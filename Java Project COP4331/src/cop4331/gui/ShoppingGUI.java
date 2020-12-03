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
    
    private JLabel shoppingLabel;
    
    public void createButtonEvents(){
        switchButton = new JButton("Switch to seller");
        
        switchButton.setActionCommand("Switch");
        
        switchButton.addActionListener(new ShoppingListener());
    }
    
    public void createGUI(){
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("Welcome to BrosRus",1000,1000);
        accountName = new JLabel(Login.getInstance().getCurrentUser().getUserName());
        createTopPanel();
        
        shoppingLabel = new JLabel("Select a product you would like to view",JLabel.CENTER);
        mainFrame.add(shoppingLabel,c);
        
        shoppingPanel = new JPanel();
        shoppingPanel.setLayout(new GridBagLayout());
        mainFrame.add(shoppingPanel);
        
        
        
        
    }
    
}
