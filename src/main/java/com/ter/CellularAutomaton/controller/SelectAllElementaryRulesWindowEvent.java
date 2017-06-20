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

/**
 * The Class CopyElementaryRulesWindowEvent. This class is used to selected all the text within the text field.
 */
public class SelectAllElementaryRulesWindowEvent implements ActionListener {

	/** ****ATTRIBUTES*****. */
	private ElementaryRulesWindow m_window;


	/**
	 * ****CONSTRUCTOR*****.
	 *
	 * @param window the window
	 */
	public SelectAllElementaryRulesWindowEvent(ElementaryRulesWindow window) {
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
		if(m_window.getm_isRadiusFocus()){
			m_window.getm_formattedTextFieldRadius().selectAll();; // Select all the text.
		}
		else{
			m_window.getm_formattedTextFieldRules().selectAll();; // Select all the text.
			}

	}


}
