package fr.ocr.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import voiture.Marque;
import voiture.option.*;

public class DAOOption extends DAO<Option>{

	public DAOOption(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Option obj, Connection conn)  throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Option obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Option obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Option find(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		
		Option oo=new Option();
		try (
				Statement state = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);	
	    			    					
	    	  	ResultSet result = state.executeQuery("SELECT * FROM option where DESCRIPTION='"+id+"'");){;
	    	    ResultSetMetaData resultMeta = result.getMetaData();
		
		    	     
		     if(result.first())
			      oo = new Option(result.getInt("id"),
			          result.getString("description"),
			          result.getDouble("prix"));	      
	
		    // System.out.println("Option ds le DAO : " + oo.getId()+"des : "+oo.getNom()+"prix:"+oo.getPrix());
		}
		return oo;
	}
		
}
