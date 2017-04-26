package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.MainWindow1D;
import com.ter.CellularAutomaton.vue.MainWindow2D;

public class Switch1DTo2DSimulationEvent implements ActionListener {


	/******ATTRIBUTES******/
	private MainWindow1D m_window1D;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public Switch1DTo2DSimulationEvent(MainWindow1D window1D) {
		super();
		this.m_window1D = window1D;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_window1D.setm_isRun(false);
		this.m_window1D.dispose();//Close the current MainWindow1D
		this.m_window1D.setm_threadSimulation(null);
		MainWindow2D window2D = new MainWindow2D();//Create a new MainWindow2D

	}

	
}
