package com.ter.CellularAutomaton.controller;

import com.ter.CellularAutomaton.vue.Simulation1D;

public class InitializeSimulation1DThreeCells implements IInitializeSimulationRules1D {

	@Override
	public void initializeSimulation(Simulation1D simulation) {
		simulation.getCellInSimulation(simulation.getm_nbCellWidth()/3, 0).setm_state(1);//Set attribute m_state of the cell to 1/3 of simulation in first line of the simulation
		simulation.getCellInSimulation(simulation.getm_nbCellWidth()/2, 0).setm_state(1);//Set attribute m_state of the center cell in first line of the simulation
		simulation.getCellInSimulation(2*simulation.getm_nbCellWidth()/3, 0).setm_state(1);//Set attribute m_state of the center cell in first line of the simulation
	}

}
