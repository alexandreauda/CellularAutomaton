package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.UniformRulesEntryModeWindow;

public class RulesEntryModeScriptEvent implements ActionListener {


	/******ATTRIBUTES******/
	private UniformRulesEntryModeWindow m_window;
	
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public RulesEntryModeScriptEvent(UniformRulesEntryModeWindow window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_window.dispose();
	}

	
}
