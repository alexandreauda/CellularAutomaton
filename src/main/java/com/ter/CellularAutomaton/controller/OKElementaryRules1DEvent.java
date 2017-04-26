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
	private String convertAndLeftCompleteBy0DecimalToBinary(String stringDecimalNumber, int lengthOfString){
		int decimalNumber=Integer.parseInt(stringDecimalNumber);
		String numberConvertToBinary=Integer.toBinaryString(decimalNumber);//Convert number decimal to binary
		StringBuilder completeBy0= new StringBuilder("");
		String completeNumber=completeBy0+numberConvertToBinary;
		while(completeNumber.length()<lengthOfString){
			completeBy0.append("0");
			completeNumber=completeBy0+numberConvertToBinary;
		}
		return completeNumber;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_currentSimulator.getm_internalFrameSimulation().getm_simulation().setm_idOfLines(0);
		this.m_currentSimulator.getm_internalFrameSimulation().getm_simulation().getm_initializeSimulationRule().initializeSimulation(m_currentSimulator.getm_internalFrameSimulation().getm_simulation());// Initialize simulation according to current rule of initialization of simulation.
		this.m_currentSimulator.setm_threadSimulation(null);
		this.m_currentSimulator.setm_simulationState(SimulationState.RUN);
		this.m_currentSimulator.setm_threadSimulation(new Thread(new RunApplication1D(m_currentSimulator)));
		this.m_currentSimulator.getm_threadSimulation().start();
		String decimalRuleChooseByUser=this.m_window.getm_formattedTextFieldRules().getText();// Stock the decimal number input from user to entry the rule.
		String binaryRuleChooseByUser=this.convertAndLeftCompleteBy0DecimalToBinary(decimalRuleChooseByUser,8);// Transform the decimal number input from user to entry the rule to binary number.

		// Set each digit of the number converted to binary in the hasmap.
		for(int i=0;i<binaryRuleChooseByUser.length();i++){
			this.m_currentSimulator.getm_internalFrameSimulation().getm_simulation().getm_evolutionRule().replace(i+1, Integer.parseInt(new StringBuilder(binaryRuleChooseByUser).reverse().toString().substring(i, i+1),10));// Initialize hasmap which represent the rule of simulation by the rule entry by the user.
		}

		this.m_window.dispose();// Close ElementaryRulesWindow.


	}
}
