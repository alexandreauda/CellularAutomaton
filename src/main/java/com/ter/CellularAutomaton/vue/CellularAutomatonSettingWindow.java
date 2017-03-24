package com.ter.CellularAutomaton.vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.ter.CellularAutomaton.controller.GlobalCardWindowSettingEvent;
import com.ter.CellularAutomaton.controller.LocalCardWindowSettingEvent;

import java.awt.CardLayout;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class CellularAutomatonSettingWindow extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private JPanel m_mainPanel;
	private JPanel m_panelChooseTypeFunction;
	private JPanel m_panelResetValidateSetting;
	private JPanel m_panelEnterSetting;
	private GroupLayout m_groupLayoutMainPanel;
	private JButton m_buttonReset;
	private JButton m_buttonOK;
	private GroupLayout m_groupLayoutPanelResetValidateSetting;
	private JLabel m_labelDefinitionByFunction;
	private ButtonGroup m_radioButtonGroup;
	private JRadioButton m_radioButtonLocal;
	private JRadioButton m_radioButtonGlobal;
	private GroupLayout m_groupLayoutPanelChooseTypeFunction;
	private JCheckBox m_checkBoxSetActualSetting;
	private CardLayout m_cardLayoutOnPanelEnterSetting;
	private JPanel m_localCard;
	private JPanel m_globalcard;
	private boolean m_showPanelLocalSetting;
	private JPanel m_panelOnLocalCardAlphabet;
	private JPanel m_panelOnLocalCardRadius;
	private JPanel m_panelOnLocalCardLocalFunction;
	private JLabel m_labelOnLocalCardAlphabet;
	private JTextField m_textFieldOnLocalCardAlphabet;
	private JLabel m_labelOnLocalCardRadius;
	private JTextField m_textFieldOnLocalCardRadius;
	private JLabel m_labelOnLocalCardLocalFunction;
	private JTextField m_textFieldOnLocalCardLocalFunction;
	private JPanel m_panelOnGlobalCardAlphabet;
	private JLabel m_labelOnGlobalCardAlphabet;
	private JTextField m_textFieldOnGlobalCardAlphabet;
	private JPanel m_panelOnGlobalCardGlobalFunction;
	private JLabel m_labelOnGlobalCardGlobalFunction;
	private JTextField m_textFieldOnGlobalCardGlobalFunction;
	private JSeparator m_separatorOnLocalCardBetweenRadiosButtonAndAlphabet;
	private JSeparator m_separatorOnLocalCardBetweenAlphabetAndRadius;
	private JSeparator m_separatorOnLocalCardBetweenRadiusAndLocalFunction;
	private JSeparator m_separatorOnLocalCardBetweenLocalFunctionAndValidate;
	private JSeparator m_separatorOnGlobalCardBetweenRadiosButtonAndAlphabet;
	private JSeparator m_separatorOnGlobalCardBetweenAlphabetAndGlobalFunction;
	
	/******GETTERS******/
	public boolean getm_showPanelLocalSetting(){
		return m_showPanelLocalSetting;
	}
	
	public CardLayout getm_cardLayoutOnPanelEnterSetting(){
		return m_cardLayoutOnPanelEnterSetting;
	}
	
	public JPanel getm_panelEnterSetting(){
		return m_panelEnterSetting;
	}
	
	/******SETTERS******/
	public void setm_showPanelLocalSetting(boolean showPanelLocalSetting){
		m_showPanelLocalSetting=showPanelLocalSetting;
	}
	

	/**
	* Create the application.
	*/
	public CellularAutomatonSettingWindow() {
		this.setTitle("Cellular Automaton Setting");
		this.setSize(480,310);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		m_showPanelLocalSetting=true;//Set the radioButton m_radioButtonLocal to true by default
		buildMainPanel();
	}

	
	/******Build MainWindowSetting******/
	
	/**
	* Initialize the contents of the frame.
	*/
	private void buildMainPanel() {
		
		m_mainPanel = new JPanel();
		getContentPane().add(m_mainPanel, BorderLayout.CENTER);
		
		buildComponentPanelChooseTypeFunction();		
		
		buildComponentPanelResetValidateSetting();
		
		buildComponentPanelEnterSetting();
		
		buildGroupLayoutMainPanel();

		this.setVisible(true);
	}
	
	
	
	private void buildGroupLayoutMainPanel(){
		m_groupLayoutMainPanel = new GroupLayout(m_mainPanel);
		m_groupLayoutMainPanel.setHorizontalGroup(
			m_groupLayoutMainPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(m_panelChooseTypeFunction, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(m_panelEnterSetting, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(m_panelResetValidateSetting, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		m_groupLayoutMainPanel.setVerticalGroup(
			m_groupLayoutMainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(m_groupLayoutMainPanel.createSequentialGroup()
					.addComponent(m_panelChooseTypeFunction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_panelEnterSetting, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_panelResetValidateSetting, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
		);
		m_mainPanel.setLayout(m_groupLayoutMainPanel);
	}
	
	
	
	/******Build Component of Panel ResetValidateSetting******/
	
	private void buildComponentPanelResetValidateSetting(){
		m_panelResetValidateSetting = new JPanel();
		m_buttonReset = new JButton("Reset");
		m_checkBoxSetActualSetting = new JCheckBox("Set Actual Setting By Default");
		m_buttonOK = new JButton("OK");
		
		m_separatorOnLocalCardBetweenLocalFunctionAndValidate = new JSeparator();
		
		buildGroupLayoutPanelResetValidateSetting();
	}
	
	private void buildGroupLayoutPanelResetValidateSetting(){
		m_groupLayoutPanelResetValidateSetting = new GroupLayout(m_panelResetValidateSetting);
		m_groupLayoutPanelResetValidateSetting.setHorizontalGroup(
			m_groupLayoutPanelResetValidateSetting.createParallelGroup(Alignment.LEADING)
				.addGroup(m_groupLayoutPanelResetValidateSetting.createSequentialGroup()
					.addGroup(m_groupLayoutPanelResetValidateSetting.createParallelGroup(Alignment.LEADING)
						.addGroup(m_groupLayoutPanelResetValidateSetting.createSequentialGroup()
							.addContainerGap()
							.addComponent(m_buttonReset, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(m_checkBoxSetActualSetting)
							.addGap(36)
							.addComponent(m_buttonOK, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addComponent(m_separatorOnLocalCardBetweenLocalFunctionAndValidate, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		m_groupLayoutPanelResetValidateSetting.setVerticalGroup(
			m_groupLayoutPanelResetValidateSetting.createParallelGroup(Alignment.LEADING)
				.addGroup(m_groupLayoutPanelResetValidateSetting.createSequentialGroup()
					.addComponent(m_separatorOnLocalCardBetweenLocalFunctionAndValidate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(m_groupLayoutPanelResetValidateSetting.createParallelGroup(Alignment.LEADING)
						.addGroup(m_groupLayoutPanelResetValidateSetting.createParallelGroup(Alignment.BASELINE)
							.addComponent(m_buttonReset)
							.addComponent(m_checkBoxSetActualSetting))
						.addComponent(m_buttonOK))
					.addContainerGap())
		);
		m_panelResetValidateSetting.setLayout(m_groupLayoutPanelResetValidateSetting);
	}
	
	
	/******Build Component of Panel ChooseTypeFunction******/
	
	private void buildComponentPanelChooseTypeFunction(){
		m_panelChooseTypeFunction = new JPanel();
		m_labelDefinitionByFunction = new JLabel("Definition by function: ");
		
		m_radioButtonLocal = new JRadioButton("local");
		m_radioButtonGlobal = new JRadioButton("global");
		
		m_radioButtonLocal.addActionListener(new LocalCardWindowSettingEvent(this));//Add actionListener to radioButton m_radioButtonLocal
		m_radioButtonGlobal.addActionListener(new GlobalCardWindowSettingEvent(this));//Add actionListener to radioButton m_radioButtonGlobal
		
		//Creation of ButtonGroup
		m_radioButtonGroup = new ButtonGroup();//Create ButtonGroup
		m_radioButtonGroup.add(m_radioButtonLocal);//Adding the radioButton rdbtnLocal to ButtonGroup m_radioButtonGroup
		m_radioButtonGroup.add(m_radioButtonGlobal);//Adding the radioButton rdbtnGlobal to ButtonGroup m_radioButtonGroup
		m_radioButtonLocal.setSelected(m_showPanelLocalSetting);//Set the radioButton m_radioButtonLocal to value of m_showPanelLocalSetting by default
		m_radioButtonGlobal.setSelected(!m_showPanelLocalSetting);//Set the radioButton m_radioButtonLocal to !value of m_showPanelLocalSetting by default
		
		m_groupLayoutPanelChooseTypeFunction = new GroupLayout(m_panelChooseTypeFunction);
		m_groupLayoutPanelChooseTypeFunction.setHorizontalGroup(
			m_groupLayoutPanelChooseTypeFunction.createParallelGroup(Alignment.LEADING)
				.addGroup(m_groupLayoutPanelChooseTypeFunction.createSequentialGroup()
					.addGap(83)
					.addComponent(m_labelDefinitionByFunction)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(m_radioButtonLocal)
					.addGap(12)
					.addComponent(m_radioButtonGlobal)
					.addGap(124))
		);
		m_groupLayoutPanelChooseTypeFunction.setVerticalGroup(
			m_groupLayoutPanelChooseTypeFunction.createParallelGroup(Alignment.LEADING)
				.addGroup(m_groupLayoutPanelChooseTypeFunction.createSequentialGroup()
					.addGap(5)
					.addGroup(m_groupLayoutPanelChooseTypeFunction.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelDefinitionByFunction)
						.addComponent(m_radioButtonGlobal)
						.addComponent(m_radioButtonLocal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
		);
		m_panelChooseTypeFunction.setLayout(m_groupLayoutPanelChooseTypeFunction);
	}
	
	/******Build Component of Panel EnterSetting******/
	
	private void buildComponentPanelEnterSetting(){
		m_panelEnterSetting = new JPanel();
		m_cardLayoutOnPanelEnterSetting=new CardLayout(0, 0);
		m_panelEnterSetting.setLayout(m_cardLayoutOnPanelEnterSetting);
		
		buildComponentCard();
	}
	
	private void buildComponentCard() {
		//Creation of two card. The first contain the localFunction interface and the second contain the globalFunction interface
	    m_localCard = new JPanel();//Create a card panel witch represent local interface
	    m_globalcard = new JPanel();//Create a card panel witch represent global interface
	    
	    //Add the cards m_localcard and m_globalcard to panel m_panelEnterSetting witch has a cardLayout
	    m_panelEnterSetting.add(m_localCard);
	    m_panelEnterSetting.add(m_globalcard);
	    
	    buildLocalCard();//Build component of window when user choose local function
	    
	    buildGlobalCard();//Build component of window when user choose global function
	}
	
	private void buildLocalCard() {
		buildComponentPanelOnLocalCardAlphabet();//Add the panel Alphabet
	    
		buildComponentPanelOnLocalCardRadius();//Add the panel Radius
		
		buildComponentPanelOnLocalCardLocalFunction();//Add the panel LocalFunction
	    
		buildGroupLayoutlocalCard();//Set the layout of panel m_localCard
	}
	
	private void buildComponentPanelOnLocalCardAlphabet(){
		m_panelOnLocalCardAlphabet = new JPanel();
	    m_labelOnLocalCardAlphabet = new JLabel("Alphabet (0 to ?):");
	    m_textFieldOnLocalCardAlphabet = new JTextField();
	    m_textFieldOnLocalCardAlphabet.setColumns(10);
	    
	    m_separatorOnLocalCardBetweenRadiosButtonAndAlphabet = new JSeparator();
	    
	    buildGroupLayoutPanelOnLocalCardAlphabet();
	}
	
	private void buildGroupLayoutPanelOnLocalCardAlphabet() {
		
		
		GroupLayout gl_panel = new GroupLayout(m_panelOnLocalCardAlphabet);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_labelOnLocalCardAlphabet)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_textFieldOnLocalCardAlphabet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(246, Short.MAX_VALUE))
				.addComponent(m_separatorOnLocalCardBetweenRadiosButtonAndAlphabet, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(m_separatorOnLocalCardBetweenRadiosButtonAndAlphabet, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelOnLocalCardAlphabet)
						.addComponent(m_textFieldOnLocalCardAlphabet, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
	    m_panelOnLocalCardAlphabet.setLayout(gl_panel);
	}
	
	private void buildComponentPanelOnLocalCardRadius() {
		m_panelOnLocalCardRadius = new JPanel();
	    m_labelOnLocalCardRadius = new JLabel("Radius (must be equal or greater than 1):");
	    
	    m_textFieldOnLocalCardRadius = new JTextField();
	    m_textFieldOnLocalCardRadius.setColumns(10);
	    
	    m_separatorOnLocalCardBetweenAlphabetAndRadius = new JSeparator();
	    
	    buildGroupLayoutPanelOnLocalCardRadius();
	}
	
	private void buildGroupLayoutPanelOnLocalCardRadius() {
		GroupLayout gl_panel_1 = new GroupLayout(m_panelOnLocalCardRadius);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_labelOnLocalCardRadius)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_textFieldOnLocalCardRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(162, Short.MAX_VALUE))
				.addComponent(m_separatorOnLocalCardBetweenAlphabetAndRadius, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(m_separatorOnLocalCardBetweenAlphabetAndRadius, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelOnLocalCardRadius)
						.addComponent(m_textFieldOnLocalCardRadius, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(17))
		);
	    m_panelOnLocalCardRadius.setLayout(gl_panel_1);
	}
	
	private void buildComponentPanelOnLocalCardLocalFunction() {
		m_panelOnLocalCardLocalFunction = new JPanel();
	    m_labelOnLocalCardLocalFunction = new JLabel("Local Function:");
	    
	    m_textFieldOnLocalCardLocalFunction = new JTextField();
	    m_textFieldOnLocalCardLocalFunction.setColumns(10);
	    
	    m_separatorOnLocalCardBetweenRadiusAndLocalFunction = new JSeparator();
	    
	    builGroupLayoutPanelOnLocalCardLocalFunction();
	}
	
	private void builGroupLayoutPanelOnLocalCardLocalFunction() {
		GroupLayout gl_panel_2 = new GroupLayout(m_panelOnLocalCardLocalFunction);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_labelOnLocalCardLocalFunction)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_textFieldOnLocalCardLocalFunction, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
				.addComponent(m_separatorOnLocalCardBetweenRadiusAndLocalFunction, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(m_separatorOnLocalCardBetweenRadiusAndLocalFunction, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_textFieldOnLocalCardLocalFunction, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(m_labelOnLocalCardLocalFunction))
					.addContainerGap(21, Short.MAX_VALUE))
		);
	    m_panelOnLocalCardLocalFunction.setLayout(gl_panel_2);	
	}
	
	private void buildGroupLayoutlocalCard() {
		GroupLayout gl_m_localcard = new GroupLayout(m_localCard);
		gl_m_localcard.setHorizontalGroup(
			gl_m_localcard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_m_localcard.createSequentialGroup()
					.addGroup(gl_m_localcard.createParallelGroup(Alignment.TRAILING)
						.addComponent(m_panelOnLocalCardLocalFunction, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_m_localcard.createParallelGroup(Alignment.LEADING, false)
							.addComponent(m_panelOnLocalCardAlphabet, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(m_panelOnLocalCardRadius, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_m_localcard.setVerticalGroup(
			gl_m_localcard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_m_localcard.createSequentialGroup()
					.addComponent(m_panelOnLocalCardAlphabet, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_panelOnLocalCardRadius, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(m_panelOnLocalCardLocalFunction, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
		);
	    m_localCard.setLayout(gl_m_localcard);
	}
	
	private void buildGlobalCard() {
		buildComponentGlobalCardAlphabet();
		
		buildComponentGlobalCardGlobalFunction();
	    
		buildGroupLayoutGlobalCard();//Set the layout of panel m_localCard
	}
	
	private void buildComponentGlobalCardAlphabet(){
		m_panelOnGlobalCardAlphabet = new JPanel();
		
		m_labelOnGlobalCardAlphabet = new JLabel("Alphabet (0 to ?):");
		   
		m_textFieldOnGlobalCardAlphabet = new JTextField();
		m_textFieldOnGlobalCardAlphabet.setColumns(10);
		
		m_separatorOnGlobalCardBetweenRadiosButtonAndAlphabet = new JSeparator();
		   
		buildGroupLayoutPanelOnGlobalCardAlphabet();
	}
	
	private void buildGroupLayoutPanelOnGlobalCardAlphabet() {
		GroupLayout gl_panel = new GroupLayout(m_panelOnGlobalCardAlphabet);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(m_labelOnGlobalCardAlphabet)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(m_textFieldOnGlobalCardAlphabet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(m_separatorOnGlobalCardBetweenRadiosButtonAndAlphabet, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(m_separatorOnGlobalCardBetweenRadiosButtonAndAlphabet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelOnGlobalCardAlphabet)
						.addComponent(m_textFieldOnGlobalCardAlphabet, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		   m_panelOnGlobalCardAlphabet.setLayout(gl_panel);
	}
	
	private void buildComponentGlobalCardGlobalFunction(){
		m_panelOnGlobalCardGlobalFunction = new JPanel();
		
		m_labelOnGlobalCardGlobalFunction = new JLabel("Global Function:");
		
		m_textFieldOnGlobalCardGlobalFunction = new JTextField();
		m_textFieldOnGlobalCardGlobalFunction.setColumns(10);
		
		m_separatorOnGlobalCardBetweenAlphabetAndGlobalFunction = new JSeparator();
		
		buildGroupLayoutGlobalCardGlobalFunction();
	}
	
	private void buildGroupLayoutGlobalCardGlobalFunction() {
		GroupLayout gl_panel = new GroupLayout(m_panelOnGlobalCardGlobalFunction);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_labelOnGlobalCardGlobalFunction, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_textFieldOnGlobalCardGlobalFunction, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(m_separatorOnGlobalCardBetweenAlphabetAndGlobalFunction, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(m_separatorOnGlobalCardBetweenAlphabetAndGlobalFunction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelOnGlobalCardGlobalFunction)
						.addComponent(m_textFieldOnGlobalCardGlobalFunction, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		   m_panelOnGlobalCardGlobalFunction.setLayout(gl_panel);
	}
	
	
	private void buildGroupLayoutGlobalCard() {
		   GroupLayout gl_m_globalcard = new GroupLayout(m_globalcard);
		   gl_m_globalcard.setHorizontalGroup(
		   	gl_m_globalcard.createParallelGroup(Alignment.TRAILING)
		   		.addGroup(Alignment.LEADING, gl_m_globalcard.createSequentialGroup()
		   			.addGroup(gl_m_globalcard.createParallelGroup(Alignment.TRAILING, false)
		   				.addComponent(m_panelOnGlobalCardGlobalFunction, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		   				.addComponent(m_panelOnGlobalCardAlphabet, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
		   			.addContainerGap(10, Short.MAX_VALUE))
		   );
		   gl_m_globalcard.setVerticalGroup(
		   	gl_m_globalcard.createParallelGroup(Alignment.LEADING)
		   		.addGroup(gl_m_globalcard.createSequentialGroup()
		   			.addComponent(m_panelOnGlobalCardAlphabet, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
		   			.addPreferredGap(ComponentPlacement.RELATED)
		   			.addComponent(m_panelOnGlobalCardGlobalFunction, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
		   );
		    m_globalcard.setLayout(gl_m_globalcard);
	}
}