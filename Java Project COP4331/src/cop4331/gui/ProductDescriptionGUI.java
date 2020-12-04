package cop4331.gui;
import cop4331.controller.ProductDescriptionListener;
import cop4331.model.*;
import cop4331.controller.ReceiptListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author mikey
 */
public class ProductDescriptionGUI extends MainFrameGUI{
    
    private JButton backButton;
    
    public void createButtonEvents(){
    
        backButton = new JButton("Back");
        
        backButton.setActionCommand("Back");
        
        backButton.addActionListener(new ProductDescriptionListener());
        
        backButton.setFont(font);
        
    }
    
    public void createGUI(){
    
        
        
    }
    
}
