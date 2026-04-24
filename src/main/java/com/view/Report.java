
package com.view;

/**
 *
 * @author Murshad Ali
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Report extends JPanel {

    public JTextField vehicleField;
    public JButton searchBtn, showAllBtn;
    public JTable table;
    private DefaultTableModel model;

    public Report() {
        setLayout(new BorderLayout(10,10));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //Top Pane
        JPanel top = new JPanel();

        vehicleField = new JTextField(10);
        searchBtn = new JButton("Search");
        showAllBtn = new JButton("Show All");

        top.add(new JLabel("Vehicle No:"));
        top.add(vehicleField);
        top.add(searchBtn);
        top.add(showAllBtn);

        //Table
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Vehicle No");
        model.addColumn("Type");
        model.addColumn("Slot");
        model.addColumn("Entry Time");
        model.addColumn("Exit Time");
        model.addColumn("Fee");

        table = new JTable(model);

        // Sample data
        model.addRow(new Object[]{1,"UP15AB1234","Four Wheeler","S2","10:00","12:00",100});
        model.addRow(new Object[]{2,"UP15XY5678","Two Wheeler","S1","11:00","-",0});

        //Bottom Panel 
        JPanel bottom = new JPanel();
        JLabel totalLabel = new JLabel("Total Vehicles: 2   Earnings: ₹100");
        bottom.add(totalLabel);

        // layout likha hu 
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        // search ka logic yaha hai
        searchBtn.addActionListener(e -> {
            String vehicle = vehicleField.getText().trim();

            if (vehicle.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter vehicle number");
                return;
            }

      
            for (int i = 0; i < model.getRowCount(); i++) {
                String v = model.getValueAt(i, 1).toString();

                if (!v.equalsIgnoreCase(vehicle)) {
                    table.removeRowSelectionInterval(i, i);
                } else {
                    table.setRowSelectionInterval(i, i);
                }
            }
        });
    }
}
