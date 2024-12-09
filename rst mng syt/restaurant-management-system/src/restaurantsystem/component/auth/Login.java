package restaurantsystem.component.auth;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JFrame {

    private JPanel loginPanel;
    private JLabel userNameLabel;
    private JTextField userNameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        initComponents();
        setDefaultUserName();
    }

    private void setDefaultUserName() {
        userNameField.setText("Enter Username");
        passwordField.setText("Enter Password");
    }

    private void initComponents() {

        // Login panel styling
        loginPanel = new JPanel();
        loginPanel.setBackground(new Color(253, 245, 230)); // Light beige background
        loginPanel.setBorder(BorderFactory.createTitledBorder(
                null, "Restaurant Login",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.BOLD, 24), // Modern font
                new Color(185, 122, 87) // Warm orange title
        ));

        // Username label styling
        userNameLabel = new JLabel("Username:");
        userNameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        userNameLabel.setForeground(Color.DARK_GRAY);

        // Username field styling
        userNameField = new JTextField("Enter Username");
        userNameField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        userNameField.setForeground(Color.DARK_GRAY);
        userNameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(185, 122, 87), 2), // Warm orange border
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        
        // Placeholder for username field
        userNameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (userNameField.getText().equals("Enter Username")) {
                    userNameField.setText("");
                    userNameField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userNameField.getText().isEmpty()) {
                    userNameField.setText("Enter Username");
                    userNameField.setForeground(Color.DARK_GRAY);
                }
            }
        });

        // Password label styling
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        passwordLabel.setForeground(Color.DARK_GRAY);

        // Password field styling
        passwordField = new JPasswordField("Enter Password");
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        passwordField.setForeground(Color.DARK_GRAY);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(185, 122, 87), 2), // Warm orange border
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        
        // Placeholder for password field
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Enter Password")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setText("Enter Password");
                    passwordField.setForeground(Color.DARK_GRAY);
                }
            }
        });

        // Login button styling
        loginButton = new JButton("Log In");
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        loginButton.setBackground(new Color(185, 122, 87)); // Warm orange
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(165, 105, 79), 2)); // Slightly darker border

        // Button hover effect
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(160, 85, 65));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(185, 122, 87));
            }
        });
        
        loginButton.addActionListener(evt -> loginButtonActionPerformed());

        // Layout adjustments for login panel
        GroupLayout loginPanelLayout = new GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createSequentialGroup()
                .addGap(30)
                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(userNameLabel)
                    .addComponent(passwordLabel))
                .addGap(18)
                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(userNameField, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(passwordField)
                    .addComponent(loginButton, GroupLayout.Alignment.CENTER, 130, 130, 130))
                .addGap(30)
        );
        
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createSequentialGroup()
                .addGap(40)
                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addGap(30)
                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(40)
        );

        // Setting up main layout
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(loginPanel, BorderLayout.CENTER);
        pack();
    }

    private void loginButtonActionPerformed() {
        if ("user".equalsIgnoreCase(userNameField.getText()) && "password".equals(new String(passwordField.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Access granted");
            dispose();
            // Open MainMenu or other next steps
        } else {
            userNameField.setText("Enter Username");
            passwordField.setText("Enter Password");
            JOptionPane.showMessageDialog(this, "Access Denied");
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
}
