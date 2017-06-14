package com.ter.CellularAutomaton.vue;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import com.ter.CellularAutomaton.controller.CloseElementaryRulesWindowEvent;
import com.ter.CellularAutomaton.controller.OKElementaryRules1DEvent;
import com.ter.CellularAutomaton.controller.PersonalizeElementaryCells1DEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;
import com.ter.CellularAutomaton.controller.ResetElementaryRules1DEvent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class ElementaryRulesWindow extends JFrame implements KeyListener, FocusListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/******ATTRIBUTES******/
	private MainWindow1D m_currentSimulator;
	
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
	private JFormattedTextField m_formattedTextFieldRadius;
	private final JLabel m_labelRules = new JLabel("Rules (0 to ?):");
	private JFormattedTextField m_formattedTextFieldRules;	
	private final JButton m_buttonOk = new JButton("OK");
	private final JButton m_buttonPersonalize = new JButton("Personalize");
	private JSeparator m_separatorBetweenAlphabetAndRadius;
	private JSeparator m_separatorBetweenRadiusAndRules;
	private JSeparator m_separatorBetweenRulesAndPanelControl;
	
	private NumberFormat m_formatForRadius;
	private NumberFormat m_formatForRules;
	
	/******GETTERS******/
	public JFormattedTextField getm_formattedTextFieldRadius() {
		return m_formattedTextFieldRadius;
	}
	
	public JFormattedTextField getm_formattedTextFieldRules() {
		return m_formattedTextFieldRules;
	}
	
	public JButton getm_buttonOk() {
		return m_buttonOk;
	}
	
	/******SETTERS******/
	public void setm_formattedTextFieldRadius(int newValue) {
		 m_formattedTextFieldRadius.setValue(newValue);
	}
	
	public void setm_formattedTextFieldRules(int newValue) {
		m_formattedTextFieldRules.setValue(newValue);
	}
	
	



	/**
	 * Create the application.
	 */
	public ElementaryRulesWindow(MainWindow1D currentSimulator) {
		
		m_currentSimulator = currentSimulator;// Initialize attribute with current simulator
		
		setUpFormats(); // Initializes the formats.
		
		buildComponentWindow();// Build component of window.
		
		this.initMenuMnemonic();// Set mnemonic of the MenuBar.
		
		this.initMenuBar();// We initialize our menuBar.
		
		this.addListenerMenuBar();// We initialize Listener of menuBar.
		
		this.addListenerOnComponentsOfRulesSettingPanel();// Initialize Listeners on Components of panel Rules Setting.
		
		this.addListenerOnComponentsOfControlPanel();// Initialize Listeners on Components of panel Control.
		
		this.setVisible(true);// Set the window visible.
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void buildComponentWindow() {
		this.setTitle("Elementary Rules Window");//Set the title of window
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
	
	//Create and set up number formats. These objects also
    //parse numbers input by user.
    private void setUpFormats() {
    	m_formatForRadius = NumberFormat.getIntegerInstance();
    	m_formatForRules = NumberFormat.getIntegerInstance();
    	
    	m_formattedTextFieldRadius = new JFormattedTextField(m_formatForRadius); // Set the format of the JFormattedTextField. 
    	m_formattedTextFieldRadius.setValue(new Integer(1)); // By default, the radius is 1.
    	
    	m_formattedTextFieldRules = new JFormattedTextField(m_formatForRules);
    	m_formattedTextFieldRules.setValue(new Integer(0)); // By default, the rules is 0.
    	
    	//m_formattedTextFieldRadius.addPropertyChangeListener("value", this); // Listener of JFormattedTextField.
    	//m_formattedTextFieldRules.addPropertyChangeListener("value", this); // Listener of JFormattedTextField.

    	m_formattedTextFieldRadius.getDocument().addDocumentListener(new DocumentListener() {
    		
    		private static final String invalidInput = "Your input is invalid. It must be a integer.";
    		private static final String validInput = "Your input is valid.";

    		@Override
				public void changedUpdate(DocumentEvent arg0) {
					if(!this.isInteger(m_formattedTextFieldRadius.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
			        	m_formattedTextFieldRadius.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
			        	m_formattedTextFieldRadius.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
			        	}
			        	else{// If the text in m_formattedTextFieldRadius is an Integer
			        		m_formattedTextFieldRadius.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
			            	m_formattedTextFieldRadius.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
			        	}
					
					
					if(this.isInteger(m_formattedTextFieldRadius.getText()) && this.isInteger(m_formattedTextFieldRules.getText())){
						m_buttonOk.setEnabled(true);
					}
					else{
						m_buttonOk.setEnabled(false);
					}
				}
				
				@Override
				public void insertUpdate(DocumentEvent arg0) {
					if(!this.isInteger(m_formattedTextFieldRadius.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
			        	m_formattedTextFieldRadius.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
			        	m_formattedTextFieldRadius.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
			        	}
			        	else{// If the text in m_formattedTextFieldRadius is an Integer
			        		m_formattedTextFieldRadius.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
			            	m_formattedTextFieldRadius.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
			        	}
					
					
					if(this.isInteger(m_formattedTextFieldRadius.getText()) && this.isInteger(m_formattedTextFieldRules.getText())){
						m_buttonOk.setEnabled(true);
					}
					else{
						m_buttonOk.setEnabled(false);
					}
					
				}
				@Override
				public void removeUpdate(DocumentEvent arg0) {
					if(!this.isInteger(m_formattedTextFieldRadius.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
			        	m_formattedTextFieldRadius.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
			        	m_formattedTextFieldRadius.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
			        	}
			        	else{// If the text in m_formattedTextFieldRadius is an Integer
			        		m_formattedTextFieldRadius.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
			            	m_formattedTextFieldRadius.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
			        	}
					
					
					if(this.isInteger(m_formattedTextFieldRadius.getText()) && this.isInteger(m_formattedTextFieldRules.getText())){
						m_buttonOk.setEnabled(true);
					}
					else{
						m_buttonOk.setEnabled(false);
					}
					
				}
				
				
				private boolean isInteger(String chaine) {
					try {
			  			Integer.parseInt(chaine);
			  		} catch (NumberFormatException e){
			  			return false;
			  		}
			   
			  		return true;
				}
    			});
    	
    	
    	
    	m_formattedTextFieldRules.getDocument().addDocumentListener(new DocumentListener() {
    		private static final String invalidInput = "Your input is invalid. It must be a integer.";
    		private static final String validInput = "Your input is valid.";

    		@Override
			public void changedUpdate(DocumentEvent arg0) {
				if(!this.isInteger(m_formattedTextFieldRules.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
					m_formattedTextFieldRules.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
					m_formattedTextFieldRules.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
		        	}
		        	else{// If the text in m_formattedTextFieldRadius is an Integer
		        		m_formattedTextFieldRules.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
		        		m_formattedTextFieldRules.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
		        	}
				
				
				if(this.isInteger(m_formattedTextFieldRadius.getText()) && this.isInteger(m_formattedTextFieldRules.getText())){
					m_buttonOk.setEnabled(true);
				}
				else{
					m_buttonOk.setEnabled(false);
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				if(!this.isInteger(m_formattedTextFieldRules.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
					m_formattedTextFieldRules.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
					m_formattedTextFieldRules.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
		        	}
		        	else{// If the text in m_formattedTextFieldRadius is an Integer
		        		m_formattedTextFieldRules.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
		        		m_formattedTextFieldRules.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
		        	}
				
				
				if(this.isInteger(m_formattedTextFieldRadius.getText()) && this.isInteger(m_formattedTextFieldRules.getText())){
					m_buttonOk.setEnabled(true);
				}
				else{
					m_buttonOk.setEnabled(false);
				}
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				if(!this.isInteger(m_formattedTextFieldRules.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
					m_formattedTextFieldRules.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
					m_formattedTextFieldRules.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
		        	}
		        	else{// If the text in m_formattedTextFieldRadius is an Integer
		        		m_formattedTextFieldRules.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
		        		m_formattedTextFieldRules.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
		        	}
				
				if(this.isInteger(m_formattedTextFieldRadius.getText()) && this.isInteger(m_formattedTextFieldRules.getText())){
					m_buttonOk.setEnabled(true);
				}
				else{
					m_buttonOk.setEnabled(false);
				}
				
			}
			
			
			private boolean isInteger(String chaine) {
				try {
		  			Integer.parseInt(chaine);
		  		} catch (NumberFormatException e){
		  			return false;
		  		}
		   
		  		return true;
			}
			});
    
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
	
	/**
	 * ****CLASS METHODS*****.
	 */
	/**
	 * If the parameter is an Integer, return true. Otherwise return false.
	 */
    private boolean isInteger(String chaine) {
  		try {
  			Integer.parseInt(chaine);
  		} catch (NumberFormatException e){
  			return false;
  		}
   
  		return true;
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
		m_menuBarFileItem1.addActionListener(new CloseElementaryRulesWindowEvent(this));
		m_menuBarFileItem2.addActionListener(new QuitEvent());
	}
	
	
	/******Listeners Panel Rules Setting******/
	private void addListenerOnComponentsOfRulesSettingPanel(){
		addListenerOnComponentsPersonalizeButton();
	}
	
	private void addListenerOnComponentsPersonalizeButton(){
		m_buttonPersonalize.addActionListener(new PersonalizeElementaryCells1DEvent(m_currentSimulator));
	}
	
	
	/******Listeners panel Control******/
	private void addListenerOnComponentsOfControlPanel(){
		m_buttonOk.addActionListener(new OKElementaryRules1DEvent

(this,m_currentSimulator));//add listener of button OK
		m_buttonOk.addFocusListener(this);
		m_formattedTextFieldRules.addKeyListener(this);
		m_buttonReset.addActionListener(new ResetElementaryRules1DEvent(this));
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
	
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		if(this.isInteger(m_formattedTextFieldRadius.getText()) && this.isInteger

(m_formattedTextFieldRules.getText())){
			m_buttonOk.doClick();
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}
    
}
