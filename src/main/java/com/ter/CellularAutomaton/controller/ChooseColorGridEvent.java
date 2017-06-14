package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ColorChooserDialogGrid;
import com.ter.CellularAutomaton.vue.MainWindow1D;

public class ChooseColorGridEvent implements ActionListener {


	/******ATTRIBUTES******/
	private ColorChooserDialogGrid m_colorChooserDialogGrid;
	MainWindow1D m_currentMainWindow;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public ChooseColorGridEvent(MainWindow1D currentMainWindow) {
		super();
		this.m_currentMainWindow = currentMainWindow;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		m_colorChooserDialogGrid = new ColorChooserDialogGrid(m_currentMainWindow);
		
	}

	
}
