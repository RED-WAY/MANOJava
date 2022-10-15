package manos.views;

// JAVA
import java.sql.SQLException;

// CLASSES
import manos.validation.Validation;
import manos.machine.config.MachineConfig;

// STYLE
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

import manos.hardware.constant.Constant;
import manos.hardware.dynamic.Dynamic;

public class View extends javax.swing.JFrame {

    // INITIALIZING INSTANCES...
    Validation validation = new Validation();
    MachineConfig updateMachine = new MachineConfig();
    Integer idMachine = null;
    Constant constant;
    Dynamic dynamic;

    public View() {
        initComponents();
        this.setSize(1400, 800);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Loading = new javax.swing.JPanel();
        lblLoading = new javax.swing.JLabel();
        Views = new javax.swing.JPanel();
        windowBar = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblTitleBar = new javax.swing.JLabel();
        Login = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        btnTheme = new javax.swing.JButton();
        btnToken = new javax.swing.JButton();
        iptToken = new javax.swing.JTextField();
        Home = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("man.OS");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1400, 800));
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setName("Base"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1400, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1400, 800));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        Loading.setBackground(new java.awt.Color(32, 32, 32));
        Loading.setAlignmentX(100.0F);
        Loading.setAlignmentY(100.0F);
        Loading.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        Loading.setDoubleBuffered(false);
        Loading.setMaximumSize(new java.awt.Dimension(1400, 800));
        Loading.setMinimumSize(new java.awt.Dimension(1400, 800));
        Loading.setName(""); // NOI18N
        Loading.setPreferredSize(new java.awt.Dimension(1400, 800));

        lblLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/splashLoading.gif"))); // NOI18N
        lblLoading.setLabelFor(lblLogo);
        lblLoading.setAlignmentX(0.5F);

        javax.swing.GroupLayout LoadingLayout = new javax.swing.GroupLayout(Loading);
        Loading.setLayout(LoadingLayout);
        LoadingLayout.setHorizontalGroup(
            LoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoadingLayout.createSequentialGroup()
                .addGap(626, 626, 626)
                .addComponent(lblLoading)
                .addGap(626, 626, 626))
        );
        LoadingLayout.setVerticalGroup(
            LoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoadingLayout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(lblLoading)
                .addGap(355, 355, 355))
        );

        getContentPane().add(Loading);

        Views.setBackground(new java.awt.Color(32, 32, 32));
        Views.setAlignmentX(100.0F);
        Views.setAlignmentY(100.0F);
        Views.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Views.setDoubleBuffered(false);
        Views.setMaximumSize(new java.awt.Dimension(1400, 800));
        Views.setMinimumSize(new java.awt.Dimension(1400, 800));
        Views.setName(""); // NOI18N
        Views.setPreferredSize(new java.awt.Dimension(1400, 800));

        windowBar.setBackground(new java.awt.Color(18, 18, 18));
        windowBar.setMaximumSize(new java.awt.Dimension(1400, 42));
        windowBar.setMinimumSize(new java.awt.Dimension(1400, 42));
        windowBar.setPreferredSize(new java.awt.Dimension(1400, 42));
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

        lblClose.setBackground(new java.awt.Color(18, 18, 18));
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseMouseExited(evt);
            }
        });

        lblTitleBar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lblTitleBar.setForeground(new java.awt.Color(224, 224, 224));
        lblTitleBar.setText("man.OS");

        javax.swing.GroupLayout windowBarLayout = new javax.swing.GroupLayout(windowBar);
        windowBar.setLayout(windowBarLayout);
        windowBarLayout.setHorizontalGroup(
            windowBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitleBar)
                .addGap(617, 617, 617)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        windowBarLayout.setVerticalGroup(
            windowBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowBarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(lblTitleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Login.setBackground(new java.awt.Color(32, 32, 32));
        Login.setAlignmentX(100.0F);
        Login.setAlignmentY(100.0F);
        Login.setDoubleBuffered(false);
        Login.setMaximumSize(new java.awt.Dimension(1400, 800));
        Login.setMinimumSize(new java.awt.Dimension(1400, 800));
        Login.setName(""); // NOI18N
        Login.setPreferredSize(new java.awt.Dimension(1400, 800));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manos.png"))); // NOI18N
        lblLogo.setLabelFor(lblLogo);
        lblLogo.setAlignmentX(0.5F);

        btnTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemeActionPerformed(evt);
            }
        });

        btnToken.setText("LOGAR");
        btnToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTokenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addComponent(iptToken, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(622, 622, 622)
                        .addComponent(btnToken, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(583, 583, 583)
                        .addComponent(lblLogo)))
                .addContainerGap(484, Short.MAX_VALUE))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(iptToken, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnToken, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(btnTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Home.setBackground(new java.awt.Color(32, 32, 32));
        Home.setAlignmentX(100.0F);
        Home.setAlignmentY(100.0F);
        Home.setDoubleBuffered(false);
        Home.setMaximumSize(new java.awt.Dimension(1400, 800));
        Home.setMinimumSize(new java.awt.Dimension(1400, 800));
        Home.setName(""); // NOI18N
        Home.setPreferredSize(new java.awt.Dimension(1400, 800));

        lblWelcome.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Bem-vindo ao man.OS");
        lblWelcome.setAlignmentY(0.0F);
        lblWelcome.setMaximumSize(new java.awt.Dimension(1400, 70));
        lblWelcome.setMinimumSize(new java.awt.Dimension(1400, 70));
        lblWelcome.setName(""); // NOI18N
        lblWelcome.setOpaque(true);
        lblWelcome.setPreferredSize(new java.awt.Dimension(1400, 70));

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(614, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ViewsLayout = new javax.swing.GroupLayout(Views);
        Views.setLayout(ViewsLayout);
        ViewsLayout.setHorizontalGroup(
            ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(windowBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addGroup(ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ViewsLayout.setVerticalGroup(
            ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewsLayout.createSequentialGroup()
                .addComponent(windowBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 758, Short.MAX_VALUE))
            .addGroup(ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(ViewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(Views);

        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // ------------------- USER INTERACTIONS -------------------    
    Boolean themeLight = false;
    private void btnThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemeActionPerformed

        if (themeLight) {
            Login.setBackground(new java.awt.Color(32, 32, 32));
        } else {
            Login.setBackground(new java.awt.Color(217, 217, 217));
        }
        themeLight = !themeLight;
    }//GEN-LAST:event_btnThemeActionPerformed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        lblClose.setIcon(new ImageIcon(getClass().getResource("/images/closeHover.png")));
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        lblClose.setIcon(new ImageIcon(getClass().getResource("/images/close.png")));
    }//GEN-LAST:event_lblCloseMouseExited

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

    private void btnTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTokenActionPerformed
        // get token input text
        linkMachine();
    }//GEN-LAST:event_btnTokenActionPerformed

    public static void main(String args[]) {
        // LOOK AND FEEL
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
            ex.printStackTrace();
        }

        // RUN
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new View();
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Home;
    private javax.swing.JPanel Loading;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel Views;
    private javax.swing.JButton btnTheme;
    private javax.swing.JButton btnToken;
    private javax.swing.JTextField iptToken;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitleBar;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel windowBar;
    // End of variables declaration//GEN-END:variables

    // ------------------- FUNCTIONS -------------------
    public void startupApp() {
        // Hiding views
        Loading.setVisible(true);
        Views.setVisible(false);

        verifyLink();
    }

    // search machine on DB
    public void verifyLink() {

        try {
            idMachine = validation.isManoCodeValid();
            Boolean alreadyLinked = idMachine != null;

            Loading.setVisible(false);
            Views.setVisible(true);
            windowBar.setVisible(true);
            System.out.println("LINKED: " + (alreadyLinked ? "YES" : "NOT"));
            if (alreadyLinked) {
                System.out.println("ID: " + idMachine);
                Login.setVisible(false);
                Home.setVisible(true);

                startDataCapture(idMachine);

            } else {
                Login.setVisible(true);
                Home.setVisible(false);
            }

        } catch (SQLException ex) {
            System.err.println("An error occurred in the database");
            ex.printStackTrace();
        }

    }

    // connect machine to web entity
    public void linkMachine() {
        Boolean wasLinked;
        String token = iptToken.getText();

        try {
            // validate at DATABASE if there is a machine with the typed token
            wasLinked = updateMachine.linkMachine(token);

            if (wasLinked) {
                Login.setVisible(false);
                Home.setVisible(true);

                this.idMachine = Integer.valueOf(token);
                this.constant = new Constant(this.idMachine);
                this.constant.insertData();
                
                startDataCapture(this.idMachine);

            } else {
                System.err.println("Erro ao conectar a máquina, talvez não exista ou já esta conectada!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void startDataCapture(Integer idMachine) {
        new Thread(() -> {
            try {
                this.dynamic = new Dynamic(this.idMachine);
                this.dynamic.insertData();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
    
}
