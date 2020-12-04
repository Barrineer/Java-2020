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
    
    //Various Products that will be used as examples:
    public static void createProducts(){
        ArrayList<User> users = Login.getInstance().getUsers();
        User user = users.get(0);
        Inventory inventory = user.getInventory();
        
        if(inventory.getInventory().size() == 0){
            //new Product(name, description, price(double), quantity, userID(just use user.getUserID() for now),address(use user.getAddress()))
            Product uno = new Product("Apples","A bag of apples that weighs around 1 pound.",2.65,50,user.getUserID(),user.getAddress());
            Product dos = new Product("T-Shirts","A package of shirts.",10.00,25,user.getUserID(),user.getAddress());
            Product tres = new Product("Water","A package of water bottles.",4.52,24,user.getUserID(),user.getAddress());
            Product four = new Product("PS5","A digital version PS5 with no disk slot.",399.99,1,user.getUserID(),user.getAddress());
            Product five = new Product("Advil","A container of Advil Liqui-Gels with 80 capsules.",2.65,80,user.getUserID(),user.getAddress());
            Product six = new Product("Almonds","A bag of almonds that weighs around 16 ounces.",6.50,12,user.getUserID(),user.getAddress());
            Product seven = new Product("Airpods","Airpod earbuds.",150.00,6,user.getUserID(),user.getAddress());
            Product eight = new Product("Monitor","A 144Hz 27in Gaming Monitor.",199.99,10,user.getUserID(),user.getAddress());
            Product nine = new Product("Computer Mouse","A wireless gaming mouse with up to 16000dpi.",79.99,20,user.getUserID(),user.getAddress());
            Product ten = new Product("Keyboard","A wired RGB mechanical keyboard.",120.00,18,user.getUserID(),user.getAddress());
            Product eleven = new Product("Headphones","A pair of great sounding, high quality headphones.",99.50,30,user.getUserID(),user.getAddress());
            Product twelve = new Product("HD Camera","A USB Camera with 100p HD Quality.",36.75,50,user.getUserID(),user.getAddress());
            Product thirteen = new Product("Running Shoes","A pair of running shoes.",80.00,50,user.getUserID(),user.getAddress());
            Product fourteen = new Product("Desk Chair","A desk chair with built in blutooth speakers.",2.65,50,user.getUserID(),user.getAddress());
            Product fifteen = new Product("iPhone 12","An iPhone 12 with 128GB.",899.99,7,user.getUserID(),user.getAddress());
            Product sixteen = new Product("Weight Scale","A scale to weigh that shows lbs and kg.",2.65,50,user.getUserID(),user.getAddress());

            inventory.addProduct(uno);
            inventory.addProduct(dos);
            inventory.addProduct(tres);
            inventory.addProduct(four);
            inventory.addProduct(five);
            inventory.addProduct(six);
            inventory.addProduct(seven);
            inventory.addProduct(eight);
            inventory.addProduct(nine);
            inventory.addProduct(ten);
            inventory.addProduct(eleven);
            inventory.addProduct(twelve);
            inventory.addProduct(thirteen);
            inventory.addProduct(fourteen);
            inventory.addProduct(fifteen);
            inventory.addProduct(sixteen);

            Login.getInstance().createSerialization();
        }
        
    }
    // for testing
    public static void printInventory(){
        ArrayList<User> users = Login.getInstance().getUsers();
        User user = users.get(0);
        Inventory inventory = user.getInventory();
                
        for(int i = 0;i < inventory.getInventory().size();i++){
            System.out.println(inventory.getInventory().get(i).getName());
        }
    }
    
    public static void printUsers(){
        ArrayList<User> users = Login.getInstance().getUsers();
        System.out.println(users.size());
        for(int i = 0;i < users.size();i++){
            System.out.println(users.get(i).getUserName());
        }
    }
    
    public static void setItemIDCounter(){
        ArrayList<User> users = Login.getInstance().getUsers();
        Product dummy = new Product("","",0,0,0,"");
        dummy.itemIDCounter = 1000;
        
        for(int i = 0;i < users.size();i++){
            ArrayList<Product> inventory = users.get(i).getInventory().getInventory();
            for(int j = 0;j < inventory.size();j++){
                dummy.itemIDCounter += 1;
            }
        }
    }
    
    
    public static void main(String args[]){
        Login.getInstance().loadSerialization();
        createProducts();
        printInventory();
        printUsers();
        setItemIDCounter();
        CurrentGUI.getInstance().callGUI();
    }
    
}
