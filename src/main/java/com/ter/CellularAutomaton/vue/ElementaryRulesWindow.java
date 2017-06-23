package com.ter.CellularAutomaton.vue;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import com.ter.CellularAutomaton.controller.CloseElementaryRulesWindowEvent;
import com.ter.CellularAutomaton.controller.CopyElementaryRulesWindowEvent;
import com.ter.CellularAutomaton.controller.CutElementaryRulesWindowEvent;
import com.ter.CellularAutomaton.controller.OKElementaryRules1DEvent;
import com.ter.CellularAutomaton.controller.PasteElementaryRulesWindowEvent;
import com.ter.CellularAutomaton.controller.PersonalizeElementaryCells1DEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;
import com.ter.CellularAutomaton.controller.ResetElementaryRules1DEvent;
import com.ter.CellularAutomaton.controller.SelectAllElementaryRulesWindowEvent;
import com.ter.CellularAutomaton.controller.UndoManagerHelper;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
import javax.swing.undo.UndoManager;


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
	private JMenuItem m_menuBarFileItem1 = new JMenuItem("Close", new ImageIcon("Files/Images/Icons/File_Menu/Close.png"));

	/** The menu bar file item 2. */
	private JMenuItem m_menuBarFileItem2 = new JMenuItem("Quit");

	/** The menu Edit. */
	//Tab in MenuBar
	private JMenu m_menuEdit = new JMenu("Edit");
	
	/** The menu bar edit item 1. */
	// In edit menu
	private JMenuItem m_menuBarEditItem1 = new JMenuItem("Undo", new ImageIcon("Files/Images/Icons/Edit_Menu/Undo.png"));
	
	/** The menu bar edit item 2. */
	private JMenuItem m_menuBarEditItem2 = new JMenuItem("Redo", new ImageIcon("Files/Images/Icons/Edit_Menu/Redo.png"));

	/** The menu bar edit item 3. */
	private JMenuItem m_menuBarEditItem3 = new JMenuItem("Cut", new ImageIcon("Files/Images/Icons/Edit_Menu/Cut.png"));


	/** The menu bar file item 1. */
	private JMenuItem m_menuBarEditItem4 = new JMenuItem("Copy", new ImageIcon("Files/Images/Icons/Edit_Menu/Copy.png"));

	/** The menu bar file item 2. */
	private JMenuItem m_menuBarEditItem5 = new JMenuItem("Paste", new ImageIcon("Files/Images/Icons/Edit_Menu/Paste.png"));

	/** The menu bar edit item 6. */
	private JMenuItem m_menuBarEditItem6 = new JMenuItem("Select all");
	
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

	private boolean m_isRadiusFocus = false;
	
	private UndoManager m_manager = new UndoManager();
	
	private JLabel m_lblNewLabel;

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
	
	public boolean getm_isRadiusFocus() {
		return m_isRadiusFocus;
	}
	
	public UndoManager getm_manager() {
		return m_manager;
	}
	
	public JMenuItem getm_menuBarEditItem1() {
		return m_menuBarEditItem1;
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

		this.setIconWindow();//Set icon on window
		
		this.setVisible(true);// Set the window visible.
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
	private void buildComponentWindow() {
		this.setTitle("Elementary Rules Window");//Set the title of window
		this.setSize(550,337);//Set size of window
		this.setLocationRelativeTo(null);//Center the location of window
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Set Default Close Operation to DISPOSE_ON_CLOSE
		getContentPane().add(m_panelControl, BorderLayout.SOUTH);//Set panel Control in SOUTH

		buildGroupLayoutPanelControl();//Set Layout for Panel Control
		m_labelAlphabet.setBounds(10, 11, 140, 19);

		m_labelAlphabet.setFont(new Font(m_labelAlphabet.getFont().getName(), m_labelAlphabet.getFont().getStyle(), 15));// new font size is 15
		m_labelRules.setBounds(10, 163, 126, 19);
		m_labelRules.setFont(new Font(m_labelRules.getFont().getName(), m_labelRules.getFont().getStyle(), 15));// new font size is 15
		m_labelRadius.setBounds(10, 80, 274, 19);
		m_labelRadius.setFont(new Font(m_labelRadius.getFont().getName(), m_labelRadius.getFont().getStyle(), 15));// new font size is 15

		getContentPane().add(m_panelRulesSetting, BorderLayout.CENTER);//Set panel RulesSetting in SOUTH

		m_separatorBetweenAlphabetAndRadius = new JSeparator();//Set separator between alphabet and Radius
		m_separatorBetweenAlphabetAndRadius.setBounds(0, 145, 10000, 2);
		m_separatorBetweenRadiusAndRules = new JSeparator();//Set separator between Radius and Rules
		m_separatorBetweenRadiusAndRules.setBounds(0, 45, 10000, 2);
		m_separatorBetweenRulesAndPanelControl = new JSeparator();//Set separator between Rules and panel control
		m_separatorBetweenRulesAndPanelControl.setBounds(0, 208, 10000, 2);

		buildGroupLayoutPanelRulesSetting();//Set Layout for Panel RulesSetting
	}

	//Create and set up number formats. These objects also
	//parse numbers input by user.
	private void setUpFormats() {
		m_formatForRadius = NumberFormat.getIntegerInstance();
		m_formatForRules = NumberFormat.getIntegerInstance();

		m_formattedTextFieldRadius = new JFormattedTextField(m_formatForRadius); // Set the format of the JFormattedTextField. 
		m_formattedTextFieldRadius.setBounds(294, 75, 205, 33);
		m_formattedTextFieldRadius.setValue(new Integer(1)); // By default, the radius is 1.

		m_formattedTextFieldRules = new JFormattedTextField(m_formatForRules);
		m_formattedTextFieldRules.setBounds(140, 158, 375, 32);
		m_formattedTextFieldRules.setValue(new Integer(0)); // By default, the rules is 0.

		//m_formattedTextFieldRadius.addPropertyChangeListener("value", this); // Listener of JFormattedTextField.
		//m_formattedTextFieldRules.addPropertyChangeListener("value", this); // Listener of JFormattedTextField.

		m_formattedTextFieldRadius.getDocument().addDocumentListener(new DocumentListener() {

			private static final String invalidInput = "Your input is invalid. It must be a integer.";
			private static final String validInput = "Your input is valid.";

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				m_isRadiusFocus = true;
				if(!this.isInteger(m_formattedTextFieldRadius.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
					//m_formattedTextFieldRadius.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
					m_formattedTextFieldRadius.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
					m_lblNewLabel.setText(invalidInput);
					m_lblNewLabel.setForeground(new Color(255,0,0));
				}
				else{// If the text in m_formattedTextFieldRadius is an Integer
					//m_formattedTextFieldRadius.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
					m_formattedTextFieldRadius.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
					m_lblNewLabel.setText(validInput);
					m_lblNewLabel.setForeground(new Color(0,0,0));
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
				m_isRadiusFocus = true;
				if(!this.isInteger(m_formattedTextFieldRadius.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
					//m_formattedTextFieldRadius.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
					m_formattedTextFieldRadius.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
					m_lblNewLabel.setText(invalidInput);
					m_lblNewLabel.setForeground(new Color(255,0,0));
				}
				else{// If the text in m_formattedTextFieldRadius is an Integer
					//m_formattedTextFieldRadius.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
					m_formattedTextFieldRadius.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
					m_lblNewLabel.setText(validInput);
					m_lblNewLabel.setForeground(new Color(0,0,0));
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
				m_isRadiusFocus = true;
				if(!this.isInteger(m_formattedTextFieldRadius.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
					//m_formattedTextFieldRadius.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
					m_formattedTextFieldRadius.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
					m_lblNewLabel.setText(invalidInput);
					m_lblNewLabel.setForeground(new Color(255,0,0));
				}
				else{// If the text in m_formattedTextFieldRadius is an Integer
					//m_formattedTextFieldRadius.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
					m_formattedTextFieldRadius.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
					m_lblNewLabel.setText(validInput);
					m_lblNewLabel.setForeground(new Color(0,0,0));
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
				m_isRadiusFocus = false;
				if(!this.isInteger(m_formattedTextFieldRules.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
					//m_formattedTextFieldRules.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
					m_formattedTextFieldRules.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
					m_lblNewLabel.setText(invalidInput);
					m_lblNewLabel.setForeground(new Color(255,0,0));
				}
				else{// If the text in m_formattedTextFieldRadius is an Integer
					//m_formattedTextFieldRules.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
					m_formattedTextFieldRules.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
					m_lblNewLabel.setText(validInput);
					m_lblNewLabel.setForeground(new Color(0,0,0));
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
				m_isRadiusFocus = false;
				if(!this.isInteger(m_formattedTextFieldRules.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
					//m_formattedTextFieldRules.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
					m_formattedTextFieldRules.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
					m_lblNewLabel.setText(invalidInput);
					m_lblNewLabel.setForeground(new Color(255,0,0));
				}
				else{// If the text in m_formattedTextFieldRadius is an Integer
					//m_formattedTextFieldRules.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
					m_formattedTextFieldRules.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
					m_lblNewLabel.setText(validInput);
					m_lblNewLabel.setForeground(new Color(0,0,0));
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
				m_isRadiusFocus = false;
				if(!this.isInteger(m_formattedTextFieldRules.getText())){ // If the text in m_formattedTextFieldRadius is not an Integer
					//m_formattedTextFieldRules.setBackground(new Color(255,0,0)); // Set the background of m_formattedTextFieldRadius to red to tell the user that his input is invalid. 
					m_formattedTextFieldRules.setToolTipText(invalidInput); // Put an infoBulle to tell the user that his input is invalid.
					m_lblNewLabel.setText(invalidInput);
					m_lblNewLabel.setForeground(new Color(255,0,0));
				}
				else{// If the text in m_formattedTextFieldRadius is an Integer
					//m_formattedTextFieldRules.setBackground(new Color(0,255,0)); // Set the background of m_formattedTextFieldRadius to green to tell the user that his input is valid. 
					m_formattedTextFieldRules.setToolTipText(validInput); // Put an infoBulle to tell the user that his input is valid.
					m_lblNewLabel.setText(validInput);
					m_lblNewLabel.setForeground(new Color(0,0,0));
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
		m_panelRulesSetting.setLayout(null);
		m_panelRulesSetting.add(m_separatorBetweenRadiusAndRules);
		m_panelRulesSetting.add(m_separatorBetweenRulesAndPanelControl);
		m_panelRulesSetting.add(m_labelRules);
		m_panelRulesSetting.add(m_formattedTextFieldRules);
		m_panelRulesSetting.add(m_labelAlphabet);
		m_buttonPersonalize.setBounds(400, 11, 120, 23);
		m_panelRulesSetting.add(m_buttonPersonalize);
		m_panelRulesSetting.add(m_separatorBetweenAlphabetAndRadius);
		m_panelRulesSetting.add(m_labelRadius);
		m_panelRulesSetting.add(m_formattedTextFieldRadius);
		
		m_lblNewLabel = new JLabel("Your input is valid.");
		m_lblNewLabel.setBounds(210, 210, 324, 14);
		m_panelRulesSetting.add(m_lblNewLabel);
	}


	/**
	 * GroupLayout of Panel Control.
	 */
	private void buildGroupLayoutPanelControl(){
		
		JSeparator separator = new JSeparator();

		GroupLayout gl_panelControl = new GroupLayout(m_panelControl);
		gl_panelControl.setHorizontalGroup(
			gl_panelControl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelControl.createSequentialGroup()
					.addGroup(gl_panelControl.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelControl.createSequentialGroup()
							.addContainerGap()
							.addComponent(m_buttonReset, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(m_checkBoxSetActualSettingAsDefault)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(m_checkBoxRememberSetting)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(m_buttonOk, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10000, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelControl.setVerticalGroup(
			gl_panelControl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelControl.createSequentialGroup()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
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
		this.constructTabEditMenuBar();//Construction of the tab "Edit" of menuBar


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

	/**
	 * Construct tab Edit menu bar.
	 */
	private void constructTabEditMenuBar(){
		//Construction of the tab "Edit" of menuBar
		this.m_menuEdit.add(m_menuBarEditItem1); // Adding a tab "Undo" in tab Edit in MenuBar.
		this.m_menuEdit.add(m_menuBarEditItem2); // Adding a tab "Redo" in tab Edit in MenuBar.
		this.m_menuEdit.addSeparator(); // Adding a separator in tab Edit of the MenuBar.
		this.m_menuEdit.add(m_menuBarEditItem3); // Adding a tab "Cut" in tab Edit in MenuBar.
		this.m_menuEdit.add(m_menuBarEditItem4); // Adding a tab "Copy" in tab Edit in MenuBar.
		this.m_menuEdit.add(m_menuBarEditItem5); // Adding a tab "Paste" in tab Edit in MenuBar.
		this.m_menuEdit.addSeparator(); // Adding a separator in tab Edit of the MenuBar.
		this.m_menuEdit.add(m_menuBarEditItem6); // Adding a tab "Select all" in tab Edit in MenuBar.
		this.m_menuBar.add(m_menuEdit); // The Edit tab is added to MenuBar.
	}

	/******Mnemonic******/
	/**
	 * Inits the menu mnemonic.
	 */
	private void initMenuMnemonic(){
		//add all the mnémonic for the MenuBar
		m_menuFile.setMnemonic('F');
		m_menuEdit.setMnemonic('E');
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
		this.addListenerEdit(); //add listener of tab Edit
	}

	//add listeners for tab File in MenuBar
	private void addListenerFile (){
		m_menuBarFileItem1.addActionListener(new CloseElementaryRulesWindowEvent(this));
		m_menuBarFileItem2.addActionListener(new QuitEvent());
	}

	//add listeners for tab File in MenuBar
	private void addListenerEdit (){
		m_menuBarEditItem3.addActionListener(new CutElementaryRulesWindowEvent(this));
		m_menuBarEditItem4.addActionListener(new CopyElementaryRulesWindowEvent(this));
		m_menuBarEditItem5.addActionListener(new PasteElementaryRulesWindowEvent(this));
		m_menuBarEditItem6.addActionListener(new SelectAllElementaryRulesWindowEvent(this));
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
		m_formattedTextFieldRadius.addKeyListener(this);
		m_formattedTextFieldRules.addKeyListener(this);
		m_buttonReset.addActionListener(new ResetElementaryRules1DEvent(this));
		

		m_formattedTextFieldRadius.getDocument().addUndoableEditListener(m_manager);
		m_formattedTextFieldRules.getDocument().addUndoableEditListener(m_manager);
		
		m_menuBarEditItem1.addActionListener(UndoManagerHelper.getUndoAction(m_manager));
		m_menuBarEditItem2.addActionListener(UndoManagerHelper.getRedoAction(m_manager));
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
