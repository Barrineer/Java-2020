package cop4331.model;
import java.util.*;
/**
 * Cart class for the BrosRus application.
 * Stores the user's ID, an array list of Products, and the total number of Products in the Cart.
 * @author mikey
 */
public class Cart implements java.io.Serializable{
    
    private int userID;
    private ArrayList<Product> productList;
    private double total;
    
    public Cart(int userID){
        this.userID = userID;
        this.productList = new ArrayList<Product>();
        this.total = 0;
    }
    /**
     * Private constructor for Cart.
     * Mainly used for the clone() function.
     */
    private Cart(int userID, ArrayList<Product> productList, double total){
        this.userID = userID;
        this.productList = productList;
        this.total = total;
    }
    /**
     * Getter for the productList.
     * @return Returns a clone of the productList.
     */
    public ArrayList<Product> getProductList(){
        return (ArrayList<Product>) this.productList.clone();
    }
    public int getUserID(){
        return this.userID;
    }
    /**
     * Adds a new Product instance to the Cart.
     * Also increases the Cart's total attribute by 1.
     * @param product The Product to be added to the Cart.
     * @param quantity The quantity attribute of a Product to be added to Cart.
     */
    public void addProduct(Product product, int quantity){
        Product temp = (Product) product.clone();
        temp.setQuantity(quantity);
        productList.add(temp);
        this.total += 1;
    }
    /**
     * Removes a quantity of a Product from the Cart.
     * If the quantity of the Product reaches 0, the item is removed from the Cart
     * and the Cart's total attribute is decreased by 1.
     * @param product The Product to be added to the Cart.
     * @param quantity The quantity of the Product to be removed from the Cart.
     */
    public void removeProduct(Product product, int quantity){
        int currentQuantity = 0;
        for(int i = 0;i < this.productList.size();i++){
            currentQuantity = this.productList.get(i).getQuantity();
            if(this.productList.get(i).getItemID() == product.getItemID()){
                    this.productList.get(i).setQuantity(currentQuantity - quantity);
            }
            if(this.productList.get(i).getQuantity() <= 0){
                this.productList.remove(i);
                this.total -= 1;
            }
                
        }        
    }
    /**
     * Creates a clone of the Cart.
     * @return Returns the cloned Cart.
     */
    public Cart clone(){
        Cart clone = new Cart(this.userID, this.productList, this.total);
        return clone;
    }
    
}
