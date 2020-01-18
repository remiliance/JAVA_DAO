package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EleveDAO extends DAO<Eleve> {

	public EleveDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Eleve obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Eleve obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Eleve obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Eleve find(int id) {
		Eleve eleve=new Eleve();
		  try {
		     ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleve WHERE elv_id = " + id);
	
		      if(result.first())
		       eleve = new Eleve(
		          id,
		          result.getString("elv_nom"),
		          result.getString("elv_prenom"));   
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return eleve;
	}
	

}
