package com.ter.CellularAutomaton.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.ter.CellularAutomaton.vue.MainWindow1D;

public class ComboBoxInitialPositionCellsEvent implements ItemListener {

	/******ATTRIBUTES******/
	MainWindow1D m_mainWindow1D;
	
	public ComboBoxInitialPositionCellsEvent(MainWindow1D mainWindow1D){
		m_mainWindow1D = mainWindow1D;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(m_mainWindow1D.getm_comboBoxInitialPositionCells().getSelectedItem() == m_mainWindow1D.getm_stringInitialPositionCells()[0]){
			IInitializeSimulationRules1D initializeSimulation1OneCells = new InitializeSimulation1DOneCell();
			initializeSimulation1OneCells.initializeSimulation(m_mainWindow1D.getm_internalFrameSimulation().getm_simulation());
			}
		else if(m_mainWindow1D.getm_comboBoxInitialPositionCells().getSelectedItem() == m_mainWindow1D.getm_stringInitialPositionCells()[1]){
			IInitializeSimulationRules1D initializeSimulation1DThreeCells=new InitializeSimulation1DThreeCells();
			initializeSimulation1DThreeCells.initializeSimulation(m_mainWindow1D.getm_internalFrameSimulation().getm_simulation());
			}
		else if(m_mainWindow1D.getm_comboBoxInitialPositionCells().getSelectedItem() == m_mainWindow1D.getm_stringInitialPositionCells()[2]){
			IInitializeSimulationRules1D initializeSimulation1DRandomCells = new InitializeSimulation1DRandomly();
			initializeSimulation1DRandomCells.initializeSimulation(m_mainWindow1D.getm_internalFrameSimulation().getm_simulation());
		}
		else{
			IInitializeSimulationRules1D initializeSimulation1OneCells = new InitializeSimulation1DOneCell();
			initializeSimulation1OneCells.initializeSimulation(m_mainWindow1D.getm_internalFrameSimulation().getm_simulation());
		}
	}

}
