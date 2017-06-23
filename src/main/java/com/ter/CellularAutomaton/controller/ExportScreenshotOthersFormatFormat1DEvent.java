package com.ter.CellularAutomaton.controller;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import org.apache.commons.io.FilenameUtils;

import com.ter.CellularAutomaton.vue.MainWindow1D;

public class ExportScreenshotOthersFormatFormat1DEvent implements ActionListener {


	/******ATTRIBUTES******/
	private MainWindow1D m_mainWindow1D;
	JFrame frame;
	private JFileChooser fileChooser;
	private static final String titleJFileChoose = "Specify a file to save";
	private static final String allowExtensionPNG = "png";
	private static final String allowExtensionJPG = "jpg";
	private static final String allowExtensionGIF = "gif";


	/**
	 * ****CONSTRUCTOR*****.
	 */
	public ExportScreenshotOthersFormatFormat1DEvent(MainWindow1D window) {
		super();
		this.m_mainWindow1D = window;

	}


	/**
	 * ****CLASS METHODS*****.
	 */
	
	/**
	 * Set icon on the frame.
	 */
	private void setIconWindow() {
		try {
			frame = new JFrame();
			frame.setIconImage(ImageIO.read(new File("Files/Images/Favicon/PenroseColor.png")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BufferedImage image = new BufferedImage(m_mainWindow1D.getm_internalFrameSimulation().getm_scrollPane().getWidth()-m_mainWindow1D.getm_internalFrameSimulation().getm_scrollPane().getVerticalScrollBar().getWidth(), m_mainWindow1D.getm_internalFrameSimulation().getm_scrollPane().getHeight()-m_mainWindow1D.getm_internalFrameSimulation().getm_scrollPane().getHorizontalScrollBar().getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		m_mainWindow1D.getm_internalFrameSimulation().getm_scrollPane().printAll(g);
		g.dispose();
		try {
			// Set up the file chooser.
			if (fileChooser == null) {
				fileChooser = new JFileChooser();
			}
			// Set the title of the fileChooser.
			fileChooser.setDialogTitle(titleJFileChoose);
			// Set the initial directory for the fileChooser.
			fileChooser.setCurrentDirectory(new java.io.File(".")); // start at application current directory
			// Add a custom file filter and disable the default
			fileChooser.addChoosableFileFilter(new ImagePNGFilter());
			fileChooser.addChoosableFileFilter(new ImageJPGFilter());
			fileChooser.addChoosableFileFilter(new ImageGIFFilter());

			// Disable the Accept All file filter.
			//fileChooser.setAcceptAllFileFilterUsed(false);

			this.setIconWindow();//Set icon on window

			//Show the fileChooser.
			int userSelection = fileChooser.showSaveDialog(frame);

			// When the user click on the button save.
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile(); // Select the file to save.
				String extension = FilenameUtils.getExtension(fileToSave.getName().toLowerCase()); // Select the extension (in minuscule) of the files present in the JFileChooser.
				ImageIO.write(image, extension, new File(fileToSave.getAbsolutePath())); // Save this file with the png extension.
				JOptionPane.showMessageDialog(null,"The image was successfully exported"); // Show a dialog to inform the user that the export has been successful.

				//Reset the file chooser for the next time it's shown.
				fileChooser.setSelectedFile(null);

			}

		} catch (IOException exp) {
			exp.printStackTrace();
		}

	}

	public class ImagePNGFilter extends FileFilter {

		//Accept all directories and png files.
		@Override
		public boolean accept(File f) {
			String extension = FilenameUtils.getExtension(f.getName().toLowerCase()); // Select the extension (in minuscule) of the files present in the JFileChooser.
			if (f.isDirectory() || (extension != null && allowExtensionPNG.equals(extension))) { // Show the file in the JFileChooser only if it is a directory or a file with the extension png.
				return true;
			}
			return false;
		}

		//The description of this filter
		@Override
		public String getDescription() {
			return allowExtensionPNG;
		}
	}
	
	public class ImageJPGFilter extends FileFilter {

		//Accept all directories and jpg files.
		@Override
		public boolean accept(File f) {
			String extension = FilenameUtils.getExtension(f.getName().toLowerCase()); // Select the extension (in minuscule) of the files present in the JFileChooser.
			if (f.isDirectory() || (extension != null && allowExtensionJPG.equals(extension))) { // Show the file in the JFileChooser only if it is a directory or a file with the extension png.
				return true;
			}
			return false;
		}

		//The description of this filter
		@Override
		public String getDescription() {
			return allowExtensionJPG;
		}
	}
	
	public class ImageGIFFilter extends FileFilter {

		//Accept all directories and gif files.
		@Override
		public boolean accept(File f) {
			String extension = FilenameUtils.getExtension(f.getName().toLowerCase()); // Select the extension (in minuscule) of the files present in the JFileChooser.
			if (f.isDirectory() || (extension != null && allowExtensionGIF.equals(extension))) { // Show the file in the JFileChooser only if it is a directory or a file with the extension png.
				return true;
			}
			return false;
		}

		//The description of this filter
		@Override
		public String getDescription() {
			return allowExtensionGIF;
		}
	}




}
