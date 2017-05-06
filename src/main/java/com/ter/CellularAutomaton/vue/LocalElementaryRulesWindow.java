package com.ter.CellularAutomaton.vue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.ter.CellularAutomaton.controller.Cell1D;
import com.ter.CellularAutomaton.controller.CloseElementaryRulesWindowEvent;
import com.ter.CellularAutomaton.controller.CloseLocalElementaryRulesWindowEvent;
import com.ter.CellularAutomaton.controller.OKElementaryRules1DEvent;
import com.ter.CellularAutomaton.controller.OKLocalElementaryRules1DEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;


public class LocalElementaryRulesWindow extends JFrame implements KeyListener {

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
	
	/** Component of window */
	private final JPanel m_panelControl = new JPanel();
	private final JButton m_buttonReset = new JButton("Reset");
	private final JCheckBox m_checkBoxRememberSetting = new JCheckBox("Remember this setting");
	private final JCheckBox m_checkBoxSetActualSettingAsDefault = new JCheckBox("Set actual setting as default");
	private final JPanel m_panelRulesSetting = new JPanel();
	private final JLabel m_labelAlphabet = new JLabel("Alphabet (0 to ?):  1");
	private final JLabel m_labelRadius = new JLabel("Radius (must be equal or greater than 1):");
	private final JFormattedTextField m_formattedTextFieldRadius = new JFormattedTextField(1);//By default, the radius is 1.
	private final JLabel m_labelRules = new JLabel("Rules (0 to ?):");
	private final JFormattedTextField m_formattedTextFieldRules = new JFormattedTextField(0);
	private final JButton m_buttonOk = new JButton("OK");
	private final JButton m_buttonPersonalize = new JButton("Personalize");
	private JSeparator m_separatorBetweenAlphabetAndRadius;
	private JSeparator m_separatorBetweenRadiusAndRules;
	private JSeparator m_separatorBetweenRulesAndPanelControl;
	
	private InternalFrameSimulation1D m_currentInternalFrameSimulation1D;
	private Cell1D m_currentCell;
	
	/******GETTERS******/
	public Cell1D getm_currentCell() {
		return m_currentCell;
	}
	
	public JFormattedTextField getm_formattedTextFieldRadius() {
		return m_formattedTextFieldRadius;
	}
	
	public JFormattedTextField getm_formattedTextFieldRules() {
		return m_formattedTextFieldRules;
	}


	/**
	 * Create the application.
	 */
	public LocalElementaryRulesWindow(InternalFrameSimulation1D currentInternalFrameSimulation1D, Cell1D currentCell) {
		
		m_currentInternalFrameSimulation1D = currentInternalFrameSimulation1D;// Initialize attribute with current InternalFrameSimulation1D
		m_currentCell = currentCell;// Initialize attribute with current Cell
		
		buildComponentWindow();// Build component of window.
		
		this.initMenuMnemonic();// Set mnemonic of the MenuBar.
		
		this.initMenuBar();// We initialize our menuBar.
		
		this.addListenerMenuBar();// We initialize Listener of menuBar.
		
		this.addListenerOnComponentsOfControlPanel();// Initialize Listeners on Components of panel Control.
		
		this.setVisible(true);// Set the window visible.
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void buildComponentWindow() {
		this.setTitle("Local Elementary Rules Window");//Set the title of window
		this.setSize(550,320);//Set size of window
		this.setLocationRelativeTo(null);//Center the location of window
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Set Default Close Operation to DISPOSE_ON_CLOSE
		getContentPane().add(m_panelControl, BorderLayout.SOUTH);//Set panel Control in SOUTH
		
		buildGroupLayoutPanelControl();//Set Layout for Panel Control
		
		m_labelAlphabet.setFont(new Font(m_labelAlphabet.getFont().getName(), m_labelAlphabet.getFont().getStyle(), 15));// new font size is 15
		m_labelRules.setFont(new Font(m_labelRules.getFont().getName(), m_labelRules.getFont().getStyle(), 15));// new font size is 15
		m_labelRadius.setFont(new Font(m_labelRadius.getFont().getName(), m_labelRadius.getFont().getStyle(), 15));// new font size is 15
		
		getContentPane().add(m_panelRulesSetting, BorderLayout.CENTER);//Set panel RulesSetting in SOUTH
		
		m_separatorBetweenAlphabetAndRadius = new JSeparator();//Set separator between alphabet and Radius
		m_separatorBetweenRadiusAndRules = new JSeparator();//Set separator between Radius and Rules
		m_separatorBetweenRulesAndPanelControl = new JSeparator();//Set separator between Rules and panel control
		
		buildGroupLayoutPanelRulesSetting();//Set Layout for Panel RulesSetting
	}
	
	
	/******GroupLayout******/
	/**
	 * GroupLayout of Panel RulesSetting.
	 */
	private void buildGroupLayoutPanelRulesSetting(){
		GroupLayout gl_panelRulesSetting = new GroupLayout(m_panelRulesSetting);
		gl_panelRulesSetting.setHorizontalGroup(
			gl_panelRulesSetting.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRulesSetting.createSequentialGroup()
					.addGroup(gl_panelRulesSetting.createParallelGroup(Alignment.LEADING)
						.addComponent(m_separatorBetweenRadiusAndRules, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 10000, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panelRulesSetting.createParallelGroup(Alignment.LEADING, false)
							.addComponent(m_separatorBetweenRulesAndPanelControl, GroupLayout.DEFAULT_SIZE, 10000, Short.MAX_VALUE)
							.addGroup(gl_panelRulesSetting.createSequentialGroup()
								.addContainerGap()
								.addComponent(m_labelRules, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(m_formattedTextFieldRules, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelRulesSetting.createSequentialGroup()
								.addContainerGap()
								.addComponent(m_labelAlphabet, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGap(250)
								.addComponent(m_buttonPersonalize, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
						.addComponent(m_separatorBetweenAlphabetAndRadius, GroupLayout.DEFAULT_SIZE, 10000, Short.MAX_VALUE)
						.addGroup(gl_panelRulesSetting.createSequentialGroup()
							.addContainerGap()
							.addComponent(m_labelRadius)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(m_formattedTextFieldRadius, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelRulesSetting.setVerticalGroup(
			gl_panelRulesSetting.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelRulesSetting.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRulesSetting.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelAlphabet)
						.addComponent(m_buttonPersonalize))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(m_separatorBetweenRadiusAndRules, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_panelRulesSetting.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelRadius)
						.addComponent(m_formattedTextFieldRadius, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(m_separatorBetweenAlphabetAndRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelRulesSetting.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelRules, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(m_formattedTextFieldRules, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(m_separatorBetweenRulesAndPanelControl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		m_panelRulesSetting.setLayout(gl_panelRulesSetting);
	}
	

	/**
	 * GroupLayout of Panel Control.
	 */
	private void buildGroupLayoutPanelControl(){
		
		GroupLayout gl_panelControl = new GroupLayout(m_panelControl);
		gl_panelControl.setHorizontalGroup(
			gl_panelControl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelControl.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_buttonReset, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(m_checkBoxSetActualSettingAsDefault)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(m_checkBoxRememberSetting)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(m_buttonOk, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_panelControl.setVerticalGroup(
			gl_panelControl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelControl.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelControl.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_buttonReset, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(m_checkBoxSetActualSettingAsDefault)
						.addComponent(m_checkBoxRememberSetting)
						.addComponent(m_buttonOk, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		m_panelControl.setLayout(gl_panelControl);
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
		m_menuBarFileItem1.addActionListener(new CloseLocalElementaryRulesWindowEvent(this));
		m_menuBarFileItem2.addActionListener(new QuitEvent());
	}
	
	
	
	/******Listeners panel Control******/
	private void addListenerOnComponentsOfControlPanel(){
		m_buttonOk.addActionListener(new OKLocalElementaryRules1DEvent(this,m_currentInternalFrameSimulation1D,m_currentCell));//add listener of button OK
		m_formattedTextFieldRules.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//if the user press the enter touch		
		if(e.getKeyCode() == 10){
			m_buttonOk.doClick();//The button OK click himself
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
