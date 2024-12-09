package restaurantsystem.component.labour;

import restaurantsystem.MainMenu;

import javax.swing.*;
import java.awt.*;

public class LabourManagement extends javax.swing.JFrame {

    public LabourManagement() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        addLabour = new javax.swing.JButton();
        viewLabour = new javax.swing.JButton();
        deleteLabour = new javax.swing.JButton();
        updateLabour = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");
        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        // Styling for main panel (jPanel2)
        jPanel2.setBackground(new Color(253, 245, 230)); // Light beige
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        // Styling for button panel (jPanel1)
        jPanel1.setBackground(new Color(255, 255, 240)); // Soft cream background
        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Labour Management",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.BOLD, 24), new Color(185, 122, 87))); // Warm orange title

        // Style buttons for Labour Management
        configureButton(addLabour, "Add Labour");
        configureButton(viewLabour, "View Labour");
        configureButton(deleteLabour, "Delete Labour");
        configureButton(updateLabour, "Update Labour");
        configureButton(jButton6, "Back");

        jButton6.addActionListener(evt -> jButton6ActionPerformed(evt));

        // Layout setup for jPanel1 (button panel)
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addLabour, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addComponent(viewLabour, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addComponent(deleteLabour, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addComponent(updateLabour, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                    .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(addLabour, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(viewLabour, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(deleteLabour, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(updateLabour, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Layout setup for jPanel2 (main panel)
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Main layout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jPanel2, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void configureButton(JButton button, String text) {
        button.setText(text);
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenu rm = new MainMenu();
        rm.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new LabourManagement().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton addLabour;
    private javax.swing.JButton deleteLabour;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton updateLabour;
    private javax.swing.JButton viewLabour;
}

