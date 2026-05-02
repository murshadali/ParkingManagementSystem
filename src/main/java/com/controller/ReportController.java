
package com.controller;

/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */
import com.model.ReportModel;
import com.view.Report;
import java.sql.*;
import javax.swing.JOptionPane;
public class ReportController {
    public void allentriesController(Report report){
         
        ReportModel rm = new ReportModel();
        ResultSet result=  rm.allEntries();
        if(result!=null){
            try{
                report.model.setRowCount(0);
                 while (result.next()) {

                Object[] rowData = new Object[7];

                for (int col=0; col < 7; col++) {
                    rowData[col] = result.getString(col + 1);
                }
                
                report.model.addRow(rowData);
                }
            }
            catch(SQLException e){
                
            }finally{
                int totalearning = rm.totalEarning();
                int totalvehicle = rm.totalVehicle();
                report.totalEarningLabel.setText("Total Earning: "+totalearning);
                report.totalVehicleLabel.setText("Total Vehicles: "+totalvehicle);
            }
        }
    }
    
    public void generateReportController(Report report){
        report.genReportBtn.addActionListener(e->{
             ReportModel rm = new ReportModel();
             int totalEarning =rm.totalEarning();
             int todayEarning =rm.todayEarning();
             int todayVehicle = rm.totalVehicleToday();
             int totalVehicle = rm.totalVehicle();
             int parkedVehicle = rm.pardkedVehicle();
           
             String msg = "Total Vehicle: "+ totalVehicle+ "\nToday Entries: "+ todayVehicle+ "\nTotal Earning: "+ totalEarning+ "\nToday Earning: "+ todayEarning+ "\nParked Vehicle: "+parkedVehicle;
             JOptionPane.showMessageDialog(report,msg );
            
        });
    }
}
