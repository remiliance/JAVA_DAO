package Main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;


public class Fenetre extends JFrame{
	public JFrame fen =new JFrame( );
	public Container contenu;
	private JToolBar tool = new JToolBar();
	private JButton load = new JButton("Execute");
	private JSplitPane split;
	private JPanel result = new JPanel();
	private String requete = "SELECT  * FROM classe";
	private JTextArea text = new JTextArea(requete);
	
	
	public Fenetre(){
	    setSize(900, 600);
	    setTitle("TP JDBC");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	    initToolbar();
	    initContent();
	    initTable(requete);
	  }
	
	  private void initToolbar(){
	    load.setPreferredSize(new Dimension(30, 35));
	    load.setBorder(null);
	    load.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){
	     // initTable(text.getText());
	      }
	    });
	    tool.add(load);
	    getContentPane().add(tool, BorderLayout.NORTH);
	    
	  }
		
	  public void initContent(){
	    result.setLayout(new BorderLayout());
	    split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(text), result);
	    split.setDividerLocation(100);
	    getContentPane().add(split, BorderLayout.CENTER);
	  
	  }
	  
	  public void initTable(String query) {
		  try {
		   /*   Class.forName("org.postgresql.Driver");
		      System.out.println("Driver O.K.");
		      String url = "jdbc:postgresql://localhost:5432/Ecole";
		      String user = "postgres";
		      String passwd = "admin";
		      java.sql.Connection conn = DriverManager.getConnection(url, user, passwd);
		      System.out.println("Connexion effective !"); 		      
		       //Création d'un objet Statement
		    Statement state = conn.createStatement();
	      //L'objet ResultSet contient le résultat de la requête SQL
	      ResultSet res = state.executeQuery(query);
	      //On récupère les MetaData
	      ResultSetMetaData resultMeta = res.getMetaData();
	      
	      Object[] column = new Object[resultMeta.getColumnCount()]; 

	      for(int i = 1 ; i <= resultMeta.getColumnCount(); i++)
	          column[i-1] = resultMeta.getColumnName(i);
	      //Petite manipulation pour obtenir le nombre de lignes
	      res.last();
	      int rowCount = res.getRow();
	      Object[][] data = new Object[res.getRow()][resultMeta.getColumnCount()];

	      //On revient au départ
	      res.beforeFirst();
	      int j = 1;

	      //On remplit le tableau d'Object[][]
	      while(res.next()){
	        for(int i = 1 ; i <= resultMeta.getColumnCount(); i++)
	          data[j-1][i-1] = res.getObject(i);
					
	        j++;
	      }
	      //On ferme le tout                                     
	      res.close();
	      state.close();

	    //  long totalTime = System.currentTimeMillis() - start;

	      //On enlève le contenu de notre conteneur
	      result.removeAll();
	      //On y ajoute un JTable
	     // result.add(new JScrollPane(new JTable(data, column)), BorderLayout.CENTER);
	    //  result.add(new JLabel("La requête à été exécuter en " + totalTime + " ms et a retourné " + rowCount + " ligne(s)"), BorderLayout.SOUTH);
	      //On force la mise à jour de l'affichage
	      result.revalidate();
		*/
			  Connection.getInstance();
			  
			  
		    } catch (Exception e) {
		      e.printStackTrace();
		    }  
	  }
}

