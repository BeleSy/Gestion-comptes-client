package ca.qc.collegeahuntsic;

/* Adresse.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class Adresse {

	private String numRue;
	private String rue;
	private String numApt;
	private String ville;
	private String province;
	private String codePost;
	private String pays;
	
	public Adresse (String numRue,
					String rue,
					String numApt,
					String ville,
					String province,
					String codePost,
					String pays) {
		this.numRue = numRue;
		this.numApt = numApt;
		this.rue = rue;
		this.ville = ville;
		this.province = province;
		this.codePost = codePost;
		this.pays = pays;
	}
	
// Constructeur sans apt
 
 	public Adresse (String numRue,
					String rue,
					String ville,
					String province,
					String codePost,
					String pays) {
		this.numRue = numRue;
		this.numApt = "";
		this.rue = rue;
		this.ville = ville;
		this.province = province;
		this.codePost = codePost;
		this.pays = pays;
	} 

	public Adresse () {
		this.numRue = "";
		this.numApt = "";
		this.rue = "";
		this.ville = "";
		this.province = "";
		this.codePost = "";
		this.pays = "";
	}

 	public String afficher(){
		String resultat = "";
		resultat += "Adresse: " + numRue
				  + " rue " + rue;
		if (numApt.equals("") == false) {
			resultat += ", apt " + numApt;
		} 
		resultat += "\n" + ville		
				  + ", " + province
				  + "\n" + codePost
				  + ", " + pays; 
		return resultat;
	}
	
	public String toString(){
		String resultat = "";
		resultat += numRue + ";" +
				  	rue  + ";";
		if (numApt.equals("") == false) {
			resultat += numApt + ";";
		}
		resultat +=	numApt + ";" +
				  	ville + ";" +
				  	province + ";" +
				  	codePost + ";" +
				  	pays;
		return resultat;
	}
}
