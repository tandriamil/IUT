package db;
/**
*@author Andriamilanto Tompoariniaina - Canno Camille - Info 2 B
*/

/**
*Classe pour les objets Categorie
*/
public class Categorie {
//Attributs
  private int idCategorie;
  private String libelleCategorie;

//Methodes
  /**
  *Constructeur
  */
  public Categorie() {}

  /**
  *Methode pour initialiser les attributs
  */
  public void init(int idC, String lib) {
    this.idCategorie = idC;
    this.libelleCategorie = lib;
  }

//Accesseurs
  public void setIdCategorie(int idC) {
    this.idCategorie = idC;
  }

  public int getIdCategorie() {
    return this.idCategorie;
  }

  public void setLibelleCategorie(String libC) {
    this.libelleCategorie = libC;
  }

  public String getLibelleCategorie() {
    return this.libelleCategorie;
  }
}
