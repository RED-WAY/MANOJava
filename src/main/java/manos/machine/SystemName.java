package manos.machine;

import java.net.InetAddress;
import java.net.UnknownHostException;
import manos.log.LogLevel;
import manos.log.Logger;

public class SystemName {

    public String nameSystem() {

        String SystemName = null;
        try {

            // get system name
            SystemName
                    = InetAddress.getLocalHost().getHostName();

            // SystemName stores the name of the system
        } catch (UnknownHostException E) {
            System.err.println(E.getMessage());
            E.printStackTrace();
            Logger.log("Erro ao tentar  criar o manoCode", E.getMessage(), LogLevel.ERROR);
        }
        return SystemName;
    }
}
