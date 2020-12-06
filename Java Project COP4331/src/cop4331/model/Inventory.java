package cop4331.model;

import java.util.*;

/**
 *
 * @author Joseph, mikey
 */
public class Inventory implements java.io.Serializable{
    
    private int userID;
    private double revenue;
    private double sales;
    private double profits;
    
    private ArrayList<Product> sellerList;
    
    /**
     * Constructor for Inventory Class
     * @param userID 
     */
    public Inventory(int userID){
        this.userID = userID;
        this.sellerList = new ArrayList<Product>();
        this.revenue = 0;
        this.sales = 0;
        this.profits = 0;
    }
    /**
     * Getter for the sellers inventory
     * @return 
     */
    public ArrayList<Product> getInventory(){
        return sellerList;
    }
    /**
     * Adds product to sellers inventory
     * @param product 
     */
    public void addProduct(Product product){
        sellerList.add((Product) product.clone());
    }
    /**
     * Removes product from sellers inventory
     * @param product 
     */
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
    
    //Profit = Revenues - Costs,
    //Revenues = Sum of sell price for all sold items
    //Costs = Sum of invoice price for all items brought in the inventory (bought)
    
//    public double calculateRevenue(double revenue){
//        return 0;
//    }
//    
//    public double calculateSales(double sales){
//        return 0;
//    }
//    
//    public double calculateProfits(double profits){
//        return 0;
//    }
    
}
