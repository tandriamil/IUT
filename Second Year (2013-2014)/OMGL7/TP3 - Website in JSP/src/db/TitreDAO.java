package db;

import java.sql.*;
/**
* @author Andriamilanto Tompoariniaina - Canno Camille - Info2B
*/

/**
* Classe pour les objets DAO de Titre
*/
public class TitreDAO {
//Methodes
	/**
	*Constructeur
	*/
	public TitreDAO() {}

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
			query = "SELECT * FROM Titre;";

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
	*@param id idTitre du titre a retrouver
	*/
	public Titre find(int id) {
		Statement stat = null;
		String query = "";
		Titre ret = new Titre();

		try {
			//Recuperation de la connexion
			Connection con = MySQLConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM Titre WHERE idTitre = " + id + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			//Si le resultat est bon, prends la premiere ligne
			if (result.first()) {
				ret.init(id, result.getString(2), result.getFloat(3), result.getString(4), result.getInt(5), result.getInt(6));
			}
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}


	/**
    *Methode qui permet d'inserer un tuple
    *@param tuple Objet de type Titre a inserer
    */
    public void insert(Titre tuple) {
    	Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Titre
        int idT = tuple.getIdTitre();
        String lib = tuple.getLibelle();
        float prix = tuple.getPrix();
        String artiste = tuple.getArtiste();
        int titreAlbum = tuple.getTitreAlbum();
        int titreCategorie = tuple.getTitreCategorie();

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "INSERT INTO Titre VALUES(" + idT + "," + lib + "," + prix + "," + artiste + "," + titreAlbum + "," + titreCategorie + ");";

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
    public void update(Titre tuple) {
    	Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Titre
        int idT = tuple.getIdTitre();
        String lib = tuple.getLibelle();
        float prix = tuple.getPrix();
        String artiste = tuple.getArtiste();
        int titreAlbum = tuple.getTitreAlbum();
        int titreCategorie = tuple.getTitreCategorie();


        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "UPDATE Titre SET Libelle = " + lib + ", Prix = " + prix + ", Artiste = " + artiste + ", TitreAlbum = " + titreAlbum + ", TitreCategorie = " + titreCategorie + " WHERE IdTitre = " + idT + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }


    /**
    * Permet de supprimer un tuple
    *@param idTitre Id du tuple a supprimer
    */
    public void delete(int idTitre) {
    	Statement stat = null;
        String query = "";

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "DELETE FROM Titre WHERE IdTitre = " + idTitre + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }
}
