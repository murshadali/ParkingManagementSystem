
package com.view;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */


public class Form extends JPanel {

    public JTextField name;
    public JPasswordField password;
    public JButton btn;
    public JLabel error;

    public Form() {
        setLayout(new GridBagLayout()); // center the card

        // Card Panel 
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setPreferredSize(new Dimension(300, 300));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Title
        JLabel title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Username
        JLabel label1 = new JLabel("username");
        name = new JTextField();
        name.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        // Password
        JLabel label2 = new JLabel("Password");
        password = new JPasswordField();
        password.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        
        


        // Button
        btn = new JButton("LOGIN");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setBackground(new Color(120, 80, 200));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        
        // error 
        error = new JLabel("");
       error.setForeground(Color.RED);

        // Add components
        card.add(title);
        card.add(Box.createRigidArea(new Dimension(0, 15)));

        // yaha error so kar rha hu
        card.add(error);
        
        card.add(label1);
        card.add(name);
        card.add(Box.createRigidArea(new Dimension(0, 10)));

        card.add(label2);
        card.add(password);
        card.add(Box.createRigidArea(new Dimension(0, 5)));


        card.add(btn);
        card.add(Box.createRigidArea(new Dimension(0, 15)));
        
        add(card); 
        
        setBackground(new Color(30,50,40));
    }
}
