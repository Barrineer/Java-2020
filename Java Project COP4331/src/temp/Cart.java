package temp;
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
    
    public void addProduct(Product product){
        this.productList.add(product);
        this.total += 1;
    }
    
    public void removeProduct(Product product){
        
    }
    
    public void removeAllProducts(Product product){
        
    }
    
}
