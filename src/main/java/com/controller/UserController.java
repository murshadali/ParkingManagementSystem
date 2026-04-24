
package com.controller;

/**
 *
 * @author Murshad Ali
 */
import com.model.User;
import com.view.Form;
import java.awt.event.*;
import javax.swing.JOptionPane;

import com.view.Container;
import com.view.Dashboard;

public class UserController {
    public Form form;
    public User user ;
    public Dashboard dashboard;
    public Container container;
    public void loginController(Form f,Container container){
        form = f;
        this.container=container;
        // user model hai iska name change krna hia
        user = new User();
        boolean isLogin = true;
        f.btn.addActionListener(new ActionListener(){
            
        @Override
        public void actionPerformed(ActionEvent e){
            String pass = new String(f.password.getPassword());
            String name = f.name.getText();
            if(!name.isEmpty()){
                if(user.isLogin(name, pass)){
                JOptionPane.showMessageDialog(f,"Login Successfully!");
                f.name.setText("");
                f.password.setText("");
                pass= "";
                name= "";
                dashboard = new Dashboard();
                container.setContentPane(dashboard);
                container.revalidate();
                container.repaint();
                // add loutController: yaha logout controller call kera diya hat taki ye dashbord ke badd aye
                HeaderController hc = new HeaderController();
                hc.logoutController(container, form, dashboard.header);
                
                }
                else{
                f.error.setText("Invalid Credential");
                }
                
            }
            else{
                f.error.setText("Enter username");
            }
            
            
            f.name.setText("");
            f.password.setText("");
        }
        
    });   
       
    }

//    public void logoutController(){
//        
//        
//        if(dashboard !=null){
//            
//        }
//        
//    }
}
