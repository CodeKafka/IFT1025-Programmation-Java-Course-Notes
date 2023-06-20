/**
 * @author: Franz Girardin 
 * Cette classe permet de gérérer des objets de type Carte
 * Un objet Carte représente une carte à jouer du jeu
 * BlackJack. Chaque objet Carte a une valeur allant de 1 à 11, 
 * ainsi qu'un nom permettant d'identifier la carte. 
 *
 *
 *
 */

public class Carte {

	private int val;
	private String nom;

	public Carte(String identiteCarte, int valeurCarte) {
		this.val = valeurCarte;
		this.nom = identiteCarte;
	}
	
	// Pour obtenir la valeur de la carte 
	public int getVal() {
		return this.val;	
	}
	
	// Pour obtenir l'idendité (nom) de la carte
	public String getNom() {
		return this.nom;
	}
}
