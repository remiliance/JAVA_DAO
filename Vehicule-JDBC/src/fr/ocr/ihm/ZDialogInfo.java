package fr.ocr.ihm;

import java.sql.SQLException;

import fr.ocr.sql.DAO;
import fr.ocr.sql.DAOOption;
import fr.ocr.sql.DAOTableFactory;
import fr.ocr.sql.DAOmoteur;
import fr.ocr.sql.HsqldbConnection;
import fr.ocr.sql.MarqueDAO;
import voiture.Marque;
import voiture.Vehicule;
import voiture.moteur.Moteur;
import voiture.option.Option;


public class ZDialogInfo {
	  private String nom,marque,prix,moteur;
	  private String listeOption[];
	 
	  public ZDialogInfo(){}
	  public ZDialogInfo(String nom, String marque, String Prix, String Moteur,String Option[]){
	    this.nom = nom;
	    this.marque = marque;
	    this.prix=Prix;
	    this.moteur=Moteur;	 
	    this.listeOption= new String[6];
	    for (int i=0;i<5;i++)
	    	  this.listeOption[i]=Option[i];
	  }
	  
	  
	  public String toString(){
		    String str;
		    if(this.nom != null && this.marque != null && this.prix != null && this.moteur != null){
		      str = "Description de l'objet InfoZDialog";
		      str += "Nom : " + this.nom + "\n";
		      str += "Marque : " + this.marque + "\n";
		      str += "Prix : " + this.prix + "\n";
		      str += "Moteur : " + this.moteur + "\n";
		    }
		    else{
		      str = "Aucune information !";
		    }
		    return str;
		  }
	  
	  public Vehicule ConvertToVehicule() throws SQLException
	  {
		  Vehicule voit = new Vehicule ();
		  //Marque mark=new Marque();
		  
		  DAO<Marque> markus =new MarqueDAO(HsqldbConnection.getInstance());
		  Marque mark=markus.find(HsqldbConnection.getInstance(),this.marque);
		  voit.setMarque(mark);	     
	       
	       int ID=DAOTableFactory.getNextIDVoiture(HsqldbConnection.getInstance());
	       voit.setId(ID);
	       
	       voit.setNom(this.nom); 
	       voit.setPrix(Double.parseDouble(this.prix));	
	       
	       DAO<Moteur> mott = new DAOmoteur (HsqldbConnection.getInstance());
	       Moteur mm=mott.find(HsqldbConnection.getInstance(),this.moteur);
	       voit.setMoteur(mm);
	       
	       for (int i=0;i<5;i++)
	       {
		    	  if (this.listeOption[i]!=null)
		    	  {
		    		  DAO<Option> opt = new DAOOption(HsqldbConnection.getInstance());
		    		  //System.out.println("Mon I"+i);
		    		  //System.out.println("Nom de l'option : "+this.listeOption[i]);
		   	       	  Option oo=opt.find(HsqldbConnection.getInstance(),this.listeOption[i]);
		   	       	  voit.addOption(oo);
		    	  }
	       }	       
       
		  return voit;
	  }
	  
	  
}
