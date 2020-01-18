package Main;

import java.sql.Connection;

public class Main {
	 public static void main(String[] args) {
		    //Testons des élèves
		    DAO<Eleve> eleveDao = new EleveDAO(sdzConnection.getInstance());
		    for(int i = 1; i < 5; i++){
		     Eleve eleve = eleveDao.find(i);
		      System.out.println("Elève N°" + eleve.getId() + "  - " + eleve.getNom() + " " + eleve.getPrenom());
		    }
		    
		    DAO<Matiere> matDao = new MatiereDAO(sdzConnection.getInstance());
		    for(int i = 1; i <7; i++){
		     Matiere mat = matDao.find(i);
		      System.out.println("Matiere N°" + mat.getId() + "  - " + mat.getNom());
		    }
		    
		    DAO<Professeur> profDao = new ProfesseurDAO(sdzConnection.getInstance());
		    for(int i = 1; i < 8; i++){
		     Professeur prof = profDao.find(i);
		     System.out.println("Prof N°" + prof.getId() + "  - " + prof.getNom() + " " + prof.getPrenom()+" Enseigne");
		     for (Matiere mat : prof.getListMatiere())
		    	 System.out.println("\t * " + mat.getNom());
		    }
		    
		    Professeur prof2=profDao.find(1);
		    prof2.setNom("PauPaul");
		   boolean b=profDao.update(prof2);
		    
		    
		    DAO<Classe> ClasseDao = new ClasseDAO(sdzConnection.getInstance());
		    for(int i = 1; i < 13; i++){
		     Classe cla = ClasseDao.find(i);
		     System.out.println("Classe N°" + cla.getId() + "  - " + cla.getNom() + " avec ");
		     for (Eleve ele : cla.getListEleve())
		    	 System.out.println("\t * " + ele.getNom());
	 }
	 }
}

