package com.ter.CellularAutomaton.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

import com.ter.CellularAutomaton.controller.Cell1D;

public class Screen extends JLabel implements MouseMotionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/******ATTRIBUTES******/
	private InternalFrameSimulation1D m_internalFrameSimulation;
	
	
	/******CONSTRUCTOR******/
	public Screen(InternalFrameSimulation1D internalFrameSimulation){
		m_internalFrameSimulation = internalFrameSimulation;
		setPreferredSize(new Dimension(4*m_internalFrameSimulation.getm_width(), 4*m_internalFrameSimulation.getm_height()));
		addListenerInternalFrameSimulation1D();
	}
	
	
	/******CLASS METHODS******/
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(m_internalFrameSimulation.getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		m_internalFrameSimulation.getm_simulation().draw(g);
	}
	
	/******Listeners on InternalFrameSimulation1D******/
	private void addListenerInternalFrameSimulation1D(){
	    this.addMouseMotionListener(this);
	    this.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		 int mx = e.getX()/Cell1D.CELL_SIZE;
		 int my = e.getY()/Cell1D.CELL_SIZE;
		 System.out.println("mouse X="+mx+" et mouse Y= "+my);
		 System.out.println("Vous avez cliqué sur la cellule de coordonne X="+mx+" et Y= "+my);
		 m_internalFrameSimulation.getm_simulation().getCellInSimulation(mx, my).setm_state(1);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
