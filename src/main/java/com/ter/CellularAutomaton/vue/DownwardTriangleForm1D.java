package com.ter.CellularAutomaton.vue;

import java.awt.Color;
import java.awt.Graphics;

import com.ter.CellularAutomaton.controller.Cell1D;

public class DownwardTriangleForm1D implements IForm {
	
	
	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public DownwardTriangleForm1D(MainWindow1D window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */

	@Override
	public void draw(Graphics g,  int abscissaX, int ordinateY) {
		int[] x={abscissaX * Cell1D.CELL_SIZE,abscissaX * Cell1D.CELL_SIZE + Cell1D.CELL_SIZE/2,abscissaX * Cell1D.CELL_SIZE + Cell1D.CELL_SIZE};
		int[] y={ordinateY * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE + Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE};
		if(m_window.getm_gridSimulation()){
			g.fillPolygon(x,y,3);//Draw a downward triangle witch represent the cell
			g.setColor(m_window.getm_colorGrid());
			g.drawPolygon(x,y,3);
		}
		else{
			g.fillPolygon(x,y,3);//Draw a downward triangle witch represent the cell
		}
	}

}
