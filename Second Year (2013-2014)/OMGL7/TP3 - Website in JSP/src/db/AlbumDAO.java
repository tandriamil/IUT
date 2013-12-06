package db;

import java.sql.*;
/**
* @author Andriamilanto Tompoariniaina - Canno Camille - Info2B
*/

/**
* Classe pour les objets DAO de Album
*/
public class AlbumDAO {
//Methodes
	/**
	*Constructeur
	*/
	public AlbumDAO() {}

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
			query = "SELECT * FROM Album;";

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
	*@param id idAlbum de l'album a retrouver
	*/
	public Album find(int id) {
		Statement stat = null;
		String query = "";
		Album ret = new Album();

		try {
			//Recuperation de la connexion
			Connection con = MySQLConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM Album WHERE idAlbum = " + id + ";";

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
    *@param tuple Objet de type Album a inserer
    */
    public void insert(Album tuple) {
    	Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Album
        int idA = tuple.getIdAlbum();
        String lib = tuple.getLibelleAlbum();

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "INSERT INTO Album VALUES(" + idA + "," + lib + ");";

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
    public void update(Album tuple) {
    	Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Album
        int idA = tuple.getIdAlbum();
        String lib = tuple.getLibelleAlbum();

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "UPDATE Album SET LibelleAlbum = " + lib + " WHERE IdAlbum = " + idA + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }


    /**
    * Permet de supprimer un tuple
    *@param idAlbum Id du tuple a supprimer
    */
    public void delete(int idAlbum) {
    	Statement stat = null;
        String query = "";

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "DELETE FROM Album WHERE IdAlbum = " + idAlbum + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }
}
