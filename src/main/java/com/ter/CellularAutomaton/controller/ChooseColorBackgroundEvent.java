package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ColorChooserDialogBackground;
import com.ter.CellularAutomaton.vue.MainWindow1D;

public class ChooseColorBackgroundEvent implements ActionListener {


	/******ATTRIBUTES******/
	private ColorChooserDialogBackground m_colorChooserDialogBackground;
	MainWindow1D m_currentMainWindow;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public ChooseColorBackgroundEvent(MainWindow1D currentMainWindow) {
		super();
		this.m_currentMainWindow = currentMainWindow;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		m_colorChooserDialogBackground = new ColorChooserDialogBackground(m_currentMainWindow);
		
	}

	
}
