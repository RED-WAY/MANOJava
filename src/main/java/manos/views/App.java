package manos.views;

import com.github.britooo.looca.api.core.Looca;

public class App {

    public static void main(String[] args) {
        Looca looca = new Looca();        
        System.out.println(looca.getGrupoDeDiscos().getDiscos());
        System.out.println(looca.getGrupoDeDiscos().getVolumes());

//        View view = new View();
//
//        try {
//            Thread.sleep(1000);
//            view.setVisible(true);
//            view.startupApp();
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }

    }
}
