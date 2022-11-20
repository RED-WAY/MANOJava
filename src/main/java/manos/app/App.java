package manos.app;

// CHANGE IMPORT TO BUILD PREFERRED VERSION
import manos.cli.View;

import manos.log.LogLevel;
import manos.log.Logger;

public class App {

    public static void main(String[] args) {
        View view = new View();

        
        try {
            Thread.sleep(1000);
            view.setVisible(true);
            view.startupApp();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Logger.log("Erro ao inicializar o aplicativo", ex.getMessage(), LogLevel.ERROR);
        }

    }

}
