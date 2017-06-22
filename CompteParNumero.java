package ca.qc.collegeahuntsic;

import java.util.Comparator;

/* ClientParCompte.java
 * Auteur: Alexander Pawinski
 * Crée le: Nov 28, 2016 */

public class CompteParNumero implements Comparator<Compte> {

	public int compare(Compte c1, Compte c2) {
		
		String num1 = c1.getNumero();
		String num2 = c2.getNumero();
		
		return num1.compareTo(num2);
	}
}
