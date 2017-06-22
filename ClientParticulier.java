package ca.qc.collegeahuntsic;

/* ClientEntreprise.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class ClientParticulier extends Client {
	
	private String nas;
	private char sexe;
	public static int nbParticuliers = 0;
	
	public ClientParticulier(String nom, Adresse adresse, Telephone telephone, String courriel,
			String nas, char sexe) {
	
		super(nom, adresse, telephone, courriel);
		this.nas = nas;
		this.sexe = sexe;
		nbParticuliers++;
		generer();
	}
	
	public ClientParticulier() {
	
		super();
		this.nas = "";
		this.sexe = '\0';
		nbParticuliers++;
		generer();
	}
	protected void generer(){
		
		super.generer();
		String num = getId();
		num += 12 + String.format("%04d", nbParticuliers);
		this.id = num;
	}
	
	//A: Ici jai enlever afficher()
	
	public String toString(){
		String resultat = "";
		resultat += super.toString() + ";" +
				  	nas  + ";" +
				  	sexe + "\n";
		return resultat;
	}

	
	
	
	
	
	

}
