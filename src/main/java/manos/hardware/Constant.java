package manos.hardware;

import java.util.Locale;

import com.github.britooo.looca.api.core.Looca;
import manos.connection.database.DatabaseConfig;

public class Constant {

    private Integer idMachine;
    private DatabaseConfig connection;
    private Looca looca;
    private Utils utils;

    public Constant(Integer idMachine) {
        this.idMachine = idMachine;
        this.connection = new DatabaseConfig();
        this.looca = new Looca();
        this.utils = new Utils();
    }

    private String getDiskModel() {
        String loocaDisk = looca.getGrupoDeDiscos().getDiscos().get(0).getModelo();

        return loocaDisk.equals("unknown") ? "NÃO IDENTIFICADO"
                : loocaDisk.replace(" (Unidades de disco padrão)", "");
    }

    public void insertData() {
        try {
            String insertQuery = String.format(Locale.US,
                    "INSERT INTO constantHardware "
                    + "(cpuName, cpuCore, ramSize, diskModel, diskSize, operationalSystem, fkMachine) "
                    + "VALUES ('%s', %d, %.2f, '%s', %.2f, '%s', %d)",
                    looca.getProcessador().getNome(),
                    looca.getProcessador().getNumeroCpusFisicas(),
                    Math.ceil(utils.convertToDoubleGb(looca.getMemoria().getTotal(), 1)),
                    this.getDiskModel(),
                    utils.convertToDoubleGb(looca.getGrupoDeDiscos().getTamanhoTotal(), 2),
                    looca.getSistema().getSistemaOperacional(),
                    this.idMachine
            );

            connection.getConnection().update(insertQuery);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            connection.closeMySql();
            connection.closeConnection();
        }
    }

}
