package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.MainWindow;

public class QuitEvent implements ActionListener {

	/******ATTRIBUTES******/
	MainWindow window;
	
	public QuitEvent(MainWindow window) {
		super();
		this.window = window;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.dispose();
		
	}

}
