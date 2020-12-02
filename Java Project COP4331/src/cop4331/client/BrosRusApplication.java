package cop4331.client;
import cop4331.gui.*;
import cop4331.controller.*;
import cop4331.model.*;
/**
 *
 * @author mikey
 */
public class BrosRusApplication {
    
    //Various Products that will be used as examples:
    // JOEY MAKE SOME PRODUCTS HERE TYTY Like 20 should be good idk go ham bud.
    
    public static void main(String args[]){
        Login.getInstance().loadSerialization();
        CurrentGUI.getInstance().callGUI();
    }
    
}
