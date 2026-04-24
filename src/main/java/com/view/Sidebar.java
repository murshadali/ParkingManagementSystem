/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view;

/**
 *
 * @author Mustafa
 */


import javax.swing.*;
import java.awt.*;

public class Sidebar extends JPanel {

    public JButton statsBtn;
    public JButton entryBtn;
    public JButton exitBtn;
    public JButton slotsBtn;
    public JButton reportBtn;

    public Sidebar() {
        setLayout(new GridLayout(6, 1, 10, 10)); // vertical menu
        setBackground(new Color(30, 40, 60));
        setPreferredSize(new Dimension(200, 0)); // width of sidebar

        // Buttons
        statsBtn = createButton("Dashboard");
        entryBtn = createButton("New Entry");
        exitBtn = createButton("Exit Vehicle");
        slotsBtn = createButton("Slots");
        reportBtn = createButton("Reports");

        // Add components
        
        add(statsBtn);
        add(entryBtn);
        add(exitBtn);
        add(slotsBtn);
        add(reportBtn);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(50, 70, 100));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.PLAIN, 14));
        btn.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        return btn;
    }
}
