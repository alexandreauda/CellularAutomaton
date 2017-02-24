package main;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import vue.MainWindow;


/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		MainWindow SimulatorWindow = new MainWindow();
		SimulatorWindow.runSimulation();
	}

}
