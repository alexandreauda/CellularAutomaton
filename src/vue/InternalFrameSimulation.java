package vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import controller.IInitializeSimulationRules;
import controller.IRules;

public class InternalFrameSimulation extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/******ATTRIBUTES******/
	private int m_width;
	private int m_height;
	private int m_refreshRate; //Updates per seconde
	private final int m_millis;
	private Screen m_screen;
	private Simulation m_simulation;
	private Color m_backgroundColor;

	/******CONSTRUCTOR******/
	public InternalFrameSimulation(String title, IRules ruleOfCells, IForm formOfCells, Color colorOfCells, Color backgroundColor, IInitializeSimulationRules initializeSimulationRule) {
		super(title,true,true,true,true);
		m_width=1000;
		m_height = 600;
		m_refreshRate = 30;
		m_millis = 1000/m_refreshRate;
		m_simulation = new Simulation(m_width, m_height, ruleOfCells, formOfCells, colorOfCells, initializeSimulationRule);
		m_screen = new Screen();
		m_backgroundColor=backgroundColor;
		
		setLayout(new BorderLayout());
		add(m_screen, BorderLayout.CENTER);
		
		this.isClosable();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setSize(m_width + this.getInsets().left +  + this.getInsets().right, m_height + this.getInsets().bottom +  + this.getInsets().top);
		this.setVisible(true);
	}

	
	/******CLASS METHODS******/
	
	public void startUpdate() {

			long before = System.currentTimeMillis();
			m_simulation.update();

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
