/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

/**
 *
 * @author Mustafa
 */

import com.model.VehicleModel;
import java.awt.event.*;
import javax.swing.*;
import com.view.Entry;
import com.model.SlotModel;
import com.model.ParkingModel;
import java.sql.*;
public class VehicleController {
    
    public void createVehicle(Entry entry){
        VehicleModel vm = new VehicleModel();
        SlotModel sm = new SlotModel();
        ParkingModel pm = new ParkingModel();
        
       entry.submitBtn.addActionListener(e->{
           
            String vehicle_no = entry.vehicleNumberField.getText();
            String type = entry.vehicleTypeBox.getSelectedItem().toString();
            String driver_name = entry.driverNameField.getText();
            String phone = entry.phoneField.getText();
           if(!vehicle_no.equals("") && !type.equals("") && !driver_name.equals("") && !phone.equals("")){
           boolean result = vm.insertVehicle(vehicle_no, type, driver_name, phone);
           if(result){
              
                try{
                    
                    /// slot id ke liye type ka slote return kerba rha hu
                     ResultSet slot = sm.getSotByType(type);
                   int slot_id=-1 ;
                   while(slot.next()){
                       slot_id = slot.getInt(1);
                   }
                   if(slot_id<0){
                       JOptionPane.showMessageDialog(entry, "Slot is not available");
                       return;
                   }
                   pm.addParking(vehicle_no, slot_id);
                   String msg = "Vehicle NO: "+ vehicle_no+ "\n"+"Type: " +type +"\nDriver Name: "+ driver_name+"\nPhone NO: "+ phone+ "\n\n\nPRINT Slip";
                  
                   JOptionPane.showMessageDialog(entry,msg);
                }catch(SQLException err){
                    System.out.println("Error " +err.getMessage());
                }
                finally{
                    
                        entry.driverNameField.setText("");
                        entry.phoneField.setText("");
                        entry.vehicleNumberField.setText("");
                        vehicle_no = "";
                        phone = "";
                        driver_name = "";
                        type = "";
                }
           }
       }
           
       });
      
            
      
       
       
       
    }
    
}
