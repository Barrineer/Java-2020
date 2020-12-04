package cop4331.controller;
import cop4331.gui.InventoryGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.ShoppingGUI;
import cop4331.model.Login;
import cop4331.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mikey
 */
public class ProductDescriptionListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        MainFrameGUI frame = CurrentGUI.getInstance().getFrame();
        CurrentGUI gui = CurrentGUI.getInstance();
        User user = Login.getInstance().getCurrentUser();
        
        if(command.equals("Back")){
            if(user.getAccountType().equals("Buyer")){
                frame.removeOldFrame();
                gui.changeGUI(new ShoppingGUI());
                gui.callGUI();
            }
            else{
                frame.removeOldFrame();
                gui.changeGUI(new InventoryGUI());
                gui.callGUI();
            }
            
        }
        
        
    }
    
}
