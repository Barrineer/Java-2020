package cop4331.controller;
import cop4331.gui.CartGUI;
import cop4331.gui.CheckoutGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.ReceiptGUI;
import cop4331.model.Login;
import cop4331.model.Product;
import cop4331.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 *
 * @author mikey, Joseph, Malcolm Richardson
 */
public class CheckoutListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        MainFrameGUI frame = CurrentGUI.getInstance().getFrame();
        CurrentGUI gui = CurrentGUI.getInstance();
        ArrayList<User> users = Login.getInstance().getUsers();
        User user = Login.getInstance().getCurrentUser();
        
        if(command.equals("Back")){
            frame.removeOldFrame();
            gui.changeGUI(new CartGUI());
            gui.callGUI();
        }
        else{
            ArrayList<Product> products = user.getCart().getProductList();
            //Add the sales to the correct seller inventory
            for(int i = 0;i < users.size();i++){
                ArrayList<Product> inventory = users.get(i).getInventory().getInventory();
                for(int j = 0;j < products.size();j++){
                    for(int k = 0;k < inventory.size();k++){
                        if(products.get(j).equals(inventory.get(k))){
                            users.get(i).getInventory().addToRevenue(products.get(j).getPrice()*products.get(j).getQuantity());
                            users.get(i).getInventory().addToCosts(products.get(j).getPrice()*products.get(j).getQuantity(),products.get(j).getOriginalPrice()*products.get(j).getQuantity());
                        }
                    }
                }
            }
            
            frame.removeOldFrame();
            gui.changeGUI(new ReceiptGUI(((CheckoutGUI)frame).getReceipt()));
            gui.callGUI();
            user.getCart().emptyCart();
        }
        
    }
    
}
