package ca.qc.collegeahuntsic;

import java.util.Comparator;

/* ClientParCompte.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class ClientParCompte implements Comparator<Client> {

	public int compare(Client cl0, Client cl1) {
		
		String num0 = cl0.getId();
		String num1 = cl1.getId();
		
		return num0.compareTo(num1);
	}
}
