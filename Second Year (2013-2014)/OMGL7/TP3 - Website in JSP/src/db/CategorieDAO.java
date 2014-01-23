package db;

import java.sql.*;
import java.util.ArrayList;
/**
* @author Andriamilanto Tompoariniaina - Canno Camille - Info2B
*/

/**
* Classe pour les objets DAO de Categorie
*/
public class CategorieDAO {
//Methodes
	/**
	*Constructeur
	*/
	public CategorieDAO() {}

	/**
	*Pour retrouver tous les tuples
	*/
	public ArrayList<Categorie> findAll() {
		Statement stat = null;
		String query = "";
		ArrayList<Categorie> ret = new ArrayList<Categorie>();

		try {
			//Recuperation de la connexion
			Connection con = MySQLConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM Categorie;";

			//Le resultat a retourner
			ResultSet res = stat.executeQuery(query);

			//Mettre le resultat de chacun des tuples de la requete sous la forme d'un Array
			while (res.next()) {
				Categorie cat = new Categorie();
				cat.init(res.getInt(1), res.getString(2));
				ret.add(cat);
			}
		}
		catch (SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		//Retourne l'execution de la requete sous la forme d'un objet ResultSet
		return ret;
	}

	/**
	*Permet de retrouver juste un tuple
	*@param id idCategorie de la categorie a retrouver
	*/
	public Categorie find(int id) {
		Statement stat = null;
		String query = "";
		Categorie ret = new Categorie();

		try {
			//Recuperation de la connexion
			Connection con = MySQLConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM Categorie WHERE IdCategorie = " + id + ";";

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
    *@param tuple Objet de type Categorie a inserer
    */
    public void insert(Categorie tuple) {
    	Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Categorie
        int idC = tuple.getIdCategorie();
        String lib = tuple.getLibelleCategorie();

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "INSERT INTO Categorie VALUES(" + idC + "," + lib + ");";

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
    public void update(Categorie tuple) {
    	Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Categorie
        int idC = tuple.getIdCategorie();
        String lib = tuple.getLibelleCategorie();

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "UPDATE Categorie SET LibelleCategorie = " + lib + " WHERE IdCategorie = " + idC + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }


    /**
    * Permet de supprimer un tuple
    *@param idCategorie Id du tuple a supprimer
    */
    public void delete(int idCategorie) {
    	Statement stat = null;
        String query = "";

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "DELETE FROM Categorie WHERE IdCategorie = " + idCategorie + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }
}
