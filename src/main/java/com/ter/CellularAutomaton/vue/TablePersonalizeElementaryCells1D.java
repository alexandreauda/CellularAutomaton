package com.ter.CellularAutomaton.vue;


import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is like TableDemo, except that it substitutes a
 * Favorite Color column for the Last Name column and specifies
 * a custom cell renderer and editor for the color data.
 */
public class TablePersonalizeElementaryCells1D extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	private ColorRenderer m_colorRenderer;
	private ColorEditor m_colorEditor;
    private boolean m_DEBUG = false;
    private CustomTableElementaryModel1D m_customTableModel;
    
    /******GETTERS******/
	public CustomTableElementaryModel1D getm_customTableModel() {
		return m_customTableModel;
	}
	
	public ColorRenderer getm_colorRenderer() {
		return m_colorRenderer;
	}
	
	public ColorEditor getm_colorEditor() {
		return m_colorEditor;
	}

    /******CONSTRUCTOR******/
    public TablePersonalizeElementaryCells1D(MainWindow1D window) {
        super(new GridLayout(1,0));
        m_window = window;
        m_colorRenderer = new ColorRenderer(true);
        m_colorEditor = new ColorEditor(m_window, this);
    	m_customTableModel = new CustomTableElementaryModel1D(m_DEBUG);

        JTable table = new JTable(m_customTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 31));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Set up renderer and editor for the Favorite Color column.
        table.setDefaultRenderer(Color.class, m_colorRenderer);
        table.setDefaultEditor(Color.class, m_colorEditor);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

}
