package cop4331.controller;
import cop4331.gui.AccountInfoGUI;
import cop4331.gui.CartGUI;
import cop4331.gui.InventoryGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.ProductDescriptionGUI;
import cop4331.gui.ShoppingGUI;
import cop4331.model.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mikey, Joseph, Malcolm Richardson
 */
public class ShoppingListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        MainFrameGUI frame = CurrentGUI.getInstance().getFrame();
        CurrentGUI gui = CurrentGUI.getInstance();
        
        if(command.equals("Switch")){
            Login.getInstance().getCurrentUser().setAccountType("Seller");
            frame.removeOldFrame();
            gui.changeGUI(new InventoryGUI());
            gui.callGUI();
        }
        else if(command.equals("Account")) {
            frame.removeOldFrame();
            gui.changeGUI(new AccountInfoGUI());
            gui.callGUI();
        }
        else if(command.equals("Cart")){
            frame.removeOldFrame();
            gui.changeGUI(new CartGUI());
            gui.callGUI();
        }
        else if(command.length() > 5){
            frame.removeOldFrame();
            gui.changeGUI(new ProductDescriptionGUI(((ShoppingGUI)frame).getProduct(command.substring(4,8))));
            gui.callGUI();
        }
        else{
            ShoppingGUI shoppingGUI = new ShoppingGUI();
            shoppingGUI.setItemAmount(((ShoppingGUI)frame).countAllProducts() - (Integer.parseInt(command)-1)*15);
            
            frame.removeOldFrame();
            gui.changeGUI(shoppingGUI);
            gui.callGUI();
        }
    }
    
}
