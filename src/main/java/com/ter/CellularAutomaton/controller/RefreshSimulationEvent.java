package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.model.SimulationState;
import com.ter.CellularAutomaton.vue.MainWindow2D;

public class RefreshSimulationEvent implements ActionListener {

	/******ATTRIBUTES******/
	private MainWindow2D window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public RefreshSimulationEvent(MainWindow2D window) {
		super();
		this.window = window;
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.getm_internalFrameSimulation().getm_simulation().getm_initializeSimulationRule().initializeSimulation(this.window.getm_internalFrameSimulation().getm_simulation().getm_cells(), this.window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth(), this.window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight(), this.window.getm_internalFrameSimulation().getm_simulation().getm_cellularAutomaton(), this.window.getm_internalFrameSimulation().getm_simulation().getm_formOfCells(), this.window.getm_internalFrameSimulation().getm_simulation().getm_colorOfCells());
		this.window.getm_internalFrameSimulation().startUpdate();
		this.window.setm_simulationState(SimulationState.STOP);
	}

}
