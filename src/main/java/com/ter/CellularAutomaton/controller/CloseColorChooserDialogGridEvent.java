package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ColorChooserDialogGrid;
import com.ter.CellularAutomaton.vue.MainWindow1D;

public class CloseColorChooserDialogGridEvent implements ActionListener {


	/******ATTRIBUTES******/
	private ColorChooserDialogGrid m_colorChooserDialogGrid;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CloseColorChooserDialogGridEvent(ColorChooserDialogGrid colorChooserDialogGrid) {
		super();
		this.m_colorChooserDialogGrid = colorChooserDialogGrid;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_colorChooserDialogGrid.dispose();
	}

	
}
