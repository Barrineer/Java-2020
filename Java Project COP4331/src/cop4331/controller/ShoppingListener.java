package cop4331.controller;
import cop4331.gui.InventoryGUI;
import cop4331.gui.AccountInfoGUI;
import cop4331.gui.CartGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.model.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mikey
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
        else{
            frame.removeOldFrame();
            gui.changeGUI(new CartGUI());
            gui.callGUI();
        }
    }
    
}
