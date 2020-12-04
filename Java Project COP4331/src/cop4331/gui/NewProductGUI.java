package cop4331.gui;
import cop4331.model.*;
import cop4331.controller.InventoryListener;
import cop4331.controller.NewProductListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author mikey
 */
public class NewProductGUI extends MainFrameGUI{
    
    private JLabel newProductLabel;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel priceLabel;
    private JLabel quantityLabel;
    private JLabel addressLabel;
    private JLabel detailLabel;
    
    private JTextField nameField;
    private JTextArea descriptionField;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextField addressField;
    
    private JButton addButton;
    private JButton backButton;
    
    public void createButtonEvents(){
        
        addButton = new JButton("Add");
        backButton = new JButton("Back");
        
        addButton.setActionCommand("Add");
        backButton.setActionCommand("Back");
        
        addButton.addActionListener(new NewProductListener());
        backButton.addActionListener(new NewProductListener());
        
        addButton.setFont(font);
        backButton.setFont(font);
        
    }
            
    public void createGUI(){
        createNewFrame("BrosRus Application",1000,1000);
        GridBagConstraints c = new GridBagConstraints();
        
        //New Product Label
        newProductLabel = new JLabel("Create a new product");
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.anchor = CENTER;
        mainFrame.add(newProductLabel,c);
        
        //Name Label
        nameLabel = new JLabel("Product Name: ");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = NE;
        c.insets = new Insets(0,0,-SPACING,0);
        mainFrame.add(nameLabel,c);
        
        //Name Field
        nameField = new JTextField(17);
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = NW;
        mainFrame.add(nameField,c);
        
        //Price Label
        priceLabel = new JLabel("Product Price: ");
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = NE;
        c.insets = new Insets(-SPACING,0,0,0);
        mainFrame.add(priceLabel,c);
        
        //Price Field
        priceField = new JTextField(17);
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = NW;
        mainFrame.add(priceField,c);
        
        //Quantity Label
        quantityLabel = new JLabel("Product Quantity: ");
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = NE;
        c.insets = new Insets(-SPACING*2,0,0,0);
        mainFrame.add(quantityLabel,c);
        
        //Quantity Field
        quantityField = new JTextField(17);
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = NW;
        mainFrame.add(quantityField,c);
        
        //Address Label
        addressLabel = new JLabel("Product Address: ");
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = NE;
        c.insets = new Insets(-SPACING*3,0,0,0);
        mainFrame.add(addressLabel,c);
        
        //Address Field
        addressField = new JTextField(17);
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = NW;
        mainFrame.add(addressField,c);
        
        //Description Label
        descriptionLabel = new JLabel("Product Description: ");
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = NE;
        c.insets = new Insets(-SPACING*4,0,0,0);
        mainFrame.add(descriptionLabel,c);
        
        //Description Field
        descriptionField = new JTextArea(5,17);
        c.gridx = 1;
        c.gridy = 5;
        c.anchor = NW;
        mainFrame.add(descriptionField,c);
        
        //Detail Label
        detailLabel = new JLabel("Click Add to create a new product listing");
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        c.anchor = NORTH;
        mainFrame.add(detailLabel,c);
        
        //Add Button
        c.gridy = 7;
        c.insets = new Insets(-SPACING*5,0,0,0);
        mainFrame.add(addButton,c);
        
        //Back Button
        c.gridy = 8;
        c.gridwidth = 1;
        c.anchor = SW;
        c.insets = new Insets(0,(int)(SPACING*1.5),(int)(SPACING*1.5),0);
        mainFrame.add(backButton,c);
        
        newProductLabel.setFont(fontBiggerBold);
        nameLabel.setFont(font);
        descriptionLabel.setFont(font);
        priceLabel.setFont(font);
        quantityLabel.setFont(font);
        addressLabel.setFont(font);
        detailLabel.setFont(fontBold);
        nameField.setFont(font);
        descriptionField.setFont(font);
        priceField.setFont(font);
        quantityField.setFont(font);
        addressField.setFont(font);
    }            
    
    public String getName(){
        return nameField.getText();
    }
    
    public String getDescription(){
        return descriptionField.getText();
    }
    
    public String getPrice(){
        return priceField.getText();
    }
    
    public String getQuantity(){
        return quantityField.getText();
    }
    
    public String getAddress(){
        return addressField.getText();
    }
    
    public void setDetailLabel(String text){
        detailLabel.setText(text);
    }
}
