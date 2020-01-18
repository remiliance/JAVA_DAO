package Main;


public class Eleve {
  //ID
  private int id = 0;
  //Nom de l'�l�ve
  private String nom = "";
  //Pr�nom de l'�l�ve
  private String prenom = "";
   
  public Eleve(int id, String nom, String prenom) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
  }
  public Eleve(){};
     
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }   
}