package com.controller;

/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */
import java.sql.*;
//import javax.swing.table.DefaultTableModel;
import com.view.Slots;
import com.model.SlotModel;
import javax.swing.JOptionPane;


public class SlotController {
   // get all slot jab slots button click karenge to ye mene event handler me daal diya hai; 
    public void allSlotsController(Slots slots){
       SlotModel sm = new SlotModel();
       
       ResultSet result = sm.getAllSlots();
       if(result !=null){
         
           
           try{
               // pehle me jitni bhi rows hai unhe null ker de rha hu;
                slots.model.setRowCount(0);
                 while (result.next()) {

                Object[] rowData = new Object[4];

                for (int col=0; col < 4; col++) {
                    rowData[col] = result.getString(col + 1);
                }
                
                slots.model.addRow(rowData);
            }
           }catch(SQLException e){
              System.out.println("Error: "+ e.getMessage());
           }
         
           
        }
      }
   
    public void updateSlotController(Slots slots) {

        slots.updateBtn.addActionListener(e -> {

            int row = slots.table.getSelectedRow();

        
            if (row == -1) {
                JOptionPane.showMessageDialog(slots, "Please select a row first!");
                return;
            }

            try {
                if (slots.table.isEditing()) {
                    slots.table.getCellEditor().stopCellEditing();
                }
                int id = Integer.parseInt(slots.model.getValueAt(row, 0).toString());
                String slot_no = slots.model.getValueAt(row, 1).toString();
                String type = slots.model.getValueAt(row, 2).toString();
                String status = slots.model.getValueAt(row, 3).toString();

                SlotModel sm = new SlotModel();
                boolean res = sm.updateSlot(id, slot_no, type, status);

                if (res) {
                    JOptionPane.showMessageDialog(slots, "Row updated successfully");
                } else {
                    JOptionPane.showMessageDialog(slots, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(slots, "Error: " + ex.getMessage());
            }
        });
    }
//    add slot : yaha add kerne ka code likha hu jisme do slot_no type pass ker rha hu model me
    public void addSlotController (Slots slots){
     
        slots.addBtn.addActionListener(e->{
            
            String slot_no = JOptionPane.showInputDialog("Enter Slot Number:");
            String type = JOptionPane.showInputDialog("Enter Type (Two/Four Wheeler):");
            if(!slot_no.equals("") && !type.equals("")){
                System.out.println(slot_no +" "+type );
                SlotModel sm = new SlotModel();
                boolean rs = sm.addSlot(slot_no, type);
                if(rs){
                    JOptionPane.showMessageDialog(slots, "Slot added Successfullly!" );
                }
                else{
                    JOptionPane.showMessageDialog(slots, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
        });
        
     }
//    delete slot : yaha model ko kebal id de rha hu taki query run kerke delete ker sku;
    public void deleteSlotController(Slots slots){
        
        slots.deleteBtn.addActionListener(e->{
            
            int row = slots.table.getSelectedRow();
            if(row ==-1){
                JOptionPane.showMessageDialog(slots, "Select Row to Delete!");
            }
            int id = Integer.parseInt(slots.model.getValueAt(row, 0).toString());
            SlotModel sm = new SlotModel();
            
            // confirmation le rha hu JOptionPane.YES_OPTION,JOptionPane.CANCEL_OPTION
            int choice = JOptionPane.showConfirmDialog(slots,"do you wanna to delete this slot!","choice yes or no",JOptionPane.YES_NO_CANCEL_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                boolean result = sm.deleteSlot(id);
                if(result){
                    JOptionPane.showMessageDialog(slots, "Slot Deleted successfully!");
                    slots.model.removeRow(row);
                }
                else{
                    JOptionPane.showMessageDialog(slots, "Something happened wrong!", "ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        
        
    }
    
}

   

