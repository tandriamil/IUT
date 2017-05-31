package pda.datas;

import java.util.*;
import java.io.*;

/**
*Classe pour le damier (le plateau de jeux)
*/
public class Damier implements Cloneable, Serializable {
//Attributs
	private int nombreCases;
	private Piece current;
	private int currentX;
	private int currentY;
	private Piece[][] tabCases;

	//Pour eviter un warning
	private static final long serialVersionUID = 1;

	/**
	*Le constructeur de la classe Damier
	*@param nbCases Le nombre de cases du damier (en longueur)
	**/
	public Damier(int nbCases) {
		this.current = null;
		this.nombreCases = nbCases;
		this.tabCases = new Piece[this.nombreCases][this.nombreCases];
		this.init();
	}

	/**
	*Le constructeur utilisee pour le clonage
	*@param nbCases Le nombre de cases du damier
	*@param enCours La piece current
	*@param x La position horizontale de la piece
	*@param y La position verticale de la piece
	*@param plateau Le plateau du jeu en cours
	*/
	public Damier(int nbCases, Piece enCours, int x, int y, Piece[][] plateau) {
		this.nombreCases = nbCases;
		this.current = enCours;
		this.currentX = x;
		this.currentY = y;
		this.tabCases = plateau;
	}

	/**
	*Permet de cloner l'objet Damier pour des simulations
	*@return Un clone du damier
	*/
	public Damier clone() {
		Damier clone = new Damier(this.nombreCases, this.current, this.currentX, this.currentY, this.tabCases);
		return clone;
	}

	/**
	*permet de connaitre le nombre de case du damier
	*@return Le nombre de case du damier (en longueur)
	**/
	public String toString() {
		String ret = "";

		for (int i = this.nombreCases; i >= 0; i--) {
			for (int j = 0; j <= this.nombreCases + 1; j++) {

				//Affichage de la colonne des numeros de cases
				if ((j == 0) && (i >= 10)) {
					ret = ret + "\n" + (i);
				}

				if ((j == 0) && (i <= 9)) {
					ret = ret + "\n" + (i) + " ";
				}

				//Debut affichage du tableau
				else {

					//Si pion blanc
					if (this.quellePiece(j - 1, i - 1) == 1) {
						ret = ret + " [b]";
					}

					//Si pion noir
					if (this.quellePiece(j - 1, i - 1) == 2) {
						ret = ret + " [n]";
					}

					//Si dame blanche
					if (this.quellePiece(j - 1, i - 1) == 3) {
						ret = ret + " [B]";
					}

					//Si dame noire
					if (this.quellePiece(j - 1, i - 1) == 4) {
						ret = ret + " [N]";
					}

					//Si case blanche
					if (this.quellePiece(j - 1, i - 1) == 5) {
						ret = ret + " [ ]";
					}

					//Si case noire
					if (this.quellePiece(j - 1, i - 1) == 0) {
						ret = ret + " [ ]";
					}
				}
			}
		}

		//Affichage du numero des lignes
		for (int x = 1; x <= this.nombreCases; x++) {
			if (x >= 10) {
				ret = ret + "  " + x;
			}
			else {
				ret = ret + "  " + x + " ";
			}
		}

		return ret;
	}

	/**
	*permet de (re)creer le Damier avec les pieces
	**/
	public void init() {
		this.clear();

		for (int x = 0; x < this.nombreCases; x++) {
			for (int y = 0; y < this.nombreCases / 2 - 1; y++) {
				if (this.tabCases[x][y].etat() == 0) {
					this.tabCases[x][y] = new Piece(x, y, 1, false);
				}
			}
		}

		for (int x = 0; x < this.nombreCases; x++) {
			for (int y = this.nombreCases - 1; y >= this.nombreCases / 2 + 1; y--) {
				if (this.tabCases[x][y].etat() == 0) {
					this.tabCases[x][y] = new Piece(x, y, 2, false);
				}
			}
		}
	}

	/**
	*Permet d'enlever toutes les pieces du damier
	*/
	public void clear() {
		//Creation d'un damier vide
		for (int x = 0; x < this.nombreCases; x++) {
			if (x % 2 == 0) {
				for (int y = 0; y < this.nombreCases; y++) {
					if (y % 2 == 0) {
						this.tabCases[x][y] = new Piece(x, y, 0, false);
					}
					else {
						this.tabCases[x][y] = new Piece(x, y, 3, false);
					}
				}
			}
			else {
				for (int y = 0; y < this.nombreCases; y++) {
					if (y % 2 == 0) {
						this.tabCases[x][y] = new Piece(x, y, 3, false);
					}
					else {
						this.tabCases[x][y] = new Piece(x, y, 0, false);
					}
				}
			}
		}
	}

	/**
	*Permet de renvoyer une Piece du tableau
	*@param l Ligne de la Piece, soit son y dans le tableau
	*@param c Colonne de la Piece, soit son x dans le tableau
	*@return Retourne la Piece correspondante
	*/
	public Piece getPiece(int c, int l) {
		return this.tabCases[c][l];
	}

	/**
	*Permet d'ajouter une Piece au tableau
	*@param p Piece a ajouter
	*/
	public void setPiece(Piece p) {
		int ligne = p.getLigne();
		int colonne = p.getColonne();
		this.tabCases[colonne][ligne] = p;
	}

	/**
	*Permet de savoir quelle Piece on va jouer
	*@param unePiece La piece qu'on va jouer
	*@return true si case possible, false si non possible
	*/
	public boolean setCurrent(Piece unePiece) {
		boolean ret = false;
		ArrayList<Piece> possible = new ArrayList<Piece>();

		if ((this.quellePiece(unePiece.getColonne(), unePiece.getLigne()) == 1) || (this.quellePiece(unePiece.getColonne(), unePiece.getLigne()) == 3)) {
			possible = this.deplacable(1);
		}
		if ((this.quellePiece(unePiece.getColonne(), unePiece.getLigne()) == 2) || (this.quellePiece(unePiece.getColonne(), unePiece.getLigne()) == 4)) {
			possible = this.deplacable(2);
		}

		if (!possible.isEmpty()) {
			for (int i = 0; i < possible.size(); i++) {
				if (unePiece.equals(possible.get(i))) {
					this.current = unePiece;
					this.currentY = unePiece.getLigne();
					this.currentX = unePiece.getColonne();
					ret = true;
				}
			}
		}

		return ret;
	}

	/**
	*Accesseur de current
	*@return La piece qu'on va jouer
	*/
	public Piece getCurrent() {
		return this.current;
	}

	/**
	*Permet de savoir quel Pion se trouve sur telle case
	*@param c La position horizontale de la piece
	*@param l La position verticale de la piece
	*@return 0 si pas de Pion, 1 si Pion blanc, 2 si Pion noir, 3 si Dame blanche, 4 si Dame noire, 5 si case blanche, 6 si case non existante
	*/
	public int quellePiece(int c, int l) {
		int ret;

		if ((c >= this.nombreCases) || l >= this.nombreCases || c < 0 || l < 0) {
			ret = 6;
		}

		else {
			if (this.tabCases[c][l].etat() == 3) {
				ret = 5;
			}

			else {
				if (this.tabCases[c][l].etat() == 0) {
					ret = 0;
				}
				else {
					if (tabCases[c][l].isDame()) {
						if (tabCases[c][l].etat() == 1) {
							ret = 3;
						}
						else {
							ret = 4;
						}
					}
					else {
						if (tabCases[c][l].etat() == 1) {
							ret = 1;
						}
						else {
							ret = 2;
						}
					}
				}
			}
		}

		return ret;
	}

	/**
	*Permet de lister les cases possibles
	*@param p Piece a calculee les cases possibles
	*/
	public ArrayList<Piece> casesPossibles(Piece p) {
		ArrayList<Piece> enumCases = new ArrayList<Piece>();
		ArrayList<Piece> casesLibres = new ArrayList<Piece>();
		boolean stopHautGauche = false;
		boolean stopHautDroite = false;
		boolean stopBasGauche = false;
		boolean stopBasDroite = false;
		boolean obligationDeManger = false;
		int pX = p.getColonne();
		int pY = p.getLigne();

	//Si Pion blanc
		if (this.quellePiece(pX, pY) == 1) {
			obligationDeManger = false;

			//Si la case au dessus a droite contient un Pion ennemi et que celle d'apres est vide
			if ((this.quellePiece(pX + 1, pY + 1) == 2) || (this.quellePiece(pX + 1, pY + 1) == 4)) {
				if (this.quellePiece(pX + 2, pY + 2) == 0) {
					enumCases.add(this.tabCases[pX + 2][pY + 2]);
					obligationDeManger = true;
				}
			}

			//Si la case au dessus a gauche contient un Pion ennemi et que celle d'apres est vide
			if ((this.quellePiece(pX - 1, pY + 1) == 2) || (this.quellePiece(pX - 1, pY + 1) == 4)) {
				if (this.quellePiece(pX - 2, pY + 2) == 0) {
					enumCases.add(this.tabCases[pX - 2][pY + 2]);
					obligationDeManger = true;
				}
			}

			//Si la case en dessous a droite contient un Pion ennemi et que celle d'apres est vide
			if ((this.quellePiece(pX + 1, pY - 1) == 2) || (this.quellePiece(pX + 1, pY - 1) == 4)) {
				if (this.quellePiece(pX + 2, pY - 2) == 0) {
					enumCases.add(this.tabCases[pX + 2][pY - 2]);
					obligationDeManger = true;
				}
			}

			//Si la case en dessous a gauche contient un Pion ennemi et que celle d'apres est vide
			if ((this.quellePiece(pX - 1, pY - 1) == 2) || (this.quellePiece(pX - 1, pY - 1) == 4)) {
				if (this.quellePiece(pX - 2, pY - 2) == 0) {
					enumCases.add(this.tabCases[pX - 2][pY - 2]);
				}
			}

			//Si la case au dessus a droite est vide
			if ((this.quellePiece(pX + 1, pY + 1) == 0) && !obligationDeManger) {
				enumCases.add(this.tabCases[pX + 1][pY + 1]);
			}

			//Si la case au dessus a gauche est vide
			if ((this.quellePiece(pX - 1, pY + 1) == 0) && !obligationDeManger) {
				enumCases.add(this.tabCases[pX - 1][pY + 1]);
			}
		}


	//Si Pion noir
		if (this.quellePiece(pX, pY) == 2) {
		obligationDeManger = false;

			//Si la case en dessous a droite contient un Pion ennemi et que celle d'apres est vide
			if ((this.quellePiece(pX + 1, pY - 1) == 1) || (this.quellePiece(pX + 1, pY - 1) == 3)) {
				if ((this.quellePiece(pX + 2, pY - 2) == 0)) {
					enumCases.add(this.tabCases[pX + 2][pY - 2]);
					obligationDeManger = true;
				}
			}

			//Si la case en dessous a gauche contient un Pion ennemi et que celle d'apres est vide
			if ((this.quellePiece(pX - 1, pY - 1) == 1) || (this.quellePiece(pX - 1, pY - 1) == 3)) {
				if (this.quellePiece(pX - 2, pY - 2) == 0) {
					enumCases.add(this.tabCases[pX - 2][pY - 2]);
					obligationDeManger = true;
				}
			}

			//Si la case en dessous a droite contient un Pion ennemi et que celle d'apres est vide
			if ((this.quellePiece(pX + 1, pY - 1) == 1) || (this.quellePiece(pX + 1, pY - 1) == 3)) {
				if (this.quellePiece(pX + 2, pY - 2) == 0) {
					enumCases.add(this.tabCases[pX + 2][pY - 2]);
					obligationDeManger = true;
				}
			}

			//Si la case en dessous a gauche contient un Pion ennemi et que celle d'apres est vide
			if ((this.quellePiece(pX - 1, pY - 1) == 1) || (this.quellePiece(pX - 1, pY - 1) == 3)) {
				if (this.quellePiece(pX - 2, pY - 2) == 0) {
					enumCases.add(this.tabCases[pX - 2][pY - 2]);
					obligationDeManger = true;
				}
			}

			//Si la case en dessous a droite est vide
			if ((this.quellePiece(pX + 1, pY - 1) == 0) && !obligationDeManger) {
				enumCases.add(this.tabCases[pX + 1][pY - 1]);
			}

			//Si la case en dessous a gauche est vide
			if ((this.quellePiece(pX - 1, pY - 1) == 0) && !obligationDeManger) {
				enumCases.add(this.tabCases[pX - 1][pY - 1]);
			}
		}

	//Si Dame blanche
		if (this.quellePiece(pX, pY) == 3) {
			obligationDeManger = false;

			//Iteration
			for (int i = 1; i < this.nombreCases; i++) {

			//Parcours haut gauche
				//Cases vides
				if ((this.quellePiece(pX - i, pY + i) == 0) && (!stopHautGauche)) {
					casesLibres.add(this.tabCases[pX - i][pY + i]);
				}

				//Case ennemie
				if (((this.quellePiece(pX - i, pY + i) == 2) || (this.quellePiece(pX - i, pY + i) == 4)) && (!stopHautGauche)) {
					stopHautGauche = true;

					//Case ennemie et vide derriere
					int x = 1;

					while (this.quellePiece(pX - (i + x), pY + (i + x)) == 0) {
						enumCases.add(this.tabCases[pX - (i + x)][pY + (i + x)]);
						obligationDeManger = true;
						x = x + 1;
					}
				}

				//Case alliee
				if (((this.quellePiece(pX - i, pY + i) == 1) || (this.quellePiece(pX - i, pY + i) == 3)) && (!stopHautGauche)) {
					stopHautGauche = true;
				}

			//Parcours haut droite
				//Cases vides
				if ((this.quellePiece(pX + i, pY + i) == 0) && (!stopHautDroite)) {
					casesLibres.add(this.tabCases[pX + i][pY + i]);
				}

				//Case ennemie
				if (((this.quellePiece(pX + i, pY + i) == 2) || (this.quellePiece(pX + i, pY + i) == 4)) && (!stopHautDroite)) {
					stopHautDroite = true;

					//Case ennemie et vide derriere
					int x = 1;

					while (this.quellePiece(pX + (i + x), pY + (i + x)) == 0) {
						enumCases.add(this.tabCases[pX + (i + x)][pY + (i + x)]);
						obligationDeManger = true;
						x = x + 1;
					}
				}

				//Case alliee
				if (((this.quellePiece(pX + i, pY + i) == 1) || (this.quellePiece(pX + i, pY + i) == 3)) && (!stopHautDroite)) {
					stopHautDroite = true;
				}

			//Parcours bas gauche
				//Cases vides
				if ((this.quellePiece(pX - i, pY - i) == 0) && (!stopBasGauche)) {
					casesLibres.add(this.tabCases[pX - i][pY - i]);
				}

				//Case ennemie
				if (((this.quellePiece(pX - i, pY - i) == 2) || (this.quellePiece(pX - i, pY - i) == 4)) && (!stopBasGauche)) {
					stopBasGauche = true;

					//Case ennemie et vide derriere
					int x = 1;

					while (this.quellePiece(pX - (i + x), pY - (i + x)) == 0) {
						enumCases.add(this.tabCases[pX - (i + x)][pY - (i + x)]);
						obligationDeManger = true;
						x = x + 1;
					}
				}

				//Case alliee
				if (((this.quellePiece(pX - i, pY - i) == 1) || (this.quellePiece(pX - i, pY - i) == 3)) && (!stopBasGauche)) {
					stopBasGauche = true;
				}

			//Parcours bas droite
				//Cases vides
				if ((this.quellePiece(pX + i, pY - i) == 0) && (!stopBasDroite)) {
					casesLibres.add(this.tabCases[pX + i][pY - i]);
				}

				//Case ennemie
				if (((this.quellePiece(pX + i, pY - i) == 2) || (this.quellePiece(pX + i, pY - i) == 4)) && (!stopBasDroite)) {
					stopBasDroite = true;

					//Case ennemie et vide derriere
					int x = 1;

					while (this.quellePiece(pX + (i + x), pY - (i + x)) == 0) {
						enumCases.add(this.tabCases[pX + (i + x)][pY - (i + x)]);
						obligationDeManger = true;
						x = x + 1;
					}
				}

				//Case alliee
				if (((this.quellePiece(pX + i, pY - i) == 1) || (this.quellePiece(pX + i, pY - i) == 3)) && (!stopBasDroite)) {
					stopBasDroite = true;
				}
			}

		//Si obligation de manger, suppression des cases ou on ne mange pas
			if (!obligationDeManger) {
				enumCases = casesLibres;
			}
		}


	//Si Dame noire
		if (this.quellePiece(pX, pY) == 4) {
			obligationDeManger = false;

			//Iteration
			for (int i = 1; i < this.nombreCases; i++) {

			//Parcours haut gauche
				//Cases vides
				if ((this.quellePiece(pX - i, pY + i) == 0) && (!stopHautGauche)) {
					casesLibres.add(this.tabCases[pX - i][pY + i]);
				}

				//Case ennemie
				if ((this.quellePiece(pX - i, pY + i) == 1) || (this.quellePiece(pX - i, pY + i) == 3) && (!stopHautGauche)) {
					stopHautGauche = true;

					//Case ennemie et vide derriere
					int x = 1;

					while (this.quellePiece(pX - (i + x), pY + (i + x)) == 0) {
						enumCases.add(this.tabCases[pX - (i + x)][pY + (i + x)]);
						obligationDeManger = true;
						x = x + 1;
					}
				}

				//Case alliee
				if ((this.quellePiece(pX - i, pY + i) == 2) || (this.quellePiece(pX - i, pY + i) == 4) && (!stopHautGauche)) {
					stopHautGauche = true;
				}

			//Parcours haut droite
				//Cases vides
				if ((this.quellePiece(pX + i, pY + i) == 0) && (!stopHautDroite)) {
					casesLibres.add(this.tabCases[pX + i][pY + i]);
				}

				//Case ennemie
				if (((this.quellePiece(pX + i, pY + i) == 1) || (this.quellePiece(pX + i, pY + i) == 3)) && (!stopHautDroite)) {
					stopHautDroite = true;

					//Case ennemie et vide derriere
					int x = 1;

					while (this.quellePiece(pX + (i + x), pY + (i + x)) == 0) {
						enumCases.add(this.tabCases[pX + (i + x)][pY + (i + x)]);
						obligationDeManger = true;
						x = x + 1;
					}
				}

				//Case alliee
				if (((this.quellePiece(pX + i, pY + i) == 2) || (this.quellePiece(pX + i, pY + i) == 4)) && (!stopHautGauche)) {
					stopHautDroite = true;
				}

			//Parcours bas gauche
				//Cases vides
				if ((this.quellePiece(pX - i, pY - i) == 0) && (!stopBasGauche)) {
					casesLibres.add(this.tabCases[pX - i][pY - i]);
				}

				//Case ennemie
				if (((this.quellePiece(pX - i, pY - i) == 1) || (this.quellePiece(pX - i, pY - i) == 3)) && (!stopBasGauche)) {
					stopBasGauche = true;

					//Case ennemie et vide derriere
					int x = 1;

					while (this.quellePiece(pX - (i + x), pY - (i + x)) == 0) {
						enumCases.add(this.tabCases[pX - (i + x)][pY - (i + x)]);
						obligationDeManger = true;
						x = x + 1;
					}
				}

				//Case alliee
				if (((this.quellePiece(pX - i, pY - i) == 2) || (this.quellePiece(pX - i, pY - i) == 4)) && (!stopBasGauche)) {
					stopBasGauche = true;
				}

			//Parcours bas droite
				//Cases vides
				if ((this.quellePiece(pX + i, pY - i) == 0) && (!stopBasDroite)) {
					casesLibres.add(this.tabCases[pX + i][pY - i]);
				}

				//Case ennemie
				if ((this.quellePiece(pX + i, pY - i) == 1) || (this.quellePiece(pX + i, pY - i) == 3) && (!stopBasDroite)) {
					stopBasDroite = true;

					//Case ennemie et vide derriere
					int x = 1;

					while (this.quellePiece(pX + (i + x), pY - (i + x)) == 0) {
						enumCases.add(this.tabCases[pX + (i + x)][pY - (i + x)]);
						obligationDeManger = true;
						x = x + 1;
					}
				}

				//Case alliee
				if (((this.quellePiece(pX + i, pY - i) == 2) || (this.quellePiece(pX + i, pY - i) == 4)) && (!stopHautGauche)) {
					stopBasDroite = true;
				}
			}

		//Si obligation de manger, suppression des cases ou on ne mange pas
			if (!obligationDeManger) {
				enumCases = casesLibres;
			}
		}

		//Si case blanche
		if (this.quellePiece(pX, pY) == 6) {
			System.out.println("Case blanche selectionnee!");
		}

		return enumCases;
	}

	/**
	*Permet de deplacer la Piece current
	*@param newC Nouvelle coordonnee de sa colonne
	*@param newL Nouvelle coordonnee de sa ligne
	*@return La Piece supprimee au passage
	*/
	public Piece deplacerVers(int newC, int newL) {
		Piece pieceSupprimee = null;
		int x;
		int y;
		ArrayList<Piece> enumCases = this.casesPossibles(this.current);
		Piece temp;

		//Verifie d'abord si enumCases est vide ou pas
		if (!(enumCases.isEmpty())) {

			//Recupere tout les elements de enumCases et verifie si la nouvelle case en fait partie
			for (int i = 0; i < enumCases.size(); i++) {
				temp = enumCases.get(i);
				if ((newC == temp.getColonne()) && (newL == temp.getLigne())) {

					//Verifie d'abord et supprime les pieces mangees
					if (newL > this.currentY) { //Si la Piece monte
						if (newC < this.currentX) { //Si la Piece monte vers la gauche
							x = newC + 1;
							y = this.currentY + 1;

							while ((x < this.currentX) && (y < newL)) {
								pieceSupprimee = supprPiece(x, y);
								x = x + 1;
								y = y + 1;
							}
						}
						if (newC > this.currentX) { //Si la Piece monte vers la droite
							x = this.currentX + 1;
							y = this.currentY + 1;

							while ((x < newC) && (y < newL)) {
								pieceSupprimee = supprPiece(x, y);
								x = x + 1;
								y = y + 1;
							}
						}
					}

					if (newL < this.currentY) { //Si la Piece descend
						if (newC < this.currentX) { //Si la Piece descend vers la gauche
							x = newC + 1;
							y = newL + 1;

							while ((x < this.currentX) && (y < this.currentY)) {
								pieceSupprimee = supprPiece(x, y);
								x = x + 1;
								y = y + 1;
							}
						}
						if (newC > this.currentX) { //Si la Piece descend vers la droite
							x = this.currentX + 1;
							y = newL + 1;

							while ((x < newC) && (y < this.currentY)) {
								pieceSupprimee = supprPiece(x, y);
								x = x + 1;
								y = y + 1;
							}
						}
					}

					//Deplace finalement la Piece
					this.tabCases[newC][newL] = new Piece(newC, newL, this.current.etat(), this.current.isDame());
					this.tabCases[this.currentX][this.currentY] = new Piece(this.currentX, this.currentY, 0, false);

					//Verifie si promotion ou pas en Dame
					if ((newL == this.nombreCases - 1) && (this.current.etat() == 1)) {
						this.promotion(newC, newL);
					}
					if ((newL == 0) && (this.current.etat() == 2)) {
						this.promotion(newC, newL);
					}
				}
			}
		}

		return pieceSupprimee;
	}

	/**
	*Permet d'afficher en terminal les cases possibles
	*@param p La piece duquel on affichera toutes les cases de deplacements possibles
	*/
	public void afficheCasesPossibles(Piece p) {
		Piece tmp;
		ArrayList<Piece> temp;
		temp = this.casesPossibles(p);
		System.out.println("\n" + "Les cases possibles de deplacement sont:");

		if (temp.isEmpty()) {
			System.out.println("Aucune case possible. Veuillez choisir un autre pion.");
		}
		else {
			for (int i = 0; i < temp.size(); i++) {
				tmp = temp.get(i);
				System.out.println(tmp.toString());
			}
		}
	}

	/**
	*Permet de supprimer la Piece
	*@param c Colonne de la Piece a supprimer
	*@param l Ligne de la Piece a supprimer
	*@return La piece supprimee
	*/
	public Piece supprPiece(int c, int l) {
		Piece ret = this.tabCases[c][l];
		this.tabCases[c][l] = new Piece(c, l, 0, false);
		return ret;
	}

	/**
	*Permet de transformer un Pion en Dame
	*@param c Colonne de la Piece a transformer
	*@param l Ligne de la Piece a transformer
	*/
	public void promotion(int c, int l) {
		this.tabCases[c][l] = new Piece(c, l, this.tabCases[c][l].etat(), true);
	}

	/**
	*Accesseur pour la taille du damier
	*@return La taille du tableau
	*/
	public int getTaille() {
		return this.nombreCases;
	}

	/**
	*Permet de savoir quelles pieces sont deplacables
	*@param couleurPiece 1 si les pieces deplacables sont les blanches, 2 si ce sont les noires
	*@return Une liste des pieces actuellement deplacables
	*/
	public ArrayList<Piece> deplacable(int couleurPiece) {
		ArrayList<Piece> ret = new ArrayList<Piece>();
		ArrayList<Piece> casePossibles;

		//Si ce sont les pieces blanches
		if (couleurPiece == 1) {

			//Parcours du plateau
			for (int i = 0; i < this.nombreCases; i++) {
				for (int j = 0; j < this.nombreCases; j++) {

					//Si la piece est un pion blanc ou une dame blanche
					if ((this.quellePiece(i, j) == 1) || (this.quellePiece(i, j) == 3)) {

						//Verifie si la piece en question peut etre deplacee quelque part sur le plateau
						casePossibles = this.casesPossibles(this.tabCases[i][j]);

						//Si la pice peut etre deplacee, on l'ajoute
						if (!(casePossibles.isEmpty())) {
							ret.add(this.tabCases[i][j]);
						}
					}
				}
			}
		}

		//Si ce sont les pieces noires
		if (couleurPiece == 2) {

			//Parcours du plateau
			for (int i = 0; i < this.nombreCases; i++) {
				for (int j = 0; j < this.nombreCases; j++) {

					//Si la piece est un pion blanc ou une dame blanche
					if ((this.quellePiece(i, j) == 2) || (this.quellePiece(i, j) == 4)) {

						//Verifie si la piece en question peut etre deplacee quelque part sur le plateau
						casePossibles = this.casesPossibles(this.tabCases[i][j]);

						//Si la pice peut etre deplacee, on l'ajoute
						if (!(casePossibles.isEmpty())) {
							ret.add(this.tabCases[i][j]);
						}
					}
				}
			}
		}

		return ret;
	}
}
