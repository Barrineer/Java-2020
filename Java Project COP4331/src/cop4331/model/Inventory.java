package cop4331.model;

import java.util.*;

/**
 *
 * @author Joseph
 */
public class Inventory {
    
    private String userID;
    private double revenue;
    private double sales;
    private double profits;
    
    private ArrayList<Product> sellerList;
    
    public Inventory(String userID){
        this.userID = userID;
        this.sellerList = new ArrayList<Product>();
        this.revenue = 0;
        this.sales = 0;
        this.profits = 0;
    }
    
    public void addProduct(Product product){
        sellerList.add((Product) product.clone());
    }
    
    public void removeProduct(Product product){
        
        for(int i = 0;i < sellerList.size();i++){
            if(sellerList.get(i).getItemID() == (product.getItemID()))
                sellerList.remove(i);
        }
        
    }
    /**
     * Updates the Inventory by checking the quantity of Products that were bought from the Cart.
     * Removes the Product from the Inventory if the quantity of Products becomes 0.
     * @param cart The Cart of Products that will update the Inventory (if any Products are in common).
     */
    public void updateInventory(Cart cart){
        ArrayList<Product> temp = cart.getProductList();
        for(int i = 0;i < temp.size();i++){
            if(this.sellerList.get(i).getItemID() == temp.get(i).getItemID()){
                this.sellerList.get(i).setQuantity(this.sellerList.get(i).getQuantity() - temp.get(i).getQuantity());
                
                if(this.sellerList.get(i).getQuantity() == 0)
                    this.removeProduct(this.sellerList.get(i));
            }
        }
    }
    
    public double calculateRevenue(double revenue){
        return 0;
    }
    
    public double calculateSales(double sales){
        return 0;
    }
    
    public double calculateProfits(double profits){
        return 0;
    }
    
}
