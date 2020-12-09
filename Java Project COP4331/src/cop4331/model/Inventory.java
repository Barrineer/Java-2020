package cop4331.model;
import java.util.*;

/**
 * Inventory for the User which holds each product they added to it and calculates the revenue, costs, and profits.
 * @author Joseph, mikey, Malcolm Richardson
 */
public class Inventory implements java.io.Serializable{
    
    private int userID;
    private double revenue;
    private double costs;
    private double profits;
    
    private ArrayList<Product> sellerList;
    
    /**
     * Constructor for Inventory Class
     * @param userID int for user's ID
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
     * @return ArrayList of Products
     */
    public ArrayList<Product> getInventory(){
        return sellerList;
    }
    /**
     * Adds product to sellers inventory
     * @param product Product object to add
     */
    public void addProduct(Product product){
        sellerList.add((Product) product.clone());
    }
    /**
     * Removes product from sellers inventory
     * @param product Product object to remove
     */
    public void removeProduct(Product product){
        
        for(int i = 0;i < sellerList.size();i++){
            if(sellerList.get(i).getItemID() == (product.getItemID()))
                sellerList.remove(i);
        }
        
    }
    /**
     * Revenues = Sum of sell price for all sold items
     * @param price double of the price to add to revenue
     */
    public void addToRevenue(double price){
        this.revenue += price;
    }
    /**
     * Costs = Sum of invoice price for all items brought in the inventory (bought) 
     * @param price double of the price to calculate
     * @param original double of the original price to calculate
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
    /**
     * Getter for revenue
     * @return double of the revenue
     */
    public double getRevenues(){
        return revenue;
    }
    /**
     * Getter for the costs
     * @return double of the costs
     */
    public double getCosts(){
        return costs;
    }
    /**
     * Getter for the profits
     * @return double of the profits
     */
    public double getProfits(){
        return profits;
    }
    
}
