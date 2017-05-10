package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.InternalFrameSimulation1D;
import com.ter.CellularAutomaton.vue.LocalElementaryRulesWindow;


public class OKLocalElementaryRules1DEvent implements ActionListener {

	/******ATTRIBUTES******/
	private LocalElementaryRulesWindow m_localElementaryRulesWindow;
	private InternalFrameSimulation1D m_currentInternalFrameSimulation1D;
	private Cell1D m_currentCell;


	/**
	 * ****CONSTRUCTOR*****.
	 */
	public OKLocalElementaryRules1DEvent(LocalElementaryRulesWindow window, InternalFrameSimulation1D currentInternalFrameSimulation1D, Cell1D currentCell) {
		super();
		this.m_localElementaryRulesWindow = window;
		this.m_currentInternalFrameSimulation1D = currentInternalFrameSimulation1D;
		this.m_currentCell = currentCell;
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
		
		//Get the input of user for X1 input, transform this string to int value and stock this value.
		String stringX1ChooseByUser=this.m_localElementaryRulesWindow.getm_formattedTextFieldX1().getText();// Stock the decimal number input from user to entry the X1.
		int intX1ChooseByUser=convertStringNumberToIntNumber(stringX1ChooseByUser);// Convert string number to int number and stock the int number.
		
		//Get the input of user for X2 input, transform this string to int value and stock this value.
		String stringX2ChooseByUser=this.m_localElementaryRulesWindow.getm_formattedTextFieldX2().getText();// Stock the decimal number input from user to entry the X2.
		int intX2ChooseByUser=convertStringNumberToIntNumber(stringX2ChooseByUser);// Convert string number to int number and stock the int number.

		//Get the input of user for Radius input, transform this string to int value and stock this value.
		String stringRadiusChooseByUser=this.m_localElementaryRulesWindow.getm_formattedTextFieldRadius().getText();// Stock the decimal number input from user to entry the radius.
		int intRadiusChooseByUser=convertStringNumberToIntNumber(stringRadiusChooseByUser);// Convert string number to int number and stock the int number.
		
		//Get the input of user for Rules input, transform this string to int value and stock this value.
		String stringRuleChooseByUser=this.m_localElementaryRulesWindow.getm_formattedTextFieldRules().getText();// Stock the decimal number input from user to entry the rule.
		int intRuleChooseByUser=convertStringNumberToIntNumber(stringRuleChooseByUser);// Convert string number to int number and stock the int number.

		this.m_currentInternalFrameSimulation1D.getm_simulation().initRadiusAndRulesCellLocally(intX1ChooseByUser, intX2ChooseByUser, intRadiusChooseByUser, intRuleChooseByUser);
		
		//Set attributes radius and rules of the current cell that the user want change with the input of user for Radius input and  with the input of user for Rules input
//		this.m_currentInternalFrameSimulation1D.getm_simulation().getCellInSimulation(m_currentCell.getm_x(), m_currentCell.getm_y()).setm_radius(intRadiusChooseByUser); //Set radius of the current cell that the user want change.
//		this.m_currentInternalFrameSimulation1D.getm_simulation().getCellInSimulation(m_currentCell.getm_x(), m_currentCell.getm_y()).setm_rules(intRuleChooseByUser);//Set rule of the current cell that the user want change.

		this.m_currentInternalFrameSimulation1D.getm_simulation().setm_idOfLines(0);//Set cursor m_idOfLines to ordonne of cell that the user want change.
		
		this.m_localElementaryRulesWindow.dispose();// Close ElementaryRulesWindow.

	}
}
