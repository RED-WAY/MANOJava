package manos.views;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {
        View view = new View();

        try {
            Files.createDirectories(Paths.get("C:\\Program Files\\REDWAY"));
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("foi");
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
