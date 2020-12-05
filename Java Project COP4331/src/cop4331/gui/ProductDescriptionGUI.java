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
 * @author mikey, malcolm
 */
public class ProductDescriptionGUI extends MainFrameGUI{
    
    private JLabel productHeadingLabel;
    
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel priceLabel;
    private JLabel quantityLabel;
    private JLabel addressLabel;
    private JLabel quantitySelectionLabel;
    
    private JTextField quantitySelectionField;
    
    private JButton backButton;
    private JButton addButton;
    private JButton removeButton;
    
    
    private Product product;
    
    public ProductDescriptionGUI(Product product){
        this.product = product;
    }
    
    
    public void createButtonEvents(){
    
        backButton = new JButton("Back");
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        
        backButton.setActionCommand("Back");
        addButton.setActionCommand("Add");
        removeButton.setActionCommand("Remove");
        
        backButton.addActionListener(new ProductDescriptionListener());
        addButton.addActionListener(new ProductDescriptionListener());
        removeButton.addActionListener(new ProductDescriptionListener());
        
        backButton.setFont(font);
        addButton.setFont(font);
        removeButton.setFont(font);
        
    }
    
    public void createGUI(){
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("BrosRus Application",1000,1000);
        User user = Login.getInstance().getCurrentUser();
        
        productHeadingLabel = new JLabel("View Product Description");
        c.weightx = 1;
        c.weighty = 1;
        c.gridy = 0;
        c.gridx = 0;
        c.anchor = CENTER;
        mainFrame.add(productHeadingLabel,c);
        
        nameLabel = new JLabel("Name: " + product.getName());
        c.gridy += 1;
        c.gridwidth = 1;
        mainFrame.add(nameLabel,c);
        
        descriptionLabel = new JLabel(product.getDesc()) ;
        c.gridy += 1;
        mainFrame.add(descriptionLabel, c);

        priceLabel = new JLabel("Price: $" + String.valueOf(product.getPrice()));
        c.gridy += 1;
        mainFrame.add(priceLabel, c);
        
        quantityLabel = new JLabel("Quantity: " + Double.toString(product.getQuantity()));
        c.gridy += 1;
        mainFrame.add(quantityLabel,c);
        
        addressLabel = new JLabel("Address: " + product.getAdress());
        c.gridy += 1;
        mainFrame.add(addressLabel,c);

        //Only insert the Add Button and Quantity Text Field if Account Type is Buyer
        if(user.getAccountType().equals("Buyer")){
            //Quantity Label
            quantitySelectionLabel = new JLabel("Quantity to add: ");
            c.gridy += 1;
            c.gridwidth = 1;
            c.insets = new Insets(-SPACING,0,0,0);
            mainFrame.add(quantitySelectionLabel,c);
            
            //Quantity Field
            c.gridy += 1;
            quantitySelectionField = new JTextField(5);
            quantitySelectionField.setText("1");
            mainFrame.add(quantitySelectionField,c);
            
            //Add Button
            c.gridy += 1;
            c.gridx = 0;
            c.anchor = CENTER;
            c.insets = new Insets(-SPACING*2,0,0,0);
            mainFrame.add(addButton,c);
            
            quantitySelectionLabel.setFont(font);
            quantitySelectionField.setFont(font);
            
        }
        //Insert Edit Button Instead
        else{
            //Edit Button
            c.gridy += 1;
            c.gridwidth = 2;
            c.anchor = CENTER;
            c.insets = new Insets(-SPACING,0,0,0);
            mainFrame.add(removeButton,c);
        }
        
        //Back Button
        c.gridy += 1;
        c.gridx = 0;
        c.gridwidth = 1;
        c.anchor = SW;
        c.insets = new Insets(0,(int)(SPACING*1.5),(int)(SPACING*1.5),0);
        mainFrame.add(backButton,c);
        
        productHeadingLabel.setFont(fontBiggerBold);
        nameLabel.setFont(fontBold);
        descriptionLabel.setFont(fontBold);
        priceLabel.setFont(fontBold);
        quantityLabel.setFont(fontBold);
        addressLabel.setFont(fontBold);
        quantitySelectionLabel.setFont(fontBold);
        quantitySelectionField.setFont(font);
        
    }
    
    public Product getProduct(){
        return product;
    }
    
    public int getQuantity(){
        return Integer.parseInt(quantitySelectionField.getText());
    }
    
    public void setQuantityLabel(String text){
        quantitySelectionLabel.setText(text);
    }
    
}
