
package com.model;

/**
 *
 * @author Murshad Ali
 */
import java.sql.*;
public class ReportModel {
    public ResultSet allEntries(){
        Connection conn = Database.dbconnection();
        try{
            String query= "SELECT p.id, v.vehicle_no, v.type, p.slot_id, p.entry_time, p.exit_time, p.fee FROM vehicle v JOIN parking p ON v.vehicle_no = p.vehicle_no;";
            PreparedStatement stm = conn.prepareStatement(query);
            return stm.executeQuery();
            
        }catch(SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }
}
