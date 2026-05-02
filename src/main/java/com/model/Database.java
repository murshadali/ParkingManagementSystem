
package com.model;

/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class Database {
    public static Connection conn;
    public static Connection dbconnection(){
        try{
            if(conn==null || conn.isClosed()){
            String url = "jdbc:mysql://localhost:3306/parkingdb";
            String username = "root";
            String password = "system";
            try{
                conn = DriverManager.getConnection(url,username,password);
                System.out.println("db is connected successfully");
            }
            catch(SQLException err){
                System.out.println("Erorr:"+ err.getMessage());
            }
            
            
        }
     
        }
        catch(SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }
        return conn;
    }
}
