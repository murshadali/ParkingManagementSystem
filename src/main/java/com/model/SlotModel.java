
package com.model;

/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */
import java.sql.*;
public class SlotModel {
    
   // add slot
    public boolean addSlot(String slot_no, String type){
        Connection conn  = Database.dbconnection();
        String status = "Available";
        try{
           String query = "INSERT INTO slot (slot_no,type, status) values(?,?,?)";
           PreparedStatement stm = conn.prepareStatement(query);
           stm.setString(1, slot_no);
           stm.setString(2, type);
           stm.setString(3, status);
           
           stm.executeUpdate();
           return true;
        }
        catch(SQLException e){
            System.out.println("Error: "+ e.toString());
        }
        return false;
    }
    
    // getAllSlot 
    public ResultSet getAllSlots(){
        Connection conn = Database.dbconnection();
        ResultSet result = null;
        try{
            String query = "SELECT *FROM slot";
            Statement stm = conn.createStatement();
            result = stm.executeQuery(query);
            return result;
        }
        catch(SQLException e){
            System.out.println("Error: "+ e.toString() + e.getMessage());
        }
        return result;
    }
    
    // update model
    public boolean updateSlot(int id, String slot_no, String type, String status){
        
        Connection conn = Database.dbconnection();
        try{
            String query = "UPDATE slot SET slot_no=?, type=?, status=? WHERE id=?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, slot_no);
            stm.setString(2, type);
            stm.setString(3,status);
            stm.setInt(4, id);
            stm.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return false;
    }

    // delete ke liye banata hu 
    public boolean deleteSlot(int id){
        
        Connection conn = Database.dbconnection();
        try{
            String query = "DELETE FROM slot WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id);
            
            stm.executeUpdate();
            return true;
        }
        catch(SQLException e){
            System.out.println("delete related exception occured");
        }
        
        return false;
    }
    
    public ResultSet getSotByType(String slotType){
        Connection conn = Database.dbconnection();
        try{
            String query = "select *from slot where type = ? AND status='Available'";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1,slotType);
            return stm.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Error " + e.getMessage());
        }
        return null;
        
    }
}
