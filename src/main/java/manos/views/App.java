package manos.views;

import manos.process.Processes;

public class App {

    public static void main(String[] args) {
        View view = new View();

        try {
            Thread.sleep(1000);
            view.setVisible(true);
            view.startupApp();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

//            Processes proc = new Processes(1);
//            proc.getManosProcess();
    }

}
