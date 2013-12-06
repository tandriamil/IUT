package db;

//Importation necessaire pour l'objet Date
import java.sql.Date;
/**
*@author Andriamilanto Tompoariniaina - Canno Camille - Info 2 B
*/

/**
*Classe pour les objets Client
*/
public class Client {
//Attributs
  private String login;
  private String password;
  private String nom;
  private String prenom;
  private Date dateDeNaissance;
  private String email;
  private String adresse;
  private int codePostal;
  private String ville;
  private int idPays;

//Methodes
  /**
  *Constructeur
  */
  public Client() {}

  /**
  *Methode pour initialiser les attributs
  */
  public void init(String log, String passwd, String name, String surname, Date ddn, String mail, String adress, int codeP, String city, int idP) {
    this.login = log;
    this.password = passwd;
    this.nom = name;
    this.prenom = surname;
    this.dateDeNaissance = ddn;
    this.email = mail;
    this.adresse = adress;
    this.codePostal = codeP;
    this.ville = city;
    this.idPays = idP;
  }

//Accesseurs
  public void setLogin(String log) {
    this.login = log;
  }

  public String getLogin() {
    return this.login;
  }

  public void setPassword(String pswd) {
    this.password = pswd;
  }

  public String getPassword() {
    return this.password;
  }

  public void setNom(String name) {
    this.nom = name;
  }

  public String getNom() {
    return this.nom;
  }

  public void setPrenom(String pren) {
    this.prenom = pren;
  }

  public String getPrenom() {
    return this.prenom;
  }

  public void setDateDeNaissance(Date ddn) {
    this.dateDeNaissance = ddn;
  }

  public Date getDateDeNaissance() {
    return this.dateDeNaissance;
  }

  public void setEmail(String mail) {
    this.email = mail;
  }

  public String getEmail() {
    return this.email;
  }

  public void setAdresse(String adr) {
    this.adresse = adr;
  }

  public String getAdresse() {
    return this.adresse;
  }

  public void setCodePostal(int cp) {
    this.codePostal = cp;
  }

  public int getCodePostal() {
    return this.codePostal;
  }

  public void setVille(String city) {
    this.ville = city;
  }

  public String getVille() {
    return this.ville;
  }

  public void setIdPays(int idp) {
    this.idPays = idp;
  }

  public int getIdPays() {
    return this.idPays;
  }
}