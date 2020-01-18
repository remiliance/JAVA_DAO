package fr.ocr.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


import voiture.Marque;
import voiture.moteur.*;

public class DAOmoteur extends DAO<Moteur>{

	public DAOmoteur(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Moteur obj, Connection conn)  throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Moteur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Moteur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Moteur find(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		Moteur momo=new Moteur();
		TypeMoteur ttmomo=new TypeMoteur();
		
		try (
				Statement state = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);	
	    			    					
	    	  	ResultSet result = state.executeQuery("SELECT * FROM moteur i JOIN TYPE_MOTEUR j ON i.MOTEUR=j.ID where i.CYLINDRE='"+id+"'");){;
	    	    ResultSetMetaData resultMeta = result.getMetaData();
		     
		     if(result.first())
		     {
		    	 ttmomo = new TypeMoteur(result.getInt("moteur"), result.getString("description"));
		    	 momo = new Moteur(result.getInt("id"),ttmomo,
			          result.getString("cylindre"),
			          result.getDouble("prix")
			    		  );		 
		     }
		}
		return momo;
	}

}
