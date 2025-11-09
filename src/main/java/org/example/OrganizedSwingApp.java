package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class OrganizedSwingApp {
    JFrame MainFrame;
    JPanel PanelMain;
    CardLayout cardLayout;

    // Store users
    Map<String, User> users = new HashMap<>();

    // ----------- COMPONENTS FOR SIGNUP -------------
    JTextField txtFirstName, txtLastName, txtAge, txtEmail, txtPhone, txtUsername;
    JPasswordField txtPassword;
    JButton btnCreateAccount, btnGoToLogin;

    JTextField txtLoginUsername;
    JPasswordField txtLoginPassword;
    JButton btnLogin, btnGoToSignup;

    JLabel lblWelcome;
    JButton btnLogout;
    public OrganizedSwingApp() {
        this.PrepareMainFrame();
    }
    public void PrepareMainFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MainFrame = new JFrame("Account Management App");
        MainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        cardLayout = new CardLayout();
        PanelMain = new JPanel(cardLayout);

        PanelMain.add(PrepareSignupPanel(), "signup");
        PanelMain.add(PrepareLoginPanel(), "login");
        PanelMain.add(PrepareDashboardPanel(), "dashboard");

        MainFrame.add(PanelMain);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setVisible(true);

        // Start on Sign Up screen
        cardLayout.show(PanelMain, "signup");
    }
}

