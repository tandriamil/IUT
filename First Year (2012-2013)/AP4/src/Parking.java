package Parking;

/**
*Classe Parking pouvant contenir les voitures
*/
public class Parking {
//Attributs
	private static final int NB_PLACES = 11;
	private Voiture[] place;

//Methodes
	/**
	*Constructeur
	*/
	public Parking() {
		this.place = new Voiture[NB_PLACES];
	}

	/**
	*Permet d'afficher l'etat de toutes les places du Parking
	*/
	public String toString() {
		String ret = "";

		for (int i = 0; i < NB_PLACES; i++) {

			if (this.place[i] != null) {
				ret = "La place numero " + i + " contient " + this.place[i].toString();
			}

			else {
				ret = ret + "La place numero " + i + " est vide.";
			}
			ret = ret + '\n';
		}

		return ret;
	}

	/**
	*Teste si le numero donnee a une place est valide
	*@param numPlace Place a verifier
	*@throws Exception si la place entree n'existe pas
	*/
	private void numeroValide(int numPlace) throws ExceptionParking {
		try {
			if ((numPlace < 0) || (numPlace > NB_PLACES)) {
				ExceptionParking e = new ExceptionParking("Numero de place non valide!");
				throw e;
			}
		}

		catch (ExceptionParking e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	*Permet de garer une voiture sur la place
	*@param voit Voiture a garer
	*@param numPlace Place ou garer la voiture
	*@throws Exception si place inexistante ou place deja occupee
	*/
	public void garer(Voiture voit, int numPlace) throws ExceptionParking {
		try {
			this.numeroValide(numPlace); //Verif numero valide

			if (this.place[numPlace] == null) { //Verif place libre
				this.place[numPlace] = voit;
			}
			else {
				ExceptionParking e = new ExceptionParking("Place deja occupee!");
				throw e;
			}
		}

		catch (ExceptionParking e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	*Permet de sortir une voiture de la place
	*@param numPlace Place ou se trouve la voiture
	*@return Retourne la voiture qui etait garee sur la place
	*@throws Exception si place inexistante ou vacante
	*/
	public Voiture sortir(int numPlace) throws ExceptionParking {
		Voiture ret = null;

		try {
			this.numeroValide(numPlace);

			if (this.place[numPlace] != null) { //Verif que la place est occupee
				ret = this.place[numPlace];
				this.place[numPlace] = null;
			}
			else {
				ExceptionParking e = new ExceptionParking("Pas de voiture a cette place!");
				throw e;
			}
		}

		catch (ExceptionParking e) {
			System.out.println(e.getMessage());
		}

		return ret;
	}

}