package cop4331.controller;
import cop4331.gui.*;
import java.awt.event.ActionListener;
/**
 * Controls which GUI is currently being displayed.
 * Uses Singleton Pattern.
 * @author mikey
 */
public class CurrentGUI {
    
    private String gui;
    private static CurrentGUI currentGUI = new CurrentGUI("Login");
    
    private CurrentGUI(String gui){
        this.gui = gui;
    }
    public static CurrentGUI getInstance(){
        return currentGUI;
    }
    public void startGUI(){
        LoginGUI.getInstance();
    }
    /**
     * Change the current GUI to another GUI.
     * @param gui String of another GUI.
     */
    public void changeGUI(String gui){
        this.gui = gui;
    }
    /**
     * Displays the current GUI.
     */
    public void callGUI(){

        if(this.gui.equals("Account")){
            
        }
        else if(this.gui.equals("Cart")){
            
        }
        else if(this.gui.equals("Checkout")){
            
        }
        else if(this.gui.equals("Inventory")){
            
        }
        else if(this.gui.equals("New")){
            
        }
        else if(this.gui.equals("Product")){
            
        }
        else if(this.gui.equals("Shopping")){
            ShoppingGUI.getInstance();
        }
    }
}
