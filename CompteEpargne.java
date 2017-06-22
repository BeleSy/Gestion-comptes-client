package ca.qc.collegeahuntsic;

import java.util.Calendar;
import java.util.Collections;

/* Compte.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class CompteEpargne extends Compte {

	private double soldeMin;			// Solde minimum

	//A: Ajout idClient
	public CompteEpargne(String numero, double solde, String devise, String date, String idClient, double soldeMin) {
		super(numero, solde, devise, date, idClient);
		this.soldeMin = soldeMin;
	}

	public CompteEpargne() {
		super();
		this.soldeMin = 0.0;
	}
	
	public CompteEpargne(String numero) {
		this();
		this.numero = numero;
	}


	public void debiter(Double montant) {
		if (montant > (solde - soldeMin)) {
//			throw compteException;
		} else {
			solde -= montant;
		}
	}
	public String getType(){
		return "Epargne";
	}

	//A: Enlever afficher()
		
	public String toString(){
		String resultat = "";
		resultat += super.toString() + ";" +
				  	getType()  + ";" +
				  	soldeMin + "\n";
		return resultat;
	}
	
	// A: Eliminer la fonction rechercheCompte (doublon)

}
