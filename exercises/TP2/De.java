import java.util.Random;

public class De {

	private int nombreFaces;

	private Random outcome = new Random();


	public De(int faces) {
		this.nombreFaces = faces;	
	}

	public void setFaces(int faces) {
		this.nombreFaces = faces;

	}

	public int getFaces() {
		return this.nombreFaces;

	}

	public int getoutcome() {
	return outcome.nextInt(getFaces());
	}
	
	public static void main(String[] args) {
	De nouveauDe = new De(25);

	System.out.println(nouveauDe.getoutcome());
	
	}

}
