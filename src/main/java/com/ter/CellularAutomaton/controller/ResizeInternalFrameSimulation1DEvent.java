package com.ter.CellularAutomaton.controller;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ter.CellularAutomaton.model.SimulationState;
import com.ter.CellularAutomaton.vue.InternalFrameSimulation1D;
import com.ter.CellularAutomaton.vue.MainWindow1D;

public class ResizeInternalFrameSimulation1DEvent implements ComponentListener {
	
	/******ATTRIBUTES******/
	// For the logging.
	private static final Logger logger = LogManager.getLogger(ResizeInternalFrameSimulation1DEvent.class.getName()); // TestLog4j1.class.getName() must be change in yourClassName.class.getName().

	private MainWindow1D m_mainWindow;

	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public ResizeInternalFrameSimulation1DEvent(MainWindow1D window) {
		super();
		this.m_mainWindow = window;
	}
	
	
	@Override
	public void componentResized(ComponentEvent e) {
		if(logger.isDebugEnabled()){
			logger.debug("Resizing the internal frame");
		}

		this.m_mainWindow.setm_simulationState(SimulationState.PAUSE);
		this.m_mainWindow.getm_internalFrameSimulation().setm_width(this.m_mainWindow.getm_internalFrameSimulation().getWidth());
		this.m_mainWindow.getm_internalFrameSimulation().setm_height(this.m_mainWindow.getm_internalFrameSimulation().getHeight());
		
		this.m_mainWindow.getm_internalFrameSimulation().getm_simulation().setm_nbCellWidth(this.m_mainWindow.getm_internalFrameSimulation().getm_width()/Cell1D.CELL_SIZE);
		this.m_mainWindow.getm_internalFrameSimulation().getm_simulation().setm_nbCellHeight(this.m_mainWindow.getm_internalFrameSimulation().getm_height()/Cell1D.CELL_SIZE);
		
		this.m_mainWindow.getm_internalFrameSimulation().getm_simulation().initByDefaultSimulation();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
