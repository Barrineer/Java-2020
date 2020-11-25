package cop4331.model;

/**
 * Holds information about the user's ID, the checkout ID, the total price, and the payment type.
 * @author mikey
 */
public class Receipt {
    
    private Cart productList;
    private int checkoutID;
    private double total;
    private String paymentType;
    
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
        for(int i = 0; i < this.productList.getProductList().size();i++){
            this.total += (this.productList.getProductList().get(i).getPrice() * this.productList.getProductList().get(i).getQuantity());
        }
    }
    
}
