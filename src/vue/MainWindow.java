
package vue;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
    
    /******ATTRIBUT******/
	private JMenuBar m_menuBar = new JMenuBar();
	private JMenu m_file = new JMenu("File");
	//private JMenu test2 = new JMenu("Edition");

	private JMenuItem m_menuBarFileItem1 = new JMenuItem("New");
	private JMenuItem m_menuBarFileItem2 = new JMenuItem("Open File");
	private JMenuItem m_menuBarFileItem3 = new JMenuItem("Recent File");
	private JMenuItem m_menuBarFileItem4 = new JMenuItem("Save");
	private JMenuItem m_menuBarFileItem5 = new JMenuItem("Save As");
	private JMenuItem m_menuBarFileItem6 = new JMenuItem("Print");
	private JMenuItem m_menuBarFileItem7 = new JMenuItem("Quit");
    
    /******CONSTRUCTEUR******/
    public MainWindow (){
        
        /***Set the window***/
    	this.setTitle("Cellular Automaton");//Define a title to the window    
    	this.setSize(1000,600);//Initial size of the window
    	this.setLocationRelativeTo(null);//We now ask our window to position itself at the center.
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Complete the process when clicking on the red cross
    	this.setResizable(true);//Prevents resizing
    	this.setAlwaysOnTop(false);//The windows will not be always on top
        
    	//We initialize our menuBar 
    	//Construction of the tab "File" of menuBar
        this.m_file.add(m_menuBarFileItem1);//Adding a tab "New" in MenuBar
        this.m_file.add(m_menuBarFileItem2);//Adding a tab "Open File" in MenuBar
        this.m_file.add(m_menuBarFileItem3);//Adding a tab "Recent File" in MenuBar
        this.m_file.addSeparator();//Adding a separator in tab File of the MenuBar
        this.m_file.add(m_menuBarFileItem4);//Adding a tab "Save" in MenuBar
        this.m_file.add(m_menuBarFileItem5);//Adding a tab "Save As" in MenuBar
        this.m_file.addSeparator();//Adding a separator in tab File of the MenuBar
        this.m_file.add(m_menuBarFileItem6);//Adding a tab "Print" in MenuBar
        this.m_file.addSeparator();//Adding a separator in tab File of the MenuBar
        this.m_file.add(m_menuBarFileItem7);//Adding a tab "Quit" in MenuBar
        this.m_menuBar.add(m_file);//the File tab is added to MenuBar
        
        
        this.setJMenuBar(m_menuBar);//the MenuBar tab is added to Window
        
        
        this.setVisible(true);
    }

}
