package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//We implement the Singleton patern: we regroup the code use to make the connection between java and the database.
//This patern is used to have only one connection.
public class Singleton {

	//******ATTRIBUTES******
	private static String pilote;

	private static String url;
	private static String login;
	private static String passord;

	private static Connection connect;


	//******DEFAULT CONSTRUCTEOR******
	public Singleton(){
		this("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/CellularAutomat", "CellularAutomat", "CeYzZsXtr5TxVtFV", null);
	}

	//******PARAMETERS CONSTRUCTOR******
	public Singleton(String pilote, String url, String login, String passord, Connection connect){
		Singleton.pilote=pilote;
		Singleton.url=url;
		Singleton.login=login;
		Singleton.passord=passord;
		Singleton.connect=connect;
	}

	//******GETTERS AND SETTERS******
	public static String getPilote() {
		return pilote;
	}


	public static void setPilote(String pilote) {
		Singleton.pilote = pilote;
	}


	public static String getUrl() {
		return url;
	}


	public static void setUrl(String url) {
		Singleton.url = url;
	}


	public static String getLogin() {
		return login;
	}


	public static void setLogin(String login) {
		Singleton.login = login;
	}


	public static String getPassord() {
		return passord;
	}


	public static void setPassord(String passord) {
		Singleton.passord = passord;
	}


	public static Connection getConnect() {
		return connect;
	}


	public static void setConnect(Connection connect) {
		Singleton.connect = connect;
	}


	//******CLASS METHODS******
	public Connection getConnexion(){

		if(connect==null){//If the attribute is null, there hasen't been a precedent connection: therefore we connect
			try {
				// Etape 1: load the driver
				Class.forName(pilote);
				// Etape 2: Retrieve the connection
				connect=DriverManager.getConnection(url, login, passord);
			}  
			// manage the exceptions
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		else{//else if the object connect is already initialize, we have already connect. Therefore we don't have to connect.
			System.out.println("Connection SQL existante");
		}
		return connect;	//return the connection of type Connection which is contain à l'api java
	}




}

