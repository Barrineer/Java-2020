package cop4331.client;
import java.util.*;
import cop4331.gui.*;
import cop4331.controller.*;
import cop4331.model.*;
/**
 *
 * @author mikey, Joseph Mucciaccio
 */


public class BrosRusApplication {
    
    /**
     * Creating Various Products that will be used as examples
     * Testing Purposes
     */
    public static void createProducts(){
        ArrayList<User> users = Login.getInstance().getUsers();
        User bill = users.get(0);   
        User bob = users.get(1);
        User sam = users.get(2);
        
        ArrayList<Product> billProducts = bill.getInventory().getInventory();
        ArrayList<Product> bobProducts = bob.getInventory().getInventory();
        ArrayList<Product> samProducts = sam.getInventory().getInventory();
        
            //new Product(name, description, price(double), quantity, userID, address)
            //Original price set to $1.49 for all test products (Original price being how much the user payed for the products)
            Product one = new Product("Apples","A bag of apples that weighs around 1 pound.",2.65,1.49,50,bill.getUserID(),bill.getAddress());
            Product two = new Product("T-Shirts","A package of shirts.",10.25,1.49,25,bob.getUserID(),bob.getAddress());
            Product three = new Product("Water","A package of water bottles.",4.52,1.49,24,sam.getUserID(),sam.getAddress());
            Product four = new Product("PS5","A digital version PS5 with no disk slot.",399.99,1.49,1,bill.getUserID(),bill.getAddress());
            Product five = new Product("Advil","A container of Advil Liqui-Gels with 80 capsules.",2.65,1.49,80,bob.getUserID(),bob.getAddress());
            Product six = new Product("Almonds","A bag of almonds that weighs around 16 ounces.",6.50,1.49,12,sam.getUserID(),sam.getAddress());
            Product seven = new Product("Airpods","Airpod earbuds.",150.99,1.49,6,bill.getUserID(),bill.getAddress());
            Product eight = new Product("Monitor","A 144Hz 27in Gaming Monitor.",199.99,1.49,10,bob.getUserID(),bob.getAddress());
            Product nine = new Product("Computer Mouse","A wireless gaming mouse with up to 16000 dpi.",79.99,1.49,20,sam.getUserID(),sam.getAddress());
            Product ten = new Product("Keyboard","A wired RGB mechanical keyboard.",119.99,1.49,18,bill.getUserID(),bill.getAddress());
            Product eleven = new Product("Headphones","A pair of great sounding, high quality headphones.",99.50,1.49,30,bob.getUserID(),bob.getAddress());
            Product twelve = new Product("HD Camera","A USB Camera with 100p HD Quality.",36.75,1.49,50,sam.getUserID(),sam.getAddress());
            Product thirteen = new Product("Running Shoes","A pair of running shoes.",80.05,1.49,50,bill.getUserID(),bill.getAddress());
            Product fourteen = new Product("Desk Chair","A desk chair with built in blutooth speakers.",2.65,1.49,50,bob.getUserID(),bob.getAddress());
            Product fifteen = new Product("iPhone 12","An iPhone 12 with 128GB.",899.99,1.49,7,sam.getUserID(),sam.getAddress());
            Product sixteen = new Product("Weight Scale","A scale to weigh that shows lbs and kg.",2.65,1.49,50,sam.getUserID(),sam.getAddress());

            billProducts.add(one);
            billProducts.add(four);
            billProducts.add(seven);
            billProducts.add(ten);
            billProducts.add(thirteen);
            
            bobProducts.add(two);
            bobProducts.add(five);
            bobProducts.add(eight);
            bobProducts.add(eleven);
            bobProducts.add(fourteen);
            
            samProducts.add(three);
            samProducts.add(six);
            samProducts.add(nine);
            samProducts.add(twelve);
            samProducts.add(fifteen);
            samProducts.add(sixteen);

            Login.getInstance().createSerialization();
    }
    /**
     * Makes Users for Testing
     */
    public static void createUsers(){
        
        User one = new User("","bill","bill");
        User two = new User("","bob","bob");
        User three = new User("","sam","sam");
        
        Login.getInstance().addUser(one);
        Login.getInstance().addUser(two);
        Login.getInstance().addUser(three);
    }
    /**
     * Reset Item Counter for Testing
     * When adding products, this increments to start after previous products that exist
     */
    public static void setItemIDCounter(){
        ArrayList<User> users = Login.getInstance().getUsers();
        Product dummy = new Product("","",0,0,0,0,"");
        dummy.itemIDCounter = 1000;
        
        for(int i = 0;i < users.size();i++){
            ArrayList<Product> inventory = users.get(i).getInventory().getInventory();
            for(int j = 0;j < inventory.size();j++){
                dummy.itemIDCounter += 1;
            }
        }
    }
    /**
     * Clears Test Data
     */
    public static void clearData(){
        Login.getInstance().removeAllData();
    }
    /**
     * Printing account details for Testing
     */
    public static void printAccountDetails(){
        System.out.println("User 1: bill, Pass: bill");
        System.out.println("User 2: bob, Pass: bob");
        System.out.println("User 3: sam, Pass: sam");
    }

    public static void main(String args[]){
        
        //True for premade data, false if new user or keeping old data
        boolean test = true;
        
        ArrayList<User> users = Login.getInstance().getUsers();
        
        if(test){
            clearData();
            createUsers();
            createProducts();
            setItemIDCounter();
            printAccountDetails();
        }
        else{
            boolean testData = true;
            
            // if any password is any of the three below, clear data
            for(int i = 0;i < users.size();i++){
                String password = users.get(i).getPassword();
                if(password.equals("bill") || password.equals("bob") || password.equals("sam"))
                    testData = false;
            }
            if(!testData){
                clearData();
            }
            Login.getInstance().loadSerialization();
            setItemIDCounter();
        }
        
        CurrentGUI.getInstance().callGUI();
        
    }
    
}
