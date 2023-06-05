

/**
 * Classe représentant un object mathématique (vecteur).
 * @author : Franz Girardin
 * Date : 2023-05-30 
 */
public class Vecteur {
	
	private double[] valeurs; 

	public double[] getValeurs() {
		return this.valeurs;
	}

	/**
	 * Permet de construire un objet de type Vecteur
	 * @param elements : valeurs du vecteur enregistrées dans un tableau
	 * de double
	 */
	public Vecteur(double[] elements) {
		this.valeurs = elements;	
	}
	
	public void setElement(int index, double valeur) {
	this.getValeurs()[index] = valeur;
	

	}

	/**
	 * Retourne la valeur à l'index demandé
	 * @param index
	 */
	public double getElement(int index) {
	return this.valeurs[index];
	}
	/**
	 * Permet d'afficher le contenu d'un objet de type Vecteur
	 * l'affichage est formatté de sorte à ce que les valeurs soient
	 * séparées par une virgule suivit d'un espace. Le tout est contenu 
	 * entre des acollades ('{' et '}'). 
	 *   
	 */
	
	/**
	 * Permet de calculer le produit scalaire avec un autre {@link Vecteur}
	 * @param v
	 *
	 *
	 */
	public double dotProduct(Vecteur v) {
		double output = 0.0;
		double[] tab = this.getValeurs();

		if (v.getValeurs().length == tab.length) {
			for (int i = 0; i < tab.length; i++) {
				output += tab[i] * v.getElement(i);
			}
			return output;
		}

		else {
		    System.err.println("Erreur dans les dimensions des vecteurs");
		    return Double.NaN;	
		}

	}

	public void afficher() {
		String outputString = "{";
		double[] tab = this.getValeurs();
		
		for (int i=0; i < tab.length ; i++) {
			outputString += tab[i];

			// ajoute une virgule et un espace après la valeur tant qu'on pas à la fin de l'array
			if (i < tab.length -1) {
			    outputString += ", ";
			}

		}
		outputString += "}";

	System.out.println(outputString);

	}
}



