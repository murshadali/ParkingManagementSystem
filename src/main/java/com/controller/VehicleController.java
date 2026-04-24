
package com.controller;

/**
 *
 * @author Murshad ali
 */

import com.model.VehicleModel;
import java.awt.event.*;
import javax.swing.*;
import com.view.Entry;
import com.view.Exit;
import com.model.SlotModel;
import com.model.ParkingModel;
import java.sql.*;
public class VehicleController {
    
    public void createVehicleController(Entry entry){
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
    
    // Exit
    public void exitVehicleController(Exit exit){
        
        ParkingModel pm = new ParkingModel();
        exit.exitBtn.addActionListener(e->{
           
            String vehicleNo = exit.vehicleNumberField.getText().toUpperCase().trim();
            
            ResultSet result = pm.searchVehicle(vehicleNo);
            
            if(result!=null){
                try{
                   if(result.next()){
                        Timestamp entryTime = result.getTimestamp("entry_time");
                        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                        
                        // calculate time diff in hours.
                        long diffMillis = currentTime.getTime() - entryTime.getTime();
                        long hours = diffMillis / (1000 * 60 * 60);

                        // minimum 1 hour charge
                        if(hours == 0){
                            hours = 1;
                        }
                        int rate = 10;
                        int amount = (int)hours*rate;
                        exit.typeValue.setText(result.getString("type"));
                        exit.timeValue.setText("" + hours);
                        exit.amount.setText("₹ " + amount);
                        result.close();
                        Double fee =  (double) amount;
                        // yaha exitvehichle pm me hai ko call ker rha hu jo boolean return karayega
                        boolean check = pm.exitVehicle(vehicleNo, fee);
                        if(!check){
                            JOptionPane.showMessageDialog(exit, "Something happened wrong");
                           
                        }
                        else{
                            String msg = "vehcle no: "+vehicleNo+"\n"+"fee: ₹"+ fee;
                            JOptionPane.showMessageDialog(exit,msg);
                        }
                    
                   }else{
                       JOptionPane.showMessageDialog(exit,"Vehicle does not exist");
                        exit.typeValue.setText("");
                        exit.timeValue.setText("");
                        exit.amount.setText("");
                   }
                }catch(SQLException err1){
                    System.out.println("Erorr: "+ err1.getMessage());
                }
                
            }

            
        });
    }
    // search event controller
    public void searchVehicleController(Exit exit){
        ParkingModel pm = new ParkingModel();
        exit.searchBtn.addActionListener(e->{
           
            String vehicleNo = exit.vehicleNumberField.getText().toUpperCase().trim();
            
            ResultSet result = pm.searchVehicle(vehicleNo);
            
            if(result!=null){
                try{
                   if(result.next()){
                        Timestamp entryTime = result.getTimestamp("entry_time");
                        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                        
                        // calculate time diff in hours.
                        long diffMillis = currentTime.getTime() - entryTime.getTime();
                        long hours = diffMillis / (1000 * 60 * 60);

                        // minimum 1 hour charge
                        if(hours == 0){
                            hours = 1;
                        }
                        int rate = 10;
                        int amount = (int)hours*rate;
                        exit.typeValue.setText(result.getString("type"));
                        exit.timeValue.setText("" + hours);
                        exit.amount.setText("₹ " + amount);
                        result.close();
                        
                        
                        
                    
                   }else{
                       JOptionPane.showMessageDialog(exit,"Vehicle does not exist");
                        exit.typeValue.setText("");
                        exit.timeValue.setText("");
                        exit.amount.setText("");
                   }
                }catch(SQLException err1){
                    System.out.println("Erorr: "+ err1.getMessage());
                }
                
            }

            
        });
    }
}
