package manos.views;

// JAVA
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// CLASSES
import manos.views.utils.ImageManipulator;
import manos.validation.Validation;
import manos.machine.config.MachineConfig;

// STYLE
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarculaLaf;

public class Landing extends javax.swing.JFrame {

    // INITIALIZING INSTANCES...
    ImageManipulator imageMan = new ImageManipulator();
    Validation validation = new Validation();
    MachineConfig updateMachine = new MachineConfig();

    public Landing() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("man.OS");
        setBackground(new java.awt.Color(250, 250, 250));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Base"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(18, 18, 18));
        background.setMaximumSize(new java.awt.Dimension(1366, 768));
        background.setMinimumSize(new java.awt.Dimension(1366, 768));
        background.setPreferredSize(new java.awt.Dimension(1366, 768));

        logoLabel.setForeground(new java.awt.Color(0, 0, 0));
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manos.png"))); // NOI18N
        logoLabel.setLabelFor(logoLabel);
        logoLabel.setAlignmentX(0.5F);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(593, 593, 593)
                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(593, 593, 593))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(252, 252, 252))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // ------------------- USER INTERACTIONS -------------------
    Boolean themeLight = false;
    int x, y;
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Landing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel logoLabel;
    // End of variables declaration//GEN-END:variables

    // ------------------- FUNCTIONS -------------------
    public void validateToken(String token) throws SQLException {
        System.out.println("Validating token...");

        Boolean isTokenValid = validation.isManoCodeValid();

        if (isTokenValid) {
            //rodar
        } else {

        }

    }

    public void updateMachineIsUsingState(String token) {
        System.out.println("Connecting to database...");
        System.out.println("Updating 'isUsing' field from machine with token: " + token);
    }

}
