package com.ter.CellularAutomaton.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.ter.CellularAutomaton.vue.CircleForm1D;
import com.ter.CellularAutomaton.vue.DownwardTriangleForm1D;
import com.ter.CellularAutomaton.vue.IForm;
import com.ter.CellularAutomaton.vue.MainWindow1D;
import com.ter.CellularAutomaton.vue.Rectangle3DRaisedForm1D;
import com.ter.CellularAutomaton.vue.Rectangle3DSunkForm1D;
import com.ter.CellularAutomaton.vue.RectangleForm1D;
import com.ter.CellularAutomaton.vue.UpwardTriangleForm1D;

public class ComboBoxFormCellsEvent implements ItemListener {

	/******ATTRIBUTES******/
	MainWindow1D m_mainWindow1D;
	
	public ComboBoxFormCellsEvent(MainWindow1D mainWindow1D){
		m_mainWindow1D = mainWindow1D;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(m_mainWindow1D.getm_comboBoxFormCells().getSelectedItem() == m_mainWindow1D.getm_stringFormCells()[0]){
			IForm rectangleForm = new RectangleForm1D(m_mainWindow1D);
			m_mainWindow1D.setm_modeForm(rectangleForm);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().setm_formOfCells(rectangleForm);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().initByDefaultSimulation();
			}
		else if(m_mainWindow1D.getm_comboBoxFormCells().getSelectedItem() == m_mainWindow1D.getm_stringFormCells()[1]){
			IForm rectangle3DRaisedForm1D = new Rectangle3DRaisedForm1D(m_mainWindow1D);
			m_mainWindow1D.setm_modeForm(rectangle3DRaisedForm1D);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().setm_formOfCells(rectangle3DRaisedForm1D);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().initByDefaultSimulation();
			}
		else if(m_mainWindow1D.getm_comboBoxFormCells().getSelectedItem() == m_mainWindow1D.getm_stringFormCells()[2]){
			IForm rectangle3DSunkForm1D = new Rectangle3DSunkForm1D(m_mainWindow1D);
			m_mainWindow1D.setm_modeForm(rectangle3DSunkForm1D);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().setm_formOfCells(rectangle3DSunkForm1D);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().initByDefaultSimulation();
		}
		else if(m_mainWindow1D.getm_comboBoxFormCells().getSelectedItem() == m_mainWindow1D.getm_stringFormCells()[3]){
			IForm upwardTriangleForm1D = new UpwardTriangleForm1D(m_mainWindow1D);
			m_mainWindow1D.setm_modeForm(upwardTriangleForm1D);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().setm_formOfCells(upwardTriangleForm1D);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().initByDefaultSimulation();
		}
		else if(m_mainWindow1D.getm_comboBoxFormCells().getSelectedItem() == m_mainWindow1D.getm_stringFormCells()[4]){
			IForm downwardTriangleForm1D = new DownwardTriangleForm1D(m_mainWindow1D);
			m_mainWindow1D.setm_modeForm(downwardTriangleForm1D);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().setm_formOfCells(downwardTriangleForm1D);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().initByDefaultSimulation();
		}
		else if(m_mainWindow1D.getm_comboBoxFormCells().getSelectedItem() == m_mainWindow1D.getm_stringFormCells()[5]){
			IForm circleForm1D = new CircleForm1D(m_mainWindow1D);
			m_mainWindow1D.setm_modeForm(circleForm1D);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().setm_formOfCells(circleForm1D);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().initByDefaultSimulation();
		}
		else{
			IForm rectangleForm = new RectangleForm1D(m_mainWindow1D);
			m_mainWindow1D.setm_modeForm(rectangleForm);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().setm_formOfCells(rectangleForm);
			m_mainWindow1D.getm_internalFrameSimulation().getm_simulation().initByDefaultSimulation();
		}
	}

}
