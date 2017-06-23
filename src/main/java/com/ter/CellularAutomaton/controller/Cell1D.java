package com.ter.CellularAutomaton.controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.ter.CellularAutomaton.vue.IForm;
import com.ter.CellularAutomaton.vue.Simulation1D;

public class Cell1D implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int CELL_SIZE = 10;

	/******ATTRIBUTES******/
	// For the logging.
	//private static final Logger logger = LogManager.getLogger(Cell1D.class.getName()); // TestLog4j1.class.getName() must be change in yourClassName.class.getName().
	
	private int m_x; // Coordinate on the abscissa.
	private int m_y; // Coordinate on the ordinate.
	private int m_state; // State of the cell (has to be in the alphabet of the user).
	private int m_radius; // Radius of the cell.
	private int m_rules;// Rules of the cell.
	private ArrayList<Integer> m_stateOfSelfAndNeighbour;
	private int m_stateEvolution; // State of the next cell (has to be in the alphabet of the user).

	private IForm m_form;//Form of cells
	private ArrayList<Color> m_color;//Color of cells

	/******CONSTRUCTOR******/
	public Cell1D(int x, int y, int state, int radius, int rules, IForm form, ArrayList<Color> color) {
		this.m_x = x;
		this.m_y = y;
		this.m_state = state;
		this.m_radius = radius;
		this.m_rules=rules;
		this.m_form=form;
		this.m_color=color;
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
	
	public int getm_radius() {
		return m_radius;
	}
	
	public int getm_rules() {
		return m_rules;
	}
	
	public ArrayList<Integer> getm_stateOfSelfAndNeighbour() {
		return m_stateOfSelfAndNeighbour;
	}

	/******SETTERS******/	
	public void setm_state(int state) {
		this.m_state = state;
	}
	
	public void setm_radius(int radius) {
		this.m_radius = radius;
	}
	
	public void setm_rules(int rules) {
		this.m_rules = rules;
	}
	
	public void setm_color(ArrayList<Color> color) {
		this.m_color = color;
	}

	/*******CLASS METHODS*****/
	
	//Convert a string binary number to int decimal number
	private static int convertBinaryStringToDecimalInt(String binaryNumber){
		//Convert
		int numberConvertToDecimal=Integer.parseInt(binaryNumber,2);//Convert number binary to decimal
		return numberConvertToDecimal;//return decimal number
	}

	//Init attributes m_stateOfSelfAndNeighbour with the state of Neighbors Cells and himself
	private void initm_stateOfSelfAndNeighbour(Simulation1D simulation){
		m_stateOfSelfAndNeighbour = new ArrayList<Integer>(); // Build the list.
		int currentStateOfCell=0;
		int i= -m_radius;
		int xAcualPositionOfCell;
		while(i <= m_radius){
			xAcualPositionOfCell=m_x+i;
			if(xAcualPositionOfCell < 0){
				xAcualPositionOfCell = simulation.getm_nbCellWidth() + xAcualPositionOfCell;//The simulator becomes a TOR in width for left border
			}
			else{
				xAcualPositionOfCell = xAcualPositionOfCell % simulation.getm_nbCellWidth();//The simulator becomes a TOR in width for right border
			}
			currentStateOfCell=simulation.getCellInSimulation(xAcualPositionOfCell,m_y).getm_state();//Stock state of Neighbor Cell
			m_stateOfSelfAndNeighbour.add(currentStateOfCell);//Set state of Neighbor Cell in ArrayList m_stateOfSelfAndNeighbour
			i++;
		}
	}
	
	//Convert neighborhood configuration to binary number and transform the binary number to decimal int
	private int transformNeighborhoodConfigurationToDecimalInt() {
		String configurationToBinaryString = "";
		for(int i=0; i<m_stateOfSelfAndNeighbour.size();i++){
			configurationToBinaryString += m_stateOfSelfAndNeighbour.get(i).toString();//Build the binary string representation of neighborhood configuration
		}
		int k = convertBinaryStringToDecimalInt(configurationToBinaryString);//Tranform the binary string representation of neighborhood configuration to decimal int and stock it
		return k;
	}
	
	//Depending on the configuration of its neighbor and itself, init attribute m_stateEvolution and return the state specify by the rules and chosen by user
	public int findStateEvolution(Simulation1D simulation){
		initm_stateOfSelfAndNeighbour(simulation); // Initialize m_stateOfSelfAndNeighbour.
		int k = transformNeighborhoodConfigurationToDecimalInt();//Stock decimal int which represent neighborhood configuration
		m_stateEvolution = (int) ((m_rules & (int)(Math.pow(2, k))) / Math.pow(2, k)); // Calculation the evolution of state of the cell depending on the rule chosen by user and neighborhood configuration and initialize the attribute m_stateEvolution with the result (it equivalent to (m_rules & (1<<k)>>k) but fix bug when k is huge).
		return m_stateEvolution;//Return value that the configuration give according to the rule chosen by user
	}


	//Draw Cell
	public void draw(Graphics g) {
		g.setColor(m_color.get(m_state));//The cell which have a state take the color associate.
		m_form.draw(g, m_x, m_y);//Draw the form of cells
	}
}
