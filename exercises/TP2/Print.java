/* 1. Essayez de compiler le programme suivant :

public class Print {

    public void print(int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        int n = 13;
        print( n );
    }
}

Expliquez le problème. */

//===================================================================================================
/* Pour utiliser la méthode print(int x), il faut une instance de la classe Print. 
 * Ou encore, il faudrait que la méthode print(int x) soit soit définit avec le mot clé
 * static pour qu'on puisse y accéder sans instancier un objet de la classe Print. Par ailleurs,
 * la méthode main est déclaré comme étant statique; elle appartient donc à la classe elle-même.
 * Puisque la fonction print(int x) est non statique, elle ne peut pas être appelée dans le contexte
 * de la méthode main. 
 *
 * Pour résoude le problème, on peut soit : (1) Instancier la classe Print dans la méthode main et 
 * appeler la méthode print(int x) dans main ou (2) changer le statut de la classe print(int x) de
 * public à static.
 *
 */
//===================================================================================================


/* Solution 1. 
public class Print {

    public void print(int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        int n = 13;
        Print obj = new Print(); // Create an instance of the Print class
        obj.print(n); // Call the print method on the instance
    }
}
*/
//===================================================================================================

//Solution 2.

public class Print {

    public static void print(int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
		print(100); // Call the print method on the instance
    }
}
