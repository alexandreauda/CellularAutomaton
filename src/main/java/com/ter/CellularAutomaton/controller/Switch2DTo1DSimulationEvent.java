package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.MainWindow1D;
import com.ter.CellularAutomaton.vue.MainWindow2D;

public class Switch2DTo1DSimulationEvent implements ActionListener {


	/******ATTRIBUTES******/
	private MainWindow2D m_window2D;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public Switch2DTo1DSimulationEvent(MainWindow2D window2D) {
		super();
		this.m_window2D = window2D;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_window2D.setm_isRun(false);
		this.m_window2D.dispose();//Close the current MainWindow2D
		this.m_window2D.setm_threadSimulation(null);
		MainWindow1D window1D = new MainWindow1D();//Create a new MainWindow1D
	}

	
}
