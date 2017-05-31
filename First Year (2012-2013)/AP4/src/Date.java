package Annuaire;

/**
*Classe permettant d'instancier les Dates a ajouter aux informations des Personnes
*/
public class Date {
//Attributs
	private int jour;
	private int mois;
	private int annee;

//Methodes
	/**
	*Constructeur, permet d'initialiser les attributs
	*@param unJ Jour de la date
	*@param UnM Mois de la date
	*@param unA Annee de la date
	*/
	public Date(int unJ, int unM, int unA) {
		this.jour = unJ;
		this.mois = unM;
		this.annee = unA;
	}


	/**
	*Methode permettant d'afficher les informations
	*@return Un affichage de la date au format JJ/MM/AAAA
	*/
	public String toString() {
		return this.jour + "/" + this.mois + "/" + this.annee;
	}
}
