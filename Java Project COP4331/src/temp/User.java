package temp;
import java.util.*;
/**
 * Holds the information for the User and allows get/set methods.
 * @author mikey
 */
public class User {
    
    private String accountType;
    private String userName;
    private String password;
    private String userID;
    private String address;
    private Date age;
    
    public User(String accountType, String userName, String passsword, String userID, String address, Date age){
        this.accountType = accountType;
        this.userName = userName;
        this.password = password;
        this.userID = userID;
        this.address = address;
        this.age = (Date) age.clone();        
    }
    
    public String getAccountType(){
        return this.accountType;
    }
    
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public Date getAge(){
        return (Date) this.age.clone();
    }
    
    public void setDate(Date age){
        this.age = (Date) age.clone();
    }
}
