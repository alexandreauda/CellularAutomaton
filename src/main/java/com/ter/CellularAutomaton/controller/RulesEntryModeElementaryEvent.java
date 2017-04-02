package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;
import com.ter.CellularAutomaton.vue.MainWindow1D;
import com.ter.CellularAutomaton.vue.RulesEntryModeWindow;

public class RulesEntryModeElementaryEvent implements ActionListener {


	/******ATTRIBUTES******/
	private RulesEntryModeWindow m_window;
	private ElementaryRulesWindow m_elementaryRulesWindow;
	MainWindow1D m_currentSimulator;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public RulesEntryModeElementaryEvent(RulesEntryModeWindow window, MainWindow1D currentSimulator) {
		super();
		this.m_window = window;
		this.m_currentSimulator = currentSimulator;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_window.dispose();
		m_elementaryRulesWindow = new ElementaryRulesWindow(m_currentSimulator);
		
	}

	
}
