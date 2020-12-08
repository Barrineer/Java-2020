package cop4331.controller;
import cop4331.gui.*;
/**
 * Controls which GUI is currently being displayed.
 * Uses Singleton Pattern.
 * @author mikey, Joseph, Malcolm Richardson
 */
public class CurrentGUI {

    private MainFrameGUI currentFrame = new LoginGUI();
    private static CurrentGUI currentGUI = new CurrentGUI();
    
    private CurrentGUI(){}
    
    public static CurrentGUI getInstance(){
        return currentGUI;
    }
    /**
     * Gets the current Frame.
     * @return 
     */
    public MainFrameGUI getFrame(){
        return currentFrame;
    }
    /**
     * Change the current GUI to another GUI.
     * @param frame A subclass of MainFrmaeGUI.
     */
    public void changeGUI(MainFrameGUI frame){
        currentFrame = frame;
    }
    /**
     * Displays the current GUI.
     */
    public void callGUI(){
        currentFrame.createButtonEvents();
        currentFrame.createGUI();
    }
}
