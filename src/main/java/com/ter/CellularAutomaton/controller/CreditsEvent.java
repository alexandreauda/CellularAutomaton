package com.ter.CellularAutomaton.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.ter.CellularAutomaton.model.Gestion_DB;
import com.ter.CellularAutomaton.vue.CreditsWindow;

public class CreditsEvent implements ActionListener {

	/******ATTRIBUTES******/
	static final String imgPath = "Files/Images/error_icon.jpg";
	ImageIcon img = new ImageIcon(imgPath);


	/**
	 * ****CLASS METHODS*****.
	 */

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		Gestion_DB gestionDB = new Gestion_DB();
		final String query = "SELECT * FROM contributor";
		ResultSet result = gestionDB.makePreparedQuerySearch(query);
		final String title = "CONTRIBUTORS";
		StringBuilder listContributors = new StringBuilder();
		try {
			while (result.next()){
				listContributors.append(result.getString(3)+" "+result.getString(2)+"\n");
			}
		} catch (SQLException e1) {
			String errorMessage = "Message error: \n "+e1.getMessage();
			System.out.println(errorMessage);
			JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, img);            
		}
		finally{
			CreditsWindow creditsWindow = new CreditsWindow(title, listContributors);
		}

	}

}
