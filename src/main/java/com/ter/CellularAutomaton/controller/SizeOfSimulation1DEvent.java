package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;
import com.ter.CellularAutomaton.vue.MainWindow1D;
import com.ter.CellularAutomaton.vue.SizeSimulationWindow;

public class SizeOfSimulation1DEvent implements ActionListener {


	/******ATTRIBUTES******/
	private MainWindow1D m_mainWindow1D;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public SizeOfSimulation1DEvent(MainWindow1D mainWindow1D) {
		super();
		this.m_mainWindow1D = mainWindow1D;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SizeSimulationWindow sizeSimulationWindow = new SizeSimulationWindow(m_mainWindow1D);
	}

	
}
