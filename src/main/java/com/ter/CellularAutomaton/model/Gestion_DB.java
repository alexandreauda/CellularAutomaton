package com.ter.CellularAutomaton.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Gestion_DB {

	/******ATTRIBUTES******/
	private static Connection connect;//Create a Connection object that belongs to the java API

	/**
	 * ****CONSTRUCTOR BY DEFAULT*****.
	 */
	public Gestion_DB(){
		Singleton singleton =new Singleton();
		Gestion_DB.connect=singleton.getConnexion();//We connect to the database. (The connection is initialized)
	}

	/**
	 * **** CONSTRUCTOR AT PARAMETERS*****.
	 */


	
	
	/**
	 * ****CLASS METHODS*****.
	 */

	// Execute a search query via PreparedStatement
	public ResultSet makePreparedQuerySearch(String query){
		ResultSet result=null;
		// Execute query
		try {
			// We create the object with the query as parameter
			PreparedStatement prepared_result = connect.prepareStatement(query);
			result=prepared_result.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;//We return the table that is returned by the execution of the query.
	}

	//Execute modification query (INSERT, UPDATE, DELETE) via PreparedStatement
	public void makePreparedQueryUpdate(String query){
		//Query execution 
		try {
			//We create the object with the query in parametre
			PreparedStatement prepared_result = connect.prepareStatement(query);
			prepared_result.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	//Execution of a search query via ResultSet
	public ResultSet makeQuerySearch(String query){
		Statement state=null;
		ResultSet result=null;

		//Creation of the statement
		try {
			state=connect.createStatement();//initialisation of the object state of type Statement which is use to execute queries. CreateStatement() has parameters to indicate the configuration of the results: readonly...
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Query execution
		try {
			result=state.executeQuery(query);//result is the table which is returned by the execution of the query.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;//we return the table which is returned by the execution of the query.
	}

	//Execute a query of modification (INSERT, UPDATE, DELETE) via ResultSet
	public void makeQueryUpdate(String query){
		Statement state=null;

		//Création of a statement
		try {
			state=connect.createStatement();//initialisation of an object state of type Statement which is used to execute queries. createStatement() has parameters to indicate the configuration of the results: readonly...
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Exécution requête
		try {
			state.executeUpdate(query);//we modifie the database with INSERT, UPDATE, DELETE
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}


