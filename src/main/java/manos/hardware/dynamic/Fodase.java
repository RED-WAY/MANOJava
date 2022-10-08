package manos.hardware.dynamic;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;

import java.util.List;

public class Fodase {
    public void printaOsCrias(List<Processo> processos) throws InterruptedException {
        System.out.println(0);
        Thread.sleep(2000);
        Looca looca = new Looca();
        System.out.println(looca.getGrupoDeProcessos().getProcessos());
    }

    public void tomatomatoma(){
        Looca looca = new Looca();
        Double toma = looca.getProcessador().getUso();
        System.out.println(toma);
    }
}
