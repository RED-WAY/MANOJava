package manos.app;

import manos.cli.View;

public class App {

    public static void main(String[] args) {
        View view = new View();

        view.setVisible(true);
        view.startupApp();
    }
}
