package manos.views;

import com.github.britooo.looca.api.core.Looca;

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
    }
}
