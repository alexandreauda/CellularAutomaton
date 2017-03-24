package com.ter.CellularAutomaton.vue;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import com.ter.CellularAutomaton.controller.CloseElementaryRulesWindowEvent;
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


public class ElementaryRulesWindow extends JFrame {

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
	private final JCheckBox m_CheckBoxRememberSetting = new JCheckBox("Remember this setting");
	private final JPanel m_panelRulesSetting = new JPanel();
	private final JLabel m_labelAlphabet = new JLabel("Alphabet (0 to ?):");
	private final JFormattedTextField m_formattedTextFieldAlphabet = new JFormattedTextField();
	private final JLabel m_labelRules = new JLabel("Rules (0 to 255):");
	private final JFormattedTextField m_formattedTextFieldRules = new JFormattedTextField();
	private final JButton m_buttonOk = new JButton("OK");
	private final JButton btnNewButton = new JButton("Personalize");
	private JSeparator m_separatorBetweenAlphabetAndRules;
	private JSeparator m_separatorBetweenRulesAndPanelControl;


	/**
	 * Create the application.
	 */
	public ElementaryRulesWindow() {
		
		buildComponentWindow();//Build component of window
		
		this.initMenuMnemonic();//Set mnemonic of the MenuBar
		
		this.initMenuBar();//We initialize our menuBar
		
		this.addListenerMenuBar();//We initialize Listener of menuBar
		
		this.setVisible(true);//Set the window visible
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void buildComponentWindow() {
		this.setTitle("Elementary Rules Window");//Set the title of window
		this.setSize(470,320);//Set size of window
		this.setLocationRelativeTo(null);//Center the location of window
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Set Default Close Operation to DISPOSE_ON_CLOSE
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
						.addComponent(m_separatorBetweenAlphabetAndRules, GroupLayout.PREFERRED_SIZE, 10000, GroupLayout.PREFERRED_SIZE)
						.addComponent(m_separatorBetweenRulesAndPanelControl, GroupLayout.PREFERRED_SIZE, 10000, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelRulesSetting.createSequentialGroup()
							.addContainerGap()
							.addComponent(m_labelAlphabet, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(m_formattedTextFieldAlphabet, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelRulesSetting.createSequentialGroup()
							.addContainerGap()
							.addComponent(m_labelRules, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(m_formattedTextFieldRules, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelRulesSetting.setVerticalGroup(
			gl_panelRulesSetting.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRulesSetting.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panelRulesSetting.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelAlphabet)
						.addComponent(m_formattedTextFieldAlphabet, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(39)
					.addComponent(m_separatorBetweenAlphabetAndRules, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_panelRulesSetting.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelRules, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(m_formattedTextFieldRules, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
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
					.addComponent(m_buttonReset, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(m_CheckBoxRememberSetting)
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(m_buttonOk, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelControl.setVerticalGroup(
			gl_panelControl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelControl.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelControl.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_CheckBoxRememberSetting)
						.addComponent(m_buttonOk, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(m_buttonReset, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
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
		
		getContentPane().add(m_panelControl, BorderLayout.SOUTH);//Set panel Control in SOUTH
		
		buildGroupLayoutPanelControl();//Set Layout for Panel Control
		
		m_labelAlphabet.setFont(new Font(m_labelAlphabet.getFont().getName(), m_labelAlphabet.getFont().getStyle(), 15));// new font size is 15
		m_labelRules.setFont(new Font(m_labelRules.getFont().getName(), m_labelRules.getFont().getStyle(), 15));// new font size is 15
		
		getContentPane().add(m_panelRulesSetting, BorderLayout.CENTER);//Set panel RulesSetting in SOUTH
		
		m_separatorBetweenAlphabetAndRules = new JSeparator();//Set separator between alphabet and rules
		m_separatorBetweenRulesAndPanelControl = new JSeparator();//Set separator between Rules and panel control
		
		buildGroupLayoutPanelRulesSetting();//Set Layout for Panel RulesSetting
		
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
		m_menuBarFileItem1.addActionListener(new CloseElementaryRulesWindowEvent(this));
		m_menuBarFileItem2.addActionListener(new QuitEvent());
	}
}
