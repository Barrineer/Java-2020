package cop4331.gui;
import cop4331.model.*;
import cop4331.controller.ShoppingListener;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 * GUI for the shopping page.
 * @author mikey, Joseph, Malcolm Richardson
 */
public class ShoppingGUI extends MainFrameGUI{
        
    private JButton cartButton;
    private JButton productButton;
    private JButton nextPageButton;
    
    private JLabel pageLabel;
    private JLabel shoppingLabel;
    
    private ArrayList<Product> products = getAllProducts();
    private int itemAmount = countAllProducts();
    private int pageCounter = 1;
    private int totalPages = 1;
    
    /**
     * Creates the button events for Buyer GUI
     */
    @Override
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
    /**
     * Creates Buyer GUI
     */
    @Override
    public void createGUI(){
        setPageCounter();
        setTotalPages();
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("BrosRus Application",1000,1000);
        createTopPanel();
        
        boolean underFifteen = false;
        int i = 0;
        
        if(itemAmount != 0)
            underFifteen = true;
        
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
        mainFrame.add(shoppingLabel,c);
        
        //Put the Products onto the page.
        while(underFifteen){
            if(i >= 14 || i >= itemAmount-1)
                underFifteen = false;
            
            String name = products.get(i+(countAllProducts()-itemAmount)).getName();
            String productID = Integer.toString(products.get(i+(countAllProducts()-itemAmount)).getItemID());
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

        
        shoppingLabel.setFont(font);        
        
    }
    /**
     * Creates a new product button instance
     * @param productName String for the product name + productID
     */
    public void createProductButton(String productName){
        productButton = new JButton(productName);
        productButton.setActionCommand(productName);
        productButton.addActionListener(new ShoppingListener());
        productButton.setFont(font);
    }
    /**
     * Adds the product button to the mainFrame
     * @param c GridBagConstraints object
     */
    public void addProductButton(GridBagConstraints c){
        mainFrame.add(productButton,c);
    }
    /**
     * Getter for the Product object
     * @param productID String of the product's ID.
     * @return Product object
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
     * Creates a new instance of the next page button
     * @param number String for the page number
     */
    public void createPageButton(String number){
        nextPageButton = new JButton(number);
        nextPageButton.setActionCommand(number);
        nextPageButton.addActionListener(new ShoppingListener());
        nextPageButton.setFont(font);
    }
    /**
     * Adds a next page button to the mainFrame
     * @param c GridBagConstraints object
     */
    public void addPageButton(GridBagConstraints c){
        mainFrame.add(nextPageButton,c);
    }
    /**
     * Keeps track of the page counter 
     */
    private void setPageCounter(){
        pageCounter = (countAllProducts() - itemAmount)/15 + 1;
    }
    /**
     * Getter for the page number
     * @return pageCounter int
     */
    public int getPageNumber(){
        return pageCounter;
    }
    /**
     * Setter for the amount of pages needed
     * If more than 15 products, put them on the next page
     */
    private void setTotalPages(){
        if(countAllProducts() % 15 == 0){
            totalPages = countAllProducts()/15;
        }
        else{
            totalPages = countAllProducts()/15 + 1;
        }
    }
    /**
     * Setter for the item amount
     * @param number int for the new itemAmount
     */
    public void setItemAmount(int number){
        itemAmount = number;
    }
    /**
     * Gets all products from every users inventory
     * @return allProducts ArrayList
     */
    private ArrayList<Product> getAllProducts(){
        ArrayList<User> users = Login.getInstance().getUsers();
        ArrayList<Product> allProducts = new ArrayList<>();
        
        for(int i = 0;i < users.size();i++){
            ArrayList<Product> inventory = users.get(i).getInventory().getInventory();
            for(int j = 0;j < inventory.size();j++){
                allProducts.add(inventory.get(j));
            }
        }
        return allProducts;
    }
    /**
     * Counter for all products
     * @return number of total products for every users inventory
     */
    public int countAllProducts(){
        int number = 0;
        ArrayList<User> users = Login.getInstance().getUsers();
        
        for(int i = 0;i < users.size();i++){
            ArrayList<Product> inventory = users.get(i).getInventory().getInventory();
            for(int j = 0;j < inventory.size();j++){
                number += 1;
            }
        }
        return number;
    }
    
    
}
