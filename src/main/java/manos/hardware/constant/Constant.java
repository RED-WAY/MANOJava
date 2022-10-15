package manos.hardware.constant;

import java.util.Locale;
import com.github.britooo.looca.api.core.Looca;
import manos.connection.database.DatabaseConfig;
import manos.machine.utils.Utils;

public class Constant {

    private String cpuName;
    private Integer cpuCore;
    private Double ramSize;
    private String diskModel;
    private Double diskSize;
    private String operationalSystem;

    public Constant() {
        Looca looca = new Looca();
        Utils utils = new Utils();

        this.cpuName = looca.getProcessador().getNome();
        this.cpuCore = looca.getProcessador().getNumeroCpusFisicas();
        this.ramSize = Math.ceil(utils.ConvertToDoubleGb(looca.getMemoria().getTotal(), 1));
        this.diskModel = looca.getGrupoDeDiscos().getDiscos().get(0).getModelo();
        this.diskSize = utils.ConvertToDoubleGb(looca.getGrupoDeDiscos().getTamanhoTotal(), 2);
        this.operationalSystem = looca.getSistema().getSistemaOperacional();
    }

    public void constantData(Integer idMachine) {
        DatabaseConfig connection = new DatabaseConfig();
        Constant constant = new Constant();

        String insertQuery = String.format(Locale.US, 
                "INSERT INTO constantHardware "
                + "(cpuName, cpuCore, ramSize, diskModel, diskSize, operationalSystem, fkMachine) "
                + "VALUES ('%s', %d, %.2f, '%s', %.2f, '%s', %d)",
                constant.cpuName,
                constant.cpuCore,
                constant.ramSize,
                constant.diskModel,
                constant.diskSize,
                constant.operationalSystem,
                idMachine
        );

        connection.getConnection().update(insertQuery);

    }
}
