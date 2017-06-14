package com.ter.CellularAutomaton.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import org.apache.commons.io.FilenameUtils;

import com.ter.CellularAutomaton.controller.SaveAs1DEvent.ImageCelFilter;
import com.ter.CellularAutomaton.vue.MainWindow1D;

public class OpenFileEvent implements ActionListener  {

	/******ATTRIBUTES******/
	private MainWindow1D m_mainWindow1D;
	JFrame frame;
	private JFileChooser fileChooser;
	private static final String titleJFileChoose = "Specify a file to open";
	private static final String allowExtension = "cel";
	
//	private MainWindow1D m_mainWindow1D;
//	static final String path="C:\\";
//	static final String imgPath = "Files/Images/error_icon.jpg";
//	ImageIcon img = new ImageIcon(imgPath);
	
	/******CONSTRUCTOR******/
	public OpenFileEvent(MainWindow1D mainWindow1D){
		m_mainWindow1D = mainWindow1D;
	}
	
	
	/**
	 * ****CLASS METHODS*****.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
//		try {
//			Desktop.getDesktop().open(new File(path));
//		} catch (IOException | NullPointerException | IllegalArgumentException e) {
//			String errorMessage = "Message error: \n "+e.getMessage();
//			System.out.println(errorMessage);
//			JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, img);            
//		}
		
		MainWindow1D openedDocument = null;
		
		try {
			// Set up the file chooser.
			if (fileChooser == null) {
				fileChooser = new JFileChooser();
			}
			// Set the title of the fileChooser.
			fileChooser.setDialogTitle(titleJFileChoose);
			// Set the initial directory for the fileChooser.
			fileChooser.setCurrentDirectory(new java.io.File("./Saves")); // start at application current directory
			// Add a custom file filter and disable the default
			fileChooser.addChoosableFileFilter(new ImageCelFilter());

			// Disable the Accept All file filter.
			//fileChooser.setAcceptAllFileFilterUsed(false);


			//Show the fileChooser.
			int userSelection = fileChooser.showOpenDialog(frame);

			// When the user click on the button save.
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile(); // Select the file to save.
				//String extension = FilenameUtils.getExtension(fileToSave.getName().toLowerCase()); // Select the extension (in minuscule) of the files present in the JFileChooser.
				
				// We must write the object in a file.
				ObjectInputStream ois;
				try{
					ois = new ObjectInputStream(
							new BufferedInputStream(
									new FileInputStream(
											new File(fileToSave.getAbsolutePath()))));
					try {
						openedDocument = (MainWindow1D) ois.readObject();
						openedDocument.setVisible(true);
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// Close the stream.
					ois.close();
				}
				/**
				 * Exceptions are handled
				 * @throws FileNotFoundException if the file cannot be found
				 * @throws IOException if file management problem occurs.
				 */
				catch (FileNotFoundException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"An error has occured. The file could not be found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				//JOptionPane.showMessageDialog(null,"The simulation was saved successfully."); // Show a dialog to inform the user that the export has been successful.

				//Reset the file chooser for the next time it's shown.
				fileChooser.setSelectedFile(null);

			}

		} catch (IOException exp) {
			exp.printStackTrace();
			JOptionPane.showMessageDialog(null,"An error has occured. Please retry later.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public class ImageCelFilter extends FileFilter implements Serializable {

		//Accept all directories and png files.
		@Override
		public boolean accept(File f) {
			String extension = FilenameUtils.getExtension(f.getName().toLowerCase()); // Select the extension (in minuscule) of the files present in the JFileChooser.
			if (f.isDirectory() || (extension != null && allowExtension.equals(extension))) { // Show the file in the JFileChooser only if it is a directory or a file with the extension png.
				return true;
			}
			return false;
		}

		//The description of this filter
		@Override
		public String getDescription() {
			return allowExtension;
		}
	}

}
