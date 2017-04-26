package com.ter.CellularAutomaton.controller;

import com.ter.CellularAutomaton.vue.MainWindow2D;

public class RunApplication2D implements Runnable{
	
	/******ATTRIBUTES******/
	private MainWindow2D window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public RunApplication2D(MainWindow2D window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
    public void run() {
    	this.window.runSimulation();                   
    }               
  } 