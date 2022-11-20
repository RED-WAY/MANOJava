package manos.machine;

import com.github.britooo.looca.api.core.Looca;

public class Machine {

    private Integer idMachine;
    private String manoCode;
    private String machineName;
    private String dtAdded;
    private String consumerName;
    private String familyName;
    private String operationalSystem;

    public Machine(
            Integer idMachine, String manoCode, String machineName, String operationalSystem) {
        this.idMachine = idMachine;
        this.manoCode = manoCode;
        this.machineName = machineName.trim();
        this.operationalSystem = operationalSystem;
    }

    public Machine(
            Integer idMachine,
            String manoCode,
            String machineName,
            String dtAdded,
            String consumerName,
            String familyName,
            String operationalSystem) {
        this.idMachine = idMachine;
        this.manoCode = manoCode;
        this.machineName = machineName.trim();
        this.dtAdded = dtAdded;
        this.consumerName = consumerName;
        this.familyName = familyName;
        this.operationalSystem = operationalSystem;
    }

    public Integer getIdMachine() {
        return this.idMachine;
    }

    public String getMachineName() {
        return this.machineName;
    }

    public String getConsumerName() {
        return this.consumerName;
    }

    public String getOperationalSystem() {
        return this.operationalSystem;
    }

}
