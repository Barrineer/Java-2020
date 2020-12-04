package cop4331.gui;
import cop4331.model.*;
import cop4331.controller.InventoryListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author mikey
 */
public class InventoryGUI extends MainFrameGUI{
    
    private JButton productButton;
    private JButton nextPageButton;
    private JButton newProductButton;
    
    private JLabel shoppingLabel;
    private JLabel pageLabel;
    
    private int itemAmount = Login.getInstance().getCurrentUser().getInventory().getInventory().size();
    private int pageCounter = 1;
    private int totalPages = 1;
    
    public void createButtonEvents(){
        switchButton = new JButton("Switch to buyer");
        accountButton = new JButton(Login.getInstance().getCurrentUser().getUserName());
        newProductButton = new JButton("Add new");
        
        switchButton.setActionCommand("Switch");
        accountButton.setActionCommand("Account");
        newProductButton.setActionCommand("New");
        
        switchButton.addActionListener(new InventoryListener());
        accountButton.addActionListener(new InventoryListener());
        newProductButton.addActionListener(new InventoryListener());
        
        switchButton.setFont(font);
        accountButton.setFont(font);
        newProductButton.setFont(font);
    }
    
    public void createGUI(){
        setPageCounter();
        setTotalPages();
        GridBagConstraints c = new GridBagConstraints();
        User user = Login.getInstance().getCurrentUser();
        Inventory inventory = user.getInventory();
        ArrayList<Product> products = inventory.getInventory();
        boolean underFifteen = false;
        int i = 0;
        
        if(itemAmount != 0)
            underFifteen = true;
        
        createNewFrame("BrosRus Application",1000,1000);
        createTopPanel();
        
        shoppingLabel = new JLabel("Select a product to edit or add a new one.",JLabel.CENTER);
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.anchor = NW;
        mainFrame.add(shoppingLabel,c);
        
        c.gridx = 1;
        mainFrame.add(newProductButton,c);
        c.gridx = 0;
        
        //Put the Products onto the page.
        while(underFifteen){
            if(i >= 14 || i >= itemAmount-1)
                underFifteen = false;
            
            String name = products.get(i+(products.size()-itemAmount)).getName();
            c.gridy += 1;
            createProductButton("Name: " + name);
            addProductButton(c);
            i++;
        }        
        
        //Page Label
        c.gridy += 1;
        c.gridx = 0;
        c.anchor = CENTER;
        pageLabel = new JLabel("Page:",JLabel.CENTER);
        mainFrame.add(pageLabel,c);
        
        //Pages
        for(int j = 1;j < totalPages+1;j++){
            c.gridx += 1;
            createPageButton(Integer.toString(j));
            addPageButton(c);
        }
        
        
        shoppingLabel.setFont(font);
        pageLabel.setFont(font);
        
    }
    
    public void createProductButton(String productName){
        productButton = new JButton(productName);
        productButton.setActionCommand(productName);
        productButton.addActionListener(new InventoryListener());
        productButton.setFont(font);
    }
    
    public void addProductButton(GridBagConstraints c){
        mainFrame.add(productButton,c);
    }
    
    public void createPageButton(String number){
        nextPageButton = new JButton(number);
        nextPageButton.setActionCommand(number);
        nextPageButton.addActionListener(new InventoryListener());
        nextPageButton.setFont(font);
    }
    
    public void addPageButton(GridBagConstraints c){
        mainFrame.add(nextPageButton,c);
    }
    
    private void setPageCounter(){
        pageCounter = (Login.getInstance().getCurrentUser().getInventory().getInventory().size() - itemAmount)/15 + 1;
    }
    
    public int getPageNumber(){
        return pageCounter;
    }
    
    private void setTotalPages(){
        if(Login.getInstance().getCurrentUser().getInventory().getInventory().size() % 15 == 0){
            totalPages = Login.getInstance().getCurrentUser().getInventory().getInventory().size()/15;
        }
        else{
            totalPages = Login.getInstance().getCurrentUser().getInventory().getInventory().size()/15 + 1;
        }
    }
    
    public void setItemAmount(int number){
        itemAmount = number;
    }
    
}
