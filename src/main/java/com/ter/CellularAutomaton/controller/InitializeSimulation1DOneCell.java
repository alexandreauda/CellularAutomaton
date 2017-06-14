package com.ter.CellularAutomaton.controller;

import java.io.Serializable;

import com.ter.CellularAutomaton.vue.Simulation1D;

public class InitializeSimulation1DOneCell implements IInitializeSimulationRules1D, Serializable {

	@Override
	public void initializeSimulation(Simulation1D simulation) {
		simulation.getCellInSimulation(simulation.getm_nbCellWidth()/2, 0).setm_state(1);//Set attribute m_state of the center cell in first line of the simulation
	}

}
