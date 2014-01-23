package pda.datas;

import java.io.*;

/**
*Classe pour les Joueurs (IA et Humain)
*/
public abstract class Joueur implements Serializable {
//Attributs
	protected String nom;
	protected int couleur;
	protected boolean sonTour;

	//Pour eviter un warning
	private static final long serialVersionUID = 1;
	
//Methodes
	/**
	*Constructeur de la classe Joueur
	*@param name Le nom du joueur
	*@param color La couleur des pieces du joueur
	**/
	public Joueur(String name, int color) {
		this.nom = name;
		this.couleur = color;
		this.sonTour = false;
	}

	/**
	*Accesseur pour la couleur
	*@return 1 si blanc, 2 si noir
	*/
	public int getCouleur() {
		return this.couleur;
	}

	/**
	*Accesseur pour le nom
	*@return Le nom du joueur (IA ou Humain)
	*/
	public String getNom() {
		return this.nom;
	}
}