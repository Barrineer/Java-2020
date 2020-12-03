package cop4331.controller;
import cop4331.gui.AccountInfoGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.ShoppingGUI;
import cop4331.model.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mikey
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
        else {
            frame.removeOldFrame();
            gui.changeGUI(new AccountInfoGUI());
            gui.callGUI();
        }
    }
    
}
