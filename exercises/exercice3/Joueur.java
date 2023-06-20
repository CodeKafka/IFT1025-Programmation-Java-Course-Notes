/**
 * @author: Franz Girardin
 * Cette classe permet de gérer des objet de type
 * Joueur. Un objet de type Joueur représente un
 * joueur du Jeu de BlackJack. 
 * 
 *
 *
 *
 */
public class Joueur {
	String nomJoeur;

	private int mise; private int argentNet;
	private int scoreManche;
	private boolean hasBlackJack = false;
	private Carte[] cartensEnMain;
	
	/**
	 * Constructeur de classe Joeur. Cette méthode
	 * intialise la mise du joueur au nombre passé
	 * en argument du constructeur. Le tableau carteEnMain
	 * est initialisé à une taille de 2 éléments. 
	 *
	 */
	public Joueur(int miseInitiale) {
		this.mise = miseInitiale;
		this.cartensEnMain = new Carte[2];
		
	}

	// Pour obtenir le nombre correspondant à la mise du joueur
	public int getmiseJoueur() {
		return this.mise;
	}

	// Obtenir l'argent total du joueur
	public int getArgentNet() {
		return this.argentNet;
	}

	// Permet de mettre à jour la somme que le joueur a en poche
	public void setArgentNet() {
	
	}

	// Obtenir le score du joueur pour la manche actuelle
	public int getScoreManche() {
		return this.scoreManche;
	}
	// Déterminer si le joueur est dans une situation BlackJack pour la manche actuelle
	public boolean getHasBlackJack() {
		return this.hasBlackJack;
	}
	// Déterminer les cartes que le joueur possède 
	public Carte[] getCartesEnMain() {
		return this.cartensEnMain;
	}
	
	// se sert de la méthode gertCartesEnMain pour afficher 
	// sur la console le contenu du tableau Carte[] représentant
	// les cartes que le joueur possède 
	public String afficherCarteEnmain(Carte[] listeCartes){
		return null;	
		
	}
}
