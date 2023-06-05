public class StringCompressee {
	String encodageFinal;

	String stringOriginale;


	public StringCompressee(String input) {
		this.stringOriginale = input;
        encodageFinal = "";
    }
	// Cette classe accepte un String et retourne un string correspondant
	// au running length encoding d'un caractère 
	public String encodeString() {
		String input; 
		input = this.stringOriginale;
        if (input.isEmpty()) {
            return encodageFinal; // Return empty string if input is empty
        }

        int n = 1; // Initialize the repetition count
        char comparisonChar = input.charAt(0); // Store the first character as the comparison character



		// On itère à travers le String. Si le char à la position de ComparisonStd
		// est indentique au char à la position suivante; on incrémente le conteur.
		// Si non, on modifie le String de l'encodage final; on appel la fonction
		// encodageChar pour obtenir de running length encoding du char répété
		// n fois. On met ensuite à jour le ComparisonStd.

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == comparisonChar) {
                n++;
            } 

			else {
                encodageFinal += encodeChar(comparisonChar, n, "yes");
                comparisonChar = currentChar;
                n = 1;
            }
        }

        encodageFinal += encodeChar(comparisonChar, n, "no"); // Encode the last character sequence

        return encodageFinal;
    }

	String encodeChar(char input, int reps, String virgule) {
	String output;
		if (virgule.equalsIgnoreCase("yes")) {
			output = reps + "" + " x " + input + ", ";
		}
		else {
			output = reps + "" + " x " + input;
		}

	return output;
	
	}


	public int tailleCompressee() {
	int output = 0;

		for (int i = 0; i < this.encodageFinal.length() ; i++) {
			output++;
		}
	return output; 

	}

	public int tailleOriginale() {
	int output = 0;

		for (int i = 0; i < this.stringOriginale.length(); i++) {
			output++;
		}
	return output;
	}

	public String[] generateDecodedTable() {
		String input = this.encodageFinal; 

		String valeur = "";
		String qty = "";
		int d = 0;
		int f = 0;
		int valUniques = compterValDinstinctes();
		String[] output = new String[valUniques * 2];

		for (int i = 0; i < valUniques -1; i++) {
			qty += input.substring(d, input.indexOf('x', d));
			f = input.indexOf(',',d);
			valeur+= input.charAt(f - 1);
			
			output[i] = qty;
			output[i + 1] = valeur;
			

			d = f+2;
			valeur = "";
			qty = "";

		}
		/*qty += input.substring(d, input.indexOf('x', d));
		f = input.length(); 
		valeur+= input.charAt(f - 1);

		output[valUniques - 2] = qty; // Use valUniques - 1 to access the last index
		output[valUniques - 1] = valeur;*/
	return output;


	}

	public int compterValDinstinctes() {
		String input = this.encodageFinal;
		int counter = 1;

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == ',') {
				counter++;
			}

		}
	return counter;

	}

	public String genererDecodedString() {
	String[] input = generateDecodedTable();

	String output = "";

		for (int i = 0; i < input.length ; i = i + 2) {
	
			for (int y = 0; y == Integer.parseInt(input[i+1]); y++) {
			output+= input[i];

			}
		
		}
	return output;
	}


	public static void main(String[] args) {
	StringCompressee compressee = new StringCompressee("aaaaaaaaaabbbbbbcc");


	System.out.println(compressee.encodeString());

	System.out.println(compressee.tailleCompressee());

	System.out.println(compressee.tailleOriginale());

	String[] test = compressee.generateDecodedTable();

	for (int i = 0; i < test.length; i++)
		System.out.println(test[i]);
	}

}
