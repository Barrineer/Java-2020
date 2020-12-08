package cop4331.controller;
import cop4331.gui.AccountInfoGUI;
import cop4331.gui.InventoryGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.NewProductGUI;
import cop4331.gui.ProductDescriptionGUI;
import cop4331.gui.ShoppingGUI;
import cop4331.model.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mikey, Joseph, Malcolm Richardson
 */
public class InventoryListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        MainFrameGUI frame = CurrentGUI.getInstance().getFrame();
        CurrentGUI gui = CurrentGUI.getInstance();
        
        if(command.equals("Switch")){
            Login.getInstance().getCurrentUser().setAccountType("Buyer");
            frame.removeOldFrame();
            gui.changeGUI(new ShoppingGUI());
            gui.callGUI();
        }
        else if(command.equals("Account")){
            frame.removeOldFrame();
            gui.changeGUI(new AccountInfoGUI());
            gui.callGUI();
        }
        else if(command.equals("New")){
            frame.removeOldFrame();
            gui.changeGUI(new NewProductGUI());
            gui.callGUI();
        }
        else if(command.length() > 5){
            frame.removeOldFrame();
            gui.changeGUI(new ProductDescriptionGUI(((InventoryGUI)frame).getProduct(command.substring(4,8))));
            gui.callGUI();
        }
        else{
            InventoryGUI inventoryGUI = new InventoryGUI();
            inventoryGUI.setItemAmount(Login.getInstance().getCurrentUser().getInventory().getInventory().size() - (Integer.parseInt(command)-1)*15);
            
            frame.removeOldFrame();
            gui.changeGUI(inventoryGUI);
            gui.callGUI();
        }
    }
    
}
