package com.ter.CellularAutomaton.vue;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;

public class ColorRenderer extends JLabel implements TableCellRenderer {
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/******ATTRIBUTES******/
	
	Border m_unselectedBorder = null;
    Border m_selectedBorder = null;
    boolean m_isBordered = true;
    Color m_newColor;
    

    public void setm_newColor(Color newColor) {
    	m_newColor = newColor;
    }
    
    public ColorRenderer(boolean isBordered) {
        this.m_isBordered = isBordered;
        setOpaque(true); //MUST do this for background to show up.
    }

    public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
        m_newColor = (Color)color;
        setBackground(m_newColor);
        if (m_isBordered) {
            if (isSelected) {
                if (m_selectedBorder == null) {
                    m_selectedBorder = BorderFactory.createMatteBorder(2,5,2,5, table.getSelectionBackground());
                }
                setBorder(m_selectedBorder);
            } else {
                if (m_unselectedBorder == null) {
                    m_unselectedBorder = BorderFactory.createMatteBorder(2,5,2,5, table.getBackground());
                }
                setBorder(m_unselectedBorder);
            }
        }
        
        setToolTipText("RGB value: " + m_newColor.getRed() + ", " + m_newColor.getGreen() + ", "+ m_newColor.getBlue());
        return this;
    }
}
