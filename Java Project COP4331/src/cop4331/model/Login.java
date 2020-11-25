package cop4331.model;
import java.util.*;
/**
 * Adds a new User to a single instance of Login.
 * Uses Singleton pattern.
 * Also checks if the username and password combination matches the one in Login records.
 * @author mikey
 */
public class Login {
    
    private ArrayList<User> users;
    private static Login instance = new Login();
    
    private Login(){
        users = new ArrayList<>();
    }
    /**
     * Gets the instance of Login.
     * @return Returns the instance of Login.
     */
    public static Login getInstance(){
        return instance;
    }
    /**
     * Adds a new User to the Login.
     * @param user The User to be added to the Login.
     */
    public void addUser(User user){
        users.add(user);
    }
    /**
     * Checks if the User's credentials is equivalent to the information given.
     * @param user The User trying to login.
     * @return Returns true if the credentials match, false otherwise.
     * @Precondition Can only be called if the users ArrayList has at least 1 User object.
     */
    public boolean verify(User user){
        boolean verify = false;
        if(users.size() > 0){        
            for(int i = 0;i < users.size();i++){
                if(users.get(i).getUserName().equals(user.getUserName())){
                    if(users.get(i).getPassword().equals(user.getPassword()))
                        verify = true;
                }
            }
        }
        return verify;
    }
    
}
