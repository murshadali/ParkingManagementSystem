
package com.view;
/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */
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