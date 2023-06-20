public class Terme { 
    // enregistre la valeur du coefficient du terme courant
    private double coeffT; 
    // enregistre la valeur de la puissance du terme courant
    private int exposantT;
    // permet de référer au prochain terme du polynôme
    public Terme suivantT;

    public Terme precedentT;
    
    // accesseurs pour les valeurs de coefficient et d'exposant
    public double getCoeffT() {
        return this.coeffT;
    }
    public int getExposantT() {
        return this.exposantT;
    }
    public Terme getSuivantT() {
        return this.suivantT;
    }
    public Terme getPrecedentT() {
        return this.precedentT;
    }
    public void setCoeffT(double coeffT) {
        this.coeffT = coeffT;
    }
    public void setExposantT(int exposantT) {
        this.exposantT = exposantT;
    }
    /** 
     * constructeur de classe permettant de générer un objet de type terme 
     * @param coeff coefficient du terme qu'on veut créer
     * @param exposant exposant tu terme qu'on veut créer
     * @param suivant référence vers le terme suivant du polynôme 
     * 
     */
    public Terme(double coeff, int exposant, Terme suivant, Terme precedent) {
        this.coeffT = coeff;
        this.exposantT = exposant;
        this.suivantT = suivant;
        this.precedentT = precedent;

        if (suivant != null) {
        suivant.precedentT = this; // Assign the current term as the precedent of the next term
        }
    }
    
    /**
     * permet d'ajouter une valeur donnée au coefficient du Terme courant
     * @param aadditionner la valeur du coefficient du terme auquel on veut additionner 
     * le coefficient présent.
     */
    public void ajouteCoefficient(double aadditionner) {
        this.coeffT += aadditionner;
    }
    public void multiplierCoefficient(double aMultiplier) {
        this.coeffT *= aMultiplier;
    }

    /**
      * Permet de calculer le produit de deux coefficient
      * @param aMultiplier la valeur du coefficient du terme auquel on veut multiplier
      * le coefficient présent
      */
    public double getProductCoefficients(double aMultiplier) {
        return this.coeffT * aMultiplier;
    }
    public void derivationPolynomiale() {
        this.coeffT = (this.coeffT * this.getExposantT());
        this.exposantT = this.exposantT - 1; 
    
    }

}
