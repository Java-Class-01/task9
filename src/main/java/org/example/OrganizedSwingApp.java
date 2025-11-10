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

    public JPanel PrepareSignupPanel() {
        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createTitledBorder("Create Account"));

        JLabel lblPersonal = new JLabel("PERSONAL INFORMATION");
        lblPersonal.setFont(new Font("Arial", Font.BOLD, 18));
        lblPersonal.setBounds(50, 30, 400, 30);
        panel.add(lblPersonal);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(50, 80, 150, 30);
        panel.add(lblFirstName);
        txtFirstName = new JTextField();
        txtFirstName.setBounds(200, 80, 300, 30);
        panel.add(txtFirstName);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(50, 120, 150, 30);
        panel.add(lblLastName);
        txtLastName = new JTextField();
        txtLastName.setBounds(200, 120, 300, 30);
        panel.add(txtLastName);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(50, 160, 150, 30);
        panel.add(lblAge);
        txtAge = new JTextField();
        txtAge.setBounds(200, 160, 300, 30);
        panel.add(txtAge);

        JLabel lblContact = new JLabel("CONTACT INFORMATION");
        lblContact.setFont(new Font("Arial", Font.BOLD, 18));
        lblContact.setBounds(50, 210, 400, 30);
        panel.add(lblContact);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 250, 150, 30);
        panel.add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setBounds(200, 250, 300, 30);
        panel.add(txtEmail);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(50, 290, 150, 30);
        panel.add(lblPhone);
        txtPhone = new JTextField();
        txtPhone.setBounds(200, 290, 300, 30);
        panel.add(txtPhone);

        JLabel lblLogin = new JLabel("LOGIN INFORMATION");
        lblLogin.setFont(new Font("Arial", Font.BOLD, 18));
        lblLogin.setBounds(50, 340, 400, 30);
        panel.add(lblLogin);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 380, 150, 30);
        panel.add(lblUsername);
        txtUsername = new JTextField();
        txtUsername.setBounds(200, 380, 300, 30);
        panel.add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 420, 150, 30);
        panel.add(lblPassword);
        txtPassword = new JPasswordField();
        txtPassword.setBounds(200, 420, 300, 30);
        panel.add(txtPassword);

        btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.setBounds(200, 480, 200, 40);
        panel.add(btnCreateAccount);

        btnGoToLogin = new JButton("Already have an account? Login");
        btnGoToLogin.setBounds(200, 530, 250, 30);
        panel.add(btnGoToLogin);

        btnCreateAccount.addActionListener(e -> CreateAccount());
        btnGoToLogin.addActionListener(e -> cardLayout.show(PanelMain, "login"));

        return panel;
    }
    // add ur part here
    //login panel
    public JPanel PrepareLoginPanel() {
        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createTitledBorder("Login"));

        JLabel lblLoginTitle = new JLabel("USER LOGIN");
        lblLoginTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblLoginTitle.setBounds(50, 50, 400, 30);
        panel.add(lblLoginTitle);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(50, 120, 150, 30);
        panel.add(lblUser);
        txtLoginUsername = new JTextField();
        txtLoginUsername.setBounds(200, 120, 300, 30);
        panel.add(txtLoginUsername);
        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(50, 160, 150, 30);
        panel.add(lblPass);
        txtLoginPassword = new JPasswordField();
        txtLoginPassword.setBounds(200, 160, 300, 30);
        panel.add(txtLoginPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(200, 210, 200, 40);
        panel.add(btnLogin);

        btnGoToSignup = new JButton("Create a new account");
        btnGoToSignup.setBounds(200, 260, 200, 30);
        panel.add(btnGoToSignup);
        btnLogin.addActionListener(e -> LoginUser());
        btnGoToSignup.addActionListener(e -> cardLayout.show(PanelMain, "signup"));

        return panel;
    }




}

