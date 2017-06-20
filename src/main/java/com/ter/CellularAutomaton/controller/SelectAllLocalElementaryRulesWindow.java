package com.ter.CellularAutomaton.controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;
import com.ter.CellularAutomaton.vue.LocalElementaryRulesWindow;

/**
 * The Class CopyElementaryRulesWindowEvent. This class is used to selected all the text within the text field.
 */
public class SelectAllLocalElementaryRulesWindow implements ActionListener {

	/** ****ATTRIBUTES*****. */
	private LocalElementaryRulesWindow m_window;


	/**
	 * ****CONSTRUCTOR*****.
	 *
	 * @param window the window
	 */
	public SelectAllLocalElementaryRulesWindow(LocalElementaryRulesWindow window) {
		super();
		this.m_window = window;

	}


	/**
	 * ****CLASS METHODS*****.
	 *
	 * 
	 */


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		/***FIRST METHOD***/
		if(m_window.getm_isComponentFocus()[0]){
			m_window.getm_formattedTextFieldX1().selectAll(); // Select all the text.
		}
		else if(m_window.getm_isComponentFocus()[1]){
			m_window.getm_formattedTextFieldX2().selectAll(); // Select all the text.
		}
		else if(m_window.getm_isComponentFocus()[2]){
			m_window.getm_formattedTextFieldRadius().selectAll(); // Select all the text.
		}
		else{
			m_window.getm_formattedTextFieldRules().selectAll(); // Select all the text.
		}

	}


}
