package manos.connection.database;

import manos.log.LogLevel;
import manos.log.Logger;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseConfig {

    private JdbcTemplate connection;
    private JdbcTemplate connectionMySql;
    private BasicDataSource dataSource = new BasicDataSource();
    private BasicDataSource mySql = new BasicDataSource();

    public JdbcTemplate getMySqlConnection() {
        try {
            // MYSQL CONFIG
            mySql.setDriverClassName("com.mysql.cj.jdbc.Driver");

            mySql.setUrl("jdbc:mysql://172.17.0.2:3306/manosecurity?useTimezone=true&"
                    + "serverTimezone=UTC&"
                    + "autoReconnect=true&"
                    + "useSSL=false");
            mySql.setUsername("root");

            mySql.setPassword("urubu200");

            this.connectionMySql = new JdbcTemplate(mySql);
            return this.connectionMySql;
        } catch (NullPointerException ex) {

            // tavex tire aq, tava no Exception ex
        } catch (Exception ex) {

            //volta p cima
        }
        return this.connectionMySql;
    }

    public JdbcTemplate getConnection() {
        try {
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            dataSource.setUrl("jdbc:sqlserver://svr-manosecurity.database.windows.net:1433;"
                    + "database=db-azure-manosecurity;encryp\n"
                    + "t=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");

            dataSource.setUsername("admin-manosecurity");

            dataSource.setPassword("#Gfgrupo6");
            this.connection = new JdbcTemplate(dataSource);
            return this.connection;
        } catch (CannotGetJdbcConnectionException ex) {

            // giga
        }

        return this.connection;
    }

    public void closeConnection() {
        try {
            dataSource.close();
        } catch (Exception ex) {
        }
    }

    public void closeMySql() {
        try {
            mySql.close();
        } catch (Exception ex) {

        }

    }

}
