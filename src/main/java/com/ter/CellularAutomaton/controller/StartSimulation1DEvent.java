package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.model.SimulationState;
import com.ter.CellularAutomaton.vue.MainWindow1D;

public class StartSimulation1DEvent implements ActionListener {
	
	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public StartSimulation1DEvent(MainWindow1D window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_window.setm_threadSimulation(null);
		this.m_window.setm_simulationState(SimulationState.RUN);
		this.m_window.setm_threadSimulation(new Thread(new RunApplication1D(m_window)));
		this.m_window.getm_threadSimulation().start();
	}
}
