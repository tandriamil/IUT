package datas;
import java.io.*;
import java.util.*;

/**
*Classe Annuaire contenant les Fiches
*<BR>Les exceptions sont a gerer dans les classes de tests
*/
public class Annuaire implements Serializable {
//Attributs
	private Hashtable <String, Fiche> tabFiche;

	//Pour eviter un warning
	private static final long serialVersionUID = 1;


//Methodes
	/**
	*Constructeur de la classe Annuaire
	*/
	public Annuaire() {
		this.tabFiche = new Hashtable <String, Fiche>();
	}


	/**
	*Permet d'ajouter a l'annuaire une Fiche dont on fournit la cle.
	*@param cle Cle d'identification (UNIQUE!) de la fiche
	*@param personne Fiche a rajouter a l'Annuaire
	*/
	public void ajouter(String cle, Fiche personne) throws IllegalArgumentException, Exception {
		//Si la cle est deja presente
		if (this.tabFiche.containsKey(cle)) {
			throw new Exception("ERREUR: Cle deja presente dans l'Annuaire!");
		}

		//Si la cle est non valide (null)
		if (cle == null) {
			throw new IllegalArgumentException("ERREUR: Cle nulle!");
		}

		//Si la Fiche est non valide (null)
		if (personne == null) {
			throw new IllegalArgumentException("ERREUR: Fiche nulle!");
		}

		//Si tout est correct, sans exception
		else {
			this.tabFiche.put(cle, personne);
		}
	}


	/**
	*Permet d'enlever de l'Annuaire la Fiche correspondant a la cle
	*@param cle Clef d'identification (UNIQUE!) de la Fiche a supprimer
	*/
	public void supprimer(String cle) throws IllegalArgumentException, NoSuchElementException {
		//Si la cle est non valide (null)
		if (cle == null) {
			throw new IllegalArgumentException("ERREUR: Cle nulle!");
		}

		//Si la cle n'est pas presente
		if (this.tabFiche.containsKey(cle) == false) {
			throw new NoSuchElementException("ERREUR: Cle non presente dans l'Annuaire!");
		}

		//Si tout est correct, sans exception
		else {
			this.tabFiche.remove(cle);
		}
	}


	/**
	*Permet de savoir si une cle est presente dans l'Annuaire
	*@param cle Clef d'identification (UNIQUE!) de la Fiche a verifier
	*@return true si la Fiche est presente dans l'Annuaire
	*/
	public boolean existe(String cle) {
		return this.tabFiche.containsKey(cle);
	}


	/**
	*Permet de renvoyer l'ensemble des cles de l'Annuaire
	*/
	public Enumeration<String> cles() {
		return this.tabFiche.keys();
	}


	/**
	*Permet de connaitre la taille du dictionnaire Annuaire
	*@return La taille de l'Annuaire, le nombre de cles autrement dit
	*/
	public int taille() {
		return this.tabFiche.size();
	}


	/**
	*Permet de consulter la Fiche correspondant a la cle
	*@param cle Cle de la Fiche a consulter
	*@return La Fiche correspondant a la cle, null si aucune valeur correspond a la cle
	*/
	public Fiche consulter(String cle) throws IllegalArgumentException {
		Fiche ret = null;

		//Verif si cle non nulle
		if (cle == null) {
			throw new IllegalArgumentException("Cle nulle!");
		}
		else {
			ret = this.tabFiche.get(cle);
		}

		return ret;
	}


	/**
	*Remplace une Fiche par une autre. Elles auront donc la meme cle.
	*@param cle Valeur de la cle de la Fiche remplacee et remplacante
	*@param newFiche Fiche remplacante
	*/
	public void modifier(String cle, Fiche newFiche) throws IllegalArgumentException, NoSuchElementException {
		//Verif si cle non nulle
		if (cle == null) {
			throw new IllegalArgumentException("Cle nulle!");
		}

		//verif si cle presente dans l'Annuaire
		if (this.tabFiche.containsKey(cle) == false) {
			throw new NoSuchElementException("Cle non presente dans l'Annuaire!");
		}

		//Si la cle est non null et presente dans l'Annuaire
		else {
			this.tabFiche.put(cle, newFiche);
		}
	}


	/**
	*Permet de sauvegarder l'Annuaire dans le fichier "annuaire.out"
	*/
	public void sauver() {
		FileOutputStream out = null;
		ObjectOutputStream fluxSortie = null;

		try {
			out = new FileOutputStream("annuaire.out"); //Creer le fichier de sortie
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Fichier pour l'ecriture non trouve!");
		}

		try {
			fluxSortie = new ObjectOutputStream(out);
			fluxSortie.writeObject(this);
			fluxSortie.close();
		}
		catch (IOException ioe) {
			System.out.println("Probleme lors de la lecture du flux en sortie!");
		}
	}


	/**
	*Permet de charger l'Annuaire a partir d'un fichier "annuaire.out"
	*@return Retourne l'Annuaire sauvegarde dans "annuaire.out"
	*/
	public Annuaire charger() {
		FileInputStream in = null;
		ObjectInputStream fluxEntree = null;
		Annuaire ret = null;

		try {
			in = new FileInputStream("annuaire.out");
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Fichier pour le chargement non trouve!");
		}

		try {
			fluxEntree = new ObjectInputStream(in);
			ret = (Annuaire)fluxEntree.readObject();
			fluxEntree.close();
		}
		catch (IOException ioe) {
			System.out.println("Probleme lors de la lecture du flux en entree!");
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println("Classe Annuaire non trouvee!");
		}

		return ret;
	}


	/**
	*Permet d'afficher les Fiches de l'Annuaire
	*/
	public String toString() {
		return this.tabFiche.toString();
	}

}
