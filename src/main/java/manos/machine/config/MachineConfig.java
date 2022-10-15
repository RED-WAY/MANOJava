package manos.machine.config;

import java.sql.SQLException;
import java.util.List;
import manos.validation.Validation;
import manos.connection.database.DatabaseConfig;
import manos.hardware.constant.Constant;

public class MachineConfig {

    Validation code = new Validation();
    DatabaseConfig connection = new DatabaseConfig();

    public Boolean machineConfigDb(String token) throws SQLException {
        Boolean isValid = false;
        String manoCode = this.code.getHost() + this.code.getHd();

        try {
            // check if exists and if it's available
            List machineAvailable = connection.getConnection()
                    .queryForList(String.format(
                            "SELECT * FROM machine "
                            + "WHERE idMachine = '%s' AND manoCode IS NULL;", token));

            if (machineAvailable.size() == 1) {
                // link local to remote
                connection.getConnection()
                        .update(String.format(
                                "UPDATE machine SET "
                                + "manoCode = '%s', "
                                + "isUsing = 'yes' "
                                + "WHERE idMachine = %s;", manoCode, token));

                Constant constant = new Constant();
                constant.constantData(Integer.valueOf(token));

                isValid = true;
            }
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }

        return isValid;

    }
}
