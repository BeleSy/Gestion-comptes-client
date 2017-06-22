package ca.qc.collegeahuntsic;

/* Telephone.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class Telephone {

	private String numPrincipal;
	private String extPrincipal;
	private String numSecondaire;
	private String extSecondaire;
	private String numMobile;
	private String numTelecopieur;
	
	public Telephone (String numPrincipal,
					  String extPrincipal,
					  String numSecondaire,
					  String extSecondaire,
					  String numMobile,
					  String numTelecopieur) {
		this.numPrincipal = numPrincipal;
		this.extPrincipal = extPrincipal;
		this.numSecondaire = numSecondaire;
		this.extSecondaire = extSecondaire;
		this.numMobile = numMobile;
		this.numTelecopieur = numTelecopieur;
	}
	
	public Telephone () {
		this.numPrincipal = "";
		this.extPrincipal = "";
		this.numSecondaire = "";
		this.extSecondaire = "";
		this.numMobile = "";
		this.numTelecopieur = "";
	}

	public String afficher(){
		String resultat = "";
		resultat += "Numero principal: " + numPrincipal;
		if (extPrincipal.equals("") == false) {
			resultat += " ext." + extPrincipal;
		} 
		if (numSecondaire.equals("") == false) {
			resultat += "\nNumero secondaire: " + numSecondaire;
			if (extSecondaire.equals("") == false) {
				resultat += " ext." + extSecondaire;
			} 
		}
		if (numMobile.equals("") == false) {
			resultat += "\nNumero mobile: " + numMobile;
		} 
		if (numTelecopieur.equals("") == false) {
			resultat += "\nNumero de telecopieur: " + numTelecopieur;
		}
		return resultat;
	}
	
	public String toString(){
		String resultat = "";
		resultat += numPrincipal + ";" +
				  	extPrincipal  + ";" +
				  	numSecondaire + ";" +
				  	extSecondaire + ";" +
				  	numMobile + ";" +
				  	numTelecopieur;
		return resultat;
	}
}
