// Dites ce que le programme affiche.
class Scratch {

    public static void main(String[] args) {

        int[] x = new int[3];

        for(int i=0; i<x.length; i++) {
            x[i] = i;
        }

        int y = 2;

        int[] z = foo(x, x, y);

        System.out.println( y );
        System.out.println(x[0] + "," + x[1] + "," + x[2]);
        System.out.println(z[0] + "," + z[1] + "," + z[2]);
    }

    public static int[] foo(int[] a, int[] b, double c) {

        c++;
        
        System.out.println(c / 2);

        for(int i=0; i<a.length; i++) {
            a[i] += (int) (c / 2);
            b[i] += (int) (c / 2);
        }

        return b;
    }
}

// Ce programme affiche 2; 1.5 ; 2,3,4 ; 2,3,4
//
// On crée d'abord un tableau d'entiers contenant [0,1,2]. L'entier 2 est ensuite 
// enregistré dans la variable y.
//
// La fonction foo prend trois paramètres : le tableau x
// comme premier et deuxième paramètre et la variable y comme troisième paramètre.
// La fonction incrément la variable y à y = 3 et commande l'impression de 2
// Après avoir fait l'opération de division. 
//
// La boucle de la fonction incrément de 1 chaque élément du tableau, de façon à
// obtenir a = [2,3,4] et b = [2,3,4] (Il s'agit du même tableau, soit x, et les deux 
// opérations de la boucle sont redondantes. 
//
// Finalement, la fonction imprime les string "2,3,4" deux fois (concaténation). 
