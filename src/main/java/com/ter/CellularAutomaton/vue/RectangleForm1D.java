package com.ter.CellularAutomaton.vue;

import java.awt.Color;
import java.awt.Graphics;

import com.ter.CellularAutomaton.controller.Cell1D;

public class RectangleForm1D implements IForm {
	
	
	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public RectangleForm1D(MainWindow1D window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */

	@Override
	public void draw(Graphics g,  int abscissaX, int ordinateY) {
		if(m_window.getm_gridSimulation()){
			g.fillRect(abscissaX * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, Cell1D.CELL_SIZE);//Draw a rectangle witch represent the cell
			g.setColor(Color.RED);
			g.drawRect(abscissaX * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, Cell1D.CELL_SIZE);
		}
		else{
			g.fillRect(abscissaX * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, Cell1D.CELL_SIZE);//Draw a rectangle witch represent the cell
		}
	}

}
