package com.ter.CellularAutomaton.vue;

import java.awt.Color;
import java.awt.Graphics;

import com.ter.CellularAutomaton.controller.Cell1D;

public class Rectangle3DRaisedForm1D implements IForm {
	
	
	/******ATTRIBUTES******/
	private MainWindow1D m_window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public Rectangle3DRaisedForm1D(MainWindow1D window) {
		super();
		this.m_window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */

	@Override
	public void draw(Graphics g,  int abscissaX, int ordinateY) {
		if(m_window.getm_gridSimulation()){
			g.fill3DRect(abscissaX * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, true);//Draw a rectangle 3D raised witch represent the cell
			g.setColor(Color.RED);
			g.draw3DRect(abscissaX * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, true);//Draw a rectangle 3D raised witch represent the cell
		}
		else{
			g.fill3DRect(abscissaX * Cell1D.CELL_SIZE, ordinateY * Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, Cell1D.CELL_SIZE, true);//Draw a rectangle 3D raised witch represent the cell
		}
	}

}
