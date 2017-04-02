package com.ter.CellularAutomaton.controller;

import java.awt.*;

import com.ter.CellularAutomaton.vue.IForm;
import com.ter.CellularAutomaton.vue.Simulation2D;

public class Cell2D {
	public static final int CELL_SIZE = 10;

	/******ATTRIBUTES******/
	private int m_x;//Coordinate on the abscissa
	private int m_y;//Coordinate on the ordinate
	private boolean m_isAlive;//true if cell is alive and false if cell is dead
	private boolean m_isAliveNextRound;//true if cell is alive in the next round and false if cell is dead in the next round
	private int m_nbNeighbors;//number of neighbors of the cell
	private IRules2D m_rule;//Rule of evolution
	private IForm m_form;//Form of cells
	private Color m_color;//Color of cells

	/******CONSTRUCTOR******/
	public Cell2D(int x, int y, boolean alive, IRules2D rule, IForm form, Color color) {
		this.m_x = x;
		this.m_y = y;
		this.m_isAlive = alive;
		this.m_nbNeighbors=0;
		this.m_rule=rule;
		this.m_form=form;
		this.m_color=color;
	}
	

	/******GETTERS******/
	public boolean getIsAlive() {
		return m_isAlive;
	}
	
	public int getm_nbNeighbors() {
		return m_nbNeighbors;
	}
	
	/******SETTERS******/
	public void setIsAliveNextRound(boolean isAliveNextRound) {
		this.m_isAliveNextRound = isAliveNextRound;
	}
	
	/*******CLASS METHODS*****/

	public void update() {
		m_isAlive = m_isAliveNextRound;//When a cell update, its state m_isAlive take the value of m_isAliveNextRound
		m_nbNeighbors=0;//When a cell update, we do not know how many neighbors it has, so we must recalculate them. Thus, we set m_nbNeighbors = 0 before recalculating it again
	}
	
	public void increasem_nbNeighbors() {
		m_nbNeighbors++;
	}
	
	public void countNeighbors(Simulation2D simulation) {
        int xMinusOne = m_x - 1;
        if(xMinusOne < 0){
        	xMinusOne = simulation.getm_nbCellWidth()- 1;//The simulator becomes a TOR in width for left border
        }
        int yMinusOne = m_y - 1;
        if(yMinusOne < 0){
        	yMinusOne = simulation.getm_nbCellHeight() - 1;//The simulator becomes a TOR in height for top border
        }
        int xPlusOne = (m_x + 1) % simulation.getm_nbCellWidth();//The simulator becomes a TOR in width for right border
        int yPlusOne = (m_y + 1) % simulation.getm_nbCellHeight();//The simulator becomes a TOR in height for down border
        
        
        if(simulation.getCellInSimulation(xMinusOne,yMinusOne).getIsAlive()){
        	simulation.getCellInSimulation(m_x,m_y).increasem_nbNeighbors();
        }
        if(simulation.getCellInSimulation(xMinusOne,m_y).getIsAlive()){
        	simulation.getCellInSimulation(m_x,m_y).increasem_nbNeighbors();
        }
        if(simulation.getCellInSimulation(xMinusOne,yPlusOne).getIsAlive()){
        	simulation.getCellInSimulation(m_x,m_y).increasem_nbNeighbors();
        }
        if(simulation.getCellInSimulation(m_x,yMinusOne).getIsAlive()){
        	simulation.getCellInSimulation(m_x,m_y).increasem_nbNeighbors();
        }
        if(simulation.getCellInSimulation(m_x,yPlusOne).getIsAlive()){
        	simulation.getCellInSimulation(m_x,m_y).increasem_nbNeighbors();
        }
        if(simulation.getCellInSimulation(xPlusOne,yMinusOne).getIsAlive()){
        	simulation.getCellInSimulation(m_x,m_y).increasem_nbNeighbors();
        }
        if(simulation.getCellInSimulation(xPlusOne,m_y).getIsAlive()){
        	simulation.getCellInSimulation(m_x,m_y).increasem_nbNeighbors();
        }
        if(simulation.getCellInSimulation(xPlusOne,yPlusOne).getIsAlive()){
        	simulation.getCellInSimulation(m_x,m_y).increasem_nbNeighbors();
        }
	}

	
	public void draw(Graphics g) {
		//if the cell is alive
		if(m_isAlive){
			g.setColor(m_color);
			m_form.draw(g, m_x, m_y);//Draw the form of cells
		}
	}
}
