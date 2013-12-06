package datas;
import java.io.*;
import java.util.*;

/**
*Classe permettant d'instancier les Dates a ajouter aux informations des Personnes
*/
public class Personne {
//Attributs
	private String nom;
	private double poids;
	private Date dateNaissance;

//Methodes
	/**
	*Constructeur
	*@param unNom Nom du contact
	*@param unPoids Poids du contact
	*@param uneDate Date de naissance du contact
	*/
	public Personne(String unNom, double unPoids, Date uneDate) {
		this.nom = unNom;
		this.poids = unPoids;
		this.dateNaissance = uneDate;
	}


	/**
	*Permet d'afficher les informations du contact
	*@return Retourne un affichage correct des informatios du contact
	*/
	public String toString() {
		return "Nom: " + this.nom + '\n' + "Date de Naissance: " + this.dateNaissance.toString() + '\n' + "Poids: " + this.poids;
	}


	/**
	*Permet de lire un fichier binaire contenant un objet Personne et d'en retirer les informations
	*@return Retourne un objet de type Personne
	*/
	public Personne lireBin() {
		Personne ret = null; //La valeur de retour
		FileInputStream in = null; //Fichier en entree
		DataInputStream flux = null; //Flux en entree
		int j, m, a; //Les entiers de la date en format jj/mm/aaaa
		double weight; //Le poids
		String name; //Le nom

		try {
			in = new FileInputStream("personne.bin");
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Fichier non trouvé!");
		}


		try {
			flux = new DataInputStream(in); //Lecture du flux en entree
			j = flux.readInt(); //Lecture du jour
			m = flux.readInt(); //Lecture du mois
			a = flux.readInt(); //Lecture de l'annee
			name = flux.readUTF(); //Lecture du nom => UTF
			weight = flux.readDouble(); //Lecture du poids

			@SuppressWarnings("deprecation")
			Date d = new Date(j, m, a); //Creation de l'objet Date avec le jour, le mois et l'annee
			ret = new Personne(name, weight, d); //Creation de l'objet Personne

			in.close(); //Ferme le flux en entree
		}
		catch (IOException ioe) {
			System.out.println("Probleme lors de la lecture du flux en entree!");
		}

		return ret;
	}
}