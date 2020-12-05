package cop4331.controller;
import cop4331.gui.CartGUI;
import cop4331.gui.CheckoutGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.ReceiptGUI;
import cop4331.model.Login;
import cop4331.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author mikey
 */
public class CheckoutListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        MainFrameGUI frame = CurrentGUI.getInstance().getFrame();
        CurrentGUI gui = CurrentGUI.getInstance();
        User user = Login.getInstance().getCurrentUser();
        
        if(command.equals("Back")){
            frame.removeOldFrame();
            gui.changeGUI(new CartGUI());
            gui.callGUI();
        }
        else{
            frame.removeOldFrame();
            gui.changeGUI(new ReceiptGUI(((CheckoutGUI)frame).getReceipt()));
            gui.callGUI();
            user.getCart().emptyCart();
        }
        
    }
    
}
