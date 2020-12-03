package cop4331.client;
import java.util.*;
import cop4331.gui.*;
import cop4331.controller.*;
import cop4331.model.*;
/**
 *
 * @author mikey
 */
public class BrosRusApplication {
    
    //Various Products that will be used as examples:
    // JOEY MAKE SOME PRODUCTS HERE TYTY Like 20 should be good idk go ham bud.
    public static void createProducts(){
        ArrayList<User> users = Login.getInstance().getUsers();
        User user = users.get(0);
        Inventory inventory = user.getInventory();
        
        if(inventory.getInventory().size() == 0){
            //new Product(name, description, price(double), quantity, userID(just use user.getUserID() for now),address(use user.getAddress()))
            Product uno = new Product("apples","A bag of apples that weighs around 1 pound.",2.65,50,user.getUserID(),user.getAddress());
            Product dos = new Product("apples","A bag of apples that weighs around 1 pound.",2.65,50,user.getUserID(),user.getAddress());
            Product tres = new Product("apples","A bag of apples that weighs around 1 pound.",2.65,50,user.getUserID(),user.getAddress());
            Product four = new Product("apples","A bag of apples that weighs around 1 pound.",2.65,50,user.getUserID(),user.getAddress());
            Product five = new Product("apples","A bag of apples that weighs around 1 pound.",2.65,50,user.getUserID(),user.getAddress());
            Product six = new Product("apples","A bag of apples that weighs around 1 pound.",2.65,50,user.getUserID(),user.getAddress());
            Product seven = new Product("apples","A bag of apples that weighs around 1 pound.",2.65,50,user.getUserID(),user.getAddress());
            Product eight = new Product("apples","A bag of apples that weighs around 1 pound.",2.65,50,user.getUserID(),user.getAddress());

            inventory.addProduct(uno);
            inventory.addProduct(dos);
            inventory.addProduct(tres);
            inventory.addProduct(four);
            inventory.addProduct(five);
            inventory.addProduct(six);
            inventory.addProduct(seven);
            inventory.addProduct(eight);

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
                
        for(int i = 0;i < users.size();i++){
            System.out.println(users.get(i).getUserName());
        }
    }
    
    
    public static void main(String args[]){
        Login.getInstance().loadSerialization();
        createProducts();
        printUsers();
        printInventory();
        CurrentGUI.getInstance().callGUI();
    }
    
}
