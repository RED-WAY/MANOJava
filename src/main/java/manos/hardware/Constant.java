package manos.hardware;

import java.util.Locale;
import com.github.britooo.looca.api.core.Looca;
import manos.connection.database.DatabaseConfig;
import manos.views.exceptions.InsertDataException;

public class Constant {

    private String cpuName;
    private Integer cpuCore;
    private Double ramSize;
    private String diskModel;
    private Double diskSize;
    private String operationalSystem;

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
                    this.cpuName = looca.getProcessador().getNome(),
                    this.cpuCore = looca.getProcessador().getNumeroCpusFisicas(),
                    this.ramSize = Math.ceil(utils.ConvertToDoubleGb(looca.getMemoria().getTotal(), 1)),
                    this.diskModel = this.getDiskModel(),
                    this.diskSize =  utils.ConvertToDoubleGb(looca.getGrupoDeDiscos().getTamanhoTotal(), 2),
                    this.operationalSystem = looca.getSistema().getSistemaOperacional(),
                    this.idMachine
            );

            connection.getConnection().update(insertQuery);
        }
        catch (RuntimeException e){
            System.out.println("Erro ao inserir os dados.");
        }
    }

}
