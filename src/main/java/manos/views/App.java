package manos.views;

import manos.hardware.constant.Constant;
import manos.hardware.dynamic.Dynamic;

public class App {

    public static void main(String[] args) throws InterruptedException {
        View view = new View();
        view.setVisible(true);
        view.startupApp();
        
        Constant constant = new Constant();
        constant.constantData();

        Dynamic dynamic = new Dynamic();
        dynamic.dynamicData();
    }
}
