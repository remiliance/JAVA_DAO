package Main;

import java.sql.Connection;

public class DAOFactory {

	  protected static final Connection conn = sdzConnection.getInstance();   
	   
	  /**
	  * Retourne un objet Classe interagissant avec la BDD
	  * @return DAO
	  */
	  public static DAO getClasseDAO(){
	    return new ClasseDAO(conn);
	  }

	  /**
	  * Retourne un objet Professeur interagissant avec la BDD
	  * @return DAO
	  */
	  public static DAO getProfesseurDAO(){
	    return new ProfesseurDAO(conn);
	  }

	  /**
	  * Retourne un objet Eleve interagissant avec la BDD
	  * @return DAO
	  */
	  public static DAO getEleveDAO(){
	    return new EleveDAO(conn);
	  }

	  /**
	  * Retourne un objet Matiere interagissant avec la BDD
	  * @return DAO
	  */
	  public static DAO getMatiereDAO(){
	    return new MatiereDAO(conn);
	  }   
	}

