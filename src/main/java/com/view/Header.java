
package com.view;

/**
 *
 * @author Murshad ali Mohammad Firdosh Alam
 */

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {

    public JButton logoutBtn;

    public Header() {
        setLayout(new BorderLayout());
        setBackground(new Color(40, 50, 70));
        setPreferredSize(new Dimension(0, 60)); // height of header

        // Left side title
        JLabel title = new JLabel("Parking Management System");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));

        // Right side logout button
        logoutBtn = new JButton("Logout");
        logoutBtn.setFocusPainted(false);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(40, 50, 70));
        rightPanel.add(logoutBtn);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));

        add(title, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    
    public JButton getLogoutButton() {
        return logoutBtn;
    }
}
