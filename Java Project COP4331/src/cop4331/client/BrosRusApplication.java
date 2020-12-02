package cop4331.client;
import cop4331.gui.*;
import cop4331.controller.*;
import cop4331.model.*;
/**
 *
 * @author mikey
 */
public class BrosRusApplication {
    
    public static void main(String args[]){
        Login.getInstance().loadSerialization();
        CurrentGUI.getInstance().callGUI();
    }
    
}
