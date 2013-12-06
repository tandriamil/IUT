<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: AccountCreationView.php
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
$page->setTitle("Music Online - Création d'un Compte");
$page->addCSSFile("css/nls_style.css");

//####################################################################################################################

//Création du header et de sa division
$divHeader = new Division();

//Asigne la classe header à cette division
$divHeader->setClass("header");

//Création du header
$header = new Header(1, 'Création de compte');

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

// Assigne la classe main à la division du contenu principal
$divContenuPrincipal->setClass("main");

// Création de la division du titre
$titre = new Division();
$titre->setClass("titre");

// Création du contenu du titre
$titre->addElement(new Text("Création d'un compte client"));

// Ajout du titre dans le contenu principal
$divContenuPrincipal->addElement($titre);

// Création des différents champs du formulaire
$inputText1 = new InputText("nom", "Nom");
$inputText2 = new InputText("prenom", "Prenom");
$date = new InputDate("dateNaissance", "Date de naissance");
$inputText3 = new inputText("email", "Email");
$inputText4 = new inputText("adresse", "Adresse");
$inputText5 = new inputText("codePostal", "Code Postal");
$inputText6 = new inputText("ville", "Ville");
$inputText7 = new inputText("login", "Votre login");
$inputText8 = new inputText("password", "Votre mot de passe");
$Button = new SubmitButton("button", "Valider");

$form = new Form(HTTP_POST, "?addcpt", URL_ENCODED_FORM);
$form->addElement($inputText1);
$form->addElement($inputText2);
$form->addElement($date);
$form->addElement($inputText3);
$form->addElement($inputText4);
$form->addElement($inputText5);
$form->addElement($inputText6);


$pays = new ComboBox("idPays","Pays");
foreach($liste_pays as $p) {
	$pays->addItem($p->getIDPays(),$p->getNom());
}
$form->addElement($pays);

$form->addElement($inputText7);
$form->addElement($inputText8);
$form->addElement($Button);

$divContenuPrincipal->addElement($form);

//Ajout du contenu principal dans la page
$page->addElement($divContenuPrincipal);



//########################################################################################################################

//Affichage de toute la page
echo $page;
 
?>
