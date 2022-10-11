package com.manos.views;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("STARTING");
        Thread.sleep(1000);
        LandingOld eita = new LandingOld();
        eita.setVisible(true);
        System.out.println("LOADED");
    }
}
