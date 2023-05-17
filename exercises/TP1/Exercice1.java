import java.util.Scanner;

public class Exercice1 {
	//=========================================================================================	
    /**
     * Cette fonction prend un tableau de Strings en paramètre et retourne un
     * nouveau tableau contenant les mêmes éléments, avec une case disponible de
     * plus.
     */
    public static String[] agrandirTab(String[] tab) {

		// On crée un tableau pouvant accepter un élément de plus que tab
		String[] tabExtd = new String[tab.length+1];
	
		// On ajoute tous les éléments du tableau original au nouveau tableau
		for (int i = 0 ; i < tab.length ; i++) {
			tabExtd[i] = tab[i];

		}
	return tabExtd; 
    }

	//=========================================================================================	
    /**
     * Cette fonction lit des mots sur la ligne de commande et les retourne dans
     * un tableau de Strings. Chaque "mot" est définit comme une ligne complète,
     * du début de la ligne entrée jusqu'au prochain \n.
     */
	 public static String[] lireMots() {
	//-----------------------------------------------------------------------------------------	
	/** On crée une boucle infinie qui permet d'enregistrer les données entrées en ligne
	 *  de commande dans le tableau. La boucle s'arrête lorsque l'utilisateur écrit
	 *  "stop" (sans discriminer pour les majuscules).
	 */
	//-----------------------------------------------------------------------------------------	
		Scanner scan = new Scanner(System.in);
		String[] motsLus = new String[0];	
			while (true) {
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("Stop")) {
					break;
				}
			motsLus = agrandirTab(motsLus);
			// On ajoute le mots écrit pas user à la fin du tableau.
			motsLus[motsLus.length-1] = input;
			

			}
	return motsLus;
    }
	
	//=========================================================================================	
    /**
     * Cette fonction prend en paramètre un tableau de mots et retourne un
     * nouveau tableau contenant ces mots triés en ordre croissant.
     */
    public static String[] trier(String[] mots) {
	String temp;

	
	// On itère à travers le tableau de mots en comparant chaque mot au mot suivant.
		for (int i = 0 ; i < mots.length -1 ; i++) {
			for (int j = i + 1 ; j < mots.length ; j++) {
				if (mots[i].compareToIgnoreCase(mots[j]) > 0) {
					temp = mots[i];
					mots[i] = mots[j];
					mots[j] = temp;
				}

			}

		}

    return mots;
    }
	
	//=========================================================================================	  
	/** 
	 * Cette fonction prend en paramètre un tableau de mots trié et retourne un
     * nouveau tableau où chaque mot est unique (tous les doublons sont
     * retirés).
     */
    public static String[] retirerDoublons(String[] mots) {
		// On compte le nombre de mots distincts dans le tableau
		int nbMotsDistincts = 0;
	//-----------------------------------------------------------------------------------------
	/** 
	 * On itère sur la longeur du tableau de mots; on compare chaque mot (mots[i])
	 * à ses sucesseurs (mots[j]). Dès qu'on trouve au moins un sucesseur identique;
	 * on conclut que le mot est dupliqué et on passe à la comparaison du mot suivant.
	 * Si le mots n'est identique à aucun de ses sucesseurs; on conclut qu'il est unique
	 * et incrémente le nombre de mot distinct (nbMotsDisctincts++). */
	//-----------------------------------------------------------------------------------------	
		for (int i = 0; i < mots.length; i++) {
			boolean estDuplique = false;
			for (int j = 0; j < i; j++) {
				if (mots[i].equalsIgnoreCase(mots[j])) {
					estDuplique = true;
						break;
				}

			}

			if (!estDuplique) {
            nbMotsDistincts++;
			
			}

		}
    
		// On crée un nouveau tableau de la bonne taille
		String[] motsDistincts = new String[nbMotsDistincts];

		int index = 0; // Pour savoir où ajoute un mot unique dans le tab. "motsDistincts"
	//-----------------------------------------------------------------------------------------	
		/* On utilise le même algorithme de comparaison. Cette fois, lorsqu'un mot est unique,
		 * on l'ajoute au tab. "motsDistincts". S'il est dupliqué, on continue à itérer sur i
		 * pour trouver le prochain mot unique. */
	//-----------------------------------------------------------------------------------------	
		for (int i = 0; i < mots.length; i++) {
			boolean estDuplique = false;
			for (int j = 0; j < i; j++) {
				if (mots[i].equalsIgnoreCase(mots[j])) {
					estDuplique = true;
					break;
				}

			}

			if (!estDuplique) {
				motsDistincts[index] = mots[i];
				index++;
			}

		}
    
    return motsDistincts;

    }
	
	//=========================================================================================
    /**
     * Fonction principale du programme (utilisée pour tester le code).
     */
    public static void main(String[] args) {
	System.out.println("# Entrée au clavier :");	
		String[] Help = retirerDoublons(trier(lireMots()));
	

	System.out.println("# Affichage du programme :");
		for (int i = 0; i < Help.length ; i++) {
		System.out.println(Help[i]);
		
		}

	}

}
	

