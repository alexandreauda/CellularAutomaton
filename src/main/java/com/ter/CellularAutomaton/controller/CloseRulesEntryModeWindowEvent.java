package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.RulesEntryModeWindow;

public class CloseRulesEntryModeWindowEvent implements ActionListener {


	/******ATTRIBUTES******/
	private RulesEntryModeWindow window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CloseRulesEntryModeWindowEvent(RulesEntryModeWindow window) {
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
