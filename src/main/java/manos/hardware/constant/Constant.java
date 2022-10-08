package manos.hardware.constant;

import com.github.britooo.looca.api.core.Looca;

public class Constant {
    Long diskSize;
    String diskModel;
    String diskSpeed;
    String ramSize;
    String nome;
    Integer núcleos;

    public Constant() {
        Looca looca = new Looca();

        this.diskSize = looca.getGrupoDeDiscos().getTamanhoTotal();
        this.diskModel = diskModel;
        this.diskSpeed = diskSpeed;
        this.ramSize = String.format("%.1f", looca.getMemoria().getTotal() / Math.pow(1024, 3));
        this.nome = looca.getProcessador().getNome();
        this.núcleos = looca.getProcessador().getNumeroCpusFisicas();
        this.threads = looca.getProcessador().getNumeroCpusLogicas();
    }

    Integer threads;
}
