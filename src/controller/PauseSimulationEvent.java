package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SimulationState;
import vue.MainWindow2D;

public class PauseSimulationEvent implements ActionListener {
	
	/******ATTRIBUTES******/
	private MainWindow2D window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public PauseSimulationEvent(MainWindow2D window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.setm_simulationState(SimulationState.PAUSE);
	}

}
