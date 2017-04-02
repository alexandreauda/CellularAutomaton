package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.model.SimulationState;
import com.ter.CellularAutomaton.vue.MainWindow2D;

public class StartSimulation2DEvent implements ActionListener {
	
	/******ATTRIBUTES******/
	private MainWindow2D window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public StartSimulation2DEvent(MainWindow2D window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.setm_simulationState(SimulationState.RUN);
	}
}
