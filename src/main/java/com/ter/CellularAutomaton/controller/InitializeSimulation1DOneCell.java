package com.ter.CellularAutomaton.controller;

import com.ter.CellularAutomaton.vue.Simulation1D;

public class InitializeSimulation1DOneCell implements IInitializeSimulationRules1D {

	@Override
	public void initializeSimulation(Simulation1D simulation) {
		simulation.getCellInSimulation(simulation.getm_nbCellWidth()/2, 0).setm_state(1);//Set attribute m_state randomly of cells in first line of the simulation
	}

}
