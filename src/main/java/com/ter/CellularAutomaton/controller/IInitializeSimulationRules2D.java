package com.ter.CellularAutomaton.controller;

import java.awt.Color;

import com.ter.CellularAutomaton.vue.IForm;

@FunctionalInterface
public interface IInitializeSimulationRules2D {
	public void initializeSimulation(Cell2D[][] cells, int nbCellWidth, int nbCellHeight, IRules2D cellularAutomaton, IForm formOfCells, Color colorOfCells);
}
