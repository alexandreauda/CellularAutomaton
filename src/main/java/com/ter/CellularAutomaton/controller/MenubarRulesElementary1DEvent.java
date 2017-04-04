package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;
import com.ter.CellularAutomaton.vue.MainWindow1D;

public class MenubarRulesElementary1DEvent implements ActionListener {


	/******ATTRIBUTES******/
	private ElementaryRulesWindow m_elementaryRulesWindow;
	MainWindow1D m_currentSimulator;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public MenubarRulesElementary1DEvent(MainWindow1D currentSimulator) {
		super();
		this.m_currentSimulator = currentSimulator;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		m_elementaryRulesWindow = new ElementaryRulesWindow(m_currentSimulator);
		
	}

	
}
