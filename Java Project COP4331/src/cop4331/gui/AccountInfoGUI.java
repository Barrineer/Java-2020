package cop4331.gui;

import cop4331.controller.AccountInfoListener;
import cop4331.model.Login;
import cop4331.model.User;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mikey
 */
public class AccountInfoGUI extends MainFrameGUI{
    
    private JLabel accountLabel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel addressLabel;
    private JLabel ageLabel;
    
    private JTextField userNameField;
    private JTextField passwordField;
    private JTextField addressField;
    private JTextField ageField;
    
    private JButton backButton;
    private JButton submitButton;
    
    public void createButtonEvents(){
        
        backButton = new JButton("Back");
        submitButton = new JButton("Submit");
        
        backButton.setActionCommand("Back");
        submitButton.setActionCommand("Submit");
        
        backButton.addActionListener(new AccountInfoListener());
        submitButton.addActionListener(new AccountInfoListener());
    }
    
    public void createGUI(){
        GridBagConstraints c = new GridBagConstraints();
        createNewFrame("BrosRus Application",1000,1000);
        User user = Login.getInstance().getCurrentUser();
        String date = user.getAge().toString();
        String year = date.substring(24);
        String month = date.substring(4,7);
        String day = date.substring(8,10);
        
        if(month.equals("Jan"))
            month = "01";
        else if(month.equals("Feb"))
            month = "02";
        else if(month.equals("Mar"))
            month = "03";
        else if(month.equals("Apr"))
            month = "04";
        else if(month.equals("May"))
            month = "05";
        else if(month.equals("Jun"))
            month = "06";
        else if(month.equals("Jul"))
            month = "07";
        else if(month.equals("Aug"))
            month = "08";
        else if(month.equals("Sep"))
            month = "09";
        else if(month.equals("Oct"))
            month = "10";
        else if(month.equals("Nov"))
            month = "11";
        else
            month = "12";
            
        date = year + "-" + month + "-" + day;
        
        accountLabel = new JLabel(user.getUserName() + " Account Details",JLabel.CENTER);
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = SOUTH;
        mainFrame.add(accountLabel,c);
        
        //Username
        userNameLabel = new JLabel("Username: ");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = NE;
        mainFrame.add(userNameLabel,c);
        
        userNameField = new JTextField(17);
        userNameField.setText(user.getUserName());
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = NW;
        mainFrame.add(userNameField,c);
        
        //Password
        passwordLabel = new JLabel("Password: ");
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = NE;
        mainFrame.add(passwordLabel,c);
        
        passwordField = new JTextField(17);
        passwordField.setText(user.getPassword());
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = NW;
        mainFrame.add(passwordField,c);
        
        //Address
        addressLabel = new JLabel("Address: ");
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = NE;
        mainFrame.add(addressLabel,c);
        
        addressField = new JTextField(17);
        addressField.setText(user.getAddress());
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = NW;
        mainFrame.add(addressField,c);
        
        //Age
        ageLabel = new JLabel("DOB (yyyy-mm-dd): ");
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = NE;
        mainFrame.add(ageLabel,c);
        
        ageField = new JTextField(17);
        ageField.setText(date);
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = NW;
        mainFrame.add(ageField,c);
        
        //Set Font
        accountLabel.setFont(fontBiggerBold);
        userNameLabel.setFont(fontBold);
        passwordLabel.setFont(fontBold);
        addressLabel.setFont(fontBold);
        ageLabel.setFont(fontBold);
        userNameField.setFont(font);
        passwordField.setFont(font);
        addressField.setFont(font);
        ageField.setFont(font);
    }
    
}
