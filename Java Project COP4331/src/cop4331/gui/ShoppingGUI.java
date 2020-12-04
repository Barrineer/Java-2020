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
        
    private JButton cartButton;
    
    private JLabel shoppingLabel;
    
    public void createButtonEvents(){
        switchButton = new JButton("Switch to seller");
        accountButton = new JButton(Login.getInstance().getCurrentUser().getUserName());
        cartButton = new JButton("Go to Cart");
        
        switchButton.setActionCommand("Switch");
        accountButton.setActionCommand("Account");
        cartButton.setActionCommand("Cart");
        
        switchButton.addActionListener(new ShoppingListener());
        accountButton.addActionListener(new ShoppingListener());
        cartButton.addActionListener(new ShoppingListener());
        
        switchButton.setFont(font);
        accountButton.setFont(font);
        cartButton.setFont(font);
    }
    
    public void createGUI(){
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("BrosRus Application",1000,1000);
        createTopPanel();
        
        c.anchor = NE;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridx = 99;
        c.insets = new Insets(3,0,0,0);
        mainFrame.add(cartButton,c);
        
        shoppingLabel = new JLabel("Select a product you would like to view",JLabel.CENTER);
        c.gridy = 1;
        c.gridx = 0;
        c.weightx = 1;
        c.weighty = 0.9;
        c.anchor = NW;
        c.insets = new Insets(3,3,3,0);
        mainFrame.add(shoppingLabel,c);

        
        shoppingLabel.setFont(font);        
        
    }
    
}
