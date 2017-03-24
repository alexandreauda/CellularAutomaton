package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;

public class CloseElementaryRulesWindowEvent implements ActionListener {


	/******ATTRIBUTES******/
	private ElementaryRulesWindow window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CloseElementaryRulesWindowEvent(ElementaryRulesWindow window) {
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
