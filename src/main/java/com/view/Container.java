///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.view;
//import javax.swing.*;
//import java.awt.*;
//import com.view.Form;
///**
// *
// * @author Mustafa
// */
//public class Container extends JFrame {
//   public Container(){
//       
//       setSize(500,400);
//       
////     getDefaultCloseOperation(JFrame.EXIT_ON_CLOSE )
//        Form form = new Form();
//        
//        setTitle("testing");
//       setLayout(new BorderLayout());
//       add(form, BorderLayout.CENTER);
//       setVisible(true);
//   }
//    
//}


package com.view;

import javax.swing.*;
import java.awt.*;
import com.controller.UserController;
public class Container extends JFrame {
    public Container(){
        Form f = new Form();
        
        setMinimumSize(new Dimension(500, 400));
        UserController userCon = new UserController();
        userCon.loginController(f,this);
        
        setLayout(new BorderLayout());
        add(f,BorderLayout.CENTER);
        setVisible(true);
    }
}