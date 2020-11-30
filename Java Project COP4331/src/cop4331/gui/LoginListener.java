package cop4331.gui;
import cop4331.model.Login;
import cop4331.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author mikey
 */
public class LoginListener implements ActionListener{

    private String accountType = "";
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        LoginGUI gui = LoginGUI.getInstance();
        Login login = Login.getInstance();
        if(command.equals("New")){
            gui.newUserGUI();
        }
        else if(command.equals("Buyer")){
            this.accountType = "Buyer";
            gui.changeLoginGUI();
        }
        else if(command.equals("Seller")){
            this.accountType = "Seller";
            gui.changeLoginGUI();
        }
        else if(command.equals("Back")){
            this.accountType = "";
            gui.goBackGUI();
        }
        else {
            if(accountType.equals("")){
                String userName = gui.getUserName();
                String password = gui.getPassword();
                String confirmPassword = gui.getConfirmPassword();
                
                if(password.equals(confirmPassword)){
                    User user = new User(accountType,userName,password);
                    
                    //Check if this User already created an account
                    if(login.verify(user)){
                        gui.setLoginLabel("You already created an account! Go back to Sign In.");
                    }
                    else{
                        login.addUser(user);
                        gui.setLoginLabel("Successfully created a new account! Go back to Sign In.");
                    }
                }  
                else{
                    gui.setLoginLabel("Passwords Do Not Match! Try Again.");
                }
            }
            else if(accountType.equals("Buyer")){
                //Go to next JFrame
            }
            else if(accountType.equals("Seller")){
                //Go to next JFrame
            }
            else{
                gui.setLoginLabel("Please Go Back To Sign In.");
                
            }
        }
    }
    
    public String getAccountType(){
        return this.accountType;
    }
    
    public static void main(String args[]){
        LoginGUI.getInstance();
    }
    
}
