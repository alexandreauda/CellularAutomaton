package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.model.SimulationState;
import com.ter.CellularAutomaton.vue.MainWindow2D;

public class StartSimulation2DEvent implements ActionListener {
	
	/******ATTRIBUTES******/
	private MainWindow2D m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public StartSimulation2DEvent(MainWindow2D window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_window.setm_threadSimulation(new Thread(new RunApplication2D(m_window)));
		this.m_window.getm_threadSimulation().start();
		this.m_window.setm_simulationState(SimulationState.RUN);
	}
}
