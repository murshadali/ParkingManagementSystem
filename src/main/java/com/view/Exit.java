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

public class Exit extends JPanel {

    public JTextField vehicleNumberField;
    public JButton searchBtn;
    public JButton exitBtn;

    // Labels to show details
    public JLabel typeValue;
    public JLabel amount;
    public JLabel timeValue;

    public Exit() {
        setLayout(new GridBagLayout());
        setBackground(new Color(240, 240, 240));

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Vehicle Exit"));
        panel.setPreferredSize(new Dimension(400, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //  Vehicle Number Input
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Vehicle Number:"), gbc);

        gbc.gridx = 1;
        vehicleNumberField = new JTextField();
        vehicleNumberField.setPreferredSize(new Dimension(100,30));
        panel.add(vehicleNumberField, gbc);

        //  Search Button
        gbc.gridx = 2;
        searchBtn = new JButton("Search");
        panel.add(searchBtn, gbc);

        //  Details
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Type:"), gbc);

        gbc.gridx = 1;
        typeValue = new JLabel("-");
        panel.add(typeValue, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("amount:"), gbc);

        gbc.gridx = 1;
        amount = new JLabel("-");
        panel.add(amount, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Time:"), gbc);

        gbc.gridx = 1;
        timeValue = new JLabel("-");
        panel.add(timeValue, gbc);
        

        //  Exit Button
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;

        exitBtn = new JButton("Exit Vehicle");
        panel.add(exitBtn, gbc);

        add(panel);
    }
    
    public void setDetails(String type, String totalamount, String time) {
        typeValue.setText(type);
        amount.setText(totalamount);
        timeValue.setText(time);
    }

    // 🔄 Get details (for JOptionPane)
    public String getDetails() {
        return "Vehicle Type: " + typeValue.getText() +
               "\nDriver Name: " + amount.getText() +
               "\nEntry Time: " + timeValue.getText();
    }
}