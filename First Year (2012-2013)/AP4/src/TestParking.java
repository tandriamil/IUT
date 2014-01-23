package Parking;

/**
*Classe de test de la classe Parking
*/
public class TestParking {
	public static void main(String[] args) {
//Instanciations
		Voiture clio = new Voiture("Renault", "Clio", 120);
		Voiture ferrari = new Voiture("Ferrari", "F1", 360);
		Parking p = new Parking();

//Test de toString()
		System.out.println(p.toString());

//Test de garer()
		//Fonctionnement normal
		try {
			p.garer(clio, 0);
		}

		catch (ExceptionParking e) {
			System.out.println(e.getMessage());
		}

		finally {
			System.out.println(p.toString());
		}

		//Deuxieme voiture garee
		try {
			p.garer(ferrari, 1);
		}

		catch (ExceptionParking e) {
			System.out.println(e.getMessage());
		}

		finally {
			System.out.println(p.toString());
		}
	}
}