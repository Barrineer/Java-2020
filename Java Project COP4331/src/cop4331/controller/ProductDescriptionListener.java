package cop4331.controller;
import cop4331.gui.InventoryGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.ProductDescriptionGUI;
import cop4331.gui.ShoppingGUI;
import cop4331.model.Login;
import cop4331.model.Product;
import cop4331.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for the ProductDescriptionGUI.
 * @author mikey, Joseph, Malcolm Richardson
 */
public class ProductDescriptionListener implements ActionListener{
    
    /**
     * Called when a button is pressed in ProductDescriptionGUI
     * @param e ActionEvent object
     */
    @Override
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
        else if(command.equals("Add")){
            try{
                Product product = ((ProductDescriptionGUI)frame).getProduct();
                int quantity = ((ProductDescriptionGUI)frame).getQuantity();
                
                if(quantity > product.getQuantity() && product.getQuantity() != 0){
                    ((ProductDescriptionGUI)frame).setQuantityLabel("Quantity too large!");
                }
                else if(product.getQuantity() == 0){
                    ((ProductDescriptionGUI)frame).setQuantityLabel("All Sold Out Sorry!");
                }
                else{
                    user.getCart().addProduct(product,quantity);
                    product.setQuantity(product.getQuantity() - quantity);
                    ((ProductDescriptionGUI)frame).setQuantityLabel("Item Added Successfully!");
                }
            }
            catch(NumberFormatException x){
                ((ProductDescriptionGUI)frame).setQuantityLabel("Please enter a valid number.");
            }
        }
        else{
            Product product = ((ProductDescriptionGUI)frame).getProduct();
            user.getInventory().removeProduct(product);
            frame.removeOldFrame();
            gui.changeGUI(new InventoryGUI());
            gui.callGUI();
        }
        
        
    }
    
}
