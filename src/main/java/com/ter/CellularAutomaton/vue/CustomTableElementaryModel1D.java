package com.ter.CellularAutomaton.vue;

import java.awt.Color;

import javax.swing.table.AbstractTableModel;

public class CustomTableElementaryModel1D extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/******ATTRIBUTES******/
	private boolean m_DEBUG = false;
    private String[] columnNames = {"Alphabet", "Color", "Comment"};
    
    private Object[][] m_settingCells = {
        {new Integer(0), new Color(0, 0, 0), "none"},
        {new Integer(1), new Color(0, 0, 255), "none"},
    };
    
    public CustomTableElementaryModel1D(boolean DEBUG){
    	m_DEBUG = DEBUG;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return m_settingCells.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Color getColorDeadCell(){
    	return (Color) m_settingCells[0][1];
    }
    
    public Color getColorLifeCell(){
    	return (Color) m_settingCells[1][1];
    }

    public Object getValueAt(int row, int col) {
        return m_settingCells[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 1) {
            return false;
        } else {
            return true;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        if (m_DEBUG) {
            System.out.println("Setting value at " + row + "," + col
                               + " to " + value
                               + " (an instance of "
                               + value.getClass() + ")");
        }

        m_settingCells[row][col] = value;
        fireTableCellUpdated(row, col);

        if (m_DEBUG) {
            System.out.println("New value of data:");
            printDebugData();
        }
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + m_settingCells[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
