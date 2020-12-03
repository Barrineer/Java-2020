package cop4331.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author mikey
 */
public class MainFrameGUI {
    
    protected JFrame mainFrame;
    protected JPanel mainPanel;
    protected JButton switchButton;
    protected JLabel accountName;
    protected JButton accountPicture;
    
    protected final int NORTH = GridBagConstraints.NORTH;
    protected final int SOUTH = GridBagConstraints.SOUTH;
    protected final int EAST = GridBagConstraints.EAST;
    protected final int WEST = GridBagConstraints.WEST;
    protected final int CENTER = GridBagConstraints.CENTER;
    protected final int REMAINDER = GridBagConstraints.REMAINDER;
    
    public void createNewFrame(String str,int width,int height){
        mainFrame = new JFrame(str);
        mainFrame.setSize(width,height);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    
    public void createTopPanel(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainFrame.add(mainPanel);
        mainPanel.add(switchButton);
        mainPanel.add(accountName);
        
        accountPicture = new JButton("N/A");
        mainPanel.add(accountPicture);
    }
    
    public void removeOldFrame(){
        mainFrame.dispose();
    }
    
    public void createButtonEvents(){}
    public void createGUI(){}
    
}
