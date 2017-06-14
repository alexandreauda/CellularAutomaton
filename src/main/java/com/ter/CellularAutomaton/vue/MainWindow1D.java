package com.ter.CellularAutomaton.vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import com.ter.CellularAutomaton.controller.CellularAutomatonSetting1DEvent;
import com.ter.CellularAutomaton.controller.ChooseColorBackgroundEvent;
import com.ter.CellularAutomaton.controller.ChooseColorGridEvent;
import com.ter.CellularAutomaton.controller.Close1DEvent;
import com.ter.CellularAutomaton.controller.CloseAllEvent;
import com.ter.CellularAutomaton.controller.ComboBoxFormCellsEvent;
import com.ter.CellularAutomaton.controller.ComboBoxInitialPositionCellsEvent;
import com.ter.CellularAutomaton.controller.CreditsEvent;
import com.ter.CellularAutomaton.controller.EraseSimulation1DEvent;
import com.ter.CellularAutomaton.controller.ExportGIFFormat1DEvent;
import com.ter.CellularAutomaton.controller.ExportJPGFormat1DEvent;
import com.ter.CellularAutomaton.controller.ExportOthersFormat1DEvent;
import com.ter.CellularAutomaton.controller.ExportPNGFormat1DEvent;
import com.ter.CellularAutomaton.controller.ExportScreenshotGIFFormat1DEvent;
import com.ter.CellularAutomaton.controller.ExportScreenshotJPGFormat1DEvent;
import com.ter.CellularAutomaton.controller.ExportScreenshotOthersFormatFormat1DEvent;
import com.ter.CellularAutomaton.controller.ExportScreenshotPNGFormat1DEvent;
import com.ter.CellularAutomaton.controller.New1DEvent;
import com.ter.CellularAutomaton.controller.NonUniformCellularAutomatonSetting1DEvent;
import com.ter.CellularAutomaton.controller.OpenFileEvent;
import com.ter.CellularAutomaton.controller.PauseSimulation1DEvent;
import com.ter.CellularAutomaton.controller.PrintUISimulatorWindow1DEvent;
import com.ter.CellularAutomaton.controller.PrintUIWindow1DEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;
import com.ter.CellularAutomaton.controller.RadioButtonGridNoEvent;
import com.ter.CellularAutomaton.controller.RadioButtonGridYesEvent;
import com.ter.CellularAutomaton.controller.RefreshSimulation1DEvent;
import com.ter.CellularAutomaton.controller.SaveAs1DEvent;
import com.ter.CellularAutomaton.controller.SizeOfSimulation1DEvent;
import com.ter.CellularAutomaton.controller.SpeedSimulation1DEvent;
import com.ter.CellularAutomaton.controller.StartSimulation1DEvent;
import com.ter.CellularAutomaton.controller.StepOfLauncherStepByStepAdjustable1DEvent;
import com.ter.CellularAutomaton.controller.Switch1DTo2DSimulationEvent;
import com.ter.CellularAutomaton.controller.ZoomSimulation1DEvent;
import com.ter.CellularAutomaton.model.SimulationState;
import com.ter.CellularAutomaton.vue.IForm;
import com.ter.CellularAutomaton.controller.IInitializeSimulationRules1D;
import com.ter.CellularAutomaton.controller.InitializeSimulation1DOneCell;
import com.ter.CellularAutomaton.controller.LaunchByStepAdjustableSimulation1DEvent;
import com.ter.CellularAutomaton.controller.LaunchByStepSimulation1DEvent;
import com.ter.CellularAutomaton.controller.MenubarNonUniformRulesElementary1DEvent;
import com.ter.CellularAutomaton.controller.MenubarRulesElementary1DEvent;
import com.ter.CellularAutomaton.vue.InternalFrameSimulation1D;
import com.ter.CellularAutomaton.vue.RectangleForm1D;
import java.awt.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class MainWindow1D.
 */
public class MainWindow1D extends JFrame implements WindowListener, Serializable {

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
	private JMenuItem m_menuBarFileItemNew = new JMenuItem("New", new ImageIcon("Files/Images/Icons/File_Menu/New_Simulation.png"));

	/** The menu bar file item 2. */
	private JMenuItem m_menuBarFileItemOpenFile = new JMenuItem("Open File", new ImageIcon("Files/Images/Icons/File_Menu/Open.png"));

	/** The menu bar file item Recent File. */
	private JMenuItem m_menuBarFileItemRecentFile = new JMenuItem("Recent File");

	/** The menu bar file item 4. */
	private JMenuItem m_menuBarFileItemSave = new JMenuItem("Save", new ImageIcon("Files/Images/Icons/File_Menu/Save.png"));

	/** The menu bar file item 5. */
	private JMenuItem m_menuBarFileItemSaveAs = new JMenuItem("Save As", new ImageIcon("Files/Images/Icons/File_Menu/Save_As.png"));

	/** The menu bar file item Print. */
	private JMenu m_menuBarFileItemPrint = new JMenu("Print");
	
	/** The menu bar file item Print All window. */
	private JMenuItem m_menuBarFileItemPrintChoicePrintAllWindow = new JMenuItem("Print all window", new ImageIcon("Files/Images/Icons/File_Menu/Print.png"));
	
	/** The menu bar file item Print simulator window. */
	private JMenuItem m_menuBarFileItemPrintChoicePrintSimulatorWindow = new JMenuItem("Print simulator window", new ImageIcon("Files/Images/Icons/File_Menu/Print.png"));
	
	/** The menu bar file item Export. */
	private JMenu m_menuBarFileItemExport = new JMenu("Export As");
	
	/** The menu bar file item Export As choice PNG. */
	private JMenuItem m_menuBarFileItemExportChoicePNG = new JMenuItem("PNG", new ImageIcon("Files/Images/Icons/File_Menu/Export.png"));
	
	/** The menu bar file item Export As choice JPG. */
	private JMenuItem m_menuBarFileItemExportChoiceJPG = new JMenuItem("JPG", new ImageIcon("Files/Images/Icons/File_Menu/Export.png"));
	
	/** The menu bar file item Export As choice GIF. */
	private JMenuItem m_menuBarFileItemExportChoiceGIF = new JMenuItem("GIF", new ImageIcon("Files/Images/Icons/File_Menu/Export.png"));

	/** The menu bar file item Export As choice Others Formats. */
	private JMenuItem m_menuBarFileItemExportChoiceOthersFormats = new JMenuItem("Others Formats", new ImageIcon("Files/Images/Icons/File_Menu/Export.png"));
	
	/** The menu bar file item Export Screenshot As. */
	private JMenu m_menuBarFileItemScreenshot = new JMenu("Export Screenshot As");
	
	/** The menu bar file item Export Screenshot As choice PNG. */
	private JMenuItem m_menuBarFileItemScreenshotChoicePNG = new JMenuItem("PNG", new ImageIcon("Files/Images/Icons/File_Menu/Export.png"));
	
	/** The menu bar file item Export Screenshot As choice JPG. */
	private JMenuItem m_menuBarFileItemScreenshotChoiceJPG = new JMenuItem("JPG", new ImageIcon("Files/Images/Icons/File_Menu/Export.png"));
	
	/** The menu bar file item Export Screenshot As choice GIF. */
	private JMenuItem m_menuBarFileItemScreenshotChoiceGIF = new JMenuItem("GIF", new ImageIcon("Files/Images/Icons/File_Menu/Export.png"));
	
	/** The menu bar file item Export Screenshot As choice Others Formats. */
	private JMenuItem m_menuBarFileItemScreenshotChoiceOthersFormats = new JMenuItem("Others Formats", new ImageIcon("Files/Images/Icons/File_Menu/Export.png"));

	/** The menu bar file item Close. */
	private JMenuItem m_menuBarFileItemClose = new JMenuItem("Close", new ImageIcon("Files/Images/Icons/File_Menu/Close.png"));

	/** The menu bar file item Close All. */
	private JMenuItem m_menuBarFileItemCloseAll = new JMenuItem("Close All", new ImageIcon("Files/Images/Icons/File_Menu/Close.png"));

	/** The menu bar file item Quit. */
	private JMenuItem m_menuBarFileItemQuit = new JMenuItem("Quit");

	/** The menu bar edit item 1. */
	// In edit menu
	private JMenuItem m_menuBarEditItem1 = new JMenuItem("Undo", new ImageIcon("Files/Images/Icons/Edit_Menu/Undo.png"));

	/** The menu bar edit item 2. */
	private JMenuItem m_menuBarEditItem2 = new JMenuItem("Redo", new ImageIcon("Files/Images/Icons/Edit_Menu/Redo.png"));

	/** The menu bar edit item 3. */
	private JMenuItem m_menuBarEditItem3 = new JMenuItem("Cut", new ImageIcon("Files/Images/Icons/Edit_Menu/Cut.png"));

	/** The menu bar edit item 4. */
	private JMenuItem m_menuBarEditItem4 = new JMenuItem("Copy", new ImageIcon("Files/Images/Icons/Edit_Menu/Copy.png"));

	/** The menu bar edit item 5. */
	private JMenuItem m_menuBarEditItem5 = new JMenuItem("Paste", new ImageIcon("Files/Images/Icons/Edit_Menu/Paste.png"));

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
	private JMenuItem m_menuBarRunItem1 = new JMenuItem("Run Current Simulation", new ImageIcon("Files/Images/Icons/Run_Menu/Run.png"));

	/** The menu bar run item 2. */
	private JMenu m_menuBarRunItem2 = new JMenu("Run Specific Screen");

	/** The menu bar run item 3. */
	private JMenuItem m_menuBarRunItem3 = new JMenuItem("Run External Simulation", new ImageIcon("Files/Images/Icons/Run_Menu/Run.png"));

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
	private JMenuItem m_menuBarHelpItem1 = new JMenuItem("Help Contents", new ImageIcon("Files/Images/Icons/Help_Menu/Help.png"));

	/** The menu bar help item 2. */
	private JMenuItem m_menuBarHelpItem2 = new JMenuItem("Credits", new ImageIcon("Files/Images/Favicon/small_penrosecolor.png"));

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
	private ArrayList<Color> m_colorOfCells;
	private Color m_colorGrid;
	
	
	/** Graphic Component */
	private JPanel m_mainPanel;
	private JPanel m_panelTopTools;
	private JToolBar m_mainToolBar;
	private JToolBar m_toolBarTypeCellularAutomaton;
	private JPanel m_panelTypeCellularAutomaton;
	private JSeparator m_separatorInTypeCellularAutomaton;
	private JPanel m_panelChooseCellularAutomaton;
	private JPanel m_panelUniform;
	private JButton m_buttonNonUniformCellularAutomatonSetting;
	private JButton m_buttonUniformCellularAutomatonSetting;
	private JToolBar m_toolBarSimulationTools;
	private JPanel m_panelSimulationTools;
	private final JPanel m_panelLauncher = new JPanel();
	private JButton m_buttonLauncher;
	private final JPanel m_panelPause = new JPanel();
	private JButton m_buttonPause;
	private final JPanel m_panelSkipByStep = new JPanel();
	private JButton m_buttonSkipByStep;
	private final JPanel m_panelSkipByStepAdjustable = new JPanel();
	private JButton m_buttonSkipByStepAdjustable;
	private final JPanel m_panelUndo = new JPanel();
	private JButton m_buttonUndo;
	private final JPanel m_panelRedo = new JPanel();
	private JButton m_buttonRedo;
	private final JPanel m_panelErase = new JPanel();
	private JButton m_buttonErase;
	private final JPanel m_panelReload = new JPanel();
	private JButton m_buttonReload;
	private JToolBar m_toolBarControlTools;
	private JPanel m_panelControlTools;
	private JPanel m_panelSimulationSpeed;
	private JSlider m_sliderSpeedSimulation;
	private final JPanel m_panelLabelSpeedGroup = new JPanel();
	private final JPanel m_panelLabelSpeedBox = new JPanel();
	private final Component verticalStrutLabelSpeed = Box.createVerticalStrut(10);
	private final JPanel m_panelLabelSpeed = new JPanel();
	private final Component horizontalStrutLabelSpeed = Box.createHorizontalStrut(5);
	private JLabel m_labelIndicatorSpeed;
	
	private JPanel m_panelSimulationZoom;
	private JSlider m_sliderZoomSimulation;
	private final JPanel m_panelLabelZoomGroup = new JPanel();
	private final JPanel m_panelLabelZoomBox = new JPanel();
	private final Component verticalStrutLabelZoom = Box.createVerticalStrut(10);
	private final JPanel m_panelLabelZoom = new JPanel();
	private final Component horizontalStrutLabelZoom = Box.createHorizontalStrut(5);
	private JLabel m_labelIndicatorZoom;
	
	private JPanel m_panelStepOfLauncherStepByStepAdjustable;
	private JSlider m_sliderStepOfLauncherStepByStepAdjustable;
	private final JPanel m_panelLabelLauncherStepByStepAdjustableGroup = new JPanel();
	private final JPanel m_panelLabelLauncherStepByStepAdjustableBox = new JPanel();
	private final Component verticalStrutLabelLauncherStepByStepAdjustable = Box.createVerticalStrut(10);
	private final JPanel m_panelLabelLauncherStepByStepAdjustable = new JPanel();
	private final Component horizontalStrutLabelLauncherStepByStepAdjustable = Box.createHorizontalStrut(5);
	private JLabel m_labelIndicatorLauncherStepByStepAdjustable;
	private JButton m_buttonBorderCondition;
	private JDesktopPane m_mainDesktopPane;
	private JScrollPane m_scrollPaneLateralTools;
	private JPanel m_panelLateralTools;
	private JPanel m_panelPropertyOfSimulation = new JPanel();
	private JPanel m_panelSizeOfSimulation;
	private JButton m_buttonSizeOfSimulation;
	private JPanel m_panelBorderCondition;
	private JPanel m_panelSimulationColor = new JPanel();
	private JPanel m_panelColorCells;
	private JButton m_buttonColorCells;
	private JPanel m_panelGrid;
	private ButtonGroup m_radioButtonGrid;
	private JRadioButton m_radioButtonGridNo;
	private JRadioButton m_radioButtonGridYes;
	private JButton m_buttonColorGrid;
	private JPanel m_panelBackgroundColor;
	private JButton m_buttonBackgroundColor;
	private JPanel m_panelAlgorithmGroup = new JPanel();
	private JPanel m_panelAlgorithm;
	private JComboBox m_comboBoxAlgorithm;
	private JPanel m_panelInitialPositionCells;
	private JPanel m_panelInitialPositionCellsGroup = new JPanel();
	private JComboBox m_comboBoxInitialPositionCells;
	private JPanel m_panelFormCellsGroup = new JPanel();
	private JPanel m_panelFormCells;
	private JComboBox m_comboBoxFormCells;
	private JPanel m_panelTypeOfSimulatorGroup = new JPanel();
	private JPanel m_panelTypeOfSimulator;
	private JButton m_buttonTypeOfSimulator;
	private InternalFrameSimulation1D m_internalFrameSimulation;
	
	/**Others */
	private IInitializeSimulationRules1D m_modeInitializeSimulationRule;
	private IForm m_modeForm;
	private SimulationState m_simulationState;
	private boolean m_isRun;
	private Thread m_threadSimulation;
	private boolean m_gridSimulation;
	private int m_stepOfLauncherStep;
	

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
		
		//Build the component of the window
		this.buildComponentWindow();
		
		//add listeners MenuBar
		this.addListenerMenuBar();
		
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
		
		m_colorGrid = new Color(70, 70, 80);
		m_simulationState = SimulationState.PAUSE;
		m_isRun = true;
		m_gridSimulation = false;
		m_stepOfLauncherStep = 10;
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
		
		//Build the component of the window
		this.buildComponentWindow();
		
		//add listeners MenuBar
		this.addListenerMenuBar();
		
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
		
		m_colorGrid = new Color(70, 70, 80);
		m_simulationState = SimulationState.PAUSE;
		m_isRun = true;
		m_gridSimulation = false;
		m_stepOfLauncherStep = 10;
		
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
	
	public SimulationState getm_simulationState() {
		return m_simulationState;
	}
	
	public boolean getm_gridSimulation() {
		return m_gridSimulation;
	}
	
	public Color getm_colorGrid() {
		return m_colorGrid;
	}
	
	public ArrayList<Color> getm_colorOfCells() {
		return m_colorOfCells;
	}
	
	public JLabel getm_labelIndicatorSpeed() {
		return m_labelIndicatorSpeed;
	}
	
	public JLabel getm_labelIndicatorLauncherStepByStepAdjustable() {
		return m_labelIndicatorLauncherStepByStepAdjustable;
	}
	
	public JSlider getm_sliderZoomSimulation() {
		return m_sliderZoomSimulation;
	}
	
	public int getm_stepOfLauncherStep() {
		return m_stepOfLauncherStep;
	}
	
	public JSlider getm_sliderStepOfLauncherStepByStepAdjustable() {
		return m_sliderStepOfLauncherStepByStepAdjustable;
	}
	
	public JLabel getm_labelIndicatorZoom() {
		return m_labelIndicatorZoom;
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
	
	public void setm_colorGrid(Color colorGrid) {
		this.m_colorGrid = colorGrid;
	}
	
	public void setm_colorOfCells(int index, Color newColor) {
		this.m_colorOfCells.set(index, newColor);
	}
	
	public void setm_stepOfLauncherStep(int stepOfLauncherStep) {
		this.m_stepOfLauncherStep = stepOfLauncherStep;
	}
	
	public void setm_sliderStepOfLauncherStepByStepAdjustable(JSlider sliderStepOfLauncherStepByStepAdjustable) {
		this.m_sliderStepOfLauncherStepByStepAdjustable = sliderStepOfLauncherStepByStepAdjustable;
	}
	
	public void setm_labelIndicatorSpeed(JLabel labelIndicatorSpeed) {
		this.m_labelIndicatorSpeed = labelIndicatorSpeed;
	}
	
	

	/**
	 * ****CLASS METHODS*****.
	 */

	/***Set the window***/
	private void setWindow(){
		m_intitialWidth = 1600;
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
		this.m_menuFile.add(m_menuBarFileItemNew);//Adding a tab "New" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItemOpenFile);//Adding a tab "Open File" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItemRecentFile);//Adding a tab "Recent File" in tab File in MenuBar
		this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuFile.add(m_menuBarFileItemSave);//Adding a tab "Save" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItemSaveAs);//Adding a tab "Save As" in tab File in MenuBar
		this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
		constructTabPrint();//Adding a tab "Print" in tab File in MenuBar 
		this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
		constructTabExportAs();
		constructTabExportScreenshotAs();
		this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuFile.add(m_menuBarFileItemClose);//Adding a tab "Close" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItemCloseAll);//Adding a tab "Close All" in tab File in MenuBar
		this.m_menuFile.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuFile.add(m_menuBarFileItemQuit);//Adding a tab "Quit" in tab File in MenuBar
		this.m_menuBar.add(m_menuFile);//the File tab is added to MenuBar
	}
	
	/**
	 * Construct tab in tab ExportAs in tab File.
	 */
	private void constructTabPrint(){
		//Build tab Print in tab File.
		constructSubTabInTabPrint();//Build Sub-group of tabs in tab Print in tab File.
		this.m_menuFile.add(m_menuBarFileItemPrint);//Adding a tab "Print" in tab File in MenuBar
	}
	
	/**
	 * Construct sub tab in tab Print in tab File.
	 */
	private void constructSubTabInTabPrint(){
		//Sub-group of tab in tab Print in tab File.
		this.m_menuBarFileItemPrint.add(m_menuBarFileItemPrintChoicePrintAllWindow);//Adding a tab "Print All Window" in tab File in MenuBar
		this.m_menuBarFileItemPrint.addSeparator();//Adding a separator in sub-group of tab in tab Print in tab File of the MenuBar
		this.m_menuBarFileItemPrint.add(m_menuBarFileItemPrintChoicePrintSimulatorWindow);//Adding a tab "Print simulator Window" in tab File in MenuBar
		
	}
	
	
	/**
	 * Construct tab in tab ExportAs in tab File.
	 */
	private void constructTabExportAs(){
		//Build tab ExportAs in tab File.
		constructSubTabInTabExportAs();//Build Sub-group of tabs in tab ExportAs in tab File.
		this.m_menuFile.add(m_menuBarFileItemExport);//Adding a tab "Export As" in tab File in MenuBar
	}
	
	/**
	 * Construct sub tab in tab ExportAs in tab File.
	 */
	private void constructSubTabInTabExportAs(){
		//Sub-group of tab in tab ExportAs in tab File.
		this.m_menuBarFileItemExport.add(m_menuBarFileItemExportChoicePNG);//Adding a tab "PNG" in tab "Export As"
		this.m_menuBarFileItemExport.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuBarFileItemExport.add(m_menuBarFileItemExportChoiceJPG);//Adding a tab "JPG" in tab "Export As"
		this.m_menuBarFileItemExport.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuBarFileItemExport.add(m_menuBarFileItemExportChoiceGIF);//Adding a tab "GIF" in tab "Export As"
		this.m_menuBarFileItemExport.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuBarFileItemExport.add(m_menuBarFileItemExportChoiceOthersFormats);//Adding a tab "GIF" in tab "Export As"
	}
	
	/**
	 * Construct tab in tab ExportAs in tab File.
	 */
	private void constructTabExportScreenshotAs(){
		//Build tab "Export Screenshot As" in tab File.
		constructSubTabInTabExportScreenshotAs();//Build Sub-group of tabs in tab Export Screenshot As in tab File.
		this.m_menuFile.add(m_menuBarFileItemScreenshot);//Adding a tab "Export Screenshot As" in tab File in MenuBar
	}
	
	/**
	 * Construct sub tab in tab ExportAs in tab File.
	 */
	private void constructSubTabInTabExportScreenshotAs(){
		//Sub-group of tab in tab "Export Screenshot As" in tab File.
		this.m_menuBarFileItemScreenshot.add(m_menuBarFileItemScreenshotChoicePNG);//Adding a tab "PNG" in tab "Export Screenshot As"
		this.m_menuBarFileItemScreenshot.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuBarFileItemScreenshot.add(m_menuBarFileItemScreenshotChoiceJPG);//Adding a tab "JPG" in tab "Export Screenshot As"
		this.m_menuBarFileItemScreenshot.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuBarFileItemScreenshot.add(m_menuBarFileItemScreenshotChoiceGIF);//Adding a tab "GIF" in tab "Export Screenshot As"
		this.m_menuBarFileItemScreenshot.addSeparator();//Adding a separator in tab File of the MenuBar
		this.m_menuBarFileItemScreenshot.add(m_menuBarFileItemScreenshotChoiceOthersFormats);//Adding a tab "GIF" in tab "Export Screenshot As"
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
		m_menuBarFileItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK)); //add accelerators of New in tab File
		m_menuBarFileItemOpenFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK)); //add accelerators of Open File in tab File
		m_menuBarFileItemPrintChoicePrintAllWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK)); //add accelerators of print in tab File
		m_menuBarFileItemExportChoicePNG.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export PNG" in tab File
		m_menuBarFileItemExportChoiceJPG.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export JPG" in tab File
		m_menuBarFileItemExportChoiceGIF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export GIF" in tab File
		m_menuBarFileItemExportChoiceOthersFormats.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export Others formats" in tab File
		m_menuBarFileItemScreenshotChoicePNG.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export ScreenShot As PNG" in tab File
		m_menuBarFileItemScreenshotChoiceJPG.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export ScreenShot As JPG" in tab File
		m_menuBarFileItemScreenshotChoiceGIF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export ScreenShot As GIF" in tab File
		m_menuBarFileItemScreenshotChoiceOthersFormats.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.ALT_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of "Export ScreenShot As Others formats" in tab File
		m_menuBarFileItemClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK)); //add accelerators of Close in tab File
		m_menuBarFileItemCloseAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK)); //add accelerators of CloseAll in tab File
		m_menuBarFileItemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK)); //add accelerators of Quit in tab File
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
		this.addListenerNonUniformRules(); //add listener of tab Non Uniform Rules
		this.addListenerRun(); //add listener of tab Run
		this.addListenerHelp(); //add listener of tab Help
	}

	//Listener of tab File
	private void addListenerFile (){
		m_menuBarFileItemNew.addActionListener(new New1DEvent());//Add ActionListener on tab "New" in tab "File"
		m_menuBarFileItemOpenFile.addActionListener(new OpenFileEvent(this));//Add ActionListener on tab "Open File" in tab "File"
		m_menuBarFileItemSaveAs.addActionListener(new SaveAs1DEvent(this));//Add ActionListener on tab "Save As" in tab "File"
		m_menuBarFileItemPrintChoicePrintAllWindow.addActionListener(new PrintUIWindow1DEvent(this));//Add ActionListener on tab "Print" in tab "File"
		m_menuBarFileItemPrintChoicePrintSimulatorWindow.addActionListener(new PrintUISimulatorWindow1DEvent(this));//Add ActionListener on tab "Print" in tab "File"
		m_menuBarFileItemExportChoicePNG.addActionListener(new ExportPNGFormat1DEvent(this));//Add ActionListener on tab "PNG" of the tab "Export As" in tab "File"
		m_menuBarFileItemExportChoiceJPG.addActionListener(new ExportJPGFormat1DEvent(this));//Add ActionListener on tab "JPG" of the tab "Export As" in tab "File"
		m_menuBarFileItemExportChoiceGIF.addActionListener(new ExportGIFFormat1DEvent(this));//Add ActionListener on tab "GIF" of the tab "Export As" in tab "File"
		m_menuBarFileItemExportChoiceOthersFormats.addActionListener(new ExportOthersFormat1DEvent(this));//Add ActionListener on tab "Others Formats" of the tab "Export As" in tab "File"
		m_menuBarFileItemScreenshotChoicePNG.addActionListener(new ExportScreenshotPNGFormat1DEvent(this));//Add ActionListener on tab "PNG" of the tab "Export Screenshot As" in tab "File"
		m_menuBarFileItemScreenshotChoiceJPG.addActionListener(new ExportScreenshotJPGFormat1DEvent(this));//Add ActionListener on tab "JPG" of the tab "Export Screenshot As" in tab "File"
		m_menuBarFileItemScreenshotChoiceGIF.addActionListener(new ExportScreenshotGIFFormat1DEvent(this));//Add ActionListener on tab "GIF" of the tab "Export Screenshot As" in tab "File"
		m_menuBarFileItemScreenshotChoiceOthersFormats.addActionListener(new ExportScreenshotOthersFormatFormat1DEvent(this));//Add ActionListener on tab "Others Formats" of the tab "Export Screenshot As" in tab "File"
		m_menuBarFileItemClose.addActionListener(new Close1DEvent(this));//Add ActionListener on tab "Close" in tab "File"
		m_menuBarFileItemCloseAll.addActionListener(new CloseAllEvent());//Add ActionListener on tab "Close All" in tab "File"
		m_menuBarFileItemQuit.addActionListener(new QuitEvent());//Add ActionListener on tab "Quit" in tab "File"
	}
	
	//Listener of tab Rules
	private void addListenerRules (){
		m_menuBarRulesItem1.addActionListener(new MenubarRulesElementary1DEvent(this));//Add ActionListener on tab "Elementary" in tab "Rules"
	}
	
	//Listener of tab Non Uniform Rules
	private void addListenerNonUniformRules (){
		m_menuBarNonUniformRulesItem1.addActionListener(new MenubarNonUniformRulesElementary1DEvent(this));//Add ActionListener on tab "Elementary" in tab "Non Uniform Rules"
	}
	
	//Listener of tab Run
		private void addListenerRun (){
			m_menuBarRunItem1.addActionListener(new StartSimulation1DEvent(this));//Add ActionListener on tab "Run current simulation" in tab "Run"
		}

	//Listener of tab Help
	private void addListenerHelp (){
		m_menuBarHelpItem2.addActionListener(new CreditsEvent());//Add ActionListener on tab "Credits" in tab "Help"
	}
	
	/******Build Windows******/
	
	private void buildComponentWindow(){
		m_mainPanel = new JPanel();
		this.getContentPane().add(m_mainPanel, BorderLayout.CENTER);
		m_mainPanel.setLayout(new BorderLayout(0, 0));
		
		m_mainToolBar = new JToolBar();
		m_mainPanel.add(m_mainToolBar, BorderLayout.NORTH);
		
		m_panelTopTools = new JPanel();
		m_panelTopTools.setBorder(BorderFactory.createRaisedBevelBorder());//Set a border of JPanel
		m_mainToolBar.add(m_panelTopTools);
		
		buildTypeCellularAutomaton();//Build the ToolBar of TypeCellularAutomaton
		
		buildSimulationTools();//Build the ToolBar of SimulationTools
		
		buildControlTools();//Build the ToolBar of ControlTools
		
		buildDesktopPane();//Build the DestopPane of window
		
		buildInternalFrameSimulation();//Build the InternalFrame witch contain the simulation
		
		buildLateralTools();//Build the panel of LateralTools
		
	}
	
	private void buildTypeCellularAutomaton(){
		buildToolBarTypeCellularAutomaton();//Build the toolBar of TypeCellularAutomaton
	}
	
	private void buildToolBarTypeCellularAutomaton(){
		m_panelTopTools.setLayout(new BoxLayout(m_panelTopTools, BoxLayout.X_AXIS));
		m_toolBarTypeCellularAutomaton = new JToolBar();//Creation of toolBar TypeCellularAutomaton
		m_panelTopTools.add(m_toolBarTypeCellularAutomaton);//Add the toolBar to panel of the mainToolBar
		
		buildPanelTypeCellularAutomaton();//Build the panel of the toolBar TypeCellularAutomaton
	}
	
	private void buildPanelTypeCellularAutomaton(){
		m_panelTypeCellularAutomaton = new JPanel();
		Dimension minimumWidthPanelTypeCellularAutomaton = new Dimension(430, 0);
		m_panelTypeCellularAutomaton.setPreferredSize(minimumWidthPanelTypeCellularAutomaton);
		m_toolBarTypeCellularAutomaton.add(m_panelTypeCellularAutomaton);
		m_panelTypeCellularAutomaton.setBorder(BorderFactory.createTitledBorder("Type of Cellular Automaton"));
		
		buildSeparatorInTypeCellularAutomaton();//Build the separator of the toolBar TypeCellularAutomaton
		
		buildPanelChooseCellularAutomaton();//Build the panel ChooseCellularAutomaton
		
		buildPanelUniform();//Build the panel Uniform
		
		buildGroupLayoutPanelTypeCellularAutomaton();//Build the GroupLayout of the panel TypeCellularAutomaton
	}
	
	private void buildSeparatorInTypeCellularAutomaton(){
		//Build the separator of the toolBar TypeCellularAutomaton
		m_separatorInTypeCellularAutomaton = new JSeparator();
		m_separatorInTypeCellularAutomaton.setOrientation(SwingConstants.VERTICAL);
	}
	
	private void buildPanelChooseCellularAutomaton(){
		//Build the panel ChooseCellularAutomaton
		m_panelChooseCellularAutomaton = new JPanel();
		m_panelChooseCellularAutomaton.setBorder(BorderFactory.createTitledBorder("Uniform Cellular Automaton"));
		m_panelChooseCellularAutomaton.setLayout(new BorderLayout(0, 0));
		
		buildComponentChooseCellularAutomaton();//Build the component of the panel ChooseCellularAutomaton
	}
	
	private void buildComponentChooseCellularAutomaton(){
		//Build the component of the panel ChooseCellularAutomaton
		m_buttonUniformCellularAutomatonSetting = new JButton("Uniform Rules");
		m_buttonUniformCellularAutomatonSetting.setToolTipText("Choose the global rule of the simulation");
		m_panelChooseCellularAutomaton.add(m_buttonUniformCellularAutomatonSetting, BorderLayout.CENTER);
	}
	
	private void buildPanelUniform(){
		//Build the panel Uniform
		m_panelUniform = new JPanel();
		m_panelUniform.setBorder(BorderFactory.createTitledBorder("Non Uniform Cellular Automaton"));
		m_panelUniform.setLayout(new BorderLayout(0, 0));
		
		buildComponentUniform();//Build the component of the panel Uniform
	}
	
	private void buildComponentUniform(){
		//Build the component of the panel Uniform
		m_buttonNonUniformCellularAutomatonSetting = new JButton("Non Uniform Rules");
		m_buttonNonUniformCellularAutomatonSetting.setToolTipText("Choose a local rule in the simulation");
		m_panelUniform.add(m_buttonNonUniformCellularAutomatonSetting, BorderLayout.CENTER);
	}
	
	private void buildGroupLayoutPanelTypeCellularAutomaton(){
		m_panelTypeCellularAutomaton.setLayout(new BoxLayout(m_panelTypeCellularAutomaton, BoxLayout.X_AXIS));
		m_panelTypeCellularAutomaton.add(m_panelChooseCellularAutomaton);
		m_panelTypeCellularAutomaton.add(m_separatorInTypeCellularAutomaton);
		m_panelTypeCellularAutomaton.add(m_panelUniform);
	}
	
	
	
	private void buildSimulationTools(){
		buildSimulationTools("Files/Images/Simulation_Tools/");
	}
	
	private void buildSimulationTools(String pathDirectory){
		m_toolBarSimulationTools = new JToolBar();
		m_panelTopTools.add(m_toolBarSimulationTools);
		
		m_panelSimulationTools = new JPanel();
		m_toolBarSimulationTools.add(m_panelSimulationTools);
		m_panelSimulationTools.setBorder(BorderFactory.createTitledBorder("Simulation Tools"));
		m_panelSimulationTools.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		m_panelLauncher.setLayout(new BorderLayout(0, 0));
		m_panelSimulationTools.add(m_panelLauncher);
		m_buttonLauncher = new JButton(new ImageIcon(pathDirectory+"button_laucher.png"));
		m_buttonLauncher.setToolTipText("Launch the simulation");
		m_panelLauncher.add(m_buttonLauncher, BorderLayout.CENTER);
		
		m_panelPause.setLayout(new BorderLayout(0, 0));
		m_panelSimulationTools.add(m_panelPause);
		m_buttonPause = new JButton(new ImageIcon(pathDirectory+"button_pause.png"));
		m_buttonPause.setToolTipText("Pause the simulation");
		m_panelPause.add(m_buttonPause, BorderLayout.CENTER);
		
		m_panelSkipByStep.setLayout(new BorderLayout(0, 0));
		m_panelSimulationTools.add(m_panelSkipByStep);
		m_buttonSkipByStep = new JButton(new ImageIcon(pathDirectory+"button_skipByStep.png"));
		m_buttonSkipByStep.setToolTipText("Launch simulation step by step");
		m_panelSkipByStep.add(m_buttonSkipByStep, BorderLayout.CENTER);
		
		m_panelSkipByStepAdjustable.setLayout(new BorderLayout(0, 0));
		m_panelSimulationTools.add(m_panelSkipByStepAdjustable);
		m_buttonSkipByStepAdjustable = new JButton(new ImageIcon(pathDirectory+"button_skipByStepAdjustable.png"));
		m_buttonSkipByStepAdjustable.setToolTipText("Launch simulation step by step with step adjustable");
		m_panelSkipByStepAdjustable.add(m_buttonSkipByStepAdjustable, BorderLayout.CENTER);
		
		m_panelUndo.setLayout(new BorderLayout(0, 0));
		m_panelSimulationTools.add(m_panelUndo);
		m_buttonUndo = new JButton(new ImageIcon(pathDirectory+"button_undo.png"));
		m_buttonUndo.setToolTipText("Undo");
		m_panelUndo.add(m_buttonUndo, BorderLayout.CENTER);
		
		m_panelRedo.setLayout(new BorderLayout(0, 0));
		m_panelSimulationTools.add(m_panelRedo);
		m_buttonRedo = new JButton(new ImageIcon(pathDirectory+"button_redo.png"));
		m_buttonRedo.setToolTipText("Redo");
		m_panelRedo.add(m_buttonRedo, BorderLayout.CENTER);
		
		m_panelErase.setLayout(new BorderLayout(0, 0));
		m_panelSimulationTools.add(m_panelErase);
		m_buttonErase = new JButton(new ImageIcon(pathDirectory+"button_erase.png"));
		m_buttonErase.setToolTipText("Clear simulation");
		m_panelErase.add(m_buttonErase, BorderLayout.CENTER);
		
		m_panelReload.setLayout(new BorderLayout(0, 0));
		m_panelSimulationTools.add(m_panelReload);
		m_buttonReload = new JButton(new ImageIcon(pathDirectory+"button_reload.png"));
		m_buttonReload.setToolTipText("Refresh simulation");
		m_panelReload.add(m_buttonReload, BorderLayout.CENTER);
	}
	
	
	
	private void buildControlTools(){
		buildToolBarControlTools();//Build the ToolBar of ControlTools
	}
	
	
	private void buildToolBarControlTools(){
		m_toolBarControlTools = new JToolBar();//Creation of toolBar
		m_panelTopTools.add(m_toolBarControlTools);//Add the toolBar to panel of the mainToolBar
		
		buildPanelControlTools();//Build the panel in the ToolBar ControlTools
	}
	
	//build the Panel ControlTools
	private void buildPanelControlTools(){
		m_panelControlTools = new JPanel();//Creation of panel
		m_toolBarControlTools.add(m_panelControlTools);//Add the panel to toolBar ControlTools
		m_panelControlTools.setBorder(BorderFactory.createTitledBorder("Control tools"));
		m_panelControlTools.setLayout(new BoxLayout(m_panelControlTools, BoxLayout.X_AXIS));
		
		buildPanelSimulationSpeed();//Create the panel "SimulationSpeed"
		
		buildPanelSimulationZoom();//Create the panel "SimulationZoom"
		
		buildPanelStepOfLauncherStepByStepAdjustable();//Create the panel "StepOfLauncherStepByStepAdjustable"
		
		buildIndicatorSpeed();//Build indicator of speed simulation
		
		buildIndicatorZoom();//Build indicator of zoom simulation
		
		buildIndicatorStepOfLauncherStepByStepAdjustable();//Build indicator step of launcher step by step adjustable
		
		m_panelControlTools.add(m_panelSimulationSpeed);
		
		m_panelControlTools.add(m_panelSimulationZoom);
		
		m_panelControlTools.add(m_panelStepOfLauncherStepByStepAdjustable);
	}
	
	//Build indicator of speed simulation
	private void buildIndicatorSpeed(){
		m_panelSimulationSpeed.add(m_panelLabelSpeedGroup, BorderLayout.EAST);
		m_panelLabelSpeedGroup.setLayout(new BoxLayout(m_panelLabelSpeedGroup, BoxLayout.Y_AXIS));
		
		m_panelLabelSpeedGroup.add(m_panelLabelSpeedBox);
		m_panelLabelSpeedBox.setLayout(new BoxLayout(m_panelLabelSpeedBox, BoxLayout.X_AXIS));
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		m_panelLabelSpeedBox.add(separator);
		
		Component horizontalStrut = Box.createHorizontalStrut(5);
		m_panelLabelSpeedBox.add(horizontalStrut);
		
		m_panelLabelSpeedBox.add(m_panelLabelSpeed);
		m_panelLabelSpeed.setLayout(new BorderLayout(0, 0));
		
		m_labelIndicatorSpeed =new JLabel("30");
		m_labelIndicatorSpeed.setToolTipText("Indicator of speed: 30");
		m_panelLabelSpeed.add(m_labelIndicatorSpeed, BorderLayout.CENTER);
		m_panelLabelSpeed.setBorder(BorderFactory.createRaisedBevelBorder());
		m_panelLabelSpeedBox.add(horizontalStrutLabelSpeed);
		
		m_panelLabelSpeedGroup.add(verticalStrutLabelSpeed);
	}
	
	//Build indicator of zoom simulation
		private void buildIndicatorZoom(){
			m_panelSimulationZoom.add(m_panelLabelZoomGroup, BorderLayout.EAST);
			m_panelLabelZoomGroup.setLayout(new BoxLayout(m_panelLabelZoomGroup, BoxLayout.Y_AXIS));
			
			m_panelLabelZoomGroup.add(m_panelLabelZoomBox);
			m_panelLabelZoomBox.setLayout(new BoxLayout(m_panelLabelZoomBox, BoxLayout.X_AXIS));
			
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			m_panelLabelZoomBox.add(separator);
			
			Component horizontalStrut = Box.createHorizontalStrut(5);
			m_panelLabelZoomBox.add(horizontalStrut);
			
			m_panelLabelZoomBox.add(m_panelLabelZoom);
			m_panelLabelZoom.setLayout(new BorderLayout(0, 0));
			
			m_labelIndicatorZoom =new JLabel("20%");
			m_labelIndicatorZoom.setToolTipText("Indicator of Zoom: 20%");
			m_panelLabelZoom.add(m_labelIndicatorZoom, BorderLayout.CENTER);
			m_panelLabelZoom.setBorder(BorderFactory.createRaisedBevelBorder());
			m_panelLabelZoomBox.add(horizontalStrutLabelZoom);
			
			m_panelLabelZoomGroup.add(verticalStrutLabelZoom);
		}
	
	//Build indicator of step of launcher step by step adjustable
		private void buildIndicatorStepOfLauncherStepByStepAdjustable(){
			m_panelStepOfLauncherStepByStepAdjustable.add(m_panelLabelLauncherStepByStepAdjustableGroup, BorderLayout.EAST);
			m_panelLabelLauncherStepByStepAdjustableGroup.setLayout(new BoxLayout(m_panelLabelLauncherStepByStepAdjustableGroup, BoxLayout.Y_AXIS));
			
			m_panelLabelLauncherStepByStepAdjustableGroup.add(m_panelLabelLauncherStepByStepAdjustableBox);
			m_panelLabelLauncherStepByStepAdjustableBox.setLayout(new BoxLayout(m_panelLabelLauncherStepByStepAdjustableBox, BoxLayout.X_AXIS));
			
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			m_panelLabelLauncherStepByStepAdjustableBox.add(separator);
			
			Component horizontalStrut = Box.createHorizontalStrut(5);
			m_panelLabelLauncherStepByStepAdjustableBox.add(horizontalStrut);
			
			m_panelLabelLauncherStepByStepAdjustableBox.add(m_panelLabelLauncherStepByStepAdjustable);
			m_panelLabelLauncherStepByStepAdjustable.setLayout(new BorderLayout(0, 0));
			
			m_labelIndicatorLauncherStepByStepAdjustable =new JLabel("10");
			m_labelIndicatorLauncherStepByStepAdjustable.setToolTipText("Indicator of step of launcher step by step adjustable: 10");
			m_panelLabelLauncherStepByStepAdjustable.add(m_labelIndicatorLauncherStepByStepAdjustable, BorderLayout.CENTER);
			m_panelLabelLauncherStepByStepAdjustable.setBorder(BorderFactory.createRaisedBevelBorder());
			m_panelLabelLauncherStepByStepAdjustableBox.add(horizontalStrutLabelLauncherStepByStepAdjustable);
			
			m_panelLabelLauncherStepByStepAdjustableGroup.add(verticalStrutLabelLauncherStepByStepAdjustable);
		}
	
	/******PANEL SIMULATION SPEED******/
	/******Build Panel SimulationSpeed******/
	private void buildPanelSimulationSpeed(){
		m_panelSimulationSpeed = new JPanel();//Creation of panel for SimulationSpeed
		m_panelSimulationSpeed.setBorder(BorderFactory.createTitledBorder("Simulation Speed"));//Set a border of JPanel
		
		buildComponentSimulationSpeed();//Set the component of Panel "Simulation Speed"
	}
	
		//Components of Panel SimulationSpeed in LateralTools
		//Build components for SimulationSpeed in LateralTools
		private void buildComponentSimulationSpeed(){ 
			m_sliderSpeedSimulation = new JSlider();//Creation of Slider for panel "Simulation Speed"
			m_sliderSpeedSimulation.setToolTipText("Speed of simulation");//Set a ToolTipText on m_sliderSpeedSimulation
			m_sliderSpeedSimulation.setMinimum(1);//Set the minimum value of slider
			m_sliderSpeedSimulation.setMaximum(100);//Set the maximum value of slider
			m_sliderSpeedSimulation.setValue(30);//Set the value of slider to 30 by default
			m_sliderSpeedSimulation.setPaintTicks(true);//Set the paint ticks of slider
			m_sliderSpeedSimulation.setMinorTickSpacing(10);//Set the space between each ticks of slider to 10
			m_sliderSpeedSimulation.setMajorTickSpacing(20);//Set the space between each major ticks of slider to 20
		
			buildGroupLayoutComponentSimulationSpeed();//Build Layout for SimulationSpeed in LateralTools
		}
		
		//Build Layout for SimulationSpeed in LateralTools
		private void buildGroupLayoutComponentSimulationSpeed(){
			m_panelSimulationSpeed.setLayout(new BorderLayout(0, 0));
			m_panelSimulationSpeed.add(m_sliderSpeedSimulation);//Add the slider to panel m_panelSimulationSpeed
		}
		
		/******PANEL SIMULATION ZOOM******/
		/******Build Panel SimulationZoom******/
		private void buildPanelSimulationZoom(){
			m_panelSimulationZoom = new JPanel();//Creation of panel for SimulationZoom
			m_panelSimulationZoom.setBorder(BorderFactory.createTitledBorder("Zoom of the Simulation"));//Set a border of JPanel
			
			buildComponentSimulationZoom();//Set the component of Panel "Simulation Zoom"
		}
		
			//Components of Panel SimulationZoom in LateralTools
			//Build components for SimulationZoom in LateralTools
			private void buildComponentSimulationZoom(){ 
				m_sliderZoomSimulation = new JSlider();//Creation of Slider for panel "Simulation Zoom"
				m_sliderZoomSimulation.setToolTipText("Zoom of the simulation");//Set a ToolTipText on m_sliderZoomSimulation
				m_sliderZoomSimulation.setMinimum(1);//Set the minimum value of slider
				m_sliderZoomSimulation.setMaximum(11);//Set the maximum value of slider
				m_sliderZoomSimulation.setValue(3);//Set the value of slider to 21 by default
				m_sliderZoomSimulation.setPaintTicks(true);//Set the paint ticks of slider
				m_sliderZoomSimulation.setMinorTickSpacing(1);//Set the space between each ticks of slider to 10
				m_sliderZoomSimulation.setMajorTickSpacing(2);//Set the space between each major ticks of slider to 20
			
				buildGroupLayoutComponentSimulationZoom();//Build Layout for SimulationZoom in LateralTools
			}
			
			//Build Layout for SimulationZoom in LateralTools
			private void buildGroupLayoutComponentSimulationZoom(){
				m_panelSimulationZoom.setLayout(new BorderLayout(0, 0));
				m_panelSimulationZoom.add(m_sliderZoomSimulation);//Add the slider to panel m_panelSimulationZoom
			}
		
		
		/******PANEL STEP OF LAUNCHER STEP BY STEP ADJUSTABLE******/
		/******Build Panel Launcher step by step adjustable******/
		private void buildPanelStepOfLauncherStepByStepAdjustable(){
			m_panelStepOfLauncherStepByStepAdjustable = new JPanel();//Creation of panel for StepOfLauncherStepByStepAdjustable
			m_panelStepOfLauncherStepByStepAdjustable.setBorder(BorderFactory.createTitledBorder("Step of launcher step by step"));//Set a border of JPanel
			
			buildComponentStepOfLauncherStepByStepAdjustable();//Set the component of Panel "Step Of Launcher Step By Step Adjustable"
		}
		
			//Components of Panel Launcher step by step adjustable in LateralTools
			//Build components for Launcher step by step adjustable in LateralTools
			private void buildComponentStepOfLauncherStepByStepAdjustable(){ 
				m_sliderStepOfLauncherStepByStepAdjustable = new JSlider();//Creation of Slider for panel "Step Of Launcher Step By Step Adjustable"
				m_sliderStepOfLauncherStepByStepAdjustable.setToolTipText("Step of launcher step by step adjustable");//Set a ToolTipText on m_sliderStepOfLauncherStepByStepAdjustable
				m_sliderStepOfLauncherStepByStepAdjustable.setMinimum(1);//Set the minimum value of slider
				m_sliderStepOfLauncherStepByStepAdjustable.setMaximum(100);//Set the maximum value of slider
				m_sliderStepOfLauncherStepByStepAdjustable.setValue(10);//Set the value of slider to 30 by default
				m_sliderStepOfLauncherStepByStepAdjustable.setPaintTicks(true);//Set the paint ticks of slider
				m_sliderStepOfLauncherStepByStepAdjustable.setMinorTickSpacing(10);//Set the space between each ticks of slider to 10
				m_sliderStepOfLauncherStepByStepAdjustable.setMajorTickSpacing(20);//Set the space between each major ticks of slider to 20
			
				buildGroupLayoutComponentStepOfLauncherStepByStepAdjustable();//Build Layout for StepOfLauncherStepByStepAdjustable in LateralTools
			}
			
			//Build Layout for SimulationSpeed in LateralTools
			private void buildGroupLayoutComponentStepOfLauncherStepByStepAdjustable(){
				m_panelStepOfLauncherStepByStepAdjustable.setLayout(new BorderLayout(0, 0));
				m_panelStepOfLauncherStepByStepAdjustable.add(m_sliderStepOfLauncherStepByStepAdjustable);//Add the slider to panel m_panelStepOfLauncherStepByStepAdjustable
			}
	
	
	/******Build DesktopPane******/
	private void buildDesktopPane(){
		m_mainDesktopPane = new JDesktopPane();
		m_mainPanel.add(m_mainDesktopPane, BorderLayout.CENTER);
	}
	
	
	/******Build InternalFrameSimulation******/
	private void buildInternalFrameSimulation(){
		m_modeForm = new RectangleForm1D(this);
		m_colorOfCells = new ArrayList<Color>();
		m_colorOfCells.add(Color.BLACK);
		m_colorOfCells.add(Color.BLUE);
		Color backgroundColor = Color.GRAY;
		m_modeInitializeSimulationRule = new InitializeSimulation1DOneCell();
		buildInternalFrameSimulation(m_modeForm, m_colorOfCells, backgroundColor, m_modeInitializeSimulationRule);
	}
	
	private void buildInternalFrameSimulation(IForm formOfCells, ArrayList<Color> colorOfCells, Color backgroundColor, IInitializeSimulationRules1D initializeSimulationRule){
		m_internalFrameSimulation = new InternalFrameSimulation1D("Simulation", formOfCells, colorOfCells, backgroundColor, initializeSimulationRule, this);
		m_internalFrameSimulation.setVisible(true);
		m_mainDesktopPane.setLayout(null);
		m_mainDesktopPane.add(m_internalFrameSimulation);
	}
	
	/******Build LateralTools******/
	private void buildLateralTools(){
		buildPanelLateralTools();//Build the panel "Lateral Tools"
	}
	
	
	/******Build Panel LateralTools and its components******/
	private void buildPanelLateralTools(){		
		m_panelLateralTools = new JPanel();//Create a JPanel for the "Lateral Tools"
		m_panelLateralTools.setPreferredSize(new Dimension(180, 2*getHeight()));

		m_scrollPaneLateralTools = new JScrollPane(m_panelLateralTools);//Create a JScrollPane for the "Lateral Tools" and add the panel m_panelLateralTools to panel m_mainPanel
		m_scrollPaneLateralTools.setPreferredSize(new Dimension(200, getHeight()));
		m_mainPanel.add(m_scrollPaneLateralTools, BorderLayout.EAST);//Add the panel m_panelLateralTools to panel m_mainPanel
		
		buildPanelPropertyOfSimulation();//Create the panel "PropertyOfSimulation"
		
		buildPanelSimulationColor();//Create the panel "SimulationColor"
		
		buildPanelAlgorithm();//Create the panel "Algorithm"
		
		buildPanelInitialPositionCells();//Create the panel "InitialPositionCells"
		
		buildPanelFormCells();//Create the panel "FormCells"
		
		buildPanelTypeOfSimulator();//Create the panel "TypeOfSimulator"
		
		buildGroupLayoutPanelLateralTools();//Create the GroupLayout for the disposition of the panel "Lateral Tools"
	}
	
	
	/******PANEL PROPERTY OF SIMULATION******/
	/******Build Panel Property Of Simulation******/
	private void buildPanelPropertyOfSimulation(){
		m_panelPropertyOfSimulation.setLayout(new BorderLayout(0, 0));
		m_panelPropertyOfSimulation.setBounds(0, 0, 180, 161);
		m_panelPropertyOfSimulation.setBorder(BorderFactory.createRaisedBevelBorder());//Set a border of JPanel
		
		JPanel panelPropertyOfSimulation = new JPanel();
		panelPropertyOfSimulation.setLayout(null);
		panelPropertyOfSimulation.setBorder(BorderFactory.createTitledBorder("Property of the simulation"));//Set a border of JPanel
		
		buildPanelSizeOfSimulation();//Set the panel Size Of Simulation
		
		buildPanelBorderCondition();//Set the panel BorderCondition
		
		panelPropertyOfSimulation.add(m_panelSizeOfSimulation);
		panelPropertyOfSimulation.add(m_panelBorderCondition);
		
		m_panelPropertyOfSimulation.add(panelPropertyOfSimulation);
	}
	
	/******Build Panel Size Of Simulation******/
	private void buildPanelSizeOfSimulation(){
		m_panelSizeOfSimulation = new JPanel();
		m_panelSizeOfSimulation.setBounds(10, 21, 158, 55);
		m_panelSizeOfSimulation.setBorder(BorderFactory.createTitledBorder("Size of Simulation"));//Set a border of JPanel
		
		buildComponentSizeOfSimulation();//Set the component of Panel "Size of Simulation"
	}
	
	//Components of Panel SizeOfSimulation in LateralTools
	private void buildComponentSizeOfSimulation(){
		m_panelSizeOfSimulation.setLayout(new BorderLayout(0, 0));//The component take full place of panel
		m_buttonSizeOfSimulation = new JButton("Size of Simulation");//Creation of Button for panel "Size of Simulation"
		m_panelSizeOfSimulation.add(m_buttonSizeOfSimulation);//Add the radioButton m_radioButtonContinuous to panel m_panelSimulationMode
	}
	
	/******Build Panel BorderCondition******/
	private void buildPanelBorderCondition(){
		m_panelBorderCondition = new JPanel();
		m_panelBorderCondition.setBounds(10, 90, 158, 55);
		m_panelBorderCondition.setBorder(BorderFactory.createTitledBorder("Border Condition"));//Set a border of JPanel
		
		buildComponentBorderCondition();//Set the component of Panel "BorderCondition"
	}
	
	//Components of Panel BorderCondition in LateralTools
	//Build components for BorderCondition in LateralTools
	private void buildComponentBorderCondition(){ 
		m_panelBorderCondition.setLayout(new BorderLayout(0, 0));
		m_buttonBorderCondition = new JButton("Border Condition");//Creation of Button for panel "BorderCondition"
		m_panelBorderCondition.add(m_buttonBorderCondition);//Add the Button to panel BorderCondition
	}
	
	
	/******PANEL SIMULATION COLOR******/
	/******Build Panel Simulation Color******/
	private void buildPanelSimulationColor(){
		m_panelSimulationColor.setLayout(new BorderLayout(0, 0));
		m_panelSimulationColor.setBounds(0, 163, 180, 264);
		m_panelSimulationColor.setBorder(BorderFactory.createRaisedBevelBorder());//Set a border of JPanel
		
		JPanel panelSimulationColor = new JPanel();
		panelSimulationColor.setLayout(null);
		panelSimulationColor.setBorder(BorderFactory.createTitledBorder("Color of simulation"));//Set a border of JPanel
		
		buildPanelColorCells();//Create the panel "ColorCells"
		
		buildPanelGrid();//Create the panel "Grid"
		
		buildPanelBackgroundColor();//Create the panel "BackgroundColor"
		
		panelSimulationColor.add(m_panelColorCells);
		panelSimulationColor.add(m_panelGrid);
		panelSimulationColor.add(m_panelBackgroundColor);
		
		m_panelSimulationColor.add(panelSimulationColor);
	}	
	
	/******Build Panel ColorCells******/
	private void buildPanelColorCells(){
		m_panelColorCells = new JPanel();//Create the panel ColorCells
		m_panelColorCells.setBounds(10, 21, 158, 55);
		m_panelColorCells.setBorder(BorderFactory.createTitledBorder("Color of Cells"));//Set a border for the panel ColorCells
		
		buildComponentLateralToolsColorCells();//Create components of panel ColorCells in the LateralTools
	}
	
	//Components of Panel ColorCells in LateralTools
		//Build components for ColorCells in LateralTools
		private void buildComponentLateralToolsColorCells(){
			m_buttonColorCells = new JButton("Color Cells Setting");
			
			buildGroupLayoutComponentColorCells();
		}
		
		//Build Layout for ColorCells in LateralTools
		private void buildGroupLayoutComponentColorCells(){
			m_panelColorCells.setLayout(new BorderLayout(0, 0));
			m_panelColorCells.add(m_buttonColorCells);
		}
		
		/******Build Panel Grid******/
		private void buildPanelGrid(){
			m_panelGrid = new JPanel();//Create the panel TypeOfSimulator
			m_panelGrid.setBounds(13, 90, 158, 90);
			m_panelGrid.setBorder(BorderFactory.createTitledBorder("Grid On Simulation"));
					
			buildComponentLateralToolsGrid();//Create components of panel TypeOfSimulator in the LateralTools
		}
		
		//Components of Panel Grid in LateralTools
		//Build components for Grid in LateralTools
		private void buildComponentLateralToolsGrid(){
			m_panelGrid.setLayout(null);
			m_radioButtonGridNo = new JRadioButton("No");
			m_radioButtonGridNo.setBounds(18, 21, 50, 23);
			m_radioButtonGridNo.setToolTipText("Disable the grid on simulation");
			m_radioButtonGridNo.setSelected(true);//Set a CheckBox "All" to true by default
			m_panelGrid.add(m_radioButtonGridNo);
			
			m_radioButtonGridYes = new JRadioButton("yes");
			m_radioButtonGridYes.setBounds(90, 21, 50, 23);
			m_radioButtonGridYes.setToolTipText("Enable the grid on simulation");
			m_panelGrid.add(m_radioButtonGridYes);
			
			m_radioButtonGrid = new ButtonGroup();
			m_radioButtonGrid.add(m_radioButtonGridNo);
			m_radioButtonGrid.add(m_radioButtonGridYes);
			
			m_buttonColorGrid = new JButton("Color of grid");
			m_buttonColorGrid.setToolTipText("Choose color of the grid");
			m_buttonColorGrid.setBounds(10, 47, 136, 32);
			m_panelGrid.add(m_buttonColorGrid);
			
		}
		
		
		/******Build Panel BackgroundColor******/
		private void buildPanelBackgroundColor(){
			m_panelBackgroundColor = new JPanel();
			m_panelBackgroundColor.setBounds(10, 194, 158, 55);
			m_panelBackgroundColor.setBorder(BorderFactory.createTitledBorder("Background Color"));
			
			buildComponentLateralToolsBackgroundColor();//Create components of panel BackgroundColor in the LateralTools
		}
	
		//Components of Panel BackgroundColor in LateralTools
		//Build components for BackgroundColor in LateralTools
		private void buildComponentLateralToolsBackgroundColor(){
			m_buttonBackgroundColor = new JButton("Background Color");
			m_buttonBackgroundColor.setToolTipText("Choose color of the background");
			
			buildGroupLayoutComponentBackgroundColor();
		}
		
		//Build Layout for BackgroundColor in LateralTools
		private void buildGroupLayoutComponentBackgroundColor(){
			m_panelBackgroundColor.setLayout(new BorderLayout(0, 0));
			m_panelBackgroundColor.add(m_buttonBackgroundColor, BorderLayout.CENTER);
		}
		
		
		/******PANEL ALGORITHM******/
		/******Build Panel Algorithm******/
		private void buildPanelAlgorithm(){
			m_panelAlgorithmGroup.setLayout(new BorderLayout(0, 0));
			m_panelAlgorithmGroup.setBounds(0, 429, 180, 71);
			m_panelAlgorithmGroup.setBorder(BorderFactory.createRaisedBevelBorder());//Set a border of JPanel
			
			m_panelAlgorithm = new JPanel();//Create the panel Algorithm
			m_panelAlgorithm.setBorder(BorderFactory.createTitledBorder("Algorithm"));//Set a border for the panel Algorithm
			
			buildComponentLateralToolsAlgorithm();//Create components of panel Algorithm in the LateralTools
			
			m_panelAlgorithmGroup.add(m_panelAlgorithm);
		}
		
		//Components of Panel Algorithm in LateralTools
		//Build components for Algorithm in LateralTools
		private void buildComponentLateralToolsAlgorithm(){
			m_comboBoxAlgorithm = new JComboBox();
			m_comboBoxAlgorithm.setBounds(16, 27, 143, 20);
			
			buildGroupLayoutComponentAlgorithm();//Build the grouplayout for the component Algorithm
		}
		
		//Build Layout for Algorithm in LateralTools
		private void buildGroupLayoutComponentAlgorithm(){
			m_panelAlgorithm.setLayout(null);
			m_panelAlgorithm.add(m_comboBoxAlgorithm);
		}

	/******PANEL INITIALPOSITIONCELLS******/
	/******Build Panel InitialPositionCells******/
	private void buildPanelInitialPositionCells(){
		m_panelInitialPositionCellsGroup.setLayout(new BorderLayout(0, 0));
		m_panelInitialPositionCellsGroup.setBounds(0, 502, 180, 71);
		m_panelInitialPositionCellsGroup.setBorder(BorderFactory.createRaisedBevelBorder());//Set a border of JPanel
		
		m_panelInitialPositionCells = new JPanel();//Create the panel InitialPositionCells
		m_panelInitialPositionCells.setBorder(BorderFactory.createTitledBorder("Initial Position of Cells"));//Set a border for the panel InitialPositionCells
		
		buildComponentLateralToolsInitialPositionCells();//Create components of panel InitialPositionCells in the LateralTools
	
		m_panelInitialPositionCellsGroup.add(m_panelInitialPositionCells);
	}
	
	//Components of Panel InitialPositionCells in LateralTools
		//Build components for InitialPositionCells in LateralTools
		private void buildComponentLateralToolsInitialPositionCells(){
			m_comboBoxInitialPositionCells = new JComboBox(m_stringInitialPositionCells);
			m_comboBoxInitialPositionCells.setBounds(16, 27, 126, 20);
			
			buildGroupLayoutComponentInitialPositionCells();
		}
		
		//Build Layout for InitialPositionCells in LateralTools
		private void buildGroupLayoutComponentInitialPositionCells(){
			m_panelInitialPositionCells.setLayout(null);
			m_panelInitialPositionCells.add(m_comboBoxInitialPositionCells);
		}
	
	/******PANEL FORMCELLS******/
	/******Build Panel FormCells******/
	private void buildPanelFormCells(){
		m_panelFormCellsGroup.setLayout(new BorderLayout(0, 0));
		m_panelFormCellsGroup.setBounds(0, 575, 180, 71);
		m_panelFormCellsGroup.setBorder(BorderFactory.createRaisedBevelBorder());//Set a border of JPanel
		
		m_panelFormCells = new JPanel();//Create the panel FormCells
		m_panelFormCells.setBorder(BorderFactory.createTitledBorder("Form of Cells"));//Set a border for the panel FormCells
		
		buildComponentLateralToolsFormCells();//Create components of panel FormCells in the LateralTools
		
		m_panelFormCellsGroup.add(m_panelFormCells);
	}
	
	//Components of Panel FormCells in LateralTools
		//Build components for FormCells in LateralTools
		private void buildComponentLateralToolsFormCells(){
			m_comboBoxFormCells = new JComboBox(m_stringFormCells);
			m_comboBoxFormCells.setBounds(16, 27, 126, 20);
			
			buildGroupLayoutComponentFormCells();
		}
		
		//Build Layout for FormCells in LateralTools
		private void buildGroupLayoutComponentFormCells(){
				m_panelFormCells.setLayout(null);
				m_panelFormCells.add(m_comboBoxFormCells);
		}
	
	
	/******PANEL TYPE OF SIMULATEUR******/
	/******Build Panel TypeOfSimulator******/
	private void buildPanelTypeOfSimulator(){
		m_panelTypeOfSimulatorGroup.setLayout(new BorderLayout(0, 0));
		m_panelTypeOfSimulatorGroup.setBounds(0, 648, 180, 55);
		m_panelTypeOfSimulatorGroup.setBorder(BorderFactory.createRaisedBevelBorder());//Set a border of JPanel
		
		m_panelTypeOfSimulator = new JPanel();
		m_panelTypeOfSimulator.setBounds(10, 922, 158, 55);
		m_panelTypeOfSimulator.setBorder(BorderFactory.createTitledBorder("Type Of Simulator"));//Set a border for the panel TypeOfSimulator
		
		buildComponentLateralToolsTypeOfSimulator();//Create components of panel TypeOfSimulator in the LateralTools
		
		m_panelTypeOfSimulatorGroup.add(m_panelTypeOfSimulator);
	}
	
	//Components of Panel TypeOfSimulator in LateralTools
		//Build components for TypeOfSimulator in LateralTools
		private void buildComponentLateralToolsTypeOfSimulator(){
			m_buttonTypeOfSimulator = new JButton("Switch to 2D");
			m_buttonTypeOfSimulator.setToolTipText("Switch to 2D simulation");
			
			buildGroupLayoutComponentTypeOfSimulator();
		}
		
		//Build Layout for TypeOfSimulator in LateralTools
		private void buildGroupLayoutComponentTypeOfSimulator(){
			m_panelTypeOfSimulator.setLayout(new BorderLayout(0, 0));
			m_panelTypeOfSimulator.add(m_buttonTypeOfSimulator);
		}
	
	
	/******Layout for all components of LateralTools******/
	//Build Layout for components of Panel LateralTools
	private void buildGroupLayoutPanelLateralTools(){
		m_panelLateralTools.setLayout(null);
		m_panelLateralTools.add(m_panelPropertyOfSimulation);
		m_panelLateralTools.add(m_panelSimulationColor);
		m_panelLateralTools.add(m_panelAlgorithmGroup);
		m_panelLateralTools.add(m_panelInitialPositionCellsGroup);
		m_panelLateralTools.add(m_panelFormCellsGroup);
		m_panelLateralTools.add(m_panelTypeOfSimulatorGroup);		
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
		addListenerSkipByStep();//add listener of button Launch By Step
		addListenerSkipByStepAdjustable();//add listener of button Launch By Step Adjustable
		this.addListenerErase();//add listener of button Erase
		this.addListenerRefresh();//add listener of button Refresh
	}

	private void addListenerLaucher(){
		m_buttonLauncher.addActionListener(new StartSimulation1DEvent(this));
	}
	
	private void addListenerPause(){
		m_buttonPause.addActionListener(new PauseSimulation1DEvent(this));
	}
	
	private void addListenerSkipByStep(){
		m_buttonSkipByStep.addActionListener(new LaunchByStepSimulation1DEvent(this));
	}
	
	private void addListenerSkipByStepAdjustable(){
		m_buttonSkipByStepAdjustable.addActionListener(new LaunchByStepAdjustableSimulation1DEvent(this));
	}
	
	private void addListenerErase(){
		m_buttonErase.addActionListener(new EraseSimulation1DEvent(this));
	}
	
	private void addListenerRefresh(){
		m_buttonReload.addActionListener(new RefreshSimulation1DEvent(this));
	}
	
	
	
	/******Listeners Control Tools******/
	private void addListenerControlTools(){
		addListenerSliderSpeedSimulation();//add listener of Slider sliderSpeedSimulation
		addListenerSliderZoomSimulation();//add listener of Slider sliderZoomSimulation
		addListenerSliderStepOfLauncherStepByStepAdjustable();//add listener of Slider StepOfLauncherStepByStepAdjustable
	}
	
	private void addListenerSliderSpeedSimulation(){
		m_sliderSpeedSimulation.addChangeListener(new SpeedSimulation1DEvent(this));
	}
	
	private void addListenerSliderZoomSimulation(){
		m_sliderZoomSimulation.addChangeListener(new ZoomSimulation1DEvent(this));
	}
	
	private void addListenerSliderStepOfLauncherStepByStepAdjustable(){
		m_sliderStepOfLauncherStepByStepAdjustable.addChangeListener(new StepOfLauncherStepByStepAdjustable1DEvent(this));
	}
	
	
	
	
	
	/******Listeners Lateral Tools******/
	private void addListenerLateralTools(){
		addListenerSizeOfSimulation();//add listener of Button SizeOfSimulation
		addListenerRadioButtonGrid();//add listener of Radio Button Grid
		addListenerColorGrid();//add listener of Button Color Grid
		addListenerColorBackground();//add listener of Button Color Background
		addListenerComboBoxInitialPositionCells();//add listener of ComboBox InitialPositionCells
		addListenerComboBoxFormCells();//add listener of ComboBox FormCells
		addListenerSwitchTo2D();//add listener of button TypeOfSimulator
	}
	
	private void addListenerSizeOfSimulation(){
		m_buttonSizeOfSimulation.addActionListener(new SizeOfSimulation1DEvent(this));
	}
	
	private void addListenerRadioButtonGrid(){
		m_radioButtonGridNo.addActionListener(new RadioButtonGridNoEvent(this));
		m_radioButtonGridYes.addActionListener(new RadioButtonGridYesEvent(this));
	}
	
	private void addListenerColorGrid(){
		m_buttonColorGrid.addActionListener(new ChooseColorGridEvent(this));
	}
	
	private void addListenerColorBackground(){
		m_buttonBackgroundColor.addActionListener(new ChooseColorBackgroundEvent(this));
	}
	
	private void addListenerComboBoxInitialPositionCells(){
		m_comboBoxInitialPositionCells.addItemListener(new ComboBoxInitialPositionCellsEvent(this));
	}
	
	private void addListenerComboBoxFormCells(){
		m_comboBoxFormCells.addItemListener(new ComboBoxFormCellsEvent(this));
	}
	
	private void addListenerSwitchTo2D(){
		m_buttonTypeOfSimulator.addActionListener(new Switch1DTo2DSimulationEvent(this));
	}
	
	
	

	
	
	public void runSimulation() {
		while(m_isRun){
			if(m_simulationState == SimulationState.RUN){
					m_internalFrameSimulation.startUpdate();//The simulation of the window start
			}
			else if(m_simulationState == SimulationState.PAUSE){
				m_internalFrameSimulation.startUpdate();//The simulation of the window start
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
