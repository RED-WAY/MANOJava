package manos.views;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

//import com.github.britooo.looca.api.core.Looca;
import manos.views.utils.ImageManipulator;
import manos.validation.Validation;
import manos.machine.config.MachineConfig;

public class Landing extends javax.swing.JFrame {

    // INITIALIZING INSTANCES...
    ImageManipulator imageMan = new ImageManipulator(2);
    Validation validation = new Validation();
    MachineConfig updateMachine = new MachineConfig();

    public Landing() {
        initComponents();
        initImages();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        iptToken = new javax.swing.JTextField();
        btnToken = new javax.swing.JToggleButton();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(32, 32, 32));

        btnToken.setText("ENVIAR");
        btnToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTokenActionPerformed(evt);
            }
        });

        lblImage.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap(400, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iptToken, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(400, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(562, 562, 562)
                .addComponent(btnToken)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(iptToken, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnToken, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // INTERACTIONS METHODS
    private void btnTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTokenActionPerformed
        // get token input text
        Boolean ready = null;
        String token = iptToken.getText();

        try {
            // validate at DATABASE if there is a machine with the typed token
            ready = updateMachine.machineConfigDb(token);
        } catch (SQLException ex) {
            Logger.getLogger(Landing.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ready = validation.isTokenValid();
        } catch (SQLException ex) {
            System.out.println("An error occurred in the database");
        }

        if (ready) {
            //rodar
        } else {
            System.out.println("ERRO");
        }
    }//GEN-LAST:event_btnTokenActionPerformed

    public static void main(String args[]) throws SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        // Looca looca = new Looca();

        // System.out.println(looca.getProcessador().getNome());
        Validation validation = new Validation();

        Boolean isTokenValid = validation.isTokenValid();

        if (isTokenValid) {
            //rodar
        } else {
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Landing().setVisible(true);
                }
            });
        }

        // }
        /* Create and display the form */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JToggleButton btnToken;
    private javax.swing.JTextField iptToken;
    private javax.swing.JLabel lblImage;
    // End of variables declaration//GEN-END:variables

    // ---------------------- FUNCTIONS ----------------------
    public void initImages() {
        JLabel labels[] = new JLabel[imageMan.getLabelsQuantity()];
        String images[] = new String[imageMan.getLabelsQuantity()];
        labels[0] = lblImage;
        images[0] = "manos.png";
        imageMan.initImages(labels, images);
    }

    public Boolean validateToken(String token) {
        System.out.println("Validating token...");

        if (true) {
            return true;
        } else {
            return false;
        }
    }

    public void updateMachineIsUsingState(String token) {
        System.out.println("Connecting to database...");
        System.out.println("Updating 'isUsing' field from machine with token: " + token);
    }
}
