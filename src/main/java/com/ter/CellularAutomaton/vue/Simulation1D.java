package com.ter.CellularAutomaton.vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ter.CellularAutomaton.controller.Cell1D;
import com.ter.CellularAutomaton.controller.IInitializeSimulationRules1D;

public class Simulation1D {

	/******ATTRIBUTES******/
	// For the logging.
	private static final Logger logger = LogManager.getLogger(Simulation1D.class.getName()); // TestLog4j1.class.getName() must be change in yourClassName.class.getName().

	private Cell1D[] [] m_matrixCells; // Matrix of cells.
	private int m_nbCellWidth; // Number of cells in width in the cell matrix.
	private int m_nbCellHeight; // Number of cells in width in the cell matrix.
	private HashMap<Integer, Integer> m_evolutionRule; // Represent the table of evolution and therefore the rules: for each possible configuration (key) is associated a value of state (value) specify the rule chosen by user.

	private IForm m_formOfCells; // Form of cells.
	private Color m_colorOfCells; // Color of cells.
	private IInitializeSimulationRules1D m_initializeSimulationRule; // Type of initialization of the matrix of cells.

	/******CONSTRUCTOR******/
	public Simulation1D(int width, int height, IForm formOfCells, Color colorOfCells, IInitializeSimulationRules1D initializeSimulationRule) {
		m_nbCellWidth = width/Cell1D.CELL_SIZE;
		m_nbCellHeight = height/Cell1D.CELL_SIZE;
		m_matrixCells = new Cell1D[m_nbCellWidth][m_nbCellHeight];// The simulator is a matrix of cell.
		m_formOfCells=formOfCells;
		m_colorOfCells=colorOfCells;
		m_initializeSimulationRule=initializeSimulationRule;
		m_evolutionRule = new HashMap<Integer, Integer>();
		initByDefaultm_evolutionRule(8,0); // By default, there are 8 possible configurations and each configuration give 0 (which represent evolution state of cell). Thus, by default, the rule of simulation is the rule 0. 

		initByDefaultSimulation(); // Initialize m_matrixCells with Cell configured by default.
	}

	/******GETTERS******/
	public Cell1D getCellInSimulation(int x, int y) {
		try{
			return m_matrixCells[x][y];
		}
		catch(ArrayIndexOutOfBoundsException e){
			if(logger.isFatalEnabled()){
				logger.fatal("Out of bounds");
			}
			return m_matrixCells[x][y];
		}
	}

	public Cell1D[][] getm_cells() {
		return m_matrixCells;
	}

	public int getm_nbCellWidth() {
		return m_nbCellWidth;
	}

	public int getm_nbCellHeight() {
		return m_nbCellHeight;
	}

	public HashMap<Integer, Integer> getm_evolutionRule() {
		return m_evolutionRule;
	}

	public IForm getm_formOfCells() {
		return m_formOfCells;
	}

	public Color getm_colorOfCells() {
		return m_colorOfCells;
	}

	public IInitializeSimulationRules1D getm_initializeSimulationRule() {
		return m_initializeSimulationRule;
	}

	/******SETTERS******/
	public void setm_evolutionRule(HashMap<Integer, Integer> evolutionRule) {
		this.m_evolutionRule = evolutionRule;
	}

	/******CLASS METHODS******/ 
	private void initByDefaultSimulation() {
		// Initialize matrix with Cell (with m_state=0 and m_radius=1 by default).
		for (int y = 0; y < m_nbCellHeight; y++) {
			for (int x = 0; x < m_nbCellWidth; x++) {
				m_matrixCells[x] [y] = new Cell1D(x, y, 0, 1, m_formOfCells, m_colorOfCells, m_evolutionRule);//Create Cell (with m_state=0 and m_radius=1 by default)
			}
		}
	}

	// Initialize simulation according to m_initializeSimulationRule.
	public void specifyInitializeSimulation() {
		m_initializeSimulationRule.initializeSimulation(this);
	}

	private void initByDefaultm_evolutionRule(int lenght, int valueByDefault){
		for(int i=0; i<lenght; i++){
			m_evolutionRule.put(i+1, valueByDefault);
		}
	}

	// Run simulation according to a rule defined by user.
	public void update() {
		int stateEvolutionOfCell;
		// For each cell.
		for (int y = 0; y < m_nbCellHeight-1; y++) {
			for (int x = 0; x < m_nbCellWidth; x++) {
				stateEvolutionOfCell = m_matrixCells[x] [y].findStateEvolution(this); // Find evolution of state of cell.
				m_matrixCells[x][y+1].setm_state(stateEvolutionOfCell); // Set the state of Cell which represent the evolution of current cell to stateEvolutionOfCell (which is  evolution of state of the current cell).
			}
		}
	}

	// Draw every Cell of simulation.
	public void draw(Graphics g) {
		// For each cell.
		for(int x = 0;x < m_nbCellWidth;x++) {
			for (int y = 0; y < m_nbCellHeight; y++) {
				m_matrixCells[x] [y].draw(g); // Draw cell.
			}
		}
	}
}