<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: CategorieDao.php
*/

import ('phpens.framework.Application');
import ('phpens.framework.db.DataObject');
import ('phpens.framework.db.DataAccessObject');
import ('musiconline.db.Categorie');


class CategorieDao implements DataAccessObject {
  //Attribut instance de DataAccessObject
  private static $dao;

  //Constructeur vide
  private function __construct() { }

  //Retourne l'instance de CategorieDAO
  public final static function getInstance() {

    //Vérifie si l'instance est correcte ou non
    if(!isset(self::$dao)) {

      //S'il n'en est pas, il en créer un autre sans paramètres
      self::$dao= new CategorieDao();
    }

    //S'il en est un, il le retourne, sinon il retourne donc une instance vide
    return self::$dao;
  }


  //Retourne toute la table
  public final function findAll() {

    //Récupère la méthode de connection à la Base de donnée
    $dbc = Application::getInstance()->getDBConnection();

    //Variable où la requête est enregistrée
    $query = "select * from Categorie";

    //Requête en dur, prends la bdd et y exécute la requête
    $stmt = $dbc->query($query);

    /*Récupère tout les tuples de Categorie, et les transpose dans des instances de classe Categorie
     Et fini par enregistrer le résultat dans $results, FALSE est retourné s'ya erreur */
    $results = $stmt->fetchALL(PDO::FETCH_CLASS, 'Categorie');

    //Retourne le résultat de $results
    return $results;
   }


  //Permet d'ajouter un tuple
  public final function insert(DataObject $do) {

    //Vérifie si l'objet entré en paramètre est instance de Categorie
    if($do instanceof Categorie){

      //Récupère la méthode de connection à la BDD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "insert into Categorie(IdCategorie,LibelleCategorie) values (:IdCategorie,:LibelleCategorie)";

      //Prépare la requête en dur avec la BDD et la requête correspondante
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres
      $stmt->bindValue(':IdCategorie',$do->getIDCategorie(),PDO::PARAM_STR);
      $stmt->bindValue(':LibelleCategorie',$do->getLIbelleCategorie(),PDO::PARAM_STR);

      //Exécute finallement la requête
      $stmt->execute($data);
   }
 }

  //Permet de mettre à jour un tuple
  public function update(DataObject $obj) {

    //Vérifie si l'objet entré en paramètre est instance de Album
    if($obj instanceof Categorie){

      //Récupère la méthode de connection à la BDD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "UPDATE Categorie SET LibelleCategorie = :LibelleCategorie WHERE IdCategorie = :IdCategorie";

      //Prépare la requête en dur avec la BDD et la requête correspondante
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres
      $stmt->bindValue(':IdCategorie',$obj->getIDCategorie(),PDO::PARAM_STR);
      $stmt->bindValue(':LibelleCategorie',$obj->getLIbelleCategorie(),PDO::PARAM_STR);

      //Exécute finallement la requête
      $stmt->execute($data);
   }
  }


  //Permet de supprimer un tuple
  public function delete(DataObject $obj) {

    //Vérifie si l'objet entré en paramètre est instance de Album
	  if($obj instanceof Categorie){

      //Récupère la méthode de connection à la BDD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "DELETE FROM Categorie WHERE IdCategorie = :IdCategorie";

      //Prépare la requête en dur avec la BDD et la requête correspondante
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres
      $stmt->bindValue(':IdCategorie',$obj->getIDCategorie(),PDO::PARAM_STR);

      //Exécute finallement la requête
      $stmt->execute($data);
    }
  }

}
?>
