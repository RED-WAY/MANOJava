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
        Boolean valid = false;
        String manoCode = this.code.getHost() + this.code.getHd();
        List returnBd = null;
        System.out.println(manoCode);
        String update = String.format("UPDATE Machine SET "
                + "manoCode = '%s', "
                + "isUsing = 'yes' "
                + "WHERE idMachine = %s;", manoCode, token);
        try {
            connection.getConnection().update(update);
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

        try {
            returnBd = connection.getConnection().queryForList(String
                    .format("SELECT * FROM Machine "
                            + "WHERE manoCode = '%s'", manoCode));
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

        if (returnBd.size() == 1) {
            valid = true;
        }

        return valid;

    }
}
