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
    
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDesc(){
        return this.description;
    }

    public void setDesc(String description){
        this.description = description;
    }

    public int getItemID(){
        return this.itemID;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getAdress(){
        return this.address;
    }

    public void setAdress(String address){
        this.address = address;
    }
}
