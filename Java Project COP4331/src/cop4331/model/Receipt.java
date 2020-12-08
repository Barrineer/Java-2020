package cop4331.model;

/**
 * Holds information about the user's ID, the checkout ID, the total price, and the payment type.
 * @author mikey, Joseph, Malcolm Richardson
 */
public class Receipt {
    
    private Cart productList;
    private int checkoutID;
    private double total;
    private String paymentType;
    
    /**
     * Constructor for the Receipt Class
     * @param productList
     * @param checkoutID
     * @param paymentType 
     */
    public Receipt(Cart productList, int checkoutID, String paymentType){
        this.productList = (Cart) productList.clone();
        this.checkoutID = checkoutID;
        this.total = 0;
        this.paymentType = paymentType;
    }
    /**
     * Calculates the total price of all Products in the Cart.
     */
    public void calculateTotal(){
        double sum = 0;
        for(int i = 0; i < this.productList.getProductList().size();i++){
            sum += (this.productList.getProductList().get(i).getPrice() * this.productList.getProductList().get(i).getQuantity());
        }
        total = sum;
    }
    /**
     * Setter for paymentType.
     * @param paymentType 
     */
    public void setPaymentType(String paymentType){
        this.paymentType = paymentType;
    }
    /**
     * Getter for Checkout ID.
     * @return checkoutID
     */
    public int getCheckoutID(){
        return checkoutID;
    }
    /**
     * Getter for paymentType.
     * @return paymentType
     */
    public String getPaymentType(){
        return paymentType;
    }
    /**
     * Getter for calculated total.
     * @return total
     */
    public double getTotal(){
        calculateTotal();
        return total;
    }
    
}
