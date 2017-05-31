<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: TitreDao.php
*/

//Les importations nécessaires
import ('phpens.framework.Application');
import ('phpens.framework.db.DataObject');
import ('phpens.framework.db.DataAccessObject');
import ('musiconline.db.Titre');


class TitreDao implements DataAccessObject{
  //Attribut instance de DataAccessObject
  private static $dao;


  //Constructeur vide
  private function __construct() { }

  //Retourne l'instance de TitreDAO
  public final static function getInstance() {

	//Vérifie si l'instance est correcte ou non
    if(!isset(self::$dao)) {

	  //S'il n'en est pas, il en créer un autre sans paramètres
      self::$dao= new TitreDao();
    }

    //S'il en est un, il le retourne, sinon il retourne donc une instance vide
    return self::$dao;
  }


  //Retourne toute la table
  public final function findAll(){

	 //Récupère la méthode de connection à la Base de donnée
     $dbc = Application::getInstance()->getDBConnection();

     //Variable où la requête est enregistrée
     $query = "select * from Titre";

     //Requête en dur, prends la bdd et y exécute la requête
     $stmt = $dbc->query($query);

     /*Récupère tout les tuples de Titre, et les transpose dans des instances de classe Titre
     Et fini par enregistrer le résultat dans $results, FALSE est retourné s'ya erreur */
     $results = $stmt->fetchALL(PDO::FETCH_CLASS, 'Titre');

     //Retourne le résultat de $results
     return $results;
   }


  //Permet d'ajouter un tuple
  public final function insert(DataObject $do){

	//Vérifie si l'objet entré en paramètre est instance de Titre
    if($do instanceof Titre){

	  //Récupère la méthode de connection à la BDD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "insert into Titre(IdTitre,Libelle,Prix,Artiste,TitreAlbum,TitreCategorie) values (:IdTitre,:Libelle,:Prix,:Artiste,:TitreAlbum,:TitreCategorie)";

	  //Prépare la requête en dur avec la BDD et la requête correspondante
      $stmt = $dbc->prepare($query);

      //Remplace tous les paramètres de Titre par les valeurs de l'objet
      $stmt->bindValue(':IdTitre',$do->getIDTitre(),PDO::PARAM_STR);
      $stmt->bindValue(':Libelle',$do->getLIbelle(),PDO::PARAM_STR);
      $stmt->bindValue(':Prix',$do->getPRix(),PDO::PARAM_STR);
      $stmt->bindValue(':Artiste',$do->getARtiste(),PDO::PARAM_STR);
      $stmt->bindValue(':TitreAlbum',$do->getTItreAlbum(),PDO::PARAM_STR);
      $stmt->bindValue(':TitreCategorie',$do->getTItreCategorie(),PDO::PARAM_STR);

     //Exécute finallement la requêtet
     $stmt->execute($data);
   }
 }


 //Permet de mettre à jour un tuple
  public function update(DataObject $obj){

	//Vérifie si l'objet entré en paramètre est instance de Titre
    if($obj instanceof Titre){

	  //Récupère la méthode de connection à la BDD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "UPDATE Titre SET Libelle = :Libelle, Prix = :Prix, Artiste = :Artiste, TitreAlbum = :TitreAlbum, TitreCategorie = :TitreCategorie WHERE IdTitre = :IdTitre";

	  //Prépare la requête en dur avec la BDD et la requête correspondante
      $stmt = $dbc->prepare($query);

      //Remplace tous les paramètres de Titre par les valeurs de l'objet
      $stmt->bindValue(':IdTitre',$obj->getIDTitre(),PDO::PARAM_STR);
      $stmt->bindValue(':Libelle',$obj->getLIbelle(),PDO::PARAM_STR);
      $stmt->bindValue(':Prix',$obj->getPRix(),PDO::PARAM_STR);
      $stmt->bindValue(':Artiste',$obj->getARtiste(),PDO::PARAM_STR);
      $stmt->bindValue(':TitreAlbum',$obj->getTItreAlbum(),PDO::PARAM_STR);
      $stmt->bindValue(':TitreCategorie',$obj->getTItreCategorie(),PDO::PARAM_STR);

     //Exécute finallement la requêtet
     $stmt->execute($data);
   }
  }


  //Permet de supprimer un tuple
  public function delete(DataObject $obj){

	   //Vérifie si l'objet entré en paramètre est instance de Titre
	   if($obj instanceof Titre){

	   //Récupère la méthode de connection à la BDD
      $dbc = Application::getInstance()->getDBConnection();

      //Prépare la requête SQL
      $query = "DELETE FROM Titre WHERE IdTitre = :IdTitre";

      //Prépare la requête en dur avec la BDD et la requête correspondante
      $stmt = $dbc->prepare($query);

      //Remplace les paramètres ":IdTitre" par la valeur de l'objet
      $stmt->bindValue(':IdTitre',$obj->getIDTitre(),PDO::PARAM_STR);

	 //Exécute finallement la requête
     $stmt->execute($data);
   }
  }
}
?>
