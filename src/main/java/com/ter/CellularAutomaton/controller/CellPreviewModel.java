package com.ter.CellularAutomaton.controller;


public class CellPreviewModel extends java.util.Observable {
    private boolean[][] mCells;         
    private boolean[][] mTempCells;   

    private int[][] mCellAges;  

    private int mCols; 
    private int mRows;     

    private int mGeneration;   


    public CellPreviewModel(int x, int y) {
        mCells = new boolean[x][y];
        mTempCells = new boolean[x][y];
        mCellAges = new int[x][y];
        mCols = x;
        mRows = y;
    }

    public boolean getCell(int x, int y) {
        if (x < 0 || y < 0 || x > (mCols - 1) || y > (mRows - 1))
            return false;

        return mCells[x][y];
    }


    public int getCellAge(int x, int y) {
        if (x < 0 || y < 0 || x > (mCols - 1) || y > (mRows - 1))
            return 0;

        return mCellAges[x][y];
    }
    public void flipCell(int x, int y) {
        if (x < 0 || y < 0 || x > (mCols - 1) || y > (mRows - 1))
            return;

        mCells[x][y] = !mCells[x][y];
        setChanged();
        notifyObservers();
    }
    
    public void setCell(int x, int y, boolean b) {
        if (x < 0 || y < 0 || x > (mCols - 1) || y > (mRows - 1))
            return;

        mCells[x][y] = b;
        setChanged();
        notifyObservers();
    }

   
    public int getCols() {
        return mCols;
    }
    
    public int getRows() {
        return mRows;
    }


}

