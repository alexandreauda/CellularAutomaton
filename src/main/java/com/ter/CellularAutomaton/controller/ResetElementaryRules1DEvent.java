package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;

public class ResetElementaryRules1DEvent implements ActionListener {
	
	/******ATTRIBUTES******/
	private ElementaryRulesWindow m_window;
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public ResetElementaryRules1DEvent(ElementaryRulesWindow window) {
		super();
		this.m_window = window;
	}
	
	/**
	 * ****CLASS METHODS*****.
	 */

	@Override
	public void actionPerformed(ActionEvent arg0) {
		m_window.setm_formattedTextFieldRadius(new Integer(1));
		m_window.setm_formattedTextFieldRules(new Integer(0));
	}

}
