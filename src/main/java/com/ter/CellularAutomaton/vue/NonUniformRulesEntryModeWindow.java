package com.ter.CellularAutomaton.vue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.ter.CellularAutomaton.controller.CloseNonUniformRulesEntryModeWindowEvent;
import com.ter.CellularAutomaton.controller.CloseRulesEntryModeWindowEvent;
import com.ter.CellularAutomaton.controller.NonUniformRulesEntryModeAdditiveEvent;
import com.ter.CellularAutomaton.controller.NonUniformRulesEntryModeElementaryEvent;
import com.ter.CellularAutomaton.controller.NonUniformRulesEntryModePatternEvent;
import com.ter.CellularAutomaton.controller.NonUniformRulesEntryModeScriptEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;
import com.ter.CellularAutomaton.controller.RulesEntryModeAdditiveEvent;
import com.ter.CellularAutomaton.controller.RulesEntryModeElementaryEvent;
import com.ter.CellularAutomaton.controller.RulesEntryModePatternEvent;
import com.ter.CellularAutomaton.controller.RulesEntryModeScriptEvent;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class NonUniformRulesEntryModeWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuBar m_menuBar = new JMenuBar();

	/** The menu file. */
	//Tab in MenuBar
	private JMenu m_menuFile = new JMenu("File");
	
	/** The menu bar file item 1. */
	// In file menu

	/** The menu bar file item 1. */
	private JMenuItem m_menuBarFileItem1 = new JMenuItem("Close");

	/** The menu bar file item 2. */
	private JMenuItem m_menuBarFileItem2 = new JMenuItem("Quit");
	
	private JPanel m_mainPanel;
	private JPanel m_panelElementary;
	private JButton m_buttonElementary;
	private JPanel m_panelAdditive;
	private JButton m_buttonAdditive;
	private JPanel m_panelPattern;
	private JButton m_buttonPattern;
	private JPanel m_panelScript;
	private JButton m_buttonScript;
	
	private MainWindow1D m_currentSimulator;
	
	

	/**
	 * Create the application.
	 */
	public NonUniformRulesEntryModeWindow(MainWindow1D currentSimulator) {
		this.setTitle("Rules entry mode");
		this.setSize(450, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		m_currentSimulator = currentSimulator;// Initialize attribute with current simulator
		
		buildComponentWindow();//Build component of window
		
		this.initMenuMnemonic();//Set mnemonic of the MenuBar
		
		this.initMenuBar();//We initialize our menuBar
		
		this.addListenerMenuBar();//We initialize Listener of menuBar
		
		addListenerOnWindow ();//Add Listener on window
		
		this.setIconWindow();//Set icon on window
		
		this.setVisible(true);
	}
	
	/**
	 * Set icon on the frame.
	 */
	private void setIconWindow() {
		try {
			this.setIconImage(ImageIO.read(new File("Files/Images/Favicon/PenroseColor.png")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//Build component of window
	private void buildComponentWindow() {
		buildPanelMain();//Build the main panel
	}
	
	/******Menu bar******/
	/**
	 * Inits the menu bar.
	 */
	private void initMenuBar(){
		//We initialize our menuBar 
		this.constructTabFileMenuBar();//Construction of the tab "File" of menuBar
		
		this.setJMenuBar(m_menuBar);//Add menuBar to window
		
		this.initAcceleratorMenuBar();//Adding all Accelerator of the MenuBar
	}
	
	
	/**
	 * Construct tab file menu bar.
	 */
	private void constructTabFileMenuBar(){
		//Construction of the tab "File" of menuBar
		this.m_menuFile.add(m_menuBarFileItem1);//Adding a tab "Close" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItem2);//Adding a tab "Quit" in tab File in MenuBar
		this.m_menuBar.add(m_menuFile);//the File tab is added to MenuBar
	}
	
	
	/******Mnemonic******/
	/**
	 * Inits the menu mnemonic.
	 */
	private void initMenuMnemonic(){
		//add all the mnémonic for the MenuBar
		m_menuFile.setMnemonic('F');
	}
	
	/******Accelerator******/
	/**
	 * *Init the accelerators**.
	 */
	private void initAcceleratorMenuBar(){
		//add all the accelerators for the items
		this.initAcceleratorFile(); //accelerator of tab File
	}
	
	private void initAcceleratorFile(){
		//add all the accelerators for the items of tab File
		m_menuBarFileItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK)); //add accelerators of Close in tab File
		m_menuBarFileItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK)); //add accelerators of Quit in tab File
	}
	
	/******Listeners MenuBar******/
	//add listeners MenuBar
	private void addListenerMenuBar (){
		this.addListenerFile(); //add listener of tab File
	}

	//add listeners for tab File in MenuBar
	private void addListenerFile (){
		m_menuBarFileItem1.addActionListener(new CloseNonUniformRulesEntryModeWindowEvent(this));
		m_menuBarFileItem2.addActionListener(new QuitEvent());
	}
	
	/******Build Main Panel******/
	//Build the main panel
	private void buildPanelMain(){
		m_mainPanel = new JPanel();
		this.getContentPane().add(m_mainPanel, BorderLayout.CENTER);
		m_mainPanel.setLayout(new BoxLayout(m_mainPanel, BoxLayout.Y_AXIS));
		
		buildComponentPanelMain();//Build the component of main panel
	}
	
	//Build the component of main panel
	private void buildComponentPanelMain(){
		buildPanelElementary();//Build the Elementary panel
		
		buildPanelAdditive();//Build the Additive panel
		
		buildPanelPattern();//Build the Pattern panel
		
		buildPanelScript();//Build the Script panel
	}
	
	/******Build Tab Elementary******/
	//Build the Elementary panel
	private void buildPanelElementary(){
		m_panelElementary = new JPanel();
		m_mainPanel.add(m_panelElementary);
		m_panelElementary.setLayout(new BorderLayout(0, 0));
		
		buildComponentPanelElementary();//Build the component of Elementary panel
	}
	
	//Build the component of Elementary panel
	private void buildComponentPanelElementary(){		
		m_buttonElementary = new JButton("Elementary");
		m_buttonElementary.setToolTipText("Allow to define an elementary local rule");
		m_panelElementary.add(m_buttonElementary, BorderLayout.CENTER);
	}
	
	/******Build Tab Additive******/
	//Build the Additive panel
	private void buildPanelAdditive(){
		m_panelAdditive = new JPanel();
		m_mainPanel.add(m_panelAdditive);
		m_panelAdditive.setLayout(new BorderLayout(0, 0));
		
		buildComponentPanelAdditive();//Build the component of Additive panel
	}
	
	//Build the component of Additive panel
	private void buildComponentPanelAdditive(){		
		m_buttonAdditive = new JButton("Additive");
		m_buttonAdditive.setToolTipText("Allow to define an additive local rule");
		m_panelAdditive.add(m_buttonAdditive, BorderLayout.CENTER);
	}
	
	/******Build Tab Pattern******/
	//Build the Pattern panel
	private void buildPanelPattern(){
		m_panelPattern = new JPanel();
		m_mainPanel.add(m_panelPattern);
		m_panelPattern.setLayout(new BorderLayout(0, 0));
		
		buildComponentPanelPattern();//Build the component of Pattern panel
	}
	
	//Build the component of Pattern panel
	private void buildComponentPanelPattern(){		
		m_buttonPattern = new JButton("Pattern");
		m_buttonPattern.setToolTipText("Allow to define an local rule by pattern");
		m_panelPattern.add(m_buttonPattern, BorderLayout.CENTER);
	}
	
	/******Build Tab Script******/
	//Build the Script panel
	private void buildPanelScript(){
		m_panelScript = new JPanel();
		m_mainPanel.add(m_panelScript);
		m_panelScript.setLayout(new BorderLayout(0, 0));
		
		buildComponentPanelScript();//Build the component of Script panel
	}
	
	//Build the component of Script panel
	private void buildComponentPanelScript(){		
		m_buttonScript = new JButton("Script");
		m_buttonScript.setToolTipText("Allow to define an local rule by script");
		m_panelScript.add(m_buttonScript, BorderLayout.CENTER);
	}
	
	/******Add Listeners on window******/
	private void addListenerOnWindow (){
		this.addListenerButtonElementary ();//Add Listener on button m_buttonElementary
		this.addListenerButtonAdditive ();//Add Listener on button m_buttonAdditive
		this.addListenerButtonPattern ();//Add Listener on button m_buttonPattern
		this.addListenerButtonScript ();//Add Listener on button m_buttonScript
		
	}
	
	//Listener on button m_buttonElementary
	private void addListenerButtonElementary (){
		m_buttonElementary.addActionListener(new NonUniformRulesEntryModeElementaryEvent(this,m_currentSimulator));
	}
	
	//Listener on button m_buttonAdditive
		private void addListenerButtonAdditive (){
			m_buttonAdditive.addActionListener(new NonUniformRulesEntryModeAdditiveEvent(this));
		}
		
		//Listener on button m_buttonPattern
		private void addListenerButtonPattern (){
			m_buttonPattern.addActionListener(new NonUniformRulesEntryModePatternEvent(this));
		}
		
		//Listener on button m_buttonElementary
		private void addListenerButtonScript (){
			m_buttonScript.addActionListener(new NonUniformRulesEntryModeScriptEvent(this));
		}

}
