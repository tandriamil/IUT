<?php
/* @Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: AccountValidationView.php
*/

//Les importations nécessaires
import('phpens.framework.View');
import('phpens.framework.Response');
import('phpens.framework.Data');
import('phpens.framework.html.*');



//Création de la page entière
$page=new Page();
$page->setTitle("Music Online - Compte créé");
$page->addCSSFile("css/nls_style.css");



//####################################################################################################################
//Création du header et de sa division
$divHeader = new Division();

//Asigne la classe header à cette division
$divHeader->setClass("header");

//Création du header
$header = new Header(1, 'Félicitation! Compte créé!');

//Ajout du header dans sa division
$divHeader->addElement($header);

//Ajout de la division du header dans la page principale
$page->addElement($divHeader);



//#####################################################################################################################
//Création du Menu sur le côté gauche
$divMenu = new Division();

//Assigne la classe left_panel à la division du menu
$divMenu->setClass("left_panel");

//Création du panneau de titre du menu
$divTitreMenu = new Division();
$divTitreMenu->setClass("menuBoxHeader");

//Ajout du panel de titre au panel complet du menu
$divMenu->addElement($divTitreMenu);

//Ajout du texte du titre
$divTitreMenu->addElement(new Text("<span class=\"titreMenu\">Compte Client</span>"));

//Création de la division du contenu du menu
$divContenuMenu = new Division();
$divContenuMenu->setClass("menuBoxContent");

//Ajout de la division du contenu dans la division du menu
$divMenu->addElement($divContenuMenu);

//Création des éléments du contenu du menu
$divContenuMenu->addElement(new Text("<div><a class=\"nav\" href=\"?connection\">Se connecter</a></div>"));
$divContenuMenu->addElement(new Text("<div><a class=\"nav\" href=\"?newcpt\">Créer un Compte</a></div>"));

//Ajout du menu à la page
$page->addElement($divMenu);



//########################################################################################################################
//Création du contenu principal (corps de la page)
$divContenuPrincipal = new Division();

// Assigne la classe main à la division du contenu principal
$divContenuPrincipal->setClass("main");

//Création et ajout des éléments du corps principal de la page
$divContenuPrincipal->add(new Text("Votre compte a été créé correctement!"));
$divContenuPrincipal->addElement(new Text("<div><a class=\"boutonRetour\" href=\"?welcome\">Valider</a></div>"));

//Ajout du contenu principal dans la page
$page->addElement($divContenuPrincipal);



//########################################################################################################################
//Affichage de toute la page
echo $page;
 
?>
