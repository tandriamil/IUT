<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: Titre.php
*/

class Titre implements DataObject{
   private $IdTitre;
   private $Libelle;
   private $Prix;
   private $Artiste;
   private $TitreAlbum;
   private $TitreCategorie;

   public function  __construct() { }

   public function init($IdTitre,$Libelle,$Prix,$Artiste,$TitreAlbum,$TitreCategorie){
      $this->IdTitre=$IdTitre;
      $this->Libelle=$Libelle;
      $this->Prix=$Prix;
      $this->Artiste=$Artiste;
      $this->TitreAlbum=$TitreAlbum;
      $this->TitreCategorie=$TitreCategorie;
   }


   public function getIDTitre(){
     return $this->IdTitre;
   }

   public function setIDTitre($IdTitre){
     $this->IdTitre = $IdTitre;
   }


   public function getLIbelle(){
     return $this->Libelle;
   }

   public function setLIbelle($Libelle){
     $this->Libelle = $Libelle;
   }


   public function getPRix(){
     return $this->Prix;
   }

   public function setPRix($Prix){
     $this->Prix = $Prix;
   }


   public function getARtiste(){
     return $this->Artiste;
   }

   public function setARtiste($Artiste){
     $this->Artiste = $Artiste;
   }


   public function getTItreAlbum(){
     return $this->TitreAlbum;
   }

   public function setTItreAlbum($TitreAlbum){
     $this->TitreAlbum = $TitreAlbum;
   }


   public function getTItreCategorie(){
     return $this->TitreCategorie;
   }

   public function setTItreCategorie($TitreCategorie){
     $this->TitreCategorie = $TitreCategorie;
   }


}
?>
