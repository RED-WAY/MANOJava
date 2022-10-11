package manos.views;

import manos.views.App;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        App view = new App();
        view.setVisible(true);
        view.startupApp();
    }
}
