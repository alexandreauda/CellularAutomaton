package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.NonUniformRulesEntryModeWindow;

public class NonUniformRulesEntryModePatternEvent implements ActionListener {


	/******ATTRIBUTES******/
	NonUniformRulesEntryModeWindow m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public NonUniformRulesEntryModePatternEvent(NonUniformRulesEntryModeWindow window) {
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
