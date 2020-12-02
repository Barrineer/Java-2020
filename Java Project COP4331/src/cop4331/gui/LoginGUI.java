package cop4331.gui;
import cop4331.controller.LoginListener;
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
    
    private final int NORTH = GridBagConstraints.NORTH;
    private final int SOUTH = GridBagConstraints.SOUTH;
    private final int EAST = GridBagConstraints.EAST;
    private final int WEST = GridBagConstraints.WEST;
    private final int CENTER = GridBagConstraints.CENTER;
    private final int REMAINDER = GridBagConstraints.REMAINDER;
    
    private static LoginGUI instance = new LoginGUI();
    
    private LoginGUI(){
        createButtonEvents();
        createLoginGUI();
    }
    
    public static LoginGUI getInstance(){
        return instance;
    }
    
    private void createLoginGUI(){
        GridBagConstraints c = new GridBagConstraints();
        loginFrame = new JFrame("Sign in to BrosRus");
        loginFrame.setSize(500,500);
        loginFrame.setLayout(new GridBagLayout());
        
        loginLabel = new JLabel("Sign in as a Buyer or Seller?", JLabel.CENTER);
        c.gridy = 0;
        loginFrame.add(loginLabel,c);
        
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        c.gridy = 1;
        c.ipady = 0;
        loginFrame.add(loginPanel,c);
        
        newUserLabel = new JLabel("or Sign up:", JLabel.CENTER);
        c.gridy = 2;
        loginFrame.add(newUserLabel,c);
        
        signUpPanel = new JPanel();
        signUpPanel.setLayout(new FlowLayout());
        c.gridy = 3;
        loginFrame.add(signUpPanel,c);
        
        loginPanel.add(buyerButton);
        loginPanel.add(sellerButton);
        signUpPanel.add(newUserButton);
        
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
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
    }
    
    public void newUserGUI(){
        GridBagConstraints c = new GridBagConstraints();
        loginLabel.setText("Create a new account");
        
        loginFrame.remove(loginPanel);
        loginFrame.remove(newUserLabel);
        signUpPanel.remove(newUserButton);
        
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        c.gridy = 1;
        c.ipady = 20;
        loginFrame.add(loginPanel,c);
        
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
        
        passwordField = new JTextField(17);
        c.gridy = 1;
        c.gridx = 1;
        c.ipady = 0;
        loginPanel.add(passwordField,c);
        
        confirmPasswordLabel = new JLabel("Repeat Password: ");
        c.gridy = 2;
        c.gridx = 0;
        c.ipady = 0;
        loginPanel.add(confirmPasswordLabel,c);
        
        confirmPasswordField = new JTextField(17);
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
        
        loginFrame.repaint();
    }
    
    public void changeLoginGUI(){
        GridBagConstraints c = new GridBagConstraints();
        loginLabel.setText("Signing in as a " + command.getAccountType());
        userNameLabel = new JLabel("Username: ");
        userNameField = new JTextField(17);
        
        passwordLabel = new JLabel("Password: ");
        passwordField = new JTextField(17);
        
        loginFrame.remove(loginPanel);
        loginFrame.remove(newUserLabel);
        signUpPanel.remove(newUserButton);
        
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        c.gridy = 1;
        c.ipady = 20;
        loginFrame.add(loginPanel,c);
        
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
        
        passwordField = new JTextField(17);
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
        
        loginFrame.repaint();
    }
    
    public void goBackGUI(){
        GridBagConstraints c = new GridBagConstraints();
        loginLabel.setText("Sign in as a Buyer or Seller?");
        
        loginFrame.remove(loginPanel);
        loginFrame.remove(newUserLabel);
        
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        c.gridy = 1;
        c.ipady = 0;
        loginFrame.add(loginPanel,c);
        
        newUserLabel = new JLabel("or Sign up:", JLabel.CENTER);
        c.gridy = 2;
        c.ipady = 0;
        loginFrame.add(newUserLabel,c);
        
        loginPanel.add(buyerButton);
        loginPanel.add(sellerButton);
        signUpPanel.add(newUserButton);
        
        loginFrame.repaint();
        
    }
    
    public void removeGUI(){
        loginFrame.dispose();
    }
    
    public String getUserName(){
        return this.userNameField.getText();
    }
    
    public String getPassword(){
        return this.passwordField.getText();
    }
    
    public String getConfirmPassword(){
        return this.confirmPasswordField.getText();
    }
    
    public void setLoginLabel(String newText){
        loginLabel.setText(newText);
    }

}
