package ca.qc.collegeahuntsic;

/* ClientEntreprise.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class ClientEntreprise extends Client {
	
	private String neq;
	private String url;
	public static int nbEntreprises = 0;
	
	public ClientEntreprise(String nom, Adresse adresse, Telephone telephone, String courriel,
			String neq, String url) {
	
		super(nom, adresse, telephone, courriel);
		this.neq = neq;
		this.url = url;
		nbEntreprises++;
		generer();
	}
	
	public ClientEntreprise() {
	
		super();
		this.neq = "";
		this.url = "";
		nbEntreprises++;
		generer();
	}

	protected void generer(){

		super.generer();
		String num = getId();
		num += 16 + String.format("%04d", nbEntreprises);
		this.id = num;

	}
	
	//A: Ici jai enlever afficher()
	
	public String toString(){
		String resultat = "";
		resultat += super.toString() + ";" +
				  	neq  + ";" +
				  	url + "\n";
		return resultat;
	}

	
	
	
	
	
	
	

}
