package db;
/**
* @author Andriamilanto Tompoariniaina - Canno Camille - Info2B
*/

/**
* Classe pour les objets Pays
*/
public class Pays{
//Attributs
	private int idPays;
	private String nom;
	 
	/**
	*Constructeur de la classe Pays
	*/
	public Pays(){}
	  
	/**
	* Méthode qui initialise les attributs de l'objet Pays
	*/
	public void init(int idp, String name){
		this.idPays = idp;
		this.nom = name;
	}
	  
	/**
	* Accesseur de l'objet
	* @return IdPays
	*/
	public int getIdPays(){
		return this.idPays;
	}
	   
	/**
	* Modificateur de l'objet
	*/
	public void setIdPays(int idp){
		this.idPays = idp;
	}
	   
	/**
	* Accesseur de l'objet
	* @return nom
	*/
	public String getNom(){
		return this.nom;
	}
		
	/**
	* Modificateur de l'objet
	*/
	public void setNom(String name){
		this.nom = name;
	}
}