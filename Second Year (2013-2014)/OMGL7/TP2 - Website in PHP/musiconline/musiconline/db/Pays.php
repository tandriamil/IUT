<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: Pays.php
*/

class Pays implements DataObject{
   private $IdPays;
   private $Nom;

   public function  __construct() { }

   public function init($IdPays,$Nom){
      $this->IdPays=$IdPays;
      $this->Nom=$Nom;
   }


   public function getIDPays(){
     return $this->IdPays;
   }

   public function setIDPays($IdPays){
     $this->IdPays = $IdPays;
   }


   public function getNom(){
     return $this->Nom;
   }

   public function setNOm($Nom){
     $this->Nom = $Nom;
   }


}
?>
