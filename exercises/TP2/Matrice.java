/**
 * Classe représentant un object mathématique (matrice).
 * @author : Franz Girardin
 * Date : 2023-05-30 
 */
public class Matrice {
	private int rangees ;
	private int colonnes ;
	
	 /**
	 * Permet d'accéder au nombre de rangées de la matrice (representation)
	 * d'un objet de type Matrice.
	 * 
	 */

	public int getRangees(){
	    return this.rangees;
	}
	
	/**
	 * Permet d'accéder au nombre de colonnes de la matrice (representation)
	 * d'un objet de type Matrice.
	 * 
	 */
	public int getColonnes() {
	    return this.colonnes;
	
	}
	private double[][] representation = new double[rangees][colonnes];
	

	/**
	 * Permet d'accéder à la matrice (la representation)
	 * d'un objewt de type Matrice.
	 * 
	 */
	public double[][] getRepresentation() {
		return this.representation;
	}
	
	public Vecteur getLine(int ligne) {
		Vecteur vecteurLigne = new Vecteur(this.getRepresentation()[ligne]);
	return vecteurLigne;

	}

	public Vecteur getCol(int col) {
		double[] tab = new double[this.getColonnes()];
		for (int i = 0; i < this.getColonnes(); i++) {
			tab[i] = this.getRepresentation()[i][col];
		}
		
		Vecteur vecteurColonne = new Vecteur(tab);
	return vecteurColonne;

	}

	public double getCell(int ligne, int col) {
	return this.representation[ligne][col];
	}

	public void setCell(int ligne, int col, double valeur) {
	this.getRepresentation()[ligne][col] = valeur;
	}

	public void additionnerScalaire(double n) {
	    for (int i = 0; i < this.getRangees() ; i++) {
	        for (int j = 0; j < this.getColonnes(); j++) {
		    this.getRepresentation()[i][j]+= n; 
		}
	    }
	}

	public void multiplierScalaire(double n) {
	    for (int i = 0; i < this.getRangees() ; i++) {
		for (int j = 0; j < this.getColonnes(); j++) {
		    this.getRepresentation()[i][j]*= n; 
		}
	    }
	}

	public Matrice dotProduct(Matrice m) {
    int m1Rows = this.getRangees();
    int m1Cols = this.getColonnes();
    int m2Rows = m.getRangees();
    int m2Cols = m.getColonnes();

    if (m1Cols != m2Rows) {
        System.err.println("Error: Incompatible matrix dimensions for matrix multiplication");
        return null;
    }

    Matrice result = new Matrice(m1Rows, m2Cols);

    for (int i = 0; i < m1Rows; i++) {
        for (int j = 0; j < m2Cols; j++) {
            double sum = 0.0;
            for (int k = 0; k < m1Cols; k++) {
                sum += this.getCell(i, k) * m.getCell(k, j);
            }
            result.setCell(i, j, sum);
        }
    }

    return result;
}
	


	/*public Matrice dotProduct(Matrice m) {
        // Vérifie si les matrices sont compatibles pour la multiplication
            if (this.getColonnes() != m.getRangees()) {
		System.err.println("Erreur dans les dimensions des matrices");
		return null;  // Return null to indicate failure
	    }

	    // Crée un objet de type Matrice pour enregistrer le résultat de la muliplication
	    int outputRangees = this.getRangees();
	    int outputColonnes = m.getColonnes();
	    Matrice mOutput = new Matrice(outputRangees, outputColonnes);

	    // Effectue l'opération de produit matriciel
	    for (int i = 0; i < outputRangees; i++) {
	        for (int j = 0; j < outputColonnes; j++) {
                    // Va chercher la i-ème rangée de la première matrice (this) et la j-ème colonne de la 
		    // second matrice (m) 
		    Vecteur rowVector = this.getLine(i);
		    Vecteur colVector = m.getCol(j);

		    // Calcule le produit vectoriel via la méthode du type Vecteur 
		    double dotProduct = rowVector.dotProduct(colVector);

		    // Enregistre la valeur obtenue dans la matrice résultante (mOutput)
		    mOutput.setCell(i, j, dotProduct);
	        }
	    }

	return mOutput;  
	}
	*/

	/**
	 * Permet de construire un objet de type Matrice 
	 * @param lignes : correspond aux rangées de la matrice
	 * @param cols : correspond aux colonnes de la matrices
	 *
	 */
	public Matrice (int lignes, int cols) {
		this.rangees = lignes;
		this.colonnes = cols;
		this.representation = new double[rangees][colonnes];

	    for (int i = 0; i < lignes; i++) {
		for (int j = 0; j < cols; j++) {
		    this.representation[i][j] = 0.0;
		}
	    }

	}
	
	/**
	 * Permet d'affiche sur la console la matrice (representation)
	 * d'un objet de type Matrice.
	 * 
	 */
	public void afficher() {
		for (int i = 0; i < this.getRangees() ; i++) {
			System.out.print("[ ");
			for (int j = 0; j < this.getColonnes(); j++) {
				System.out.print(this.getRepresentation()[i][j] + " ");
		}
		System.out.println("]");
	    }

	}

}
