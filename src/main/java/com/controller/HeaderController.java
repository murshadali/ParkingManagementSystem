
package com.controller;

/**
 *
 * @author Murshad Ali Mohammad Firdosh Alam
 */
import com.view.Header;
import com.view.Form;
import com.view.Container;
public class HeaderController {
    public void logoutController(Container container,Form form,Header header){
        header.logoutBtn.addActionListener(e->{
            System.out.println("event run");
            container.setContentPane(form);
            container.revalidate();
            container.repaint();
            
        });
    }
}
