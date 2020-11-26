package cop4331.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author mikey
 */
public class LoginListener implements ActionListener{

    private String accountType;
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if(command.equals("New")){
            LoginGUI.getInstance().newUserGUI();
        }
        else if(command.equals("Buyer")){
            this.accountType = "Buyer";
            LoginGUI.getInstance().changeLoginGUI();
        }
        else if(command.equals("Seller")){
            this.accountType = "Seller";
            LoginGUI.getInstance().changeLoginGUI();
        }
        else if(command.equals("Back")){
            this.accountType = "";
            LoginGUI.getInstance().goBackGUI();
        }
        else {
            //Go to next JFrame 
        }
    }
    
    public String getAccountType(){
        return this.accountType;
    }
    
    public static void main(String args[]){
        LoginGUI.getInstance();
    }
    
}
