package manos.machine;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import manos.connection.database.DatabaseConfig;
import manos.hardware.Utils;

public class Validation {

    private DatabaseConfig connection;
    Utils utils;

    private FindingOutSerial HD;
    private SystemName HOST;
    private String hd;
    private String host;
    private Integer idMachine;

    public Validation() {
        this.connection = new DatabaseConfig();
        this.utils = new Utils();

        this.HD = new FindingOutSerial();
        this.HOST = new SystemName();

        this.hd = HD.serial();
        this.host = HOST.nameSystem();
    }

    public String getHd() {
        return this.hd;
    }

    public String getHost() {
        return this.host;
    }

    public void setIdMachine(Integer idMachine) {
        this.idMachine = idMachine;
    }

    public Integer isManoCodeValid() throws SQLException {

        String validationBD = this.host + this.hd;
        List<Map<String, Object>> sql;

        sql = connection.getConnection()
                .queryForList(String.format(
                        "SELECT idMachine FROM machine "
                        + "WHERE manoCode = '%s'", validationBD));

        if (sql.size() == 1) {
            this.idMachine = Integer.valueOf(utils.extractQueryList(sql, "idMachine"));

            return idMachine;
        }

        return null;
    }

}
