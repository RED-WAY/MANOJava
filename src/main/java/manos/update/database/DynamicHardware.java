package manos.update.database;

/**
 *
 * @author pedro
 */
public class DynamicHardware {

    private Integer idDynamicHardware;
    private Double cpu;
    private Double ram;
    private Integer fkMachine;
    private String dtAdded;

    public DynamicHardware(Integer idDynamicHardware, Double cpu, Double ram, Integer fkMachine, String dtAdded) {
        this.idDynamicHardware = idDynamicHardware;
        this.cpu = cpu;
        this.ram = ram;
        this.fkMachine = fkMachine;
        this.dtAdded = dtAdded;
    }

    public Integer getIdDynamicHardware() {
        return idDynamicHardware;
    }

    public String getDtAdded() {
        return dtAdded;
    }

    public void setDtAdded(String dtAdded) {
        this.dtAdded = dtAdded;
    }

    public void setIdDynamicHardware(Integer idDynamicHardware) {
        this.idDynamicHardware = idDynamicHardware;
    }

    public Double getCpu() {
        return cpu;
    }

    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }

    public Double getRam() {
        return ram;
    }

    public void setRamUse(Double ram) {
        this.ram = ram;
    }

    public Integer getFkMachine() {
        return fkMachine;
    }

}
