package temp;

/**
 * Product class for the BrosDoBUs Application
 * Stores the name, description, item ID, price, quantity, seller ID, and address of a Product.
 * @author mikey
 */
public class Product {
    
    private String name;
    private String description;
    public int itemIDCounter = 1000;
    private int itemID;
    private double price;
    private int quantity;
    private String sellerID;
    private String address;
    
    public Product(String name, String description, double price, int quantity, String sellerID, String address){
        
        this.name = name;
        this.description = description;
        itemID = createNewID();
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
    
}
