package manos.update.database;

import java.util.ArrayList;
import java.util.List;
import manos.connection.database.DatabaseConfig;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author pedro
 */
public class UpdateDataBase {

    DatabaseConfig connection = new DatabaseConfig();
    JdbcTemplate mySql = connection.getMySqlConnection();
    JdbcTemplate azure = connection.getConnection();

    public void needUpdate() {
        Boolean isConnected = true;

        try {

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

            }
            if (!operation.isEmpty()) {

                for (int i = 0; i < operation.size(); i++) {
                    azure.update(String.format("INSERT INTO "
                            + "operationKilled(dtAdded, fkMachine, fkOperation) "
                            + "VALUES "
                            + "('%s', %d, %d) ", operation.get(i).getDtAdded().replaceAll(" ", "T"),
                            operation.get(i).getFkMachine(), operation.get(i).getFkOperation()));
                }

            }

        } catch (Exception ex) {
            isConnected = false;
            System.out.println("fudeu");
        } finally {
            if (isConnected) {
                mySql.execute("TRUNCATE TABLE operationKilled");
                mySql.execute("TRUNCATE TABLE dynamicHardware");
                connection.closeMySql();
                connection.closeConnection();
            }

        }

    }
}
