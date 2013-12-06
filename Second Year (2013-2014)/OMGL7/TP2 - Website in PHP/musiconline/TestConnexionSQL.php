<?php
//Test du bon fonctionnement de classe MySQLConnection

//Les importations necessaires
require ('../phpens/framework/db/DatabaseConnection.php');
require ('../phpens/framework/db/MySQLConnection.php');

//Creation de l'instance de MySQLConnection
$testCo = new MySQLConnection ('wamba.univ-ubs.fr', 'e_13_gl7_14_36', 'e_13_gl7_14_36', 'pe_13_gl7_14_36p');

//Enregistrement des resultats d'une requete dans un tableau
$result=$testCo->getConnection()->query("select * from Client")->fetchAll();

//Affichage des resultats
var_dump($result);

?>
