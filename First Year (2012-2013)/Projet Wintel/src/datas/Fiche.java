package datas;


/**
*Classe contenant les informations d'un contact
*/
public class Fiche extends java.lang.Object implements java.io.Serializable {
//Attributs
	private String nom;
	private String prenom;
	private String numTel;

	//Juste pour eviter un warning
	private static final long serialVersionUID = 42;

//Methodes
	/**
	*Constructeur de la classe Fiche
	*@param leNom Le nom du contact
	*@param lePrenom Le prenom du contact
	*@param leNumero Le numero du contact
	*/
	public Fiche(String leNom, String lePrenom, String leNumero) {
		this.nom = leNom;
		this.prenom = lePrenom;
		this.numTel = leNumero;
	}


	/**
	*Accesseur du nom
	*@return Le nom
	*/
	public String getNom() {
		return this.nom;
	}


	/**
	*Accesseur du prenom
	*@return Le prenom
	*/
	public String getPrenom() {
		return this.prenom;
	}


	/**
	*Accesseur du numero de telephone
	*@return Le numero de telephone
	*/
	public String getNumTel() {
		return this.numTel;
	}


	/**
	*Permet d'afficher les infos du contact en ligne
	*@return Un affichage en ligne des infos du contact
	*/
	public String toString() {
		return "Nom: " + this.nom + '\n' + "Prenom: " + this.prenom + '\n' + "Numero de Telephone: " + this.numTel + '\n';
	}
}
