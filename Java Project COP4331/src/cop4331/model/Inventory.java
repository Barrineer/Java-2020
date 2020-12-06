package cop4331.model;

import java.util.*;

/**
 *
 * @author Joseph, mikey
 */
public class Inventory implements java.io.Serializable{
    
    private int userID;
    private double revenue;
    private double costs;
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
        this.costs = 0;
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
     * Revenues = Sum of sell price for all sold items
     * @param price 
     */
    public void addToRevenue(double price){
        this.revenue += price;
    }
    /**
     * Costs = Sum of invoice price for all items brought in the inventory (bought) 
     * @param price
     * @param original
     */
    public void addToCosts(double price, double original){
        this.costs += ((price*0.02) + original);
    }
    /**
     * Profit = Revenues - Costs 
     */
    public void calculateProfits(){
        profits = revenue - costs;
    }
    
    public double getRevenues(){
        return revenue;
    }
    
    public double getCosts(){
        return costs;
    }
    
    public double getProfits(){
        return profits;
    }
    
}
