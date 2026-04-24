/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author Mustafa
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class User {
    
    public boolean isLogin(String name, String password){
       Connection conn = Database.dbconnection();
       try{
             String query = "SELECT name FROM USER WHERE name=? and password=?";
       
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, name);
            stm.setString(2, password);
            ResultSet rs= stm.executeQuery();
            return rs.next();
       }
       catch(SQLException e){
           System.out.println("ERROR: " + e.getMessage());
       }
       return false;           
    }
    
}
