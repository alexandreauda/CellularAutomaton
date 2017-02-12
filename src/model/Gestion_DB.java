package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Gestion_DB {

	//******ATTRIBUT******
	private static Connection connect;//crée un objet de type Connection qui appartient à l'api java

	//******CONSTRUCTEUR PAR DEFAUT******
	public Gestion_DB(){
		Singleton singleton =new Singleton();
		Gestion_DB.connect=singleton.getConnexion();//on se connecte à la base de données. (on initialise la connexion)
	}

	//******CONSTRUCTEUR A PARAMETRE******


	//******METHODE DE CLASSE******

	//Execute une requête de recherche via PreparedStatement
	public ResultSet makePreparedQuerySearch(String query){
		ResultSet result=null;
		//Exécution requête
		try {
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepared_result = connect.prepareStatement(query);
			result=prepared_result.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;//on retourne la table qui est retournée par l'exécution de la query (requête).
	}

	//Execute une requête de modification (INSERT, UPDATE, DELETE) via PreparedStatement
	public void makePreparedQueryUpdate(String query){
		//Exécution requête
		try {
			//On crée l'objet avec la requête en paramètre
			PreparedStatement prepared_result = connect.prepareStatement(query);
			prepared_result.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	//Execute une requête de recherche via ResultSet
	public ResultSet makeQuerySearch(String query){
		Statement state=null;
		ResultSet result=null;

		//Création d'un statement
		try {
			state=connect.createStatement();//initialisation de l'objet state du type Statement qui permet d'exécuter des requêtes. createStatement() possède des paramètres pour indiquer la portée des résultats: readonly...
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Exécution requête
		try {
			result=state.executeQuery(query);//result est la table qui est retournée par l'exécution de la query (requête).
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;//on retourne la table qui est retournée par l'exécution de la query (requête).
	}

	//Execute une requête de modification (INSERT, UPDATE, DELETE) via ResultSet
	public void makeQueryUpdate(String query){
		Statement state=null;

		//Création d'un statement
		try {
			state=connect.createStatement();//initialisation de l'objet state du type Statement qui permet d'exécuter des requêtes. createStatement() possède des paramètres pour indiquer la portée des résultats: readonly...
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Exécution requête
		try {
			state.executeUpdate(query);//on modifie la base avec un INSERT, UPDATE, DELETE
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}


