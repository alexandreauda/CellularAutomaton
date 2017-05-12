package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.UniformRulesEntryModeWindow;

public class CloseRulesEntryModeWindowEvent implements ActionListener {


	/******ATTRIBUTES******/
	private UniformRulesEntryModeWindow window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CloseRulesEntryModeWindowEvent(UniformRulesEntryModeWindow window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.dispose();
		
	}

	
}
