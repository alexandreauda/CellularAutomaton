package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class OpenFileEvent implements ActionListener  {

	/******ATTRIBUTES******/
	String path="C:\\";
	
	
	/**
	 * ****CLASS METHODS*****.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Desktop.getDesktop().open(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
