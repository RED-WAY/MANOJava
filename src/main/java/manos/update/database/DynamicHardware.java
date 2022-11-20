/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manos.update.database;

/**
 *
 * @author pedro
 */
public class DynamicHardware {
    private Integer idDynamicHardware;
    private Double cpuUse;
    private Double ramUse;
    private Integer fkMachine;
    private String dtAdded;

    public DynamicHardware(Integer idDynamicHardware, Double cpuUse, Double ramUse, Integer fkMachine, String dtAdded) {
        this.idDynamicHardware = idDynamicHardware;
        this.cpuUse = cpuUse;
        this.ramUse = ramUse;
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

    public Double getCpuUse() {
        return cpuUse;
    }

    public void setCpuUse(Double cpuUse) {
        this.cpuUse = cpuUse;
    }

    public Double getRamUse() {
        return ramUse;
    }

    public void setRamUse(Double ramUse) {
        this.ramUse = ramUse;
    }

    public Integer getFkMachine() {
        return fkMachine;
    }

 
    
    
    

}
