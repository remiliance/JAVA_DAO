package Main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//CTRL + SHIFT + O pour g�n�rer les imports
//CTRL + SHIFT + O pour g�n�rer les imports
public class sdzConnection{
//URL de connexion
private String url = "jdbc:postgresql://localhost:5432/Ecole";
//Nom du user
private String user = "postgres";
//Mot de passe de l'utilisateur
private String passwd = "admin";
//Objet Connection
public static Connection connect;
 
//Constructeur priv�
private sdzConnection(){
  try {
    connect = DriverManager.getConnection(url, user, passwd);
  } catch (SQLException e) {
    e.printStackTrace();
  }
}
 
//M�thode qui va nous retourner notre instance et la cr�er si elle n'existe pas
 public static Connection getInstance(){
	 if(connect == null){
		    new sdzConnection();
		    System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
		  }
		  else{
		    System.out.println("CONNEXION SQL EXISTANTE ! ");
		  }
		  return connect;
}   
}
