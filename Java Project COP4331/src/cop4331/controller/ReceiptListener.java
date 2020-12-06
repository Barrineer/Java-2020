package cop4331.controller;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.ShoppingGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author mikey, Joseph
 */
public class ReceiptListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        MainFrameGUI frame = CurrentGUI.getInstance().getFrame();
        CurrentGUI gui = CurrentGUI.getInstance();
        
        if(command.equals("Return")){
            frame.removeOldFrame();
            gui.changeGUI(new ShoppingGUI());
            gui.callGUI();
        }
        
    }
    
}
