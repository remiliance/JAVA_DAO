package Main;

//CTRL + SHIFT + O pour générer les imports
public class TestDAO {
public static void main(String[] args) {
  System.out.println("");
  //On récupère un objet faisant le lien entre la base et nos objets 
  DAO<Eleve> eleveDao = DAOFactory.getEleveDAO();

  for(int i = 1; i < 5; i++){
    //On fait notre recherche
    Eleve eleve = eleveDao.find(i);
    System.out.println("\tELEVE N°" + eleve.getId() + " - NOM : " + eleve.getNom() + " - PRENOM : " + eleve.getPrenom());
  }      

  System.out.println("\n\t****************************************");

  //On agit de même pour une classe
  DAO<Classe> classeDao = DAOFactory.getClasseDAO();
  //On cherche la classe ayant pour ID 10
  Classe classe = classeDao.find(10);

  System.out.println("\tCLASSE DE " + classe.getNom());

  //On récupère la liste des élèves
  System.out.println("\n\tCelle-ci contient " + classe.getListEleve().size() + " élève(s)");
  for(Eleve eleve : classe.getListEleve())
    System.out.println("\t\t - " + eleve.getNom() + " " + eleve.getPrenom());
          
  //De même pour la liste des professeurs
  System.out.println("\n\tCelle-ci a " + classe.getListProfesseur().size() + " professeur(s)");      
  for(Professeur prof : classe.getListProfesseur()){
    System.out.println("\t\t - Mr " + prof.getNom() + " " + prof.getPrenom() + " professeur de :");
       
    //Tant qu'à faire, on prend aussi les matières
    for(Matiere mat : prof.getListMatiere())
      System.out.println("\t\t\t * " + mat.getNom());         
  }
    
  System.out.println("\n\t****************************************");
    
  //Un petit essai sur les matières
  DAO<Matiere> matiereDao = DAOFactory.getMatiereDAO();
  Matiere mat = matiereDao.find(2);
  System.out.println("\tMATIERE " + mat.getId() + " : " + mat.getNom());      
}
}
