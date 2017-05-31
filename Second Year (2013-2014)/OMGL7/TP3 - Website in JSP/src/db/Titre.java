package db;
/**
*@author Andriamilanto Tompoariniaina - Canno Camille - Info 2 B
*/

/**
*Classe pour les objets Titre
*/
public class Titre {
//Attributs
	private int idTitre;
	private String libelle;
	private float prix;
	private String artiste;
	private int titreAlbum;
	private int titreCategorie;

//Methodes
	/**
	*Constructeur
	*/
	public Titre() {}

	/**
	*Methode pour initialiser les attributs
	*/
	public void init(int idti, String lib, float price, String art, int titreAl, int titreCat) {
		this.idTitre = idti;
		this.libelle = lib;
		this.prix = price;
		this.artiste = art;
		this.titreCategorie = titreCat;
		this.titreAlbum = titreAl;
	}

//Accesseurs
	public void setIdTitre(int idti) {
		this.idTitre = idti;
	}

	public int getIdTitre() {
		return this.idTitre;
	}

	public void setLibelle(String lib) {
		this.libelle = lib;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setPrix(float price) {
		this.prix = price;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setArtiste(String art) {
		this.artiste = art;
	}

	public String getArtiste() {
		return this.artiste;
	}

	public void setTitreAlbum(int title) {
		this.titreAlbum = title;
	}

	public int getTitreAlbum() {
		return this.titreAlbum;
	}

	public void setTitreCategorie(int tit) {
		this.titreCategorie = tit;
	}

	public int getTitreCategorie() {
		return this.titreCategorie;
	}
}
