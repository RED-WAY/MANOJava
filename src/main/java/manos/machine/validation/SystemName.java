package manos.machine.validation;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
        }
        return SystemName;
    }
}
