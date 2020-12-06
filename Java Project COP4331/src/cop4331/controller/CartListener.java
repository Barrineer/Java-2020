package cop4331.controller;
import cop4331.gui.CartGUI;
import cop4331.gui.CheckoutGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.ProductDescriptionGUI;
import cop4331.gui.ShoppingGUI;
import cop4331.model.Login;
import cop4331.model.Product;
import cop4331.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author mikey, Joseph
 */
public class CartListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        MainFrameGUI frame = CurrentGUI.getInstance().getFrame();
        CurrentGUI gui = CurrentGUI.getInstance();
        User user = Login.getInstance().getCurrentUser();
        
        if(command.equals("Back")){
            frame.removeOldFrame();
            gui.changeGUI(new ShoppingGUI());
            gui.callGUI();
        }
        else if(command.equals("Checkout")){
            frame.removeOldFrame();
            gui.changeGUI(new CheckoutGUI());
            gui.callGUI();
        }
        else if(command.length() < 5){
            CartGUI cartGUI = new CartGUI();
            cartGUI.setItemAmount(Login.getInstance().getCurrentUser().getCart().getProductList().size() - (Integer.parseInt(command)-1)*15);
            
            frame.removeOldFrame();
            gui.changeGUI(cartGUI);
            gui.callGUI();
        }
        else if(command.substring(0,10).equals("Remove One")){
            Product product = new Product("","",1,1,1,"");
            ArrayList<Product> cart = user.getCart().getProductList();
            ArrayList<User> users = Login.getInstance().getUsers();
            product.itemIDCounter -= 1;
            int quantity = 0;
            
            for(int i = 0;i<cart.size();i++){
                if(cart.get(i).getItemID() == Integer.parseInt(command.substring(11))){
                    product = cart.get(i);
                    quantity = cart.get(i).getQuantity();
                }
            }
            
            user.getCart().removeProduct(product, 1);
            
            for(int j = 0;j < users.size();j++){
                ArrayList<Product> inventory = users.get(j).getInventory().getInventory();
                for(int k = 0;k < inventory.size();k++){
                    if(inventory.get(k).getItemID() == product.getItemID()){
                        inventory.get(k).setQuantity(quantity);
                    }
                }
            }
            
            frame.removeOldFrame();
            gui.changeGUI(new CartGUI());
            gui.callGUI();
        }
        else if(command.substring(0,10).equals("Remove All")){
            Product product = new Product("","",1,1,1,"");
            ArrayList<Product> cart = user.getCart().getProductList();
            ArrayList<User> users = Login.getInstance().getUsers();
            product.itemIDCounter -= 1;
            int quantity = 0;
            
            for(int i = 0;i<cart.size();i++){
                if(cart.get(i).getItemID() == Integer.parseInt(command.substring(11))){
                    product = cart.get(i);
                    quantity = cart.get(i).getQuantity();
                }
            }
            user.getCart().removeProduct(product, product.getQuantity());
            
            for(int j = 0;j < users.size();j++){
                ArrayList<Product> inventory = users.get(j).getInventory().getInventory();
                for(int k = 0;k < inventory.size();k++){
                    if(inventory.get(k).getItemID() == product.getItemID()){
                        inventory.get(k).setQuantity(quantity);
                    }
                }
            }
            
            frame.removeOldFrame();
            gui.changeGUI(new CartGUI());
            gui.callGUI();
        }
        else{
            frame.removeOldFrame();
            gui.changeGUI(new ProductDescriptionGUI(((CartGUI)frame).getProduct(command.substring(4,8))));
            gui.callGUI();
        }
    }
    
}
