package fr.ocr.ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import fr.ocr.ihm.ZDialog;
import fr.ocr.ihm.ZDialogInfo;

public class NewVehiculeListener implements ActionListener {

	private JFrame frame;

	public NewVehiculeListener(JFrame f) {
		frame = f;
	}

	public void actionPerformed(ActionEvent e) {
		Runnable code = new Runnable() {
		    public void run() {
		    		  ZDialog zd = new ZDialog(null, "Ajouter une Voiture", true);
		    		  ZDialogInfo zInfo = zd.showZDialog(); 
		  	        JOptionPane jop = new JOptionPane();
		  	        jop.showMessageDialog(null, zInfo.toString(), "Informations voiture", JOptionPane.INFORMATION_MESSAGE);		
		    }
		};
		
		if (SwingUtilities.isEventDispatchThread()) {
			System.out.println("run!");
			code.run();
		     } else {
		    SwingUtilities.invokeLater(code);
		    System.out.println("Invoke Later!");
		  }
		   	  											
		
		 }
}
