package cop4331.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * The GUI for the BrosRus Application.
 * @author mikey
 */
public class LoginGUI {

    private JFrame loginFrame;
    private JPanel loginPanel;
    
    private JLabel accountTypeLabel;
    private JButton buyerButton;
    private JButton sellerButton;
    private JButton backButton;
    
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameField;
    private JTextField passwordField;
    
    
    public LoginGUI(){
        createLoginGUI();
    }
    
    private void createLoginGUI(){
        loginFrame = new JFrame("Sign in to BrosRus");
        loginFrame.setSize(500,500);
        loginFrame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        accountTypeLabel = new JLabel("Sign in as a Buyer or Seller?", JLabel.CENTER);
        
        loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());
        
        buyerButton = new JButton("Buyer");
        sellerButton = new JButton("Seller");
        
        loginPanel.add(buyerButton);
        loginPanel.add(sellerButton);
        
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        loginFrame.add(accountTypeLabel,c);
        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        LoginGUI test = new LoginGUI();
    }

}
