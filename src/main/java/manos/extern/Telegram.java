package manos.extern;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import manos.log.Logger;

import manos.connection.database.DatabaseConfig;
import manos.log.LogLevel;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class Telegram {

    private DatabaseConfig connection;
    private String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
    private final String apiToken = "5785472072:AAG2umyIttkO1Hyyc6-k3-8ETNQr9sU3AX4";
    private List<String> chatIds;

    public Telegram() {
        this.connection = new DatabaseConfig();
        this.chatIds = new ArrayList<>();
    }

    public void sendNotification(String message) {

        for (String chatId : this.chatIds) {

            try {

                urlString = String.format("https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s", this.apiToken, chatId, message);
                URL url = new URL(urlString);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                StringBuilder sb = new StringBuilder();
                InputStream is = new BufferedInputStream(conn.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    sb.append(inputLine);
                }
                is.close();
                br.close();
                conn.disconnect();
            } catch (MalformedURLException ex) {
                ex.printStackTrace();

                Logger.log("Erro de formatação na URL", ex.getMessage(), LogLevel.ERROR);
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.log("Erro genérico  de conexão com app", message, LogLevel.ERROR);
            }

        }

    }

//    public void sendNotification()
    public void requestChatIds() {
        try {
             this.connection = new DatabaseConfig();
            List<Map<String, Object>> sql;

            sql = connection.getConnection()
                    .queryForList(String.format(
                            "SELECT telegramId"
                            + " FROM consumer"
                            + " WHERE fkCompany = %d"
                            + " AND telegramId IS NOT NULL", 1));

            if (!sql.isEmpty()) {

                for (Map<String, Object> map : sql) {
                    this.chatIds.add((String) map.get("telegramId"));
                }
            }
        } catch (CannotGetJdbcConnectionException ex) {
            ex.printStackTrace();
            Logger.log("Erro ao conectar com o banco de dados", ex.getMessage(), LogLevel.ERROR);
        } finally {
            connection.closeMySql();
            connection.closeConnection();
        }

    }

    public void show() {
        System.out.println(this.chatIds.toString());
    }
}
