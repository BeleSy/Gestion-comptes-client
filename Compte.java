package ca.qc.collegeahuntsic;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.DefaultTableModel;

/* Compte.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class Compte {

	protected String numero;
	protected double solde;
	private String devise;
	private String date; 			// D'ouverture du compte
	
	//B: Mettre nombre de comptes
	public static int nbComptes=0;
	
	// A: idClient secret
	private String idClient;
	
	//A: Ici j'ai enlever listeComptes
	
	public Compte(String numero, double solde, String devise, String date, String idClient) {
		this.numero = numero;
		this.solde = solde;
		this.devise = devise;
		this.date = date;

		// A: idClient
		this.idClient = idClient;
		
		nbComptes++;
	}
	public Compte() {
		this.numero = "";
		this.solde = 0;
		this.devise = "";
		this.date = "";
		
		// A: idClient
		this.idClient = "";
		
		nbComptes++;
	}
	public Compte(String numero) {
		this();
		this.numero = numero;
	}
	public void setNumero(String numero){
		this.numero = numero;
	}
	public String getNumero(){
		return this.numero;
	}
	public void crediter (double montant) {
		solde += montant;
	}
	public void debiter (double montant) {
		
		if (montant > solde) {
//			throw compteException;
		} else {
			solde -= montant;
		}
	}

//	public String getType(){}	
	
	//A: Enlever afficher()
	
	public String toString(){
		String resultat = "";
		resultat += numero + ";" +
				  	solde  + ";" +
				  	devise + ";" +
				  	date;
		return resultat;
	}
	
	public String afficher(String idClient){
		String resultat = "";
		resultat += idClient + ";" +
				  	solde  + ";" +
				  	devise + ";" +
				  	date;
		return resultat;
	}
	
	public String getIdClient() {
		return "Client ID";
	}
	public String getType() {
	/*	if (this instanceof CompteCheque) return "Cheque";
		else if (this instanceof CompteEpargne) return "Epargne";
		else return "Inconnu";*/
		return "bonjour";
	}
	public String getSolde() {
		return "" + solde;
	}
	public String getDevise() {
		return devise;
	}
	public String getDate() {
		return date;
	}
	
	public int getNbComptes(){
		return nbComptes;
	}
}
