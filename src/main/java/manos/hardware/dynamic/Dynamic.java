package manos.hardware.dynamic;

import com.github.britooo.looca.api.core.Looca;
import manos.hardware.conversor.Conversor;

public class Dynamic {
    Double cpuInUse;
    String ramInUse;
    Long totalDisk;
    Long diskAvailable;
    String activityTime;

    public Dynamic() {
        Looca looca = new Looca();

        this.cpuInUse = looca.getProcessador().getUso();
        this.ramInUse = Conversor.formatarBytes(looca.getMemoria().getEmUso());
        this.totalDisk = looca.getGrupoDeDiscos().getTamanhoTotal();
        this.diskAvailable = diskAvailable;
        this.activityTime = Conversor.formatarSegundosDecorridos(looca.getSistema().getTempoDeAtividade());
    }

    public static void main(String[] args) throws InterruptedException {
        Looca looca = new Looca();
        System.out.println();
    }

}
