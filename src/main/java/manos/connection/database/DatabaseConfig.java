/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manos.connection.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author pedro
 */
public class DatabaseConfig {

     public Connection Connection () {
      Connection sqlConnection;
        try {
             // start connection
            Class.forName("com.mysql.cj.jdbc.Driver");
           
         sqlConnection = DriverManager.getConnection("jdbc:mysql://localhost/"
                    // Database name 
                    + "MANOSecurity",
                    // user name  
                    "aluno",
                    // passsword  
                    "sptech");
         
               
               return sqlConnection;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error to found class");
        } catch (SQLException ex) {
            System.out.println("Error to connect to database, erro :" + ex.getMessage());
        }
         return null;
    }

}