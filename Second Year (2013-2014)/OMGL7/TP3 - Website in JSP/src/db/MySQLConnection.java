package db;

import java.sql.*;
import com.mysql.jdbc.*;

/**
 * Cette classe (type singleton !!) établit la connexion entre une
 * application Java et une BDD mysql.
 */

class MySQLConnection {

    // !!REMPLACER 36X par vos paramètres de BDD mysql.
    private String dsn = "jdbc:mysql://wamba.univ-ubs.fr/e_11_gl7_12_36";
    private String username= "e_13_gl7_14_36";
    private String password= "pe_13_gl7_14_36p";
    
    private java.sql.Connection connect;
    private static MySQLConnection theInst = null;

    /**
     * Constructeur privé !
     * Etablissement de la connexion.
     */
    private MySQLConnection(){
        this.getConnection();
    }

    /**
     * Méthode statique de récupération de l'instance unique.
     * @return - l'instance de MySQLConnection.
     */
    public static MySQLConnection getInstance(){
        if ( MySQLConnection.theInst == null ) {
            MySQLConnection.theInst = new MySQLConnection();
        }
        return MySQLConnection.theInst;
    }

    /**
     * Renvoie l'objet qui a établi la connexion avec la BDD.
     * @return - l'objet qui a établi la connexion.
     */
    public java.sql.Connection getConnection(){
        if ( this.connect == null ) {
            try {
            DriverManager.registerDriver( new com.mysql.jdbc.Driver() );
            this.connect = DriverManager.getConnection( this.dsn, this.username, this.password );
            System.out.println( "Connexion reussie" );
            }
            catch ( Exception e ) {
                System.err.println( "Erreur de connexion : " + e.getMessage() );
            }
        }
        return this.connect;
    }

    /**
     * Ferme la connexion avec la BDD.
     */
    public void closeConnection(){
        try {
            this.connect.close();
            this.connect = null;
        } catch ( Exception e ) {
            System.out.println ( "Probleme de fermeture" + e.getMessage() );
        }
    }


    /**
     * Lanceur qui teste la classe MySQLConnection
     */
    public static void main(String[] args){
        MySQLConnection theObj = MySQLConnection.getInstance();
        theObj.closeConnection();
    }

}
