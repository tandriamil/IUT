package pda.datas;

import java.io.*;

/**
*Classe pour les Pieces (Pion ou Dame), les cases aussi sont considerees comme
*/
public class Piece implements Serializable {
//Attributs
	private int etat;
	private int ligne;
	private int colonne;
	private boolean dame;

	//Pour eviter un warning
	private static final long serialVersionUID = 1;

//Methodes
	/**
	*Constructeur de la classe Piece
	*@param etat Couleur de la Piece
	*@param l Ligne de la Piece
	*@param c Colonne de la piece
	*@param isDame Si c'est une Dame ou pas
	*/
	public Piece(int c, int l, int etat, boolean isDame) {
		this.etat = etat;
		this.ligne = l;
		this.colonne = c;
		this.dame = isDame;
	}

	/**
	*Permet un affichage de la Piece
	*Attention, on y rajoute 1 car case 0 non pertinente
	*@return Un affichage organise de la Piece
	**/
	public String toString() {
		String ret="";

		if (etat == 1) {
			if (!dame) {
				ret = "Pion blanc ";
			}
			else {
				ret = "Dame blanche ";
			}
		}
		if (etat == 2) {
			if (!dame) {
				ret = "Pion noir ";
			}
			else {
				ret = "Dame noire ";
			}
		}
		if (etat == 0) {
			ret = "Case noire vide ";
		}
		if (etat == 3) {
			ret = "Case blanche ";
		}

		ret = ret + "a la position [" + (this.colonne + 1) + "," + (this.ligne + 1) + "].";

		return ret;
	}

	/**
	*Permet de savoir si c'est un Pion ou une Dame
	*@return true si un Pion, false si une Dame
	*/
	public boolean isDame() {
		return this.dame;
	}

	/**
	*Permet de savoir si c'est une Piece noire ou blanche
	*@return 1 si Piece blanche, 2 si Piece noire, 0 si case noire vide, 3 si case blanche
	*/
	public int etat() {
		return this.etat;
	}

	/**
	*Accesseur de la ligne de la piece
	*@return La ligne de la piece
	*/
	public int getLigne() {
		return this.ligne;
	}

	/**
	*Accesseur de la colonne de la Piece
	*@return La colonne de la Piece
	*/
	public int getColonne() {
		return this.colonne;
	}
}