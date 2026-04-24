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
import com.controller.SidebarController;
import com.controller.VehicleController;
import com.controller.SlotController;

public class Dashboard extends JPanel {
    public JPanel centerpanel;
    public Header header;
    public Dashboard() {
        Sidebar sidebar = new Sidebar();
        Entry entry = new Entry();
        Exit exit = new Exit();
        Stats stats = new Stats();
        Report report = new Report();
        header = new Header();
        
//        Report report = new Report();
        Slots slots = new Slots();
        setLayout(new BorderLayout());
        
        add(sidebar,BorderLayout.WEST);
        add(header,BorderLayout.NORTH);
        centerpanel = new JPanel();
        centerpanel.setLayout(new BorderLayout());
        
        centerpanel.add(stats);
        add(centerpanel,BorderLayout.CENTER);
        
//        add(new Entry(),BorderLayout.CENTER);
//          add(new Stats(), BorderLayout.CENTER);

        // 
        
         
         // controller here
         
         // sidebar controller pass krunga dashboard object , sidebar ka object, entry ,stats, exit, slots, report
         SidebarController side = new SidebarController();
         side.sideBarClick(this, sidebar, entry, stats, exit,slots, report);
         //vehicle controller
         
         VehicleController vc = new VehicleController();
         vc.createVehicleController(entry);
         vc.exitVehicleController(exit);
         vc.searchVehicleController(exit);
         
         // slot controllers method
         SlotController sc = new SlotController();
//         sc.allSlots(slots);
           sc.updateSlotController(slots);
           sc.addSlotController(slots);
           sc.deleteSlotController(slots);
           
         
         
    }
}
