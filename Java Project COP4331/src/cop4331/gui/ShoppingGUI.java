package cop4331.gui;
import cop4331.model.*;
import cop4331.controller.ShoppingListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author mikey
 */
public class ShoppingGUI extends MainFrameGUI{
    
    private JPanel shoppingPanel;
    private JPanel topPanel;
    
    private JLabel shoppingLabel;
    
    public void createButtonEvents(){
        
    }
    
    public void createGUI(){
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("Welcome to BrosRus",1000,1000);
        
        shoppingLabel = new JLabel("Select a product you would like to view",JLabel.CENTER);
        mainFrame.add(shoppingLabel);
        
    }
    
}
