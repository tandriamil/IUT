<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: Client.php
*/

class Client implements DataObject{
   private $Login;
   private $Password;
   private $Nom;
   private $Prenom;
   private $DateDeNaissance;
   private $Email;
   private $Adresse;
   private $CodePostal;
   private $Ville;
   private $IdPays;

   public function  __construct() { }

   public function init($Login,$Password,$Nom,$Prenom,$DateDeNaissance,$Email,$Adresse,$CodePostal,$Ville,$IdPays){
      $this->Login=$Login;
      $this->Password=$Password;
      $this->Nom=$Nom;
      $this->Prenom=$Prenom;
      $this->DateDeNaissance=$DateDeNaissance;
      $this->Email=$Email;
      $this->Adresse=$Adresse;
      $this->CodePostal=$CodePostal;
      $this->Ville=$Ville;
      $this->IdPays=$IdPays;
   }


   public function getLOgin(){
     return $this->Login;
   }

   public function setLOgin($Login){
     $this->Login = $Login;
   }


   public function getPAssword(){
     return $this->Password;
   }

   public function setPAssword($Password){
     $this->Password = $Password;
   }


   public function getNOm(){
     return $this->Nom;
   }

   public function setNOm($Nom){
     $this->Nom = $Nom;
   }


   public function getPRenom(){
     return $this->Prenom;
   }

   public function setPRenom($Prenom){
     $this->Prenom = $Prenom;
   }


   public function getDAteDeNaissance(){
     return $this->DateDeNaissance;
   }

   public function setDAteDeNaissance($DateDeNaissance){
     $this->DateDeNaissance = $DateDeNaissance;
   }


   public function getEMail(){
     return $this->Email;
   }

   public function setEMail($Email){
     $this->Email = $Email;
   }


   public function getADresse(){
     return $this->Adresse;
   }

   public function setADresse($Adresse){
     $this->Adresse = $Adresse;
   }


   public function getCOdePostal(){
     return $this->CodePostal;
   }

   public function setCOdePostal($CodePostal){
     $this->CodePostal = $CodePostal;
   }


   public function getVIlle(){
     return $this->Ville;
   }

   public function setVIlle($Ville){
     $this->Ville = $Ville;
   }


   public function getIDPays(){
     return $this->IdPays;
   }

   public function setIDPays($IdPays){
     $this->IdPays = $IdPays;
   }


}
?>
