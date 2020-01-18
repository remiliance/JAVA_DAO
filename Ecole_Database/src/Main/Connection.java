package Main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

	//CTRL + SHIFT + O pour g�n�rer les imports
	public class Connection{
	  //URL de connexion
	  private String url = "jdbc:postgresql://localhost:5432/Ecole";
	  //Nom du user
	  private String user = "postgres";
	  //Mot de passe de l'utilisateur
	  private String passwd = "postgres";
	  //Objet Connection
	  private static Connection connect;
	   
	  //Constructeur priv�
	  private Connection(){
	    try {
	      connect = (Connection) DriverManager.getConnection(url, user, passwd);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	   
	  //M�thode qui va nous retourner notre instance et la cr�er si elle n'existe pas
	   public static Connection getInstance(){
	    if(connect == null){
	      new Connection();
	    }
	    return connect;   
	  }   
	}

