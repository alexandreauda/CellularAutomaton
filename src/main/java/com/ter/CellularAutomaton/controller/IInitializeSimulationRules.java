package com.ter.CellularAutomaton.controller;

import java.awt.Color;

import com.ter.CellularAutomaton.vue.IForm;

@FunctionalInterface
public interface IInitializeSimulationRules {
	public void initializeSimulation(Cell[][] cells, int nbCellWidth, int nbCellHeight, IRules cellularAutomaton, IForm formOfCells, Color colorOfCells);
}
