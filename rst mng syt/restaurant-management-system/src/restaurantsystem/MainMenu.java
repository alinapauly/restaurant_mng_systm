package restaurantsystem;

import restaurantsystem.component.item.ItemManagement;
import restaurantsystem.component.labour.LabourManagement;
import restaurantsystem.component.order.OrderManagement;

import javax.swing.*;
import javax.swing.border.TitledBorder; // Import TitledBorder
import java.awt.*;

public class MainMenu extends JFrame {

    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton orderManagementButton;
    private JButton labourManagementButton;
    private JButton itemManagementButton;
    private JButton exitButton;

    public MainMenu() {
        initComponents();
    }

    private void initComponents() {

        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        orderManagementButton = new JButton("Order Management");
        labourManagementButton = new JButton("Labour Management");
        itemManagementButton = new JButton("Item Management");
        exitButton = new JButton("Exit");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        // Main panel styling
        mainPanel.setBackground(new Color(253, 245, 230)); // Light beige
        mainPanel.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        // Button panel styling
        buttonPanel.setBackground(new Color(255, 255, 240)); // Soft cream background
        buttonPanel.setBorder(BorderFactory.createTitledBorder(null, "Main Menu",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.BOLD, 24), new Color(185, 122, 87))); // Warm orange title

        // Button styling
        configureButton(orderManagementButton);
        configureButton(labourManagementButton);
        configureButton(itemManagementButton);
        configureButton(exitButton);

        // Set up button actions
        orderManagementButton.addActionListener(evt -> orderManagementButtonActionPerformed());
        labourManagementButton.addActionListener(evt -> labourManagementButtonActionPerformed());
        itemManagementButton.addActionListener(evt -> itemManagementButtonActionPerformed());
        exitButton.addActionListener(evt -> exitButtonActionPerformed());

        // Button panel layout
        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(itemManagementButton, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(labourManagementButton, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(orderManagementButton, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(exitButton, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup()
                    .addGap(10)
                    .addComponent(itemManagementButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labourManagementButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(orderManagementButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );

        // Main panel layout
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                    .addContainerGap(50, Short.MAX_VALUE)
                    .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(20)
                    .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    // Button action methods
    private void itemManagementButtonActionPerformed() {
        ItemManagement im = new ItemManagement();
        im.setVisible(true);
        dispose();
    }

    private void labourManagementButtonActionPerformed() {
        LabourManagement lm = new LabourManagement();
        lm.setVisible(true);
        dispose();
    }

    private void orderManagementButtonActionPerformed() {
        OrderManagement om = new OrderManagement();
        om.setVisible(true);
        dispose();
    }

    private void exitButtonActionPerformed() {
        System.exit(0);
    }

    // Utility method to style buttons
    private void configureButton(JButton button) {
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setBackground(new Color(185, 122, 87)); // Warm orange background
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(new Color(165, 105, 79), 2)); // Slightly darker border
        button.setFocusPainted(false);

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(160, 85, 65)); // Darker shade
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(185, 122, 87)); // Original color
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainMenu().setVisible(true));
    }
}



