package manos.hardware.constant;

import com.github.britooo.looca.api.core.Looca;

public class Constant {
    Long diskSize;
    String diskModel;
    String ramSize;
    String nameProcessor;
    Integer cores;
    String systemOperational;
    Integer threads;

    public Constant() {
        Looca looca = new Looca();

        this.diskSize = looca.getGrupoDeDiscos().getTamanhoTotal();
        this.diskModel = diskModel;
        this.systemOperational = looca.getSistema().getSistemaOperacional();
        this.ramSize = String.format("%.1f", looca.getMemoria().getTotal() / Math.pow(1024, 3));
        this.nameProcessor = looca.getProcessador().getNome();
        this.cores = looca.getProcessador().getNumeroCpusFisicas();
        this.threads = looca.getProcessador().getNumeroCpusLogicas();
    }


}
