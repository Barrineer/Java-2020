package cop4331.controller;
import cop4331.gui.LoginGUI;
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
        else { //Submit is clicked
            String userName = gui.getUserName().replaceAll("\\s","");
            String password = gui.getPassword().replaceAll("\\s","");
            User user = new User(accountType,userName,password);
            boolean test = login.verify(user);
            
            if(accountType.equals("")){ //Submit is clicked when a new account is being created
                
                String confirmPassword = gui.getConfirmPassword();
                //Check if username/password is empty
                if(userName.equals("")){
                    gui.setLoginLabel("Please enter a non-empty username.");
                }
                else if(password.equals("")){
                    gui.setLoginLabel("Please enter a non-empty password.");
                }
                else if(password.equals(confirmPassword)){
                    //Check if this User already created an account
                    if(test){
                        gui.setLoginLabel("You already created an account! Go back to Sign In.");
                    }
                    else{
                        login.addUser(user);
                        login.createSerialization();
                        gui.setLoginLabel("Successfully created a new account! Go back to Sign In.");
                    }
                }  
                else{
                    gui.setLoginLabel("Passwords Do Not Match! Try Again.");
                }
            }
            else if(accountType.equals("Buyer")){ //Submit is clicked by a buyer account
                if(test){
                    gui.removeGUI();
                    CurrentGUI.getInstance().changeGUI("Shopping");
                    CurrentGUI.getInstance().callGUI();
                }
                else {
                    gui.setLoginLabel("Incorrect username and password combination.");
                }
                
            }
            
            else if(accountType.equals("Seller")){ //Submit is clicked by a seller account
                if(test){
                    gui.removeGUI();
                    CurrentGUI.getInstance().changeGUI("Inventory");
                    CurrentGUI.getInstance().callGUI();
                }
                else {
                    gui.setLoginLabel("Incorrect username and password combination.");
                }
            }
        }
    }
    
    public String getAccountType(){
        return this.accountType;
    }
    
}
