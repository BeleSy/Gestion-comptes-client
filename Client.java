package ca.qc.collegeahuntsic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

/* Client.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class Client {
	
	protected String id;
	private String nom;
	private Adresse adresse;
	private Telephone telephone;
	private String couriel;
	public ArrayList<Compte> listeComptes = new ArrayList<Compte>();
	public static int nbClients = 0;
	
	public Client(String nom,
				  Adresse adresse,
				  Telephone telephone,
				  String courriel) {
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.couriel = courriel;
		nbClients++;
		generer();
	}

	public Client(String id) {
	
		this.nom = "";
		this.adresse = new Adresse();
		this.telephone = new Telephone();
		this.couriel = "";
		this.id = id;
	}

	public Client() {
		this.nom = "";
		this.adresse = new Adresse();
		this.telephone = new Telephone();
		this.couriel = "";
		nbClients++;
		generer();
	}
	
	public String getId(){ return id; }
	public String getNom() {
		return nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public Telephone getTelephone() {
		return telephone;
	}

	public String getCouriel() {
		return couriel;
	}

	public void setId(String id){ this.id = id; }
	
	protected void generer() {
		
		String num = "4312";
		num += String.format("%06d", nbClients);
		id = num;
	}

	public void ajouterCompte (Compte c){
		listeComptes.add(c);
	}
	public boolean equals(Client autre) {
		if (this.getId().equals(autre.getId()))
			{ return true; }
		else 
			{ return false; }
	}
	
	//A: Deleter vielle methode supprimer compte
	//A: deleter afficherInfo() et genererAfficheComptes()

	//A: Nouvelle methode pour afficher comptes
		public DefaultTableModel afficherComptes(String idClient) {
		
		DefaultTableModel modelCompte = new DefaultTableModel();

		for(int i = 0; i < listeComptes.size(); i++) {
		
			String id = idClient;
			String type = listeComptes.get(i).getType();
			String numero = listeComptes.get(i).getNumero();
			String solde = listeComptes.get(i).getSolde();
			String devise = listeComptes.get(i).getDevise();
			String date = listeComptes.get(i).getDate();
			Object[] dataCompte = {id, type, numero, solde, devise, date}; 
			modelCompte.addRow(dataCompte);
		}
		return modelCompte;
	} 
		
	public int getListSize(){
		return listeComptes.size();
	}
	
	public Compte getCompte(int index){
		return listeComptes.get(index);
	}
	
	//A: Nouvelle methode pour crediter comptes
	public void crediterCompte(String numero, String credit){
		
		double montant = Double.parseDouble(credit);
		Compte saisie = rechercherCompte(numero);
		saisie.crediter(montant);
		System.out.println(saisie + "crediter de: " + montant);
		
	}
	
	//A: Ajout de methode supprimerCompte()
	public void supprimerCompte(String numero) {
		
		Compte saisie = rechercherCompte(numero);
		int pos = -1;
		pos = listeComptes.indexOf(saisie);
		if (pos != -1) { listeComptes.remove(saisie); }
//		else throw compteException;
		System.out.println(saisie);
	}	

	
	//A: Nouvelle methode rechercherCompte
	public Compte rechercherCompte(String idCompte){
		
		Compte saisie = new Compte(idCompte);
		Collections.sort(listeComptes, new CompteParNumero());
		int pos = Collections.binarySearch(listeComptes, saisie, new CompteParNumero());
		saisie = listeComptes.get(pos);
		System.out.println(saisie);
		return saisie;
	}


	// A: Nouvelles methodes ajoute qui remplace remplirList (appeler lors de banque remplirlisteclient
	public void ajouteCompte1(String idClient){
		Compte cheque1 = new CompteCheque("0005", 150.00, "CAD", "2010-03-11", idClient, 100.00);
		listeComptes.add(cheque1);
		}
	public void ajouteCompte2(String idClient){
		Compte cheque2 = new CompteCheque("0004", 850.00, "CAD", "2011-03-11", idClient, 50.00);
		listeComptes.add(cheque2);
	}
	public void ajouteCompte3(String idClient){
		Compte cheque3 = new CompteCheque("0003", 450.00, "USD", "2010-04-11", idClient, 200.00);
		listeComptes.add(cheque3);
	}
	public void ajouteCompte4(String idClient){
		Compte epargne1 = new CompteEpargne("0001", 350.00, "CAD", "2014-03-14", idClient, 150.00);
		listeComptes.add(epargne1);
	}
	public void ajouteCompte5(String idClient){
		Compte epargne2 = new CompteEpargne("0002", 250.00, "USD", "2015-03-11",  idClient,100.00);
		listeComptes.add(epargne2);
	}	
	
	public String toString(){
		String resultat = "";
		resultat += id + ";" +
				  	nom  + ";" +
				  	adresse + ";" +
				  	telephone + ";" +
				  	couriel;
		return resultat;
	}	
	
	public String genererAfficheComptes() {
		String resultat = "";
		Iterator<Compte> it = listeComptes.iterator();
		while (it.hasNext()){
			resultat += it.next().afficher(this.getId()) /* + ";" + it.next().getType()*/ + "\n";
		}
		return resultat;
	}
}
