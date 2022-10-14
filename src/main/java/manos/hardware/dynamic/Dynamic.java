package manos.hardware.dynamic;

import com.github.britooo.looca.api.core.Looca;
import manos.connection.database.DatabaseConfig;
import manos.hardware.conversor.Conversor;

import java.time.LocalDate;

public class Dynamic {

    private Double cpuUse;
    private Long ramUse;
    private String activityTime;

    public Dynamic() {
        Looca looca = new Looca();

        this.cpuUse = looca.getProcessador().getUso();
        this.ramUse = (looca.getMemoria().getEmUso() * 100) / looca.getMemoria().getTotal();
    }

    public void dynamicData() throws InterruptedException {
        DatabaseConfig connection = new DatabaseConfig();
        Dynamic dynamic = new Dynamic();

        String updateQuery = String.format("INSERT INTO dynamicHardware (cpu, ram, fkMachine) VALUES (%d, %s, %d)",
                dynamic.cpuUse,
                dynamic.ramUse,
                10
        );

        connection.getConnection().update(updateQuery);

        Thread.sleep(5000);
        this.dynamicData();
    }
}
