package cop4331.controller;
import cop4331.gui.AccountInfoGUI;
import cop4331.gui.InventoryGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.NewProductGUI;
import cop4331.gui.ShoppingGUI;
import cop4331.model.Login;
import cop4331.model.Product;
import cop4331.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author mikey
 */
public class NewProductListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        MainFrameGUI frame = CurrentGUI.getInstance().getFrame();
        CurrentGUI gui = CurrentGUI.getInstance();
        User user = Login.getInstance().getCurrentUser();
        
        String name = ((NewProductGUI)frame).getName();
        String description = ((NewProductGUI)frame).getDescription();
        String price = ((NewProductGUI)frame).getPrice();
        String quantity = ((NewProductGUI)frame).getQuantity();
        String address = ((NewProductGUI)frame).getAddress();;
        
        if(command.equals("Add")){
            
            if(name == "" || description == "" || price == "" || quantity == "" || address == ""){
                ((NewProductGUI)frame).setDetailLabel("Please enter at least a single value into each category.");
            }
            else{
                Product product = new Product(name,description,Double.parseDouble(price),Integer.parseInt(quantity),user.getUserID(),address);
                user.getInventory().addProduct(product);
                ((NewProductGUI)frame).setDetailLabel("New product created successfully!");
                Login.getInstance().createSerialization();
            }
            
        }
        else{
            frame.removeOldFrame();
            gui.changeGUI(new InventoryGUI());
            gui.callGUI();
        }
        
    }
    
}
