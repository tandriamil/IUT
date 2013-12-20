<?php
/* Controleur pour l'accueil */

class Accueil extends CI_Controller {

	/**
	 * Methode afichant la page d'acceuil
	 */
	public function index() {
		$data = array();
		$data['titre'] = "La Tour de Pizz - Hennebont";

		$this->load->view('accueil/accueil', $data);
	}
}

?>