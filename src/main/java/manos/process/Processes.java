package manos.process;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;

import java.io.IOException;

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
    private List<String> manosProcesses;

    public Processes(Integer idMachine, String operationalSystem) {
        this.connection = new DatabaseConfig();
        this.utils = new Utils();
        this.looca = new Looca();

        this.operationalSystem = operationalSystem;
        this.idMachine = idMachine;
        this.manosProcesses = new ArrayList<>();
    }

    public void getManosProcesses() {
        List<Map<String, Object>> sql = this.connection.getConnection()
                .queryForList(String.format(
                        "SELECT operationName FROM operation"
                        + " JOIN companyoperations ON idOperation = fkOperation"
                        + " JOIN familyoperations ON idCompanyOperations = fkCompanyOperations"
                        + " JOIN family ON idFamily = familyoperations.fkFamily"
                        + " JOIN machine ON idFamily = machine.fkFamily "
                        + " WHERE idMachine = %d;", this.idMachine));

        System.out.println(sql.size());

        for (Map<String, Object> map : sql) {
            this.manosProcesses.add(this.utils.extractQueryList(map, "operationName"));
        }

    }

    public List<Processo> getOsProcess() {
        return looca.getGrupoDeProcessos().getProcessos();
    }

    public void matchProcesses() {

        List<Processo> osProcess = this.getOsProcess();
        List<Integer> pids = new ArrayList<>();

        for (String manosProcess : this.manosProcesses) {
            for (Processo process : osProcess) {

                String processName = process
                        .getNome()
                        .replaceAll("\\s+", "")
                        .toUpperCase();

                if (processName.contains(manosProcess)) {
                    pids.add(process.getPid());
                }

            }
        }

        this.killProcesses(pids);
    }

    public void killProcesses(List<Integer> pids) {
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

            Thread.sleep(10000);
            this.matchProcesses();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            Thread.currentThread().interrupt();
        }

    }

}
