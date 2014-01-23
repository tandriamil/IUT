<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: Album.php
*/

class Album implements DataObject{
   private $IdAlbum;
   private $LibelleAlbum;

   public function  __construct() {}

   public function init($IdAlbum,$LibelleAlbum){
      $this->IdAlbum=$IdAlbum;
      $this->LibelleAlbum=$LibelleAlbum;
   }


   public function getIDAlbum(){
     return $this->IdAlbum;
   }

   public function setIDAlbum($IdAlbum){
     $this->IdAlbum = $IdAlbum;
   }


   public function getLIbelleAlbum(){
     return $this->LibelleAlbum;
   }

   public function setLIbelleAlbum($LibelleAlbum){
     $this->LibelleAlbum = $LibelleAlbum;
   }


}
?>
