package ca.qc.collegeahuntsic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FenetreRechercheClient extends JInternalFrame implements ActionListener{
	
	private JPanel panelCentre;
	private JPanel panelHaut;
	private JTextField txtRechercheClient;
	private JButton btRechercher;
	private JButton btAnnuler;
	
	Banque banque;
	JDesktopPane bureau;
	private JTable tableComptes;
	private DefaultTableModel modelCompte;
	private JScrollPane scrollPane;
	
	
	public FenetreRechercheClient(String titre, Banque banque){
		super(titre, true, true, true, true);
		setSize(600,150);
		setVisible(true);
		this.banque = banque;
		construireComposantes();
		panelCentre.setVisible(false);
				
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == btRechercher){
			setSize(600,250);
			String[] colCompte = {"Id Client", "Type", "Numero", "Solde", "Devise", "Date"};
			modelCompte = new DefaultTableModel(colCompte, 0);
			
			//A: Nouvelle methode chercher listeComptes dans Client
			Client saisie = banque.rechercherClient(txtRechercheClient.getText());
			modelCompte = saisie.afficherComptes(saisie.getId());
			tableComptes = new JTable(modelCompte);
			
			// A: Sorter
			tableComptes.setAutoCreateRowSorter(true);
			scrollPane = new JScrollPane(tableComptes);

			//A: Resize le scrollPane a la grandeur de la table
			Dimension d = tableComptes.getPreferredSize();
			scrollPane.setPreferredSize(new Dimension(d.width,tableComptes.getRowHeight()*banque.listeClients.size()+1));
			panelCentre.add(scrollPane, BorderLayout.CENTER);
			panelCentre.setVisible(true);
		}
		else if (e.getSource() == btAnnuler){
			setVisible(false);
		}
	}
	
	//B: ajout de JTable liste comptes des clients
	public void construireComposantes(){

		panelHaut = new JPanel();
		panelHaut.setLayout(new FlowLayout());
		JLabel lbRecherche = new JLabel("Entrer l'identifiant du client recherché : ");
		txtRechercheClient = new JTextField(20);
		btRechercher = new JButton("Rechercher");
		btAnnuler = new JButton("Annuler");
		panelHaut.add(lbRecherche);
		panelHaut.add(txtRechercheClient);
		panelHaut.add(btRechercher);
		panelHaut.add(btAnnuler);
		add(panelHaut, BorderLayout.NORTH);
		
		btRechercher.addActionListener(this);
		btAnnuler.addActionListener(this);
		
		panelCentre = new JPanel();
		panelCentre.setLayout(new BorderLayout());
		JLabel lbListeComptese = new JLabel("Liste des comptes du client");
		panelCentre.add(lbListeComptese, BorderLayout.NORTH);
		
		add(panelCentre, BorderLayout.CENTER);
		panelCentre.setVisible(false);
	}
	
	
}
