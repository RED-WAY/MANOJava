/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manos.machine.config;
import java.sql.SQLException;
import manos.validation.Validation;
import manos.connection.database.DatabaseConfig;
/**
 *
 * @author pedro
 */
public class MachineConfig {
     Validation code = new Validation();
     DatabaseConfig connection = new DatabaseConfig();
    public Boolean machineConfigDb(String token) throws SQLException{
        Boolean valid = false;
        String codeManos = this.code.getHost() + this.code.getHd();
        
        String update = String.format("UPDATE Manchine SET"
                + "manosCode = '%s' WHERE token = '%s'", codeManos, token);
        
        
          valid = connection.Connection().createStatement().
                  execute(update);
        
        
        
         return valid;
           
    }
}