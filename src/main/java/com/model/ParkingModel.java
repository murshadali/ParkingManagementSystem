
package com.model;

/**
 *
 * @author Murshad Ali
 */
import java.sql.*;
public class ParkingModel {
  
   public boolean addParking(String vehicleNo, int slotId) {
         Connection conn = Database.dbconnection();
        try {
            String query = "INSERT INTO parking (vehicle_no, slot_id, entry_time) VALUES (?, ?, NOW())";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, vehicleNo);
            ps.setInt(2, slotId);

            ps.executeUpdate();

            //Update slot status
            String updateSlot = "UPDATE slot SET status='Occupied' WHERE id=?";
            PreparedStatement ps2 = conn.prepareStatement(updateSlot);
            ps2.setInt(1, slotId);
            ps2.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    public ResultSet getAllParked() {
        Connection conn = Database.dbconnection();
        try {
            String query = "SELECT * FROM parking WHERE exit_time IS NULL";
            PreparedStatement ps = conn.prepareStatement(query);
            return ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
    
   public boolean exitVehicle(String vehicleNo, double fee) {
        try {
            Connection conn = Database.dbconnection();
            // 1. Get slot_id
            String getQuery = "SELECT slot_id FROM parking WHERE vehicle_no=? AND exit_time IS NULL";
            PreparedStatement ps1 = conn.prepareStatement(getQuery);
            ps1.setString(1, vehicleNo);
            
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                int slotId = rs.getInt("slot_id");

                // 2. Update parking 
                String updateParking = "UPDATE parking SET exit_time=NOW(), fee=? WHERE vehicle_no=? AND exit_time IS NULL";
                PreparedStatement ps2 = conn.prepareStatement(updateParking);
                ps2.setDouble(1, fee);
                ps2.setString(2, vehicleNo);
                ps2.executeUpdate();

                // 3. Free slot
                String updateSlot = "UPDATE slot SET status='Available' WHERE id=?";
                PreparedStatement ps3 = conn.prepareStatement(updateSlot);
                ps3.setInt(1, slotId);
                ps3.executeUpdate();
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
   
   public ResultSet searchVehicle(String vehicle_no){
       Connection conn = Database.dbconnection();
       ResultSet result=null;
       try{
           String query = "SELECT v.vehicle_no, v.type, p.entry_time FROM vehicle v JOIN parking p ON v.vehicle_no = p.vehicle_no WHERE v.vehicle_no = ? AND p.exit_time IS NULL;";
           PreparedStatement stm = conn.prepareStatement(query);
           stm.setString(1, vehicle_no);
           result = stm.executeQuery();
       }
       catch(SQLException e){
           System.out.println("Error: int exit"+ e.getMessage());
           
       }
       return result;
   }

}

    

