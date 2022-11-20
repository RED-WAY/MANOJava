package manos.machine;

import java.sql.SQLException;
import java.util.List;
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

    public String getName(String token) {
        return (String) connection.getConnection()
                .queryForList(String.format(
                        "SELECT machineName "
                        + " FROM machine"
                        + " WHERE idMachine = '%s'", token)).get(0).get("machineName");
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

            String name = this.getName(token);
            
            connection.getMySqlConnection().update(String.format("INSERT INTO machine (idMachine, manoCode, machineName) VALUES (%d, '%s', '%s')",
                    Integer.valueOf(token), this.manoCode, name));
            return true;
        }

        return false;

    }
}
