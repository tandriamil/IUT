<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: controllers.php
*/

$config['urls']= array(
new UrlMapping("newcpt","musiconline.controllers.AccountController.newCompte"),
new UrlMapping("addcpt","musiconline.controllers.AccountController.add"),
new UrlMapping("connection","musiconline.controllers.AccountConnectionController.seCo"),
new UrlMapping("verification","musiconline.controllers.AccountConnectionController.verifyConnection"),
new UrlMapping("welcome","musiconline.controllers.MainController.handle")
);
?>
