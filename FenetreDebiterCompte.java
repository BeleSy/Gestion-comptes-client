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

public class FenetreDebiterCompte extends JInternalFrame implements ActionListener{
	private JPanel panelCentre;
	private JTextField txtRechercheCompte;
	private JTextField txtDebiterCompte;
	private JButton btDebiter;
	private JButton btAnnuler;
		
	public FenetreDebiterCompte(String titre){
		super(titre, true, true, true, true);
		setSize(600,150);
		setVisible(true);
		construireComposantes();
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == btDebiter){
			//rechercher txtRechercheComptet.getText();
			//débiter txtDebiterCompte.getText();
			//mettre un fonction qui ne dépasse pas le minimum
			setVisible(false);
		}
		else if (e.getSource() == btAnnuler){
			setVisible(false);
		}
	}
	
	
	public void construireComposantes(){
		panelCentre = new JPanel();
		panelCentre.setLayout(new GridLayout(3,2));
		JLabel lbRecherche = new JLabel("Entrer le compte à débiter : ");
		txtRechercheCompte = new JTextField(20);
		JLabel lbDebiter = new JLabel("Entrer le montant à débiter : ");
		txtDebiterCompte = new JTextField(20);
		btDebiter = new JButton("Débiter");
		btAnnuler = new JButton("Annuler");
		panelCentre.add(lbRecherche);
		panelCentre.add(txtRechercheCompte);
		panelCentre.add(lbDebiter);
		panelCentre.add(txtDebiterCompte);
		panelCentre.add(btDebiter);
		panelCentre.add(btAnnuler);
		
		
		add(panelCentre, BorderLayout.CENTER);
		
		btDebiter.addActionListener(this);
		btAnnuler.addActionListener(this);
	}
}