package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.CellularAutomatonSettingWindow;


public class LocalCardWindowSettingEvent implements ActionListener {

	/******ATTRIBUTES******/
	CellularAutomatonSettingWindow m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public LocalCardWindowSettingEvent(CellularAutomatonSettingWindow window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.m_window.getm_showPanelLocalSetting() == false){
			this.m_window.setm_showPanelLocalSetting(true);
			this.m_window.getm_cardLayoutOnPanelEnterSetting().next(this.m_window.getm_panelEnterSetting());
		}	
	}
}
