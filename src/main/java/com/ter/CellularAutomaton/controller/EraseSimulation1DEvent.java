package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.MainWindow1D;

public class EraseSimulation1DEvent implements ActionListener  {
	/******ATTRIBUTES******/
	private MainWindow1D m_mainWindow1D;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public EraseSimulation1DEvent(MainWindow1D window) {
		super();
		this.m_mainWindow1D = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().resetSimulation();
	}
}
