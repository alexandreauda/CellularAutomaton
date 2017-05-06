package com.ter.CellularAutomaton.vue;

import java.awt.Graphics;

import com.ter.CellularAutomaton.controller.Cell2D;

public class RectangleForm2D implements IForm {
	
	
	/******ATTRIBUTES******/
	private MainWindow2D m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public RectangleForm2D(MainWindow2D window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */

	@Override
	public void draw(Graphics g,  int abscissaX, int ordinateY) {
		g.fillRect(abscissaX * Cell2D.CELL_SIZE, ordinateY * Cell2D.CELL_SIZE, Cell2D.CELL_SIZE, Cell2D.CELL_SIZE);//Draw a rectangle witch represent the cell
	}

}
