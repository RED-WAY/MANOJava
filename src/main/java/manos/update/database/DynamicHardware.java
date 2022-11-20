package manos.update.database;

/**
 *
 * @author pedro
 */
public class DynamicHardware {

    private Integer idDynamicHardware;
    private Double cpu;
    private Double ram;
    private String dtAdded;
    private Integer fkMachine;


    

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

    public void setRam(Double ram) {
        this.ram = ram;
    }

    public void setFkMachine(Integer fkMachine) {
        this.fkMachine = fkMachine;
    }

    public Integer getFkMachine() {
        return fkMachine;
    }

    @Override
    public String toString() {
        return "DynamicHardware{" + "idDynamicHardware=" + idDynamicHardware + "\n cpu=" 
                + cpu + "\n ram=" + ram + 
                " fkMachine=" + fkMachine + 
                "\n dtAdded=" + dtAdded + '}';
    }

}
