package com.ter.CellularAutomaton.controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ter.CellularAutomaton.vue.IForm;
import com.ter.CellularAutomaton.vue.Simulation1D;

public class Cell1D {
	public static final int CELL_SIZE = 10;

	/******ATTRIBUTES******/
	// For the logging.
	private static final Logger logger = LogManager.getLogger(Cell1D.class.getName()); // TestLog4j1.class.getName() must be change in yourClassName.class.getName().
	
	private int m_x; // Coordinate on the abscissa.
	private int m_y; // Coordinate on the ordinate.
	private int m_state; // State of the cell (has to be in the alphabet of the user).
	private int m_radius; // Radius of the cell.
	private ArrayList<Integer> m_stateOfSelfAndNeighbour;
	private int m_stateEvolution; // State of the next cell (has to be in the alphabet of the user).
	private HashMap<Integer, Integer> m_evolutionRule;//Represent the table of evolution and therefore the rules: for each possible configuration (key) is associated a value of state (value) specify the rule chosen by user

	private IForm m_form;//Form of cells
	private ArrayList<Color> m_color;//Color of cells

	/******CONSTRUCTOR******/
	public Cell1D(int x, int y, int state, int radius, IForm form, ArrayList<Color> color, HashMap<Integer, Integer> evolutionRule) {
		this.m_x = x;
		this.m_y = y;
		this.m_state = state;
		this.m_radius = radius;
		this.m_form=form;
		this.m_color=color;
		this.m_evolutionRule=evolutionRule;
	}


	/******GETTERS******/
	public int getm_x() {
		return m_x;
	}
	
	public int getm_y() {
		return m_y;
	}
	
	public int getm_state() {
		return m_state;
	}
	
	public ArrayList<Integer> getm_stateOfSelfAndNeighbour() {
		return m_stateOfSelfAndNeighbour;
	}
	
	public HashMap<Integer, Integer> getm_evolutionRule() {
		return m_evolutionRule;
	}

	/******SETTERS******/
	public void setm_evolutionRule(HashMap<Integer, Integer> evolutionRule) {
		this.m_evolutionRule = evolutionRule;
	}
	
	public void setm_state(int state) {
		this.m_state = state;
	}
	
	public void setm_color(ArrayList<Color> color) {
		this.m_color = color;
	}

	/*******CLASS METHODS*****/

	//Init attributes m_stateOfSelfAndNeighbour with the state of Neighbors Cells and himself
	private void initm_stateOfSelfAndNeighbour(Simulation1D simulation){
		final int LenghtStateOfSelfAndNeighbour = 2 * m_radius + 1; // Number of the cell itself and its neighbors.
		m_stateOfSelfAndNeighbour = new ArrayList<Integer>(); // Build the list with an initial capacity.
		int currentStateOfCell=0;
		int xAcualPositionOfCell=m_x-m_radius;
		for(int i=0; i<LenghtStateOfSelfAndNeighbour; i++){
			xAcualPositionOfCell+=i;
			if(xAcualPositionOfCell < 0){
				xAcualPositionOfCell = simulation.getm_nbCellWidth()+ (m_x-m_radius+i);//The simulator becomes a TOR in width for left border
			}
			else{
				xAcualPositionOfCell = (m_x-m_radius+i) % simulation.getm_nbCellWidth();//The simulator becomes a TOR in width for right border
			}
			currentStateOfCell=simulation.getCellInSimulation(xAcualPositionOfCell,m_y).getm_state();//Stock state of Neighbor Cell
			m_stateOfSelfAndNeighbour.add(currentStateOfCell);//Set state of Neighbor Cell in ArrayList m_stateOfSelfAndNeighbour
		}
	}
	
	//Depending on the configuration of its neighbor and itself specify in attribute m_stateOfSelfAndNeighbour, return a id
		private int returnConfiguration(){
			int idOfConfiguration = 0;
			final int lenght = m_stateOfSelfAndNeighbour.size();
			if(lenght==3){
				int one = m_stateOfSelfAndNeighbour.get(0);
				int two = m_stateOfSelfAndNeighbour.get(1);
				int three = m_stateOfSelfAndNeighbour.get(2);

				if(one==0 && two==0 && three==0){
					idOfConfiguration = 1;
				}
				else if(one==0 && two==0 && three==1){
					idOfConfiguration = 2;
				}
				else if(one==0 && two==1 && three==0){
					idOfConfiguration = 3;
				}
				else if(one==0 && two==1 && three==1){
					idOfConfiguration = 4;
				}
				else if(one==1 && two==0 && three==0){
					idOfConfiguration = 5;
				}
				else if(one==1 && two==0 && three==1){
					idOfConfiguration = 6;
				}
				else if(one==1 && two==1 && three==0){
					idOfConfiguration = 7;
				}
				else if(one==1 && two==1 && three==1){
					idOfConfiguration = 8;
				}
				//If a m_state of one of cell is not in alphabet (0 or 1)
				else{
					if(logger.isErrorEnabled()){
						logger.error("Configuration not valid.");//Log a error
					}
					idOfConfiguration = 0;//If a m_state of one of cell is not in alphabet (0 or 1) return 0 = impossible configuration
				}
							
			}
			return idOfConfiguration;//return a id, depending on the configuration of its neighbor and itself specify in attribute m_stateOfSelfAndNeighbour
		}
	
	
	//Depending on the configuration of its neighbor and itself, init attribute m_stateEvolution and return the state specify by the rules and chosen by user
	public int findStateEvolution(Simulation1D simulation){
		initm_stateOfSelfAndNeighbour(simulation); // Initialize m_stateOfSelfAndNeighbour.
		int numberOfActualConfigurationCell = returnConfiguration();//Stock id of configuration
		m_stateEvolution=m_evolutionRule.get(numberOfActualConfigurationCell);//Set attribute m_stateEvolution with value that the configuration give according to the rule chosen by user
		return m_evolutionRule.get(numberOfActualConfigurationCell);//Return value that the configuration give according to the rule chosen by user
	}


	//Draw Cell
	public void draw(Graphics g) {
		g.setColor(m_color.get(m_state));//The cell which have a state take the color associate.
		m_form.draw(g, m_x, m_y);//Draw the form of cells
	}
}
