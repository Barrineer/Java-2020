package cop4331.gui;
import cop4331.controller.LoginListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * The Login GUI for the BrosRus Application.
 * @author mikey, Joseph, Malcolm Richardson
 */
public class LoginGUI extends MainFrameGUI{

    private JPanel loginPanel;
    private JPanel signUpPanel;
    
    private JLabel loginLabel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JLabel newUserLabel;
    
    private JTextField userNameField;
    private JTextField passwordField;
    private JTextField confirmPasswordField;
    
    private JButton newUserButton;
    private JButton submitButton;
    private JButton buyerButton;
    private JButton sellerButton;
    private JButton backButton;
    
    private LoginListener command = new LoginListener();
    
    /**
     * Creates a GUI for Login
     */
    public void createGUI(){
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("Welcome to BrosRus!",500,500);
        loginLabel = new JLabel("Sign in as a Buyer or Seller?", JLabel.CENTER);
        c.gridy = 0;
        mainFrame.add(loginLabel,c);
        
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        c.gridy = 1;
        c.ipady = 0;
        mainFrame.add(loginPanel,c);
        
        newUserLabel = new JLabel("or Sign up:", JLabel.CENTER);
        c.gridy = 2;
        mainFrame.add(newUserLabel,c);
        
        signUpPanel = new JPanel();
        signUpPanel.setLayout(new FlowLayout());
        c.gridy = 3;
        mainFrame.add(signUpPanel,c);
        
        loginPanel.add(buyerButton);
        loginPanel.add(sellerButton);
        signUpPanel.add(newUserButton);
        
        loginLabel.setFont(font);
        newUserLabel.setFont(font);
        newUserButton.setFont(font);
        buyerButton.setFont(font);
        sellerButton.setFont(font);
    }
    /**
     * Creates button events for the Login GUI
     */
    public void createButtonEvents(){
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
    }
    /**
     * GUI for creating a new user
     */
    public void newUserGUI(){
        GridBagConstraints c = new GridBagConstraints();
        loginLabel.setText("Create a new account");
        
        mainFrame.remove(loginPanel);
        mainFrame.remove(newUserLabel);
        signUpPanel.remove(newUserButton);
        
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        c.gridy = 1;
        c.ipady = 20;
        mainFrame.add(loginPanel,c);
        
        userNameLabel = new JLabel("Username: ");
        c.gridy = 0;
        c.gridx = 0;
        c.ipady = 0;
        loginPanel.add(userNameLabel,c);
        
        userNameField = new JTextField(17);
        c.gridy = 0;
        c.gridx = 1;
        c.ipady = 0;
        loginPanel.add(userNameField,c);
        
        passwordLabel = new JLabel("Password: ");
        c.gridy = 1;
        c.gridx = 0;
        c.ipady = 0;
        loginPanel.add(passwordLabel,c);
        
        passwordField = new JPasswordField(17);
        c.gridy = 1;
        c.gridx = 1;
        c.ipady = 0;
        loginPanel.add(passwordField,c);
        
        confirmPasswordLabel = new JLabel("Repeat Password: ");
        c.gridy = 2;
        c.gridx = 0;
        c.ipady = 0;
        loginPanel.add(confirmPasswordLabel,c);
        
        confirmPasswordField = new JPasswordField(17);
        c.gridy = 2;
        c.gridx = 1;
        c.ipady = 0;
        loginPanel.add(confirmPasswordField,c);
        
        c.gridy = 3;
        c.gridx = 0;
        c.ipady = 0;
        c.weighty = 0.5;
        c.insets = new Insets(10,0,0,0);
        c.anchor = SOUTH;
        loginPanel.add(backButton,c);
        
        c.gridy = 3;
        c.gridx = 1;
        c.ipady = 0;
        loginPanel.add(submitButton,c);
        
        userNameLabel.setFont(font);
        passwordLabel.setFont(font);
        confirmPasswordLabel.setFont(font);
        userNameField.setFont(font);
        passwordField.setFont(font);
        confirmPasswordField.setFont(font);
        submitButton.setFont(font);
        backButton.setFont(font);
        
        mainFrame.repaint();
    }
    /**
     * Creates the buyer/seller different GUIs
     */
    public void changeLoginGUI(){
        GridBagConstraints c = new GridBagConstraints();
        loginLabel.setText("Signing in as a " + command.getAccountType());
        userNameLabel = new JLabel("Username: ");
        userNameField = new JTextField(17);
        
        passwordLabel = new JLabel("Password: ");
        passwordField = new JTextField(17);
        
        mainFrame.remove(loginPanel);
        mainFrame.remove(newUserLabel);
        signUpPanel.remove(newUserButton);
        
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        c.gridy = 1;
        c.ipady = 20;
        mainFrame.add(loginPanel,c);
        
        userNameLabel = new JLabel("Username: ");
        c.gridy = 0;
        c.gridx = 0;
        c.ipady = 0;
        loginPanel.add(userNameLabel,c);
        
        userNameField = new JTextField(17);
        c.gridy = 0;
        c.gridx = 1;
        c.ipady = 0;
        loginPanel.add(userNameField,c);
        
        passwordLabel = new JLabel("Password: ");
        c.gridy = 1;
        c.gridx = 0;
        c.ipady = 0;
        loginPanel.add(passwordLabel,c);
        
        passwordField = new JPasswordField(17);
        c.gridy = 1;
        c.gridx = 1;
        c.ipady = 0;
        loginPanel.add(passwordField,c);
        
        c.gridy = 3;
        c.gridx = 0;
        c.ipady = 0;
        c.weighty = 0.5;
        c.insets = new Insets(10,0,0,0);
        c.anchor = SOUTH;
        loginPanel.add(backButton,c);
        
        c.gridy = 3;
        c.gridx = 1;
        c.ipady = 0;
        loginPanel.add(submitButton,c);
        
        userNameLabel.setFont(font);
        passwordLabel.setFont(font);
        userNameField.setFont(font);
        passwordField.setFont(font);
        submitButton.setFont(font);
        backButton.setFont(font);
        
        mainFrame.repaint();
    }
    /**
     * GUI for back button event
     */
    public void goBackGUI(){
        GridBagConstraints c = new GridBagConstraints();
        loginLabel.setText("Sign in as a Buyer or Seller?");
        
        mainFrame.remove(loginPanel);
        mainFrame.remove(newUserLabel);
        
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        c.gridy = 1;
        c.ipady = 0;
        mainFrame.add(loginPanel,c);
        
        newUserLabel = new JLabel("or Sign up:", JLabel.CENTER);
        c.gridy = 2;
        c.ipady = 0;
        mainFrame.add(newUserLabel,c);
        
        loginPanel.add(buyerButton);
        loginPanel.add(sellerButton);
        signUpPanel.add(newUserButton);

        loginLabel.setFont(font);
        newUserLabel.setFont(font);
        newUserButton.setFont(font);
        buyerButton.setFont(font);
        sellerButton.setFont(font);
        
        mainFrame.repaint();
        
    }
    /**
     * Getter for userNameField
     * @return string of username
     */
    public String getUserName(){
        return this.userNameField.getText();
    }
    /**
     * Getter for passwordField
     * @return string of password
     */
    public String getPassword(){
        return this.passwordField.getText();
    }
    /**
     * Getter for confirmPasswordField
     * @return string of confirmed password 
     */
    public String getConfirmPassword(){
        return this.confirmPasswordField.getText();
    }
    /**
     * sets text for the Login Label
     * @param newText 
     */
    public void setLoginLabel(String newText){
        loginLabel.setText(newText);
    }
    
    

}
