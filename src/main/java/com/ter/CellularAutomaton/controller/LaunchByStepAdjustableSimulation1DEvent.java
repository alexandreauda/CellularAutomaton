package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.model.SimulationState;
import com.ter.CellularAutomaton.vue.MainWindow1D;

public class LaunchByStepAdjustableSimulation1DEvent implements ActionListener {
	
	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public LaunchByStepAdjustableSimulation1DEvent(MainWindow1D window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_window.setm_simulationState(SimulationState.PAUSE);
		int actualIdOfLine = this.m_window.getm_internalFrameSimulation().getm_simulation().getm_idOfLines();
		this.m_window.setm_simulationState(SimulationState.RUN);
		while(this.m_window.getm_internalFrameSimulation().getm_simulation().getm_idOfLines() < actualIdOfLine+this.m_window.getm_stepOfLauncherStep()){
			if (this.m_window.getm_internalFrameSimulation().getm_simulation().getm_idOfLines() < this.m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()-1) {
				this.m_window.getm_internalFrameSimulation().getm_simulation().setm_idOfLines(this.m_window.getm_internalFrameSimulation().getm_simulation().getm_idOfLines()-1);
				this.m_window.getm_internalFrameSimulation().startUpdate();
			}
			else {
				this.m_window.getm_internalFrameSimulation().startUpdate();
			}
			
		}
		this.m_window.setm_simulationState(SimulationState.PAUSE);

		
	}

}
