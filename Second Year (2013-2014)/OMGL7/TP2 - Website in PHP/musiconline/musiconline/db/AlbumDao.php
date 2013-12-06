<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: AlbumDao.php
*/

//Les importations nécessaires
import ('phpens.framework.Application');
import ('phpens.framework.db.DataObject');
import ('phpens.framework.db.DataAccessObject');
import ('musiconline.db.Album');


class AlbumDao implements DataAccessObject {
  //Attribut instance de DataAccessObject
  private static $dao;

  //Constructeur vide
  private function __construct() { }

  //Retourne l'instance d'AlbumDAO
  public final static function getInstance() {

    //Vérifie si l'instance est correcte ou non
    if(!isset(self::$dao)) {

      //S'il n'en est pas, il en créer un autre sans paramètres
      self::$dao= new AlbumDao();
    }

    //S'il en est un, il le retourne, sinon il retourne donc une instance vide
    return self::$dao;
  }


  //Retourne toute la table
  public final function findAll(){

     //Récupère la méthode de connection à la Base de donnée
     $dbc = Application::getInstance()->getDBConnection();

     //Variable où la requête est enregistrée
     $query = "select * from Album";

     //Requête en dur, prends la bdd et y exécute la requête
     $stmt = $dbc->query($query);

     /*Récupère tout les tuples de Album, et les transpose dans des instances de classe Album
     Et fini par enregistrer le résultat dans $results, FALSE est retourné s'ya erreur */
     $results = $stmt->fetchALL(PDO::FETCH_CLASS, 'Album');

     //Retourne le résultat de $results
     return $results;
   }


  //Permet d'ajouter un tuple
  public final function insert(DataObject $do){

    //Vérifie si l'objet entré en paramètre est instance de Album
    if($do instanceof Album){

      //Récupère la méthode de connection à la BDD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "insert into Album(IdAlbum,LibelleAlbum) values (:IdAlbum,:LibelleAlbum)";

      //Prépare la requête en dur avec la BDD et la requête correspondante
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres ":IdAlbum" et "LibelleAlbum" par les valeurs de l'objet
      $stmt->bindValue(':IdAlbum',$do->getIDAlbum(),PDO::PARAM_STR);
      $stmt->bindValue(':LibelleAlbum',$do->getLIbelleAlbum(),PDO::PARAM_STR);

      //Exécute finallement la requête
      $stmt->execute($data);
    }
  }


  //Permet de mettre à jour un tuple
  public function update(DataObject $obj){

    //Vérifie si l'objet entré en paramètre est instance de Album
    if($obj instanceof Album){

      //Récupère la méthode de connection à la BDD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "UPDATE Album SET LibelleAlbum = :LibelleAlbum WHERE IdAlbum = :IdAlbum";

      //Prépare la requête en dur avec la BDD et la requête correspondante
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres ":IdAlbum" et "LibelleAlbum" par les valeurs de l'objet
      $stmt->bindValue(':IdAlbum',$obj->getIDAlbum(),PDO::PARAM_STR);
      $stmt->bindValue(':LibelleAlbum',$obj->getLIbelleAlbum(),PDO::PARAM_STR);

      //Exécute finallement la requête
      $stmt->execute($data);
   }
  }


  //Permet de supprimer un tuple
  public function delete(DataObject $obj){

    //Vérifie si l'objet entré en paramètre est instance de Album
    if($obj instanceof Album){

      //Récupère la méthode de connection à la BDD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "DELETE FROM Album WHERE IdAlbum = :IdAlbum";

      //Prépare la requête en dur avec la BDD et la requête correspondante
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres ":IdAlbum" par la valeur de l'objet
      $stmt->bindValue(':IdAlbum',$obj->getIDAlbum(),PDO::PARAM_STR);

      //Exécute finallement la requête
      $stmt->execute($data);
  }
}


//Creation d'une instance d'AlbumDAO
	$testAlbum = new AlbumDAO();

	//Test du findAll
	$findAll = $testAlbum->findAll();

	//Affichage du resultat
	echo $findAll;
?>
