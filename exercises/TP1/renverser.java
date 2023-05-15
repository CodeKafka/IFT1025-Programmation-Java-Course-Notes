// Écrire une fonction public static int[] renverser(int[] tab) qui 
// contient les mêmes éléments que tab mais en ordre inverse. 
// Le tableau original passé en paramètre ne doit pas être modifié.

public class renverser {
	
	// Cette fonction accepte un tableau d'entiers et retourne
	// un tableau d'entier où les éléments ont été renversé
	public static int[] renverser(int[] tab) {
		
		// On crée un tableau ayant la même taille qu l'original
		int[] reversed = new int[tab.length];
		

		//Le premier élément du tableau (reversed) prend la valeur du dernier élément du tableau
		//original (tab); le dernier élément du tableau prend la valeur du premier élément du tableau
		//original; ainsi de suite. 
		for (int i = 0 ; i <= tab.length/2 ; i++) {
			reversed[i] = tab[tab.length -1 -i];
			reversed[reversed.length -1 -i] = tab[i];
		}
	
	return reversed;

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
