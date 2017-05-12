package com.ter.CellularAutomaton.controller;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CellPreviewPanel extends JComponent implements Observer {
    private int mCols;
    private int mRows;
    private int mCellSize;

    private Color mOutlineColor; // Outline color

    private CellPreviewModel mCellModel;

    private boolean mShowCellOutlines = true; // Show outlines by default
    private boolean mShowAging;

    public CellPreviewPanel(CellPreviewModel model, int cellSize) {
        setDoubleBuffered(true);
        mCellModel = model;
        model.addObserver(this);
        mCols = model.getCols();
        mRows = model.getRows();
        mCellSize = cellSize;

        // Default colors
        setForeground(Color.black);
        setBackground(Color.white);
        setOutline(Color.lightGray);

        setSize(mCellSize * mCols, mCellSize * mRows);
        setPreferredSize(new Dimension(mCellSize * mCols, mCellSize * mRows));
    }

    public void setOutline(Color c) {
        mOutlineColor = c;
    }
    
    public void showCellOutlines(boolean b) {
        this.mShowCellOutlines = b;
    }
    public void update(Graphics g) {
        return; // do nothing
    }
    
    public void update(Observable t, Object o) {
        repaint();
    }

   
    private Color lightenColor(Color c, int age) {
        int red = c.getRed();
        int green = c.getGreen();
        int blue = c.getBlue();
        int alpha = c.getAlpha();

        double p = 1.0 - (0.05 * age);

        if (p > 0.20) {
            alpha = (int)(p * alpha);
        } else {
            alpha = (int)(0.20 * alpha);
        }

        return new Color(red, green, blue, alpha);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int width = getSize().width;
        int height = getSize().height;

        // Clear the panel.
        g2d.setPaint(getBackground());
        g2d.fill(new Rectangle(0, 0, width, height));

        g2d.setPaint(getForeground());
        for (int i = 0; i < mCols; i++) {
            for (int j = 0; j < mRows; j++) {
                if (mCellModel.getCell(i, j)) {
                    // If cell aging is enabled, draw aged cells
                    int age = 0;
                    if (mShowAging) {
                        age = mCellModel.getCellAge(i, j);
                        g2d.setPaint(lightenColor(getForeground(), age));
                    }
                    g2d.fillRect(i * mCellSize,
                                 j * mCellSize,
                                 mCellSize,
                                 mCellSize);
                    if (mShowAging) {
                        g2d.setPaint(getForeground());
                    }
                }
            }
        }

        // Show outlines if desired
        if (mShowCellOutlines) {
            drawCellOutlines(g2d);
        }
    }

    public Color getOutline() {
        return mOutlineColor;
    }
    public void setCellAging(boolean b) {
        mShowAging = b;
    }

    private void drawCellOutlines(Graphics2D g2d) {
        g2d.setPaint(mOutlineColor);
        g2d.setStroke(new BasicStroke(1.0f));

        int width = getSize().width;
        int height = getSize().height;

        // Draw rectangle outlining the entire component
        g2d.draw(new Rectangle(0, 0, width - 1, height - 1));

        // Draw the vertical lines
        for (int i = 0; i < mCols; i++) {
            g2d.drawLine(i * mCellSize, 0, i * mCellSize, height);
        }

        // Draw the horizontal lines
        for (int j = 0; j < mRows; j++) {
            g2d.drawLine(0, j * mCellSize, width, j * mCellSize);
        }
    }
}
