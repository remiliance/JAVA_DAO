package Main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class sdzConnection{

	  private static String url = "jdbc:postgresql://localhost:5432/Ecole";

	  private static String user = "postgres";

	  private static String passwd = "admin";
	  private static Connection connect;
//	  private static sdzConnection connect=null;

	  public static Connection getInstance(){
	    if(connect == null){
	      try {
	    	 connect = DriverManager.getConnection(url, user, passwd);
	    	  System.out.println("CONNEXION ! ");
	      } catch (SQLException e) {
	      System.out.println("ERREUR DE CONNEXION ! ");
	      }}
	      else
	    	  System.out.println("Déjà connecté");
	    	
	    return connect;	
	  }
	}