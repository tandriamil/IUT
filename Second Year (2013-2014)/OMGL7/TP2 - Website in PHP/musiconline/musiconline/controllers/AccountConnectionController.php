<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: AccountConnectionController.php
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
import('musiconline.db.ClientDao');
import('musiconline.db.Client');
/**
*Controlleur de l'ajout de comtpe
*/
class AccountConnectionController extends Controller {

	/**
	*Le constructeur
	*@param $request La requête en entrée
	*@param $response La réponse à la requête
	*@param $view La vue retournée
	*/
	public function __construct(Request $request, Response $response, View $view) {
        parent::__construct($request, $response, $view);
    }

	// Request Mapping: connection
	public function seCo() {
		$this->view->setContent('musiconline/views/AccountConnectionView.php');
	}


    /**
    *Fonction déclanchant le chargement et l'affichage de la vue AccountCreationView
    */
	// Request Mapping: verification
    public function verifyConnection() {
        //Attribut pour savoir si c'est valable ou pas
        $autorisation = FALSE;

    	//Récupération des différentes données
        $login = $this->request->getParameter('login');
        $password = $this->request->getParameter('password');

        //Création de l'objet d'où l'on vérifira
		//Récupération des données de la table Client
        $tableauxClients = ClientDao::getInstance()->findAll();

		//Vérification de chaque tuple
        foreach ($tableauxClients as $client) {
            if ($client->getLOgin() == $login) {
				if ($client->getPAssword() == $password) {
					$autorisation = TRUE;
				}
			}
        }

		//Alors on renvoie vers une bonne page!
		if ($autorisation == TRUE) {
			$this->view->setContent('musiconline/views/AccountConnectionValidationView.php');
		}
		else {
			$this->view->setContent('musiconline/views/AccountConnectionErrorView.php');
		}
    }
}


?>
