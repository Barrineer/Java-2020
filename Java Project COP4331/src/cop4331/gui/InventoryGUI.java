package cop4331.gui;
import cop4331.model.*;
import cop4331.controller.InventoryListener;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * GUI for the user's inventory.
 * @author mikey, Joseph, Malcolm Richardson
 */
public class InventoryGUI extends MainFrameGUI{
    
    private JButton productButton;
    private JButton nextPageButton;
    private JButton newProductButton;
    
    private JLabel shoppingLabel;
    private JLabel pageLabel;
    
    private int itemAmount = Login.getInstance().getCurrentUser().getInventory().getInventory().size();
    private int pageCounter = 1;
    private int totalPages = 1;
    
    private User user = Login.getInstance().getCurrentUser();
    private Inventory inventory = user.getInventory();
    private ArrayList<Product> products = inventory.getInventory();
    
    /**
     * Creates the button events for the seller GUI
     */
    @Override
    public void createButtonEvents(){
        switchButton = new JButton("Switch to buyer");
        accountButton = new JButton(Login.getInstance().getCurrentUser().getUserName());
        newProductButton = new JButton("Add new");
        
        switchButton.setActionCommand("Switch");
        accountButton.setActionCommand("Account");
        newProductButton.setActionCommand("New");
        
        switchButton.addActionListener(new InventoryListener());
        accountButton.addActionListener(new InventoryListener());
        newProductButton.addActionListener(new InventoryListener());
        
        switchButton.setFont(font);
        accountButton.setFont(font);
        newProductButton.setFont(font);
    }
    /**
     * Creates seller GUI
     */
    @Override
    public void createGUI(){
        setPageCounter();
        setTotalPages();
        GridBagConstraints c = new GridBagConstraints();
        
        boolean underFifteen = false;
        int i = 0;
        
        if(itemAmount != 0)
            underFifteen = true;
        
        createNewFrame("BrosRus Application",1000,1000);
        createTopPanel();
        
        shoppingLabel = new JLabel("Select a product to edit or add a new one.",JLabel.CENTER);
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.anchor = NW;
        mainFrame.add(shoppingLabel,c);
        
        c.gridx = 1;
        mainFrame.add(newProductButton,c);
        c.gridx = 0;
        
        //Put the Products onto the page.
        while(underFifteen){
            if(i >= 14 || i >= itemAmount-1)
                underFifteen = false;
            
            String name = products.get(i+(products.size()-itemAmount)).getName();
            String productID = Integer.toString(products.get(i+(products.size()-itemAmount)).getItemID());
            c.gridy += 1;
            createProductButton("ID: " + productID + " Name: " + name);
            addProductButton(c);
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
        
        
        shoppingLabel.setFont(font);
        pageLabel.setFont(font);
        
    }
    /**
     * Creates a new product button
     * @param productName String object
     */
    public void createProductButton(String productName){
        productButton = new JButton(productName);
        productButton.setActionCommand(productName);
        productButton.addActionListener(new InventoryListener());
        productButton.setFont(font);
    }
    /**
     * Adds the product button to the main frame
     * @param c GridBagConstraints object
     */
    public void addProductButton(GridBagConstraints c){
        mainFrame.add(productButton,c);
    }
    /**
     * Getter for products based on item ID
     * @param productID String object
     * @return product Product object
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
     * Creates a page button
     * @param number String for page number
     */
    public void createPageButton(String number){
        nextPageButton = new JButton(number);
        nextPageButton.setActionCommand(number);
        nextPageButton.addActionListener(new InventoryListener());
        nextPageButton.setFont(font);
    }
    /**
     * Add the page button based on GridBagContraints
     * @param c GridBagConstraints object
     */
    public void addPageButton(GridBagConstraints c){
        mainFrame.add(nextPageButton, c);
    }
    /**
     * Sets page counter
     */
    private void setPageCounter(){
        pageCounter = (Login.getInstance().getCurrentUser().getInventory().getInventory().size() - itemAmount)/15 + 1;
    }
    /**
     * Getter for page number
     * @return pageCounter int for pageCounter
     */
    public int getPageNumber(){
        return pageCounter;
    }
    /**
     * Setter for total pages
     */
    private void setTotalPages(){
        if(Login.getInstance().getCurrentUser().getInventory().getInventory().size() % 15 == 0){
            totalPages = Login.getInstance().getCurrentUser().getInventory().getInventory().size()/15;
        }
        else{
            totalPages = Login.getInstance().getCurrentUser().getInventory().getInventory().size()/15 + 1;
        }
    }
    /**
     * Setter for item amount
     * @param number int for itemAmount
     */
    public void setItemAmount(int number){
        itemAmount = number;
    }  
}