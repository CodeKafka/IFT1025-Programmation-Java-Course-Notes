

public class Exercice2{
	public static void main(String[] args) {
	    // Crée des objets de type Vecteur
	    double[] tabDoubleVA = {1.0,2.0,3.0,4.0};
	    Vecteur vecteurA = new Vecteur(tabDoubleVA);

	    double[] tabDoubleVB = {5.0,6.0,7.0,8.0};
	    Vecteur B = new Vecteur(tabDoubleVB);
	    
	    // Teste le constructeur de classe
	    System.out.println("------------------------Constructeur de classe------------------------");
	    boolean successConstructeur = true;
	    for (int i = 0; i < tabDoubleVA.length; i++) {
		    if (vecteurA.getValeurs()[i] != tabDoubleVA[i]) {
			successConstructeur = false;
			System.out.println("Erreur : les valeurs des tableaux ne sont pas equivalentes"+"\n");
		    }		    
	    }
	    if (successConstructeur == true) {
	        System.out.println("Succès : La méthode de constructeur semble fonctionner"+"\n");
	    }

	    // Teste la methode afficher()
	    System.out.println("--------------------------Valeur de VecteurA--------------------------");
	    System.out.print("Le Vecteur « VecteurA » est représenté par VecteurA = ");  vecteurA.afficher();
	    System.out.println("");

	    // Teste la méthode getElement()
	    System.out.println("-----------------------------getElement()------------------------------");
		
	    boolean successGetElement = true;
	    for (int i = 0; i < vecteurA.getValeurs().length; i++) {
		if (vecteurA.getElement(i) != (double) i+1.0 ) {
		    successGetElement = false;
		    System.out.println("Erreur : la donnée à l'index " +i +" ne semble pas avoir la bonne valeur ");
		}
	    }

	    if (successGetElement == true) {
		System.out.println("Succès : la méthode getElement() semble fonctionner" + "\n");
	    }
		
	    // Teste la méthode setElement()
            System.out.println("-----------------------------setElement()------------------------------");
	    vecteurA.setElement(0,25.0);
	    if (vecteurA.getElement(0) == 25.0 ) {
		System.out.println("Succès : la méthode setElement() semble fonctionner" + "\n");
		System.out.print("Notez que le vecteur « VecteurA » est maintenant représenté par");
		vecteurA.afficher();
	    }
	    System.out.println("");

	    // Teste la méthode dotProduct()
	    System.out.println("------------------------------dotProduct()------------------------------");
	    if (vecteurA.dotProduct(B) == 190.0) {
		System.out.println("Succès : la méthode dotProduct() semble fonctionner"+"\n");
	    }
	    System.out.print("Notez que la valeur du produit croisé est ");
	    System.out.println(vecteurA.dotProduct(B));

	    double compt = 1.0;
	    Matrice matriceA = new Matrice(4,4);
	    Matrice matriceB = new Matrice(4,4);
	    Matrice matriceC = new Matrice(4,6);
	    for (int i = 0; i < matriceB.getRangees(); i++) {
		for (int j = 0; j < matriceB.getColonnes(); j++) {
		    matriceB.getRepresentation()[i][j] = compt;
		    compt++;
		}
	    }
	    for (int i = 0; i < matriceC.getRangees(); i++) {
		for (int j = 0; j < matriceC.getColonnes(); j++) {
		    matriceC.getRepresentation()[i][j] = compt;
		    compt++;
		}
	    }





	    System.out.println("--------------------Constructeur de classe Matrice----------------------");
	    System.out.println("La matrice 2D générée par le constructeur Matrice() est: ");
	    System.out.println("");
	    for (int i = 0; i < matriceA.getRangees() ; i++) {
		for (int j = 0; j < matriceA.getColonnes(); j++) {
		    System.out.print(matriceA.getRepresentation()[i][j] + " ");
		}
		System.out.println();
	    }
	    System.out.println("");
	    System.out.println("Succès : La méthode de constructeur semble fonctionner" + "\n");



	    System.out.println("--------------------------Méthode afficher()-----------------------------");
	    System.out.println("On affiche la matrice «matriceB» en utilisant la méthode afficher()" + "\n");
	    matriceB.afficher();

	    System.out.println("");
	    System.out.println("Succès : la méthode afficher() semble fonctionner"+"\n");

	    System.out.println("--------------------------Méthode getLine()-----------------------------");
	    System.out.println("La ligne 0 de la matrice «matriceB» est : ");
	    Vecteur testGetLine = matriceB.getLine(0);
	    testGetLine.afficher();    
	    System.out.println("Succès : la méthode getLine() semble fonctionner" + "\n");
	    
	    System.out.println("---------------------------Méthode getCol()-----------------------------");
	    System.out.println("La ligne 0 de la matrice «matriceB» est : ");
	    Vecteur testGetCol = matriceB.getCol(0);
	    testGetCol.afficher();    
	    System.out.println("Succès : la méthode getCol() semble fonctionner" + "\n");

	    System.out.println("---------------------------Méthode getCell()-----------------------------");
	    System.out.println("La cellue (2,2) de la matrice «matriceB» est: ");
	    System.out.println(matriceB.getCell(2,2)+"");
	    System.out.println("Succès : la méthode getCell() semble fonctionner" + "\n");

	    System.out.println("---------------------------Méthode setCell()-----------------------------");
	    System.out.print("La cellue (2,2) de la matrice «matriceB» était: ");
	    System.out.println(matriceB.getCell(2,2)+"");

	    matriceB.setCell(2,2, 99.0);
	    System.out.print("La cellue (2,2) de la matrice «matriceB» est maintenant: ");
	    System.out.println(matriceB.getCell(2,2)+"");

	    System.out.println("Succès : la méthode setCell() semble fonctionner" + "\n");


	    System.out.println("-------------------------additionnerScalaire()-----------------------------");
	    System.out.println("La matrice «matriceB» avait le contenu suivant : ");
	    matriceB.afficher();

	    matriceB.additionnerScalaire(10.0);
	    System.out.println("");
	    System.out.println("En ajoutant le scalire 10.0, elle a maintenant le contenu : ");
	    matriceB.afficher();
    
	    System.out.println("Succès : la méthode additionnerScalaire() semble fonctionner" + "\n");


	    System.out.println("-------------------------multiplierScalaire()-----------------------------");
	    System.out.println("La matrice «matriceB» avait le contenu suivant : ");
	    matriceB.afficher();

	    matriceB.multiplierScalaire(2.0);
	    System.out.println("");
	    System.out.println("En la multipliant par le scalire 2.0, elle a maintenant le contenu : ");
	    matriceB.afficher();
 
	    System.out.println("Succès : la méthode additionnerScalaire() semble fonctionner" + "\n");



	    System.out.println("-------------------------dotProduct()-----------------------------");
	    Matrice testDotProduct1 = matriceB.dotProduct(matriceB);
	    Matrice testDotProduct2 = matriceB.dotProduct(matriceA);
	    Matrice testDotProduct3 = matriceB.dotProduct(matriceC);
	    

	    System.out.println("Le produit matriciel de «matriceB» par «matriceB» est :");
	    testDotProduct1.afficher();
	    System.out.println("");

	    System.out.println("Le produit matriciel de «matriceB» par «matriceA» est :");
	    testDotProduct2.afficher();
	    System.out.println(""); 

	    System.out.println("Le produit matriciel de «matriceB» par «matriceC» est :");
	    testDotProduct3.afficher();
	    System.out.println("Hmmm je ne suis pas sûr que ma méthode dotProduct() est cohérente");

	}


}
