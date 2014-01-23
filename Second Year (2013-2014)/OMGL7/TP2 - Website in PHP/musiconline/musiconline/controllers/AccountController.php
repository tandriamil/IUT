<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: AccountController.php
*/

/**
*Classe pour le controlleur du formulaire d'ajout d'étudiant
*/

//Importation des classes nécessaires
import('phpens.framework.Controller');
import('phpens.framework.Request');
import('phpens.framework.Response');
import('phpens.framework.View');
import('phpens.framework.util.ResultSet');
import('musiconline.db.PaysDao');
import('musiconline.db.Pays');
import('musiconline.db.ClientDao');
import('musiconline.db.Client');
/**
*Controlleur de l'ajout de comtpe
*/
class AccountController extends Controller {

	/**
	*Le constructeur
	*@param $request La requête en entrée
	*@param $response La réponse à la requête
	*@param $view La vue retournée
	*/

	public function __construct(Request $request, Response $response, View $view) {
        parent::__construct($request, $response, $view);
    }


    /**
    *Fonction déclanchant le chargement et l'affichage de la vue AccountCreationView
    */
	// Request Mapping: newcpt
    public function newCompte() {
    	//Permet de changer la vue et de mettre une sorte d'écran de chargement
    	$liste_pays = PaysDao::getInstance()->findAll();
    	$this->view->setContent('musiconline/views/AccountCreationView.php');
    	$this->view->set('liste_pays',$liste_pays);
    }


    /**
    *Fonction permettant l'affichage de la vue AccountValidationView qui permet de savoir si la requête a aboutie ou non
    */
    // Request Mapping: addcpt
    public function add() {
    	//Récupération des différentes données du formulaire
    	$login = $this->request->getParameter('login');
    	$password = $this->request->getParameter('password');
    	$nom = $this->request->getParameter('nom');
    	$prenom = $this->request->getParameter('prenom');
    	$dateNaissance = $this->request->getParameter('dateNaissance');
    	$email = $this->request->getParameter('email');
    	$adresse = $this->request->getParameter('adresse');
    	$codePostal = $this->request->getParameter('codePostal');
    	$ville = $this->request->getParameter('ville');
    	$idPays = $this->request->getParameter('idPays');

    	//Création de l'objet qui prendra tous ces paramètres
    	$client = new Client();
    	$client->init($login, $password, $nom, $prenom, $dateNaissance, $email, $adresse, $codePostal, $ville, $idPays);

    	//Tentative d'insertion du tuple du compte dans la BDD
    	try {
    		ClientDao::getInstance()->insert($client);
    		$this->view->setContent('musiconline/views/AccountValidationView.php');
    	}
    	catch (PDOException $e) {
    		$this->view->setContent('musiconline/views/AccountErrorView.php');
    		echo $e->getMessage();
    	}
    }

}


?>
