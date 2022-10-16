package manos.machine.validation;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import manos.connection.database.DatabaseConfig;
import manos.hardware.Utils;

public class Validation {

    FindingOutSerial HD = new FindingOutSerial();
    SystemName HOST = new SystemName();
    DatabaseConfig connection = new DatabaseConfig();

    String hd;
    String host;

    public Validation() {
        this.hd = HD.serial();
        this.host = HOST.nameSystem();
    }

    public String getHd() {
        return hd;
    }

    public String getHost() {
        return host;
    }

    public Integer isManoCodeValid() throws SQLException {

        String validationBD = this.host + this.hd;
        List<Map<String, Object>> sql;

        sql = connection.getConnection().queryForList(String
                .format("SELECT idMachine FROM machine "
                        + "WHERE manoCode = '%s'", validationBD));

        if (sql.size() == 1) {
            Utils utils = new Utils();
            return Integer.valueOf(utils.extractIdMachine(sql));
        }

        return null;
    }

}
