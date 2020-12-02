package cop4331.model;
import java.util.*;
/**
 * Holds the information for the User and allows get/set methods.
 * @author mikey
 */
public class User implements java.io.Serializable{
    
    private String accountType;
    private String userName;
    private String password;
    private String address;
    private Date age;
    
    private int userID;
    private static int userIDCounter = 1;
    
    private Cart cart;
    private Inventory inventory;
    
    public User(String accountType, String userName, String password, String address, Date age){
        this.accountType = accountType;
        this.userName = userName;
        this.password = password;
        this.userID = createNewID();
        this.address = address;
        this.age = (Date) age.clone();
        this.cart = new Cart(userID);
        this.inventory = new Inventory(userID);
    }
    public User(String accountType, String userName, String password){
        this.accountType = accountType;
        this.userName = userName;
        this.password = password;
        this.userID = createNewID();
        this.address = "none";
        this.age = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();
        this.cart = new Cart(userID);
        this.inventory = new Inventory(userID);
    }
    
    private int createNewID(){
        userIDCounter += 1;
        return userIDCounter;
    }
    /**
     * Getter for the userID attribute.
     * @return Returns an int of the user's ID.
     */
    public int getUserID(){
        return this.userID;
    }
    /**
     * Getter for the accountType attribute.
     * @return Returns a String of the account type of the User.
     */
    public String getAccountType(){
        return this.accountType;
    }
    /**
     * Setter for the accountType attribute.
     * @param accountType The new String of the accountType.
     */
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
    /**
     * Getter for the userName attribute.
     * @return Returns a String of the username of the User.
     */
    public String getUserName(){
        return this.userName;
    }
    /**
     * Setter for the userName attribute.
     * @param userName The new String of the userName.
     */
    public void setUserName(String userName){
        this.userName = userName;
    }
    /**
     * Getter for the password attribute.
     * @return Returns a String of the password of the User.
     */
    public String getPassword(){
        return this.password;
    }
    /**
     * Setter for the password attribute.
     * @param password The new String of the password.
     */
    public void setPassword(String password){
        this.password = password;
    }
    /**
     * Getter for the address attribute.
     * @return Returns a String of the address of the User.
     */
    public String getAddress(){
        return this.address;
    }
    /**
     * Setter for the address attribute.
     * @param address The new String of the address.
     */
    public void setAddress(String address){
        this.address = address;
    }
    /**
     * Getter for the age attribute.
     * The returned Date is cloned.
     * @return Returns a Date object of the age of the User.
     */
    public Date getAge(){
        return (Date) this.age.clone();
    }
    /**
     * Setter for the age attribute.
     * The new Date is cloned.
     * @param age The new Date object of the age.
     */
    public void setDate(Date age){
        this.age = (Date) age.clone();
    }
}
