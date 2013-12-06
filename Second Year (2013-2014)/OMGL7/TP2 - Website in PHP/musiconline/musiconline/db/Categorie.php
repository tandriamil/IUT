<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: Categorie.php
*/

class Categorie implements DataObject{
   private $IdCategorie;
   private $LibelleCategorie;

   public function  __construct() { }

   public function init($IdCategorie,$LibelleCategorie){
      $this->IdCategorie=$IdCategorie;
      $this->LibelleCategorie=$LibelleCategorie;
   }


   public function getIDCategorie(){
     return $this->IdCategorie;
   }

   public function setIDCategorie($IdCategorie){
     $this->IdCategorie = $IdCategorie;
   }


   public function getLIbelleCategorie(){
     return $this->LibelleCategorie;
   }

   public function setLIbelleCategorie($LibelleCategorie){
     $this->LibelleCategorie = $LibelleCategorie;
   }


}
?>
