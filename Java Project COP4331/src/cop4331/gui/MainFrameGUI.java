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
    protected JButton accountButton;
    
    protected final int NORTH = GridBagConstraints.NORTH;
    protected final int SOUTH = GridBagConstraints.SOUTH;
    protected final int EAST = GridBagConstraints.EAST;
    protected final int WEST = GridBagConstraints.WEST;
    protected final int CENTER = GridBagConstraints.CENTER;
    protected final int NE = GridBagConstraints.NORTHEAST;
    protected final int NW = GridBagConstraints.NORTHWEST;
    protected final int SE = GridBagConstraints.SOUTHEAST;
    protected final int SW = GridBagConstraints.SOUTHWEST;
    /*
    SERIF = TimesRoman
    SANS_SERIF = Helvetica
    MONOSPACED = Courier
    */
    protected final Font font = new Font(Font.SANS_SERIF,Font.BOLD,18);
    
    protected final int BASELINE_LEADING = GridBagConstraints.BASELINE_LEADING;
    
    protected final int REMAINDER = GridBagConstraints.REMAINDER;
    protected final int BOTH = GridBagConstraints.BOTH;
    
    public void createNewFrame(String str,int width,int height){
        mainFrame = new JFrame(str);
        mainFrame.setSize(width,height);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    
    public void createTopPanel(){
        GridBagConstraints c = new GridBagConstraints();
        
        //mainPanel = new JPanel();
        //mainPanel.setLayout(new GridBagLayout());
        
        //Panel
        //c.weightx = 1;
        //c.weighty = 0.1;
        //c.anchor = NW;
        //mainFrame.add(mainPanel,c);
        
        //Switch Button
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.anchor = NW;
        c.insets = new Insets(3,3,0,0);
        switchButton.setFont(font);
        mainFrame.add(switchButton,c);
        //Account Button
        c.anchor = NE;
        c.insets = new Insets(3,0,0,3);
        accountButton.setFont(font);
        mainFrame.add(accountButton,c);
        
    }
    
    public void removeOldFrame(){
        mainFrame.dispose();
    }
    
    public void createButtonEvents(){}
    public void createGUI(){}
    
}
