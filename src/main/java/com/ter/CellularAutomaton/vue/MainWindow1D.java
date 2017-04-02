package com.ter.CellularAutomaton.vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.ter.CellularAutomaton.controller.CellularAutomatonSetting1DEvent;
import com.ter.CellularAutomaton.controller.Close1DEvent;
import com.ter.CellularAutomaton.controller.CloseAllEvent;
import com.ter.CellularAutomaton.controller.CreditsEvent;
import com.ter.CellularAutomaton.controller.New1DEvent;
import com.ter.CellularAutomaton.controller.OpenFileEvent;
import com.ter.CellularAutomaton.controller.PauseSimulation1DEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;
import com.ter.CellularAutomaton.controller.RefreshSimulation1DEvent;
import com.ter.CellularAutomaton.controller.StartSimulation1DEvent;
import com.ter.CellularAutomaton.controller.StopSimulation1DEvent;
import com.ter.CellularAutomaton.model.SimulationState;
import com.ter.CellularAutomaton.vue.IForm;
import com.ter.CellularAutomaton.controller.IInitializeSimulationRules1D;
import com.ter.CellularAutomaton.controller.InitializeSimulation1DOneCell;
import com.ter.CellularAutomaton.controller.InitializeSimulation1DRandomly;
import com.ter.CellularAutomaton.vue.InternalFrameSimulation1D;
import com.ter.CellularAutomaton.vue.RectangleForm;


// TODO: Auto-generated Javadoc
/**
 * The Class MainWindow1D.
 */
public class MainWindow1D extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/******ATTRIBUTES******/
	private JMenuBar m_menuBar = new JMenuBar();

	/** The menu file. */
	//Tab in MenuBar
	private JMenu m_menuFile = new JMenu("File");

	/** The menu edit. */
	private JMenu m_menuEdit = new JMenu("Edit");

	/** The menu run. */
	private JMenu m_menuRun = new JMenu("Run");

	/** The menu option. */
	private JMenu m_menuOption = new JMenu("Option");

	/** The menu view. */
	private JMenu m_menuView = new JMenu("View");

	/** The menu help. */
	private JMenu m_menuHelp = new JMenu("Help");

	/** The menu bar file item 1. */
	// In file menu
	private JMenuItem m_menuBarFileItem1 = new JMenuItem("New");

	/** The menu bar file item 2. */
	private JMenuItem m_menuBarFileItem2 = new JMenuItem("Open File");

	/** The menu bar file item 3. */
	private JMenuItem m_menuBarFileItem3 = new JMenuItem("Recent File");

	/** The menu bar file item 4. */
	private JMenuItem m_menuBarFileItem4 = new JMenuItem("Save");

	/** The menu bar file item 5. */
	private JMenuItem m_menuBarFileItem5 = new JMenuItem("Save As");

	/** The menu bar file item 6. */
	private JMenuItem m_menuBarFileItem6 = new JMenuItem("Print");

	/** The menu bar file item 7. */
	private JMenuItem m_menuBarFileItem7 = new JMenuItem("Close");

	/** The menu bar file item 8. */
	private JMenuItem m_menuBarFileItem8 = new JMenuItem("Close All");

	/** The menu bar file item 9. */
	private JMenuItem m_menuBarFileItem9 = new JMenuItem("Quit");

	/** The menu bar edit item 1. */
	// In edit menu
	private JMenuItem m_menuBarEditItem1 = new JMenuItem("Undo");

	/** The menu bar edit item 2. */
	private JMenuItem m_menuBarEditItem2 = new JMenuItem("Redo");

	/** The menu bar edit item 3. */
	private JMenuItem m_menuBarEditItem3 = new JMenuItem("Cut");

	/** The menu bar edit item 4. */
	private JMenuItem m_menuBarEditItem4 = new JMenuItem("Copy");

	/** The menu bar edit item 5. */
	private JMenuItem m_menuBarEditItem5 = new JMenuItem("Paste");

	/** The menu bar edit item 6. */
	private JMenuItem m_menuBarEditItem6 = new JMenuItem("Select all");

	/** The menu bar edit item 7. */
	private JMenuItem m_menuBarEditItem7 = new JMenuItem("Find");

	/** The menu bar edit item 8. */
	private JMenuItem m_menuBarEditItem8 = new JMenuItem("Find Next");

	/** The menu bar run item 1. */
	// In run menu
	private JMenuItem m_menuBarRunItem1 = new JMenuItem("Run Current Simulation");

	/** The menu bar run item 2. */
	private JMenu m_menuBarRunItem2 = new JMenu("Run Specific Screen");

	/** The menu bar run item 3. */
	private JMenuItem m_menuBarRunItem3 = new JMenuItem("Run External Simulation");

	/** The menu bar option item 1. */
	// In option menu
	private JMenuItem m_menuBarOptionItem1 = new JMenuItem("Bookmarks");

	/** The menu bar option item 2. */
	private JMenuItem m_menuBarOptionItem2 = new JMenuItem("Setting By Default");

	/** The menu bar view item 1. */
	// In view menu
	private JMenuItem m_menuBarViewItem1 = new JMenuItem("View By Default");

	/** The menu bar view item 2. */
	private JMenu m_menuBarViewItem2 = new JMenu("Split Screen By");

	/** The menu bar view item 3. */
	private JCheckBoxMenuItem m_menuBarViewItem3 = new StayOpenCheckBoxMenuItem("Show Toolbars");

	/** The menu bar view item 4. */
	private JMenuItem m_menuBarViewItem4 = new JMenuItem("Customize View");

	/** The menu bar help item 1. */
	// In help menu
	private JMenuItem m_menuBarHelpItem1 = new JMenuItem("Help Contents");

	/** The menu bar help item 2. */
	private JMenuItem m_menuBarHelpItem2 = new JMenuItem("Credits");

	/** The run item 2 choice 1. */
	// In tab run
	private JCheckBoxMenuItem  m_runItem2Choice1 = new StayOpenCheckBoxMenuItem ("All");

	/** The run item 2 choice 2. */
	private JMenu  m_runItem2Choice2 = new JMenu ("Custom");

	/** The custom item choice 1. */
	// In tab custom in tab run
	private JCheckBoxMenuItem  m_customItemChoice1 = new StayOpenCheckBoxMenuItem ("1");

	/** The custom item choice 2. */
	private JCheckBoxMenuItem  m_customItemChoice2 = new StayOpenCheckBoxMenuItem ("2");

	/** The custom item choice 3. */
	private JCheckBoxMenuItem  m_customItemChoice3 = new StayOpenCheckBoxMenuItem ("3");

	/** The custom item choice 4. */
	private JCheckBoxMenuItem  m_customItemChoice4 = new StayOpenCheckBoxMenuItem ("4");

	/** The view item 2 choice 1. */
	// In tab view
	private JRadioButtonMenuItem  m_viewItem2Choice1 = new StayOpenRadioButtonMenuItem ("None");

	/** The view item 2 choice 2. */
	private JRadioButtonMenuItem  m_viewItem2Choice2 = new StayOpenRadioButtonMenuItem ("2");

	/** The view item 2 choice 3. */
	private JRadioButtonMenuItem  m_viewItem2Choice3 = new StayOpenRadioButtonMenuItem ("4");
	
	/** Graphic Component */
	private JPanel m_mainPanel;
	private JPanel m_panelTopTools;
	private JToolBar m_mainToolBar;
	private JToolBar m_toolBarTypeCellularAutomaton;
	private JPanel m_panelTypeCellularAutomaton;
	private JSeparator m_separatorInTypeCellularAutomaton;
	private JPanel m_panelChooseCellularAutomaton;
	private JPanel m_panelUniform;
	private GroupLayout m_GroupLayoutPanelTypeCellularAutomaton;
	private JComboBox m_comboBoxUniform;
	private JButton m_buttonCellularAutomatonSetting;
	private JToolBar m_toolBarSimulationTools;
	private JPanel m_panelSimulationTools;
	private JButton m_buttonLauncher;
	private JButton m_buttonPause;
	private JButton m_buttonStop;
	private JButton m_buttonUndo;
	private JButton m_buttonRedo;
	private JButton m_buttonReload;
	private JToolBar m_toolBarControlTools;
	private JPanel m_panelControlTools;
	private JPanel m_panelBorderCondition;
	private JPanel m_panelDirectionOfEvolution;
	private JButton m_buttonDirectionOfEvolution;
	private JButton m_buttonBorderCondition;
	private JSeparator m_separatorInControlTools;
	private JDesktopPane m_mainDesktopPane;
	private JPanel m_panelLateralTools;
	private GroupLayout m_GroupLayoutPanelLateralTools;
	private JPanel m_panelAlgorithm;
	private GroupLayout m_GroupLayoutPanelAlgorithm;
	private JComboBox m_comboBoxAlgorithm;
	private JPanel m_panelInitialPositionCells;
	private GroupLayout m_GroupLayoutPanelInitialPositionCells;
	private JComboBox m_comboBoxInitialPositionCells;
	private JPanel m_panelFormCells;
	private GroupLayout m_GroupLayoutPanelFormCells;
	private JComboBox comboBoxFormCells;
	private JPanel m_panelColorCells;
	private JButton m_buttonColorCells;
	private JPanel m_panelBackgroundColor;
	private GroupLayout m_GroupLayoutPanelBackgroundColor;
	private JComboBox m_comboBoxBackgroundColor;
	private InternalFrameSimulation1D m_internalFrameSimulation;
	
	private SimulationState m_simulationState;

	/**
	 * ****CONSTRUCTOR*****.
	 */
	public MainWindow1D (){

		//Set the window
		this.setWindow();

		//Set mnemonic of the MenuBar
		this.initMenuMnemonic();

		//We initialize our menuBar 
		this.initMenuBar();

		//add listeners MenuBar
		this.addListenerMenuBar();
		
		//Build the component of the window
		this.buildComponentWindow();
		
		//add listeners TypeCellularAutomatonTools
		addListenerTypeCellularAutomatonTools();
		
		//add listeners SimulationTools
		addListenerSimulationTools();
		
		//add listeners ControlTools
		addListenerControlTools();

		//Set the window visible
		this.setVisible(true);
		
		m_simulationState = SimulationState.STOP;
	}


	
	/******GETTERS******/
	public InternalFrameSimulation1D getm_internalFrameSimulation() {
		return m_internalFrameSimulation;
	}
	
	public JButton getm_sliderSpeedSimulation() {
		return m_buttonBorderCondition;
	}
	
	/******SETTERS******/	
	public void setm_internalFrameSimulation(InternalFrameSimulation1D internalFrame) {
		this.m_internalFrameSimulation = internalFrame;
	}
	
	public void setm_simulationState(SimulationState m_simulationState) {
		this.m_simulationState = m_simulationState;
	}
	

	/**
	 * ****CLASS METHODS*****.
	 */

	/***Set the window***/
	private void setWindow(){
		this.setWindow("Cellular Automaton", 1370, 730, true, false);
	}


	/**
	 * *Set the window**.
	 *
	 * @param title the title
	 * @param width the width
	 * @param height the height
	 * @param isResisable the is resisable
	 * @param isAlwayOnTop the is alway on top
	 */
	private void setWindow(String title, int width, int height, boolean isResisable, boolean isAlwayOnTop){
		this.setTitle(title);//Define a title to the window    
		this.setSize(width,height);//Initial size of the window
		this.setLocationRelativeTo(null);//We now ask our window to position itself at the center.
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Complete the process when clicking on the red cross
		this.setResizable(isResisable);//Prevents resizing
		this.setAlwaysOnTop(isAlwayOnTop);//The windows will not be always on top
		try {
			this.setIconImage(ImageIO.read(new File("Files/Images/Favicon/PenroseColor2.png")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
	}

	/**
	 * Inits the menu mnemonic.
	 */
	private void initMenuMnemonic(){
		//add all the mnémonic for the MenuBar
		m_menuFile.setMnemonic('F');
		m_menuEdit.setMnemonic('E');
		m_menuRun.setMnemonic('R');
		m_menuOption.setMnemonic('O');
		m_menuView.setMnemonic('V');
		m_menuHelp.setMnemonic('H');
	}


	/**
	 * Inits the menu bar.
	 */
	private void initMenuBar(){
		//We initialize our menuBar 

		this.constructTabFileMenuBar();//Construction of the tab "File" of menuBar


		this.constructTabEditMenuBar();//Construction of the tab "Edit" of menuBar


		this.constructTabRunMenuBar();//Construction of the tab "Run" of menuBar



		this.constructTabOptionMenuBar();//Construction of the tab "Option" of menuBar


		this.constructTabViewMenuBar();//Construction of the tab "View" of menuBar


		this.constructTabHelpMenuBar();//Construction of the tab "Help" of menuBar

		this.setJMenuBar(m_menuBar);//the MenuBar tab is added to Window

		this.initAcceleratorMenuBar();//Adding all Accelerator of the MenuBar

	}

	/**
	 * Construct tab file menu bar.
	 */
	private void constructTabFileMenuBar(){
		//Construction of the tab "File" of menuBar
		this.m_menuFile.add(m_menuBarFileItem1);//Adding a tab "New" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItem2);//Adding a tab "Open File" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItem3);//Adding a tab "Recent File" in tab File in MenuBar
		this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuFile.add(m_menuBarFileItem4);//Adding a tab "Save" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItem5);//Adding a tab "Save As" in tab File in MenuBar
		this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuFile.add(m_menuBarFileItem6);//Adding a tab "Print" in tab File in MenuBar
		this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuFile.add(m_menuBarFileItem7);//Adding a tab "Close" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItem8);//Adding a tab "Close All" in tab File in MenuBar
		this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuFile.add(m_menuBarFileItem9);//Adding a tab "Quit" in tab File in MenuBar
		this.m_menuBar.add(m_menuFile);//the File tab is added to MenuBar

	}

	/**
	 * Construct tab edit menu bar.
	 */
	private void constructTabEditMenuBar(){
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

	}

	/**
	 * Construct tab run menu bar.
	 */
	private void constructTabRunMenuBar(){
		//Construction of the tab "Run" of menuBar
		this.constructSubTabCustomInTabRunSpecificScreen();//Sub-group of tab "Custom" in tab "Run Specific Screen" in tab run
		this.constructSubTabRunSpecificScreenInTabRun();//Sub-group of tab "Run Specific Screen" in tab run

		this.m_menuRun.add(m_menuBarRunItem1);//Adding a tab "Run Current Simulation" in MenuBar
		this.m_menuRun.add(m_menuBarRunItem2);//Adding a tab "Run Specific Screen" in MenuBar
		this.m_menuRun.addSeparator();//Adding a separator in tab Run of the MenuBar
		this.m_menuRun.add(m_menuBarRunItem3);//Adding a tab "Run External Simulation" in MenuBar
		this.m_menuBar.add(m_menuRun);//the Run tab is added to MenuBar
	}

	/**
	 * Construct sub tab custom in tab run specific screen.
	 */
	private void constructSubTabCustomInTabRunSpecificScreen(){
		//Sub-group of tab "Custom" in tab "Run Specific Screen" in tab run
		this.m_runItem2Choice2.add(m_customItemChoice1);//Adding a tab "1" in tab "Custom"
		this.m_runItem2Choice2.add(m_customItemChoice2);//Adding a tab "2" in tab "Custom"
		this.m_runItem2Choice2.add(m_customItemChoice3);//Adding a tab "3" in tab "Custom"
		this.m_runItem2Choice2.add(m_customItemChoice4);//Adding a tab "4" in tab "Custom"
		this.m_customItemChoice1.setSelected(true);//Set "1" CheckBox to true by default 

	}

	/**
	 * Construct sub tab run specific screen in tab run.
	 */
	private void constructSubTabRunSpecificScreenInTabRun(){
		//Sub-group of tab "Run Specific Screen" in tab run
		this.m_menuBarRunItem2.add(m_runItem2Choice1);//Adding a CheckBox "All" in tab "Run Specific Screen"
		this.m_runItem2Choice1.setSelected(true);//Set a CheckBox "All" to true by default
		this.m_menuBarRunItem2.addSeparator();//Adding a separator in tab "Run Specific Screen" in tab "Run"
		this.m_menuBarRunItem2.add(m_runItem2Choice2);//Adding a tab "Custom" in tab "Run Specific Screen"

	}

	/**
	 * Construct tab option menu bar.
	 */
	private void constructTabOptionMenuBar(){
		//Construction of the tab "Option" of menuBar
		this.m_menuOption.add(m_menuBarOptionItem1);//Adding a tab "Bookmarks" in MenuBar
		this.m_menuOption.addSeparator();//Adding a separator in tab Option of the MenuBar
		this.m_menuOption.add(m_menuBarOptionItem2);//Adding a tab "Setting By Default" in MenuBar
		this.m_menuBar.add(m_menuOption);//the Option tab is added to MenuBar

	}

	/**
	 * Construct tab view menu bar.
	 */
	private void constructTabViewMenuBar(){
		this.constructSubTabSplitScreenByInTabView();//Sub-group of tab "Split Screen By" in tab view

		//Tab view
		this.m_menuView.add(m_menuBarViewItem1);//Adding a tab "View By Default" in MenuBar
		this.m_menuView.add(m_menuBarViewItem2);//Adding a tab "Split Screen By" in MenuBar
		this.m_menuView.addSeparator();//Adding a separator in tab View of the MenuBar
		this.m_menuView.add(m_menuBarViewItem3);//Adding a checkBox tab "Show Toolbars" in MenuBar
		this.m_menuBarViewItem3.setSelected(true);//Set "Show Toolbars" checkBox to true by default
		this.m_menuView.addSeparator();//Adding a separator in tab View of the MenuBar
		this.m_menuView.add(m_menuBarViewItem4);//Adding a tab "Customize View" in MenuBar
		this.m_menuBar.add(m_menuView);//the View tab is added to MenuBar

	}


	/**
	 * Construct sub tab split screen by in tab view.
	 */
	private void constructSubTabSplitScreenByInTabView(){
		//Sub-group of tab "Split Screen By" in tab view
		ButtonGroup viewItem2ButtonGroup = new ButtonGroup();//Adding ButtonGroup
		viewItem2ButtonGroup.add(m_viewItem2Choice1);//Adding radio button "None" in ButtonGroup
		viewItem2ButtonGroup.add(m_viewItem2Choice2);//Adding radio button "2" in ButtonGroup
		viewItem2ButtonGroup.add(m_viewItem2Choice3);//Adding radio button "4" in ButtonGroup
		this.m_viewItem2Choice1.setSelected(true);//Set "None" radio button to true by default 
		this.m_menuBarViewItem2.add(m_viewItem2Choice1);//Adding a tab "None" in tab "Split Screen By"
		this.m_menuBarViewItem2.add(m_viewItem2Choice2);//Adding a tab "2" in tab "Split Screen By"
		this.m_menuBarViewItem2.add(m_viewItem2Choice3);//Adding a tab "4" in tab "Split Screen By"

	}


	/**
	 * Construct tab help menu bar.
	 */
	private void constructTabHelpMenuBar(){
		//Construction of the tab "Help" of menuBar
		this.m_menuHelp.add(m_menuBarHelpItem1);//Adding a tab "Help Contents" in MenuBar
		this.m_menuHelp.addSeparator();//Adding a separator in tab Help of the MenuBar
		this.m_menuHelp.add(m_menuBarHelpItem2);//Adding a tab "Credits" in MenuBar
		this.m_menuBar.add(m_menuHelp);//the Help tab is added to MenuBar

	}

	/**
	 * *Init the accelerators**.
	 */
	private void initAcceleratorMenuBar(){
		//add all the accelerators for the items
		this.initAcceleratorFile(); //accelerator of tab File
		this.initAcceleratorHelp();//accelerator of tab Help
	}

	private void initAcceleratorFile(){
		//add all the accelerators for the items of tab File
		m_menuBarFileItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK)); //add accelerators of New in tab File
		m_menuBarFileItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK)); //add accelerators of Open File in tab File
		m_menuBarFileItem7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK)); //add accelerators of Close in tab File
		m_menuBarFileItem8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of CloseAll in tab File
		m_menuBarFileItem9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK)); //add accelerators of Quit in tab File
	}

	private void initAcceleratorHelp(){
		//add all the accelerators for the items of tab Help
		m_menuBarHelpItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of Quit in tab File
	}



	/***Listeners MenuBar***/

	private void addListenerMenuBar (){
		this.addListenerFile(); //add listener of tab File
		this.addListenerHelp(); //add listener of tab Help
	}

	private void addListenerFile (){
		m_menuBarFileItem1.addActionListener(new New1DEvent());
		m_menuBarFileItem2.addActionListener(new OpenFileEvent());
		m_menuBarFileItem7.addActionListener(new Close1DEvent(this));
		m_menuBarFileItem8.addActionListener(new CloseAllEvent());
		m_menuBarFileItem9.addActionListener(new QuitEvent());
	}

	private void addListenerHelp (){
		m_menuBarHelpItem2.addActionListener(new CreditsEvent());
	}
	
	/******Build Windows******/
	
	public void buildComponentWindow(){
		m_mainPanel = new JPanel();
		this.getContentPane().add(m_mainPanel, BorderLayout.CENTER);
		m_mainPanel.setLayout(new BorderLayout(0, 0));
		
		m_mainToolBar = new JToolBar();
		m_mainPanel.add(m_mainToolBar, BorderLayout.NORTH);
		
		m_panelTopTools = new JPanel();
		m_mainToolBar.add(m_panelTopTools);
		m_panelTopTools.setLayout(new GridLayout(1, 3, 0, 0));
		
		buildTypeCellularAutomaton();//Build the ToolBar of TypeCellularAutomaton
		
		buildSimulationTools();//Build the ToolBar of SimulationTools
		
		buildControlTools();//Build the ToolBar of ControlTools
		
		buildDesktopPane();//Build the DestopPane of window
		
		buildInternalFrameSimulation();//Build the InternalFrame witch contain the simulation
		
		buildLateralTools();//Build the panel of LateralTools
		
	}
	
	public void buildTypeCellularAutomaton(){
		buildToolBarTypeCellularAutomaton();//Build the toolBar of TypeCellularAutomaton
	}
	
	public void buildToolBarTypeCellularAutomaton(){
		m_toolBarTypeCellularAutomaton = new JToolBar();//Creation of toolBar TypeCellularAutomaton
		m_panelTopTools.add(m_toolBarTypeCellularAutomaton);//Add the toolBar to panel of the mainToolBar
		
		buildPanelTypeCellularAutomaton();//Build the panel of the toolBar TypeCellularAutomaton
	}
	
	public void buildPanelTypeCellularAutomaton(){
		m_panelTypeCellularAutomaton = new JPanel();
		m_toolBarTypeCellularAutomaton.add(m_panelTypeCellularAutomaton);
		m_panelTypeCellularAutomaton.setBorder(BorderFactory.createTitledBorder("Type of Cellular Automaton"));
		
		buildSeparatorInTypeCellularAutomaton();//Build the separator of the toolBar TypeCellularAutomaton
		
		buildPanelChooseCellularAutomaton();//Build the panel ChooseCellularAutomaton
		
		buildPanelUniform();//Build the panel Uniform
		
		buildGroupLayoutPanelTypeCellularAutomaton();//Build the GroupLayout of the panel TypeCellularAutomaton
	}
	
	public void buildSeparatorInTypeCellularAutomaton(){
		//Build the separator of the toolBar TypeCellularAutomaton
		m_separatorInTypeCellularAutomaton = new JSeparator();
		m_separatorInTypeCellularAutomaton.setOrientation(SwingConstants.VERTICAL);
	}
	
	public void buildPanelChooseCellularAutomaton(){
		//Build the panel ChooseCellularAutomaton
		m_panelChooseCellularAutomaton = new JPanel();
		m_panelChooseCellularAutomaton.setBorder(BorderFactory.createTitledBorder("Cellular Automaton"));
		m_panelChooseCellularAutomaton.setLayout(new BorderLayout(0, 0));
		
		buildComponentChooseCellularAutomaton();//Build the component of the panel ChooseCellularAutomaton
	}
	
	public void buildComponentChooseCellularAutomaton(){
		//Build the component of the panel ChooseCellularAutomaton
		m_buttonCellularAutomatonSetting = new JButton("Cellular Automaton Setting");
		m_panelChooseCellularAutomaton.add(m_buttonCellularAutomatonSetting, BorderLayout.CENTER);
	}
	
	public void buildPanelUniform(){
		//Build the panel Uniform
		m_panelUniform = new JPanel();
		m_panelUniform.setBorder(BorderFactory.createTitledBorder("Uniform / Non-Uniform"));
		m_panelUniform.setLayout(new BorderLayout(0, 0));
		
		buildComponentUniform();//Build the component of the panel Uniform
	}
	
	public void buildComponentUniform(){
		//Build the component of the panel Uniform
		m_comboBoxUniform = new JComboBox();
		m_panelUniform.add(m_comboBoxUniform, BorderLayout.CENTER);
	}
	
	public void buildGroupLayoutPanelTypeCellularAutomaton(){
		m_GroupLayoutPanelTypeCellularAutomaton = new GroupLayout(m_panelTypeCellularAutomaton);
		m_GroupLayoutPanelTypeCellularAutomaton.setHorizontalGroup(
			m_GroupLayoutPanelTypeCellularAutomaton.createParallelGroup(Alignment.LEADING)
				.addGroup(m_GroupLayoutPanelTypeCellularAutomaton.createSequentialGroup()
					.addComponent(m_panelChooseCellularAutomaton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_separatorInTypeCellularAutomaton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_panelUniform, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
		);
		m_GroupLayoutPanelTypeCellularAutomaton.setVerticalGroup(
			m_GroupLayoutPanelTypeCellularAutomaton.createParallelGroup(Alignment.TRAILING)
				.addComponent(m_separatorInTypeCellularAutomaton, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
				.addComponent(m_panelChooseCellularAutomaton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
				.addComponent(m_panelUniform, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
		);
		m_panelTypeCellularAutomaton.setLayout(m_GroupLayoutPanelTypeCellularAutomaton);
	}
	
	
	
	public void buildSimulationTools(){
		buildSimulationTools("Files/Images/Simulation_Tools/");
	}
	
	public void buildSimulationTools(String pathDirectory){
		m_toolBarSimulationTools = new JToolBar();
		m_panelTopTools.add(m_toolBarSimulationTools);
		
		m_panelSimulationTools = new JPanel();
		m_toolBarSimulationTools.add(m_panelSimulationTools);
		m_panelSimulationTools.setBorder(BorderFactory.createTitledBorder("Simulation Tools"));
		
		m_buttonLauncher = new JButton(new ImageIcon(pathDirectory+"button_laucher.png"));
		
		m_buttonPause = new JButton(new ImageIcon(pathDirectory+"button_pause.png"));
		
		m_buttonStop = new JButton(new ImageIcon(pathDirectory+"button_stop.png"));
		
		m_buttonUndo = new JButton(new ImageIcon(pathDirectory+"button_undo.png"));
		
		m_buttonRedo = new JButton(new ImageIcon(pathDirectory+"button_redo.png"));
		
		m_buttonReload = new JButton(new ImageIcon(pathDirectory+"button_reload.png"));
		
		m_panelSimulationTools.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		m_panelSimulationTools.add(m_buttonLauncher);
		m_panelSimulationTools.add(m_buttonPause);
		m_panelSimulationTools.add(m_buttonStop);
		m_panelSimulationTools.add(m_buttonUndo);
		m_panelSimulationTools.add(m_buttonRedo);
		m_panelSimulationTools.add(m_buttonReload);
	}
	
	
	
	public void buildControlTools(){
		buildToolBarControlTools();//Build the ToolBar of ControlTools
	}
	
	
	public void buildToolBarControlTools(){
		m_toolBarControlTools = new JToolBar();//Creation of toolBar
		m_panelTopTools.add(m_toolBarControlTools);//Add the toolBar to panel of the mainToolBar
		
		buildPanelControlTools();//Build the panel in the ToolBar ControlTools
	}
	
	
	public void buildPanelControlTools(){
		m_panelControlTools = new JPanel();//Creation of panel
		m_toolBarControlTools.add(m_panelControlTools);//Add the panel to toolBar ControlTools
		m_panelControlTools.setBorder(BorderFactory.createTitledBorder("Control tools"));//Set a border of JPanel
		m_panelControlTools.setLayout(null);
		
		buildPanelBorderCondition();//Set the panel BorderCondition
		buildPanelDirectionOfEvolution();//Set the panel DirectionOfEvolution
		
		m_panelControlTools.add(m_panelBorderCondition);//Add the panel of "BorderCondition" to panel of "ControlTools"
		m_panelControlTools.add(m_panelDirectionOfEvolution);//Add the panel of "DirectionOfEvolution" to panel of "ControlTools"
		
		buildSeparatorInControlTools();//Build the separator in ControlTools
	}
	
	
	public void buildPanelBorderCondition(){
		m_panelBorderCondition = new JPanel();//Creation of panel for BorderCondition
		m_panelBorderCondition.setBounds(6, 16, 190, 50);//Set size of JPanel
		m_panelBorderCondition.setBorder(BorderFactory.createTitledBorder("Border Condition"));//Set a border of JPanel
		
		buildComponentBorderCondition();//Set the component of Panel "BorderCondition"
	}
	
	public void buildComponentBorderCondition(){ 
		m_panelBorderCondition.setLayout(new BorderLayout(0, 0));
		m_buttonBorderCondition = new JButton("Border Condition Setting");//Creation of Button for panel "BorderCondition"
		m_panelBorderCondition.add(m_buttonBorderCondition, BorderLayout.CENTER);//Add the Button to panel BorderCondition
	}
	
	
	
	public void buildPanelDirectionOfEvolution(){
		m_panelDirectionOfEvolution = new JPanel();//Creation of JPanel for DirectionOfEvolution
		m_panelDirectionOfEvolution.setBounds(207, 16, 210, 50);//Set size of JPanel
		m_panelDirectionOfEvolution.setBorder(BorderFactory.createTitledBorder("Direction of Evolution"));//Set a border of JPanel
		
		buildComponentDirectionOfEvolution();//Set the component of Panel "DirectionOfEvolution"
	}
	
	public void buildComponentDirectionOfEvolution(){
		m_panelDirectionOfEvolution.setLayout(new BorderLayout(0, 0));//The component take full place of panel
		m_buttonDirectionOfEvolution = new JButton("Direction of Evolution Setting");//Creation of Button for panel "Direction of evolution"
		m_panelDirectionOfEvolution.add(m_buttonDirectionOfEvolution);//Add the radioButton m_radioButtonContinuous to panel m_panelSimulationMode
	}

	
	public void buildSeparatorInControlTools(){
		//Creation of Separator between the panel of "BorderCondition" and the panel "DirectionOfEvolution"
		m_separatorInControlTools = new JSeparator();//Create JSeparator
		m_separatorInControlTools.setOrientation(SwingConstants.VERTICAL);//Set the orientation of separator to vertical
		m_separatorInControlTools.setBounds(194, 23, 2, 43);//Set the position and size of separator
		m_panelControlTools.add(m_separatorInControlTools);//Add the separator to panel m_panelControlTools
	}
	
	
	public void buildDesktopPane(){
		m_mainDesktopPane = new JDesktopPane();
		m_mainPanel.add(m_mainDesktopPane, BorderLayout.CENTER);
	}
	
	
	public void buildInternalFrameSimulation(){
		IForm formOfCells = new RectangleForm();
		Color colorOfCells = Color.BLUE;
		Color backgroundColor = Color.BLACK;
		IInitializeSimulationRules1D initializeSimulationRule = new InitializeSimulation1DOneCell();
		buildInternalFrameSimulation(formOfCells, colorOfCells, backgroundColor, initializeSimulationRule);
	}
	
	public void buildInternalFrameSimulation(IForm formOfCells, Color colorOfCells, Color backgroundColor, IInitializeSimulationRules1D initializeSimulationRule){
		m_internalFrameSimulation = new InternalFrameSimulation1D("Simulation", formOfCells, colorOfCells, backgroundColor, initializeSimulationRule);
		m_internalFrameSimulation.setBounds(53, 11, 900, 530);
		m_internalFrameSimulation.setVisible(true);
		m_mainDesktopPane.setLayout(null);
		m_mainDesktopPane.add(m_internalFrameSimulation);
	}
	
	
	public void buildLateralTools(){
		buildPanelLateralTools();//Build the panel "Lateral Tools"
	}
	
	
	public void buildPanelLateralTools(){
		m_panelLateralTools = new JPanel();//Create a JPanel for the "Lateral Tools"
		m_mainPanel.add(m_panelLateralTools, BorderLayout.EAST);//Add the panel m_panelLateralTools to panel m_mainPanel
		
		buildPanelAlgorithm();//Create the panel "Algorithm"
		
		buildPanelInitialPositionCells();//Create the panel "InitialPositionCells"
		
		buildPanelFormCells();//Create the panel "FormCells"
		
		buildPanelColorCells();//Create the panel "ColorCells"
		
		buildPanelBackgroundColor();//Create the panel "BackgroundColor"
		
		buildGroupLayoutPanelLateralTools();//Create the GroupLayout for the disposition of the panel "Lateral Tools"
	}
	
	
	public void buildPanelAlgorithm(){
		m_panelAlgorithm = new JPanel();//Create the panel Algorithm
		m_panelAlgorithm.setBorder(BorderFactory.createTitledBorder("Algorithm"));//Set a border for the panel Algorithm
		
		buildComponentLateralToolsAlgorithm();//Create components of panel Algorithm in the LateralTools
	}
	
	
	public void buildPanelInitialPositionCells(){
		m_panelInitialPositionCells = new JPanel();//Create the panel InitialPositionCells
		m_panelInitialPositionCells.setBorder(BorderFactory.createTitledBorder("Initial Position of Cells"));//Set a border for the panel InitialPositionCells
		
		buildComponentLateralToolsInitialPositionCells();//Create components of panel InitialPositionCells in the LateralTools
	}
	
	public void buildPanelFormCells(){
		m_panelFormCells = new JPanel();//Create the panel FormCells
		m_panelFormCells.setBorder(BorderFactory.createTitledBorder("Form of Cells"));//Set a border for the panel FormCells
		
		buildComponentLateralToolsFormCells();//Create components of panel FormCells in the LateralTools
	}
	
	public void buildPanelColorCells(){
		m_panelColorCells = new JPanel();//Create the panel ColorCells
		m_panelColorCells.setBorder(BorderFactory.createTitledBorder("Color of Cells"));//Set a border for the panel ColorCells
		
		buildComponentLateralToolsColorCells();//Create components of panel ColorCells in the LateralTools
	}
	
	public void buildPanelBackgroundColor(){
		m_panelBackgroundColor = new JPanel();//Create the panel BackgroundColor
		m_panelBackgroundColor.setBorder(BorderFactory.createTitledBorder("Background Color"));//Set a border for the panel BackgroundColor
		
		buildComponentLateralToolsBackgroundColor();//Create components of panel BackgroundColor in the LateralTools
	}
	
	public void buildComponentLateralToolsAlgorithm(){
		m_comboBoxAlgorithm = new JComboBox();
		m_GroupLayoutPanelAlgorithm = new GroupLayout(m_panelAlgorithm);
		
		buildGroupLayoutComponentAlgorithm();//Build the grouplayout for the component Algorithm
	}
	
	public void buildGroupLayoutComponentAlgorithm(){
		m_GroupLayoutPanelAlgorithm.setHorizontalGroup(
				m_GroupLayoutPanelAlgorithm.createParallelGroup(Alignment.LEADING)
					.addGroup(m_GroupLayoutPanelAlgorithm.createSequentialGroup()
						.addContainerGap()
						.addComponent(m_comboBoxAlgorithm, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			m_GroupLayoutPanelAlgorithm.setVerticalGroup(
				m_GroupLayoutPanelAlgorithm.createParallelGroup(Alignment.LEADING)
					.addGroup(m_GroupLayoutPanelAlgorithm.createSequentialGroup()
						.addContainerGap()
						.addComponent(m_comboBoxAlgorithm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE))
			);
			m_panelAlgorithm.setLayout(m_GroupLayoutPanelAlgorithm);
	}
	
	public void buildComponentLateralToolsInitialPositionCells(){
		m_comboBoxInitialPositionCells = new JComboBox();
		m_GroupLayoutPanelInitialPositionCells = new GroupLayout(m_panelInitialPositionCells);
		
		buildGroupLayoutComponentInitialPositionCells();
	}
	
	public void buildGroupLayoutComponentInitialPositionCells(){
		m_GroupLayoutPanelInitialPositionCells.setHorizontalGroup(
				m_GroupLayoutPanelInitialPositionCells.createParallelGroup(Alignment.LEADING)
					.addGap(0, 158, Short.MAX_VALUE)
					.addGroup(m_GroupLayoutPanelInitialPositionCells.createSequentialGroup()
						.addContainerGap()
						.addComponent(m_comboBoxInitialPositionCells, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			m_GroupLayoutPanelInitialPositionCells.setVerticalGroup(
				m_GroupLayoutPanelInitialPositionCells.createParallelGroup(Alignment.LEADING)
					.addGap(0, 71, Short.MAX_VALUE)
					.addGroup(m_GroupLayoutPanelInitialPositionCells.createSequentialGroup()
						.addContainerGap()
						.addComponent(m_comboBoxInitialPositionCells, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE))
			);
			m_panelInitialPositionCells.setLayout(m_GroupLayoutPanelInitialPositionCells);
	}
	
	
	public void buildComponentLateralToolsFormCells(){
		comboBoxFormCells = new JComboBox();
		m_GroupLayoutPanelFormCells = new GroupLayout(m_panelFormCells);
		
		buildGroupLayoutComponentFormCells();
	}
	
	public void buildGroupLayoutComponentFormCells(){
		m_GroupLayoutPanelFormCells.setHorizontalGroup(
				m_GroupLayoutPanelFormCells.createParallelGroup(Alignment.LEADING)
					.addGap(0, 158, Short.MAX_VALUE)
					.addGroup(m_GroupLayoutPanelFormCells.createSequentialGroup()
						.addContainerGap()
						.addComponent(comboBoxFormCells, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			m_GroupLayoutPanelFormCells.setVerticalGroup(
				m_GroupLayoutPanelFormCells.createParallelGroup(Alignment.LEADING)
					.addGap(0, 71, Short.MAX_VALUE)
					.addGroup(m_GroupLayoutPanelFormCells.createSequentialGroup()
						.addContainerGap()
						.addComponent(comboBoxFormCells, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE))
			);
			m_panelFormCells.setLayout(m_GroupLayoutPanelFormCells);
	}
	
	
	public void buildComponentLateralToolsBackgroundColor(){
		m_comboBoxBackgroundColor = new JComboBox();
		m_GroupLayoutPanelBackgroundColor = new GroupLayout(m_panelBackgroundColor);
		
		buildGroupLayoutComponentBackgroundColor();
	}
	
	public void buildGroupLayoutComponentBackgroundColor(){
		m_GroupLayoutPanelBackgroundColor.setHorizontalGroup(
				m_GroupLayoutPanelBackgroundColor.createParallelGroup(Alignment.LEADING)
					.addGap(0, 158, Short.MAX_VALUE)
					.addGroup(m_GroupLayoutPanelBackgroundColor.createSequentialGroup()
						.addContainerGap()
						.addComponent(m_comboBoxBackgroundColor, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			m_GroupLayoutPanelBackgroundColor.setVerticalGroup(
					m_GroupLayoutPanelBackgroundColor.createParallelGroup(Alignment.LEADING)
					.addGap(0, 71, Short.MAX_VALUE)
					.addGroup(m_GroupLayoutPanelBackgroundColor.createSequentialGroup()
						.addContainerGap()
						.addComponent(m_comboBoxBackgroundColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE))
			);
			m_panelBackgroundColor.setLayout(m_GroupLayoutPanelBackgroundColor);
	}
	
	
	public void buildComponentLateralToolsColorCells(){
		m_buttonColorCells = new JButton("Color Cells Setting");
		
		buildGroupLayoutComponentColorCells();
	}
	
	public void buildGroupLayoutComponentColorCells(){
		m_panelColorCells.setLayout(new BorderLayout(0, 0));
		m_panelColorCells.add(m_buttonColorCells);
	}

	
	public void buildGroupLayoutPanelLateralTools(){
		m_GroupLayoutPanelLateralTools = new GroupLayout(m_panelLateralTools);
		m_GroupLayoutPanelLateralTools.setHorizontalGroup(
			m_GroupLayoutPanelLateralTools.createParallelGroup(Alignment.LEADING)
				.addGroup(m_GroupLayoutPanelLateralTools.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(m_panelAlgorithm, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(m_GroupLayoutPanelLateralTools.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_panelInitialPositionCells, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(m_GroupLayoutPanelLateralTools.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_panelFormCells, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(m_GroupLayoutPanelLateralTools.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_panelBackgroundColor, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(m_GroupLayoutPanelLateralTools.createSequentialGroup()
						.addContainerGap()
						.addComponent(m_panelColorCells, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		m_GroupLayoutPanelLateralTools.setVerticalGroup(
			m_GroupLayoutPanelLateralTools.createParallelGroup(Alignment.LEADING)
				.addGroup(m_GroupLayoutPanelLateralTools.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_panelAlgorithm, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(m_panelInitialPositionCells, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(m_panelFormCells, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(m_panelBackgroundColor, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(m_panelColorCells, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(251, Short.MAX_VALUE))
		);
		m_panelLateralTools.setLayout(m_GroupLayoutPanelLateralTools);
	}
	
	
	
	/******Listeners TypeCellularAutomaton Tools******/
	private void addListenerTypeCellularAutomatonTools(){
		this.addListenerCellularAutomatonSetting();//add listener of button Launcher
	}
	
	private void addListenerCellularAutomatonSetting(){
		m_buttonCellularAutomatonSetting.addActionListener(new CellularAutomatonSetting1DEvent(this));
	}
	
	
	/******Listeners Simulation Tools******/
	private void addListenerSimulationTools(){
		this.addListenerLaucher();//add listener of button Launcher
		this.addListenerPause();//add listener of button Pause
		this.addListenerStop();//add listener of button Stop
		this.addListenerRefresh();//add listener of button Refresh
	}

	private void addListenerLaucher(){
		m_buttonLauncher.addActionListener(new StartSimulation1DEvent(this));
	}
	
	private void addListenerPause(){
		m_buttonPause.addActionListener(new PauseSimulation1DEvent(this));
	}
	
	private void addListenerStop(){
		m_buttonStop.addActionListener(new StopSimulation1DEvent(this));
	}
	
	private void addListenerRefresh(){
		m_buttonReload.addActionListener(new RefreshSimulation1DEvent(this));
	}
	
	
	
	/***Listeners Control Tools***/
	private void addListenerControlTools(){
		
	}

	

	
	
	public void runSimulation() {
		while(true){
			if(m_simulationState == SimulationState.RUN){
				while(m_simulationState == SimulationState.RUN) {
					m_internalFrameSimulation.startUpdate();//The simulation of the window start
				}
			}
			else if(m_simulationState == SimulationState.PAUSE){
				while(m_simulationState == SimulationState.PAUSE) {
					System.out.println("Pause");
				//TODO
				}
			}
			else{
				//TODO
				System.out.println("Stop");
			}
		}
	}
	


}
