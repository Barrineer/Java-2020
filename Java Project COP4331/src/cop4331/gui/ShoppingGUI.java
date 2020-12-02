package cop4331.gui;
import cop4331.controller.ShoppingListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author mikey
 */
public class ShoppingGUI {
    
    private JFrame shoppingFrame;
    private JPanel shoppingPanel;
    private JPanel topPanel;
    
    private JLabel shoppingLabel;
    
    private static ShoppingGUI instance = new ShoppingGUI();
    
    private ShoppingGUI(){
        createButtonEvents();
        createShoppingGUI();
    }
    
    public static ShoppingGUI getInstance(){
        return instance;
    }
    
    private void createButtonEvents(){
        
    }
    
    private void createShoppingGUI(){
        GridBagConstraints c = new GridBagConstraints();
        shoppingFrame = new JFrame("Welcome to BrosRus");
        shoppingFrame.setSize(1000,1000);
        shoppingFrame.setLayout(new GridBagLayout());
        
        shoppingLabel = new JLabel("Select a product you would like to view",JLabel.CENTER);
        shoppingFrame.add(shoppingLabel);
        
        shoppingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        shoppingFrame.setVisible(true);
    }
    
}
