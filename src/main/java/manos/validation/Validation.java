/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manos.validation;

// FindingOutSystemOperation SO = new FindingOutSystemOperation();
//  SystemName host = new SystemName(
import java.sql.ResultSet;
import java.sql.SQLException;
import manos.connection.database.DatabaseConfig;

/**
 *
 * @author pedro
 */
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

    public Boolean isTokenValid() throws SQLException {

        String validationBD = this.host + this.hd;
        Boolean isValidad = false;
        ResultSet sql = null;

        try {
            sql = connection.Connection().createStatement().executeQuery(String
                    .format("SELECT * FROM Machine "
                            + "WHERE manoCode = '%s'", validationBD));

        } catch (SQLException ex) {
            System.out.println("An error occurred in the database");
        }

        if (sql.next() == true) {
            isValidad = true;
        }

        return isValidad;
    }

}
