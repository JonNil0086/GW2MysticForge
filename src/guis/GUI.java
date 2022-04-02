package guis;

import java.awt.Dimension;

/* GUI
 * -----------------------------------------------------------------------------
 * Class representing the GUI (sets up the mainframe).
 * -----------------------------------------------------------------------------
 * Notes:       None
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class GUI {    

    private final MainFrame mainFrame;     
    
    /* GUI
     * --------------------------------------------------
     * Constructor used for initialization.
     * --------------------------------------------------
     * Input:   (title): Title of the mainframe
     *          (dimension): Dimensions of the frame
     * Output:  None
     * --------------------------------------------------
     */
    public GUI(String title, Dimension dimension) {
        mainFrame = new MainFrame(new MysticForgeProfiterPanel());
        mainFrame.setTitle(title);
        mainFrame.setSize(new Dimension(710, 750));
    }
    
    /**
     * Show the display
     */
    public void show() {
        mainFrame.setVisible(true);
    }  
}