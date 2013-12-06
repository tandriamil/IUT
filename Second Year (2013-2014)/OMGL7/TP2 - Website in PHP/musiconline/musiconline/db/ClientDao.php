<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: ClientDao.php
*/


import ('phpens.framework.Application');
import ('phpens.framework.db.DataObject');
import ('phpens.framework.db.DataAccessObject');
import ('musiconline.db.Client');


class ClientDao implements DataAccessObject {
  //Attribut instance de DataAccessObject
  private static $dao;

  //Constructeur vide
  private function __construct() { }

  //Retourne l'instance de ClientDAO
  public final static function getInstance() {

    //Vérifie d'abord si l'instance est correcte ou non
    if(!isset(self::$dao)) {

      //Si non correct, en créer une
      self::$dao= new ClientDao();
    }

    //Retourne finallement l'instance, sinon retourne une instance vide
    return self::$dao;
  }


  //Retourne toute la table
  public final function findAll() {

    //Récupère la méthode de connexion au SGBD
    $dbc = Application::getInstance()->getDBConnection();

    //Prépare la requête
    $query = "select * from Client";

    //Requête en dur, prends la BDD et y exécute la requête
    $stmt = $dbc->query($query);

    //Récupère le résultat sous forme de tableau d'instances de classes
    $results = $stmt->fetchALL(PDO::FETCH_CLASS, 'Client');

    //Retourne le résultat
    return $results;
   }


  //Permet d'insérer un tuple
  public final function insert(DataObject $do) {

    //Vérifie que l'objet entré est bien une instance de Client
    if($do instanceof Client){

      //Récupère la méthode de connexion au SGBD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "insert into Client(Login,Password,Nom,Prenom,DateDeNaissance,Email,Adresse,CodePostal,Ville,IdPays) values (:Login,:Password,:Nom,:Prenom,:DateDeNaissance,:Email,:Adresse,:CodePostal,:Ville,:IdPays)";

      //Prépare la requête en dûr
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres
      $stmt->bindValue(':Login',$do->getLOgin(),PDO::PARAM_STR);
      $stmt->bindValue(':Password',$do->getPAssword(),PDO::PARAM_STR);
      $stmt->bindValue(':Nom',$do->getNOm(),PDO::PARAM_STR);
      $stmt->bindValue(':Prenom',$do->getPRenom(),PDO::PARAM_STR);
      $stmt->bindValue(':DateDeNaissance',$do->getDAteDeNaissance(),PDO::PARAM_STR);
      $stmt->bindValue(':Email',$do->getEMail(),PDO::PARAM_STR);
      $stmt->bindValue(':Adresse',$do->getADresse(),PDO::PARAM_STR);
      $stmt->bindValue(':CodePostal',$do->getCOdePostal(),PDO::PARAM_STR);
      $stmt->bindValue(':Ville',$do->getVIlle(),PDO::PARAM_STR);
      $stmt->bindValue(':IdPays',$do->getIDPays(),PDO::PARAM_STR);
      
      //Exécute la requête finale
      $stmt->execute();
   }
 }


  //Méthode qui permet de mettre à jour un tuple
  public function update(DataObject $obj) {

    //Vérifie que l'objet entré est bien une instance de Client
    if($obj instanceof Client){

      //Récupère la méthode de connexion au SGBD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "UPDATE Client SET Password = :Password, Nom = :Nom, Prenom = :Prenom, DateDeNaissance = :DateDeNaissance, Email = :Email, Adresse = :Adresse, CodePostal = :CodePostal, Ville = :Ville, IdPays = :IdPays WHERE Login = :Login";

      //Prépare la requête en dûr
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres
      $stmt->bindValue(':Login',$obj->getLOgin(),PDO::PARAM_STR);
      $stmt->bindValue(':Password',$obj->getPAssword(),PDO::PARAM_STR);
      $stmt->bindValue(':Nom',$obj->getNOm(),PDO::PARAM_STR);
      $stmt->bindValue(':Prenom',$obj->getPRenom(),PDO::PARAM_STR);
      $stmt->bindValue(':DateDeNaissance',$obj->getDAteDeNaissance(),PDO::PARAM_STR);
      $stmt->bindValue(':Email',$obj->getEMail(),PDO::PARAM_STR);
      $stmt->bindValue(':Adresse',$obj->getADresse(),PDO::PARAM_STR);
      $stmt->bindValue(':CodePostal',$obj->getCOdePostal(),PDO::PARAM_STR);
      $stmt->bindValue(':Ville',$obj->getVIlle(),PDO::PARAM_STR);
      $stmt->bindValue(':IdPays',$obj->getIDPays(),PDO::PARAM_STR);
      
      //Exécute la requête finale
      $stmt->execute();
  }
  }


  //Méthode permettant de supprimer un tuple
  public function delete(DataObject $obj) {

    //Vérifie si l'objet entré en paramètre est instance de Album
    if($obj instanceof Client) {

      //Récupère la méthode de connection à la BDD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "DELETE FROM Client WHERE Login = :Login";
    
      //Prépare la requête en dur avec la BDD et la requête correspondante
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres
      $stmt->bindValue(':Login',$obj->getLOgin(),PDO::PARAM_STR);
   
      //Exécute finallement la requête
      $stmt->execute();
  }
}
}
?>
