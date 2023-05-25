public class Romain {

	// Cette propriété encapsule la valeur d'une instance de la classe Romain
	private String valeur;

	private int valeurNumerique;

	
	// Cette méthode est le constructeur de classe. Lorsqu'on crée un objet de type Romain,
	// on fournit un entier (n) qui devient alors la valeur numérique (valeurNumerique) 
	// dudit objet. 
	public Romain(int n) {
	this.valeurNumerique = n;
	this.valeur = this.valeur();


	}
	
	// Cette méthode permet d'afficher la valeur d'un objet de type Romain.
	// Elle retourne un String correspondant à la valeur. 
	public String valeur() {
		return romain(this.valeurNumerique);
	}
	
	// Cette méthode additione les valeurs numériques de deux instance de la classe Romain.
	// Elle retourne un entier correspondant à la somme de ces valeurs. 
	public int ajouter(Romain operande2) {
		return this.valeurNumerique + operande2.valeurNumerique;

	}

	// Cette méthode multiplie les valeurs numériques de deux instance de la classe Romain.
	// Elle retourne un entier correspondant au produit de ces valeurs. 
	public int multiplier(Romain operande2) {
		return this.valeurNumerique * operande2.valeurNumerique;

	}


	/**
     *
     * Retourne un texte correspondant à la numération romaine de n, qui doit
     * être un nombre entier entre 1 et 3999
     */
    public static String romain(int n) {

        return chiffre(n, 1000, "M", "?", "?")
                + chiffre(n, 100, "C", "D", "M")
                + chiffre(n, 10, "X", "L", "C")
                + chiffre(n, 1, "I", "V", "X");
    }

    /**
     * Retourne un texte correspondant au chiffre de n de poids puiss10.
     */
    public static String chiffre(int n, int puiss10, String un, String cinq, String dix) {

        // Retourne un texte correspondant au chiffre de n de poids puiss10.
        int c = (int) Math.floor(n / puiss10) % 10;

        if (c < 4) {
            return repeter(c, un);
        } else if (c == 4) {
            return "" + un + cinq;
        } else if (c < 9) {
            return cinq + repeter(c - 5, un);
        } else {
            return "" + un + dix;
        }
    }

    /**
     * Retourne un texte qui contient n répétitions du texte sujet (par exemple
     * repeter(3,"I") retourne "III").
     */
    public static String repeter(int n, String sujet) {

        // Retourne un texte qui contient n répétitions du texte sujet
        // (par exemple repeter(3,"I") retourne "III").
        String accum = "";

        for (int i = n; i > 0; i--) {
            accum += sujet;
        }

        return accum;
    }	

	public static void main(String[] args) {
        Romain dix = new Romain(10);
        Romain cinq = new Romain(5);
        
        System.out.println(dix.valeur);
        System.out.println(cinq.valeur);
		System.out.println(dix.ajouter(cinq));
		System.out.println(dix.multiplier(cinq));
    }
	
}













