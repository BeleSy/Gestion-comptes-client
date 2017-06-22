package ca.qc.collegeahuntsic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FenetreOuvrirCompte extends JInternalFrame implements ActionListener{
	
	private JPanel panelCentre;
	private JLabel lbNumCompte;
	private JTextField txtNumCompte;
	private JLabel lbNumClient;
	private JTextField txtNumClient;
	private JLabel lbSolde;
	private JTextField txtSolde;
	private JLabel lbDevise;
	private JTextField txtDevise;
	private JLabel lbDate;
	private JTextField txtDate;
	private JLabel lbSelectTypeCompte;
	private JRadioButton radioEpargne;
	private JRadioButton radioCheque;
	private JButton btValider;
	private JPanel panelBas;
	private JLabel lbSoldeMin;
	private JTextField txtSoldMin;
	private JLabel lbLimDecouvert;
	private JTextField txtLimDecouvert;
	private JButton btnEnregistrer;
	private JButton btnAnnuler;
	Banque banque;	
	
	public FenetreOuvrirCompte(String titre, Banque banque){
		super(titre, true, true, true, true);
		setSize(800,400);
		construireComposants();
		setVisible(true);
		panelBas.setVisible(false);
		this.banque = banque;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== btnEnregistrer){
			if(radioEpargne.isSelected() == true){
				enregistrerCompteEpargne();
			}
			if(radioCheque.isSelected() == true){
				enregistrerCompteCheque();
			}
			setVisible(false);
		}
		else if(e.getSource()== btnAnnuler){
			setVisible(false);
		}
		else if(e.getSource()== btValider){
			initialiserCompte();
			if(radioEpargne.isSelected() == true){
				panelBas.setVisible(true);
				lbSoldeMin.setVisible(true);
				txtSoldMin.setVisible(true);
				btnEnregistrer.setVisible(true);
				btnAnnuler.setVisible(true);
			}
			if(radioCheque.isSelected() == true){
				panelBas.setVisible(true);
				lbLimDecouvert.setVisible(true);
				txtLimDecouvert.setVisible(true);
				btnEnregistrer.setVisible(true);
				btnAnnuler.setVisible(true);
			}
		}
	}
	
	private void construireComposants(){
		//informations générales pour tous les clients
		panelCentre = new JPanel();
		panelCentre.setLayout(new FlowLayout());
		lbNumCompte = new JLabel("Numéro de compte : ");
		panelCentre.add(lbNumCompte);
		txtNumCompte = new JTextField(20);
		panelCentre.add(txtNumCompte);
		lbSolde = new JLabel("Solde : ");
		panelCentre.add(lbSolde);
		txtSolde = new JTextField(20);
		panelCentre.add(txtSolde);
		lbDevise = new JLabel("Devise : ");
		panelCentre.add(lbDevise);
		txtDevise = new JTextField(20);
		panelCentre.add(txtDevise);
		lbDate = new JLabel("Date : ");
		panelCentre.add(lbDate);
		txtDate = new JTextField(20);
		panelCentre.add(txtDate);
		lbSelectTypeCompte = new JLabel("Sélectionner le type de compte ");
		panelCentre.add(lbSelectTypeCompte);
		radioEpargne = new JRadioButton("Épargne");
		radioCheque = new JRadioButton("Chèque");
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioEpargne);
		bg.add(radioCheque);
		panelCentre.add(radioEpargne);
		panelCentre.add(radioCheque);
		btValider = new JButton ("Valider");
		panelCentre.add(btValider);
		btValider.addActionListener(this);
		add(panelCentre, BorderLayout.CENTER);
		
		//Option des comptes
		panelBas = new JPanel();
		panelBas.setLayout(new FlowLayout());
		lbSoldeMin = new JLabel("Entrer le solde minimum : ");
		panelBas.add(lbSoldeMin);
		txtSoldMin = new JTextField(20);
		panelBas.add(txtSoldMin);
		lbLimDecouvert = new JLabel("Entrer la limite découvert: ");
		panelBas.add(lbLimDecouvert);
		txtLimDecouvert = new JTextField(20);
		panelBas.add(txtLimDecouvert);
		btnEnregistrer = new JButton("Enregistrer");
		btnAnnuler = new JButton("Annuler");
		panelBas.add(btnEnregistrer);
		panelBas.add(btnAnnuler);
		add(panelBas, BorderLayout.SOUTH);
		
		btnEnregistrer.addActionListener(this);
		btnAnnuler.addActionListener(this);
	}

	
	private void enregistrerCompteEpargne(){
		String numCompte = txtNumCompte.getText();
		String solde = txtSolde.getText();
		String devise = txtDevise.getText();
		String date = txtDate.getText();
		String soldeMin = txtSoldMin.getText();
		//ajouter compte épargne
		CompteEpargne compteEpargne = new CompteEpargne(numCompte, Double.parseDouble(solde), devise, date, "Inconnu", Double.parseDouble(soldeMin));
		banque.ajouterCompte(compteEpargne);
	}
	
	private void enregistrerCompteCheque(){
		String numCompte = txtNumCompte.getText();
		String solde = txtSolde.getText();
		String devise = txtDevise.getText();
		String date = txtDate.getText();
		String limDecouvert = txtLimDecouvert.getText();
		//ajouter compte cheque		
	}
	
	public void initialiserCompte(){
		panelBas.setVisible(false);
		lbSoldeMin.setVisible(false);;
		txtSoldMin.setVisible(false);
		lbLimDecouvert.setVisible(false);
		txtLimDecouvert.setVisible(false);
		btnEnregistrer.setVisible(false);
		btnAnnuler.setVisible(false);
	}
}
