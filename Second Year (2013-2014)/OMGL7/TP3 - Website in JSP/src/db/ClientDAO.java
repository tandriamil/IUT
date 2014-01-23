package db;

import java.sql.*;
/**
* @author Andriamilanto Tompoariniaina - Canno Camille - Info2B
*/

/**
* Classe pour les objets DAO de Client
*/
public class ClientDAO {
//Methodes
	/**
	*Constructeur
	*/
	public ClientDAO() {}

	/**
	*Pour retrouver tous les tuples
	*/
	public ResultSet findAll() {
		Statement stat = null;
		String query = "";
		ResultSet ret = null;

		try {
			//Recuperation de la connexion
			Connection con = MySQLConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM Client;";

			//Le resultat a retourner
			ret = stat.executeQuery(query);
		}
		catch (SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		//Retourne l'execution de la requete sous la forme d'un objet ResultSet
		return ret;
	}

	/**
	*Permet de retrouver juste un tuple
	*@param id idClient du client a retrouver
	*/
	public Client find(String login) {
		Statement stat = null;
		String query = "";
		Client ret = new Client();

		try {
			//Recuperation de la connexion
			Connection con = MySQLConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM Client WHERE Login = " + login + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			//Si le resultat est bon, prends la premiere ligne
			if (result.first()) {
				ret.init(login, result.getString(2), result.getString(3), result.getString(4), result.getDate(5), result.getString(6), result.getString(7), result.getInt(8), result.getString(9), result.getInt(10));
			}
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}


	/**
    *Methode qui permet d'inserer un tuple
    *@param tuple Objet de type Client a inserer
    */
    public void insert(Client tuple) {
    	Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Client
        String login = tuple.getLogin();
        String passwd = tuple.getPassword();
        String nom = tuple.getNom();
        String prenom = tuple.getPrenom();
        Date ddn = tuple.getDateDeNaissance();
        String email = tuple.getEmail();
        String adresse = tuple.getAdresse();
        int codePostal = tuple.getCodePostal();
        String ville = tuple.getVille();
        int idP = tuple.getIdPays();

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "INSERT INTO Client VALUES(" + login + "," + passwd + "," + nom + "," + prenom + "," + ddn + "," + email + "," + adresse + "," + codePostal + "," + ville + "," + idP + ");";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }


    /**
    * Permet de faire la mise a jour d'un tuple
    *@param tuple Objet nouveau a mettre a la place de l'ancien
    */
    public void update(Client tuple) {
    	Statement stat = null;
        String query = "";

       	//Recuperation des attributs de l'objet Client
        String login = tuple.getLogin();
        String passwd = tuple.getPassword();
        String nom = tuple.getNom();
        String prenom = tuple.getPrenom();
        Date ddn = tuple.getDateDeNaissance();
        String email = tuple.getEmail();
        String adresse = tuple.getAdresse();
        int codePostal = tuple.getCodePostal();
        String ville = tuple.getVille();
        int idP = tuple.getIdPays();

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "UPDATE Client SET Password = " + passwd + ", Nom = " + nom + ", Prenom = " + prenom + ", DateDeNaissance = " + ddn + ", Email = " + email + ", Adresse = " + adresse + ", CodePostal = " + codePostal + ", Ville = " + ville + ", IdPays = " + idP + " WHERE Login = " + login + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }


    /**
    * Permet de supprimer un tuple
    *@param idclient id du tuple a supprimer
    */
    public void delete(String login) {
    	Statement stat = null;
        String query = "";

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "DELETE FROM Client WHERE Login = " + login + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }
}
