package manos.hardware.constant;

import com.github.britooo.looca.api.core.Looca;
import manos.connection.database.DatabaseConfig;
import manos.hardware.conversor.Conversor;

public class Constant {
    private Long diskSize;
    private String diskModel;
    private String ramSize;
    private String cpuName;
    private Integer cpuCore;
    private String operationalSystem;

    public Constant() {
        Looca looca = new Looca();

        this.diskSize = looca.getGrupoDeDiscos().getTamanhoTotal();
        this.diskModel = looca.getGrupoDeDiscos().getDiscos().get(0).getNome();
        this.operationalSystem = looca.getSistema().getSistemaOperacional();
        this.ramSize = Conversor.formatarBytes(looca.getMemoria().getTotal());
        this.cpuName = looca.getProcessador().getNome();
        this.cpuCore = looca.getProcessador().getNumeroCpusFisicas();
    }

    public static void constantData() {
        DatabaseConfig connection = new DatabaseConfig();
        Constant constant = new Constant();

        String update = String.format("INSERT INTO constantHardware VALUES (null, %s, %d, %s, %s, %l, %s, null)",
                constant.cpuName,
                constant.cpuCore,
                constant.ramSize,
                constant.diskModel,
                constant.diskSize,
                constant.operationalSystem
        );

        connection.getConnection().update(update);

    }
}
