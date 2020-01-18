package Main;

public class Singleton2 {
	  //Le singleton
	  private static Singleton2 single ;/*= new Singleton2();*/
	  //Variable d'instance
	  private String name = "";
	   
	  //Constructeur priv�
	  private Singleton2(){
	    this.name = "Mon singleton";
	    System.out.println("\t\tCR�ATION DE L'INSTANCE ! ! !");
	  }
	   
	  //M�thode d'acc�s au singleton
	  public static Singleton2 getInstance(){
	    if(single == null)
	    single = new Singleton2();
	      
	    return single;
	  }
	}
