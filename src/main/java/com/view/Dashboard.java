
package com.view;

/**
 *
 * @author Murshad Ali
 */


import javax.swing.*;
import java.awt.*;
import com.controller.SidebarController;
import com.controller.VehicleController;
import com.controller.SlotController;
import com.controller.StatsController;
import com.controller.ReportController;

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
         // ek method banaya tha sideBarclick jime mene all button handler datle hai
         SidebarController side = new SidebarController();
         side.sideBarClick(this, sidebar, entry, stats, exit,slots, report);
         
        // stats controller
        StatsController statClr = new StatsController();
        statClr.displayStatsController(stats);
        
        
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
           
         // report controller note jo all entries bana controller hai bo sidebarController me call kiya hai
         ReportController rc = new ReportController();
         rc.generateReportController(report);
         
    }
}
