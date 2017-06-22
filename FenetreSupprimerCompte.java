package ca.qc.collegeahuntsic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FenetreSupprimerCompte extends JInternalFrame implements ActionListener{
	
	private JPanel panelCentre;
	private JTextField txtRechercheClient;
	private JTextField txtRechercheCompte;
	private JButton btSupprimer;
	private JButton btAnnuler;

	Banque banque;
	//A: Ajout d'un client
	Client client;
	
	//A: Et dans le constructeur
	public FenetreSupprimerCompte(String titre, Banque banque){
		super(titre, true, true, true, true);
		setSize(600,150);
		setVisible(true);
		this.banque = banque;
		construireComposantes();
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == btSupprimer){
			client = banque.rechercherClient(txtRechercheClient.getText());
			//A: Ici aussi
			client.supprimerCompte(txtRechercheCompte.getText());
			setVisible(false);
		}
		else if (e.getSource() == btAnnuler){
			setVisible(false);
		}
	}
	
	
	public void construireComposantes(){
		panelCentre = new JPanel();
		panelCentre.setLayout(new GridLayout(2,2));
		JLabel lbRecherche = new JLabel("Entrer le numéro de compte à supprimer : ");
		txtRechercheClient = new JTextField(30);
		btSupprimer = new JButton("Supprimer");
		btAnnuler = new JButton("Annuler");
		panelCentre.add(lbRecherche);
		panelCentre.add(txtRechercheClient);
		
		//A: Ajout rechercherCompte
		panelCentre.add(txtRechercheCompte);
		panelCentre.add(btSupprimer);
		panelCentre.add(btAnnuler);
			
		add(panelCentre, BorderLayout.CENTER);
		
		btSupprimer.addActionListener(this);
		btAnnuler.addActionListener(this);
	}
}