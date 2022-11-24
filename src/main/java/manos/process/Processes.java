package manos.process;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import manos.log.Logger;

import manos.connection.database.DatabaseConfig;
import manos.extern.Telegram;
import manos.hardware.Utils;
import manos.log.LogLevel;
import manos.update.database.OperationKilled;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class Processes {

    private DatabaseConfig connection;
    private Utils utils;
    private Looca looca;

    private String operationalSystem;
    private String machineName;
    private Integer idMachine;
    private List<String> manosNames;
    private List<Integer> manosIds;

    private List<String> telegramMessages = new ArrayList<>();
    private Telegram telegram = new Telegram();

    public Processes(String machineName, Integer idMachine, String operationalSystem) {

        this.utils = new Utils();
        this.looca = new Looca();

        this.operationalSystem = operationalSystem;
        this.machineName = machineName;
        this.idMachine = idMachine;

        this.manosNames = new ArrayList<>();
        this.manosIds = new ArrayList<>();

        this.telegram.requestChatIds();
    }

    public Processes() {
    }
    
    

    public void getManosProcesses() throws InterruptedException {
        try {
            this.connection = new DatabaseConfig();
            List<Operation> azure = this.connection.getConnection()
                    .query((String.format(
                            "SELECT operationName, idOperation, operationType FROM operation"
                            + " JOIN companyoperations ON idOperation = fkOperation"
                            + " JOIN familyoperations ON idCompanyOperations = fkCompanyOperations"
                            + " JOIN family ON idFamily = familyoperations.fkFamily"
                            + " JOIN machine ON idFamily = machine.fkFamily "
                            + " WHERE idMachine = %d;", this.idMachine)),
                            new BeanPropertyRowMapper(Operation.class));

            List<Operation> mySql = this.connection.getMySqlConnection()
                    .query(String.format("SELECT * FROM operation"),
                            new BeanPropertyRowMapper(Operation.class));

            if (azure.size() != mySql.size()) {
                connection.getMySqlConnection().execute("TRUNCATE TABLE operation");
                for (int i = 0; i < azure.size(); i++) {
                    connection.getMySqlConnection().update(String.format("INSERT INTO operation"
                            + "(idOperation, operationType, operationName) VALUES"
                            + "(%d, '%s','%s')", azure.get(i).getIdOperation(),
                            azure.get(i).getOperationType(), azure.get(i).getOperationName()));

                }
                connection.closeMySql();

            }

            List<String> urls = new ArrayList<>();
           
                     
            for (int i = 0; i < mySql.size(); i++) {
            
                String name = mySql.get(i).getOperationName();
                Integer id = mySql.get(i).getIdOperation();
                String type = mySql.get(i).getOperationType();

                if (type.equals("desktop")) {
                    manosNames.add(name);
                    manosIds.add(id);
                } else{
                    urls.add(name.toLowerCase());
                }
            }
        Thread.sleep(10000);
            if (!urls.isEmpty()) {
                this.handleWebBlock(urls);
            }
        } catch (CannotGetJdbcConnectionException ex) {

            this.connection = new DatabaseConfig();
            List<String> urls = new ArrayList<>();

            List<Operation> mySql = this.connection.getMySqlConnection()
                    .query(String.format("SELECT * FROM operation"),
                            new BeanPropertyRowMapper(Operation.class));

            for (int i = 0; i < mySql.size(); i++) {
                String name = mySql.get(i).getOperationName();
                Integer id = mySql.get(i).getIdOperation();
                String type = mySql.get(i).getOperationType();

                if (type.equals("desktop")) {
                    manosNames.add(name);
                    manosIds.add(id);
                } else {
                    urls.add(name.toLowerCase());
                }
            }
Thread.sleep(10000);
            if (!urls.isEmpty()) {
                this.handleWebBlock(urls);
            }
        }catch(NullPointerException ex){
        
        } finally {
            connection.closeConnection();
            connection.closeMySql();
        }
    }

    public List<Processo> getOsProcess() {
        return looca.getGrupoDeProcessos().getProcessos();
    }

    public void matchProcesses() {
        List<Processo> osProcess = this.getOsProcess();
        List<Integer> pids = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();
        Set<String> notifyNames = new HashSet<>();

        for (int i = 0; i < manosNames.size(); i++) {
            String manosName = manosNames.get(i);

            for (Processo process : osProcess) {

                String processName = process
                        .getNome()
                        .replaceAll("\\s+", "")
                        .toUpperCase();

                if (processName.contains(manosName)
                        || processName.contentEquals(manosName)) {

                    pids.add(process.getPid());
                    ids.add(manosIds.get(i));
                    notifyNames.add(manosName);

                }

            }

        }

        try {

            if (!pids.isEmpty()) {
                String[] names = notifyNames.toArray(new String[notifyNames.size()]);
                for (String notifyName : names) {
                    String message = String.format(
                            "O processo %s foi morto na máquina '%s'",
                            notifyName, this.machineName);

                    telegramMessages.add(message);
                }

                this.killProcesses(pids, new ArrayList<>(ids));
            }

            Thread.sleep(10000);
            this.matchProcesses();
            Logger.log("Processo eliminado", null, LogLevel.PROCESSES);

        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
            ex.getStackTrace();
            Logger.log("Erro ao eliminar processo na  maquina : " + machineName, ex.getMessage(), LogLevel.ERROR);
        }
    }

    public void killProcesses(List<Integer> pids, List<Integer> ids) {
        try {

            String pidsString = "";
            Runtime rt = Runtime.getRuntime();
            if (operationalSystem.equals("Windows")) {
                for (Integer pid : pids) {
                    pidsString += String.format("/PID %d ", pid);
                }
                rt.exec("taskkill /F " + pidsString + "/T");
            } else {
                for (Integer pid : pids) {
                    pidsString += String.format("%d ", pid);
                }
                rt.exec("kill -9 " + pidsString);
            }

            this.insertData(ids);

        } catch (IOException ex) {
            ex.printStackTrace();
            ex.getStackTrace();
            Logger.log("Erro ao  matar processo", ex.getMessage(), LogLevel.ERROR);
        }

    }

    public void insertData(List<Integer> ids) {
        String strValues = "";
        Boolean isLogged = true;

        System.out.println("IDS: " + ids.size());

        for (int i = 0; i < ids.size(); i++) {
            Integer id = ids.get(i);
            strValues += String.format("(%d, %d)", this.idMachine, id);
            strValues += i == ids.size() - 1 ? ";" : ",";
        }

        String insertQuery = "INSERT INTO "
                + "operationKilled (fkMachine, fkOperation) "
                + "VALUES " + strValues;

        try {
            this.connection = new DatabaseConfig();
            connection.getConnection().update(insertQuery);

        } catch (Exception ex) {

            isLogged = false;

            connection.getMySqlConnection().update(insertQuery);

        } finally {
            if (isLogged) {
                for (String message : telegramMessages) {
                    this.telegram.sendNotification(message);
                }
            }

            connection.closeMySql();
            connection.closeConnection();
        }
    }

    public void handleWebBlock(List<String> urls) {

        String commandUpdate = "# " + "-".repeat(50)
                + "\n# REDWAY - man.OS\n";

        for (String url : urls) {
            commandUpdate += String.format("\n# "
                    + "-".repeat(10) + " %1$s " + "-".repeat(10)
                    + "\n127.0.0.1\t%2$s.com"
                    + "\n127.0.0.1\twww.%2$s.com"
                    + "\n127.0.1.1\t%2$s.com"
                    + "\n127.0.1.1\twww.%2$s.com"
                    + "\n", url.toUpperCase(), url);
        }

        File hostsFile = new File("/etc/hosts");

        try {
            if (this.operationalSystem.equals("Windows")) {
                hostsFile = new File("C://Windows/System32/drivers/etc/hosts");
            }

            PrintWriter pw = new PrintWriter(hostsFile);
            pw.println(commandUpdate);
            pw.close();

        } catch (IOException ex) {
            ex.printStackTrace();

            Logger.log("Erro ao modificar o diretorio Hosts", ex.getMessage(), LogLevel.ERROR);
        }
    }

}
