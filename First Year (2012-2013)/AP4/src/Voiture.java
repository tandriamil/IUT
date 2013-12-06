package Parking;

/**
*Classe permettant d'instancier des voitures a placer sur le parking
*/
public class Voiture {
	//Attributs
	private String marque;
	private String modele;
	private int puissance;

	//Methodes
	/**
	*Constructeur de la classe
	*@param mq Marque de la voiture
	*@param mdl Modele de la voiture
	*@param p Puissance de la voiture
	*/ 
	public Voiture(String mq, String mdl, int p) {
		this.marque = mq;
		this.modele = mdl;
		this.puissance = p;
	}

	/**
	*Methode presentant la voiture
	*@return Description de la voiture
	*/
	public String toString() {
		return "une " + this.marque + " " + this.modele + " de " + this.puissance + " cheveaux.";
	}
}