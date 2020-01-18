package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClasseDAO extends DAO<Classe>{

	public ClasseDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Classe obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Classe obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Classe obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Classe find(int id) {
		Classe classe=new Classe();
		  try {
		     ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		     ResultSet.CONCUR_READ_ONLY).executeQuery("select * from eleve i inner join classe j on i.elv_cls_k=j.cls_id where j.cls_id="+id);
		     
		     if(result.first())
			      classe = new Classe(
			          id,
			          result.getString("cls_nom"));
		   
		     result.beforeFirst();
		     EleveDAO eleDao = new EleveDAO(this.connect);
		      while(result.next())
		    		  {
		    	 classe.addEleve(eleDao.find(result.getInt("elv_id")));
		    		  }
		  } catch (SQLException e) {
		      e.printStackTrace();}
		      
		return classe;
	
	}
}


