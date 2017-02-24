package vue;

import java.awt.Graphics;

@FunctionalInterface
public interface IForm {
	public void draw(Graphics g, int abscissaX, int ordinateY);
}
