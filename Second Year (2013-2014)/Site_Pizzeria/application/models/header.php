<?php if (!defined('BASEPATH')) exit('No direct script access allowed');
/* Model pour les données du header */

class Header extends CI_Model {

	/**
	 * Methode renvoyant les données du header
	 */
	public function getDonnees() {
		$ret = array();

		//Recup du numero de tel et des horaires
		$query = "SELECT titre, corps FROM Donnees WHERE idData >= 2 AND idData <= 9"

		$exec = $this->db->query($query);

		//Recup des donnees dans un array
		$ret = $exec->result_array();

		return $ret;
	}


	/**
	 * Insertion des données
	 *//*
	public function setDonnees($id, $titre, $corps) {
		//Modification de telle ou telle ligne
		$query = "UPDATE Donnees
			SET titre = " . $titre . 
			", corps = " . $corps . " WHERE idData = " . $id

		$exec = $this->db->query($query);
	}*/
}

?>