<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: CommandeDao.php
*/

import ('phpens.framework.Application');
import ('phpens.framework.db.DataObject');
import ('phpens.framework.db.DataAccessObject');
import ('musiconline.db.Commande');


class CommandeDao implements DataAccessObject{
  //Attribut instance de DataAccessObject
  private static $dao;

  //Constructeur vide
  private function __construct() { }

  //Permet de retourner une instance de CommandeDAO
  public final static function getInstance() {

    //Vérifie si l'objet est correcte
    if(!isset(self::$dao)) {

      //Sinon, il en créer un vide
      self::$dao= new CommandeDao();
    }

    //Retourne l'objet ou l'objet créer
    return self::$dao;
  }


  //Retourne tous les tuples
  public final function findAll(){

    //Récupère la méthode de connexion au SGBD
    $dbc = Application::getInstance()->getDBConnection();

    //Prépare la requête
    $query = "select * from Commande";

    //Prépare la requête en dur
    $stmt = $dbc->query($query);

    //Enregistre tous les tuples dans un tableau d'instances de classe
    $results = $stmt->fetchALL(PDO::FETCH_CLASS, 'Commande');

    //Retourne le résultat
    return $results;
   }


  //Permet d'insérer un tuple
  public final function insert(DataObject $do){

    //Vérifie si l'objet entré est instance de commande
    if($do instanceof Commande){

      //Récupère la méthode de connexion
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête
      $query = "insert into Commande(NumeroCommande,ClientCommande,TitreCommande,Total) values (:NumeroCommande,:ClientCommande,:TitreCommande,:Total)";

      //Prépare la requête en dur
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres
      $stmt->bindValue(':NumeroCommande',$do->getNUmeroCommande(),PDO::PARAM_STR);
      $stmt->bindValue(':ClientCommande',$do->getCLientCommande(),PDO::PARAM_STR);
      $stmt->bindValue(':TitreCommande',$do->getTItreCommande(),PDO::PARAM_STR);
      $stmt->bindValue(':Total',$do->getTOtal(),PDO::PARAM_STR);

      //Exécute la requête
      $stmt->execute($data);
    }
 }


  //Permet de mettre à jour un tuple
  public function update(DataObject $obj){

	  //Vérifie si l'objet entré est instance de commande
    if($obj instanceof Commande){

      //Récupère la méthode de connexion
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête
      $query = "UPDATE Commande SET TitreCommande = :TitreCommande, Total = :Total WHERE NumeroCommande = :NumeroCommande AND ClientCommande = :ClientCommande";

      //Prépare la requête en dur
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres
      $stmt->bindValue(':NumeroCommande',$obj->getNUmeroCommande(),PDO::PARAM_STR);
      $stmt->bindValue(':ClientCommande',$obj->getCLientCommande(),PDO::PARAM_STR);
      $stmt->bindValue(':TitreCommande',$obj->getTItreCommande(),PDO::PARAM_STR);
      $stmt->bindValue(':Total',$obj->getTOtal(),PDO::PARAM_STR);

      //Exécute la requête
      $stmt->execute($data);
  }

  public function delete(DataObject $obj){

    //Vérifie si l'objet entré est instance de commande
    if($obj instanceof Commande){

      //Récupère la méthode de connexion
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête
      $query = "DELETE FROM Commande WHERE NumeroCommande = :NumeroCommande AND ClientCommande = :ClientCommande";

      //Prépare la requête en dur
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres
      $stmt->bindValue(':NumeroCommande',$obj->getNUmeroCommande(),PDO::PARAM_STR);
      $stmt->bindValue(':ClientCommande',$obj->getCLientCommande(),PDO::PARAM_STR);

      //Exécute la requête
      $stmt->execute($data);
  }
}
?>
