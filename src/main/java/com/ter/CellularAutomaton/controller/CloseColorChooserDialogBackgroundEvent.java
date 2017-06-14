package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ColorChooserDialogBackground;

public class CloseColorChooserDialogBackgroundEvent implements ActionListener {


	/******ATTRIBUTES******/
	private ColorChooserDialogBackground m_colorChooserDialogBackground;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CloseColorChooserDialogBackgroundEvent(ColorChooserDialogBackground colorChooserDialogGrid) {
		super();
		this.m_colorChooserDialogBackground = colorChooserDialogGrid;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_colorChooserDialogBackground.dispose();
	}

	
}
