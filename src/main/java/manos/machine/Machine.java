package manos.machine;

public class Machine {

    private Integer idMachine;
    private String manoCode;
    private String machineName;
    private String dtAdded;
    private String consumerName;
    private String familyName;
    private String operationalSystem;

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

    public void setIdMachine(Integer idMachine) {
        this.idMachine = idMachine;
    }

    public String getManoCode() {
        return this.manoCode;
    }

    public void setManoCode(String manoCode) {
        this.manoCode = manoCode;
    }

    public String getMachineName() {
        return this.machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getDtAdded() {
        return this.dtAdded;
    }

    public void setDtAdded(String dtAdded) {
        this.dtAdded = dtAdded;
    }

    public String getConsumerName() {
        return this.consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getOperationalSystem() {
        return this.operationalSystem;
    }

    public void setOperationalSystem(String operationalSystem) {
        this.operationalSystem = operationalSystem;
    }

}
