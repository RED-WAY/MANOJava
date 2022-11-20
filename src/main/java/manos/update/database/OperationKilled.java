/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manos.update.database;

/**
 *
 * @author pedro
 */
public class OperationKilled {
    private Integer idOperationRunning;        
    private String dtAdded;
    private Integer fkMachine;
    private Integer fkOperation;

    public Integer getIdOperationRunning() {
        return idOperationRunning;
    }

  
    
    

  

    public void setIdOperationRunning(Integer idOperationRunning) {
        this.idOperationRunning = idOperationRunning;
    }

    public String getDtAdded() {
        return dtAdded;
    }

    public void setDtAdded(String dtAdded) {
        this.dtAdded = dtAdded;
    }

    public Integer getFkMachine() {
        return fkMachine;
    }

    public void setFkMachine(Integer fkMachine) {
        this.fkMachine = fkMachine;
    }

    public Integer getFkOperation() {
        return fkOperation;
    }

    public void setFkOperation(Integer fkOperation) {
        this.fkOperation = fkOperation;
    }

    @Override
    public String toString() {
        return "OperationKilled{" + "idOperationRunning=" + idOperationRunning + ", dtAdded=" + dtAdded + ", fkMachine=" + fkMachine + ", fkOperation=" + fkOperation + '}';
    }
    
    
    

}
