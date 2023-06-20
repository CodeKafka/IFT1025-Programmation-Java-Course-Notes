public class Polynome {
    private Terme premierTerme;
    private Terme dernierTerme; 

    private Terme constanteDuPolynome;
    //====================================================================================================
    public Terme getPremierTerme(){
        return this.premierTerme;
    }
    public Terme getDernierterme() {
        return this.dernierTerme;
    }
    public Terme getConstantePolynôme() {
        return this.constanteDuPolynome;
    }

    //====================================================================================================
    // Permet d'obtenir un format adéquat pour l'affiche d'une valeur décimale
    public String affichageDecimale(double aEvaluer) {
        String resultat = "";

        if (aEvaluer % 1.0 == 0.0) {
            return ((int) aEvaluer + resultat);
        }
    return resultat; 
    }
    //====================================================================================================
    /**
     *  @Override Modification de la fonction toString() afin d'afficher les termes
     *  d'un Polynôme adéquatement. L'algorithme pour l'affichage prend compte de cas
     *  particuliers où il n'y a qu'un constante à afficher et de celui où il n'y a qu'un polynomial 
     *  à afficher
     */
    public String toString() {
        String stringFinal = "";
        // Cas 1 Polynôme ne contient aucun terme
        if (this.premierTerme == null) {
            return null;
        }
        // Cas 2 Polynôme contient un seul terme.
        else if (this.size() == 1) {
            // Situation 2.1 Polynôme contient seulement une constante. 
            if (this.premierTerme.getExposantT() == 0) {
                stringFinal += affichageDecimale(this.premierTerme.getCoeffT());
            }
            // Situation 2.2 Polynôme contient seulement un polynomial x^1
            else if (this.premierTerme.getExposantT() == 1) {
                stringFinal += affichageDecimale(this.premierTerme.getCoeffT()) + "x";
            }
            // Situation 2.3 Polynôme contient un polynomial autre que x^1.
            else {
                stringFinal += affichageDecimale(this.premierTerme.getCoeffT()) + "x^" + this.premierTerme.getExposantT();
            }
        }
        
        // Cas 3 Polynôme contient plusieurs termes
        else{
            Terme aImprimmer = this.premierTerme;
            while(aImprimmer != null) {
                
                // 3.1 : On est à la fin de la chaîne et le dernier terme est une constante telle que le terme à imprimmer
                if (aImprimmer.getExposantT() == this.dernierTerme.getExposantT() && aImprimmer.getExposantT() == 0) {
                    stringFinal += affichageDecimale(aImprimmer.getCoeffT());
       
                }
                // 3.2 : On est à la fin de la chaîne et le terme à imprimmer est un polynomial de degré 1
                else if (aImprimmer.getExposantT() == this.dernierTerme.getExposantT() && aImprimmer.getExposantT() == 1) {
                    stringFinal += affichageDecimale(aImprimmer.getCoeffT()) + "x"; 
                }
                // 3.3 : On est à la fin de la chaîne et le terme à imprimmer un polynomial de degré > 1 
                else if (aImprimmer.getExposantT() == this.dernierTerme.getExposantT() && aImprimmer.getExposantT() > 1) {
                    stringFinal += affichageDecimale(aImprimmer.getCoeffT()) + "x^" + aImprimmer.getExposantT();
                }
                
                // 3.4 : On au milieu de la chaîne et le terme à imprimmer est un polynomial de degré 1
                else if (aImprimmer.getExposantT() != this.dernierTerme.getExposantT() && aImprimmer.getExposantT() == 1) { 
                    stringFinal += affichageDecimale(aImprimmer.getCoeffT()) + "x" + " + ";
                }
                // 3.5 : On est au milieu de la chaîne et le terme à imprimmer est un polynomial de degré > 1
                else {
                    stringFinal += affichageDecimale(aImprimmer.getCoeffT()) + "x^" + aImprimmer.getExposantT() + " + ";
                }
                aImprimmer = aImprimmer.suivantT;
            }
        }
        
        return stringFinal;
    }
    //====================================================================================================
    /** Permet de déterminer la quantité de termes présents dans le polynôme en parcourant la liste chaînée
     *  Note : cette méthode est copiée des notes de cours « Structure de données » et apparaît
     *  à la diapositive 50. 
     */
    public int size() {
        int size = 0;
        Terme t = this.premierTerme;
        while(t != null) {
            size++;
            t = t.suivantT;
        }
        return size;
    }
    //====================================================================================================
    /**
     * Additionne un terme cx^e au polynome.
     *
     * @param coeff coefficient c du terme à ajouter
     * @param exposant exposant e du terme à ajouter
     */
    public void ajouter(double coeff, int exposant) {
        Terme termeAAjouter = new Terme(coeff, exposant, null, null);
        /**
         *  Cas no. 1 : Le Polynôme actuel (this) ne contient aucun terme, on ajoute alors
         *  le termeAAjouter au polynôme en indiquant qu'il s'agit du premier terme
         *  (this.premierTerme = termeAAjouter). Si le terme à ajouter est une constante,
         *  On met à jour la valeur de l'attribut consteDuPolynome. 
         */
        if (this.premierTerme == null) {
            this.premierTerme = termeAAjouter;
            this.dernierTerme = termeAAjouter;

            if (exposant == 0) {
                this.constanteDuPolynome = termeAAjouter;
            }
        }
        //-----------------------------------------------------------------------------------------------
        /** Cas no.2 : Le polynôme contient uniquement un terme, soit une constante ou un polynomial
         * dont l'exposant a la même valeur que celle du terme à ajouter.
         *  On met à jour le coefficient du terme.
         */ 
        else if (this.size() == 1 && exposant == this.premierTerme.getExposantT()) {

            this.premierTerme.ajouteCoefficient(coeff);
            
            if (exposant == 0) {
                this.constanteDuPolynome = this.premierTerme;
            }
        }
        //-----------------------------------------------------------------------------------------------
        /** Cas no. 3 : Le polynôme contient uniquement un terme, soit une constante ou un polynormial
         * dont la valeur de son exposant est plus grand que celle du terme à ajouter. 
         * On ajouter le terme à la fin de la liste
         */
        else if (this.size() == 1 && exposant < this.premierTerme.getExposantT()) {
            this.premierTerme.suivantT = new Terme(coeff, exposant, null, this.premierTerme);
            this.dernierTerme = this.premierTerme.suivantT;
        
        }
        //-----------------------------------------------------------------------------------------------
        /** Cas no. 4 : le terme à ajouter a un exposant plus grand que tous les autres termes du polynôme 
         *  On insère le terme à ajouter au début de la liste. 
         */
        else if (exposant > this.premierTerme.getExposantT()) {
            Terme nouveauPremier = new Terme(coeff, exposant, this.premierTerme, null);
            
            this.premierTerme.precedentT = nouveauPremier;
            this.premierTerme = nouveauPremier;
        
        }
        //-----------------------------------------------------------------------------------------------
        /** Cas no. 5 : le terme à ajouter a un exposant aussi grand que l'exposant le plus grand
         *  du polynôme courant. On met à jour le coefficient du premier terme. 
         */
        else if (this.size() >= 1 && exposant == this.premierTerme.getExposantT()) {
            this.premierTerme.ajouteCoefficient(coeff);
        
        }
        //-----------------------------------------------------------------------------------------------
        /** Cas no. 6: Le polynôme contient plus d'un terme et le terme à ajouter a un exposant
         * plus petit que celui de tous les autres termes de la liste. 

         * Il peut s'agit d'une constante ou d'un polynomial. 
         * On insère le terme à la fin de la liste et met à jour la valeur du dernier terme
         */
        else if (this.size() > 1 && exposant < this.dernierTerme.getExposantT()) {
            Terme nouveauDernier = new Terme(coeff, exposant, null, this.dernierTerme);
            this.dernierTerme.suivantT = nouveauDernier;
            this.dernierTerme = nouveauDernier;
        }
        /** Cas no. 8: Le polynôme contient plus d'un terme et le terme à ajouter a un exposant 
         *  équivalent à l'exposant du plus petit terme du polynôme

         *  On met à jour le coefficient du dernier terme
         */
        else if (this.size() > 1 && exposant == this.dernierTerme.getExposantT()) {
            Terme dummyDernier = new Terme(coeff, exposant, null, null);
            this.dernierTerme.ajouteCoefficient(dummyDernier.getCoeffT());

        }
        //-----------------------------------------------------------------------------------------------
        /** Cas no. 7: Le polynôme contient plus d'un terme et le terme à ajouter est un polynomial
         *  On insère le terme à l'endroit approprié
         */
        else {
            Terme trackerThis = this.premierTerme;
            while (trackerThis != null) {
                // Situation 7.1 : on ajoute un terme déjà présent; on met à jour le coefficient. 
                if (trackerThis.getExposantT() == exposant) {
                    trackerThis.ajouteCoefficient(coeff);
                    break; 
                }
                // Situation 7.2 : on insère un terme entre deux termes.
                else if (trackerThis.suivantT != null && exposant > trackerThis.suivantT.getExposantT()) {

                    trackerThis.suivantT.precedentT = termeAAjouter;
                    termeAAjouter.suivantT = trackerThis.suivantT;
                    termeAAjouter.precedentT = trackerThis;

                    trackerThis.suivantT = termeAAjouter;
                    break;
                } 
            trackerThis = trackerThis.suivantT;    
            }   
        }
        //-----------------------------------------------------------------------------------------------

    }
    //====================================================================================================
    /**
     * Addition d'un polynome par un autre. Cette fonction ne
     * modifie pas le polynome actuel.
     *
     * @param autre le polynome à additionner
     * @return un nouveau polynome contenant le résultat de
     * l'addition
     */
    public Polynome additionner(Polynome autre) {
        Polynome resultat = new Polynome();
        
        Terme trackerThis = this.premierTerme;
        // Iterate through the current polynomial
        while (trackerThis != null) {
            resultat.ajouter(trackerThis.getCoeffT(), trackerThis.getExposantT()); 
            trackerThis = trackerThis.suivantT;
        }
        
        Terme trackerAutre = autre.premierTerme;
        while (trackerAutre != null) {
            resultat.ajouter(trackerAutre.getCoeffT(), trackerAutre.getExposantT());
            trackerAutre = trackerAutre.suivantT;
        }
    return resultat; 

    }
    //====================================================================================================
	
    /**
     * Multiplication par une constante. Cette fonction ne modifie pas
     * le polynome actuel.
     *
     * @param c constante multiplicative
     * @return un nouveau polynome correspondant au polynome actuel
     * (this) multiplié par une constante
     */
    public Polynome multiplier(double c) {
        Polynome resultat = new Polynome();
        // ...

        return resultat;
    }
    //====================================================================================================
    /**
     *  Permet de calculer le produit entre deux termes.
     *  Les coefficients sont multipliés et les exposants sont additionnés
     *  @param t1 terme à multipler 
     *  @param t2 Idem
     *
     *  @param lienSuivant réfère au Terme suivant auquel on veut lier le terme actuel
     *  @param lienPrecedent réfère au Terme précédent auquel on veut lier le terme actuel
     *  @return resultat correspondant à la multiplication
     */
    public Terme generateTermeProduct(Terme t1, Terme t2) {
        
        double coeffResultat = t1.getCoeffT() * t2.getCoeffT(); 
        int exposantResultat = t1.getExposantT() + t2.getExposantT();
        
        Terme resultat = new Terme(coeffResultat, exposantResultat, null, null);
        return resultat;

    }
    //====================================================================================================
    /**
     * Multiplication d'un polynome par un autre. Cette fonction ne
     * modifie pas le polynome actuel.
     *
     * @param autre le polynome à multiplier
     * @return un nouveau polynome contenant le résultat de la
     * multiplication
     */
    public Polynome multiplier(Polynome autre) {
    Polynome resultat = new Polynome();

    if (this.premierTerme == null || autre.premierTerme == null) {
        return resultat;
    }

    Terme trackerAutre = autre.premierTerme;

    // Iterate through the multiplier polynomial
    while (trackerAutre != null) {
        Terme trackerThis = this.premierTerme;

        // Iterate through the current polynomial
        while (trackerThis != null) {
            Terme nouveauTerme = generateTermeProduct(trackerThis, trackerAutre);
            resultat.ajouter(nouveauTerme.getCoeffT(), nouveauTerme.getExposantT()); // Add the new term to the resulting polynomial
            trackerThis = trackerThis.suivantT;
        }

        trackerAutre = trackerAutre.suivantT;
    }

    return resultat;
    }

    //====================================================================================================
    /**
     * Retourne la dérivée sous la forme d'un nouveau polynome. Cette
     * fonction ne modifie pas le polynome actuel.
     *
     * @return la dérivée du polynome actuel sous la forme d'un
     * nouveau polynome
     */
    public Polynome derivee() {
        Polynome derivee = new Polynome();

        // ...

        return derivee;
    }
    //====================================================================================================
    /**
     * Fonction utilitaire pour tester la classe.
     *
     * @param test résultat du test unitaire
     * @param message description du test
     */
    public static void assertTest(boolean test, String message) {
        if(test) {
            System.out.println("OK: " + message);
        } else {
            System.out.println("ERREUR: " + message);
        }
    }
    //====================================================================================================
    /**
     * À compléter : quelques tests pour vous aider
     */
    public static void main(String[] args) {

        Polynome p = new Polynome();
        Polynome q = new Polynome();

        System.out.println("-------------------- On teste la fonction ajouter()--------------------");
        p = new Polynome();
        p.ajouter(10, 0);
        System.out.println("On appelle p.ajotuer(10,0) — cas 1 de la méthode ");
        assertTest(p.toString().equals("10"), "Un seul terme (constante)");
        System.out.println("p = " + p +"\n");

        p.ajouter(20, 0);
        System.out.println("On appelle p.ajotuer(20,0) — cas 2 de la méthode ");
        assertTest(p.toString().equals("30"), "Un seul terme (constante)");
        System.out.println("p = " + p +"\n");

        p = new Polynome();
        p.ajouter(40,2);
        p.ajouter(40,1);
        System.out.println("On réinitialise p, on appelle p.ajouter(40,2), puis p.ajouter(40,1) — cas 3 de la méthode ");
        assertTest(p.toString().equals("40x^2 + 40x"), "Deux termes; 40x inséré après 40x^2");
        System.out.println("p = " + p + "\n");


        p.ajouter(40, 3);
        System.out.println("On appelle p.ajotuer(40,3) — cas 4 de la méthode ");
        assertTest(p.toString().equals("40x^3 + 40x^2 + 40x"), "Trois termes; 40x^3 inséré au début de la liste");
        System.out.println("p = " + p +"\n");

        p.ajouter(40, 3);
        System.out.println("On appelle p.ajotuer(40,3) — cas 5 de la méthode ");
        assertTest(p.toString().equals("80x^3 + 40x^2 + 40x"), "Trois termes; coefficient du premier terme mis à jour");
        System.out.println("p = " + p +"\n");

        p.ajouter(40, 0);
        System.out.println("On appelle p.ajotuer(40,0) — cas 6 de la méthode ");
        assertTest(p.toString().equals("80x^3 + 40x^2 + 40x + 40"), "Quatre termes; la constante est insérée à la fin de la liste");
        System.out.println("p = " + p +"\n");

        p.ajouter(40, 6);
        p.ajouter(40, 5);
        System.out.println("On appelle p.ajotuer(40,6), puise p.ajouter(40,5) — cas 6 de la méthode ");
        assertTest(p.toString().equals("40x^6 + 40x^5 + 80x^3 + 40x^2 + 40x + 40"), "Six terme 40x^5 inséré entre 40x^6 et 80x^3");
        System.out.println("p = " + p +"\n");


        System.out.println("-------------------- Tests ajouter() du prof--------------------");
        p = new Polynome();
        p.ajouter(10, 0);
        assertTest(p.toString().equals("10"), "Un seul terme (constante)");

        p = new Polynome();
        p.ajouter(10, 1);
        assertTest(p.toString().equals("10x"), "Un seul terme (exposant=1)");

        p = new Polynome();
        p.ajouter(10, 2);
        assertTest(p.toString().equals("10x^2"), "Un seul terme (exposant=2)");

        p.ajouter(5, 4);
        assertTest(p.toString().equals("5x^4 + 10x^2"), "Deux termes");
        System.out.println(p);

        p.ajouter(3, 2);
        assertTest(p.toString().equals("5x^4 + 13x^2"), "Ajouter à un terme déjà présent");

        p.ajouter(7, 0);
        assertTest(p.toString().equals("5x^4 + 13x^2 + 7"), "Ajouter une constante");

        p.ajouter(-22, 3);
        assertTest(p.toString().equals("5x^4 + -22x^3 + 13x^2 + 7"), "Ajouter un coefficient négatif");







        System.out.println("-------------------- On teste la fonction multiplier()--------------------");
        p = new Polynome();
        System.out.println("On réinitialise p, on appelle p.ajouter(10, 2) et p.ajouter(5, 4), puis on appelle la fonction p.multiplier(p));");
        p.ajouter(10, 2); p.ajouter(5, 4); System.out.println("p = " + p);
        assertTest(p.multiplier(p).toString().equals("25x^8 + 100x^6 + 100x^4"), "l'équivalent de (a+b)^2 = a^2 +2ab + b^2");
        System.out.println("multiplication de p par p = " + p.multiplier(p) + "\n");
        
        System.out.println("-------------------- On teste la fonction additionner()--------------------");
        p = new Polynome();
        System.out.println("On réinitialise p, on appelle p.ajouter(10, 2) et p.ajouter(5, 4), puis on appelle la fonction p.additionner(p));");
        p.ajouter(10, 2); p.ajouter(5, 4); System.out.println("p = " + p);
        assertTest(p.additionner(p).toString().equals("10x^4 + 20x^2"), "le polynôme est additionné à lui-même");
        System.out.println("addition de p par p = " + p.additionner(p)+"\n");

        q = new Polynome();
        System.out.println("On initialise q et appelle q.ajouter(10,2), q.ajouter(25,6), q.ajouter(30,3), q.ajouter(10,0)\n");
        q.ajouter(10,2); q.ajouter(25,6); q.ajouter(30,3); q.ajouter(10,0);
        
        System.out.println("On apelle ensuite q.additionner(p)");
        assertTest(q.additionner(p).toString().equals("25x^6 + 5x^4 + 30x^3 + 20x^2 + 10"),"addition de q et p");
        System.out.println(q.additionner(p));

        


        



        

        //
        // Polynome derivee = p.derivee();
        // assertTest(derivee.toString().equals("20x^3 + -66x^2 + 26x"), "Dérivée");
        //
        // derivee = p.derivee().derivee().derivee().derivee();
        // assertTest(derivee.toString().equals("120"), "Dérivée 4 fois");
        //
        // derivee = p.derivee().derivee().derivee().derivee().derivee()
        //            .derivee().derivee().derivee().derivee().derivee();
        // assertTest(derivee.toString().equals("0"), "Dérivée 10 fois");

        // TODO : écrire d'autres tests
    }
}
