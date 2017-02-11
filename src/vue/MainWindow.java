
package vue;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
    
    /******ATTRIBUT******/
	private JMenuBar m_menuBar = new JMenuBar();
	private JMenu m_menuFile = new JMenu("File");
	private JMenu m_menuEdit = new JMenu("Edit");
	private JMenu m_menuRun = new JMenu("Run");
	private JMenu m_menuOption = new JMenu("Option");

	private JMenuItem m_menuBarFileItem1 = new JMenuItem("New");
	private JMenuItem m_menuBarFileItem2 = new JMenuItem("Open File");
	private JMenuItem m_menuBarFileItem3 = new JMenuItem("Recent File");
	private JMenuItem m_menuBarFileItem4 = new JMenuItem("Save");
	private JMenuItem m_menuBarFileItem5 = new JMenuItem("Save As");
	private JMenuItem m_menuBarFileItem6 = new JMenuItem("Print");
	private JMenuItem m_menuBarFileItem7 = new JMenuItem("Quit");
	
	private JMenuItem m_menuBarEditItem1 = new JMenuItem("Undo");
	private JMenuItem m_menuBarEditItem2 = new JMenuItem("Redo");
	private JMenuItem m_menuBarEditItem3 = new JMenuItem("Cut");
	private JMenuItem m_menuBarEditItem4 = new JMenuItem("Copy");
	private JMenuItem m_menuBarEditItem5 = new JMenuItem("Paste");
	private JMenuItem m_menuBarEditItem6 = new JMenuItem("Select all");
	private JMenuItem m_menuBarEditItem7 = new JMenuItem("Find");
	private JMenuItem m_menuBarEditItem8 = new JMenuItem("Find Next");
	
	private JMenuItem m_menuBarRunItem1 = new JMenuItem("Run Current Simulation");
	private JMenuItem m_menuBarRunItem2 = new JMenuItem("Run External Simulation");
	
	private JMenuItem m_menuBarOptionItem1 = new JMenuItem("Bookmarks");
	private JMenuItem m_menuBarOptionItem2 = new JMenuItem("Setting By Default");
    
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
        this.m_menuFile.add(m_menuBarFileItem1);//Adding a tab "New" in MenuBar
        this.m_menuFile.add(m_menuBarFileItem2);//Adding a tab "Open File" in MenuBar
        this.m_menuFile.add(m_menuBarFileItem3);//Adding a tab "Recent File" in MenuBar
        this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
        this.m_menuFile.add(m_menuBarFileItem4);//Adding a tab "Save" in MenuBar
        this.m_menuFile.add(m_menuBarFileItem5);//Adding a tab "Save As" in MenuBar
        this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
        this.m_menuFile.add(m_menuBarFileItem6);//Adding a tab "Print" in MenuBar
        this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
        this.m_menuFile.add(m_menuBarFileItem7);//Adding a tab "Quit" in MenuBar
        this.m_menuBar.add(m_menuFile);//the File tab is added to MenuBar
        
        //Construction of the tab "Edit" of menuBar
        this.m_menuEdit.add(m_menuBarEditItem1);//Adding a tab "Undo" in MenuBar
        this.m_menuEdit.add(m_menuBarEditItem2);//Adding a tab "Redo" in MenuBar
        this.m_menuEdit.addSeparator();//Adding a separator in tab Edit of the MenuBar
        this.m_menuEdit.add(m_menuBarEditItem3);//Adding a tab "Cut" in MenuBar
        this.m_menuEdit.add(m_menuBarEditItem4);//Adding a tab "Copy" in MenuBar
        this.m_menuEdit.add(m_menuBarEditItem5);//Adding a tab "Paste" in MenuBar
        this.m_menuEdit.addSeparator();//Adding a separator in tab Edit of the MenuBar
        this.m_menuEdit.add(m_menuBarEditItem6);//Adding a tab "Select all" in MenuBar
        this.m_menuEdit.add(m_menuBarEditItem7);//Adding a tab "Find" in MenuBar
        this.m_menuEdit.add(m_menuBarEditItem8);//Adding a tab "Find Next" in MenuBar
        this.m_menuBar.add(m_menuEdit);//the Edit tab is added to MenuBar
        
        //Construction of the tab "Run" of menuBar
        this.m_menuRun.add(m_menuBarRunItem1);//Adding a tab "Run Current Simulation" in MenuBar
        this.m_menuRun.addSeparator();//Adding a separator in tab Run of the MenuBar
        this.m_menuRun.add(m_menuBarRunItem2);//Adding a tab "Run External Simulation" in MenuBar
        this.m_menuBar.add(m_menuRun);//the Run tab is added to MenuBar
        
      //Construction of the tab "Option" of menuBar
        this.m_menuOption.add(m_menuBarOptionItem1);//Adding a tab "Bookmarks" in MenuBar
        this.m_menuOption.addSeparator();//Adding a separator in tab Run of the MenuBar
        this.m_menuOption.add(m_menuBarOptionItem2);//Adding a tab "Setting By Default" in MenuBar
        this.m_menuBar.add(m_menuOption);//the Run tab is added to MenuBar
        
        this.setJMenuBar(m_menuBar);//the MenuBar tab is added to Window
        
        
        this.setVisible(true);
    }

}
