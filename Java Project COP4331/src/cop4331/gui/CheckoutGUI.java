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
    
    private JLabel checkoutLabel;
    private JLabel priceLabel;
    private JLabel paymentTypeLabel;
    
    private JTextField paymentTypeField;    
    
    private Cart cart = Login.getInstance().getCurrentUser().getCart();
    private Receipt receipt = new Receipt(cart,Login.getInstance().getCurrentUser().getUserID(),"");
    
    /**
     * Creates the button events for the Checkout GUI
     */
    public void createButtonEvents(){
        
        payButton = new JButton("Pay");
        backButton = new JButton("Back");
        
        payButton.setActionCommand("Pay");
        backButton.setActionCommand("Back");
        
        payButton.addActionListener(new CheckoutListener());
        backButton.addActionListener(new CheckoutListener());
        
        payButton.setFont(font);
        backButton.setFont(font);
    }
    /**
     * Creates the Checkout GUI
     */
    public void createGUI(){
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("BrosRus Application",1000,1000);
        
        //Checkout Label
        checkoutLabel = new JLabel("Checkout");
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.anchor = SOUTH;
        mainFrame.add(checkoutLabel,c);
        
        //Price Label
        priceLabel = new JLabel("Total Price: " + receipt.getTotal());
        c.gridy = 1;
        c.anchor = SOUTH;
        c.insets = new Insets(-SPACING,0,0,0);
        mainFrame.add(priceLabel,c);
        
        //Payment Type Label
        paymentTypeLabel = new JLabel("Enter your payment type(Check,Cash,etc.): ");
        c.gridy = 2;
        c.gridwidth = 1;
        c.anchor = NE;
        c.insets = new Insets(0,0,-SPACING,0);
        mainFrame.add(paymentTypeLabel,c);
        
        //Payment Type Field
        paymentTypeField = new JTextField(17);
        c.gridx = 1;
        c.anchor = NW;
        mainFrame.add(paymentTypeField,c);
        
        //Back Button
        c.gridy += 1;
        c.gridx = 0;
        c.gridwidth = 1;
        c.anchor = SW;
        c.insets = new Insets(0,(int)(SPACING*1.5),(int)(SPACING*1.5),0);       
        mainFrame.add(backButton,c);
        
        //Pay Button
        c.anchor = SE;
        c.gridx = 1;
        c.insets = new Insets(0,0,(int)(SPACING*1.5),(int)(SPACING*1.5));
        mainFrame.add(payButton,c);
        
        checkoutLabel.setFont(fontBiggerBold);
        priceLabel.setFont(font);
        paymentTypeLabel.setFont(font);
        paymentTypeField.setFont(font);
        
    }
    /**
     * Getter for the receipt
     * @return receipt
     */
    public Receipt getReceipt(){
        receipt.setPaymentType(paymentTypeField.getText());
        return receipt;
    }
    
}
