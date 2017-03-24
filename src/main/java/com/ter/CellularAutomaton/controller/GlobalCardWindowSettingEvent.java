package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ter.CellularAutomaton.vue.CellularAutomatonSettingWindow;


public class GlobalCardWindowSettingEvent implements ActionListener {

	/******ATTRIBUTES******/
	CellularAutomatonSettingWindow m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public GlobalCardWindowSettingEvent(CellularAutomatonSettingWindow window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.m_window.getm_showPanelLocalSetting() == true){
			this.m_window.setm_showPanelLocalSetting(false);
			this.m_window.getm_cardLayoutOnPanelEnterSetting().next(this.m_window.getm_panelEnterSetting());
		}	
	}
}
