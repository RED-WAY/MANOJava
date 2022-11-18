package manos.hardware;

import com.github.britooo.looca.api.core.Looca;
import java.sql.SQLException;
import java.util.Locale;
import manos.connection.database.DatabaseConfig;
import org.springframework.dao.DataAccessException;

public class Dynamic {

    private Double cpuUse;
    private Double ramUse;

    private Integer idMachine;

    private Looca looca;
    private DatabaseConfig connection;

    public Dynamic(Integer idMachine) {
        this.idMachine = idMachine;
        this.looca = new Looca();
        this.connection = new DatabaseConfig();
    }

    public void getData() {
        this.cpuUse = looca.getProcessador().getUso();
        this.ramUse = Double.valueOf((looca.getMemoria().getEmUso() * 100) / looca.getMemoria().getTotal());
    }

    public void insertData() {
        try {

            this.getData();

            String updateQuery = String.format(Locale.US,
                    "INSERT INTO dynamicHardware (cpu, ram, fkMachine) "
                    + "VALUES (%.2f, %.2f, %d)",
                    this.cpuUse,
                    this.ramUse,
                    this.idMachine
            );

            connection.getConnection().update(updateQuery);
            System.out.println(this.toString());

            Thread.sleep(5000);
            this.insertData();

        } catch (InterruptedException ex) {
            this.getData();

            String updateQuery = String.format(Locale.US,
                    "INSERT INTO dynamicHardware (cpu, ram, fkMachine) "
                    + "VALUES (%.2f, %.2f, %d)",
                    this.cpuUse,
                    this.ramUse,
                    this.idMachine
            );

            connection.getMySqlConnection().update(updateQuery);
            System.out.println(this.toString());

         
            this.insertData();
        } catch (DataAccessException ex) {

            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return "--- CATCH ---\n"
                + "CPU: " + this.cpuUse.intValue() + "%\n"
                + "RAM: " + this.ramUse.intValue() + "%\n\n";
    }
}
