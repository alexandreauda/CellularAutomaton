package com.ter.CellularAutomaton.vue;

import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.KeyStroke;

import com.ter.CellularAutomaton.controller.CloseElementaryRulesWindowEvent;
import com.ter.CellularAutomaton.controller.CloseSizeSimulationWindowEvent;
import com.ter.CellularAutomaton.controller.OKSizeSimulation1DEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

public class SizeSimulationWindow extends JFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/******ATTRIBUTES******/
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
	
	private MainWindow1D m_mainWindow1D;
	
	private JScrollPane m_mainScrollPane = new JScrollPane();
	private JPanel m_mainpanel = new JPanel();
	private JPanel m_controlPanel = new JPanel();
	private final JButton m_buttonCancel = new JButton("Cancel");
	private final Component m_horizontalStrut = Box.createHorizontalStrut(60);
	private final JButton m_buttonOk = new JButton("OK");
	private JScrollPane m_sizeScrollPane = new JScrollPane();
	private final JPanel m_sizePanel = new JPanel();
	private final JLabel m_labelWidthOfSimulation = new JLabel("Width of simulation:");
	private JFormattedTextField m_formattedTextFieldWidthOfSimulation = new JFormattedTextField();
	private final JLabel m_labelHeightOfSimulation = new JLabel("Height of simulation:");
	private final JFormattedTextField m_formattedTextFieldHeightOfSimulation = new JFormattedTextField();
	
	/******GETTERS******/
	public MainWindow1D getm_mainWindow1D() {
		return m_mainWindow1D;
	}
	
	public JFormattedTextField getm_formattedTextFieldWidthOfSimulation() {
		return m_formattedTextFieldWidthOfSimulation;
	}
	
	public JFormattedTextField getm_formattedTextFieldHeightOfSimulation() {
		return m_formattedTextFieldHeightOfSimulation;
	}

	/**
	 * Create the application.
	 */
	public SizeSimulationWindow(MainWindow1D mainWindow1D) {
		m_mainWindow1D = mainWindow1D;
		
		this.setTitle("Size of simulation window");//Set the title of window
		this.setSize(450,270);//Set size of window
		this.setLocationRelativeTo(null);//Center the location of window
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Set Default Close Operation to DISPOSE_ON_CLOSE
		
		buildComponentWindow();//Build component of window
		
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void buildComponentWindow() {
		
		this.initMenuMnemonic();// Set mnemonic of the MenuBar.
		
		this.initMenuBar();// We initialize our menuBar.
		
		this.addListenerMenuBar();// We initialize Listener of menuBar.
		
		this.getContentPane().add(m_mainScrollPane, BorderLayout.CENTER);
		m_mainScrollPane.setViewportView(m_mainpanel);
		m_mainpanel.setLayout(new BorderLayout(0, 0));
		m_mainpanel.add(m_controlPanel, BorderLayout.SOUTH);
		m_controlPanel.add(m_buttonCancel);
		m_controlPanel.add(m_horizontalStrut);
		m_controlPanel.add(m_buttonOk);
		m_mainpanel.add(m_sizeScrollPane, BorderLayout.CENTER);
		m_sizeScrollPane.setViewportView(m_sizePanel);
		m_sizePanel.setLayout(null);
		
		m_labelWidthOfSimulation.setBounds(10, 38, 151, 29);
		m_sizePanel.add(m_labelWidthOfSimulation);
		m_labelWidthOfSimulation.setFont(new Font(m_labelWidthOfSimulation.getFont().getName(), m_labelWidthOfSimulation.getFont().getStyle(), 15));// new font size is 15
		
		m_formattedTextFieldWidthOfSimulation.setBounds(171, 38, 234, 29);
		m_sizePanel.add(m_formattedTextFieldWidthOfSimulation);
		
		m_labelHeightOfSimulation.setBounds(10, 106, 151, 29);
		m_sizePanel.add(m_labelHeightOfSimulation);
		m_labelHeightOfSimulation.setFont(new Font(m_labelHeightOfSimulation.getFont().getName(), m_labelHeightOfSimulation.getFont().getStyle(), 15));// new font size is 15
		
		m_formattedTextFieldHeightOfSimulation.setBounds(171, 106, 234, 29);
		m_sizePanel.add(m_formattedTextFieldHeightOfSimulation);
		
		addListenerComponentControlPanel ();//Add Listener on component control panel
		
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
		m_menuBarFileItem1.addActionListener(new CloseSizeSimulationWindowEvent(this));
		m_menuBarFileItem2.addActionListener(new QuitEvent());
	}
	
	/******Listeners Component Control Panel******/
	//add listeners on component in control panel
		private void addListenerComponentControlPanel (){
			m_buttonCancel.addActionListener(new CloseSizeSimulationWindowEvent(this));
			m_buttonOk.addActionListener(new OKSizeSimulation1DEvent(this));
		}
	
}
