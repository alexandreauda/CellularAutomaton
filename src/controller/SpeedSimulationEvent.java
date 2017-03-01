package controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import vue.MainWindow;

public class SpeedSimulationEvent implements ChangeListener {
	
	/******ATTRIBUTES******/
	private MainWindow window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public SpeedSimulationEvent(MainWindow window) {
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
