<?php
/**
*@author: 
*/


//Les importations nécessaires
import('phpens.framework.html.Page');
import('phpens.framework.html.Header');
import('phpens.framework.html.Text');
import('phpens.framework.View');
import('phpens.framework.Response');
import('phpens.framework.Data');
import('phpens.framework.html.*');



//Création de la page entière
$page=new Page();
$page->setTitle("Music Online");
$page->addCSSFile("css/nls_style.css");

//####################################################################################################################

//Création du header et de sa division
$divHeader = new Division();

//Asigne la classe header à cette division
$divHeader->setClass("header");

//Création du header
$header = new Header(1, 'Music Online');

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

//Création du contenu principal
$divContenuPrincipal = new Division();

//Création de la division du contenu du contenu principal
$divContenuContenuP = new Division();

// Ajout du texte dans le contenu, puis ajout du contenu
$divContenuContenuP->addElement(new text("Bonjour et bienvenue dans notre application musiconline"));
$divContenuPrincipal->addElement($divContenuContenuP);

// Assigne la classe main à la division du contenu principal
$divContenuPrincipal->setClass("main");

//Ajout du contenu principal dans la page
$page->addElement($divContenuPrincipal);



//########################################################################################################################

//Affichage de toute la page
echo $page;
 
?>
