package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.MainWindow;

public class CloseEvent implements ActionListener {


	/******ATTRIBUTES******/
	MainWindow window;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CloseEvent(MainWindow window) {
		super();
		this.window = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.dispose();
		
	}

	
}
