package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.MainWindow1D;

public class RadioButtonGridNoEvent implements ActionListener {
	
	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public RadioButtonGridNoEvent(MainWindow1D window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_window.setm_gridSimulation(false);
	}
}
