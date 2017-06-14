package com.ter.CellularAutomaton.controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ter.CellularAutomaton.vue.MainWindow1D;

public class SpeedSimulation1DEvent implements ChangeListener {
	
	/******ATTRIBUTES******/
	private MainWindow1D window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public SpeedSimulation1DEvent(MainWindow1D window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */

	@Override
	public void stateChanged(ChangeEvent e) {
		this.window.getm_internalFrameSimulation().setm_refreshRate(this.window.getm_sliderSpeedSimulation().getValue());//Set the value of the attribute m_refreshRate to the value specified by the slider
		this.window.getm_labelIndicatorSpeed().setText("" + this.window.getm_sliderSpeedSimulation().getValue());//Change the label indicator of speed
		this.window.getm_labelIndicatorSpeed().setToolTipText("Indicator of speed: " + this.window.getm_sliderSpeedSimulation().getValue());//Change the label indicator of speed
	}

}
