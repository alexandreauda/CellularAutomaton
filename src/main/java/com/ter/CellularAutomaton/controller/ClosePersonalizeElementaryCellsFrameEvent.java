package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.PersonalizeElementaryCells1DFrame;

public class ClosePersonalizeElementaryCellsFrameEvent implements ActionListener {


	/******ATTRIBUTES******/
	private PersonalizeElementaryCells1DFrame m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public ClosePersonalizeElementaryCellsFrameEvent(PersonalizeElementaryCells1DFrame window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_window.dispose();	
	}
}