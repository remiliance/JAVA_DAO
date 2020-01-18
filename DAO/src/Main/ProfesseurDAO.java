package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ProfesseurDAO extends DAO<Professeur>{

	public ProfesseurDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Professeur obj) {
		// TODO Auto-generated method stub
		//
		return false;
	}

	@Override
	public boolean delete(Professeur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Professeur obj) {
		// TODO Auto-generated method stub
		try {
			 int o= obj.getId();
			Statement state = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet res = state.executeQuery("select * from professeur where prof_id="+o);
		    res.first();
			res.updateString("prof_nom", obj.getNom());
		    res.updateRow();
		      
		} catch (SQLException e) {
		      e.printStackTrace();
		    }
		return false;
	}

	@Override
	public Professeur find(int id) {
		Professeur prof=new Professeur();
		  try {
		     ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		    	
		    		 ResultSet.CONCUR_READ_ONLY).executeQuery("select * from professeur i, j_mat_prof j, matiere x\r\n" + 
		        		"where j.jmp_prof_k=i.prof_id\r\n" + 
		        		"and x.mat_id=j.jmp_mat_k and prof_id="+id);
			//  ResultSetMetaData resultMeta = result.getMetaData();
			  
			  //test print
		    /* while(result.next()){			
		    	  for(int j = 1; j <= resultMeta.getColumnCount(); j++)
		    	    System.out.print("\t" + result.getObject(j).toString() + "\t |");
		     }*/
		     
		     if(result.first())
		       prof = new Professeur(
		          id,
		          result.getString("prof_nom"),
		          result.getString("prof_prenom"));   
		     result.beforeFirst();
		     DAO<Matiere> matDao = new MatiereDAO(this.connect);
		      while(result.next())
		    		  {
		    	  prof.addMatiere(matDao.find(result.getInt("mat_id")));
		    		  }
		  } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return prof;
	}
	}


