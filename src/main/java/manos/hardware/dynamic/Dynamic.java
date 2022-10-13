package manos.hardware.dynamic;

import com.github.britooo.looca.api.core.Looca;
import manos.connection.database.DatabaseConfig;
import manos.hardware.constant.Constant;
import manos.hardware.conversor.Conversor;

import java.time.LocalDate;

public class Dynamic {
    private Double cpuInUse;
    private String ramInUse;
    private Long totalDisk;
    private Long diskAvailable;
    private String activityTime;

    public Dynamic() {
        Looca looca = new Looca();

        this.cpuInUse = looca.getProcessador().getUso();
        this.ramInUse = Conversor.formatarBytes(looca.getMemoria().getEmUso());
        this.totalDisk = looca.getGrupoDeDiscos().getTamanhoTotal();
        this.diskAvailable = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal();
        this.activityTime = Conversor.formatarSegundosDecorridos(looca.getSistema().getTempoDeAtividade());
    }

    public static void constantData() throws InterruptedException {
        DatabaseConfig connection = new DatabaseConfig();
        Dynamic dynamic = new Dynamic();
        LocalDate localDate = LocalDate.now();

        String update = String.format("INSERT INTO dynamicHardware VALUES (null, %d, %s, %s, NAO SEI O QUE COLCAR AINDA)",
                dynamic.cpuInUse,
                dynamic.ramInUse,
                dynamic.activityTime,
                localDate
        );

        connection.getConnection().update(update);

        Thread.sleep(5000);
        constantData();
    }

//    public static void main(String[] args) throws InterruptedException {
//        Looca looca = new Looca();
//        System.out.println();
//    }

}

