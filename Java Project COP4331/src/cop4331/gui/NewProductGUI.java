package cop4331.gui;
import cop4331.controller.NewProductListener;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author mikey, Joseph, Malcolm Richardson
 */
public class NewProductGUI extends MainFrameGUI{
    
    private JLabel newProductLabel;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel originalPriceLabel;
    private JLabel priceLabel;
    private JLabel quantityLabel;
    private JLabel addressLabel;
    private JLabel detailLabel;
    
    private JTextField nameField;
    private JTextArea descriptionField;
    private JTextField originalPriceField;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextField addressField;
    
    private JButton addButton;
    private JButton backButton;
    
    /**
     * Creates button events for New Product GUI
     */
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
    /**
     * Creates New Product GUI
     */
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
        mainFrame.add(nameLabel,c);
        
        //Name Field
        nameField = new JTextField(17);
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = NW;
        mainFrame.add(nameField,c);
        
        //Original Price Label
        originalPriceLabel = new JLabel("Original Price: ");
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = NE;
        mainFrame.add(originalPriceLabel,c);
        
        //Original Price Field
        originalPriceField = new JTextField(17);
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = NW;
        mainFrame.add(originalPriceField,c);
        
        //Price Label
        priceLabel = new JLabel("Your Sell Price: ");
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = NE;
        mainFrame.add(priceLabel,c);
        
        //Price Field
        priceField = new JTextField(17);
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = NW;
        mainFrame.add(priceField,c);
        
        //Quantity Label
        quantityLabel = new JLabel("Product Quantity: ");
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = NE;
        mainFrame.add(quantityLabel,c);
        
        //Quantity Field
        quantityField = new JTextField(17);
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = NW;
        mainFrame.add(quantityField,c);
        
        //Address Label
        addressLabel = new JLabel("Product Address: ");
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = NE;
        mainFrame.add(addressLabel,c);
        
        //Address Field
        addressField = new JTextField(17);
        c.gridx = 1;
        c.gridy = 5;
        c.anchor = NW;
        mainFrame.add(addressField,c);
        
        //Description Label
        descriptionLabel = new JLabel("Product Description: ");
        c.gridx = 0;
        c.gridy = 6;
        c.anchor = NE;
        mainFrame.add(descriptionLabel,c);
        
        //Description Field
        descriptionField = new JTextArea(5,17);
        c.gridx = 1;
        c.gridy = 6;
        c.anchor = NW;
        mainFrame.add(descriptionField,c);
        
        //Detail Label
        detailLabel = new JLabel("Click Add to create a new product listing");
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        c.anchor = NORTH;
        mainFrame.add(detailLabel,c);
        
        //Add Button
        c.gridy = 8;
        mainFrame.add(addButton,c);
        
        //Back Button
        c.gridy = 9;
        c.gridwidth = 1;
        c.anchor = SW;
        c.insets = new Insets(0,(int)(SPACING*1.5),(int)(SPACING*1.5),0);
        mainFrame.add(backButton,c);
        
        newProductLabel.setFont(fontBiggerBold);
        nameLabel.setFont(font);
        descriptionLabel.setFont(font);
        originalPriceLabel.setFont(font);
        priceLabel.setFont(font);
        quantityLabel.setFont(font);
        addressLabel.setFont(font);
        detailLabel.setFont(fontBold);
        nameField.setFont(font);
        descriptionField.setFont(font);
        originalPriceField.setFont(font);
        priceField.setFont(font);
        quantityField.setFont(font);
        addressField.setFont(font);
    }            
    /**
     * Getter for product name field 
     * @return string for name text field
     */
    public String getName(){
        return nameField.getText();
    }
    /**
     * Getter for product description field
     * @return string for description field
     */
    public String getDescription(){
        return descriptionField.getText();
    }
    /**
     * Getter for the Original Price Field
     * @return 
     */
    public String getOriginalPrice(){
        return originalPriceField.getText();
    }
    /**
     * Getter for product price field
     * @return string for price field
     */
    public String getPrice(){
        return priceField.getText();
    }
    /**
     * Getter for product quantity field
     * @return string for quantity field
     */
    public String getQuantity(){
        return quantityField.getText();
    }
    /**
     * Getter for product address field
     * @return string for address field
     */
    public String getAddress(){
        return addressField.getText();
    }
    /**
     * Setter for detail label
     * @param text string to set
     */
    public void setDetailLabel(String text){
        detailLabel.setText(text);
    }
}
