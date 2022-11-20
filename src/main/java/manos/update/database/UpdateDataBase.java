/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

        try {

            List<DynamicHardware> hardware
                    = mySql.query("SELECT * FROM dynamicHardware ",
                            new BeanPropertyRowMapper(DynamicHardware.class));

            List<OperationKilled> operation
                    = mySql.query("SELECT * FROM operationKelled ",
                            new BeanPropertyRowMapper(OperationKilled.class));

            if (!hardware.isEmpty()) {

                for (int i = 0; i < hardware.size(); i++) {
                    azure.update(String.format("INSERT INTO dynamicHardware"
                            + "(cpu, ram, dtAdded, fkMachine) VALUES "
                            + "(%.2f, %.2f, %s, %d ) ", hardware.get(i).getCpuUse(),
                            hardware.get(i).getRamUse(), hardware.get(i).getDtAdded(),
                            hardware.get(i).getFkMachine()));

                }
                mySql.execute("TRUNCATE TABLE dynamicHardware");

            }
            if (!operation.isEmpty()) {
                for (int i = 0; i < operation.size(); i++) {
                    azure.update(String.format("INSERT INTO "
                            + "operationKilled(dtAdded, fkMachine, fkOperation) "
                            + "VALUES "
                            + "(%s, %d, %d,) ", operation.get(i).getDtAdded(),
                            operation.get(i).getFkMachine(), operation.get(i).getFkOperation()));
                }
                mySql.execute("TRUNCATE TABLE operaionKilled");
            }

        } catch (Exception ex) {
         // AQ GIGA
        }

    }
}
