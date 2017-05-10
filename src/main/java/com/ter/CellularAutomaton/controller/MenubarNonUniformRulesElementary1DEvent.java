package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.LocalElementaryRulesWindow;
import com.ter.CellularAutomaton.vue.MainWindow1D;

public class MenubarNonUniformRulesElementary1DEvent implements ActionListener {


	/******ATTRIBUTES******/
	private LocalElementaryRulesWindow m_elementaryRulesWindow;
	MainWindow1D m_currentSimulator;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public MenubarNonUniformRulesElementary1DEvent(MainWindow1D currentSimulator) {
		super();
		this.m_currentSimulator = currentSimulator;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		m_elementaryRulesWindow = new LocalElementaryRulesWindow(m_currentSimulator.getm_internalFrameSimulation());
		
	}

	
}
