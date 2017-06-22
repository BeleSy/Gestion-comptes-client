package ca.qc.collegeahuntsic;

/* ClientEntreprise.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class ClientEtudiant extends ClientParticulier {
	
	private String ecole;
	private String niveau;										// Niveau d'etudes
	private String date;										// Date d'ouverture
	public static int nbEtudiants = 0;
	
	public ClientEtudiant(String nom, Adresse adresse, Telephone telephone, String courriel, String nas, char sexe,
			String ecole, String niveau, String date) {
	
		super(nom, adresse, telephone, courriel, nas, sexe);
		this.ecole = ecole;
		this.niveau = niveau;
		this.date = date;
		nbEtudiants++;
		generer();
	}
	
	public ClientEtudiant() {
	
		super();
		this.ecole = "";
		this.niveau = "";
		this.date = "";
		nbEtudiants++;
		generer();
	}
	
	protected void generer(){													

		super.generer();
		String num = "";
		num += getId().substring(0,10) + "18" + getId().substring(12);
		System.out.println("num dans clientEtudiant: " + num);
	}									
	
	//A: Ici j'ai enleve afficher()
	
	public String toString(){
		String resultat = "";
		resultat += super.toString() + ";" +
				  	ecole  + ";" +
				  	niveau + ";" +
				  	date + "\n";
		return resultat;
	}
	
	

}
