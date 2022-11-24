package manos.update.database;

import java.util.ArrayList;
import java.util.List;
import manos.connection.database.DatabaseConfig;
import manos.process.Processes;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author pedro
 */
public class UpdateDataBase {

    DatabaseConfig connection;
    JdbcTemplate mySql;
    JdbcTemplate azure;
    Processes processes;

    public void needUpdate() {
        Boolean isConnected = true;

        try {
            connection = new DatabaseConfig();
            mySql = connection.getMySqlConnection();
            azure = connection.getConnection();
            List<DynamicHardware> hardware
                    = mySql.query("SELECT * FROM dynamicHardware; ",
                            new BeanPropertyRowMapper(DynamicHardware.class));

            List<OperationKilled> operation
                    = mySql.query("SELECT * FROM operationKilled; ",
                            new BeanPropertyRowMapper(OperationKilled.class));

            if (!hardware.isEmpty()) {

                for (int i = 0; i < hardware.size(); i++) {

                    azure.update(String.format("INSERT INTO dynamicHardware"
                            + "(cpu, ram, dtAdded, fkMachine) VALUES "
                            + " (%.0f, %.0f, '%s', %d) ", hardware.get(i).getCpu(),
                            hardware.get(i).getRam(), hardware.get(i).getDtAdded().replaceAll(" ", "T"),
                            hardware.get(i).getFkMachine()));

                }
                mySql.execute("TRUNCATE TABLE dynamicHardware");
            }
            if (!operation.isEmpty()) {

                for (int i = 0; i < operation.size(); i++) {
                    azure.update(String.format("INSERT INTO "
                            + "operationKilled(dtAdded, fkMachine, fkOperation) "
                            + "VALUES "
                            + "('%s', %d, %d) ", operation.get(i).getDtAdded().replaceAll(" ", "T"),
                            operation.get(i).getFkMachine(), operation.get(i).getFkOperation()));
                }
                mySql.execute("TRUNCATE TABLE operationKilled");
            }

            Thread.sleep((hardware.size() + operation.size()) * 1000);

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } finally {
            

                connection.closeMySql();
                connection.closeConnection();
            

        }

    }
}
