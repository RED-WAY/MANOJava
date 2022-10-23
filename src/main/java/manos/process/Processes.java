package manos.process;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import manos.connection.database.DatabaseConfig;
import manos.hardware.Utils;

public class Processes {

    private DatabaseConfig connection;
    private Utils utils;
    private Looca looca;

    private String operationalSystem;
    private Integer idMachine;
    private List<String> manosNames;
    private List<Integer> manosIds;

    public Processes(Integer idMachine, String operationalSystem) {
        this.connection = new DatabaseConfig();
        this.utils = new Utils();
        this.looca = new Looca();

        this.operationalSystem = operationalSystem;
        this.idMachine = idMachine;

        this.manosNames = new ArrayList<>();
        this.manosIds = new ArrayList<>();
    }

    public void getManosProcesses() {
        List<Map<String, Object>> sql = this.connection.getConnection()
                .queryForList(String.format(
                        "SELECT operationName, idOperation, operationType FROM operation"
                        + " JOIN companyoperations ON idOperation = fkOperation"
                        + " JOIN familyoperations ON idCompanyOperations = fkCompanyOperations"
                        + " JOIN family ON idFamily = familyoperations.fkFamily"
                        + " JOIN machine ON idFamily = machine.fkFamily "
                        + " WHERE idMachine = %d;", this.idMachine));

        List<String> urls = new ArrayList<>();

        for (Map<String, Object> map : sql) {
            String name = map.entrySet().toArray()[0].toString().replace("operationName=", "");
            Integer id = Integer.valueOf(map.entrySet().toArray()[1].toString().replace("idOperation=", ""));
            String type = map.entrySet().toArray()[2].toString().replace("operationType=", "");

            if (type.equals("desktop")) {
                manosNames.add(name);
                manosIds.add(id);
            } else {
                urls.add(name.toLowerCase());
            }
        }

        if (!urls.isEmpty()) {
            this.handleWebBlock(urls);
        }
    }

    public List<Processo> getOsProcess() {
        return looca.getGrupoDeProcessos().getProcessos();
    }

    public void matchProcesses() {
        List<Processo> osProcess = this.getOsProcess();
        List<Integer> pids = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();

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
                }

            }

        }

        try {

            if (!pids.isEmpty()) {
                this.killProcesses(pids, ids);
            }

            Thread.sleep(10000);
            this.matchProcesses();

        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
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
        }

    }

    public void insertData(List<Integer> ids) {
        String strValues = "";
        for (int i = 0; i < ids.size(); i++) {
            Integer id = ids.get(i);
            strValues += String.format("(%d, %d)", this.idMachine, id);
            strValues += i == ids.size() - 1 ? ";" : ",";
        }

        String insertQuery = "INSERT INTO "
                + "operationKilled (fkMachine, fkOperation) "
                + "VALUES " + strValues;

        connection.getConnection().update(insertQuery);
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
        }
    }

}
