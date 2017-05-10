package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.NonUniformRulesEntryModeWindow;
import com.ter.CellularAutomaton.vue.RulesEntryModeWindow;

public class CloseNonUniformRulesEntryModeWindowEvent implements ActionListener {


	/******ATTRIBUTES******/
	private NonUniformRulesEntryModeWindow window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CloseNonUniformRulesEntryModeWindowEvent(NonUniformRulesEntryModeWindow window) {
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
