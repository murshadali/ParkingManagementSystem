
package com.controller;

/**
 *
 * @author Murshad Ali
 */
import com.view.Dashboard;
import com.view.Entry;
import com.view.Exit;
import com.view.Stats;
import com.view.Sidebar;
import com.view.Slots;
import com.view.Report;
import java.awt.BorderLayout;
import java.awt.event.*;
public class SidebarController {
    
    public void sideBarClick(Dashboard dashboard,Sidebar sidebar, Entry entry, Stats stats, Exit exit, Slots slots, Report report )
    {
        sidebar.statsBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // stats display java dashbord per click karu tu
                StatsController statClr = new StatsController();
                statClr.displayStatsController(stats);
                // rediplay panel
                dashboard.centerpanel.removeAll();
                
                dashboard.centerpanel.add(stats,BorderLayout.CENTER);
                dashboard.centerpanel.revalidate();
                dashboard.centerpanel.repaint();
            }
        });
        
        
        sidebar.exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dashboard.centerpanel.removeAll();
                System.out.println("hello");
                   
                  dashboard.centerpanel.add(exit, BorderLayout.CENTER);
                  dashboard.revalidate();
                  dashboard.repaint();
            }
        });
        sidebar.entryBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dashboard.centerpanel.removeAll();
                   
                  dashboard.centerpanel.add(entry, BorderLayout.CENTER);
                  dashboard.revalidate();
                  dashboard.repaint();
            }
        });
        
        sidebar.slotsBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dashboard.centerpanel.removeAll();
                System.out.println("hello");
                        SlotController sc = new SlotController();
                        sc.allSlotsController(slots);
                  dashboard.centerpanel.add(slots, BorderLayout.CENTER);
                  dashboard.revalidate();
                  dashboard.repaint();
                  
            }
        });
        
        
        sidebar.reportBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // ya per report banala controller call kiya hai so that button click per value aaye
                ReportController rc = new ReportController();
                rc.allentriesController(report);
                
                
                dashboard.centerpanel.removeAll();
                System.out.println("hello");
                   
                  dashboard.centerpanel.add(report, BorderLayout.CENTER);
                  dashboard.revalidate();
                  dashboard.repaint();
            }
        });
        
        
        
        
       
    }
}
