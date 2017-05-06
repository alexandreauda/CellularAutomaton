package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.LocalElementaryRulesWindow;

public class CloseLocalElementaryRulesWindowEvent implements ActionListener {


	/******ATTRIBUTES******/
	private LocalElementaryRulesWindow m_localElementaryRulesWindow;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CloseLocalElementaryRulesWindowEvent(LocalElementaryRulesWindow window) {
		super();
		this.m_localElementaryRulesWindow = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m_localElementaryRulesWindow.dispose();
		
	}

	
}
