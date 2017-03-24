package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;
import com.ter.CellularAutomaton.vue.RulesEntryModeWindow;

public class RulesEntryModeElementaryEvent implements ActionListener {


	/******ATTRIBUTES******/
	private RulesEntryModeWindow m_window;
	private ElementaryRulesWindow m_elementaryRulesWindow;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public RulesEntryModeElementaryEvent(RulesEntryModeWindow window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_window.dispose();
		m_elementaryRulesWindow = new ElementaryRulesWindow();
		
	}

	
}
