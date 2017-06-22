package ca.qc.collegeahuntsic;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class FenetreJTableClients extends JInternalFrame {
	
	private JPanel panelHaut;
	private JLabel lbTitre;
	private JPanel panelCentre;
	Banque banque;
	private JTable tableClientss;
	private JTable tableComptes;
	private JScrollPane scrollPane;
		
	public FenetreJTableClients(String titre, Banque banque){
		super(titre, true, true, true, true);
		setSize(600,150);
		setLocation(300,50);
		setVisible(true);
		String[] colCompte = {"Id Client", "Type", "Numero", "Solde", "Devise", "Date"};
		DefaultTableModel modelCompte = new DefaultTableModel(colCompte, 0);

		for(int i = 0; i < banque.listeClients.size(); i++) {

			Client saisie = banque.listeClients.get(i);
			
			for(int j = 0; j < saisie.getListSize(); j++) {
				
				Compte compte = saisie.getCompte(j);
				Object[] dataCompte = {saisie.getId(), compte.getType(), 
									   compte.getNumero(), compte.getSolde(), 
									   compte.getDevise(), compte.getDate()};
				modelCompte.addRow(dataCompte);
				}
		}
		tableComptes = new JTable(modelCompte);
		tableComptes.setAutoCreateRowSorter(true);
		
		//A Nouvelle fonction resize
		resizeColumnWidth(tableComptes);
		scrollPane = new JScrollPane(tableComptes);
		Dimension d = tableComptes.getPreferredSize();
		scrollPane.setPreferredSize(new Dimension(d.width,tableComptes.getRowHeight()*banque.listeClients.size()+1));
		add(scrollPane);	
	}

	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}

}
/*	public JScrollPane creerTableComptes(){

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

public JScrollPane creerTableCompteClient(String numero){

	String[] colCompte = {"Id Client", "Type", "Numero", "Solde", "Devise", "Date"};
	DefaultTableModel modelCompte = new DefaultTableModel(colCompte, 0);
	Client saisie = rechercherClient(numero);
	modelCompte = saisie.afficherComptes(saisie.getId());
	JTable tableComptes = new JTable(modelCompte);
	tableComptes.setAutoCreateRowSorter(true);
	JScrollPane scrollPane = new JScrollPane(tableComptes);
	Dimension d = tableComptes.getPreferredSize();
	scrollPane.setPreferredSize(new Dimension(d.width,tableComptes.getRowHeight()*listeClients.size()+1));
	return scrollPane;
}
*/