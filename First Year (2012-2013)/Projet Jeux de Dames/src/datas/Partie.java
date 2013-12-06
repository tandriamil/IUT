package pda.datas;

import java.util.*;
import java.io.*;

/**
*Classe pour le deroulement d'une partie
*/
public class Partie implements Serializable {
//Attributs
	private Damier damier;
	private String gagnant;
	private String perdant;
	private int nbPiecesDepart;
	private int nbPiecesHumain;
	private int nbPiecesIA;
	private ArrayList<Coup> historiqueCoups;
	private Coup coupCourant;
	private Humain humain;
	private Ordinateur ia;
	private boolean fini;
	private int tour;

	//Pour eviter un warning
	private static final long serialVersionUID = 1;
	
	//Methodes
	/**
	*Constructeur de la classe
	*@param damier1 Le damier de la partie en cours
	*@param joueur1 Le Joueur1 forcement humain
	*@param joueur2 Le Joueur2 forcement ia
	*@param nbPiecesDepart Le nombre de pieces dans la partie en cours
	**/
	public Partie (Damier damier1, Humain joueur1, Ordinateur joueur2, int nbPiecesDepart) {
		//Creation de la partie et de ses attributs
		this.damier = damier1;
		this.humain = joueur1;
		this.ia = joueur2;
		this.nbPiecesDepart = nbPiecesDepart;
		this.historiqueCoups = new ArrayList<Coup>();
		this.fini = false;
		System.out.println("\n" + "Partie entre " + this.humain.getNom() + " et " + this.ia.getNom() + " avec " + this.damier.getTaille() + " cases et " + this.nbPiecesDepart + " pieces de depart.");

		//Demarre la partie en meme temps
		this.demarrer();
	}
	
	/**
	*Permet de commencer la partie
	**/
	private void demarrer() {
		this.fini = false;
		this.nbPiecesHumain = this.nbPiecesDepart / 2;
		this.nbPiecesIA = this.nbPiecesDepart / 2;

		if (this.humain.getCouleur() == 1) {
			this.tour = 1;
			System.out.println(this.humain.getNom() + " demarre la partie.");
		}
		else {
			this.tour = 2;
			System.out.println(this.ia.getNom() + " demarre la partie.");
		}
	}
	
	/**
	*Permet de verifier si la partie est finie ou non
	**/
	public void checkFin() {
		boolean ret = false;

		//Qui a gagne, qui a perdu?
		if (this.nbPiecesHumain == 0) {
			this.gagnant = this.ia.getNom();
			this.perdant = this.humain.getNom();
			ret = true;
		}
		if (this.nbPiecesIA == 0) {
			this.gagnant = this.humain.getNom();
			this.perdant = this.ia.getNom();
			ret = true;
		}

		this.fini = ret;
	}
	
	/**
	*Permet de jouer un tour
	*@return true si mouvement possible, false sinon
	**/
	public boolean jouerUnTour(Piece current, Piece next) {
		boolean ret = false;

		if (this.damier.setCurrent(current)) {
			if (this.damier.casesPossibles(current).contains(next)) {
				Piece debut = this.damier.getCurrent();
				Piece suppr = this.damier.deplacerVers(next.getColonne(), next.getLigne());

				if (suppr != null) {
					if (suppr.etat() == this.humain.getCouleur()) {
						this.nbPiecesHumain = this.nbPiecesHumain - 1;
					}
					if (suppr.etat() == this.ia.getCouleur()) {
						this.nbPiecesIA = this.nbPiecesIA - 1;
					}
				}

				Coup temp = new Coup(debut, next, suppr);

				this.coupCourant = temp;
				this.ajouterUnCoup();

				ret = true;
			}
		}

		this.checkFin();

		return ret;
	}
	
	/**
	*Permet d'ajouter le coup courant a l'historique
	**/
	private void ajouterUnCoup() {
		this.historiqueCoups.add(this.coupCourant);
	}
	
	/**
	*Permet d'afficher la partie en cours et son etat
	**/
	public void afficherEtatCourant() {
		String ret = this.damier.toString() + "\n";
		System.out.println(ret);
	}

	/**
	*Accesseur du score de l'humain
	*@return Le score du joueur humain
	*/
	public int getScoreHumain() {
		return this.nbPiecesHumain;
	}

	/**
	*Accesseur du score de l'ordinateur
	*@return Le score de l'ordinateur
	*/
	public int getScoreOrdi() {
		return this.nbPiecesIA;
	}

	/**
	*Accesseur de la fin de partie
	*@return true si la partie est finie, false sinon
	*/
	public boolean isFini() {
		return this.fini;
	}

	public int getTour() {
		return this.tour;
	}

	public void setTour(int i) {
		this.tour = i;
	}

	public Damier getDamier() {
		return this.damier;
	}

	public boolean tourIA() {
		boolean ret = false;

		Piece debut = this.ia.choixPiece();
		Piece next = this.ia.choixCase(debut);
		if (this.jouerUnTour(debut, next)) {
			ret = true;
		}

		return ret;
	}

	public Coup getCoupCourant() {
		return this.coupCourant;
	}
}