
package vue;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
    
    /******ATTRIBUT******/
	private JMenuBar m_menuBar = new JMenuBar();
	
	//Tab in MenuBar
	private JMenu m_menuFile = new JMenu("File");
	private JMenu m_menuEdit = new JMenu("Edit");
	private JMenu m_menuRun = new JMenu("Run");
	private JMenu m_menuOption = new JMenu("Option");
	private JMenu m_menuView = new JMenu("View");
	private JMenu m_menuHelp = new JMenu("Help");

	// In file menu
	private JMenuItem m_menuBarFileItem1 = new JMenuItem("New");
	private JMenuItem m_menuBarFileItem2 = new JMenuItem("Open File");
	private JMenuItem m_menuBarFileItem3 = new JMenuItem("Recent File");
	private JMenuItem m_menuBarFileItem4 = new JMenuItem("Save");
	private JMenuItem m_menuBarFileItem5 = new JMenuItem("Save As");
	private JMenuItem m_menuBarFileItem6 = new JMenuItem("Print");
	private JMenuItem m_menuBarFileItem7 = new JMenuItem("Quit");
	
	// In edit menu
	private JMenuItem m_menuBarEditItem1 = new JMenuItem("Undo");
	private JMenuItem m_menuBarEditItem2 = new JMenuItem("Redo");
	private JMenuItem m_menuBarEditItem3 = new JMenuItem("Cut");
	private JMenuItem m_menuBarEditItem4 = new JMenuItem("Copy");
	private JMenuItem m_menuBarEditItem5 = new JMenuItem("Paste");
	private JMenuItem m_menuBarEditItem6 = new JMenuItem("Select all");
	private JMenuItem m_menuBarEditItem7 = new JMenuItem("Find");
	private JMenuItem m_menuBarEditItem8 = new JMenuItem("Find Next");
	
	// In run menu
	private JMenuItem m_menuBarRunItem1 = new JMenuItem("Run Current Simulation");
	private JMenu m_menuBarRunItem2 = new JMenu("Run Specific Screen");
	private JMenuItem m_menuBarRunItem3 = new JMenuItem("Run External Simulation");
	
	// In option menu
	private JMenuItem m_menuBarOptionItem1 = new JMenuItem("Bookmarks");
	private JMenuItem m_menuBarOptionItem2 = new JMenuItem("Setting By Default");
	
	// In view menu
	private JMenuItem m_menuBarViewItem1 = new JMenuItem("View By Default");
	private JMenu m_menuBarViewItem2 = new JMenu("Split Screen By");
	private JCheckBoxMenuItem m_menuBarViewItem3 = new JCheckBoxMenuItem("Show Toolbars");
	private JMenuItem m_menuBarViewItem4 = new JMenuItem("Customize View");
	
	// In help menu
	private JMenuItem m_menuBarHelpItem1 = new JMenuItem("Help Contents");
	private JMenuItem m_menuBarHelpItem2 = new JMenuItem("Credits");
	
	// In tab run
	private JCheckBoxMenuItem  m_runItem2Choice1 = new JCheckBoxMenuItem ("All");
	private JMenu  m_runItem2Choice2 = new JMenu ("Custom");
	
	// In tab view
	private JRadioButtonMenuItem  m_viewItem2Choice1 = new JRadioButtonMenuItem ("None");
	private JRadioButtonMenuItem  m_viewItem2Choice2 = new JRadioButtonMenuItem ("2");
	private JRadioButtonMenuItem  m_viewItem2Choice3 = new JRadioButtonMenuItem ("4");
    
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
        //Sub-group of tab "Run Specific Screen" in tab run
        this.m_menuBarRunItem2.add(m_runItem2Choice1);//Adding a CheckBox "All" in tab "Run Specific Screen"
        this.m_runItem2Choice1.setSelected(true);//Set a CheckBox "All" to true by default
        this.m_menuBarRunItem2.addSeparator();//Adding a separator in tab "Run Specific Screen" in tab "Run"
        this.m_menuBarRunItem2.add(m_runItem2Choice2);//Adding a tab "Custom" in tab "Run Specific Screen"
        
        this.m_menuRun.add(m_menuBarRunItem1);//Adding a tab "Run Current Simulation" in MenuBar
        this.m_menuRun.add(m_menuBarRunItem2);//Adding a tab "Run Specific Screen" in MenuBar
        this.m_menuRun.addSeparator();//Adding a separator in tab Run of the MenuBar
        this.m_menuRun.add(m_menuBarRunItem3);//Adding a tab "Run External Simulation" in MenuBar
        this.m_menuBar.add(m_menuRun);//the Run tab is added to MenuBar
        
        //Construction of the tab "Option" of menuBar
        this.m_menuOption.add(m_menuBarOptionItem1);//Adding a tab "Bookmarks" in MenuBar
        this.m_menuOption.addSeparator();//Adding a separator in tab Option of the MenuBar
        this.m_menuOption.add(m_menuBarOptionItem2);//Adding a tab "Setting By Default" in MenuBar
        this.m_menuBar.add(m_menuOption);//the Option tab is added to MenuBar
        
        //Construction of the tab "View" of menuBar
        //Sub-group of tab "Split Screen By" in tab view
        ButtonGroup viewItem2ButtonGroup = new ButtonGroup();//Adding ButtonGroup
        viewItem2ButtonGroup.add(m_viewItem2Choice1);//Adding radio button "None" in ButtonGroup
        viewItem2ButtonGroup.add(m_viewItem2Choice2);//Adding radio button "2" in ButtonGroup
        viewItem2ButtonGroup.add(m_viewItem2Choice3);//Adding radio button "4" in ButtonGroup
        this.m_viewItem2Choice1.setSelected(true);//Set "None" radio button to true by default 
        this.m_menuBarViewItem2.add(m_viewItem2Choice1);//Adding a tab "None" in tab "Split Screen By"
        this.m_menuBarViewItem2.add(m_viewItem2Choice2);//Adding a tab "2" in tab "Split Screen By"
        this.m_menuBarViewItem2.add(m_viewItem2Choice3);//Adding a tab "4" in tab "Split Screen By"
        
        //Tab view
        this.m_menuView.add(m_menuBarViewItem1);//Adding a tab "View By Default" in MenuBar
        this.m_menuView.add(m_menuBarViewItem2);//Adding a tab "Split Screen By" in MenuBar
        this.m_menuView.addSeparator();//Adding a separator in tab View of the MenuBar
        this.m_menuView.add(m_menuBarViewItem3);//Adding a checkBox tab "Show Toolbars" in MenuBar
        this.m_menuBarViewItem3.setSelected(true);//Set "Show Toolbars" checkBox to true by default
        this.m_menuView.addSeparator();//Adding a separator in tab View of the MenuBar
        this.m_menuView.add(m_menuBarViewItem4);//Adding a tab "Customize View" in MenuBar
        this.m_menuBar.add(m_menuView);//the View tab is added to MenuBar
        
        //Construction of the tab "Help" of menuBar
        this.m_menuHelp.add(m_menuBarHelpItem1);//Adding a tab "Help Contents" in MenuBar
        this.m_menuHelp.addSeparator();//Adding a separator in tab Help of the MenuBar
        this.m_menuHelp.add(m_menuBarHelpItem2);//Adding a tab "Credits" in MenuBar
        this.m_menuBar.add(m_menuHelp);//the Help tab is added to MenuBar
        
        this.setJMenuBar(m_menuBar);//the MenuBar tab is added to Window
        
        
        this.setVisible(true);
    }

}
