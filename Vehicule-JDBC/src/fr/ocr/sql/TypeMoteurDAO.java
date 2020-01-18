package fr.ocr.sql;

import java.sql.Connection;
import java.sql.SQLException;

import voiture.moteur.*;

public class TypeMoteurDAO extends DAO<TypeMoteur>{

	public TypeMoteurDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(TypeMoteur obj,Connection conn)  throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TypeMoteur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TypeMoteur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TypeMoteur find(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
