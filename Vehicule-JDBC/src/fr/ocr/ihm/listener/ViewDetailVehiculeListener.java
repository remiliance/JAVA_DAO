package fr.ocr.ihm.listener;

import java.awt.event.ActionEvent;

import fr.ocr.ihm.*;
import fr.ocr.sql.DatabaseTable;

public class ViewDetailVehiculeListener extends ButtonListener {
	private Integer id;

	public void actionPerformed(ActionEvent e) {
		Details zd = new Details(null, "Details Voiture", true);
	}
}
