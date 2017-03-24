package com.ter.CellularAutomaton.controller;

import java.awt.Color;
import java.util.Random;

import com.ter.CellularAutomaton.vue.IForm;

public class InitializeSimulation1DRandomly implements IInitializeSimulationRules {

	@Override
	public void initializeSimulation(Cell[][] cells, int nbCellWidth, int nbCellHeight, IRules cellularAutomaton, IForm formOfCells, Color colorOfCells) {
		Random random = new Random();
		for(int x = 0;x < nbCellWidth;x++) {
                cells[x] [0] = new Cell(x, 0, random.nextBoolean(), cellularAutomaton, formOfCells, colorOfCells);//Create randomly cells in the simulation witch is a matrix of cells which follows a certain set of rules
        }
        for(int x = 0;x < nbCellWidth;x++) {
            for (int y = 1; y < nbCellHeight; y++) {
                cells[x] [y] = new Cell(x, y, false, cellularAutomaton, formOfCells, colorOfCells);//Create randomly cells in the simulation witch is a matrix of cells which follows a certain set of rules
            }
        }
	}

}
