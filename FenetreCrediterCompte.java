package ca.qc.collegeahuntsic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FenetreCrediterCompte extends JInternalFrame implements ActionListener{
	
	private JPanel panelCentre;
	
	//A: Ajout texte recherche client
	private JTextField txtRechercheClient;
	private JTextField txtRechercheCompte;
	private JTextField txtCrediterCompte;
	private JButton btCrediter;
	private JButton btAnnuler;
	
	Banque banque;
	//A: Ici, j'ai changer banque pour client et on va lancer un client dans le constructeur
	Client client;
	
	public FenetreCrediterCompte(String titre, Banque banque){
		super(titre, true, true, true, true);
		setSize(600,150);
		setVisible(true);
		this.banque = banque;
		construireComposantes();
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == btCrediter){
			client = banque.rechercherClient(txtRechercheClient.getText());
			//A: client
			client.crediterCompte(txtRechercheCompte.getText(), txtCrediterCompte.getText());
			setVisible(false);
		}
		else if (e.getSource() == btAnnuler){
			setVisible(false);
		}
	}
	
	
	public void construireComposantes(){
		panelCentre = new JPanel();
		panelCentre.setLayout(new GridLayout(3,2));
		JLabel lbRecherche = new JLabel("Entrer le compte à créditer : ");
		txtRechercheCompte = new JTextField(20);
		JLabel lbCrediter = new JLabel("Entrer le montant à créditer : ");
		txtCrediterCompte = new JTextField(20);
		btCrediter = new JButton("Créditer");
		btAnnuler = new JButton("Annuler");
		panelCentre.add(lbRecherche);
		panelCentre.add(txtRechercheCompte);
		panelCentre.add(lbCrediter);
		panelCentre.add(txtCrediterCompte);
		panelCentre.add(btCrediter);
		panelCentre.add(btAnnuler);
		
		add(panelCentre, BorderLayout.CENTER);
		
		btCrediter.addActionListener(this);
		btAnnuler.addActionListener(this);
	}
}
