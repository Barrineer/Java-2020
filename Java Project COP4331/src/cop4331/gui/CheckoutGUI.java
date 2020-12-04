package cop4331.gui;
import cop4331.model.*;
import cop4331.controller.CheckoutListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author mikey
 */
public class CheckoutGUI extends MainFrameGUI{
    
    private JButton payButton;
    private JButton backButton;
    
    private JLabel cartLabel;
    
    public void createButtonEvents(){
        
        payButton = new JButton("Pay");
        backButton = new JButton("Back");
        
        payButton.setActionCommand("Pay");
        backButton.setActionCommand("Back");
        
        payButton.addActionListener(new CheckoutListener());
        backButton.addActionListener(new CheckoutListener());
    }
    
    public void createGUI(){
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("BrosRus Application",1000,1000);
        User user = Login.getInstance().getCurrentUser();
        
        cartLabel = new JLabel(user.getUserName() + " Personal Cart");
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.anchor = SOUTH;
        mainFrame.add(cartLabel,c);
        
        //Back Button
        c.anchor = SW;
        c.gridy = 1;
        c.gridwidth = 1;        
        mainFrame.add(backButton,c);
        
        //Pay Button
        c.anchor = SE;
        c.gridx = 1;
        mainFrame.add(payButton,c);
        
        cartLabel.setFont(fontBiggerBold);
        payButton.setFont(font);
        backButton.setFont(font);
    }
    
}
