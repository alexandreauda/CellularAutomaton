package com.ter.CellularAutomaton.vue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import com.ter.CellularAutomaton.controller.CellPreviewModel;
import com.ter.CellularAutomaton.controller.CellPreviewPanel;
import com.ter.CellularAutomaton.controller.CloseColorChooserDialogGridEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;


public class ColorChooserDialogGrid extends JDialog {
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
	
    private JColorChooser m_colorChooser;
    private JComboBox m_comboBoxChoiceComponent;

    private CellPreviewPanel m_PreviewCell;

    private Color m_cellColor;
    private Color m_backgroundColor;
    private Color m_gridColor;

    boolean m_setCellColor;
    boolean m_setBackgroundColor;
    boolean m_setGridColor;

    private static final String m_stringColorGrid = "Grid";
    private static final String m_stringPreviewColorCell = "Preview Color Cells";
    private static final String m_stringPreviewColorBackground = "Preview Color Background";

    public ColorChooserDialogGrid(MainWindow1D window) {
    	this.setTitle("Choose color of grid");//Define a title to the window    
		this.setSize(450,300);//Initial size of the window
		this.setLocationRelativeTo(null);//We now ask our window to position itself at the center.
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.initMenuMnemonic();//Set mnemonic of the MenuBar
		
		this.initMenuBar();//We initialize our menuBar
		
		this.addListenerMenuBar();//We initialize Listener of menuBar
		
    	m_window = window;

        JPanel panelForComboBoxChoiceComponent = new JPanel();
        panelForComboBoxChoiceComponent.setLayout(new FlowLayout());
        panelForComboBoxChoiceComponent.setBorder(BorderFactory.createTitledBorder("Set color for"));

        m_comboBoxChoiceComponent = new JComboBox();
        m_comboBoxChoiceComponent.addItem(m_stringColorGrid);
        m_comboBoxChoiceComponent.addItem(m_stringPreviewColorCell);
        m_comboBoxChoiceComponent.addItem(m_stringPreviewColorBackground);

        m_comboBoxChoiceComponent.addItemListener(new SelectElementListener());

        panelForComboBoxChoiceComponent.add(m_comboBoxChoiceComponent);//Add comboBox in panel panelForComboBoxChoiceComponent

        m_colorChooser = new JColorChooser();
        
        JPanel previewPanel = new JPanel();//Create panel for preview
        previewPanel.setLayout(new FlowLayout());//Set Layout on panel for preview

        CellPreviewModel model = new CellPreviewModel(3,3);
        m_PreviewCell = new CellPreviewPanel(model, 20);
        model.flipCell(1, 1);

        previewPanel.add(m_PreviewCell);
        
        previewPanel.setSize(m_PreviewCell.getSize());
        previewPanel.setBorder(BorderFactory.createEmptyBorder(0,0,1,0));

        m_colorChooser.setPreviewPanel(previewPanel);

        m_colorChooser.getSelectionModel().addChangeListener(new PreviewListener());

        JPanel buttonBar = new JPanel();
        buttonBar.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new SetColorListener());

        cancelButton.addActionListener(new CancelListener());

        buttonBar.add(cancelButton);
        buttonBar.add(okButton);

        getContentPane().add(panelForComboBoxChoiceComponent, BorderLayout.NORTH);
        getContentPane().add(m_colorChooser, BorderLayout.CENTER);
        getContentPane().add(buttonBar, BorderLayout.SOUTH);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
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
		m_menuBarFileItem1.addActionListener(new CloseColorChooserDialogGridEvent(this));
		m_menuBarFileItem2.addActionListener(new QuitEvent());
	}

    final private class SetColorListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            if (m_setGridColor) {
            	m_window.setm_colorGrid(m_gridColor);
            }
            dispose();
        }
    }
    
    final private class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            dispose();
        }
    }

    final private class SelectElementListener implements ItemListener {
        public void itemStateChanged(ItemEvent evt) {
        	//if Cell is selected in m_comboBoxChoiceComponent
            if (m_comboBoxChoiceComponent.getSelectedItem().equals(m_stringPreviewColorCell)) {
                m_colorChooser.setColor(m_PreviewCell.getForeground());
            }
          //if background is selected in m_comboBoxChoiceComponent
            else if (m_comboBoxChoiceComponent.getSelectedItem().equals(m_stringPreviewColorBackground)) {
                m_colorChooser.setColor(m_PreviewCell.getBackground());
            }
          //if grid is selected in m_comboBoxChoiceComponent
            else if (m_comboBoxChoiceComponent.getSelectedItem().equals(m_stringColorGrid)) {
                m_colorChooser.setColor(m_PreviewCell.getOutline());
            }

            m_PreviewCell.repaint();
        }
    }

    
    final private class PreviewListener implements ChangeListener {
    	//if user choose a color
        public void stateChanged(ChangeEvent evt) {
        	//if Cell is selected in m_comboBoxChoiceComponent
            if (m_comboBoxChoiceComponent.getSelectedItem().equals(m_stringPreviewColorCell)) {
                m_cellColor = m_colorChooser.getColor();
                m_setCellColor = true;
                m_PreviewCell.setForeground(m_cellColor);
            }
          //if background is selected in m_comboBoxChoiceComponent
            else if (m_comboBoxChoiceComponent.getSelectedItem().equals(m_stringPreviewColorBackground)) {
                m_backgroundColor = m_colorChooser.getColor();
                m_setBackgroundColor = true;
                m_PreviewCell.setBackground(m_backgroundColor);
            }
          //if grid is selected in m_comboBoxChoiceComponent
            else if (m_comboBoxChoiceComponent.getSelectedItem().equals(m_stringColorGrid)) {
                m_gridColor = m_colorChooser.getColor();
                m_setGridColor = true;
                m_PreviewCell.setOutline(m_gridColor);
            }

            m_PreviewCell.repaint();//Repaint 
        }
    }
}
