package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.MainWindow1D;


// TODO: Auto-generated Javadoc
/**
 * The Class NewEvent.
 */
public class New1DEvent implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MainWindow1D newSimulatorWindow = new MainWindow1D();
		
	}

}
