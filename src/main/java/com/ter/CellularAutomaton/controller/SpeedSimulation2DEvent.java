package com.ter.CellularAutomaton.controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ter.CellularAutomaton.vue.MainWindow2D;

public class SpeedSimulation2DEvent implements ChangeListener {
	
	/******ATTRIBUTES******/
	private MainWindow2D window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public SpeedSimulation2DEvent(MainWindow2D window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */

	@Override
	public void stateChanged(ChangeEvent e) {
		this.window.getm_internalFrameSimulation().setm_refreshRate(this.window.getm_sliderSpeedSimulation().getValue());//Set the value of the attribute m_refreshRate to the value specified by the slider
	}

}
