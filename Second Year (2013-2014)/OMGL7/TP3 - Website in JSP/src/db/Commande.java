package db;
/**
* @author Andriamilanto Tompoariniaina - Canno Camille - Info2B
*/

/**
* Classe pour les objets Commande
*/
public class Commande {
	private int numeroCommande;
	private String clientCommande;
	private String titreCommande;
	private int total;
	 
	/**
	* Constructeur de la classe Commande
	*/
	public Commande() {}
	  
	/**
	* Méthode qui initialise les attributs de l'objet Commande
	*/
	public void init(int numCo, String cliCo, String titCo, int tot) {
		this.numeroCommande = numCo;
		this.clientCommande = cliCo;
		this.titreCommande = titCo;
		this.total = total;
	}
	  
	/**
	* Accesseur de l'objet
	* @return numeroCommande
	*/
	public int getNumeroCommande() {
		return this.numeroCommande;
	}
	   
	/**
	* Modificateur de l'objet
	*/
	public void setNumeroCommande(int numCo) {
		this.numeroCommande = numCo;
	}
	   
	/**
	* Accesseur de l'objet
	* @return clientCommande
	*/
	public String getClientCommande() {
		return this.clientCommande;
	}
		
	/**
	* Modificateur de l'objet
	*/
	public void setClientCommande(String cliCo){
		this.clientCommande = cliCo;
	}
		
	/**
	* Accesseur de l'objet
	* @return titreCommande
	*/
	public String getTitreCommande(){
		return this.titreCommande;
	}
	   
	/**
	* Modificateur de l'objet
	*/
	public void setTitreCommande(String titCo){
		this.titreCommande = titCo;
	}
	   
	/**
	* Accesseur de l'objet
	* @return total
	*/
	public int getTotal(){
		return this.total;
	}

	/**
	* Modificateur de l'objet
	*/
	public void setTotal(int tot){
		this.total = tot;
	}
}