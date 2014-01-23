package pda.datas;

import java.io.*;

/**
*Classe pour le joueur Humain
*/
public class Humain extends Joueur implements Serializable {
//Attributs
	//Pour eviter un warning
	private static final long serialVersionUID = 1;
	
//Methodes
	/**
	*Constructeur de la classe Humain
	*@param name Nom du joueur
	*@param color Couleur des Pieces du joueur
	*/
	public Humain(String name, int color) {
		super(name, color);
	}
}