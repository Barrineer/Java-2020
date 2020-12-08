package cop4331.gui;
import cop4331.model.*;
import cop4331.controller.CartListener;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author mikey, Joseph, Malcolm Richardson
 */
public class CartGUI extends MainFrameGUI{
    
    private JButton backButton;
    private JButton checkoutButton;
    private JButton removeOneButton;
    private JButton removeAllButton;
    private JButton productButton;
    private JButton nextPageButton;
    
    private JLabel cartLabel;
    private JLabel pageLabel;
    
    private int itemAmount = Login.getInstance().getCurrentUser().getCart().getProductList().size();
    private int pageCounter = 1;
    private int totalPages = 1;
    
    private User user = Login.getInstance().getCurrentUser();
    private Cart cart = user.getCart();
    private ArrayList<Product> products = cart.getProductList();    
    
    /**
     * Creates button events for the Cart GUI
     */
    public void createButtonEvents(){
        backButton = new JButton("Back");
        checkoutButton = new JButton("Checkout");
        
        backButton.setActionCommand("Back");
        checkoutButton.setActionCommand("Checkout");
        
        backButton.addActionListener(new CartListener());
        checkoutButton.addActionListener(new CartListener());
        
        backButton.setFont(font);
        checkoutButton.setFont(font);
    }
    /**
     * Creates the Cart GUI
     */
    public void createGUI(){
        setPageCounter();
        setTotalPages();
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("BrosRus Application",1000,1000);
        
        boolean underFifteen = false;
        int i = 0;
        
        if(itemAmount != 0)
            underFifteen = true;
        
        //Cart Label
        cartLabel = new JLabel(Login.getInstance().getCurrentUser().getUserName() + " Cart");
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.anchor = CENTER;
        mainFrame.add(cartLabel,c);
        
        c.gridwidth = 1;
        //Put the Products and Remove Buttons onto the page.
        while(underFifteen){
            if(i >= 14 || i >= itemAmount-1)
                underFifteen = false;
            
            String name = products.get(i+(products.size()-itemAmount)).getName();
            String productID = Integer.toString(products.get(i+(products.size()-itemAmount)).getItemID());
            c.gridy += 1;
            c.gridx = 0;
            createProductButton("ID: " + productID + " Name: " + name);
            addProductButton(c);
            c.gridx = 1;
            createRemoveButtons(productID);
            addRemoveOneButton(c);
            c.gridx = 2;
            addRemoveAllButton(c);
            i++;
        }        
        
        //Page Label
        c.gridy += 1;
        c.gridx = 0;
        c.anchor = CENTER;
        pageLabel = new JLabel("Page:",JLabel.CENTER);
        mainFrame.add(pageLabel,c);
        
        //Pages
        for(int j = 1;j < totalPages+1;j++){
            c.gridx += 1;
            createPageButton(Integer.toString(j));
            addPageButton(c);
        }
        
        //Back Button
        c.gridy += 1;
        c.gridx = 0;
        c.gridwidth = 1;
        c.anchor = SW;
        c.insets = new Insets(0,(int)(SPACING*1.5),(int)(SPACING*1.5),0);
        mainFrame.add(backButton,c);
        
        //Checkout Button
        c.gridx = 2;
        c.anchor = SE;
        c.insets = new Insets(0,0,(int)(SPACING*1.5),(int)(SPACING*1.5));
        mainFrame.add(checkoutButton,c);      
        
        cartLabel.setFont(fontBiggerBold);
        pageLabel.setFont(fontBold);
    }
    /**
     * Creates a product button
     * @param productName 
     */
    public void createProductButton(String productName){
        productButton = new JButton(productName);
        productButton.setActionCommand(productName);
        productButton.addActionListener(new CartListener());
        productButton.setFont(font);
    }
    /**
     * Adds product button to the main frame
     * @param c 
     */
    public void addProductButton(GridBagConstraints c){
        mainFrame.add(productButton,c);
    }
    /**
     * Getter for products
     * @param productID
     * @return product
     */
    public Product getProduct(String productID){
        Product product = new Product("none","none",0,0,0,0,"none");
        for(int i = 0;i < products.size();i++){
            if(Integer.parseInt(productID) == products.get(i).getItemID()){
                product = products.get(i);
            }
        }
        return product;
    }
    /**
     * Creates the "Remove 1" and "Remove All" button
     * @param productID 
     */
    public void createRemoveButtons(String productID){
        removeOneButton = new JButton("Remove 1");
        removeAllButton = new JButton("Remove All");
        
        removeOneButton.setActionCommand("Remove One " + productID);
        removeAllButton.setActionCommand("Remove All " + productID);
        
        removeOneButton.addActionListener(new CartListener());
        removeAllButton.addActionListener(new CartListener());
        
        removeOneButton.setFont(font);
        removeAllButton.setFont(font);
    }
    /**
     * Add "Remove All" button
     * @param c 
     */
    public void addRemoveAllButton(GridBagConstraints c){
        mainFrame.add(removeAllButton,c);
    }
    /**
     * Add "Remove 1" button
     * @param c 
     */
    public void addRemoveOneButton(GridBagConstraints c){
        mainFrame.add(removeOneButton,c);
    }
    /**
     * Creates the page buttons
     * @param number 
     */
    public void createPageButton(String number){
        nextPageButton = new JButton(number);
        nextPageButton.setActionCommand(number);
        nextPageButton.addActionListener(new CartListener());
        nextPageButton.setFont(font);
    }
    /**
     * Adds the page buttons
     * @param c 
     */
    public void addPageButton(GridBagConstraints c){
        mainFrame.add(nextPageButton,c);
    }
    /**
     * Setter for the page counter
     */
    private void setPageCounter(){
        pageCounter = (Login.getInstance().getCurrentUser().getCart().getProductList().size() - itemAmount)/15 + 1;
    }
    /**
     * Getter for the page counter
     * @return page counter
     */
    public int getPageNumber(){
        return pageCounter;
    }
    /**
     * Sets total pages
     */
    private void setTotalPages(){
        if(Login.getInstance().getCurrentUser().getCart().getProductList().size() % 15 == 0){
            totalPages = Login.getInstance().getCurrentUser().getCart().getProductList().size()/15;
        }
        else{
            totalPages = Login.getInstance().getCurrentUser().getCart().getProductList().size()/15 + 1;
        }
    }
    /**
     * Sets the total item amount
     * @param number 
     */
    public void setItemAmount(int number){
        itemAmount = number;
    }
    
}
