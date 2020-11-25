package cop4331.model;
import java.util.*;
/**
 *
 * @author mikey
 */
public class Cart {
    
    private String userID;
    private ArrayList<Product> productList;
    private double total;
    
    public Cart(String userID){
        this.userID = userID;
        this.productList = new ArrayList<Product>();
        this.total = 0;
    }
    /**
     * Adds a new Product instance to the Cart.
     * Also increases the Cart's total attribute by 1.
     * @param product The Product to be added to the Cart.
     */
    public void addProduct(Product product, int quantity){
        Product temp = (Product) product.clone();
        this.productList.add(product);
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
                if(currentQuantity <= quantity)
                    currentQuantity -= quantity;
            }
            if(currentQuantity == 0){
                this.productList.remove(i);
                this.total -= 1;
            }
                
        }           
    }
    
}
