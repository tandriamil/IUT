<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: PaysDao.php
*/

//Les importations nécessaires
import ('phpens.framework.Application');
import ('phpens.framework.db.DataObject');
import ('phpens.framework.db.DataAccessObject');
import ('musiconline.db.Pays');


class PaysDao implements DataAccessObject{
  //Attribut instance de DataAccessObject
  private static $dao;


  //Constructeur vide
  private function __construct() { }

  //Retourne l'instance de PaysDAO
  public final static function getInstance() {
	  
	//Vérifie si l'instance est correcte ou non  
    if(!isset(self::$dao)) {
		
	  //S'il n'en est pas, il en créer un autre sans paramètres	
      self::$dao= new PaysDao();
    }
    
    //S'il en est un, il le retourne, sinon il retourne donc une instance vide
    return self::$dao;
  }


  //Retourne toute la table
  public final function findAll(){
	  
	 //Récupère la méthode de connection à la Base de donnée
     $dbc = Application::getInstance()->getDBConnection();
     
     //Variable où la requête est enregistrée
     $query = "select * from Pays";
     
     //Requête en dur, prends la bdd et y exécute la requête
     $stmt = $dbc->query($query);
     
     /*Récupère tout les tuples de Pays, et les transpose dans des instances de classe Pays
     Et fini par enregistrer le résultat dans $results, FALSE est retourné s'ya erreur */
     $results = $stmt->fetchALL(PDO::FETCH_CLASS, 'Pays');
     
     //Retourne le résultat de $results
     return $results;
   }


  //Permet d'ajouter un tuple
  public final function insert(DataObject $do){
	  
	//Vérifie si l'objet entré en paramètre est instance de Titre  
    if($do instanceof Pays){
		
	  //Récupère la méthode de connection à la BDD	
      $dbc = Application::getInstance()->getDBConnection();
      
      // Prépare la requête SQL
      $query = "insert into Pays(IdPays,Nom;) values (:IdPays,:Nom;)";
      
      //Prépare la requête en dur avec la BDD et la requête correspondante
      $stmt = $dbc->prepare($query);
     
      //Remplace les paramètres ":IdPays" et "Nom" par les valeurs de l'objet
      $stmt->bindValue(':IdPays',$do->getIDPays(),PDO::PARAM_STR);
      $stmt->bindValue(':Nom',$do->getNOm(),PDO::PARAM_STR);
     
      //Exécute finallement la requête
      $stmt->execute();
   }
 }
 
 
  public function update(DataObject $obj){
	   if($obj instanceof Pays){
      $dbc = Application::getInstance()->getDBConnection();
      // prepare the SQL statement
      $query = "UPDATE Pays SET Nom = :Nom WHERE IdPays = :IdPays";
    $stmt = $dbc->prepare($query);
   // bind the paramaters
    $stmt->bindValue(':IdPays',$obj->getIDPays(),PDO::PARAM_STR);
    $stmt->bindValue(':Nom',$obj->getNOm(),PDO::PARAM_STR);
   // execute the prepared statement
   $stmt->execute();
   }
  }
  
  
  public function delete(DataObject $obj){
	   if($obj instanceof Pays){
      $dbc = Application::getInstance()->getDBConnection();
      // prepare the SQL statement
      $query = "DELETE FROM Pays WHERE IdPays = :IdPays";
    $stmt = $dbc->prepare($query);
   // bind the paramaters
    $stmt->bindValue(':IdPays',$obj->getIDPays(),PDO::PARAM_STR);
   // execute the prepared statement
   $stmt->execute();
   }
  }
}
?>
