package manos.views;

public class App {

    private static String mode;

    public App() {
        this.mode = "gui";
//        this.mode = "cli";
    }
    
    public static void main(String[] args) {
        View view = new View();

        try {
            Thread.sleep(1000);
            
            if(mode.equals("gui")) {
                view.setVisible(true);
            }
            view.startupApp();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

}
