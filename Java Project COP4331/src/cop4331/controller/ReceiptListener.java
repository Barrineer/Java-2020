package cop4331.controller;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.ShoppingGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ActionListener for the ReceiptGUI.
 * @author mikey, Joseph, Malcolm Richardson
 */
public class ReceiptListener implements ActionListener{

    /**
     * Called when a button is pressed in ReceiptGUI
     * @param e ActionEvent object
     */
    @Override
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
