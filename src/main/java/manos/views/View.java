package manos.views;

// JAVA
import java.sql.SQLException;

// CLASSES
import manos.machine.validation.Validation;
import manos.machine.config.MachineConfig;

// STYLE
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import manos.hardware.Constant;
import manos.hardware.Dynamic;

public class View extends javax.swing.JFrame {

    // INITIALIZING INSTANCES...
    Validation validation = new Validation();
    MachineConfig updateMachine = new MachineConfig();
    Integer idMachine = null;
    Constant constant;
    Dynamic dynamic;

    // COLORS
    Color btnPrimary = new Color(70, 70, 70, 255);
    Color btnFocus = new Color(100, 100, 100, 255);
    Color btnActive = new Color(120, 120, 120, 255);
    Color btnDisabled = new Color(18, 18, 18, 255);

    Color closePrimary = new Color(255, 255, 255, 255);
    Color closeFocus = new Color(237, 20, 91, 255);

    public View() {
        // icon
        final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        final URL imageResource = App.class.getClassLoader().getResource("images/appIcon64.png");
        final Image image = defaultToolkit.getImage(imageResource);
        this.setIconImage(image);

        initComponents();
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
        pnlIptToken = new javax.swing.JPanel();
        iptToken = new javax.swing.JTextField();
        lblIptTokenError = new javax.swing.JLabel();
        btnToken = new javax.swing.JPanel();
        lblBtnToken = new javax.swing.JLabel();
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

        lblClose.setBackground(new java.awt.Color(255, 255, 255));
        lblClose.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        lblClose.setForeground(new java.awt.Color(204, 204, 204));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("X");
        lblClose.setAlignmentY(0.0F);
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblClose.setIconTextGap(0);
        lblClose.setMaximumSize(new java.awt.Dimension(42, 42));
        lblClose.setMinimumSize(new java.awt.Dimension(42, 42));
        lblClose.setPreferredSize(new java.awt.Dimension(42, 42));
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

        lblTitleBar.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N
        lblTitleBar.setForeground(new java.awt.Color(224, 224, 224));
        lblTitleBar.setText("man.OS");
        lblTitleBar.setAlignmentY(0.0F);
        lblTitleBar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTitleBar.setMaximumSize(new java.awt.Dimension(80, 42));
        lblTitleBar.setMinimumSize(new java.awt.Dimension(80, 42));
        lblTitleBar.setName(""); // NOI18N
        lblTitleBar.setPreferredSize(new java.awt.Dimension(80, 42));

        javax.swing.GroupLayout windowBarLayout = new javax.swing.GroupLayout(windowBar);
        windowBar.setLayout(windowBarLayout);
        windowBarLayout.setHorizontalGroup(
            windowBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowBarLayout.createSequentialGroup()
                .addGap(660, 660, 660)
                .addComponent(lblTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(618, 618, 618)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        windowBarLayout.setVerticalGroup(
            windowBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowBarLayout.createSequentialGroup()
                .addGroup(windowBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        pnlIptToken.setBackground(new java.awt.Color(18, 18, 18));
        pnlIptToken.setMaximumSize(new java.awt.Dimension(450, 134));
        pnlIptToken.setMinimumSize(new java.awt.Dimension(450, 134));
        pnlIptToken.setOpaque(false);
        pnlIptToken.setPreferredSize(new java.awt.Dimension(450, 134));

        iptToken.setBackground(new java.awt.Color(32, 32, 32));
        iptToken.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        iptToken.setForeground(new java.awt.Color(200, 200, 200));
        iptToken.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        iptToken.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 2, true), "TOKEN DA MÁQUINA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins", 0, 14), new java.awt.Color(200, 200, 200))); // NOI18N
        iptToken.setCaretColor(new java.awt.Color(237, 20, 91));
        iptToken.setDisabledTextColor(new java.awt.Color(200, 200, 200));
        iptToken.setMargin(new java.awt.Insets(20, 20, 20, 20));
        iptToken.setMaximumSize(new java.awt.Dimension(380, 84));
        iptToken.setMinimumSize(new java.awt.Dimension(380, 84));
        iptToken.setPreferredSize(new java.awt.Dimension(380, 84));
        iptToken.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        iptToken.setSelectionColor(new java.awt.Color(237, 20, 91));
        iptToken.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                iptTokenKeyPressed(evt);
            }
        });

        lblIptTokenError.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblIptTokenError.setForeground(new java.awt.Color(237, 20, 91));
        lblIptTokenError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIptTokenError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIptTokenError.setMaximumSize(new java.awt.Dimension(420, 30));
        lblIptTokenError.setMinimumSize(new java.awt.Dimension(420, 30));
        lblIptTokenError.setPreferredSize(new java.awt.Dimension(420, 30));

        javax.swing.GroupLayout pnlIptTokenLayout = new javax.swing.GroupLayout(pnlIptToken);
        pnlIptToken.setLayout(pnlIptTokenLayout);
        pnlIptTokenLayout.setHorizontalGroup(
            pnlIptTokenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIptTokenLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblIptTokenError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(pnlIptTokenLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(iptToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        pnlIptTokenLayout.setVerticalGroup(
            pnlIptTokenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIptTokenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iptToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblIptTokenError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnToken.setBackground(new java.awt.Color(70, 70, 70));
        btnToken.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnToken.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        btnToken.setMaximumSize(new java.awt.Dimension(216, 62));
        btnToken.setMinimumSize(new java.awt.Dimension(216, 62));
        btnToken.setPreferredSize(new java.awt.Dimension(216, 62));
        btnToken.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTokenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTokenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTokenMouseExited(evt);
            }
        });

        lblBtnToken.setBackground(new java.awt.Color(32, 32, 32));
        lblBtnToken.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        lblBtnToken.setForeground(new java.awt.Color(204, 204, 204));
        lblBtnToken.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBtnToken.setText("CONECTAR");
        lblBtnToken.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblBtnToken.setMaximumSize(new java.awt.Dimension(168, 62));
        lblBtnToken.setMinimumSize(new java.awt.Dimension(168, 62));
        lblBtnToken.setPreferredSize(new java.awt.Dimension(168, 62));

        javax.swing.GroupLayout btnTokenLayout = new javax.swing.GroupLayout(btnToken);
        btnToken.setLayout(btnTokenLayout);
        btnTokenLayout.setHorizontalGroup(
            btnTokenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTokenLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblBtnToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        btnTokenLayout.setVerticalGroup(
            btnTokenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBtnToken, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(600, 600, 600)
                        .addComponent(lblLogo))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(592, 592, 592)
                        .addComponent(btnToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(pnlIptToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(476, 476, 476))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(lblLogo)
                .addGap(18, 18, 18)
                .addComponent(pnlIptToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        pnlIptToken.getAccessibleContext().setAccessibleName("");

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
    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        this.animateColor(lblClose, closeFocus, "fore", 1);

    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        this.animateColor(lblClose, closePrimary, "fore", 1);
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

    private void iptTokenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iptTokenKeyPressed
        if (evt.getExtendedKeyCode() == 10) {

            if (lblBtnToken.getText().equals("CONECTAR")) {
                new Thread(() -> {
                    try {
                        this.animateColor(btnToken, btnActive, "back", 2);
                        Thread.sleep(100);
                        this.animateColor(btnToken, btnPrimary, "back", 2);

                        this.readInputToken();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            }

        }
    }//GEN-LAST:event_iptTokenKeyPressed

    private void btnTokenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTokenMouseClicked
        if (lblBtnToken.getText().equals("CONECTAR")) {

            new Thread(() -> {
                try {

                    this.animateColor(btnToken, btnActive, "back", 2);
                    Thread.sleep(100);
                    this.animateColor(btnToken, btnPrimary, "back", 2);

                    this.readInputToken();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

            }).start();

        }
    }//GEN-LAST:event_btnTokenMouseClicked

    private void btnTokenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTokenMouseEntered
        if (lblBtnToken.getText().equals("CONECTAR")) {
            this.animateColor(btnToken, btnFocus, "back", 10);
        }
    }//GEN-LAST:event_btnTokenMouseEntered

    private void btnTokenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTokenMouseExited
        if (lblBtnToken.getText().equals("CONECTAR")) {
            this.animateColor(btnToken, btnPrimary, "back", 10);
        }
    }//GEN-LAST:event_btnTokenMouseExited

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
    private javax.swing.JPanel btnToken;
    private javax.swing.JTextField iptToken;
    private javax.swing.JLabel lblBtnToken;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblIptTokenError;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitleBar;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnlIptToken;
    private javax.swing.JPanel windowBar;
    // End of variables declaration//GEN-END:variables

    // ------------------- FUNCTIONS -------------------
    public void startupApp() {
        // Hiding views
        Loading.setVisible(true);
        Views.setVisible(false);

        this.verifyLink();
    }

    // search machine on DB
    public void verifyLink() {

        try {

            idMachine = validation.isManoCodeValid();
            Boolean alreadyLinked = idMachine != null;

            Loading.setVisible(false);
            Views.setVisible(true);
            windowBar.setVisible(true);

            if (alreadyLinked) {

                System.out.println("ID: " + idMachine);
                Login.setVisible(false);
                Home.setVisible(true);

                this.startDataCapture(idMachine);

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
    public void readInputToken() {
        String token = iptToken.getText().trim();

        if (!token.matches("[0-9]+")) {

            new Thread(() -> {

                try {

                    lblIptTokenError.setText("Token inválido. Apenas números são permitidos!");
                    Thread.sleep(5000);
                    lblIptTokenError.setText("");

                    Thread.currentThread().interrupt();

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    Thread.currentThread().interrupt();
                }

            }).start();

        } else {

            this.linkMachine(token);

        }

    }

    public void linkMachine(String token) {
        try {
            lblBtnToken.setText("");
            lblBtnToken.setIcon(new ImageIcon(getClass().getResource("/gifs/loadingButton.gif")));
            this.animateColor(btnToken, btnDisabled, "back", 2);

            // validate at DATABASE if there is a machine with the typed token
            Boolean wasLinked = updateMachine.linkMachine(token);

            new Thread(() -> {
                try {
                    Thread.sleep(3000);

                    if (wasLinked) {
                        Login.setVisible(false);
                        Home.setVisible(true);

                        this.idMachine = Integer.valueOf(token);
                        this.constant = new Constant(this.idMachine);
                        this.constant.insertData();

                        this.startDataCapture(this.idMachine);

                    } else {

                        lblBtnToken.setIcon(null);
                        lblBtnToken.setText("CONECTAR");
                        this.animateColor(btnToken, new Color(70, 70, 70), "back", 2);

                        System.err.println("Erro ao conectar a máquina, talvez não exista ou já esta conectada!");
                        lblIptTokenError.setText("Máquina já esta conectada ou ainda não foi criada no site!");
                        Thread.sleep(5000);
                        lblIptTokenError.setText("");

                        Thread.currentThread().interrupt();
                    }

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }).start();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void startDataCapture(Integer idMachine) {
        new Thread(() -> {
            this.dynamic = new Dynamic(this.idMachine);
            this.dynamic.insertData();
        }).start();
    }

    public void animateColor(JComponent component, Color end, String type, Integer delay) {

        new Thread(() -> {
            try {
                int r = type.equals("back")
                        ? component.getBackground().getRed()
                        : component.getForeground().getRed();

                int g = type.equals("back")
                        ? component.getBackground().getGreen()
                        : component.getForeground().getGreen();

                int b = type.equals("back")
                        ? component.getBackground().getBlue()
                        : component.getForeground().getBlue();

                int a = type.equals("back")
                        ? component.getBackground().getAlpha()
                        : component.getForeground().getAlpha();

                Color start = type.equals("back")
                        ? component.getBackground()
                        : component.getForeground();

                while (!start.equals(end)) {

                    if (r != end.getRed()) {
                        r = r > end.getRed() ? r - 1 : r + 1;
                    }
                    if (g != end.getGreen()) {
                        g = g > end.getGreen() ? g - 1 : g + 1;
                    }
                    if (b != end.getBlue()) {
                        b = b > end.getBlue() ? b - 1 : b + 1;
                    }
                    if (a != end.getAlpha()) {
                        a = a > end.getAlpha() ? a - 1 : a + 1;
                    }

                    start = new Color(r, g, b, a);

                    if (type.equals("back")) {
                        component.setBackground(start);
                    } else {
                        component.setForeground(start);
                    }
                    Thread.sleep(delay);
                }

                Thread.currentThread().interrupt();

            } catch (InterruptedException ex) {
                ex.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }).start();

    }

}
