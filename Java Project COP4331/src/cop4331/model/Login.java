package cop4331.model;
import java.util.*;
/**
 * Adds a new User to a single instance of Login.
 * Also checks if the username and password combination matches the one in Login records.
 * @author mikey
 */
public class Login {
    
    private ArrayList<User> users = new ArrayList<>();
    
    private Login(){}
    
    public void addUser(User user){
        users.add(user);
    }
    
    public boolean verify(User user){
        boolean verify = false;
        
        for(int i = 0;i < users.size();i++){
            if(users.get(i).getUserName().equals(user.getUserName())){
                if(users.get(i).getPassword().equals(user.getPassword()))
                    verify = true;
            }
        }
        return verify;
    }
    
}
