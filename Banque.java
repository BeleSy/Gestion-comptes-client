package ca.qc.collegeahuntsic;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/* Banque.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class Banque {

	public ArrayList<Client> listeClients = new ArrayList<Client>();
	Compte compte;
	//A: Amener listeComptes dans Client
	
	public Banque(){

		// La banque est remplis au moment de la construction
		
		remplirListeClients();
		//A: Deleter remplirListeComptes ici
		
		/*télécharger csv
		initialiserClient("ressources/listeClients.txt");
		initialiserCompte("ressources/listeComptes.txt");
		
		*/
	}	
	
	public JScrollPane creerTableClients(){

		String[] colClient = {"Id", "Nom", "Adresse", "Telephone", "Couriel"};
		DefaultTableModel modelClient = new DefaultTableModel(colClient, 0);
		for(int i = 0; i < listeClients.size(); i++) {
			String id = listeClients.get(i).getId();
			String nom = listeClients.get(i).getNom();
			String adresse = listeClients.get(i).getAdresse().afficher();
			String telephone = listeClients.get(i).getTelephone().afficher();
			String couriel = listeClients.get(i).getCouriel();
			Object[] data = {id, nom, adresse, telephone, couriel}; 
			modelClient.addRow(data);
		}
		JTable tableClients = new JTable(modelClient);
		
		// A: Ajout fonctionalite de sort
		tableClients.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(tableClients);

		//A: Resize le scrollPane a la grandeur de la table
		Dimension d = tableClients.getPreferredSize();
		scrollPane.setPreferredSize(new Dimension(d.width,tableClients.getRowHeight()*listeClients.size()+1));
		
		return scrollPane;
	}
	public JScrollPane creerTableComptes(){
		
		String[] colCompte = {"Id Client", "Type", "Numero", "Solde", "Devise", "Date"};
		DefaultTableModel modelCompte = new DefaultTableModel(colCompte, 0);

		//A: Nouvelle methode funky de creerTableComptes()
		for(int i = 0; i < listeClients.size(); i++) {
		
			Client saisie = listeClients.get(i);
			
			for(int j = 0; j < saisie.getListSize(); j++) {
				
				Compte compte = saisie.getCompte(j);
				Object[] dataCompte = {saisie.getId(), compte.getType(), 
									   compte.getNumero(), compte.getSolde(), 
									   compte.getDevise(), compte.getDate()};
				modelCompte.addRow(dataCompte);
				}
		}
		JTable tableComptes = new JTable(modelCompte);
		
		// A: Sorter
		tableComptes.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(tableComptes);

		//A: Resize le scrollPane a la grandeur de la table
		Dimension d = tableComptes.getPreferredSize();
		scrollPane.setPreferredSize(new Dimension(d.width,tableComptes.getRowHeight()*listeClients.size()+1));

		return scrollPane;
	}
	
/*	//A: Methode unqiuement pour UN client
	public JScrollPane creerTableCompteClient(String numero){
		
		String[] colCompte = {"Id Client", "Type", "Numero", "Solde", "Devise", "Date"};
		DefaultTableModel modelCompte = new DefaultTableModel(colCompte, 0);
		
		//A: Nouvelle methode chercher listeComptes dans Client
		Client saisie = rechercherClient(numero);
		modelCompte = saisie.afficherComptes(saisie.getId());
		JTable tableComptes = new JTable(modelCompte);
		
		// A: Sorter
		tableComptes.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(tableComptes);

		//A: Resize le scrollPane a la grandeur de la table
		Dimension d = tableComptes.getPreferredSize();
		scrollPane.setPreferredSize(new Dimension(d.width,tableComptes.getRowHeight()*listeClients.size()+1));

		return scrollPane;
	}
*/
	public void ajouterClient(Client client) {
		
		listeClients.add(client);
		System.out.println(client);
	}
	public void supprimerClient(String numero) {
		
		Client saisie = rechercherClient(numero);
		int pos = -1;
		pos = listeClients.indexOf(saisie);
		if (pos != -1) { listeClients.remove(saisie); }
		System.out.println(saisie);
	}
	
	//A: Ici j'ai enleve une tonne de fonctions inutiles

	public Client rechercherClient(String idClient){
		
		Client saisie = new Client(idClient);
		Collections.sort(listeClients, new ClientParCompte());
		int pos = Collections.binarySearch(listeClients, saisie, new ClientParCompte());
		//B: En cas qu'il ne trouve pas le client
		if (pos >= 0){
			saisie = listeClients.get(pos);
			System.out.println(saisie);
			return saisie;
		}
		else{
			JOptionPane.showMessageDialog(null, "Le numéro entré est invalide");
			return null;
		}
	}

	public void remplirListeClients(){
		Client bele = new ClientEtudiant(
				"Bele", new Adresse("100", "D'Ahuntsic", "Montreal", "Quebec", "H1H5Y7", "Canada"), 
				new Telephone("5142317864", "", "5141110087", "", "4382322276", "5149982045"), 
				"bele@ahuntsic.qc.ca", "909818727", 'm', "College Ahuntsic", "AEC", "2010-01-01");
		Client alex = new ClientEtudiant(
				"Alex", new Adresse("1", "Du College", "1", "Montreal", "Quebec", "H2H1Y7", "Canada"), 
				new Telephone("5143457864", "1", "5142290087", "0", "4382398876", "5149982034"), 
				"alex@ahuntsic.qc.ca", "909818727", 'm', "College Ahuntsic", "AEC", "2010-01-01");
		Client kerlyne = new ClientParticulier(
				"Kerlyne", new Adresse("200", "Du Cheval", "Montreal", "Quebec", "H6H1Y2", "Canada"), 
				new Telephone("5143457864", "", "5142290087", "", "", ""),
				"", "121818727", 'f');
		Client antonio = new ClientParticulier(
				"Antonio", new Adresse("333", "Du Bonhomme", "100", "Montreal", "Quebec", "H2x1U8", "Canada"), 
				new Telephone("5143457864", "", "", "", "", ""), 
				"antonio@ahuntsic.qc.ca", "323818727", 'm');
		Client annie = new ClientEntreprise(
				"College Ahuntsic Inc.", new Adresse("300", "Du Plateau", "", "Montreal", "Quebec", "H3E1Y5", "Canada"), 
				new Telephone("", "", "", "", "", ""), 
				"", "939454727", "www.collegeahuntsic.qc.ca");
		
		// A: Jai updater ici pour ajouter un compte different a chaque client
		
		bele.ajouteCompte1(bele.getId());
		alex.ajouteCompte2(alex.getId());
		kerlyne.ajouteCompte3(kerlyne.getId());
		antonio.ajouteCompte4(antonio.getId());
		annie.ajouteCompte5(annie.getId());
		listeClients.add(bele);
		listeClients.add(alex);
		listeClients.add(kerlyne);
		listeClients.add(antonio);
		listeClients.add(annie);
		System.out.println(listeClients);
	}	
	
	//B : télécharger fichier comptes
	public void initialiserCompte(String nomFichier){
		try{
			FileReader fr = new FileReader(nomFichier);
			BufferedReader bw = new BufferedReader(fr);
			String ligneLue;
			do{
				ligneLue = bw.readLine();
				if (ligneLue != null){
					StringTokenizer tokens = new StringTokenizer(ligneLue,";");
					String numero = tokens.nextToken();
					double solde = Double.parseDouble(tokens.nextToken());
					String devise = tokens.nextToken();
					String date = tokens.nextToken();
					//compte c = new CompteEpargne(numero, solde, devise, date);
					//listeComptes.add(c);
				}
				
			}while(ligneLue != null);
			bw.close();
		}
		catch(FileNotFoundException ex){
			System.out.println(ex.getMessage());
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		
	}
		
	//B : télécharger fichier clients
	public void initialiserClient(String nomFichier){
		try{
			FileReader fr = new FileReader(nomFichier);
			BufferedReader bw = new BufferedReader(fr);
			String ligneLue;
			do{
				ligneLue = bw.readLine();
				if (ligneLue != null){
					StringTokenizer tokens = new StringTokenizer(ligneLue,";");
					String id = tokens.nextToken();
					if (id.substring(10,12).equals("18")){
						String nom = tokens.nextToken();
						String numero = tokens.nextToken();
						String rue = tokens.nextToken();
						String numAppart = tokens.nextToken();
						String ville = tokens.nextToken();
						String province = tokens.nextToken();
						String codePostal = tokens.nextToken();
						String pays = tokens.nextToken();
						String numPrincipale = tokens.nextToken();
						String extNumPrincipale = tokens.nextToken();
						String numSecondaire = tokens.nextToken();
						String extNumSecondaire = tokens.nextToken();
						String cellulaire = tokens.nextToken();
						String telecopieur = tokens.nextToken();
						String courriel = tokens.nextToken();
						String nas = tokens.nextToken();
						char sexe = tokens.nextToken().charAt(0);
						String ecole = tokens.nextToken();
						String niveau = tokens.nextToken();
						String calendar = tokens.nextToken();
					/*	listeClients.add(new Client(nom, new Adresse(numero, rue, numAppart, ville, province,
								codePostal, pays), new Telephone(numPrincipale, extNumPrincipale,
								numSecondaire, extNumSecondaire, cellulaire, telecopieur), courriel,
								nas, sexe, ecole, niveau, calendar));*/
					}
					else if (id.substring(10,12).equals("12")){
						String nom = tokens.nextToken();
						String numero = tokens.nextToken();
						String rue = tokens.nextToken();
						String numAppart = tokens.nextToken();
						String ville = tokens.nextToken();
						String province = tokens.nextToken();
						String codePostal = tokens.nextToken();
						String pays = tokens.nextToken();
						String numPrincipale = tokens.nextToken();
						String extNumPrincipale = tokens.nextToken();
						String numSecondaire = tokens.nextToken();
						String extNumSecondaire = tokens.nextToken();
						String cellulaire = tokens.nextToken();
						String telecopieur = tokens.nextToken();
						String courriel = tokens.nextToken();
						String nas = tokens.nextToken();
						char sexe = tokens.nextToken().charAt(0);
					/*	listeClients.add(new Client(nom, new Adresse(numero, rue, numAppart, ville, province,
								codePostal, pays), new Telephone(numPrincipale, extNumPrincipale,
								numSecondaire, extNumSecondaire, cellulaire, telecopieur), courriel,
								nas, sexe));*/
					}else if (id.substring(10,12).equals("16")){
						String nom = tokens.nextToken();
						String numero = tokens.nextToken();
						String rue = tokens.nextToken();
						String numAppart = tokens.nextToken();
						String ville = tokens.nextToken();
						String province = tokens.nextToken();
						String codePostal = tokens.nextToken();
						String pays = tokens.nextToken();
						String numPrincipale = tokens.nextToken();
						String extNumPrincipale = tokens.nextToken();
						String numSecondaire = tokens.nextToken();
						String extNumSecondaire = tokens.nextToken();
						String cellulaire = tokens.nextToken();
						String telecopieur = tokens.nextToken();
						String courriel = tokens.nextToken();
						String neq = tokens.nextToken();
						String url = tokens.nextToken();
					/*	listeClients.add(new Client(nom, new Adresse(numero, rue, numAppart, ville, province,
								codePostal, pays), new Telephone(numPrincipale, extNumPrincipale,
								numSecondaire, extNumSecondaire, cellulaire, telecopieur), courriel,
								neq, url));*/
					}
				}
				
			}while(ligneLue != null);
			bw.close();
		}
		catch(FileNotFoundException ex){
			System.out.println(ex.getMessage());
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}

	public void enregistrerFichierClients(String nomFichier){
		try{
			FileWriter fw = new FileWriter(nomFichier);
			PrintWriter pw = new PrintWriter(fw);
			for (int i=0; i< listeClients.size(); i++){
				if (i < listeClients.size() -1){
					pw.println(listeClients.get(i).toString());
				}
				else{
					pw.print(listeClients.get(i).toString());
				}
			}
			pw.close();
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	//B: trouver liste comptes
	public void enregistrerFichierComptes(String nomFichier){
		try{
			FileWriter fw = new FileWriter(nomFichier);
			PrintWriter pw = new PrintWriter(fw);
			for (int i=0; i< listeClients.size(); i++){
				if (i < listeClients.size() -1){
					pw.println(listeClients.get(i).genererAfficheComptes());
					System.out.println(listeClients.get(i).genererAfficheComptes());
				}
				else{
					pw.print(listeClients.get(i).genererAfficheComptes());
					System.out.println("else : " +listeClients.get(i).genererAfficheComptes());

				}
			}
			pw.close();
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}
}
