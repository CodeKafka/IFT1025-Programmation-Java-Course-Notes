// Écrire une fonction public static int[] renverser(int[] tab) qui 
// Qui inverse (donc modifie) le contenu du tableau tab "in place",
// sans allouer plus de mémoire

public class renvAlt {
	
	// Cette fonction accepte un tableau d'entiers et retourne
	// un tableau d'entier où les éléments ont été renversé
	public static int[] renverser(int[] tab) {
		
		//Le premier élément du tableau (reversed) prend la valeur du dernier élément du tableau
		//original (tab); le dernier élément du tableau prend la valeur du premier élément du tableau
		//original; ainsi de suite. 
		//La variable temporaire enregistre la valeur du dernier élément du tableau original.
		for (int i = 0 ; i < tab.length/2 ; i++) {
			int temp = tab[tab.length -i -1];
			tab[tab.length -i -1] = tab[i];
			tab[i] = temp;
		}
	
	return tab;

	}

	public static void main(String[] args) {

		// On cree le tableau original affiche son contenu
		int[] tabOri = {1,2,3,4,5};
		System.out.println("Tableau original :");
		for (int i = 0 ; i < tabOri.length ; i++)
			System.out.println(tabOri[i]);
		
		// On crée le tableau renversé et affiche son contenu 
		int[] rev = renverser(tabOri);
		System.out.println("Tableau renversé : ");
		for (int i = 0 ; i < rev.length ; i++)
			System.out.println(rev[i]);
 	
	}





}
