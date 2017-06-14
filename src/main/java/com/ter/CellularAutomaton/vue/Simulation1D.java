package com.ter.CellularAutomaton.vue;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ter.CellularAutomaton.controller.Cell1D;
import com.ter.CellularAutomaton.controller.IInitializeSimulationRules1D;

public class Simulation1D implements Serializable {

	/******ATTRIBUTES******/
	// For the logging.
	private static final Logger logger = LogManager.getLogger(Simulation1D.class.getName()); // TestLog4j1.class.getName() must be change in yourClassName.class.getName().

	private ArrayList<ArrayList<Cell1D>> m_matrixCells; // Matrix of cells.
	private int m_nbCellWidth; // Number of cells in width in the cell matrix.
	private int m_nbCellHeight; // Number of cells in width in the cell matrix.
	private int m_idOfLines;
	private int m_globalRadius;// Global radius of the simulation.
	private int m_globalRules;// Global rules of the simulation.
	private IForm m_formOfCells; // Form of cells.
	private ArrayList<Color> m_colorOfCells; // Color of cells.
	private IInitializeSimulationRules1D m_initializeSimulationRule; // Type of initialization of the matrix of cells.

	/******CONSTRUCTOR******/
	public Simulation1D(int width, int height, int globalRadius, int globalRules, IForm formOfCells, ArrayList<Color> colorOfCells, IInitializeSimulationRules1D initializeSimulationRule) {
		m_idOfLines=0;
		m_nbCellWidth = width/Cell1D.CELL_SIZE;
		m_nbCellHeight = height/Cell1D.CELL_SIZE;
		m_matrixCells = new ArrayList<ArrayList<Cell1D>>();// The simulator is a matrix of cell.
		m_globalRadius = globalRadius;
		m_globalRules=globalRules;
		m_formOfCells=formOfCells;
		m_colorOfCells=colorOfCells;
		m_initializeSimulationRule=initializeSimulationRule; 

		initByDefaultSimulation(); // Initialize m_matrixCells with Cell configured by default.
	}

	/******GETTERS******/
	public Cell1D getCellInSimulation(int x, int y) {
		try{
			return m_matrixCells.get(x).get(y);
		}
		catch(ArrayIndexOutOfBoundsException e){
			if(logger.isFatalEnabled()){
				logger.fatal("Out of bounds");
			}
			e.printStackTrace();
			return m_matrixCells.get(x).get(y);
		}
	}

	public ArrayList<ArrayList<Cell1D>> getm_cells() {
		return m_matrixCells;
	}
	
	public int getm_nbCellWidth() {
		return m_nbCellWidth;
	}

	public int getm_nbCellHeight() {
		return m_nbCellHeight;
	}
	
	public int getm_globalRadius() {
		return m_globalRadius;
	}
	
	public int getm_globalRules() {
		return m_globalRules;
	}

	public IForm getm_formOfCells() {
		return m_formOfCells;
	}

	public ArrayList<Color> getm_colorOfCells() {
		return m_colorOfCells;
	}

	public IInitializeSimulationRules1D getm_initializeSimulationRule() {
		return m_initializeSimulationRule;
	}
	
	public int getm_idOfLines() {
		return m_idOfLines;
	}

	/******SETTERS******/
	public void setm_nbCellWidth(int nbCellWidth) {
		this.m_nbCellWidth = nbCellWidth;
	}
	
	public void setm_nbCellHeight(int nbCellHeight) {
		this.m_nbCellHeight = nbCellHeight;
	}
	
	public void setm_globalRadius(int globalRadius) {
		this.m_globalRadius = globalRadius;
	}
	
	public void setm_globalRules(int globalRules) {
		this.m_globalRules = globalRules;
	}
	
	public void setm_idOfLines(int idOfLines) {
		this.m_idOfLines = idOfLines;
	}
	
	public void setm_formOfCells(IForm formOfCells) {
		this.m_formOfCells = formOfCells;
	}

	/******CLASS METHODS******/ 
	public void initByDefaultSimulation() {
		// Initialize matrix with Cell (with m_state=0 and m_radius=1 by default).
		m_matrixCells.removeAll(m_matrixCells);
		for (int x = 0; x < m_nbCellWidth; x++) {
			ArrayList<Cell1D> columnOfCells = new ArrayList<Cell1D>();
			for (int y = 0; y < m_nbCellHeight; y++) {
				columnOfCells.add(new Cell1D(x, y, 0, 1, 0, m_formOfCells, m_colorOfCells));
			}
			m_matrixCells.add(columnOfCells);//Create Cell (with m_state=0 and m_radius=1 by default)
		}
	}

	// Initialize simulation according to m_initializeSimulationRule.
	public void specifyInitializeSimulation() {
		m_initializeSimulationRule.initializeSimulation(this);
	}
	
	//For each cell of Simulation, set the radius and rules of the cell  with the Radius and the Rules specify in parameter.
		public void initRadiusAndRulesCellLocally(int x1, int x2, int localRadius, int localRule){
			// For each cell of the region area.
			for(int x = x1;x < x2;x++) {
				for (int y = 0; y < m_nbCellHeight; y++) {
					m_matrixCells.get(x).get(y).setm_radius(localRadius);//Set the radius of the cell with the Radius specify in parameter.
					m_matrixCells.get(x).get(y).setm_rules(localRule);//Set the rules of the cell with the Rule specify in parameter.
				}
			}
		}
		
		//For each cell of Simulation, set the radius and rules of the cell  with the Radius and the Rules specify in parameter.
				public void initRadiusAndRulesCellLocally(int x1, int x2, int y1, int y2, int localRadius, int localRule){
					// For each cell of the region area.
					for(int x = x1;x < x2;x++) {
						for (int y = y1; y < y2; y++) {
							m_matrixCells.get(x).get(y).setm_radius(localRadius);//Set the radius of the cell with the Radius specify in parameter.
							m_matrixCells.get(x).get(y).setm_rules(localRule);//Set the rules of the cell with the Rule specify in parameter.
						}
					}
				}
	
	//For each cell of Simulation, set the radius and rules of the cell  with the global Radius and the global Rules of Simulation.
	public void initRadiusAndRulesCellWithGlobalRadiusAndRulesSimulation(){
		// For each cell.
		for(int x = 0;x < m_nbCellWidth;x++) {
			for (int y = 0; y < m_nbCellHeight; y++) {
				m_matrixCells.get(x).get(y).setm_radius(m_globalRadius);//Set the radius of the cell with the global Radius of Simulation.
				m_matrixCells.get(x).get(y).setm_rules(m_globalRules);//Set the rules of the cell with the global rules of Simulation.
			}
		}
	}

	//For each cell of Simulation, set the m_state to 0 (value by default)
		public void resetSimulation(){
			// For each cell.
			for(int x = 0;x < m_nbCellWidth;x++) {
				for (int y = 0; y < m_nbCellHeight; y++) {
					m_matrixCells.get(x).get(y).setm_state(0);//Set the m_state to 0 (value by default)
					m_matrixCells.get(x).get(y).setm_radius(1);//Set the m_radius to 1 (value by default)
					m_matrixCells.get(x).get(y).setm_rules(0);//Set the m_rules to 0 (value by default)
				}
			}
		}
	
	// Run simulation according to a rule defined by user.
	public void update() {
		int stateEvolutionOfCell;
		//if cursor is smaller than the number of cell in height.
		if ( m_idOfLines < m_nbCellHeight-1) {
			// For each cell.
			for (int x = 0; x < m_nbCellWidth; x++) {
				stateEvolutionOfCell = m_matrixCells.get(x).get(m_idOfLines).findStateEvolution(this); // Find evolution of state of cell.
				m_matrixCells.get(x).get(m_idOfLines+1).setm_state(stateEvolutionOfCell); // Set the state of Cell which represent the evolution of current cell to stateEvolutionOfCell (which is  evolution of state of the current cell).
			}
			m_idOfLines++;//increment cursor
		}
		else{
			m_nbCellHeight++; //increment the number of cell in height.
			for(int x = 0; x < m_nbCellWidth; x++){
				m_matrixCells.get(x).add(new Cell1D(x, m_nbCellHeight-1, 0, m_globalRadius, m_globalRules, m_formOfCells, m_colorOfCells));//Add default cell in arrayList
			}
		}
	}

	// Draw every Cell of simulation.
	public void draw(Graphics g) {
		// For each cell.
		for(int x = 0;x < m_nbCellWidth;x++) {
			for (int y = 1; y < m_nbCellHeight; y++) {
				m_matrixCells.get(x).get(y-1).draw(g); // Draw cell.
			}
		}
	}
}