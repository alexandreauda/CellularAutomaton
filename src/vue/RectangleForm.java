package vue;

import java.awt.Graphics;

import controller.Cell;

public class RectangleForm implements IForm {

	@Override
	public void draw(Graphics g,  int abscissaX, int ordinateY) {
		g.fillRect(abscissaX * Cell.CELL_SIZE, ordinateY * Cell.CELL_SIZE, Cell.CELL_SIZE, Cell.CELL_SIZE);//Draw a rectangle witch represent the cell
	}

}
