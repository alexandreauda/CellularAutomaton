package com.ter.CellularAutomaton.controller;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.ter.CellularAutomaton.vue.MainWindow1D;

public class ExportGIFFormat1DEvent implements ActionListener {


	/******ATTRIBUTES******/
	private MainWindow1D m_mainWindow1D;
	
	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public ExportGIFFormat1DEvent(MainWindow1D window) {
		super();
		this.m_mainWindow1D = window;
		
	}

	
	/**
	 * ****CLASS METHODS*****.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BufferedImage image = new BufferedImage(m_mainWindow1D.getm_internalFrameSimulation().getm_scrollPane().getWidth(), m_mainWindow1D.getm_internalFrameSimulation().getm_scrollPane().getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        m_mainWindow1D.getm_internalFrameSimulation().getm_scrollPane().printAll(g);
        g.dispose();
        try {
        	ImageIO.write(image, "gif", new File("ExportSimulation/Simulation.gif"));
            JOptionPane.showMessageDialog(null,"The image was successfully exported");
        } catch (IOException exp) {
            exp.printStackTrace();
        }
		
	}
}
