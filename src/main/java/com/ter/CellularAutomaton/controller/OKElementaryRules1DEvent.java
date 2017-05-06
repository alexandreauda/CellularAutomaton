package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.model.SimulationState;
import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;
import com.ter.CellularAutomaton.vue.MainWindow1D;


public class OKElementaryRules1DEvent implements ActionListener {

	/******ATTRIBUTES******/
	private ElementaryRulesWindow m_window;
	private MainWindow1D m_currentSimulator;


	/**
	 * ****CONSTRUCTOR*****.
	 */
	public OKElementaryRules1DEvent(ElementaryRulesWindow window, MainWindow1D currentSimulator) {
		super();
		this.m_window = window;
		this.m_currentSimulator = currentSimulator;

	}


	/**
	 * ****CLASS METHODS*****.
	 */
	//Convert string number to int number and return the int number
	private static int convertStringNumberToIntNumber(String stringNumber){
		//Convert
		return Integer.parseInt(stringNumber,10);//Convert string number to int number and return the int number
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_currentSimulator.setm_simulationState(SimulationState.PAUSE);//Stop the simulation.
		this.m_currentSimulator.getm_internalFrameSimulation().getm_simulation().setm_idOfLines(0);//Set cursor m_idOfLines to 0.
		this.m_currentSimulator.getm_internalFrameSimulation().getm_simulation().getm_initializeSimulationRule().initializeSimulation(m_currentSimulator.getm_internalFrameSimulation().getm_simulation());// Initialize simulation according to current rule of initialization of simulation.
		
		//Get the input of user for Radius input, transform this string to int value and stock this value.
		String stringRadiusChooseByUser=this.m_window.getm_formattedTextFieldRadius().getText();// Stock the decimal number input from user to entry the radius.
		int intRadiusChooseByUser=convertStringNumberToIntNumber(stringRadiusChooseByUser);// Convert string number to int number and stock the int number.
		
		//Get the input of user for Rules input, transform this string to int value and stock this value.
		String stringRuleChooseByUser=this.m_window.getm_formattedTextFieldRules().getText();// Stock the decimal number input from user to entry the rule.
		int intRuleChooseByUser=convertStringNumberToIntNumber(stringRuleChooseByUser);// Convert string number to int number and stock the int number.

		//Set attributes m_globalRadius and m_globalRules of the current Simulation with the input of user for Radius input and  with the input of user for Rules input
		this.m_currentSimulator.getm_internalFrameSimulation().getm_simulation().setm_globalRadius(intRadiusChooseByUser); //Set m_globalRadius of the current simulation with the value entry by user.
		this.m_currentSimulator.getm_internalFrameSimulation().getm_simulation().setm_globalRules(intRuleChooseByUser);//Set m_globalRules of the current simulation with the value entry by user.
		
		this.m_currentSimulator.getm_internalFrameSimulation().getm_simulation().initRadiusAndRulesCellWithGlobalRadiusAndRulesSimulation();//For each cell of Simulation, set the radius and rules of the cell  with the global Radius and the global Rules of Simulation.
		
		this.m_currentSimulator.setm_simulationState(SimulationState.RUN);//Run the simulation.

		this.m_window.dispose();// Close ElementaryRulesWindow.

	}
}
