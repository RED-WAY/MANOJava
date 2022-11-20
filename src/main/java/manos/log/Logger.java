package manos.log;

import com.github.britooo.looca.api.core.Looca;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Logger {

    public static void log(String title, String message, LogLevel level) {

        //GERA A MENSAGEM DE LOG
        // DATA-HORA - LEVEL - MENSAGEM - SO - IP - VERSAO_APP
        StringBuilder sbLog = new StringBuilder()
                .append(DateTimeFormatter
                        .ofPattern("uuuuMMdd-HH:mm:ss")
                        .format(LocalDateTime.now()))
                .append(" - ")
                .append(level.toString())
                .append(": ")
                .append(title)
                .append("\n");
        if (message != null) {
            sbLog
                    .append("\t\t\t\t")
                    .append("CAUSE: ")
                    .append(message)
                    .append("\n");
        }

        String logMessage = sbLog.toString();

        try {

            String os = new Looca()
                    .getSistema()
                    .getSistemaOperacional()
                    .toLowerCase();

            String path = os.equals("windows")
                    ? "C:\\Program Files\\REDWAY\\LOGS\\"
                    : "/home/ubuntu/REDWAY/LOGS/";

            String preFile = os.equals("windows") ? "\\" : "/";

            Files.createDirectories(Paths.get(path));
            Files.createDirectories(Paths.get(path + LogLevel.ERROR.toString()));
            Files.createDirectories(Paths.get(path + LogLevel.HARDWARE.toString()));
            Files.createDirectories(Paths.get(path + LogLevel.PROCESSES.toString()));
            Files.createDirectories(Paths.get(path + LogLevel.INFO.toString()));

            //REFERENCIA O ARQUIVO DESTINO DO LOG
            StringBuilder sb = new StringBuilder(path).append(level.toString());
            Path logFile = Paths.get(sb.append(preFile).append("log.txt").toString());

            //VERIFICA SE O ARQUIVO NAO EXISTE (ARQUIVO ONDE FICARA OS LOGS)
            if (!logFile.toFile().exists()) {
                logFile.toFile().createNewFile(); // CRIA O ARQUIVO DE LOG CASO ELE NÃO EXISTA
            }

            Files.write(logFile, Arrays.asList(logMessage), StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
