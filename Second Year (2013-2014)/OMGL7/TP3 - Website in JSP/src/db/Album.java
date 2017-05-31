package db;
/**
*@author Andriamilanto Tompoariniaina - Canno Camille - Info 2 B
*/

/**
*Classe pour les objets Album
*/
public class Album {
//Attributs
  private int idAlbum;
  private String libelleAlbum;

//Methodes
  /**
  *Constructeur
  */
  public Album() {}

  /**
  *Methode pour initialiser les attributs
  */
  public void init(int idA, String lib) {
    this.idAlbum = idA;
    this.libelleAlbum = lib;
  }

//Accesseurs
  public void setIdAlbum(int idA) {
    this.idAlbum = idA;
  }

  public int getIdAlbum() {
    return this.idAlbum;
  }

  public void setLibelleAlbum(String libA) {
    this.libelleAlbum = libA;
  }

  public String getLibelleAlbum() {
    return this.libelleAlbum;
  }
}
