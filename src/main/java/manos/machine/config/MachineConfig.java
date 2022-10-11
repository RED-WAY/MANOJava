/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manos.machine.config;

import java.sql.SQLException;
import java.util.List;
import manos.validation.Validation;
import manos.connection.database.DatabaseConfig;

/**
 *
 * @author pedro
 */
public class MachineConfig {

    Validation code = new Validation();
    DatabaseConfig connection = new DatabaseConfig();

    public Boolean machineConfigDb(String token) throws SQLException {
        Boolean isValid = false;
        String manoCode = this.code.getHost() + this.code.getHd();
        String update = String.format("UPDATE machine SET "
                + "manoCode = '%s', "
                + "isUsing = 'yes' "
                + "WHERE idMachine = %s;", manoCode, token);
        try {
            List machineAvailable = connection.getConnection()
                    .queryForList(String.format("SELECT * FROM machine "
                            + "WHERE idMachine = '%s' AND manoCode IS NULL;", token));

            if (machineAvailable.size() == 1) {
                connection.getConnection().update(update);
                isValid = true;
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

        return isValid;

    }
}
