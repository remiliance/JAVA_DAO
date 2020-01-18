package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatiereDAO extends DAO<Matiere>{

	public MatiereDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Matiere obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Matiere obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Matiere obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Matiere find(int id) {
		Matiere mat=new Matiere();
		  try {
		     ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM matiere WHERE mat_id = " + id);
	
		      if(result.first())
		      mat= new Matiere(
		          result.getInt("mat_id"),
		          result.getString("mat_nom"));   
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return mat;
	}
	}

