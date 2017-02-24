package controller;

import java.awt.Color;

import vue.IForm;

@FunctionalInterface
public interface IInitializeSimulationRules {
	public void initializeSimulation(Cell[][] cells, int nbCellWidth, int nbCellHeight, IRules cellularAutomaton, IForm formOfCells, Color colorOfCells);
}
