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
        sellerList.add(product);
    }
    
    public void removeProduct(Product product){
        
        for(int i = 0;i < sellerList.size();i++){
            if(sellerList.get(i).getName().equals(product.getName()))
                sellerList.remove(i);
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
