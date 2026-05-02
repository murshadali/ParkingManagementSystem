
package com.view;

/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */
import javax.swing.*;
import java.awt.*;

public class Entry extends JPanel {

    public JTextField vehicleNumberField;
    public JComboBox<String> vehicleTypeBox;
    public JTextField driverNameField;
    public JTextField phoneField;
    public JButton submitBtn;

    public Entry() {
        setLayout(new GridBagLayout()); 
        setBackground(new Color(240, 240, 240));

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);
        form.setBorder(BorderFactory.createTitledBorder("Vehicle Entry"));
        form.setPreferredSize(new Dimension(400, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Vehicle Number
        gbc.gridx = 0; gbc.gridy = 0;
        form.add(new JLabel("Vehicle Number:"), gbc);

        gbc.gridx = 1;
        vehicleNumberField = new JTextField();
        form.add(vehicleNumberField, gbc);

        // Vehicle Type
        gbc.gridx = 0; gbc.gridy = 1;
        form.add(new JLabel("Vehicle Type:"), gbc);

        gbc.gridx = 1;
        vehicleTypeBox = new JComboBox<>(new String[]{
                "Two Wheeler", "Four Wheeler"
        });
        form.add(vehicleTypeBox, gbc);

        //Driver Name
        gbc.gridx = 0; gbc.gridy = 2;
        form.add(new JLabel("Driver Name:"), gbc);

        gbc.gridx = 1;
        driverNameField = new JTextField();
        form.add(driverNameField, gbc);

        // Phone Number
        gbc.gridx = 0; gbc.gridy = 3;
        form.add(new JLabel("Phone Number:"), gbc);

        gbc.gridx = 1;
        phoneField = new JTextField();
        form.add(phoneField, gbc);

        //Button
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        submitBtn = new JButton("Add Entry");
        form.add(submitBtn, gbc);

        add(form); 
    }
}
