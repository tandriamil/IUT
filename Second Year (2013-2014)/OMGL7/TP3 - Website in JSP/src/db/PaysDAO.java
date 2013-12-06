package db;

import java.sql.*;
/**
* @author Andriamilanto Tompoariniaina - Canno Camille - Info2B
*/

/**
* Classe pour les objets DAO de Pays
*/
public class PaysDAO {
//Methodes
	/**
	*Constructeur
	*/
	public PaysDAO() {}

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
			query = "SELECT * FROM Pays;";

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
	*@param id idPays du pays a retrouver
	*/
	public Pays find(int id) {
		Statement stat = null;
		String query = "";
		Pays ret = new Pays();

		try {
			//Recuperation de la connexion
			Connection con = MySQLConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM Pays WHERE IdPays = " + id + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			//Si le resultat est bon, prends la premiere ligne
			if (result.first()) {
				ret.init(id, result.getString(2));
			}
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}


	/**
    *Methode qui permet d'inserer un tuple
    *@param tuple Objet de type Pays a inserer
    */
    public void insert(Pays tuple) {
    	Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Pays
        int idP = tuple.getIdPays();
        String lib = tuple.getNom();

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "INSERT INTO Pays VALUES(" + idP + "," + lib + ");";

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
    public void update(Pays tuple) {
    	Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Pays
        int idP = tuple.getIdPays();
        String lib = tuple.getNom();

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "UPDATE Pays SET Nom = " + lib + " WHERE IdPays = " + idP + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }


    /**
    * Permet de supprimer un tuple
    *@param idPays Id du tuple a supprimer
    */
    public void delete(int idPays) {
    	Statement stat = null;
        String query = "";

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "DELETE FROM Pays WHERE IdPays = " + idPays + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }
}
