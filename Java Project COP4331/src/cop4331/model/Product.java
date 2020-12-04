package cop4331.model;

/**
 * Product class for the BrosRUs Application.
 * Stores the name, description, item ID, price, quantity, seller ID, and address of a Product.
 * Includes a uniqueID creator and getter/setter functions for most attributes.
 * @author mikey
 */
public class Product implements java.io.Serializable{
    
    private String name;
    private String description;
    public static int itemIDCounter = 1000;
    private int itemID;
    private double price;
    private int quantity;
    private int sellerID;
    private String address;
    /**
     * Constructor for a new Product.
     * Gives a unique itemID.
     */
    public Product(String name, String description, double price, int quantity, int sellerID, String address){
        
        this.name = name;
        this.description = description;
        itemID = createNewID();
        this.price = price;
        this.quantity = quantity;
        this.sellerID = sellerID;
        this.address = address;
        
        
    }
    /**
     * Private constructor for a new Product.
     * Gives an itemID that may belong to another Product.
     */
    private Product(String name, String description, int itemID, double price, int quantity, int sellerID, String address){
        this.name = name;
        this.description = description;
        this.itemID = itemID;
        this.price = price;
        this.quantity = quantity;
        this.sellerID = sellerID;
        this.address = address;

    }
    /**
     * Creates a new unique ID for the Product's item ID.
     * @return int for a new ID.
     */
    private int createNewID(){
        itemIDCounter += 1;
        return itemIDCounter;
    }
    /**
     * Creates a clone of a Product.
     * @return Returns the cloned Product.
     */
    public Product clone(){
        Product clone = new Product(this.name,this.description,this.itemID,this.price,this.quantity,this.sellerID,this.address);
        return clone;
    }
    /**
     * Getter for the name attribute.
     * @return Returns the name attribute for this instance of Product.
     */
    public String getName(){
        return this.name;
    }
    /**
     * Setter for the name attribute.
     * @param name The new name of the Product.
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Getter for the description attribute.
     * @return Returns the description attribute for this instance of Product.
     */
    public String getDesc(){
        return this.description;
    }
    /**
     * Setter for the description attribute.
     * @param description The new description of the Product.
     */
    public void setDesc(String description){
        this.description = description;
    }
    /**
     * Getter for the item ID attribute.
     * @return Returns the item ID attribute for this instance of Product.
     */
    public int getItemID(){
        return this.itemID;
    }
    /**
     * Getter for the price attribute.
     * @return Returns the price attribute for this instance of Product.
     */
    public double getPrice(){
        return this.price;
    }
    /**
     * Setter for the price attribute.
     * @param price The new price of the Product.
     */
    public void setPrice(double price){
        this.price = price;
    }
    /**
     * Getter for the quantity attribute.
     * @return Returns the quantity attribute for this instance of Product.
     */
    public int getQuantity(){
        return this.quantity;
    }
    /**
     * Setter for the quantity attribute.
     * @param quantity The new quantity of the Product.
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    /**
     * Getter for the address attribute.
     * @return Returns the address attribute for this instance of Product.
     */
    public String getAdress(){
        return this.address;
    }
    /**
     * Setter for the address attribute.
     * @param address The new address of the Product.
     */
    public void setAdress(String address){
        this.address = address;
    }
}
