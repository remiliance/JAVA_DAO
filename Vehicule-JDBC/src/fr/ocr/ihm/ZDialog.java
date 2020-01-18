package fr.ocr.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.ocr.sql.*;
import voiture.moteur.Moteur;
import voiture.option.Option;
import voiture.*;

public class ZDialog extends JDialog {
  private ZDialogInfo zInfo = new ZDialogInfo();
  private boolean sendData;
  private JLabel nomLabel, MarqueLabel, MoteurLabel, prixLabel,prix2Label;
  private JCheckBox tranche1, tranche2, tranche3, tranche4, tranche5;
  private JComboBox marque, moteur;
  private JTextField nom, prix;

  public ZDialog(JFrame parent, String title, boolean modal){
    super(parent, title, modal);
    this.setSize(700, 400);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    this.initComponent();
  }

  public ZDialogInfo showZDialog(){
    this.sendData = false;
    this.setVisible(true);      
    return this.zInfo;      
  }

  private void initComponent() {
       
    //Le nom
    JPanel panNom = new JPanel();
    panNom.setBackground(Color.white);
    panNom.setPreferredSize(new Dimension(220, 60));
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(100, 25));
    panNom.setBorder(BorderFactory.createTitledBorder("Nom du vehicle"));
    nomLabel = new JLabel("Saisir un nom :");
    panNom.add(nomLabel);
    panNom.add(nom);

    //La Marque
    JPanel panMarque = new JPanel();
    panMarque.setBackground(Color.white);
    panMarque.setPreferredSize(new Dimension(220, 60));
    panMarque.setBorder(BorderFactory.createTitledBorder("Marque du vehicule"));
     
    int nbRecord=0;
    
    try {
		nbRecord=DAOTableFactory.getNbeRecord(HsqldbConnection.getInstance(),DatabaseTable.MARQUE);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    String tab[]=new String [nbRecord];
     
    
    try {
		tab = DAOTableFactory.getListeTable(HsqldbConnection.getInstance(), DatabaseTable.MARQUE);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
      
    marque = new JComboBox(tab);
    MarqueLabel = new JLabel("Marque : ");
    panMarque.add(MarqueLabel);
    panMarque.add(marque);

    //Option
    JPanel panOption = new JPanel();
    panOption.setBackground(Color.white);
    panOption.setBorder(BorderFactory.createTitledBorder("Options Disponibles"));
    panOption.setPreferredSize(new Dimension(540, 60));
    tranche1 = new JCheckBox("Barre de toit");
    tranche2 = new JCheckBox("Climatisation");
    tranche3 = new JCheckBox("GPS");
    tranche4 = new JCheckBox("Sièges Chauffants");
    tranche5 = new JCheckBox("Toit Ouvrant");
    ButtonGroup bg = new ButtonGroup();
    bg.add(tranche1);
    ButtonGroup bg2 = new ButtonGroup();
    bg2.add(tranche2);
    ButtonGroup bg3 = new ButtonGroup();
    bg3.add(tranche3);
    ButtonGroup bg4 = new ButtonGroup();
    bg4.add(tranche4);
    ButtonGroup bg5 = new ButtonGroup();
    bg5.add(tranche5);
    panOption.add(tranche1);
    panOption.add(tranche2);
    panOption.add(tranche3);
    panOption.add(tranche4);
    panOption.add(tranche5);

    //Le prix
    JPanel panPrix = new JPanel();
    panPrix.setBackground(Color.white);
    panPrix.setPreferredSize(new Dimension(220, 60));
    panPrix.setBorder(BorderFactory.createTitledBorder("Prix"));
    prixLabel = new JLabel("Prix : ");
    prix2Label = new JLabel(" cm");
    prix = new JTextField();
    prix.setPreferredSize(new Dimension(90, 25));
    panPrix.add(prixLabel);
    panPrix.add(prix);
    panPrix.add(prix2Label);

    //Moteur
    JPanel panMoteur = new JPanel();
    panMoteur.setBackground(Color.white);
    panMoteur.setPreferredSize(new Dimension(220, 60));
    panMoteur.setBorder(BorderFactory.createTitledBorder("Motorisation"));
   
    
    int nbRecord2=0;
    
    try {
		nbRecord2=DAOTableFactory.getNbeRecord(HsqldbConnection.getInstance(),DatabaseTable.MOTEUR);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    String tab2[]=new String [nbRecord2];
       
    try {
		tab2 = DAOTableFactory.getListeTable(HsqldbConnection.getInstance(), DatabaseTable.MOTEUR);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
    
    moteur = new JComboBox(tab2);
    MoteurLabel = new JLabel("Moteur : ");
    panMoteur.add(MoteurLabel);
    panMoteur.add(moteur);

    ///////////////////////////////////////  
    
    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panNom);
    content.add(panMarque);
    content.add(panOption);
    content.add(panPrix);
    content.add(panMoteur);

    JPanel control = new JPanel();
    JButton okBouton = new JButton("OK");
    
    okBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) { 
    	  String Option[]=new String[6];
    	  int i=0;
    	  boolean selected = tranche1.isSelected();
          if (selected) {
              Option[i]="Barres de toit";
            		i++;
          }
          boolean selected2 = tranche2.isSelected();
              if (selected2) {
                  Option[i]="Climatisation";
           		i++;
              }
          boolean selected3 = tranche3.isSelected();
              if (selected3) {
                  Option[i]="GPS";
           		i++;
              }
              boolean selected4 = tranche4.isSelected();
              if (selected4) {
                  Option[i]="Sièges chauffants";
           		i++;
              }
              boolean selected5 = tranche5.isSelected();
              if (selected5) {
                  Option[i]="Toit ouvrant";
           		i++;
              }
       zInfo = new ZDialogInfo(nom.getText(),(String)marque.getSelectedItem(), prix.getText(), (String)moteur.getSelectedItem(),Option);
        
       // création de l'objet Vehicule à insérer
       Vehicule voit = new Vehicule ();
       try {
		voit=zInfo.ConvertToVehicule();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
       System.out.println("MA voiture "+ voit.toString());
       
       // insertion en bdd
       		DAO<Vehicule> vv = new VoitureDAO(HsqldbConnection.getInstance());
    		try {
				if (vv.create(voit,HsqldbConnection.getInstance())==true)
					System.out.println("voiture ajoutée!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		setVisible(false);
      }
   });    
    
    JButton cancelBouton = new JButton("Annuler");
    cancelBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }      
    });    
    control.add(okBouton);
    control.add(cancelBouton);

    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
    //On spécifie une taille
    this.setSize(600, 500);
    //La position
    this.setLocationRelativeTo(null);
    this.setResizable(true);
    //Enfin on l'affiche
    this.setVisible(true);
    //Tout ceci ressemble à ce que nous faisons depuis le début avec notre JFrame.
}
  // Enregistrer le record
  
  
}
