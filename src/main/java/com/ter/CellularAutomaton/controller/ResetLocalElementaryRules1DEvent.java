package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;
import com.ter.CellularAutomaton.vue.LocalElementaryRulesWindow;

public class ResetLocalElementaryRules1DEvent implements ActionListener {
	
	/******ATTRIBUTES******/
	private LocalElementaryRulesWindow m_window;
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public ResetLocalElementaryRules1DEvent(LocalElementaryRulesWindow window) {
		super();
		this.m_window = window;
	}
	
	/**
	 * ****CLASS METHODS*****.
	 */

	@Override
	public void actionPerformed(ActionEvent arg0) {
		m_window.setm_formattedTextFieldX1(new Integer(1));
		m_window.setm_formattedTextFieldX2(new Integer(1));
		m_window.setm_formattedTextFieldRadius(new Integer(1));
		m_window.setm_formattedTextFieldRules(new Integer(0));
	}

}
