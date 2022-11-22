package manos.machine;

import com.github.britooo.looca.api.core.Looca;
import com.google.common.util.concurrent.ExecutionError;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import manos.connection.database.DatabaseConfig;
import manos.hardware.Utils;
import manos.log.LogLevel;
import manos.log.Logger;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.ResultSet;

public class Validation {

    private DatabaseConfig connection;
    private Utils utils;
    private String hd;
    private String host;
    private Machine machine;
    private Looca looca;

    public Validation() {
        this.connection = new DatabaseConfig();
        this.utils = new Utils();
        this.looca = new Looca();

        this.hd = new FindingOutSerial().serial();
        this.host = new SystemName().nameSystem();
    }

    public String getHd() {
        return this.hd;
    }

    public String getHost() {
        return this.host;
    }

    public Machine isManoCodeValid() throws SQLException {

        String manoCode = this.host + this.hd;
        List<Map<String, Object>> sql;
        Map<String, Object> m;

        try {
            sql = connection.getConnection()
                    .queryForList(String.format(
                            "SELECT idMachine, machineName, consumerName, familyName,"
                            + " FORMAT(SWITCHOFFSET(machine.dtAdded, '-03:00'), 'dd/MM/yy-HH:mm') AS dtAdded"
                            + " FROM machine"
                            + " LEFT JOIN family ON idFamily = fkFamily"
                            + " JOIN consumer ON idConsumer = fkConsumer"
                            + " WHERE manoCode = '%s'", manoCode));

            if (sql.size() == 1) {
                m = sql.get(0);
                this.machine = new Machine(
                        (Integer) m.get("idMachine"),
                        manoCode,
                        (String) m.get("machineName"),
                        (String) m.get("dtAdded"),
                        (String) m.get("consumerName"),
                        (String) m.get("familyName"),
                        looca.getSistema().getSistemaOperacional()
                );
               

                return machine;
            }
            Logger.log("Conexão encontrada com sucesso. manoCode: " + manoCode, null, LogLevel.INFO);
        } catch (CannotGetJdbcConnectionException ex ) {
            
            ex.printStackTrace();

            Logger.log("Erro ao tentar encontrar conexão prévia. ", ex.getMessage(), LogLevel.ERROR);

            if (this.machine == null) {
                sql = connection.getMySqlConnection()
                        .queryForList(String.format(
                                "SELECT idMachine, machineName"
                                + " FROM machine"
                                + " WHERE manoCode = '%s'", manoCode));

                if (sql.size() == 1) {
                    m = sql.get(0);
                    this.machine = new Machine(
                            (Integer) m.get("idMachine"),
                            manoCode,
                            (String) m.get("machineName"),
                            looca.getSistema().getSistemaOperacional()
                    );
              
                     
                }
                 System.out.println(this.machine.toString());
                return machine;
            }
        }

        return null;
    }

}
