package com.ter.CellularAutomaton.controller;

public class ConwayRules2D implements IRules2D{

	@Override
	public void applyRules(Cell2D cell) {
		//If a cell has strictly less than two or strictly more than three living neighbors
        if(cell.getm_nbNeighbors() < 2 || cell.getm_nbNeighbors() > 3){
        	cell.setIsAliveNextRound(false);//The cell died in the next step.
        }
        //If a cell has exactly two neighbors alive
        else if(cell.getm_nbNeighbors() == 2){
        	cell.setIsAliveNextRound(cell.getIsAlive());//The cell remains in its current state in the next step.
        }
        //If a cell has exactly three neighbors alive
        else{
        	cell.setIsAliveNextRound(true);//The cell is alive in the next step.
        }
	}

}
