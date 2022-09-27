package com.manos.views;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author Vitor
 */
public class LandingView extends javax.swing.JFrame {

    public LandingView() {
        initComponents();
        initImages();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Background = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        themeChanger = new javax.swing.JButton();
        windowBar = new javax.swing.JPanel();
        closeLabel = new javax.swing.JLabel();
        titleBarLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("man.OS");
        setBackground(new java.awt.Color(250, 250, 250));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Base"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        Background.setBackground(new java.awt.Color(32, 32, 32));
        Background.setPreferredSize(new java.awt.Dimension(1366, 768));

        logoLabel.setBackground(new java.awt.Color(255, 0, 51));
        logoLabel.setForeground(new java.awt.Color(0, 0, 0));
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setLabelFor(logoLabel);
        logoLabel.setAlignmentX(0.5F);
        logoLabel.setOpaque(true);

        themeChanger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeChangerActionPerformed(evt);
            }
        });

        windowBar.setBackground(new java.awt.Color(18, 18, 18));
        windowBar.setPreferredSize(new java.awt.Dimension(719, 42));
        windowBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                windowBarMouseDragged(evt);
            }
        });
        windowBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                windowBarMousePressed(evt);
            }
        });

        closeLabel.setBackground(new java.awt.Color(18, 18, 18));
        closeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeLabelMouseExited(evt);
            }
        });

        titleBarLabel.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        titleBarLabel.setForeground(new java.awt.Color(224, 224, 224));
        titleBarLabel.setText("man.OS");

        javax.swing.GroupLayout windowBarLayout = new javax.swing.GroupLayout(windowBar);
        windowBar.setLayout(windowBarLayout);
        windowBarLayout.setHorizontalGroup(
            windowBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleBarLabel)
                .addGap(617, 617, 617)
                .addComponent(closeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        windowBarLayout.setVerticalGroup(
            windowBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowBarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(closeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(titleBarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(windowBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(themeChanger, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(583, 583, 583)
                        .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(583, Short.MAX_VALUE))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                .addComponent(windowBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(themeChanger, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // ------------------- ACTIONS -------------------
    Boolean themeLight = false;
    private void themeChangerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeChangerActionPerformed

        if (themeLight) {
            Background.setBackground(new java.awt.Color(32, 32, 32));
        } else {
            Background.setBackground(new java.awt.Color(217, 217, 217));
        }
        themeLight = !themeLight;

        changeSize();
    }//GEN-LAST:event_themeChangerActionPerformed

    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeLabelMouseClicked

    private void closeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseEntered
        closeLabel.setIcon(resizedImage("closeHover.png", closeLabel));
    }//GEN-LAST:event_closeLabelMouseEntered

    private void closeLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseExited
        closeLabel.setIcon(resizedImage("close.png", closeLabel));
    }//GEN-LAST:event_closeLabelMouseExited

    int x, y;
    private void windowBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowBarMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_windowBarMousePressed

    private void windowBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowBarMouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - x, yy - y);
    }//GEN-LAST:event_windowBarMouseDragged

    private void initImages() {
        logoLabel.setBackground(Color.red);

        logoLabel.setIcon(resizedImage("manos.png", logoLabel));
        closeLabel.setIcon(resizedImage("close.png", closeLabel));
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LandingView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton themeChanger;
    private javax.swing.JLabel titleBarLabel;
    private javax.swing.JPanel windowBar;
    // End of variables declaration//GEN-END:variables

    // ------------------- FUNCTIONS -------------------
    private ImageIcon resizedImage(String imgName, JLabel label) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(String.format("assets/%s", imgName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);

        return imageIcon;
    }

    private void changeSize() {
        logoLabel.setSize(100, 140);
        logoLabel.setIcon(resizedImage("manos.png", logoLabel));
    }
}
