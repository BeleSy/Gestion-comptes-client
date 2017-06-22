package ca.qc.collegeahuntsic;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/* Fenetre.java
 * Auteur: Alexander Pawinski
 * Crée le: Dec 4, 2016 */

public class Fenetre extends JFrame implements ActionListener{

	JButton affiche = new JButton("Affiche");
	JTextArea area = new JTextArea(10,30);
	JButton afficheC = new JButton("Affiche Comptes");
	JTextArea areaC = new JTextArea(10,30);
	
	// A: JTable changer en JScrollPanes
	JScrollPane tableClients = new JScrollPane();
	JScrollPane tableComptes = new JScrollPane();
	JPanel pnlMain = new JPanel();
	
	Banque banque = new Banque();
		
	public Fenetre() {
		super();
		tableClients = banque.creerTableClients();
		tableComptes = banque.creerTableComptes();
		creerGUI();
		setVisible(true);
	}
	
	public void creerGUI(){
	
		setSize(1000, 1000);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		affiche.addActionListener(this);
		afficheC.addActionListener(this);

		pnlMain.add(affiche);
		pnlMain.add(tableClients);
		pnlMain.add(afficheC);
		pnlMain.add(tableComptes);
		setContentPane(pnlMain);

	}

	public void creerTables(){
		
		pnlMain.add(tableClients);
		pnlMain.add(tableComptes);
		
	}
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()== affiche){
			pnlMain.add(banque.creerTableClients());
		}
		if(e.getSource()== afficheC){
			pnlMain.add(banque.creerTableComptes());
		}

	}

	

}
