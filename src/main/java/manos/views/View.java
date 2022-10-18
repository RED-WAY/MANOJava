package manos.views;

// JAVA
import java.sql.SQLException;

// CLASSES
import manos.machine.Validation;
import manos.machine.MachineConfig;

// STYLE
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import manos.hardware.Constant;
import manos.hardware.Dynamic;
import manos.machine.Machine;
import manos.process.Processes;

public class View extends javax.swing.JFrame {

    // INITIALIZING INSTANCES...
    Validation validation = new Validation();
    MachineConfig updateMachine = new MachineConfig();

    Machine machine;

    Constant constant;
    Dynamic dynamic;
    Processes processes;

    Thread errorThread = new Thread();
    Utils utils = new Utils();
    Colors colors = new Colors();

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
        LoginContainer = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlIptToken = new javax.swing.JPanel();
        iptToken = new javax.swing.JTextField();
        lblIptTokenError = new javax.swing.JLabel();
        btnToken = new javax.swing.JPanel();
        lblBtnToken = new javax.swing.JLabel();
        Home = new javax.swing.JPanel();
        lblMachineName = new javax.swing.JLabel();
        lblOperationalSystem = new javax.swing.JLabel();
        lblConsumerName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("man.OS");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        setForeground(new java.awt.Color(205, 205, 205));
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
        Loading.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
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
        Views.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        Views.setMaximumSize(new java.awt.Dimension(1400, 800));
        Views.setMinimumSize(new java.awt.Dimension(1400, 800));
        Views.setName(""); // NOI18N
        Views.setPreferredSize(new java.awt.Dimension(1400, 800));

        windowBar.setBackground(new java.awt.Color(18, 18, 18));
        windowBar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
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
        Login.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        Login.setMaximumSize(new java.awt.Dimension(1400, 800));
        Login.setMinimumSize(new java.awt.Dimension(1400, 800));
        Login.setName(""); // NOI18N
        Login.setPreferredSize(new java.awt.Dimension(1400, 800));

        LoginContainer.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LoginContainer.setMaximumSize(new java.awt.Dimension(1400, 800));
        LoginContainer.setMinimumSize(new java.awt.Dimension(1400, 800));
        LoginContainer.setOpaque(false);
        LoginContainer.setPreferredSize(new java.awt.Dimension(1400, 800));

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
        lblIptTokenError.setForeground(new java.awt.Color(32, 32, 32));
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

        javax.swing.GroupLayout LoginContainerLayout = new javax.swing.GroupLayout(LoginContainer);
        LoginContainer.setLayout(LoginContainerLayout);
        LoginContainerLayout.setHorizontalGroup(
            LoginContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1400, Short.MAX_VALUE)
            .addGroup(LoginContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LoginContainerLayout.createSequentialGroup()
                    .addGap(475, 475, 475)
                    .addGroup(LoginContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LoginContainerLayout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addComponent(lblLogo))
                        .addGroup(LoginContainerLayout.createSequentialGroup()
                            .addGap(118, 118, 118)
                            .addComponent(btnToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pnlIptToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(475, Short.MAX_VALUE)))
        );
        LoginContainerLayout.setVerticalGroup(
            LoginContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(LoginContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LoginContainerLayout.createSequentialGroup()
                    .addGap(152, 152, 152)
                    .addComponent(lblLogo)
                    .addGap(18, 18, 18)
                    .addComponent(pnlIptToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(152, Short.MAX_VALUE)))
        );

        pnlIptToken.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addComponent(LoginContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(476, 476, 476))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addComponent(LoginContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Home.setBackground(new java.awt.Color(32, 32, 32));
        Home.setAlignmentX(100.0F);
        Home.setAlignmentY(100.0F);
        Home.setDoubleBuffered(false);
        Home.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        Home.setMaximumSize(new java.awt.Dimension(1400, 800));
        Home.setMinimumSize(new java.awt.Dimension(1400, 800));
        Home.setName(""); // NOI18N
        Home.setPreferredSize(new java.awt.Dimension(1400, 800));

        lblMachineName.setBackground(new java.awt.Color(204, 204, 204));
        lblMachineName.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        lblMachineName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMachineName.setAlignmentY(0.0F);
        lblMachineName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 4, true));
        lblMachineName.setMaximumSize(new java.awt.Dimension(540, 70));
        lblMachineName.setMinimumSize(new java.awt.Dimension(540, 70));
        lblMachineName.setName(""); // NOI18N
        lblMachineName.setOpaque(true);
        lblMachineName.setPreferredSize(new java.awt.Dimension(540, 70));

        lblOperationalSystem.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblOperationalSystem.setForeground(new java.awt.Color(237, 20, 91));
        lblOperationalSystem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOperationalSystem.setAlignmentY(0.0F);
        lblOperationalSystem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 187, 187), 2, true));
        lblOperationalSystem.setMaximumSize(new java.awt.Dimension(300, 50));
        lblOperationalSystem.setMinimumSize(new java.awt.Dimension(300, 50));
        lblOperationalSystem.setName(""); // NOI18N
        lblOperationalSystem.setPreferredSize(new java.awt.Dimension(300, 50));

        lblConsumerName.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        lblConsumerName.setForeground(new java.awt.Color(204, 204, 204));
        lblConsumerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConsumerName.setAlignmentY(0.0F);
        lblConsumerName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 187, 187), 2, true));
        lblConsumerName.setMaximumSize(new java.awt.Dimension(800, 70));
        lblConsumerName.setMinimumSize(new java.awt.Dimension(800, 70));
        lblConsumerName.setName(""); // NOI18N
        lblConsumerName.setPreferredSize(new java.awt.Dimension(250, 40));

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(550, 550, 550)
                        .addComponent(lblOperationalSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(575, 575, 575)
                        .addComponent(lblConsumerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(lblMachineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(lblOperationalSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblMachineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblConsumerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        utils.animateColor(lblClose, colors.closeFocus, "fore", 1);

    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        utils.animateColor(lblClose, colors.closePrimary, "fore", 1);
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
                        utils.animateColor(btnToken, colors.btnActive, "back", 2);
                        Thread.sleep(100);
                        utils.animateColor(btnToken, colors.btnPrimary, "back", 2);

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
                    utils.animateColor(btnToken, colors.btnActive, "back", 2);
                    Thread.sleep(100);
                    utils.animateColor(btnToken, colors.btnPrimary, "back", 2);

                    this.readInputToken();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

            }).start();

        }
    }//GEN-LAST:event_btnTokenMouseClicked

    private void btnTokenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTokenMouseEntered
        if (lblBtnToken.getText().equals("CONECTAR")) {
            utils.animateColor(btnToken, colors.btnFocus, "back", 10);
        }
    }//GEN-LAST:event_btnTokenMouseEntered

    private void btnTokenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTokenMouseExited
        if (lblBtnToken.getText().equals("CONECTAR")) {
            utils.animateColor(btnToken, colors.btnPrimary, "back", 10);
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
    private javax.swing.JPanel LoginContainer;
    private javax.swing.JPanel Views;
    private javax.swing.JPanel btnToken;
    private javax.swing.JTextField iptToken;
    private javax.swing.JLabel lblBtnToken;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblConsumerName;
    private javax.swing.JLabel lblIptTokenError;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMachineName;
    private javax.swing.JLabel lblOperationalSystem;
    private javax.swing.JLabel lblTitleBar;
    private javax.swing.JPanel pnlIptToken;
    private javax.swing.JPanel windowBar;
    // End of variables declaration//GEN-END:variables

    // ------------------- FUNCTIONS -------------------
    public void startupApp() {
        // Hiding views
        Loading.setVisible(true);
        Views.setVisible(false);

        this.errorThread.interrupt();

        this.verifyLink();
    }

    // search machine on DB
    public void verifyLink() {

        try {

            this.machine = this.validation.isManoCodeValid();

            Boolean alreadyLinked = this.machine != null;

            Loading.setVisible(false);
            Views.setVisible(true);
            windowBar.setVisible(true);

            if (alreadyLinked) {
                this.setHomeData();

                Login.setVisible(false);
                Home.setVisible(true);

                this.constant = new Constant(this.machine.getIdMachine());
                this.startDataCapture();

            } else {

                Login.setVisible(true);
                Home.setVisible(false);

                iptToken.grabFocus();
                iptToken.requestFocus();
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

            if (this.errorThread.isInterrupted()) {
                this.errorThread = new Thread(() -> {
                    try {

                        lblIptTokenError.setText("Token inválido. Apenas números são permitidos!");
                        this.utils.animateColor(lblIptTokenError, colors.textSecondary, "text", 1);
                        Thread.sleep(3000);
                        this.utils.animateColor(lblIptTokenError, colors.textHidden, "text", 1);
                        Thread.sleep(2000);
                        lblIptTokenError.setText("");

                        this.errorThread.interrupt();
                    } catch (InterruptedException ex) {

                    }
                });
                this.errorThread.start();
            }

        } else {

            this.linkMachine(token);

        }

    }

    public void linkMachine(String token) {
        try {

            lblBtnToken.setText("");
            lblBtnToken.setIcon(new ImageIcon(getClass().getResource("/gifs/loadingButton.gif")));
            utils.animateColor(btnToken, colors.btnDisabled, "back", 2);

            // validate at DATABASE if there is a machine with the typed token
            this.updateMachine.linkMachine(token);
            this.machine = this.validation.isManoCodeValid();

            Boolean wasLinked = this.machine != null;

            new Thread(() -> {

                if (wasLinked) {
                    this.transitionPanels(Login, Home);
                    this.setHomeData();

                    this.constant = new Constant(this.machine.getIdMachine());
                    this.constant.insertData();

                    this.startDataCapture();

                } else {

                    lblBtnToken.setIcon(null);
                    lblBtnToken.setText("CONECTAR");
                    utils.animateColor(btnToken, new Color(70, 70, 70), "back", 2);

                    System.err.println("Erro ao conectar a máquina, talvez não exista ou já esta conectada!");

                    if (this.errorThread.isInterrupted()) {
                        this.errorThread = new Thread(() -> {

                            try {

                                lblIptTokenError.setText("Máquina já esta conectada ou ainda não foi criada no site!");
                                utils.animateColor(lblIptTokenError, colors.textSecondary, "text", 1);
                                Thread.sleep(3000);
                                utils.animateColor(lblIptTokenError, colors.textHidden, "text", 1);
                                Thread.sleep(2000);
                                lblIptTokenError.setText("");

                                this.errorThread.interrupt();
                            } catch (InterruptedException ex) {

                            }

                        });

                        this.errorThread.start();
                    }

                }

            }).start();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void startDataCapture() {
        new Thread(() -> {
            this.dynamic = new Dynamic(this.machine.getIdMachine());
            this.dynamic.insertData();
        }).start();
        new Thread(() -> {
            this.processes = new Processes(this.machine.getIdMachine(), this.machine.getOperationalSystem());
            this.processes.getManosProcesses();
            this.processes.matchProcesses();
        }).start();
    }

    public void setHomeData() {
        lblOperationalSystem.setText(machine.getOperationalSystem());
        lblMachineName.setText(machine.getMachineName());
        lblConsumerName.setText(machine.getConsumerName());
    }

    public void transitionPanels(JPanel actualPanel, JPanel nextPanel) {
        new Thread(() -> {
            try {

                Double timer = 1.0;
                for (int i = 42; i <= 800; i++) {
                    i += 4;
                    timer += 0.025;
                    windowBar.setSize(1400, i);
                    Thread.sleep(Math.round(timer));
                }

                timer = 1.0;
                Views.setBackground(new Color(18, 18, 18));
                actualPanel.setVisible(false);
                Thread.sleep(300);
                nextPanel.setVisible(true);

                for (int i = 800; i >= 42; i--) {
                    i = i - 4;
                    timer += 0.01;
                    windowBar.setSize(1400, i);
                    Thread.sleep(Math.round(timer));
                }

                Views.setBackground(new Color(32, 32, 32));

            } catch (InterruptedException ex) {
                ex.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
    }

}
