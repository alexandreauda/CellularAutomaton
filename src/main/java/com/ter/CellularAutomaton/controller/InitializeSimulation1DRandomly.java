package com.ter.CellularAutomaton.controller;

import java.util.Random;

import com.ter.CellularAutomaton.vue.Simulation1D;

public class InitializeSimulation1DRandomly implements IInitializeSimulationRules1D {

	@Override
	public void initializeSimulation(Simulation1D simulation) {
		Random random = new Random();
		//For each cell in first line of the simulation
		for(int x = 0;x < simulation.getm_nbCellWidth();x++) {
			simulation.getCellInSimulation(x, 0).setm_state(random.nextInt(2));//Set attribute m_state randomly of cells in first line of the simulation
        }
	}

}
