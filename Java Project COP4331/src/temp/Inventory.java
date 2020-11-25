package temp;

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
    
    public void addProduct(){
        
    }
    
    public void removeProduct(){
        
    }
    
    public double calculateRevenue(double revenue){
        
    }
    
    public double calculateSales(double sales){
        
    }
    
    public double calculateProfits(double profits){
        
    }
    
}
