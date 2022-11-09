package manos.log;

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
        String logMessage = new StringBuilder()
                .append(DateTimeFormatter
                        .ofPattern("uuuuMMdd-HH:mm:ss")
                        .format(LocalDateTime.now()))
                .append(" - ")
                .append(level.toString())
                .append(": ")
                .append(title)
                .append("\n")
                .append("\t\t\t\t")
                .append("CAUSE: ")
                .append(message)
                .append("\n")
                .toString();

        try {
            Files.createDirectories(Paths.get("C:\\Program Files\\REDWAY"));
            Files.createDirectories(Paths.get("C:\\Program Files\\REDWAY\\" + LogLevel.ERROR.toString()));
            Files.createDirectories(Paths.get("C:\\Program Files\\REDWAY\\" + LogLevel.HARDWARE.toString()));
            Files.createDirectories(Paths.get("C:\\Program Files\\REDWAY\\" + LogLevel.PROCESSES.toString()));
            Files.createDirectories(Paths.get("C:\\Program Files\\REDWAY\\" + LogLevel.INFO.toString()));
            
            System.out.println("Foi");

            //REFERENCIA O ARQUIVO DESTINO DO LOG
            StringBuilder sb = new StringBuilder("C:\\Program Files\\REDWAY\\").append(level.toString());
            Path logFile = Paths.get(sb.append("\\log.txt").toString());

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