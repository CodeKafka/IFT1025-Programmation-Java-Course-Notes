public class JoueurHumain extends Joueur {
	public class JoueurHumain() {
		super();
	}
	
	// Surcharged de la méthode piocherCarte(). Permet de piocher une
	// quantité n de cartes. La pile de carte est mise à jour par la méthode. 
	public void piocherCarte(int n) {
	
	}

	// Permet au joueur d'indiquer la quantité de carte qu'il veut piger.
	// La méthode retourne un entier correspondant à la quantité de 
	// cartes qu'il veut.  
	public int indiquerQuantite() {
		return null;
	}
	
	// Permet au système d'annoncer que le joueur concerné a pris la décision
	// de « Stand » 
	public String annoncerChoixStand() {
		return null;
	}
	
	// Permet au joueur de doubler la mise qu<il a placé pour le tour actuel
	// Cette méthode appelle la méthode piocherCarte() pour permettre
	// au joueur d'obtenir une carte de plus après avoir doublé sa mise. 
	public void doubleDownMise() {
	}
	
	// Permet au joueur d'exécuter l'action d'abandon. Cette méthode appelle
	// la méthode setArgentNet() pour mettre à jour l'argent que le joueur a en
	// poche (déduire attribut mise de l'attribut argentNet.
	public void abandonner() {
	}


	
}
