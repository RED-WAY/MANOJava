package manos.hardware.dynamic;

import com.github.britooo.looca.api.core.Looca;
import java.util.Locale;
import manos.connection.database.DatabaseConfig;

public class Dynamic {

    private Double cpuUse;
    private Double ramUse;

    public Dynamic() {
        Looca looca = new Looca();

        this.cpuUse = looca.getProcessador().getUso();
        this.ramUse = Double.valueOf((looca.getMemoria().getEmUso() * 100) / looca.getMemoria().getTotal());
    }

    public void dynamicData() throws InterruptedException {
        DatabaseConfig connection = new DatabaseConfig();
        Dynamic dynamic = new Dynamic();

        String updateQuery = String.format(Locale.US, "INSERT INTO dynamicHardware (cpu, ram, fkMachine) VALUES (%.2f, %.2f, %d)",
                dynamic.cpuUse,
                dynamic.ramUse,
                10
        );

        connection.getConnection().update(updateQuery);

//        System.out.println(this.toString(dynamic.cpuUse, dynamic.ramUse));
        Thread.sleep(2000);
        this.dynamicData();
    }

    public String toString(Double cpuUse, Double ramUse) {
        String str = "--- CATCH ---\n"
                + "CPU: " + cpuUse + "%\n"
                + "RAM: " + ramUse + "%\n\n";

        return str;
    }
}
