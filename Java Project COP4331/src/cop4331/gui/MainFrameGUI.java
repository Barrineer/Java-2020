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
    
    public void createNewFrame(String str,int width,int height){
        mainFrame = new JFrame(str);
        mainFrame.setSize(width,height);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    
    public void removeOldFrame(){
        mainFrame.dispose();
    }
    
    public void createButtonEvents(){}
    public void createGUI(){}
    
}
