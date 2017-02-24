package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SimulationState;
import vue.MainWindow;

public class StopSimulationEvent implements ActionListener  {
	/******ATTRIBUTES******/
	MainWindow window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public StopSimulationEvent(MainWindow window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.setm_simulationState(SimulationState.STOP);
	}
}
