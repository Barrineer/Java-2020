package cop4331.client;
import cop4331.gui.*;
import cop4331.controller.*;
import cop4331.model.*;
/**
 *
 * @author mikey
 */
public class BrosRusApplication {
    /**
     * ACCOUNT_GUI is for the AccountInfoGUI.
     */
    public static final String ACCOUNT_GUI = "Account";
    /**
     * CART_GUI is for the CartGUI.
     */
    public static final String CART_GUI = "Cart";
    /**
     * CHECKOUT_GUI is for the CheckoutGUI.
     */
    public static final String CHECKOUT_GUI = "Checkout";
    /**
     * INVENTORY_GUI is for the InventoryGUI.
     */
    public static final String INVENTORY_GUI = "Inventory";
    /**
     * LOGIN_GUI is for the LoginGUI.
     */
    public static final String LOGIN_GUI = "Login";
    /**
     * NEW_PRODUCT_GUI is for the NewProductGUI.
     */
    public static final String NEW_PRODUCT_GUI = "New";
    /**
     * PRODUCT_DESCRIPTION_GUI is for the ProductDescriptionGUI.
     */
    public static final String PRODUCT_DESCRIPTION_GUI = "Product";
    /**
     * SHOPPING_GUI is for the ShoppingGUI.
     */
    public static final String SHOPPING_GUI = "Shopping";
    
    public static void main(String args[]){
        Login.getInstance().loadSerialization();
        CurrentGUI.getInstance().startGUI();
    }
    
}
