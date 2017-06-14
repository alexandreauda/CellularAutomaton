package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.MainWindow1D;
import com.ter.CellularAutomaton.vue.PersonalizeElementaryCells1DFrame;

public class PersonalizeElementaryCells1DEvent implements ActionListener {

	private MainWindow1D m_window;
	
	public PersonalizeElementaryCells1DEvent(MainWindow1D window) {
		m_window = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		PersonalizeElementaryCells1DFrame personalizeElementaryCellsFrame = new PersonalizeElementaryCells1DFrame(m_window);
	}

}
