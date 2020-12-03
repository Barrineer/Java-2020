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
        accountButton = new JButton(Login.getInstance().getCurrentUser().getUserName());
        
        switchButton.setActionCommand("Switch");
        accountButton.setActionCommand("Account");
        
        switchButton.addActionListener(new ShoppingListener());
        accountButton.addActionListener(new ShoppingListener());
        
        switchButton.setFont(font);
        accountButton.setFont(font);
    }
    
    public void createGUI(){
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("BrosRus Application",1000,1000);
        createTopPanel();
        
        shoppingLabel = new JLabel("Select a product you would like to view",JLabel.CENTER);
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 0.9;
        c.anchor = NW;
        mainFrame.add(shoppingLabel,c);
        
        shoppingPanel = new JPanel();
        shoppingPanel.setLayout(new GridBagLayout());
        mainFrame.add(shoppingPanel);
        
        shoppingLabel.setFont(font);
        
        
    }
    
}
