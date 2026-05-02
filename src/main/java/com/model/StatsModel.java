
package com.model;

/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */
import java.sql.*;
public class StatsModel {
    
    public int occupiedSotCount(){
        int count = 0;

        try(Connection conn = Database.dbconnection();
            PreparedStatement stm = conn.prepareStatement(
                "SELECT COUNT(*) FROM slot WHERE status = 'Occupied'"
            );
            ResultSet rs = stm.executeQuery()){

            if(rs.next()){
                count = rs.getInt(1);
            }

        } catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }

        return count;
    }
    
    public int availableSlotCount(){
        int count = 0;

        try(Connection conn = Database.dbconnection();
            PreparedStatement stm = conn.prepareStatement(
                "SELECT COUNT(*) FROM slot WHERE status = 'available'"
            );
            ResultSet rs = stm.executeQuery()){

            if(rs.next()){
                count = rs.getInt(1);
            }

        } catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }

        return count;
    }
    // today earning
    public int todayEarning(){
            int total = 0;
            try(Connection conn = Database.dbconnection();
                PreparedStatement stm = conn.prepareStatement(
                    "SELECT SUM(fee) FROM parking WHERE DATE(exit_time) = CURDATE()"
                );
                ResultSet rs = stm.executeQuery()){

                if(rs.next()){
                    total = rs.getInt(1); // sum ya le rha hu
                }

            } catch(SQLException e){
                System.out.println("Error: " + e.getMessage());
            }
            return total;
    }
    // total earning ke liye ye method bana rha hu 
    public int totalEarning(){
            int total = 0;

            try(Connection conn = Database.dbconnection();
                PreparedStatement stm = conn.prepareStatement(
                    "SELECT SUM(fee) FROM parking WHERE exit_time IS NOT NULL"
                );
                ResultSet rs = stm.executeQuery()){

                if(rs.next()){
                    total = rs.getInt(1);
                }

            } catch(SQLException e){
                System.out.println("Error: " + e.getMessage());
            }

        return total;
    }
     
    // total vehicle today
    public int totalVehicleToday(){
            int count = 0;

            try(Connection conn = Database.dbconnection();
                PreparedStatement stm = conn.prepareStatement(
                    "SELECT COUNT(*) FROM parking WHERE DATE(entry_time) = CURDATE()"
                );
                ResultSet rs = stm.executeQuery()){

                if(rs.next()){
                    count = rs.getInt(1);
                }

            } catch(SQLException e){
                System.out.println("Error: " + e.getMessage());
            }

            return count;
            }
    

}
