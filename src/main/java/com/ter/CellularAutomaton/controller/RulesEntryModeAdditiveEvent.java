package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.RulesEntryModeWindow;

public class RulesEntryModeAdditiveEvent implements ActionListener {


	/******ATTRIBUTES******/
	RulesEntryModeWindow m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public RulesEntryModeAdditiveEvent(RulesEntryModeWindow window) {
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
