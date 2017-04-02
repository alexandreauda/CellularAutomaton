package com.ter.CellularAutomaton.controller;

import java.awt.Color;

import com.ter.CellularAutomaton.vue.IForm;
import com.ter.CellularAutomaton.vue.Simulation1D;

@FunctionalInterface
public interface IInitializeSimulationRules1D {
	public void initializeSimulation(Simulation1D simulation);
}
