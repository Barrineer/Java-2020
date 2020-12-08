package cop4331.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author mikey, Joseph, Malcolm Richardson
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
    
    protected final int ABOVE_BASELINE = GridBagConstraints.ABOVE_BASELINE;
    protected final int ABOVE_BASELINE_LEADING = GridBagConstraints.ABOVE_BASELINE_LEADING;
    protected final int ABOVE_BASELINE_TRAILING = GridBagConstraints.ABOVE_BASELINE_TRAILING;
    protected final int BASELINE = GridBagConstraints.BASELINE;
    protected final int BASELINE_LEADING = GridBagConstraints.BASELINE_LEADING;
    protected final int BASELINE_TRAILING = GridBagConstraints.BASELINE_TRAILING;
    protected final int BELOW_BASELINE = GridBagConstraints.BELOW_BASELINE;
    protected final int BELOW_BASELINE_LEADING = GridBagConstraints.BELOW_BASELINE_LEADING;
    protected final int BELOW_BASELINE_TRAILING = GridBagConstraints.BELOW_BASELINE_TRAILING;
    
    protected final int REMAINDER = GridBagConstraints.REMAINDER;
    protected final int BOTH = GridBagConstraints.BOTH;
    /*
    SERIF = TimesRoman
    SANS_SERIF = Helvetica
    MONOSPACED = Courier
    */
    protected final Font font = new Font(Font.SANS_SERIF,Font.PLAIN,14);
    protected final Font fontBold = new Font(Font.SANS_SERIF,Font.BOLD,14);
    protected final Font fontItalic = new Font(Font.SANS_SERIF,Font.ITALIC,14);
    protected final Font fontBigger = new Font(Font.SANS_SERIF,Font.PLAIN,16);
    protected final Font fontBiggerBold = new Font(Font.SANS_SERIF,Font.BOLD,16);
    protected final Font fontBiggerItalic = new Font(Font.SANS_SERIF,Font.ITALIC,16);
    protected final Font fontBiggest = new Font(Font.SANS_SERIF,Font.PLAIN,18);
    protected final Font fontBiggestBold = new Font(Font.SANS_SERIF,Font.BOLD,18);
    protected final Font fontBiggestItalic = new Font(Font.SANS_SERIF,Font.ITALIC,18);
    
    protected static final int SPACING = 60;

    /**
     * Creates a new frame
     * 
     * @param str frames name
     * @param width sets frame width
     * @param height sets frame height
     */
    public void createNewFrame(String str,int width,int height){
        mainFrame = new JFrame(str);
        mainFrame.setSize(width,height);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    /**
     * Creates the top panel and contains the switch user button and profile button
     */
    public void createTopPanel(){
        GridBagConstraints c = new GridBagConstraints();
        
        //Switch Button
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridx = 0;
        c.anchor = NW;
        c.insets = new Insets(3,3,0,0);
        switchButton.setFont(font);
        mainFrame.add(switchButton,c);
        
        //Account Button
        c.anchor = NE;
        c.gridx = 100;
        c.insets = new Insets(3,0,0,3);
        accountButton.setFont(font);
        mainFrame.add(accountButton,c);
        
    }
    /**
     * Takes away previous frame
     */
    public void removeOldFrame(){
        mainFrame.dispose();
    }
    /**
     * Creates buttons events based on the subclass
     */
    public void createButtonEvents(){}
    /**
     * Creates GUI based on the subclass
     */
    public void createGUI(){}
    
}
