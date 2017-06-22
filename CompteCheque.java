package ca.qc.collegeahuntsic;

import java.util.Calendar;
import java.util.Collections;

/* Compte.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class CompteCheque extends Compte {

	private double limite;			// Limite de decouvert

	//A: Ajout idClient
	public CompteCheque(String numero, double solde, String devise, String date, String idClient, double limite) {
		super(numero, solde, devise, date, idClient);
		this.limite = limite;
	}

	public CompteCheque() {
		super();
		this.limite = 0.0;
	}
	
	public CompteCheque(String numero) {
		this();
		this.numero = numero;
	}


	public void debiter(Double montant) {
		if (montant > (solde + limite)) {
//			throw compteException;
		} else {
			solde -= montant;
		}
	}
	public String getType(){
		return "Cheque";
	}
	
	//A: Enlever afficher()
		
	public String toString(){
		String resultat = "";
		resultat += super.toString() + ";" +
				  	getType()  + ";" +
				  	limite + "\n";
		return resultat;
	}
	
	//A: Eliminer rechercherCompte
}
