package com.ter.CellularAutomaton.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JLabel;
import com.ter.CellularAutomaton.controller.Cell1D;

public class Screen extends JLabel implements MouseMotionListener, MouseListener, MouseWheelListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/******ATTRIBUTES******/
	private InternalFrameSimulation1D m_internalFrameSimulation;
	private int m_screenWidth;
	private int m_screenHeight;
	
	/******CONSTRUCTOR******/
	public Screen(InternalFrameSimulation1D internalFrameSimulation){
		m_internalFrameSimulation = internalFrameSimulation;
		m_screenWidth = 10*m_internalFrameSimulation.getm_width();
		m_screenHeight = 10*m_internalFrameSimulation.getm_height();
		setPreferredSize(new Dimension(m_screenWidth, m_screenHeight));
		addListenerInternalFrameSimulation1D();
	}
	
	/******GETTERS******/
	public int getm_screenWidth() {
		return m_screenWidth;
	}
	
	public int getm_screenHeight() {
		return m_screenHeight;
	}
	
	/******SETTERS******/
	public void setm_screenWidth(int screenWidth) {
		this.m_screenWidth = screenWidth;
	}
	
	public void setm_screenHeight(int screenHeight) {
		this.m_screenHeight = screenHeight;
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
	    this.addMouseWheelListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	    int buttonDown = e.getButton();// stock the button of the mouse which is pushed
	    
	    // If the LEFT button is pushed
		if(buttonDown == MouseEvent.BUTTON1) {
			 int mx = e.getX()/Cell1D.CELL_SIZE;
			 int my = e.getY()/Cell1D.CELL_SIZE;
			 System.out.println("mouse X="+mx+" and mouse Y= "+my);
			 System.out.println("You are click on the cell of coordonne X="+mx+" and Y= "+my);
			 if(mx <= m_internalFrameSimulation.getm_simulation().getm_nbCellWidth() && my <= m_internalFrameSimulation.getm_simulation().getm_nbCellHeight()){
				 if(m_internalFrameSimulation.getm_simulation().getCellInSimulation(mx, my).getm_state() == 0){
					 m_internalFrameSimulation.getm_simulation().getCellInSimulation(mx, my).setm_state(1); 
				 }
				 else {
					 m_internalFrameSimulation.getm_simulation().getCellInSimulation(mx, my).setm_state(0);
				}
			 }
		}
		// If the CENTER button is pushed
		else if(buttonDown == MouseEvent.BUTTON2){
			
		}
		// If the RIGTH button is pushed
		else if(buttonDown == MouseEvent.BUTTON3){
			 int mx = e.getX()/Cell1D.CELL_SIZE;
			 int my = e.getY()/Cell1D.CELL_SIZE;
			 System.out.println("mouse X="+mx+" and mouse Y= "+my);
			 System.out.println("You are click on the cell of coordonne X="+mx+" and Y= "+my);
			 LocalElementaryRulesWindow localElementaryRulesWindow = new LocalElementaryRulesWindow(m_internalFrameSimulation, m_internalFrameSimulation.getm_simulation().getCellInSimulation(mx, my));
		}
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


	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
			int mouseRot = arg0.getWheelRotation();
		     
		    if (mouseRot < 0){
		    	Cell1D.CELL_SIZE *= 2;
//		    	m_screenWidth = m_internalFrameSimulation.getm_simulation().getm_nbCellWidth() * Cell1D.CELL_SIZE;
//		    	m_screenHeight = m_internalFrameSimulation.getm_simulation().getm_nbCellHeight() * Cell1D.CELL_SIZE;
//		    	this.setPreferredSize(new Dimension(m_screenWidth, m_screenHeight));
		    }
		    else if(mouseRot > 0){
		    	if(Cell1D.CELL_SIZE > 2){
		        	Cell1D.CELL_SIZE /= 2;
//		        	m_screenWidth = m_internalFrameSimulation.getm_simulation().getm_nbCellWidth() * Cell1D.CELL_SIZE;
//				    m_screenHeight = m_internalFrameSimulation.getm_simulation().getm_nbCellHeight() * Cell1D.CELL_SIZE;
//				    this.setPreferredSize(new Dimension(m_screenWidth, m_screenHeight));
		         }
		    }
		else{
			
			//m_internalFrameSimulation.getm_scrollPane().getVerticalScrollBar().setValue(r);
		}
	}


}
