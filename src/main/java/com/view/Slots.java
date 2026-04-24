/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view;

/**
 *
 * @author Murshad Ali
 */
 
import com.controller.SlotController;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Slots extends JPanel {

    public DefaultTableModel model;
    public JTable table;
    public JButton addBtn, updateBtn,deleteBtn;

    public Slots() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        // Table Model
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Slot No");
        model.addColumn("Type");
        model.addColumn("Status");


        table = new JTable(model);

        // Top Panel
        JPanel topPanel = new JPanel();

        addBtn = new JButton("Add Slot");
        updateBtn = new JButton("Update Status");
        deleteBtn = new JButton("Delete");
        deleteBtn.setFocusPainted(false);

        topPanel.add(addBtn);
        topPanel.add(updateBtn);
        topPanel.add(deleteBtn);

        //  Add components
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        

    }
}