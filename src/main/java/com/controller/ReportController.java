
package com.controller;

/**
 *
 * @author Murshad Ali
 */
import com.model.ReportModel;
import com.view.Report;
import java.sql.*;
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
                
            }
        }
    }
}
