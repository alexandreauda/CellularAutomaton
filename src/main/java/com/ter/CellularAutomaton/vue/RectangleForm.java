package com.ter.CellularAutomaton.vue;

import java.awt.Graphics;

import com.ter.CellularAutomaton.controller.Cell2D;

public class RectangleForm implements IForm {

	@Override
	public void draw(Graphics g,  int abscissaX, int ordinateY) {
		g.fillRect(abscissaX * Cell2D.CELL_SIZE, ordinateY * Cell2D.CELL_SIZE, Cell2D.CELL_SIZE, Cell2D.CELL_SIZE);//Draw a rectangle witch represent the cell
	}

}
