
package com.view;

/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */




import javax.swing.*;
import java.awt.*;

public class Stats extends JPanel {

    private JLabel totalVehiclesValue;
    private JLabel availableSlotsValue;
    private JLabel occupiedSlotsValue;
    private JLabel totalEarningsValue;

    public Stats() {
        setLayout(new GridLayout(2, 2, 20, 20)); 

        add(createBox("Total Vehicles Today", totalVehiclesValue = new JLabel("0")));
        add(createBox("Available Slots", availableSlotsValue = new JLabel("0")));
        add(createBox("Occupied Slots", occupiedSlotsValue = new JLabel("0")));
        add(createBox("Total Earnings", totalEarningsValue = new JLabel("₹0")));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
//        setPreferredSize(new Dimension(Integer.MAX_VALUE,0));
    }

    private JPanel createBox(String title, JLabel valueLabel) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(104, 173, 161));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        valueLabel.setFont(new Font("Arial", Font.BOLD, 24));

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(valueLabel, BorderLayout.CENTER);
        panel.setMaximumSize(new Dimension(300,300));
        return panel;
    }

    // Update methods
    public void setTotalVehicles(int count) {
        totalVehiclesValue.setText(String.valueOf(count));
    }

    public void setAvailableSlots(int count) {
        availableSlotsValue.setText(String.valueOf(count));
    }

    public void setOccupiedSlots(int count) {
        occupiedSlotsValue.setText(String.valueOf(count));
    }

    public void setTotalEarnings(double amount) {
        totalEarningsValue.setText("₹" + amount);
    }
}