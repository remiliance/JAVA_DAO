package Main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Connection{

	  /**
	  * URL de connection
	  */
	  private static String url = "jdbc:postgresql://localhost:5432/Ecole";

	  /**
	  * Nom du user
	  */
	  private static String user = "postgres";

	  /**
	  * Mot de passe du user
	  */
	  private static String passwd = "admin";

	  /**
	  * Objet Connection
	  */
	  private static Connection connect=null;

	  /**
	  * Méthode qui va retourner notre instance
	  * et la créer si elle n'existe pas...
	  * @return
	  */
	  public static Connection getInstance(){
	    if(connect == null){
	      try {
	    	  java.sql.Connection conn = DriverManager.getConnection(url, user, passwd);
	      } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
	      }
	    }		
	    return connect;	
	  }
	}