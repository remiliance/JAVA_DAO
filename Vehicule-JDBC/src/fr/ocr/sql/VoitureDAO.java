package fr.ocr.sql;
import voiture.*;
import voiture.option.Option;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Stream;

public class VoitureDAO extends DAO<Vehicule>{

	public VoitureDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public boolean create(Vehicule obj, Connection conn)throws SQLException {
		// TODO Auto-generated method stub
		
		
		try {
							
					Statement state = conn.createStatement(
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);	
					conn.setAutoCommit(true);
					
					//System.out.println("VEHICULE dans la DAO:"+obj.getMarque().getId()+obj.getMoteur().getId()+obj.getPrix()+obj.getNom()+obj.getId());
					
				 state.executeUpdate("INSERT INTO VEHICULE(MARQUE,MOTEUR,PRIX,NOM,ID) VALUES('"+obj.getMarque().getId()+"','"+obj.getMoteur().getId()+"','"+obj.getPrix()+"','"+obj.getNom()+"','"+obj.getId()+"')");
				
				 
				 
				
				
				 int j=obj.getId();
				 List<Option> listP =  obj.getOptions();
				 Stream <Option> sp=listP.stream();
				// sp.forEach(x->x.getId()); 
				 
				 sp.forEach(x-> { int i=x.getId(); 
				 try {
					state.executeUpdate("INSERT INTO VEHICULE_OPTION (ID_VEHICULE,ID_OPTION) VALUES('"+j+"','"+i+"')");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 });
					
				 										 
				// state.executeUpdate("INSERT INTO VEHICULE(MARQUE,MOTEUR,PRIX,NOM,ID) VALUES('"+obj.getMarque().getId()+"','"+obj.getMoteur().getId()+"','"+obj.getPrix()+"','"+obj.getNom()+"','"+obj.getId()+"')");
				  	
				state.close();
				  	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return true;
	}

	public boolean delete(Vehicule obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Vehicule obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vehicule find(Connection conn, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
