package fr.ocr.ihm;

import java.awt.BorderLayout;
import java.awt.Button;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import fr.ocr.sql.*;
import voiture.moteur.Moteur;
import voiture.option.Option;
import voiture.*;

public class Details extends JDialog{

	public Details(JFrame parent, String title, boolean modal){
	    super(parent, title, modal);
	    this.setSize(700, 400);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	    this.initComponent();
	  }

	  
	  private void initComponent() {
	  JPanel content = new JPanel();
	    content.setBackground(Color.white);


	    JPanel control = new JPanel();
	    JButton okBouton = new JButton("OK");	    
	    okBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) { };
	    });
	    
	    JButton cancelBouton = new JButton("Annuler");
	    cancelBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        setVisible(false);
	      }      
	    });    
	    control.add(okBouton);
	    control.add(cancelBouton);
	    control.add(new JScrollPane(DAOTableFactory.getTable(
				HsqldbConnection.getInstance(),DatabaseTable.VEHICULE_OPTION)));

	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.getContentPane().add(control, BorderLayout.SOUTH);
	    //On spécifie une taille
	    this.setSize(600, 500);
	    //La position
	    this.setLocationRelativeTo(null);
	    this.setResizable(true);
	    //Enfin on l'affiche
	    this.setVisible(true);    
	    
	    
	  }
}
