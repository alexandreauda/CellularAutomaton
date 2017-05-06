package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.SizeSimulationWindow;

public class CloseSizeSimulationWindowEvent implements ActionListener {


	/******ATTRIBUTES******/
	private SizeSimulationWindow m_sizeSimulationWindow;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CloseSizeSimulationWindowEvent(SizeSimulationWindow sizeSimulationWindow) {
		super();
		this.m_sizeSimulationWindow = sizeSimulationWindow;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_sizeSimulationWindow.dispose();	
	}
}