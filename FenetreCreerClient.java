package ca.qc.collegeahuntsic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class FenetreCreerClient extends JInternalFrame implements ActionListener{
	
	private JPanel panelClient;
	private JPanel panelBoutons;	
	
	private JTextField txtNom;
	private JTextField txtEmail;
	private JTextField txtNumRue;							
	private JTextField txtRue;
	private JTextField txtNumApt;
	private JTextField txtVille;
	private JTextField txtProvince;
	private JTextField txtCodePost;
	private JTextField txtPays;
	private JTextField txtTelPrinc;
	private JTextField txtExtPrinc;
	private JTextField txtTelSec;
	private JTextField txtExtSec;
	private JTextField txtNumMob;
	private JTextField txtTelecop;
	
	private JButton btValider;
	private JRadioButton radioParticulier;
	private JRadioButton radioEtud;
	private JRadioButton radioEnt;
	
	private JTextField txtNas;
	private JTextField txtSex;
	private JTextField txtEcole;
	private JTextField txtNiveau;
	private JTextField txtCal;
	private JTextField txtNeq;
	private JTextField txtUrl;
	
	private JButton btnEnregistrer;
	private JButton btnAnnuler;
	
	private JLabel lbNas;
	private JLabel lbSexe;
	private JLabel lbEcole;
	private JLabel lbNiveau;
	private JLabel lbDate;
	private JLabel lbNeq;
	private JLabel lbUrl;
	
	Banque banque;
		
	public FenetreCreerClient(String titre, Banque banque){
		super(titre, true, true, true, true);
		
		//A Edit
		setSize(530,490);
		setLocation(10,10);
		construireComposants();
		setVisible(true);
		setLayout(new FlowLayout());
		this.banque = banque;
//		panelClient.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()== btnEnregistrer){
			if(radioParticulier.isSelected() == true){
				banque.ajouterClient(enregistrerParticulier());
			}
			if(radioEtud.isSelected() == true){
				banque.ajouterClient(enregistrerEtudiant());
			}
			if(radioParticulier.isSelected() == true){
				banque.ajouterClient(enregistrerEntreprise());
			}
//			setVisible(true);
		}
		else if(e.getSource()== btnAnnuler){
			setVisible(false);
		}
		else if(e.getSource()== btValider){
			initialiserClients();
			if(radioParticulier.isSelected() == true){
				lbNas.setVisible(true);
				txtNas.setVisible(true);
				lbSexe.setVisible(true);
				txtSex.setVisible(true);
				btnEnregistrer.setVisible(true);
				btnAnnuler.setVisible(true);
			
				lbEcole.setVisible(false);
				txtEcole.setVisible(false);
				lbNiveau.setVisible(false);
				txtNiveau.setVisible(false);
				lbDate.setVisible(false);
				txtCal.setVisible(false);
				lbNeq.setVisible(false);
				txtNeq.setVisible(false);
				txtUrl.setVisible(false);
				lbUrl.setVisible(false);
				txtUrl.setVisible(false);
			}
			if(radioEtud.isSelected() == true){
				lbNas.setVisible(true);
				txtNas.setVisible(true);
				lbSexe.setVisible(true);
				txtSex.setVisible(true);
				lbEcole.setVisible(true);
				txtEcole.setVisible(true);
				lbNiveau.setVisible(true);
				txtNiveau.setVisible(true);
				lbDate.setVisible(true);
				txtCal.setVisible(true);
				btnEnregistrer.setVisible(true);
				btnAnnuler.setVisible(true);

				lbNeq.setVisible(false);
				txtNeq.setVisible(false);
				txtUrl.setVisible(false);
				lbUrl.setVisible(false);
				txtUrl.setVisible(false);
			}
			if(radioEnt.isSelected() == true){
			
				lbNeq.setVisible(true);
				txtNeq.setVisible(true);
				txtUrl.setVisible(true);
				lbUrl.setVisible(true);
				txtUrl.setVisible(true);
				btnEnregistrer.setVisible(true);
				btnAnnuler.setVisible(true);
			
				lbEcole.setVisible(false);
				txtEcole.setVisible(false);
				lbNiveau.setVisible(false);
				txtNiveau.setVisible(false);
				lbDate.setVisible(false);
				txtCal.setVisible(false);
				lbNas.setVisible(false);
				txtNas.setVisible(false);
				lbSexe.setVisible(false);
				txtSex.setVisible(false);
				btnEnregistrer.setVisible(true);
				btnAnnuler.setVisible(true);
			}
		}
	}
	
	private void construireComposants(){

		//informations générales pour tous les clients
		JPanel panelCentre = new JPanel();
		panelCentre.setLayout(new GridLayout(17,2));

		//A Ajout padding
		Border padding = BorderFactory.createEmptyBorder(8, 8, 8, 8);
		
		panelCentre.add(new JLabel("Nom"));
		txtNom = new JTextField(10);
		panelCentre.add(txtNom);

		panelCentre.add(new JLabel("Numero de rue"));
		txtNumRue = new JTextField(10);
		panelCentre.add(txtNumRue);

		panelCentre.add(new JLabel("Rue"));
		txtRue = new JTextField(10);
		panelCentre.add(txtRue);

		panelCentre.add(new JLabel("Numéro appart."));
		txtNumApt = new JTextField(10);
		panelCentre.add(txtNumApt);

		panelCentre.add(new JLabel("Ville"));
		txtVille = new JTextField(10);
		panelCentre.add(txtVille);

		panelCentre.add(new JLabel("Province"));
		txtProvince = new JTextField(10);
		panelCentre.add(txtProvince);

		panelCentre.add(new JLabel("Code Postal"));
		txtCodePost = new JTextField(10);
		panelCentre.add(txtCodePost);

		panelCentre.add(new JLabel("Pays"));
		txtPays = new JTextField(10);
		panelCentre.add(txtPays);

		panelCentre.add(new JLabel("Courriel"));
		txtEmail = new JTextField(10);
		panelCentre.add(txtEmail);

		panelCentre.add(new JLabel("Tél. principlale"));
		txtTelPrinc = new JTextField(10);
		panelCentre.add(txtTelPrinc);

		panelCentre.add(new JLabel("Ext. principale"));
		txtExtPrinc = new JTextField(10);
		panelCentre.add(txtExtPrinc);

		panelCentre.add(new JLabel("Tél. secondaire"));
		txtTelSec = new JTextField(10);
		panelCentre.add(txtTelSec);

		panelCentre.add(new JLabel("Ext. secondaire"));
		txtExtSec = new JTextField(10);
		panelCentre.add(txtExtSec);

		panelCentre.add(new JLabel("Num. mobilité"));
		txtNumMob = new JTextField(10);
		panelCentre.add(txtNumMob);

		panelCentre.add(new JLabel("Télécopieur"));
		txtTelecop = new JTextField(10);
		panelCentre.add(txtTelecop);
		
		panelCentre.add(new JLabel("Type de client : "));

		radioParticulier = new JRadioButton("Particulier");
		radioEtud = new JRadioButton("Étudiant");
		radioEnt = new JRadioButton("Entreprise");
		
		//A: Button group
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(radioParticulier);
		bGroup.add(radioEtud);
		bGroup.add(radioEnt);
		
		panelCentre.add(radioParticulier);
		panelCentre.add(radioEtud);
		panelCentre.add(radioEnt);
		
		btValider = new JButton ("Valider");
		btValider.addActionListener(this);

		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.add(panelCentre, BorderLayout.CENTER);
		panelMain.add(btValider, BorderLayout.SOUTH);
		panelMain.setBorder(padding);

		JPanel panelClient = new JPanel();
		panelClient.setLayout(new GridLayout(7,2));

		//différentes options du bas
		lbNas = new JLabel("NAS");
		panelClient.add(lbNas);
		lbNas.setVisible(false);
		txtNas = new JTextField(10);
		panelClient.add(txtNas);
		txtNas.setVisible(false);
		
		lbSexe = new JLabel("Sexe");
		panelClient.add(lbSexe);
		lbSexe.setVisible(false);
		txtSex = new JTextField(10);
		panelClient.add(txtSex);
		txtSex.setVisible(false);
		
		JPanel panelSecondaire = new JPanel();
		panelSecondaire.setLayout(new BorderLayout());
		panelSecondaire.setBorder(padding);
		
		//option étudiant
		lbEcole = new JLabel("École");
		lbEcole.setVisible(false);
		panelClient.add(lbEcole);
		txtEcole = new JTextField(10);
		panelClient.add(txtEcole);
		txtEcole.setVisible(false);
		lbNiveau = new JLabel("Niveau");
		panelClient.add(lbNiveau);
		lbNiveau.setVisible(false);
		txtNiveau = new JTextField(10);
		panelClient.add(txtNiveau);
		txtNiveau.setVisible(false);
		lbDate = new JLabel("Sexe");
		panelClient.add(lbDate);
		lbDate.setVisible(false);
		txtCal = new JTextField(10);
		panelClient.add(txtCal);
		txtCal.setVisible(false);
		
		//option entreprise
		lbNeq = new JLabel("NEQ");
		panelClient.add(lbNeq);
		lbNeq.setVisible(false);
		txtNeq = new JTextField(10);
		panelClient.add(txtNeq);
		txtNeq.setVisible(false);
		lbUrl = new JLabel("URL");
		panelClient.add(lbUrl);
		lbUrl.setVisible(false);
		txtUrl = new JTextField(10);
		panelClient.add(txtUrl);
		txtUrl.setVisible(false);
		
		panelSecondaire.add(panelClient, BorderLayout.CENTER);
		JPanel panelBoutons = new JPanel();
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(this);
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		panelBoutons.add(btnEnregistrer);
		btnEnregistrer.setVisible(false);
		panelBoutons.add(btnAnnuler);
		btnAnnuler.setVisible(false);

		panelSecondaire.add(panelBoutons, BorderLayout.SOUTH);
		JSplitPane splitPane = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT, panelMain, panelSecondaire);
		add(splitPane);
						
	}
	
	private Client enregistrerParticulier(){
		
		String nom = txtNom.getText();
		String email = txtEmail.getText();
		
		//ajout adresse
		String numRue = txtNumRue.getText();
		String rue = txtRue.getText();
		String numAppart = txtNumApt.getText();
		String ville = txtVille.getText();
		String province = txtProvince.getText();
		String codePostal = txtCodePost.getText();
		String pays = txtPays.getText();
		
		//ajout telephone
		String telPrincipale = txtTelPrinc.getText();
		String extPrincipale = txtTelPrinc.getText();
		String telSecondaire = txtTelSec.getText();
		String extSecondaire = txtExtSec.getText();
		String numMobilite = txtNumMob.getText();
		String telecopieur = txtTelecop.getText();
		
		//specifique à particulier
		String nas = txtNas.getText();
		char sexe = txtSex.getText().charAt(0);
		
		//ajouter client particulier
		Adresse saisie = new Adresse(numRue, rue, numAppart, ville, province, codePostal, pays);
		Telephone saisieTelephone = new Telephone(telPrincipale, extPrincipale, telSecondaire, extSecondaire, numMobilite, telecopieur);
		ClientParticulier clientP = new ClientParticulier(nom, saisie, saisieTelephone, email, nas, sexe);
		
		return clientP;
	}
	
	private Client enregistrerEtudiant(){

		String nom = txtNom.getText();
		String email = txtEmail.getText();
		//ajout adresse
		String numRue = txtNumRue.getText();
		String rue = txtRue.getText();
		String numAppart = txtNumApt.getText();
		String ville = txtVille.getText();
		String province = txtProvince.getText();
		String codePostal = txtCodePost.getText();
		String pays = txtPays.getText();
		//ajout telephone
		String telPrincipale = txtTelPrinc.getText();
		String extPrincipale = txtTelPrinc.getText();
		String telSecondaire = txtTelSec.getText();
		String extSecondaire = txtExtSec.getText();
		String numMobilite = txtNumMob.getText();
		String telecopieur = txtTelecop.getText();
		//specifique à particulier
		String nas = txtNas.getText();
		char sexe = txtSex.getText().charAt(0);
		String ecole = txtEcole.getText();
		String niveau = txtNiveau.getText();
		String date = txtCal.getText();
		//ajouter client étudiant
		Adresse saisie = new Adresse(numRue, rue, numAppart, ville, province, codePostal, pays);
		Telephone saisieTelephone = new Telephone(telPrincipale, extPrincipale, telSecondaire, extSecondaire, numMobilite, telecopieur);
		ClientEtudiant clientE = new ClientEtudiant(nom, saisie, saisieTelephone, email, nas, sexe, ecole, niveau, date);
		return clientE;

	}
	
	private Client enregistrerEntreprise(){

		String nom = txtNom.getText();
		String email = txtEmail.getText();
		//ajout adresse
		String numRue = txtNumRue.getText();
		String rue = txtRue.getText();
		String numAppart = txtNumApt.getText();
		String ville = txtVille.getText();
		String province = txtProvince.getText();
		String codePostal = txtCodePost.getText();
		String pays = txtPays.getText();
		//ajout telephone
		String telPrincipale = txtTelPrinc.getText();
		String extPrincipale = txtTelPrinc.getText();
		String telSecondaire = txtTelSec.getText();
		String extSecondaire = txtExtSec.getText();
		String numMobilite = txtNumMob.getText();
		String telecopieur = txtTelecop.getText();
		//specifique à entreprise
		String neq = txtNeq.getText();
		String url = txtUrl.getText();
		//ajouter client entreprise	
		Adresse saisie = new Adresse(numRue, rue, numAppart, ville, province, codePostal, pays);
		Telephone saisieTelephone = new Telephone(telPrincipale, extPrincipale, telSecondaire, extSecondaire, numMobilite, telecopieur);
		ClientEntreprise clientEn = new ClientEntreprise(nom, saisie, saisieTelephone, email, neq, url);
		return clientEn;
	}
	
	public void initialiserClients(){
/*		panelClient.setVisible(true);
		lbNas.setVisible(true);
		txtNas.setVisible(true);
		lbSexe.setVisible(true);
		txtSex.setVisible(true);
		lbEcole.setVisible(true);
		txtEcole.setVisible(true);
		lbNiveau.setVisible(true);
		txtNiveau.setVisible(true);
		lbDate.setVisible(true);
		txtCal.setVisible(true);
		lbNeq.setVisible(true);
		txtNeq.setVisible(true);
		lbUrl.setVisible(true);
		txtUrl.setVisible(true);
		btnEnregistrer.setVisible(true);
		btnAnnuler.setVisible(true); */
	}
}
