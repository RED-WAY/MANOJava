/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manos.validation;

// FindingOutSystemOperation SO = new FindingOutSystemOperation();
//  SystemName host = new SystemName(
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

    private String hd;
    private String host;

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
    
    

    public Boolean isTokenValid() {

        String validationBD = this.host + this.hd;
         Boolean validacao = false;
         System.out.println(validationBD);
        try {
            Boolean validar = connection.Connection().createStatement().execute(String
                    .format("SELECT * FROM Machine"
                            + "WHERE manosCode = '%s'", validationBD));
            if(validar){
             validacao = true;
            }

        } catch (SQLException ex) {
           
        }
    return validacao;
    }

}
