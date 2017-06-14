package com.ter.CellularAutomaton.vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ter.CellularAutomaton.controller.Cell1D;
import com.ter.CellularAutomaton.controller.IInitializeSimulationRules1D;
import com.ter.CellularAutomaton.controller.ResizeInternalFrameSimulation1DEvent;
import com.ter.CellularAutomaton.controller.Switch1DTo2DSimulationEvent;
import com.ter.CellularAutomaton.model.SimulationState;

import javax.swing.JScrollPane;

public class InternalFrameSimulation1D extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/******ATTRIBUTES******/
	// For the logging.
	private static final Logger logger = LogManager.getLogger(InternalFrameSimulation1D.class.getName()); // TestLog4j1.class.getName() must be change in yourClassName.class.getName().
	private MainWindow1D m_mainWindow1D;
	
	private int m_width;
	private int m_height;
	private int m_refreshRate; //Updates per seconde
	private int m_millis;
	private JScrollPane m_scrollPane;
	private Screen m_screen;
	private Simulation1D m_simulation;
	private Color m_backgroundColor;

	/******CONSTRUCTOR******/
	public InternalFrameSimulation1D(String title, IForm formOfCells, ArrayList<Color> colorOfCells, Color backgroundColor, IInitializeSimulationRules1D initializeSimulationRule, MainWindow1D mainWindow1D) {
		super(title,true,true,true,true);
		m_mainWindow1D = mainWindow1D;
		m_width=900;
		m_height = 530;
		m_refreshRate = 30;
		m_millis = 1000/m_refreshRate;
		
		m_simulation = new Simulation1D(m_width, m_height, 0, 0, formOfCells, colorOfCells, initializeSimulationRule);
		
		m_screen = new Screen(this);
		m_scrollPane = new JScrollPane(m_screen);
		m_scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);// Force the scrollbars to always be displayed
		m_scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);// Force the scrollbars to always be displayed
		getContentPane().add(m_scrollPane, BorderLayout.CENTER);
		m_scrollPane.updateUI();
		m_backgroundColor=backgroundColor;
		this.setBackground(m_backgroundColor);
		
		this.setLocation(53, 11);//Set initial location of internalFrame
		this.isClosable();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(true);//The internalFrame can be closed
		this.pack();
		this.setSize(m_width + this.getInsets().left +  + this.getInsets().right, m_height + this.getInsets().bottom +  + this.getInsets().top);

		ImageIcon icon;
		try {
			icon = new ImageIcon(ImageIO.read(new File("Files/Images/Favicon/small_penrosecolor.png")));
			this.setFrameIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		addListenerInternalFrameSimulation1D(mainWindow1D);
		
		this.setVisible(true);
	}
	
	/******GETTERS******/
	public MainWindow1D getm_mainWindow1D() {
		return m_mainWindow1D;
	}
	
	public JScrollPane getm_scrollPane() {
		return m_scrollPane;
	}
	
	public Screen getm_screen() {
		return m_screen;
	}
	
	public Simulation1D getm_simulation() {
		return m_simulation;
	}
	
	public int getm_width() {
		return m_width;
	}
	
	public int getm_height() {
		return m_height;
	}
	
	public Color getm_backgroundColor() {
		return m_backgroundColor;
	}
	
	/******SETTERS******/
	public void setm_mainWindow1D(MainWindow1D mainWindow1D) {
		this.m_mainWindow1D = mainWindow1D;
	}
	public void setm_width(int width) {
		this.m_width = width;
	}
	
	public void setm_height(int height) {
		this.m_height = height;
	}
	
	public void setm_refreshRate(int refreshRate) {
		this.m_refreshRate = refreshRate;
	}
	
	
	public void setm_backgroundColor(Color backgroundColor) {
		this.m_backgroundColor = backgroundColor;
	}

	
	/******CLASS METHODS******/
	
	/******Listeners on InternalFrameSimulation1D******/
	private void addListenerInternalFrameSimulation1D(MainWindow1D mainWindow1D){
		addListenerResize(mainWindow1D);//add listener of button TypeOfSimulator
	}
	
	private void addListenerResize(MainWindow1D mainWindow1D){
		this.addComponentListener(new ResizeInternalFrameSimulation1DEvent(mainWindow1D));
	}
	
	
	public void startUpdate() {
			m_millis = 1000/m_refreshRate;
			long before = System.currentTimeMillis();
			if(m_mainWindow1D.getm_simulationState() == SimulationState.RUN){
				m_simulation.update();//Simulation update
			}
			
			//The size of scrollbar update when the size of screen grows
			m_scrollPane.setViewportView(m_screen);  
			m_scrollPane.revalidate();  
			m_scrollPane.repaint();
			
			m_screen.repaint();
			long diff = m_millis - (System.currentTimeMillis() - before);

			try {
				if(diff > 0){
					Thread.sleep(diff);
				}
			}
			catch (Exception e) {
				if(logger.isErrorEnabled()){
				logger.error("Thread.sleep issue.");
			}
			}
	}
	
}
