
package com.model;

/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class VehicleModel {
    
    public boolean insertVehicle(String vehicle_no, String type, String driver_name, String phone){
        
        Connection conn = Database.dbconnection();
        try{
            String query = "INSERT INTO vehicle VALUES(?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, vehicle_no);
            stm.setString(2, type);
            stm.setString(3, driver_name);
            stm.setString(4,phone);
            
            stm.executeUpdate();
            return true;
            
        }
        catch(SQLException e){
            System.out.println("Error: " + e.toString());
        }
        return false;
    }
    
    // getUser method jo getVehicle return kar rha hai
    public ResultSet getVehicle(String vehicle_no){
        ResultSet result =null;
        try{
            Connection conn = Database.dbconnection();
            String query = "SELECT *FROM vehicle where vehicle_no =? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, vehicle_no);
            result = stm.executeQuery();
            return result;
            
        }catch(SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }
        return result;
    }
    
}
