package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.PersonalizeElementaryCells1DFrame;

public class CancelPersonalizeElementaryCells1DFrameEvent implements ActionListener {

	/******ATTRIBUTES******/
	private PersonalizeElementaryCells1DFrame window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CancelPersonalizeElementaryCells1DFrameEvent(PersonalizeElementaryCells1DFrame window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.dispose();
		
	}


}

