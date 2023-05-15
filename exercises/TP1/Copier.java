// Le programme suivant est supposé copier en mémoire un tableau de
// double et modifier la première case du tableau copié. Mais
// le réultat obtenu n'est pas le résultat désiré. Corriger le bug. 

// Fichier: Copier.java:

public class Copier {
    public static double[] copierTab(double[] tab) {
        double[] copie = tab;

        return copie;
    }

    public static void main(String[] args) {
        double[] t1 = new double[10];

        for(int i=0; i<10; i++) {
            t1[i] = i;
        }

        double[] t2 = copierTab(t1);

        t2[0] = 1000;

        System.out.println(t1[0]); // Devrait afficher 0
        System.out.println(t2[0]); // Devrait afficher 1000
    }
}

// Réponse : la fonction copierTab ne crée pas une copie du tableau;
// elle engendre simplement une nouvelle référence vers la cellule 
// mémoire où tab se situe. Ainsi, lorsqu'on modoifie le premier
// élément du tableau "copie" on modifie en fait le premier élément
// du tableau tab, puisqu'il s'agit du même tableau.
//
// Pour corriger ce bug, il faudrait copier les élément du tableau tab
// en utilisant une méthode prédéfinie (System.arraycopy) ou une simple
// boucle. 
