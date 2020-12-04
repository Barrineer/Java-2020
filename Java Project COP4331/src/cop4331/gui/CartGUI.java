package cop4331.gui;
import cop4331.model.*;
import cop4331.controller.CartListener;
import cop4331.controller.InventoryListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author mikey
 */
public class CartGUI extends MainFrameGUI{
    
    private JButton backButton;
    private JButton checkoutButton;
    
    public void createButtonEvents(){
        backButton = new JButton("Back");
        checkoutButton = new JButton("Checkout");
        
        backButton.setActionCommand("Back");
        checkoutButton.setActionCommand("Checkout");
        
        backButton.addActionListener(new CartListener());
        checkoutButton.addActionListener(new CartListener());
    }
    
    public void createGUI(){
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("BrosRus Application",1000,1000);
        
        //Back Button
        c.weightx = 1;
        c.weighty = 1;
        c.anchor = SW;
        c.insets = new Insets(0,30,30,0);
        mainFrame.add(backButton,c);
        
        //Checkout Button
        c.anchor = SE;
        c.insets = new Insets(0,0,30,30);
        mainFrame.add(checkoutButton,c);        
    }
    
}
