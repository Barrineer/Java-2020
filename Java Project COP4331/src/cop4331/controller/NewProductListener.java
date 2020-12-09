package cop4331.controller;
import cop4331.gui.InventoryGUI;
import cop4331.gui.MainFrameGUI;
import cop4331.gui.NewProductGUI;
import cop4331.model.Login;
import cop4331.model.Product;
import cop4331.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ActionListener for the NewProductGUI.
 * @author mikey, Joseph, Malcolm Richardson
 */
public class NewProductListener implements ActionListener{

    /**
     * Called when a button is pressed in NewProductGUI
     * @param e ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        MainFrameGUI frame = CurrentGUI.getInstance().getFrame();
        CurrentGUI gui = CurrentGUI.getInstance();
        User user = Login.getInstance().getCurrentUser();
        
        String name = ((NewProductGUI)frame).getName();
        String description = ((NewProductGUI)frame).getDescription();
        String original = ((NewProductGUI)frame).getOriginalPrice();
        String price = ((NewProductGUI)frame).getPrice();
        String quantity = ((NewProductGUI)frame).getQuantity();
        String address = ((NewProductGUI)frame).getAddress();;
        
        if(command.equals("Add")){
            
            try{
            if(name == "" || description == "" || price == "" || quantity == "" || address == "" || original == ""){
                ((NewProductGUI)frame).setDetailLabel("Please enter at least a single value into each category.");
            }
            else{
                Product product = new Product(name,description,Double.parseDouble(price),Double.parseDouble(original),Integer.parseInt(quantity),user.getUserID(),address);
                user.getInventory().addProduct(product);
                ((NewProductGUI)frame).setDetailLabel("New product created successfully!");
                Login.getInstance().createSerialization();
            }
            }
            catch(NumberFormatException x){
                ((NewProductGUI)frame).setDetailLabel("Please enter a numerical value into both the price and quantity fields.");
            }
            
        }
        else{
            frame.removeOldFrame();
            gui.changeGUI(new InventoryGUI());
            gui.callGUI();
        }
        
    }
    
}
