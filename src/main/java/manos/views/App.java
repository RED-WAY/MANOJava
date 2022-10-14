package manos.views;

import com.github.britooo.looca.api.core.Looca;
import manos.hardware.constant.Constant;

public class App {

    public static void main(String[] args) throws InterruptedException {
//        View view = new View();
//        view.setVisible(true);
//        view.startupApp();
//        
//        Constant constant = new Constant();       
//        constant.constantData();
        
        Looca looca = new Looca();
        System.out.println((looca.getMemoria().getEmUso() * 100) / looca.getMemoria().getTotal());
    }
}
