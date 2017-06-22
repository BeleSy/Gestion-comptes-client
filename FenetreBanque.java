package ca.qc.collegeahuntsic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.table.DefaultTableModel;

public class FenetreBanque extends JFrame implements ActionListener{

	private JMenuItem optCreerClient;
	private JMenuItem optRechercher;
	private JMenuItem optListerClients;
	private JMenuItem optQuitter;
	private JDesktopPane bureau;
	private JMenuItem optListerComptes;
	private JMenuItem optOuvrirCompte;
	private JMenuItem optDebiterCompte;
	private JMenuItem optCrediterCompte;
	private JMenuItem optSupprimerCompte;
	private JInternalFrame tableClients;
	
	Banque banque = new Banque();
	
	public FenetreBanque(){
	
		//A: Jai changer quelques attributs pour le look
		super("Banque Ahuntsic (gere par Bele et Alex)");	//appel du constructeur de la classe mère
		setSize(1250, 700); 								//défini la dimension de la fenetre coin supérieur gauche
		setLocation(50,50); 								//placer dans l'écran ou utiliser setBounds en une formule
		setDefaultCloseOperation(EXIT_ON_CLOSE); 			//pour version java 6 et antérieures
		creerMenu();
		bureau = new JDesktopPane();
		add(bureau);
		setVisible(true);	
		
		// Mettre logo
		ImageIcon icon = new ImageIcon("logo.jpg"); 
		JLabel label = new JLabel(icon);
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		java.awt.Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int dx = icon.getIconWidth();
		int dy = icon.getIconHeight();
		int xwidth = (screen.width-dx)/2;
		int yheight = (screen.height-dy)/2;
		bureau.add(label, JLayeredPane.FRAME_CONTENT_LAYER);
		int xPos = (bureau.getWidth() - label.getWidth()) / 2;
		int yPos = (bureau.getHeight() - label.getHeight()) / 2;
		label.setLocation(xPos, yPos);

	}
	
	public static void main(String[] args) {

		FenetreBanque fenetre = new FenetreBanque();
		
	}
	
	//actionListener
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == optQuitter){
			banque.enregistrerFichierClients("ressources/listeClients.txt");
			banque.enregistrerFichierComptes("ressources/listeComptes.txt");
			System.exit(0);
		}
		else if (e.getSource() == optCreerClient){
			FenetreCreerClient fenetreCreerClient = new FenetreCreerClient("Créer client", banque);
			bureau.add(fenetreCreerClient);
			bureau.setSelectedFrame(fenetreCreerClient);
		}
		else if (e.getSource() == optRechercher){
			FenetreRechercheClient fenetreRechercher = new FenetreRechercheClient("Comptes du client", banque);
			bureau.add(fenetreRechercher);
			bureau.setSelectedFrame(fenetreRechercher);	
		}
		else if (e.getSource() == optOuvrirCompte){
			FenetreOuvrirCompte fenetreOuvrirCompte = new FenetreOuvrirCompte("Ouvrir compte", banque);
			bureau.add(fenetreOuvrirCompte);
			bureau.setSelectedFrame(fenetreOuvrirCompte);
		}
		else if (e.getSource() == optListerComptes){
			FenetreJTableClients fenetreTableClients = new FenetreJTableClients("Liste des Clients de la Banque", banque);
			bureau.add(fenetreTableClients);
			bureau.setSelectedFrame(fenetreTableClients);
		}
		else if (e.getSource() == optListerComptes){
			FenetreJTableComptes fenetreTableComptes = new FenetreJTableComptes("Liste des Comptes de la Banque", banque);
			bureau.add(fenetreTableComptes);
			bureau.setSelectedFrame(fenetreTableComptes);
		}
		else if (e.getSource() == optDebiterCompte){
			FenetreDebiterCompte fenetreOuvrirCompte = new FenetreDebiterCompte("Débiter compte");
			bureau.add(fenetreOuvrirCompte);
			bureau.setSelectedFrame(fenetreOuvrirCompte);
		}
		else if (e.getSource() == optCrediterCompte){
			FenetreCrediterCompte fenetreCrediterCompte = new FenetreCrediterCompte("Créditer compte", banque);
			bureau.add(fenetreCrediterCompte);
			bureau.setSelectedFrame(fenetreCrediterCompte);
		}
		else if (e.getSource() == optSupprimerCompte){
			FenetreSupprimerCompte fenetreSupprimerCompte = new FenetreSupprimerCompte("Supprimer client", banque);
			bureau.add(fenetreSupprimerCompte);
			bureau.setSelectedFrame(fenetreSupprimerCompte);
		}
	}
	
	public void creerMenu(){

		//création de la barre de menu
		JMenuBar barreMenu = new JMenuBar();
		
		//création des objets menu
		JMenu mnuClients = new JMenu("Clients");
						
		//création des objets de menu Clients
		optCreerClient = new JMenuItem("Créer client");
		optRechercher = new JMenuItem("Rechercher un client");
		optQuitter = new JMenuItem("Quitter le programme");
						
		//ajout des options de menus Options dans le menu Options
		mnuClients.addSeparator();
		mnuClients.add(optCreerClient);
		mnuClients.addSeparator();
		mnuClients.add(optRechercher);
		mnuClients.addSeparator();
		mnuClients.add(optQuitter);
				
		//ajout du menu fichier dans la barre menu
		barreMenu.add(mnuClients);
				
		//actionListener pour tous les boutons du menu
		optCreerClient.addActionListener(this);
		optRechercher.addActionListener(this);
		optQuitter.addActionListener(this);
		
		//création des objets menu
		JMenu mnuComptes = new JMenu("Comptes");
				
		//création des objets de menu Comptes
		optOuvrirCompte = new JMenuItem("Ouvrir compte");
		optListerComptes = new JMenuItem("Lister les comptes");
		optDebiterCompte = new JMenuItem("Débiter un compte");
		optCrediterCompte = new JMenuItem("Créditer un compte");
		optSupprimerCompte = new JMenuItem("Supprimer un compte");
		
		//ajout du menu fichier dans la barre menu
		barreMenu.add(mnuComptes);
		
		//ajouter la barre de menus <a la fenetre
		setJMenuBar(barreMenu);
		
		//ajout des options compte dans le menu Recherche
		mnuComptes.add(optOuvrirCompte);
		mnuComptes.addSeparator();
		mnuComptes.add(optListerComptes);
		mnuComptes.addSeparator();
		mnuComptes.add(optDebiterCompte);
		mnuComptes.addSeparator();
		mnuComptes.add(optCrediterCompte);
		mnuComptes.addSeparator();
		mnuComptes.add(optSupprimerCompte);
		
		//ajout du menu fichier dans la barre menu
		barreMenu.add(mnuComptes);
		
		optOuvrirCompte.addActionListener(this);
		optListerComptes.addActionListener(this);
		optDebiterCompte.addActionListener(this);
		optCrediterCompte.addActionListener(this);
		optSupprimerCompte.addActionListener(this);
		
		//ajouter la barre de menus <a la fenetre
		setJMenuBar(barreMenu);
	}
	
}
