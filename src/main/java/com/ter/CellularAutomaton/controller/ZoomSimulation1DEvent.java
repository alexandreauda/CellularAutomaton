package com.ter.CellularAutomaton.controller;

import java.awt.Dimension;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ter.CellularAutomaton.vue.MainWindow1D;

public class ZoomSimulation1DEvent implements ChangeListener {

	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public ZoomSimulation1DEvent(MainWindow1D window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */

	@Override
	public void stateChanged(ChangeEvent e) {
		int actualValueOfZoomSlider = this.m_window.getm_sliderZoomSimulation().getValue();
		
		switch (actualValueOfZoomSlider) {
			case 1: Cell1D.CELL_SIZE = 2;
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					this.m_window.getm_labelIndicatorZoom().setText("0%");//Change the label indicator of zoom
					this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 0%");//Change the label indicator of zoom
					break;
				
			case 2: Cell1D.CELL_SIZE = 4;
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					this.m_window.getm_labelIndicatorZoom().setText("10%");//Change the label indicator of zoom
					this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 10%");//Change the label indicator of zoom
					break;
					
			case 3: Cell1D.CELL_SIZE = 10;
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					this.m_window.getm_labelIndicatorZoom().setText("20%");//Change the label indicator of zoom
					this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 20%");//Change the label indicator of zoom
					break;
		
			case 4: Cell1D.CELL_SIZE = 16;
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					this.m_window.getm_labelIndicatorZoom().setText("30%");//Change the label indicator of zoom
					this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 30%");//Change the label indicator of zoom
					break;
					
			case 5: Cell1D.CELL_SIZE = 32;
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					this.m_window.getm_labelIndicatorZoom().setText("40%");//Change the label indicator of zoom
					this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 40%");//Change the label indicator of zoom
					break;
					
			case 6: Cell1D.CELL_SIZE = 64;
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					this.m_window.getm_labelIndicatorZoom().setText("50%");//Change the label indicator of zoom
					this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 50%");//Change the label indicator of zoom
					break;
					
			case 7: Cell1D.CELL_SIZE = 128;
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					this.m_window.getm_labelIndicatorZoom().setText("60%");//Change the label indicator of zoom
					this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 60%");//Change the label indicator of zoom
					break;
					
			case 8: Cell1D.CELL_SIZE = 256;
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					this.m_window.getm_labelIndicatorZoom().setText("70%");//Change the label indicator of zoom
					this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 70%");//Change the label indicator of zoom
					break;
					
			case 9: Cell1D.CELL_SIZE = 512;
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					this.m_window.getm_labelIndicatorZoom().setText("80%");//Change the label indicator of zoom
					this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 80%");//Change the label indicator of zoom
					break;
					
			case 10: Cell1D.CELL_SIZE = 1024;
					 m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					 m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					 m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					 this.m_window.getm_labelIndicatorZoom().setText("90%");//Change the label indicator of zoom
					 this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 90%");//Change the label indicator of zoom
					 break;
					
			case 11: Cell1D.CELL_SIZE = 2048;
					 m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					 m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					 m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					 this.m_window.getm_labelIndicatorZoom().setText("100%");//Change the label indicator of zoom
					 this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 100%");//Change the label indicator of zoom
					 break;
	
			default: Cell1D.CELL_SIZE = 10;
					 m_window.getm_internalFrameSimulation().getm_screen().setm_screenWidth(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellWidth()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					 m_window.getm_internalFrameSimulation().getm_screen().setm_screenHeight(m_window.getm_internalFrameSimulation().getm_simulation().getm_nbCellHeight()*Cell1D.CELL_SIZE+100);// The Screen follow now the simulation when we zoom on simulation
					 m_window.getm_internalFrameSimulation().getm_screen().setPreferredSize(new Dimension(m_window.getm_internalFrameSimulation().getm_screen().getm_screenWidth(), m_window.getm_internalFrameSimulation().getm_screen().getm_screenHeight()));//Resize the Screen
					 this.m_window.getm_labelIndicatorZoom().setText("20%");//Change the label indicator of zoom
					 this.m_window.getm_labelIndicatorZoom().setToolTipText("Indicator of Zoom: 20%");//Change the label indicator of zoom
					 break;
		}
	}


}
