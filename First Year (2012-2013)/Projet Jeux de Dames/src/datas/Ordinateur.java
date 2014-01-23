package pda.datas;

import java.util.*;
import java.io.*;

/**
*Classe pour l'IA
*/
public class Ordinateur extends Joueur implements Serializable {
//Attributs
	private Damier damier;
	//Pour eviter un warning
	private static final long serialVersionUID = 1;

//Methodes
	/**
	*Constructeur de la classe Ordinateur
	*@param unDamier Damier du jeux en cours
	*@param color Couleur des Pieces du joueur
	*/
	public Ordinateur (Damier unDamier, int color) {
		super("Ordinateur", color);
		this.damier = unDamier;
	}

	/**
	*Methode pour choisir la piece a bouger
	*@return La piece a bougee
	*/
	public Piece choixPiece() {
		//La piece a bougee (a retournee)
		Piece ret = null;

		//Un clone du damier pour eviter de modifier le damier en lui meme
		Damier clone = this.damier.clone();

		//Le compteur du nombre de pieces prises et la position de la piece la plus rentable
		int nbPiecePrises;
		int indexPiece;

		//L'incrementation pour savoir quelle piece est la plus rentable
		int max = 0;

		//Les pieces temporaires pour verifier la rentabilite
		Piece temp;
		Piece temp2;

		//Les pieces que l'on pourrait deplacer et leurs indices de rentabilites
		ArrayList<Piece> tabPiecesPossibles = new ArrayList<Piece>();
		ArrayList<Integer> tabNbPiecesPrises = new ArrayList<Integer>();

		//Les pieces deplacables
		ArrayList<Piece> choix = clone.deplacable(this.couleur);
		ArrayList<Piece> deplacementsPossibles;

		//Parcours des pieces deplacables
		for (int i = 0; i < choix.size(); i++) {
			nbPiecePrises = 0;
			temp = choix.get(i);

			//On regarde les deplacements que peut faire chage piece deplacable
			deplacementsPossibles = clone.casesPossibles(temp);

			//On parcours tout les deplacements possibles de chaque piece
			for (int j = 0; j < deplacementsPossibles.size(); j++) {
				temp2 = deplacementsPossibles.get(j);

				//Si la piece peut en manger d'autres, on augmente son nombre de pieces prises possibles
				if (!(clone.deplacerVers(temp2.getColonne(), temp2.getLigne()) != null)) {
					nbPiecePrises = nbPiecePrises + 1;
				}
			}

			//On ajoute ensuite toutes les pieces possibles et respectivement le nombre de pieces qu'elles peuvent manger
			tabPiecesPossibles.add(temp);
			tabNbPiecesPrises.add(nbPiecePrises);
		}

		//On parcours le tableau du nombre de pieces prises et on garde celle qui peut en manger le plus
		for (int l = 0; l < tabNbPiecesPrises.size(); l++) {
			if (tabNbPiecesPrises.get(l) >= max) {
				max = tabNbPiecesPrises.get(l);
			}
		}

		//On regarde a quelle position se trouve cette valeur max et la Piece correspondante est donc celle choisie
		indexPiece = tabNbPiecesPrises.indexOf(max);
		ret = tabPiecesPossibles.get(indexPiece);

		//Enfin, on retourne donc cette piece
		return ret;
	}

	/**
	*Methode pour savoir ou la bougee
	*@param p La piece a deplacee, appelee prealablement par choixPiece()
	*@return La case ou elle va allee
	*/
	public Piece choixCase(Piece p) {
		//La case ou la deplacee, a retournee
		Piece ret = null;

		//Un clone du damier pour eviter de le modifier
		Damier clone = this.damier.clone();

		//Un piece temporaire et si on peut manger une piece
		Piece temp;
		boolean peutManger = false;

		//Les cases ou la piece en question peut allee
		ArrayList<Piece> possibles = clone.casesPossibles(p);

		//Parcours des cases ou celle-ci peut allee
		for (int i = 0; i < possibles.size(); i++) {
			temp = possibles.get(i);

			//Si on peut mettre la piece en current
			if (clone.setCurrent(p)) {

				//Si on le deplace et qu'on peut manger une piece
				if (clone.deplacerVers(temp.getColonne(), temp.getLigne()) != null) {
					ret = temp;
					peutManger = true;
				}
			}
		}

		//Si aucune piece ne peut etre mangee, elle en prend une au hasard
		if (!peutManger) {
			int random = (int)(Math.random() * (possibles.size() - 1));
			ret = possibles.get(random);
		}

		//Retour de la valeur
		return ret;
	}
}