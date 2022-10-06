/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manos.validation;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author pedro
 */
public class SystemName {
    public String nameSystem(){
          
      String SystemName = null;
        try  {

            // get system name
             SystemName
                    = InetAddress.getLocalHost().getHostName();
           

            // SystemName stores the name of the system
        } catch (UnknownHostException E) {
            System.err.println(E.getMessage());
        }
        return SystemName;
    }
}
