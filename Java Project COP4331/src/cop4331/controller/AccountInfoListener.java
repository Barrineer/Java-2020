package cop4331.controller;
import cop4331.gui.AccountInfoGUI;
import cop4331.gui.InventoryGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.ShoppingGUI;
import cop4331.model.Login;
import cop4331.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/**
 *
 * @author mikey
 */
public class AccountInfoListener implements ActionListener{
    
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
        else{
            try{
                
                String userName = ((AccountInfoGUI)frame).getUserName().replaceAll("\\s","");
                String password = ((AccountInfoGUI)frame).getPassword().replaceAll("\\s","");
                String address = ((AccountInfoGUI)frame).getAddress().replaceAll("\\s","");
                String age = ((AccountInfoGUI)frame).getAge().replaceAll("\\s","");            
                
                if(!(user.getUserName().equals(userName))){
                    user.setUserName(userName);
                    ((AccountInfoGUI)frame).setSubmitDetailLabel("Successfully made changes!");
                }
                if(!(user.getPassword().equals(password))){
                    user.setPassword(password);
                    ((AccountInfoGUI)frame).setSubmitDetailLabel("Successfully made changes!");
                }
                if(!(user.getAddress().equals(address))){
                    user.setAddress(address);
                    ((AccountInfoGUI)frame).setSubmitDetailLabel("Successfully made changes!");
                }

                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
                int currentDay = Calendar.getInstance().get(Calendar.DATE);
                int year = Integer.parseInt(age.substring(0,4));
                int month = Integer.parseInt(age.substring(5,7));
                int day = Integer.parseInt(age.substring(8));

                Date DOB = user.getAge();

                if(year < currentYear && day <= 31 && month-1 <= 12){
                    DOB = new GregorianCalendar(year,month-1,day).getTime();
                }
                else if(year == currentYear && month-1 < currentMonth && day <= 31 && month-1 <= 12){
                    DOB = new GregorianCalendar(year,month-1,day).getTime();    
                }
                else if(year == currentYear && month-1 == currentMonth && day <= currentDay && day <= 31 && month-1 <= 12){
                    DOB = new GregorianCalendar(year,month-1,day).getTime();
                }
                else{
                    ((AccountInfoGUI)frame).setSubmitDetailLabel("Please enter a correct DOB.");
                }

                if(!(user.getAge().equals(DOB))){
                    user.setDate(DOB);
                    ((AccountInfoGUI)frame).setSubmitDetailLabel("Successfully made changes!");
                }
                Login.getInstance().createSerialization();
            }
            catch(StringIndexOutOfBoundsException x){
                ((AccountInfoGUI)frame).setSubmitDetailLabel("Please enter a correct DOB.");
            }
        }
    }
    
}
