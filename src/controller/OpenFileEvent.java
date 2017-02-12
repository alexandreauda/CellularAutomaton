package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class OpenFileEvent implements ActionListener  {

	/******ATTRIBUTES******/
	static final String path="C:\\";
	static final String imgPath = "Files/Images/error_icon.jpg";
	ImageIcon img = new ImageIcon(imgPath);
	
	
	/**
	 * ****CLASS METHODS*****.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Desktop.getDesktop().open(new File(path));
		} catch (IOException | NullPointerException | IllegalArgumentException e) {
			String errorMessage = "Message error: \n "+e.getMessage();
			System.out.println(errorMessage);
			JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, img);            
		}
	}

}
