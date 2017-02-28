package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SimulationState;
import vue.MainWindow;

public class StartSimulationEvent implements ActionListener {
	
	/******ATTRIBUTES******/
	private MainWindow window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public StartSimulationEvent(MainWindow window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.setm_simulationState(SimulationState.RUN);
	}
}
