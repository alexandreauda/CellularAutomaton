package com.ter.CellularAutomaton.vue;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.ter.CellularAutomaton.controller.CancelPersonalizeElementaryCells1DFrameEvent;
import com.ter.CellularAutomaton.controller.ClosePersonalizeElementaryCellsFrameEvent;
import com.ter.CellularAutomaton.controller.OKPersonalizeElementaryCells1DFrameEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;


public class PersonalizeElementaryCells1DFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	
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
	
	/** Component of window */
	private final JPanel m_mainPanel = new JPanel();
	private final JPanel m_controlPanel = new JPanel();
	private final JButton m_buttonCancel = new JButton("Cancel");
	private final JButton m_buttonOk = new JButton("OK");
	private JComponent m_tableChooseColorCellsPane;
	private final Component horizontalStrut = Box.createHorizontalStrut(50);
	
	/******GETTERS******/
	public TablePersonalizeElementaryCells1D getm_tableChooseColorCellsPane() {
		return (TablePersonalizeElementaryCells1D) m_tableChooseColorCellsPane;
	}

	/******CONSTRUCTOR******/
	/**
	 * Create the application.
	 */
	public PersonalizeElementaryCells1DFrame(MainWindow1D window) {
		m_window = window;
		
		buildComponentWindow();// Build component of window.
		
		this.initMenuMnemonic();// Set mnemonic of the MenuBar.
		
		this.initMenuBar();// We initialize our menuBar.
		
		this.addListenerMenuBar();// We initialize Listener of menuBar.
		
		this.setIconWindow();//Set icon on window
	}
	
	
	/******CLASS METHODS******/


	/**
	 * Initialize the contents of the frame.
	 */
	private void buildComponentWindow() {
		this.setTitle("Personalize Cells");//Define a title to the window    
		this.setSize(450,152);//Initial size of the window
		this.setLocationRelativeTo(null);//We now ask our window to position itself at the center.
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Complete the process when clicking on the red cross
        m_mainPanel.setLayout(new BorderLayout(0, 0));

        //Create and set up the content pane.
        m_tableChooseColorCellsPane = new TablePersonalizeElementaryCells1D(m_window);
        m_tableChooseColorCellsPane.setOpaque(true); //content panes must be opaque
        m_mainPanel.add(m_tableChooseColorCellsPane, BorderLayout.CENTER);
        
        m_controlPanel.add(m_buttonCancel);
        
        m_controlPanel.add(horizontalStrut);
        m_controlPanel.add(m_buttonOk);
        m_mainPanel.add(m_controlPanel, BorderLayout.SOUTH);

        this.setContentPane(m_mainPanel);
        
        addListenerOnComponentsOfControlPanel();

        //Display the window.
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
		m_menuBarFileItem1.addActionListener(new ClosePersonalizeElementaryCellsFrameEvent(this));
		m_menuBarFileItem2.addActionListener(new QuitEvent());
	}
	
	/******Listeners panel Control******/
	private void addListenerOnComponentsOfControlPanel(){
		m_buttonCancel.addActionListener(new CancelPersonalizeElementaryCells1DFrameEvent(this));//add listener of button CANCEL
		m_buttonOk.addActionListener(new OKPersonalizeElementaryCells1DFrameEvent(m_window,this));//add listener of button OK
	}
	

}
