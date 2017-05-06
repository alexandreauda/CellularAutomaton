package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.MainWindow2D;

public class Close2DEvent implements ActionListener {


	/******ATTRIBUTES******/
	MainWindow2D window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public Close2DEvent(MainWindow2D window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.setm_isRun(false);
		this.window.setm_threadSimulation(null);
		this.window.dispose();
		
	}

	
}
