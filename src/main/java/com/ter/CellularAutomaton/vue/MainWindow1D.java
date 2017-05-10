package com.ter.CellularAutomaton.vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.ter.CellularAutomaton.controller.CellularAutomatonSetting1DEvent;
import com.ter.CellularAutomaton.controller.Close1DEvent;
import com.ter.CellularAutomaton.controller.CloseAllEvent;
import com.ter.CellularAutomaton.controller.ComboBoxFormCellsEvent;
import com.ter.CellularAutomaton.controller.ComboBoxInitialPositionCellsEvent;
import com.ter.CellularAutomaton.controller.CreditsEvent;
import com.ter.CellularAutomaton.controller.EraseSimulation1DEvent;
import com.ter.CellularAutomaton.controller.ExportAllFormat1DEvent;
import com.ter.CellularAutomaton.controller.ExportGIFFormat1DEvent;
import com.ter.CellularAutomaton.controller.ExportJPGFormat1DEvent;
import com.ter.CellularAutomaton.controller.ExportPNGFormat1DEvent;
import com.ter.CellularAutomaton.controller.New1DEvent;
import com.ter.CellularAutomaton.controller.NonUniformCellularAutomatonSetting1DEvent;
import com.ter.CellularAutomaton.controller.OpenFileEvent;
import com.ter.CellularAutomaton.controller.PauseSimulation1DEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;
import com.ter.CellularAutomaton.controller.RadioButtonGridNoEvent;
import com.ter.CellularAutomaton.controller.RadioButtonGridYesEvent;
import com.ter.CellularAutomaton.controller.RefreshSimulation1DEvent;
import com.ter.CellularAutomaton.controller.RunApplication1D;
import com.ter.CellularAutomaton.controller.SizeOfSimulation1DEvent;
import com.ter.CellularAutomaton.controller.SpeedSimulation1DEvent;
import com.ter.CellularAutomaton.controller.StartSimulation1DEvent;
import com.ter.CellularAutomaton.controller.StopSimulation1DEvent;
import com.ter.CellularAutomaton.controller.Switch1DTo2DSimulationEvent;
import com.ter.CellularAutomaton.model.SimulationState;
import com.ter.CellularAutomaton.vue.IForm;
import com.ter.CellularAutomaton.controller.IInitializeSimulationRules1D;
import com.ter.CellularAutomaton.controller.InitializeSimulation1DOneCell;
import com.ter.CellularAutomaton.controller.MenubarNonUniformRulesElementary1DEvent;
import com.ter.CellularAutomaton.controller.MenubarRulesElementary1DEvent;
import com.ter.CellularAutomaton.vue.InternalFrameSimulation1D;
import com.ter.CellularAutomaton.vue.RectangleForm1D;
import java.awt.Component;


// TODO: Auto-generated Javadoc
/**
 * The Class MainWindow1D.
 */
public class MainWindow1D extends JFrame implements WindowListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/******ATTRIBUTES******/
	/** Characteristics of windows */
	private int m_intitialWidth;
	private int m_intitialHeight;
	
	
	private JMenuBar m_menuBar = new JMenuBar();

	/** The menu file. */
	//Tab in MenuBar
	private JMenu m_menuFile = new JMenu("File");

	/** The menu edit. */
	private JMenu m_menuEdit = new JMenu("Edit");
	
	/** The menu rules. */
	private JMenu m_menuRules = new JMenu("Rules");
	
	/** The menu Non Uniform rules. */
	private JMenu m_menuNonUniformRules = new JMenu("Non Uniform Rules");

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
	private JMenuItem m_menuBarFileItem7 = new JMenuItem("Export (all formats)");
	
	/** The menu bar file item 8. */
	private JMenu m_menuBarFileItem8 = new JMenu("Export As");
	
	/** The menu bar file item 8 choice PNG. */
	private JMenuItem m_menuBarFileItem8ChoicePNG = new JMenuItem("PNG");
	
	/** The menu bar file item 8 choice JPG. */
	private JMenuItem m_menuBarFileItem8ChoiceJPG = new JMenuItem("JPG");
	
	/** The menu bar file item 8 choice GIF. */
	private JMenuItem m_menuBarFileItem8ChoiceGIF = new JMenuItem("GIF");

	/** The menu bar file item 9. */
	private JMenuItem m_menuBarFileItem9 = new JMenuItem("Close");

	/** The menu bar file item 10. */
	private JMenuItem m_menuBarFileItem10 = new JMenuItem("Close All");

	/** The menu bar file item 11. */
	private JMenuItem m_menuBarFileItem11 = new JMenuItem("Quit");

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
	
	/** The menu bar rules item 1. */
	// In rules menu
	private JMenuItem m_menuBarRulesItem1 = new JMenuItem("Elementary");

	/** The menu bar rules item 2. */
	private JMenuItem m_menuBarRulesItem2 = new JMenuItem("Additive");

	/** The menu bar rules item 3. */
	private JMenuItem m_menuBarRulesItem3 = new JMenuItem("Pattern");

	/** The menu bar rules item 4. */
	private JMenuItem m_menuBarRulesItem4 = new JMenuItem("Script");
	
	/** The menu bar Non Uniform rules item 1. */
	// In rules menu
	private JMenuItem m_menuBarNonUniformRulesItem1 = new JMenuItem("Elementary");

	/** The menu bar Non Uniform rules item 2. */
	private JMenuItem m_menuBarNonUniformRulesItem2 = new JMenuItem("Additive");

	/** The menu bar Non Uniform rules item 3. */
	private JMenuItem m_menuBarNonUniformRulesItem3 = new JMenuItem("Pattern");

	/** The menu bar Non Uniform rules item 4. */
	private JMenuItem m_menuBarNonUniformRulesItem4 = new JMenuItem("Script");

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
	
	
	/** Utilities */
	private String[] m_stringInitialPositionCells = { "One Cell", "Three Cells", "Randomly" };
	private String[] m_stringFormCells = { "Rectangle", "Rectangle 3D Raised", "Rectangle 3D Sunk", "Upward Triangle", "Downward Triangle", "Circle" };
	
	
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
	private JButton m_buttonNonUniformCellularAutomatonSetting;
	private JButton m_buttonUniformCellularAutomatonSetting;
	private JToolBar m_toolBarSimulationTools;
	private JPanel m_panelSimulationTools;
	private JButton m_buttonLauncher;
	private JButton m_buttonPause;
	private JButton m_buttonErase;
	private JButton m_buttonUndo;
	private JButton m_buttonRedo;
	private JButton m_buttonReload;
	private JToolBar m_toolBarControlTools;
	private JPanel m_panelControlTools;
	private JPanel m_panelBorderCondition;
	private JPanel m_panelDirectionOfEvolution;
	private JButton m_buttonSizeOfSimulation;
	private JButton m_buttonBorderCondition;
	private JSeparator m_separatorInControlTools;
	private JDesktopPane m_mainDesktopPane;
	private JScrollPane m_scrollPaneLateralTools;
	private JPanel m_panelLateralTools;
	private JPanel m_panelAlgorithm;
	private JComboBox m_comboBoxAlgorithm;
	private JPanel m_panelInitialPositionCells;
	private JComboBox m_comboBoxInitialPositionCells;
	private JPanel m_panelFormCells;
	private JComboBox m_comboBoxFormCells;
	private JPanel m_panelColorCells;
	private JButton m_buttonColorCells;
	private JPanel m_panelBackgroundColor;
	private JComboBox m_comboBoxBackgroundColor;
	private JPanel m_panelTypeOfSimulator;
	private JButton m_buttonTypeOfSimulator;
	private JPanel m_panelSimulationSpeed;
	private JSlider m_sliderSpeedSimulation;
	private JPanel m_panelGrid;
	private ButtonGroup m_radioButtonGrid;
	private JRadioButton m_radioButtonGridNo;
	private JRadioButton m_radioButtonGridYes;
	private InternalFrameSimulation1D m_internalFrameSimulation;
	
	/**Others */
	private IInitializeSimulationRules1D m_modeInitializeSimulationRule;
	private IForm m_modeForm;
	private SimulationState m_simulationState;
	private boolean m_isRun;
	private Thread m_threadSimulation;
	private boolean m_gridSimulation;
	

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
		
		//add listeners LateralTools
		addListenerLateralTools();

		//Set the window visible
		this.setVisible(true);
		
		m_simulationState = SimulationState.RUN;
		m_isRun = true;
		m_gridSimulation = false;
		this.addWindowListener(this);//Add WindowListener on MainWindow
		
		this.runSimulation();//run simulation
		
	}

	
	public MainWindow1D (boolean createNewThread){

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
		
		//add listeners LateralTools
		addListenerLateralTools();

		//Set the window visible
		this.setVisible(true);
		
		m_simulationState = SimulationState.RUN;
		m_isRun = true;
		m_gridSimulation = false;
		
		this.addWindowListener(this);//Add WindowListener on MainWindow
		
		//if we want create a new thread
		if(createNewThread){
			//Don't start simulation. We must create before a new thread.
		}
		else{
			this.runSimulation();//run simulation
		}
		
	}

	
	/******GETTERS******/
	public int getm_intitialWidth() {
		return m_intitialWidth;
	}
	
	public int getm_intitialHeight() {
		return m_intitialHeight;
	}
	
	public InternalFrameSimulation1D getm_internalFrameSimulation() {
		return m_internalFrameSimulation;
	}
	
	public JButton getm_buttonBorderCondition() {
		return m_buttonBorderCondition;
	}
	
	public JSlider getm_sliderSpeedSimulation() {
		return m_sliderSpeedSimulation;
	}
	
	public JButton getm_buttonLauncher() {
		return m_buttonLauncher;
	}
	
	public JButton getm_buttonPause() {
		return m_buttonPause;
	}
	
	public JButton getm_buttonStop() {
		return m_buttonErase;
	}
	
	public boolean getm_isRun() {
		return m_isRun;
	}
	
	public Thread getm_threadSimulation() {
		return m_threadSimulation;
	}
	
	public IInitializeSimulationRules1D getm_modeInitializeSimulationRule() {
		return m_modeInitializeSimulationRule;
	}
	
	public String[] getm_stringInitialPositionCells() {
		return m_stringInitialPositionCells;
	}
	
	public String[] getm_stringFormCells() {
		return m_stringFormCells;
	}
	
	public JComboBox getm_comboBoxInitialPositionCells() {
		return m_comboBoxInitialPositionCells;
	}
	
	public JComboBox getm_comboBoxFormCells() {
		return m_comboBoxFormCells;
	}
	
	public IForm getm_modeForm() {
		return m_modeForm;
	}
	
	public boolean getm_gridSimulation() {
		return m_gridSimulation;
	}

	
	/******SETTERS******/
	public void setm_internalFrameSimulation(InternalFrameSimulation1D internalFrame) {
		this.m_internalFrameSimulation = internalFrame;
	}
	
	public void setm_modeInitializeSimulationRule(IInitializeSimulationRules1D modeInitializeSimulationRule) {
		this.m_modeInitializeSimulationRule = modeInitializeSimulationRule;
	}
	
	public void setm_simulationState(SimulationState simulationState) {
		this.m_simulationState = simulationState;
	}
	
	public void setm_isRun(boolean isRun) {
		this.m_isRun = isRun;
	}
	
	public void setm_threadSimulation(Thread threadSimulation) {
		this.m_threadSimulation = threadSimulation;
	}
	
	public void setm_stringFormCells(String[] stringFormCells) {
		this.m_stringFormCells = stringFormCells;
	}
	
	
	public void setm_modeForm(IForm modeForm) {
		this.m_modeForm = modeForm;
	}
	
	public void setm_gridSimulation(boolean gridSimulation) {
		this.m_gridSimulation = gridSimulation;
	}
	
	

	/**
	 * ****CLASS METHODS*****.
	 */

	/***Set the window***/
	private void setWindow(){
		m_intitialWidth = 1370;
		m_intitialHeight = 730;
		this.setWindow("Cellular Automaton", m_intitialWidth, m_intitialHeight, true, false);
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
			this.setIconImage(ImageIO.read(new File("Files/Images/Favicon/PenroseColor.png")));
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
		m_menuRules.setMnemonic('R');
		m_menuNonUniformRules.setMnemonic('N');
		m_menuRun.setMnemonic('U');
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


		this.constructTabRulesMenuBar();//Construction of the tab "Rules" of menuBar
		
		
		constructTabNonUniformRulesMenuBar();//Construction of the tab "Non Uniform Rules" of menuBar
		
		
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
		this.m_menuFile.add(m_menuBarFileItem7);//Adding a tab "Export" in tab File in MenuBar
		constructTabExportAs();
		this.m_menuFile.add(m_menuBarFileItem8);//Adding a tab "Export As" in tab File in MenuBar
		this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuFile.add(m_menuBarFileItem9);//Adding a tab "Close" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItem10);//Adding a tab "Close All" in tab File in MenuBar
		this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuFile.add(m_menuBarFileItem11);//Adding a tab "Quit" in tab File in MenuBar
		this.m_menuBar.add(m_menuFile);//the File tab is added to MenuBar
	}
	
	
	/**
	 * Construct tab in tab ExportAs in tab File.
	 */
	private void constructTabExportAs(){
		//Build tab ExportAs in tab File.
		constructSubTabInTabExportAs();//Build Sub-group of tabs in tab ExportAs in tab File.
		this.m_menuFile.add(m_menuBarFileItem8);//Adding a tab "Export As" in tab File in MenuBar
	}
	
	/**
	 * Construct sub tab in tab ExportAs in tab File.
	 */
	private void constructSubTabInTabExportAs(){
		//Sub-group of tab in tab ExportAs in tab File.
		this.m_menuBarFileItem8.add(m_menuBarFileItem8ChoicePNG);//Adding a tab "PNG" in tab "Export As"
		this.m_menuBarFileItem8.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuBarFileItem8.add(m_menuBarFileItem8ChoiceJPG);//Adding a tab "JPG" in tab "Export As"
		this.m_menuBarFileItem8.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuBarFileItem8.add(m_menuBarFileItem8ChoiceGIF);//Adding a tab "GIF" in tab "Export As"
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
	 * Construct tab rules menu bar.
	 */
	private void constructTabRulesMenuBar(){
		//Construction of the tab "Rules" of menuBar
		this.m_menuRules.add(m_menuBarRulesItem1);//Adding a tab "Elementary" in MenuBar
		this.m_menuRules.addSeparator();//Adding a separator in tab Rules of the MenuBar
		this.m_menuRules.add(m_menuBarRulesItem2);//Adding a tab "Additive" in MenuBar
		this.m_menuRules.addSeparator();//Adding a separator in tab Rules of the MenuBar
		this.m_menuRules.add(m_menuBarRulesItem3);//Adding a tab "Pattern" in MenuBar
		this.m_menuRules.addSeparator();//Adding a separator in tab Rules of the MenuBar
		this.m_menuRules.add(m_menuBarRulesItem4);//Adding a tab "Script" in MenuBar
		this.m_menuBar.add(m_menuRules);//the Rules tab is added to MenuBar

	}
	
	/**
	 * Construct tab Non Uniform rules menu bar.
	 */
	private void constructTabNonUniformRulesMenuBar(){
		//Construction of the tab "Rules" of menuBar
		this.m_menuNonUniformRules.add(m_menuBarNonUniformRulesItem1);//Adding a tab "Elementary" in MenuBar
		this.m_menuNonUniformRules.addSeparator();//Adding a separator in tab Rules of the MenuBar
		this.m_menuNonUniformRules.add(m_menuBarNonUniformRulesItem2);//Adding a tab "Additive" in MenuBar
		this.m_menuNonUniformRules.addSeparator();//Adding a separator in tab Rules of the MenuBar
		this.m_menuNonUniformRules.add(m_menuBarNonUniformRulesItem3);//Adding a tab "Pattern" in MenuBar
		this.m_menuNonUniformRules.addSeparator();//Adding a separator in tab Rules of the MenuBar
		this.m_menuNonUniformRules.add(m_menuBarNonUniformRulesItem4);//Adding a tab "Script" in MenuBar
		this.m_menuBar.add(m_menuNonUniformRules);//the Rules tab is added to MenuBar

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
		this.initAcceleratorRules(); //accelerator of tab Rules
		this.initAcceleratorNonUniformRules(); //accelerator of tab NonUniform Rules
		this.initAcceleratorHelp();//accelerator of tab Help
	}

	private void initAcceleratorFile(){
		//add all the accelerators for the items of tab File
		m_menuBarFileItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK)); //add accelerators of New in tab File
		m_menuBarFileItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK)); //add accelerators of Open File in tab File
		m_menuBarFileItem7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export (all formats)" in tab File
		m_menuBarFileItem8ChoicePNG.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export (all formats)" in tab File
		m_menuBarFileItem8ChoiceJPG.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export (all formats)" in tab File
		m_menuBarFileItem8ChoiceGIF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export (all formats)" in tab File
		m_menuBarFileItem9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK)); //add accelerators of Close in tab File
		m_menuBarFileItem10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of CloseAll in tab File
		m_menuBarFileItem11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK)); //add accelerators of Quit in tab File
	}
	
	private void initAcceleratorRules(){
		//add all the accelerators for the items of tab Rules
		m_menuBarRulesItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK)); //add accelerators of Elementary in tab Rules
		m_menuBarRulesItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK)); //add accelerators of Additive in tab Rules
		m_menuBarRulesItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK)); //add accelerators of Pattern in tab Rules
		m_menuBarRulesItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK)); //add accelerators of Script in tab Rules
	}
	
	private void initAcceleratorNonUniformRules(){
		//add all the accelerators for the items of tab Rules
		m_menuBarNonUniformRulesItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK)); //add accelerators of Elementary in tab Rules
		m_menuBarNonUniformRulesItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of Additive in tab Rules
		m_menuBarNonUniformRulesItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of Pattern in tab Rules
		m_menuBarNonUniformRulesItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of Script in tab Rules
	}

	private void initAcceleratorHelp(){
		//add all the accelerators for the items of tab Help
		m_menuBarHelpItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of Quit in tab File
	}



	/***Listeners MenuBar***/
	//All listener of MenuBar
	private void addListenerMenuBar (){
		this.addListenerFile(); //add listener of tab File
		this.addListenerRules(); //add listener of tab Rules
;		this.addListenerNonUniformRules(); //add listener of tab Non Uniform Rules
		this.addListenerHelp(); //add listener of tab Help
	}

	//Listener of tab File
	private void addListenerFile (){
		m_menuBarFileItem1.addActionListener(new New1DEvent());//Add ActionListener on tab "New" in tab "File"
		m_menuBarFileItem2.addActionListener(new OpenFileEvent());//Add ActionListener on tab "Open File" in tab "File"
		m_menuBarFileItem7.addActionListener(new ExportAllFormat1DEvent(this));//Add ActionListener on tab "Export (all formats)" in tab "File"
		m_menuBarFileItem8ChoicePNG.addActionListener(new ExportPNGFormat1DEvent(this));//Add ActionListener on tab "PNG" of the tab "Export As" in tab "File"
		m_menuBarFileItem8ChoiceJPG.addActionListener(new ExportJPGFormat1DEvent(this));//Add ActionListener on tab "JPG" of the tab "Export As" in tab "File"
		m_menuBarFileItem8ChoiceGIF.addActionListener(new ExportGIFFormat1DEvent(this));//Add ActionListener on tab "GIF" of the tab "Export As" in tab "File"
		m_menuBarFileItem9.addActionListener(new Close1DEvent(this));//Add ActionListener on tab "Close" in tab "File"
		m_menuBarFileItem10.addActionListener(new CloseAllEvent());//Add ActionListener on tab "Close All" in tab "File"
		m_menuBarFileItem11.addActionListener(new QuitEvent());//Add ActionListener on tab "Quit" in tab "File"
	}
	
	//Listener of tab Rules
	private void addListenerRules (){
		m_menuBarRulesItem1.addActionListener(new MenubarRulesElementary1DEvent(this));//Add ActionListener on tab "Elementary" in tab "Rules"
	}
	
	//Listener of tab Non Uniform Rules
		private void addListenerNonUniformRules (){
			m_menuBarNonUniformRulesItem1.addActionListener(new MenubarNonUniformRulesElementary1DEvent(this));//Add ActionListener on tab "Elementary" in tab "Non Uniform Rules"
		}

	//Listener of tab Help
	private void addListenerHelp (){
		m_menuBarHelpItem2.addActionListener(new CreditsEvent());//Add ActionListener on tab "Credits" in tab "Help"
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
		m_panelChooseCellularAutomaton.setBorder(BorderFactory.createTitledBorder("Uniform Cellular Automaton"));
		m_panelChooseCellularAutomaton.setLayout(new BorderLayout(0, 0));
		
		buildComponentChooseCellularAutomaton();//Build the component of the panel ChooseCellularAutomaton
	}
	
	public void buildComponentChooseCellularAutomaton(){
		//Build the component of the panel ChooseCellularAutomaton
		m_buttonUniformCellularAutomatonSetting = new JButton("Uniform Rules");
		m_panelChooseCellularAutomaton.add(m_buttonUniformCellularAutomatonSetting, BorderLayout.CENTER);
	}
	
	public void buildPanelUniform(){
		//Build the panel Uniform
		m_panelUniform = new JPanel();
		m_panelUniform.setBorder(BorderFactory.createTitledBorder("Non Uniform Cellular Automaton"));
		m_panelUniform.setLayout(new BorderLayout(0, 0));
		
		buildComponentUniform();//Build the component of the panel Uniform
	}
	
	public void buildComponentUniform(){
		//Build the component of the panel Uniform
		m_buttonNonUniformCellularAutomatonSetting = new JButton("Non Uniform Rules");
		m_panelUniform.add(m_buttonNonUniformCellularAutomatonSetting, BorderLayout.CENTER);
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
		
		m_buttonErase = new JButton(new ImageIcon(pathDirectory+"button_erase.png"));
		
		m_buttonUndo = new JButton(new ImageIcon(pathDirectory+"button_undo.png"));
		
		m_buttonRedo = new JButton(new ImageIcon(pathDirectory+"button_redo.png"));
		
		m_buttonReload = new JButton(new ImageIcon(pathDirectory+"button_reload.png"));
		
		m_panelSimulationTools.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		m_panelSimulationTools.add(m_buttonLauncher);
		m_panelSimulationTools.add(m_buttonPause);
		m_panelSimulationTools.add(m_buttonUndo);
		m_panelSimulationTools.add(m_buttonRedo);
		m_panelSimulationTools.add(m_buttonErase);
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
		m_panelDirectionOfEvolution.setBorder(BorderFactory.createTitledBorder("Size of Simulation"));//Set a border of JPanel
		
		buildComponentDirectionOfEvolution();//Set the component of Panel "DirectionOfEvolution"
	}
	
	public void buildComponentDirectionOfEvolution(){
		m_panelDirectionOfEvolution.setLayout(new BorderLayout(0, 0));//The component take full place of panel
		m_buttonSizeOfSimulation = new JButton("Size of Simulation");//Creation of Button for panel "Size of Simulation"
		m_panelDirectionOfEvolution.add(m_buttonSizeOfSimulation);//Add the radioButton m_radioButtonContinuous to panel m_panelSimulationMode
	}

	
	public void buildSeparatorInControlTools(){
		//Creation of Separator between the panel of "BorderCondition" and the panel "DirectionOfEvolution"
		m_separatorInControlTools = new JSeparator();//Create JSeparator
		m_separatorInControlTools.setOrientation(SwingConstants.VERTICAL);//Set the orientation of separator to vertical
		m_separatorInControlTools.setBounds(194, 23, 2, 43);//Set the position and size of separator
		m_panelControlTools.add(m_separatorInControlTools);//Add the separator to panel m_panelControlTools
	}
	
	
	/******Build DesktopPane******/
	public void buildDesktopPane(){
		m_mainDesktopPane = new JDesktopPane();
		m_mainPanel.add(m_mainDesktopPane, BorderLayout.CENTER);
	}
	
	
	/******Build InternalFrameSimulation******/
	public void buildInternalFrameSimulation(){
		m_modeForm = new RectangleForm1D(this);
		ArrayList<Color> colorOfCells = new ArrayList<Color>();
		colorOfCells.add(Color.BLACK);
		colorOfCells.add(Color.BLUE);
		Color backgroundColor = Color.GRAY;
		m_modeInitializeSimulationRule = new InitializeSimulation1DOneCell();
		buildInternalFrameSimulation(m_modeForm, colorOfCells, backgroundColor, m_modeInitializeSimulationRule);
	}
	
	public void buildInternalFrameSimulation(IForm formOfCells, ArrayList<Color> colorOfCells, Color backgroundColor, IInitializeSimulationRules1D initializeSimulationRule){
		m_internalFrameSimulation = new InternalFrameSimulation1D("Simulation", formOfCells, colorOfCells, backgroundColor, initializeSimulationRule, this);
		m_internalFrameSimulation.setVisible(true);
		m_mainDesktopPane.setLayout(null);
		m_mainDesktopPane.add(m_internalFrameSimulation);
	}
	
	/******Build LateralTools******/
	public void buildLateralTools(){
		buildPanelLateralTools();//Build the panel "Lateral Tools"
	}
	
	
	/******Build Panel LateralTools and its components******/
	public void buildPanelLateralTools(){		
		m_panelLateralTools = new JPanel();//Create a JPanel for the "Lateral Tools"
		m_panelLateralTools.setPreferredSize(new Dimension(180, 2*getHeight()));

		m_scrollPaneLateralTools = new JScrollPane(m_panelLateralTools);//Create a JScrollPane for the "Lateral Tools" and add the panel m_panelLateralTools to panel m_mainPanel
		m_scrollPaneLateralTools.setPreferredSize(new Dimension(200, getHeight()));
		m_mainPanel.add(m_scrollPaneLateralTools, BorderLayout.EAST);//Add the panel m_panelLateralTools to panel m_mainPanel
		
		buildPanelAlgorithm();//Create the panel "Algorithm"
		
		buildPanelInitialPositionCells();//Create the panel "InitialPositionCells"
		
		buildPanelFormCells();//Create the panel "FormCells"
		
		buildPanelColorCells();//Create the panel "ColorCells"
		
		buildPanelBackgroundColor();//Create the panel "BackgroundColor"
		
		buildPanelTypeOfSimulator();//Create the panel "TypeOfSimulator"
		
		buildPanelSimulationSpeed();//Create the panel "SimulationSpeed"
		
		buildPanelGrid();//Create the panel "Grid"
		
		buildGroupLayoutPanelLateralTools();//Create the GroupLayout for the disposition of the panel "Lateral Tools"
	}
	
	
	/******Build Panel Algorithm******/
	public void buildPanelAlgorithm(){
		m_panelAlgorithm = new JPanel();//Create the panel Algorithm
		m_panelAlgorithm.setBounds(13, 11, 158, 71);
		m_panelAlgorithm.setBorder(BorderFactory.createTitledBorder("Algorithm"));//Set a border for the panel Algorithm
		
		buildComponentLateralToolsAlgorithm();//Create components of panel Algorithm in the LateralTools
	}
	
	/******Build Panel InitialPositionCells******/
	public void buildPanelInitialPositionCells(){
		m_panelInitialPositionCells = new JPanel();//Create the panel InitialPositionCells
		m_panelInitialPositionCells.setBounds(10, 100, 158, 71);
		m_panelInitialPositionCells.setBorder(BorderFactory.createTitledBorder("Initial Position of Cells"));//Set a border for the panel InitialPositionCells
		
		buildComponentLateralToolsInitialPositionCells();//Create components of panel InitialPositionCells in the LateralTools
	}
	
	/******Build Panel FormCells******/
	public void buildPanelFormCells(){
		m_panelFormCells = new JPanel();//Create the panel FormCells
		m_panelFormCells.setBounds(10, 189, 158, 71);
		m_panelFormCells.setBorder(BorderFactory.createTitledBorder("Form of Cells"));//Set a border for the panel FormCells
		
		buildComponentLateralToolsFormCells();//Create components of panel FormCells in the LateralTools
	}
	
	/******Build Panel ColorCells******/
	public void buildPanelColorCells(){
		m_panelColorCells = new JPanel();//Create the panel ColorCells
		m_panelColorCells.setBounds(10, 367, 158, 55);
		m_panelColorCells.setBorder(BorderFactory.createTitledBorder("Color of Cells"));//Set a border for the panel ColorCells
		
		buildComponentLateralToolsColorCells();//Create components of panel ColorCells in the LateralTools
	}
	
	/******Build Panel BackgroundColor******/
	public void buildPanelBackgroundColor(){
		m_panelBackgroundColor = new JPanel();//Create the panel BackgroundColor
		m_panelBackgroundColor.setBounds(10, 278, 158, 71);
		m_panelBackgroundColor.setBorder(BorderFactory.createTitledBorder("Background Color"));//Set a border for the panel BackgroundColor
		
		buildComponentLateralToolsBackgroundColor();//Create components of panel BackgroundColor in the LateralTools
	}
	
	/******Build Panel TypeOfSimulator******/
	public void buildPanelTypeOfSimulator(){
		m_panelTypeOfSimulator = new JPanel();//Create the panel TypeOfSimulator
		m_panelTypeOfSimulator.setBounds(10, 440, 158, 55);
		m_panelTypeOfSimulator.setBorder(BorderFactory.createTitledBorder("Type Of Simulator"));//Set a border for the panel TypeOfSimulator
		
		buildComponentLateralToolsTypeOfSimulator();//Create components of panel TypeOfSimulator in the LateralTools
	}
	
	/******Build Panel SimulationSpeed******/
	public void buildPanelSimulationSpeed(){
		m_panelSimulationSpeed = new JPanel();//Creation of panel for SimulationSpeed
		m_panelSimulationSpeed.setBounds(10, 513, 158, 55);
		m_panelSimulationSpeed.setBorder(BorderFactory.createTitledBorder("Simulation Speed"));//Set a border of JPanel
		
		buildComponentSimulationSpeed();//Set the component of Panel "Simulation Speed"
	}
	
	/******Build Panel Grid******/
	public void buildPanelGrid(){
		m_panelGrid = new JPanel();//Create the panel TypeOfSimulator
		m_panelGrid.setBounds(13, 588, 158, 55);
		m_panelGrid.setBorder(BorderFactory.createTitledBorder("Grid On Simulation"));
				
		buildComponentLateralToolsGrid();//Create components of panel TypeOfSimulator in the LateralTools
	}
	
	
	/******Components of Panel Algorithm in LateralTools******/
	//Build components for Algorithm in LateralTools
	public void buildComponentLateralToolsAlgorithm(){
		m_comboBoxAlgorithm = new JComboBox();
		m_comboBoxAlgorithm.setBounds(16, 27, 126, 20);
		
		buildGroupLayoutComponentAlgorithm();//Build the grouplayout for the component Algorithm
	}
	
	//Build Layout for Algorithm in LateralTools
	public void buildGroupLayoutComponentAlgorithm(){
			m_panelAlgorithm.setLayout(null);
			m_panelAlgorithm.add(m_comboBoxAlgorithm);
	}
	
	
	/******Components of Panel InitialPositionCells in LateralTools******/
	//Build components for InitialPositionCells in LateralTools
	public void buildComponentLateralToolsInitialPositionCells(){
		m_comboBoxInitialPositionCells = new JComboBox(m_stringInitialPositionCells);
		m_comboBoxInitialPositionCells.setBounds(16, 27, 126, 20);
		
		buildGroupLayoutComponentInitialPositionCells();
	}
	
	//Build Layout for InitialPositionCells in LateralTools
	public void buildGroupLayoutComponentInitialPositionCells(){
			m_panelInitialPositionCells.setLayout(null);
			m_panelInitialPositionCells.add(m_comboBoxInitialPositionCells);
	}
	
	
	/******Components of Panel FormCells in LateralTools******/
	//Build components for FormCells in LateralTools
	public void buildComponentLateralToolsFormCells(){
		m_comboBoxFormCells = new JComboBox(m_stringFormCells);
		m_comboBoxFormCells.setBounds(16, 27, 126, 20);
		
		buildGroupLayoutComponentFormCells();
	}
	
	//Build Layout for FormCells in LateralTools
	public void buildGroupLayoutComponentFormCells(){
			m_panelFormCells.setLayout(null);
			m_panelFormCells.add(m_comboBoxFormCells);
	}
	
	
	/******Components of Panel BackgroundColor in LateralTools******/
	//Build components for BackgroundColor in LateralTools
	public void buildComponentLateralToolsBackgroundColor(){
		m_comboBoxBackgroundColor = new JComboBox();
		m_comboBoxBackgroundColor.setBounds(16, 27, 126, 20);
		
		buildGroupLayoutComponentBackgroundColor();
	}
	
	//Build Layout for BackgroundColor in LateralTools
	public void buildGroupLayoutComponentBackgroundColor(){
			m_panelBackgroundColor.setLayout(null);
			m_panelBackgroundColor.add(m_comboBoxBackgroundColor);
	}
	
	
	/******Components of Panel ColorCells in LateralTools******/
	//Build components for ColorCells in LateralTools
	public void buildComponentLateralToolsColorCells(){
		m_buttonColorCells = new JButton("Color Cells Setting");
		
		buildGroupLayoutComponentColorCells();
	}
	
	//Build Layout for ColorCells in LateralTools
	public void buildGroupLayoutComponentColorCells(){
		m_panelColorCells.setLayout(new BorderLayout(0, 0));
		m_panelColorCells.add(m_buttonColorCells);
	}
	
	
	/******Components of Panel TypeOfSimulator in LateralTools******/
	//Build components for TypeOfSimulator in LateralTools
	public void buildComponentLateralToolsTypeOfSimulator(){
		m_buttonTypeOfSimulator = new JButton("Switch to 2D");
		
		buildGroupLayoutComponentTypeOfSimulator();
	}
	
	//Build Layout for TypeOfSimulator in LateralTools
	public void buildGroupLayoutComponentTypeOfSimulator(){
		m_panelTypeOfSimulator.setLayout(new BorderLayout(0, 0));
		m_panelTypeOfSimulator.add(m_buttonTypeOfSimulator);
	}
	
	
	/******Components of Panel SimulationSpeed in LateralTools******/
	//Build components for SimulationSpeed in LateralTools
	public void buildComponentSimulationSpeed(){ 
		m_sliderSpeedSimulation = new JSlider();//Creation of Slider for panel "Simulation Speed"
		m_sliderSpeedSimulation.setMinimum(1);//Set the minimum value of slider
		m_sliderSpeedSimulation.setMaximum(100);//Set the maximum value of slider
		m_sliderSpeedSimulation.setValue(30);//Set the value of slider to 30 by default
		m_sliderSpeedSimulation.setPaintTicks(true);//Set the paint ticks of slider
		m_sliderSpeedSimulation.setMinorTickSpacing(10);//Set the space between each ticks of slider to 10
		m_sliderSpeedSimulation.setMajorTickSpacing(20);//Set the space between each major ticks of slider to 20
	
		buildGroupLayoutComponentSimulationSpeed();//Build Layout for SimulationSpeed in LateralTools
	}
	
	//Build Layout for SimulationSpeed in LateralTools
	public void buildGroupLayoutComponentSimulationSpeed(){
		m_panelSimulationSpeed.setLayout(new BorderLayout(0, 0));
		m_panelSimulationSpeed.add(m_sliderSpeedSimulation);//Add the slider to panel m_panelSimulationSpeed
	}
	
	/******Components of Panel Grid in LateralTools******/
	//Build components for Grid in LateralTools
	public void buildComponentLateralToolsGrid(){
		m_radioButtonGridNo = new JRadioButton("No");
		m_radioButtonGridNo.setSelected(true);//Set a CheckBox "All" to true by default
		m_panelGrid.add(m_radioButtonGridNo);
		
		Component horizontalStrut = Box.createHorizontalStrut(30);
		m_panelGrid.add(horizontalStrut);
		
		m_radioButtonGridYes = new JRadioButton("yes");
		m_panelGrid.add(m_radioButtonGridYes);
		
		m_radioButtonGrid = new ButtonGroup();
		m_radioButtonGrid.add(m_radioButtonGridNo);
		m_radioButtonGrid.add(m_radioButtonGridYes);
		
		buildGroupLayoutComponentGrid();
	}
	
	//Build Layout for BackgroundColor in LateralTools
	public void buildGroupLayoutComponentGrid(){
			m_panelBackgroundColor.setLayout(null);
			//m_panelBackgroundColor.add();
	}


	
	/******Layout for all components of LateralTools******/
	//Build Layout for components of Panel LateralTools
	public void buildGroupLayoutPanelLateralTools(){
		m_panelLateralTools.setLayout(null);
		m_panelLateralTools.add(m_panelAlgorithm);
		m_panelLateralTools.add(m_panelInitialPositionCells);
		m_panelLateralTools.add(m_panelFormCells);
		m_panelLateralTools.add(m_panelBackgroundColor);
		m_panelLateralTools.add(m_panelColorCells);
		m_panelLateralTools.add(m_panelTypeOfSimulator);
		m_panelLateralTools.add(m_panelSimulationSpeed);
		m_panelLateralTools.add(m_panelGrid);
	}
	
	
	
	/******Listeners TypeCellularAutomaton Tools******/
	private void addListenerTypeCellularAutomatonTools(){
		this.addListenerUniformCellularAutomatonSetting();//add listener of button UniformCellularAutomatonSetting
		this.addListenerNonUniformCellularAutomatonSetting();//add listener of button NonUniformCellularAutomatonSetting
	}
	
	private void addListenerUniformCellularAutomatonSetting(){
		m_buttonUniformCellularAutomatonSetting.addActionListener(new CellularAutomatonSetting1DEvent(this));
	}
	
	private void addListenerNonUniformCellularAutomatonSetting(){
		m_buttonNonUniformCellularAutomatonSetting.addActionListener(new NonUniformCellularAutomatonSetting1DEvent(this));
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
		m_buttonErase.addActionListener(new EraseSimulation1DEvent(this));
	}
	
	private void addListenerRefresh(){
		m_buttonReload.addActionListener(new RefreshSimulation1DEvent(this));
	}
	
	
	
	/******Listeners Control Tools******/
	private void addListenerControlTools(){
		addListenerSizeOfSimulation();
	}
	
	private void addListenerSizeOfSimulation(){
		m_buttonSizeOfSimulation.addActionListener(new SizeOfSimulation1DEvent(this));
	}
	
	
	
	/******Listeners Lateral Tools******/
	private void addListenerLateralTools(){
		addListenerSlider();//add listener of Slider sliderSpeedSimulation
		addListenerSwitchTo2D();//add listener of button TypeOfSimulator
		addListenerComboBoxInitialPositionCells();//add listener of ComboBox InitialPositionCells
		addListenerComboBoxFormCells();//add listener of ComboBox FormCells
		addListenerRadioButtonGrid();//add listener of Radio Button Grid
	}
	
	private void addListenerSwitchTo2D(){
		m_buttonTypeOfSimulator.addActionListener(new Switch1DTo2DSimulationEvent(this));
	}
	
	private void addListenerSlider(){
		m_sliderSpeedSimulation.addChangeListener(new SpeedSimulation1DEvent(this));
	}
	
	private void addListenerComboBoxInitialPositionCells(){
		m_comboBoxInitialPositionCells.addItemListener(new ComboBoxInitialPositionCellsEvent(this));
	}
	
	private void addListenerComboBoxFormCells(){
		m_comboBoxFormCells.addItemListener(new ComboBoxFormCellsEvent(this));
	}
	
	private void addListenerRadioButtonGrid(){
		m_radioButtonGridNo.addActionListener(new RadioButtonGridNoEvent(this));
		m_radioButtonGridYes.addActionListener(new RadioButtonGridYesEvent(this));
	}
	
	
	

	
	
	public void runSimulation() {
		while(m_isRun){
			if(m_simulationState == SimulationState.RUN){
					m_internalFrameSimulation.startUpdate();//The simulation of the window start
			}
			else if(m_simulationState == SimulationState.PAUSE){
					System.out.println("Pause");
			}
			else{
				//TODO
				System.out.println("Stop");
			}
		}
	}


	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		m_isRun = false;
		m_threadSimulation = null;
	}


	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	} 
}
