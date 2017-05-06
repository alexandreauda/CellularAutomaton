package com.ter.CellularAutomaton.vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.ter.CellularAutomaton.controller.IInitializeSimulationRules2D;
import com.ter.CellularAutomaton.controller.IRules2D;

public class InternalFrameSimulation2D extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/******ATTRIBUTES******/
	private int m_width;
	private int m_height;
	private int m_refreshRate; //Updates per seconde
	private int m_millis;
	private Screen m_screen;
	private Simulation2D m_simulation;
	private Color m_backgroundColor;

	/******CONSTRUCTOR******/
	public InternalFrameSimulation2D(String title, IRules2D ruleOfCells, IForm formOfCells, Color colorOfCells, Color backgroundColor, IInitializeSimulationRules2D initializeSimulationRule) {
		super(title,true,true,true,true);
		m_width=1000;
		m_height = 600;
		m_refreshRate = 30;
		m_millis = 1000/m_refreshRate;
		m_simulation = new Simulation2D(m_width, m_height, ruleOfCells, formOfCells, colorOfCells, initializeSimulationRule);
		m_screen = new Screen();
		m_backgroundColor=backgroundColor;
		
		setLayout(new BorderLayout());
		add(m_screen, BorderLayout.CENTER);
		
		this.isClosable();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
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
		
		
		this.setVisible(true);
	}
	
	/******GETTERS******/
	public Simulation2D getm_simulation() {
		return m_simulation;
	}
	
	/******SETTERS******/
	public void setm_refreshRate(int refreshRate) {
		this.m_refreshRate = refreshRate;
	}

	
	/******CLASS METHODS******/
	
	public void startUpdate() {
			m_millis = 1000/m_refreshRate;
			long before = System.currentTimeMillis();
			m_simulation.update();//Simulation update

			m_screen.repaint();
			long diff = m_millis - (System.currentTimeMillis() - before);

			try {
				if(diff > 0) Thread.sleep(diff);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}


	public class Screen extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(m_backgroundColor);
			g.fillRect(0, 0, getWidth(), getHeight());
			m_simulation.draw(g);
		}
	}


}
