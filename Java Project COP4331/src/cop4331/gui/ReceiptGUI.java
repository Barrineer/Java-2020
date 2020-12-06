package cop4331.gui;
import cop4331.model.*;
import cop4331.controller.ReceiptListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author mikey, Joseph
 */
public class ReceiptGUI extends MainFrameGUI{
    
    private JLabel receiptLabel;
    private JLabel orderIDLabel;
    private JLabel paymentTypeLabel;
    private JLabel finalPriceLabel;
    
    private JButton returnButton;
    
    private Receipt receipt;
    
    public ReceiptGUI(Receipt receipt){
        this.receipt = receipt;
    }
    /**
     * Creates the button events for the Receipt GUI
     */
    public void createButtonEvents(){
    
        returnButton = new JButton("Return");
        
        returnButton.setActionCommand("Return");
        
        returnButton.addActionListener(new ReceiptListener());
        
        returnButton.setFont(font);    
    }
    /**
     * Creates GUI for Receipt GUI
     */
    public void createGUI(){
    
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("BrosRus Application",1000,1000);
        
        //Receipt Label
        receiptLabel = new JLabel(Login.getInstance().getCurrentUser().getUserName() + " Receipt");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.anchor = CENTER;
        mainFrame.add(receiptLabel,c);
        
        //Order ID Label
        orderIDLabel = new JLabel("Order ID: " + receipt.getCheckoutID());
        c.gridy = 1;
        c.anchor = NORTH;
        c.insets = new Insets(0,0,-SPACING,0);
        mainFrame.add(orderIDLabel,c);
        
        //Payment Type Label
        paymentTypeLabel = new JLabel("Payment Type: " + receipt.getPaymentType());
        c.gridy = 2;
        c.insets = new Insets(-SPACING,0,0,0);
        mainFrame.add(paymentTypeLabel,c);
        
        //Final Price Label
        finalPriceLabel = new JLabel("Total Price: " + Double.toString(receipt.getTotal()));
        c.gridy = 3;
        c.insets = new Insets(-SPACING*2,0,0,0);
        mainFrame.add(finalPriceLabel,c);
        
        //Return Button
        c.gridy = 4;
        c.insets = new Insets(-SPACING*3,0,0,0);
        mainFrame.add(returnButton,c);
    
        receiptLabel.setFont(fontBiggerBold);
        orderIDLabel.setFont(fontBold);
        paymentTypeLabel.setFont(fontBold);
        finalPriceLabel.setFont(fontBold);
        returnButton.setFont(font);
        
    }
    
}
