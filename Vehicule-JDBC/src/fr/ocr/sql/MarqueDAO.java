package fr.ocr.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import voiture.Marque;

public class MarqueDAO extends DAO<Marque>{

	public MarqueDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Marque obj, Connection conn)  throws SQLException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Marque obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Marque obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public Marque find(Connection conn, String mm) throws SQLException {
		// TODO Auto-generated method stub
	
		Marque mark=new Marque();
		try (
				Statement state = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);	
	    			    					
	    	  	ResultSet result = state.executeQuery("SELECT * FROM marque where NOM='"+mm+"'");){;
	    	    ResultSetMetaData resultMeta = result.getMetaData();
		
		    
		     
		     if(result.first())
			      mark = new Marque(result.getInt("id"),
			          result.getString("nom"));
		      
	
		}
		return mark;
	}
	
}
