package manos.machine.config;

import java.sql.SQLException;
import java.util.List;
import manos.machine.validation.Validation;
import manos.connection.database.DatabaseConfig;
import org.springframework.dao.DataAccessException;

public class MachineConfig {

    private Validation validation;
    private DatabaseConfig connection;
    private String manoCode;

    public MachineConfig() {
        this.validation = new Validation();
        this.connection = new DatabaseConfig();
        this.manoCode = this.validation.getHost() + this.validation.getHd();
    }

    public Boolean checkMachineAvailability(String token) {
        List machineAvailable = connection.getConnection()
                .queryForList(String.format(
                        "SELECT * FROM machine "
                        + "WHERE idMachine = '%s' "
                        + "AND manoCode IS NULL;", token));

        return machineAvailable.size() == 1;
    }

    public Boolean linkMachine(String token) throws SQLException {

        if (checkMachineAvailability(token)) {
            connection.getConnection()
                    .update(String.format(
                            "UPDATE machine SET "
                            + "manoCode = '%s', "
                            + "isUsing = 'yes' "
                            + "WHERE idMachine = %s;", this.manoCode, token));
            return true;
        }

        return false;

    }
}
