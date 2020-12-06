package cop4331.controller;
import cop4331.gui.*;
import cop4331.model.Login;
import cop4331.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author mikey, Joseph
 */
public class LoginListener implements ActionListener{

    private String accountType = "";
    
    /**
     * Overrides ActionListener
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        MainFrameGUI gui = CurrentGUI.getInstance().getFrame();
        Login login = Login.getInstance();
        
        if(command.equals("New")){
            ((LoginGUI)gui).newUserGUI();
        }
        else if(command.equals("Buyer")){
            this.accountType = "Buyer";
            ((LoginGUI)gui).changeLoginGUI();
        }
        else if(command.equals("Seller")){
            this.accountType = "Seller";
            ((LoginGUI)gui).changeLoginGUI();
        }
        else if(command.equals("Back")){
            this.accountType = "";
            ((LoginGUI)gui).goBackGUI();
        }
        else { //Submit is clicked
            String userName = ((LoginGUI)gui).getUserName().replaceAll("\\s","");
            String password = ((LoginGUI)gui).getPassword().replaceAll("\\s","");
            User user = new User(accountType,userName,password);
            boolean test = login.verify(user);
            
            if(accountType.equals("")){ //Submit is clicked when a new account is being created
                
                String confirmPassword = ((LoginGUI)gui).getConfirmPassword();
                //Check if username/password is empty
                if(userName.equals("")){
                    ((LoginGUI)gui).setLoginLabel("Please enter a non-empty username.");
                }
                else if(password.equals("")){
                    ((LoginGUI)gui).setLoginLabel("Please enter a non-empty password.");
                }
                else if(password.equals(confirmPassword)){
                    //Check if this User already created an account
                    if(test){
                        ((LoginGUI)gui).setLoginLabel("You already created an account! Go back to Sign In.");
                    }
                    else{
                        login.addUser(user);
                        login.createSerialization();
                        ((LoginGUI)gui).setLoginLabel("Successfully created a new account! Go back to Sign In.");
                    }
                }  
                else{
                    ((LoginGUI)gui).setLoginLabel("Passwords Do Not Match! Try Again.");
                }
            }
            else if(accountType.equals("Buyer")){ //Submit is clicked by a buyer account
                if(test){
                    login.getCurrentUser().setAccountType(accountType);
                    login.createSerialization();
                    gui.removeOldFrame();
                    CurrentGUI.getInstance().changeGUI(new ShoppingGUI());
                    CurrentGUI.getInstance().callGUI();
                }
                else {
                    ((LoginGUI)gui).setLoginLabel("Incorrect username and password combination.");
                }
                
            }
            
            else if(accountType.equals("Seller")){ //Submit is clicked by a seller account
                if(test){
                    login.getCurrentUser().setAccountType(accountType);
                    login.createSerialization();
                    gui.removeOldFrame();
                    CurrentGUI.getInstance().changeGUI(new InventoryGUI());
                    CurrentGUI.getInstance().callGUI();
                }
                else {
                    ((LoginGUI)gui).setLoginLabel("Incorrect username and password combination.");
                }
            }
        }
    }
    /**
     * Getter for account type
     * @return account type
     */
    public String getAccountType(){
        return this.accountType;
    }
    
}
