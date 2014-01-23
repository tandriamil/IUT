package Parking;

/**
*Classe de test de la classe Voiture
*/
public class TestVoiture {
	public static void main(String [] args) {
		//Instanciation
		Voiture v = new Voiture("Renault", "Clio", 120);
		System.out.println(v.toString());
	}
}