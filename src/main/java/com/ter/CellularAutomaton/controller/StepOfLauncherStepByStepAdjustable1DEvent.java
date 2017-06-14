package com.ter.CellularAutomaton.controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ter.CellularAutomaton.vue.MainWindow1D;

public class StepOfLauncherStepByStepAdjustable1DEvent implements ChangeListener {
	
	/******ATTRIBUTES******/
	private MainWindow1D window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public StepOfLauncherStepByStepAdjustable1DEvent(MainWindow1D window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */

	@Override
	public void stateChanged(ChangeEvent e) {
		this.window.setm_stepOfLauncherStep(this.window.getm_sliderStepOfLauncherStepByStepAdjustable().getValue());//Set the value of the attribute m_stepOfLauncherStep to the value specified by the slider
		this.window.getm_labelIndicatorLauncherStepByStepAdjustable().setText("" + this.window.getm_sliderStepOfLauncherStepByStepAdjustable().getValue());//Change the label indicator of step of launcher step by step adjustable
		this.window.getm_labelIndicatorLauncherStepByStepAdjustable().setToolTipText("Indicator of step of launcher step by step adjustable: " + this.window.getm_sliderStepOfLauncherStepByStepAdjustable().getValue());//Change the label indicator of step of launcher step by step adjustable
	}

}
