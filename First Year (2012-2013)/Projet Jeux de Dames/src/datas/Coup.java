package pda.datas;

import java.io.*;

/**
*Classe pour enregistrer les coups passes pour pouvoir ensuite en annules
*/
public class Coup implements Serializable {
//Attributs
	private Piece caseDebut;
	private Piece caseSuivante;
	private Piece piecePrise;

	//Pour eviter un warning
	private static final long serialVersionUID = 1;

//Methodes
	/**
	*Constructeur de la classe Coup
	*@param debut La piece current qui joue
	*@param next La case ou cette piece va
	*@param suppr La piece supprimee, peut etre null si aucune
	*/
	public Coup(Piece debut, Piece next, Piece suppr) {
		this.caseDebut = debut;
		this.caseSuivante = next;
		this.piecePrise = suppr;
	}

	/**
	*Accesseur de caseDebut
	*@return La piece de depart du coup
	*/
	public Piece getDebut() {
		return this.caseDebut;
	}

	/**
	*Accesseur de caseSuivante
	*@return La nouvelle position de la Piece en question
	*/
	public Piece getNext() {
		return this.caseSuivante;
	}

	/**
	*Accesseur de piecePrise
	*@return La piece prise (supprimee) durant le coup
	*/
	public Piece getSuppr() {
		return this.piecePrise;
	}

	/**
	*Permet un affichage du coup
	*@return Un affichage organise du coup
	*/
	public String toString() {
		String ret = "";

		ret = ret + this.caseDebut.toString() + " deplacee en " + this.caseSuivante.toString() + "." + "\n";

		if (piecePrise != null) {
			ret = ret + "La case suivante a ete supprimee: " + this.piecePrise.toString() + "\n";
		}
		
		return ret;
	}
}