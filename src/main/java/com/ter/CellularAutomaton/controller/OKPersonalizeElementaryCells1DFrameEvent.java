package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.MainWindow1D;
import com.ter.CellularAutomaton.vue.PersonalizeElementaryCells1DFrame;

public class OKPersonalizeElementaryCells1DFrameEvent implements ActionListener {


	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	private PersonalizeElementaryCells1DFrame m_personalizeElementaryCellsFrame;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public OKPersonalizeElementaryCells1DFrameEvent(MainWindow1D window, PersonalizeElementaryCells1DFrame personalizeElementaryCellsFrame) {
		super();
		m_window = window;
		this.m_personalizeElementaryCellsFrame = personalizeElementaryCellsFrame;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_window.setm_colorOfCells(0, m_personalizeElementaryCellsFrame.getm_tableChooseColorCellsPane().getm_customTableModel().getColorDeadCell());
		this.m_window.setm_colorOfCells(1, m_personalizeElementaryCellsFrame.getm_tableChooseColorCellsPane().getm_customTableModel().getColorLifeCell());
		this.m_personalizeElementaryCellsFrame.dispose();
		
	}

}
