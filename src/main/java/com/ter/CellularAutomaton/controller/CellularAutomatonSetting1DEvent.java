package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;
import com.ter.CellularAutomaton.vue.MainWindow1D;
import com.ter.CellularAutomaton.vue.RulesEntryModeWindow;

public class CellularAutomatonSetting1DEvent implements ActionListener {
	
	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CellularAutomatonSetting1DEvent(MainWindow1D window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		RulesEntryModeWindow window = new RulesEntryModeWindow(m_window);
	}

	
}
