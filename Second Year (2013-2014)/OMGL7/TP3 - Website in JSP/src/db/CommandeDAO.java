package db;

import java.sql.*;
/**
* @author Andriamilanto Tompoariniaina - Canno Camille - Info2B
*/

/**
* Classe pour les objets DAO de Commande
*/
public class CommandeDAO {
//Methodes
	/**
	*Constructeur
	*/
	public CommandeDAO() {}

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
			query = "SELECT * FROM Commande;";

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
	*@param id idCommande de la commande a retrouver
	*/
	public Commande find(int numCommande) {
		Statement stat = null;
		String query = "";
		Commande ret = new Commande();

		try {
			//Recuperation de la connexion
			Connection con = MySQLConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM Commande WHERE NumeroCommande = " + numCommande + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			//Si le resultat est bon, prends la premiere ligne
			if (result.first()) {
				ret.init(numCommande, result.getString(2), result.getString(3), result.getInt(4));
			}
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}


	/**
    *Methode qui permet d'inserer un tuple
    *@param tuple Objet de type Commande a inserer
    */
    public void insert(Commande tuple) {
    	Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Commande
        int numCommande = tuple.getNumeroCommande();
        String clientCommande = tuple.getClientCommande();
        String titreCommande = tuple.getTitreCommande();
        int total = tuple.getTotal();

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "INSERT INTO Commande VALUES(" + numCommande + "," + clientCommande + "," + titreCommande + "," + total + ");";

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
    public void update(Commande tuple) {
    	Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Commande
        int numCommande = tuple.getNumeroCommande();
        String clientCommande = tuple.getClientCommande();
        String titreCommande = tuple.getTitreCommande();
        int total = tuple.getTotal();

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "UPDATE Commande SET ClientCommande = " + clientCommande + ", TitreCommande = " + titreCommande + ", Total = " + total + " WHERE NumeroCommande = " + numCommande + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }


    /**
    * Permet de supprimer un tuple
    *@param numCommande id du tuple a supprimer
    */
    public void delete(int numCommande) {
    	Statement stat = null;
        String query = "";

        try {
	    	//Recuperation de la connexion
	        Connection con = MySQLConnection.getInstance().getConnection();

	        //Preparation de la requete
	        query = "DELETE FROM Commande WHERE NumeroCommande = " + numCommande + ";";

	        //Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
    }
}
