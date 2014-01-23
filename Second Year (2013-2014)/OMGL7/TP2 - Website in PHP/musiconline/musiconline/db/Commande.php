<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: Commande.php
*/

class Commande implements DataObject{
   private $NumeroCommande;
   private $ClientCommande;
   private $TitreCommande;
   private $Total;

   public function  __construct() { }

   public function init($NumeroCommande,$ClientCommande,$TitreCommande,$Total){
      $this->NumeroCommande=$NumeroCommande;
      $this->ClientCommande=$ClientCommande;
      $this->TitreCommande=$TitreCommande;
      $this->Total=$Total;
   }


   public function getNUmeroCommande(){
     return $this->NumeroCommande;
   }

   public function setNUmeroCommande($NumeroCommande){
     $this->NumeroCommande = $NumeroCommande;
   }


   public function getCLientCommande(){
     return $this->ClientCommande;
   }

   public function setCLientCommande($ClientCommande){
     $this->ClientCommande = $ClientCommande;
   }


   public function getTItreCommande(){
     return $this->TitreCommande;
   }

   public function setTItreCommande($TitreCommande){
     $this->TitreCommande = $TitreCommande;
   }


   public function getTOtal(){
     return $this->Total;
   }

   public function setTOtal($Total){
     $this->Total = $Total;
   }


}
?>
