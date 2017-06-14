package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.LocalElementaryRulesWindow;
import com.ter.CellularAutomaton.vue.MainWindow1D;
import com.ter.CellularAutomaton.vue.NonUniformRulesEntryModeWindow;

public class NonUniformRulesEntryModeElementaryEvent implements ActionListener {


	/******ATTRIBUTES******/
	private NonUniformRulesEntryModeWindow m_window;
	private LocalElementaryRulesWindow m_localElementaryRulesWindow;
	MainWindow1D m_currentSimulator;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public NonUniformRulesEntryModeElementaryEvent(NonUniformRulesEntryModeWindow window, MainWindow1D currentSimulator) {
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
		m_localElementaryRulesWindow = new LocalElementaryRulesWindow(m_currentSimulator);
		
	}

	
}
