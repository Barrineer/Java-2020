package cop4331.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * The Login GUI for the BrosRus Application.
 * @author mikey
 */
public class LoginGUI {

    private JFrame loginFrame;
    private JPanel loginPanel;
    private JPanel signUpPanel;
    
    private JLabel accountTypeLabel;
    private JButton buyerButton;
    private JButton sellerButton;
    private JButton backButton;
    
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel newUserLabel;
    private JTextField userNameField;
    private JTextField passwordField;
    private JButton newUserButton;
    private JButton submitButton;
    
    private LoginListener command = new LoginListener();
    GridBagConstraints c = new GridBagConstraints();
    
    private static LoginGUI instance = new LoginGUI();
    
    private LoginGUI(){
        createLoginGUI();
        createButtonEvents();
    }
    
    private void createLoginGUI(){
        loginFrame = new JFrame("Sign in to BrosRus");
        loginFrame.setSize(500,500);
        loginFrame.setLayout(new GridBagLayout());
        
        accountTypeLabel = new JLabel("Sign in as a Buyer or Seller?", JLabel.CENTER);
        c.gridy = 0;
        loginFrame.add(accountTypeLabel,c);
        
        loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());
        c.gridy = 1;
        c.ipady = 75;
        loginFrame.add(loginPanel,c);
        
        newUserLabel = new JLabel("or Sign up:", JLabel.CENTER);
        c.gridy = 2;
        c.ipadx = 0;
        c.ipady = 0;
        loginFrame.add(newUserLabel,c);
        
        signUpPanel = new JPanel();
        signUpPanel.setLayout(new FlowLayout());
        c.gridy = 3;
        loginFrame.add(signUpPanel,c);
        
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
    }
    
    public static LoginGUI getInstance(){
        return instance;
    }
    
    private void createButtonEvents(){
        newUserButton = new JButton("Sign Up");
        buyerButton = new JButton("Buyer");
        sellerButton = new JButton("Seller");
        backButton = new JButton("Back");
        submitButton = new JButton("Submit");
        
        newUserButton.setActionCommand("New");
        buyerButton.setActionCommand("Buyer");
        sellerButton.setActionCommand("Seller");
        backButton.setActionCommand("Back");
        submitButton.setActionCommand("Submit");
        
        newUserButton.addActionListener(command);
        buyerButton.addActionListener(command);
        sellerButton.addActionListener(command);
        backButton.addActionListener(command);
        submitButton.addActionListener(command);
        
        loginPanel.add(buyerButton);
        loginPanel.add(sellerButton);
        signUpPanel.add(newUserButton);
        
        loginFrame.repaint();
    }
    
    public void newUserGUI(){
        
    }
    
    public void changeLoginGUI(){
        
        accountTypeLabel.setText("Signing in as a " + command.getAccountType());
        userNameLabel = new JLabel("Username: ");
        userNameField = new JTextField(17);
        
        passwordLabel = new JLabel("Password: ");
        passwordField = new JTextField(17);
        
        loginPanel.remove(buyerButton);
        loginPanel.remove(sellerButton);
        loginFrame.remove(newUserLabel);
        loginFrame.remove(signUpPanel);
        
        loginPanel.add(userNameLabel);
        loginPanel.add(userNameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(backButton);
        loginPanel.add(submitButton);
        
        loginFrame.repaint();
    }
    
    public void goBackGUI(){
        
        accountTypeLabel.setText("Sign in as a Buyer or Seller?");
        
        loginFrame.remove(loginPanel);
        loginFrame.remove(signUpPanel);
        
        loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());
        c.gridy = 1;
        c.ipady = 75;
        loginFrame.add(loginPanel,c);
        
        newUserLabel = new JLabel("or Sign up:", JLabel.CENTER);
        c.gridy = 2;
        c.ipadx = 0;
        c.ipady = 0;
        loginFrame.add(newUserLabel,c);
        
        signUpPanel = new JPanel();
        signUpPanel.setLayout(new FlowLayout());
        c.gridy = 3;
        loginFrame.add(signUpPanel,c);
        
        loginPanel.add(buyerButton);
        loginPanel.add(sellerButton);
        signUpPanel.add(newUserButton);
        
        loginFrame.repaint();
        
    }

}
