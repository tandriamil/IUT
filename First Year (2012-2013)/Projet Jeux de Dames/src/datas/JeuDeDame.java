package pda.datas;

import java.io.*;

/**
*Classe principale pour le jeux entier
*/
public class JeuDeDame implements Serializable {
//Attributs
	private int tailleDamier;
	private Damier damier;
	private Partie partieCourante;
	private Humain humain;
	private Ordinateur ia;
	private String nomJoueur;
	private int couleurHumain;

	//Pour eviter un warning
	private static final long serialVersionUID = 1;

//Methodes
	/**
	*Constructeur de la classe JeuDeDame
	*/
	public JeuDeDame() {
		this.tailleDamier = 10;
		this.couleurHumain = 1;
	}

	/**
	*Permet la creation d'une nouvelle sauvegarde
	*/
	public void sauvegarderPartie() throws FileNotFoundException, IOException {
		FileOutputStream out = null;
		ObjectOutputStream fluxSortie = null;

		out = new FileOutputStream("svg.jdd"); //Creer le fichier de sortie
		System.out.println("Fichier de sortie svg.jdd correctement cree.");

		fluxSortie = new ObjectOutputStream(out);
		fluxSortie.writeObject(this);
		fluxSortie.close();
		System.out.println("Sauvegarde effectuee avec succes.");
	}

	/**
	*Permet de charger une partie
	*@return Le Jeu de Dame enregistre
	*/
	public JeuDeDame chargerPartie() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream in = null;
		ObjectInputStream fluxEntree = null;
		JeuDeDame ret = null;


		in = new FileInputStream("svg.jdd");
		System.out.println("Fichier de sauvegarde svg.jdd trouvee.");

		fluxEntree = new ObjectInputStream(in);
		ret = (JeuDeDame)fluxEntree.readObject();
		fluxEntree.close();
		System.out.println("Chargement effectuee avec succes.");

		return ret;
	}

	/**
	*Permet de creer une nouvelle partie
	*/
	public void creerNouvellePartie() {
		//Creation du damier
		this.damier = new Damier(this.tailleDamier);
		System.out.println("Plateau initial:" + "\n" + this.damier.toString());

		//Creation du joueur humain
		this.humain = new Humain(this.nomJoueur, this.couleurHumain);

		//Creation de l'IA
		if (this.couleurHumain == 1) {
			this.ia = new Ordinateur(this.damier, 2);
		}
		else {
			this.ia = new Ordinateur(this.damier, 1);
		}

		//Creation de la Partie
		if (this.tailleDamier == 8) {
			this.partieCourante = new Partie(this.damier, this.humain, this.ia, 24);
		}
		if (this.tailleDamier == 10) {
			this.partieCourante = new Partie(this.damier, this.humain, this.ia, 40);
		}
		if (this.tailleDamier == 12) {
			this.partieCourante = new Partie(this.damier, this.humain, this.ia, 60);
		}
	}

	/**
	*Permet de configurer les parametres de la partie
	*@param taille Taille du damier a configurer
	*/
	public void configurerTaille(int taille) {
		this.tailleDamier = taille;
	}

	/**
	*Permet de configurer les parametres de la partie
	*@param color Couleur des jetons de l'humain
	*/
	public void configurerCouleurJetonsHumain(int color) {
		this.couleurHumain = color;
	}

	/**
	*Permet de configurer les parametres de la partie
	*@param name Nom donne a l'humain
	*/
	public void setNom(String name) {
		this.nomJoueur = name;
	}

	/**
	*Accesseur de la taille du damier
	*@return La taille du damier
	*/
	public int getTaille() {
		return this.tailleDamier;
	}

	/**
	*Accesseur de la partie courante
	*@return La partie courante
	*/
	public Partie getPartieCourante() {
		return this.partieCourante;
	}

	/**
	*Accesseur du damier
	*@return Le damier du jeu en cours
	*/
	public Damier getDamier() {
		return this.damier;
	}
}
