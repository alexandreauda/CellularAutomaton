package com.ter.CellularAutomaton.vue;

import java.awt.Color;
import java.awt.Graphics;

import com.ter.CellularAutomaton.controller.Cell2D;
import com.ter.CellularAutomaton.controller.IInitializeSimulationRules2D;
import com.ter.CellularAutomaton.controller.IRules2D;

public class Simulation2D {
	
    /******ATTRIBUTES******/
    private Cell2D[] [] m_matrixCells;//Matrix of cells
    private int m_nbCellWidth;//Number of cells in width in the cell matrix
    private int m_nbCellHeight;//Number of cells in width in the cell matrix
    private IRules2D m_cellularAutomaton;//Cellular automaton of simulation. In other hand, the rule of evolution of the cells
    private IForm m_formOfCells;//Form of cells
    private Color m_colorOfCells;//Color of cells
    private IInitializeSimulationRules2D m_initializeSimulationRule;//Type of initialization of the matrix of cells

    /******CONSTRUCTOR******/
    public Simulation2D(int width, int height, IRules2D cellularAutomaton, IForm formOfCells, Color colorOfCells, IInitializeSimulationRules2D initializeSimulationRule) {
        m_nbCellWidth = width/Cell2D.CELL_SIZE;
        m_nbCellHeight = height/Cell2D.CELL_SIZE;
        m_matrixCells = new Cell2D[m_nbCellWidth][m_nbCellHeight];//The simulator is a matrix of cell
        m_cellularAutomaton=cellularAutomaton;
        m_formOfCells=formOfCells;
        m_colorOfCells=colorOfCells;
        m_initializeSimulationRule=initializeSimulationRule;
        
        m_initializeSimulationRule.initializeSimulation(m_matrixCells, m_nbCellWidth, m_nbCellHeight, m_cellularAutomaton, m_formOfCells, m_colorOfCells);//Initialize simulation according to a rule witch is a matrix of cells
        
    }
    
    /******GETTERS******/    

    public Cell2D[][] getm_cells() {
		return m_matrixCells;
	}

	public int getm_nbCellWidth() {
		return m_nbCellWidth;
	}

	public int getm_nbCellHeight() {
		return m_nbCellHeight;
	}
	
	public IRules2D getm_cellularAutomaton() {
			return m_cellularAutomaton;
	}
	
	public IForm getm_formOfCells() {
		return m_formOfCells;
	}
	
	public Color getm_colorOfCells() {
		return m_colorOfCells;
	}
	
	public IInitializeSimulationRules2D getm_initializeSimulationRule() {
		return m_initializeSimulationRule;
	}

	/******CLASS METHODS******/ 
	
    public void update() {
    	//For each cell
        for(int x = 0;x < m_nbCellWidth;x++) {
            for (int y = 0; y < m_nbCellHeight; y++) {
            	
            	m_matrixCells[x] [y].countNeighbors(this);//Count Neighbors
            	m_cellularAutomaton.applyRules(m_matrixCells[x] [y]);//Apply the rule of evolution
            }
        }
        //update each cell of Simulation to next state
        for(int x = 0;x < m_nbCellWidth;x++) {
            for (int y = 0; y < m_nbCellHeight; y++) {
                m_matrixCells[x] [y].update();
            }
        }
    }
    

    public Cell2D getCellInSimulation(int x, int y) {
		return m_matrixCells[x][y];
	}
    
    public void draw(Graphics g) {
        for(int x = 0;x < m_nbCellWidth;x++) {
            for (int y = 0; y < m_nbCellHeight; y++) {
                m_matrixCells[x] [y].draw(g);
            }
        }
    }
}