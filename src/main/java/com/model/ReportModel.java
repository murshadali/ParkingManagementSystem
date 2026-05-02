
package com.model;
/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */
import java.sql.*;
public class ReportModel {
    //all report
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
    // totalEarning
    public int totalEarning(){
            int total = 0;

            try(Connection conn = Database.dbconnection();
                PreparedStatement stm = conn.prepareStatement(
                    "SELECT SUM(fee) FROM parking WHERE exit_time IS NOT NULL"
                );
                ResultSet rs = stm.executeQuery()){

                if(rs.next()){
                    total = rs.getInt(1);
                    if(rs.wasNull()){  // handle NULL sum
                        total = 0;
                    }
                }

            } catch(SQLException e){
                System.out.println("Error: " + e.getMessage());
            }

            return total;
    }
    
    //today earing
    public int todayEarning(){
        int total = 0;

            try(Connection conn = Database.dbconnection();
                PreparedStatement stm = conn.prepareStatement(
                    "SELECT SUM(fee) FROM parking WHERE DATE(exit_time) = CURDATE()"
                );
                ResultSet rs = stm.executeQuery()){

                if(rs.next()){
                    total = rs.getInt(1);
                    if(rs.wasNull()){  // handle NULL sum
                        total = 0;
                    }
                }

            } catch(SQLException e){
                System.out.println("Error: " + e.getMessage());
            }

            return total;
        
    }
    
    // today total vehicle
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
    
    // totalvehicle 
    
    public int totalVehicle(){
            int count = 0;

            try(Connection conn = Database.dbconnection();
                PreparedStatement stm = conn.prepareStatement(
                    "SELECT COUNT(*) FROM parking"
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
    
    public int pardkedVehicle(){
            int count = 0;

            try(Connection conn = Database.dbconnection();
                PreparedStatement stm = conn.prepareStatement(
                    "SELECT COUNT(*) FROM parking where exit_time = NULL"
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
