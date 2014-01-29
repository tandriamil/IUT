#include "CManFch.h"

/**
 * The first constructor with no parameters
 */
CManFch::CManFch() {
	//Initializes the attributes
	this->m_NomFich = "";
	this->m_EmplcmtFich = "";
	this->m_TypeFich = 0;
}


/** 
 * The second constructor with a string
 * @param str The name of the file with it location
 */
CManFch::CManFch(string str) {

}


/**
 * Method to set the name of the file
 * @param str The new name of the file
 */
void CManFch::setNomFichier(string str) {
	//Firstly, create a copy of the name
	string tmp = this->m_NomFich;

	//Change the name of the file
	this->m_NomFich = str;

	//Displays the changes
	cout << "Changement du nom de " << tmp << " en " << this->m_NomFich << ".";
}


/**
 * Displays the attributes
 */
void CManFch::afficherAttributs() {
	cout << "Nom du fichier: " << this->m_NomFich << "\n" << "Emplacement du fichier: " << this->m_EmplcmtFich << "\n" << "Type du fichier: " << this->m_TypeFich << "\n";
}


/**
 * Displays the file
 */
void CManFch::afficherFichier() {
	//If it's a .txt file
	if (this->m_TypeFich == 1) {
		
	}

	//If it's a .bin file
	if ($this->m_TypeFich == 2) {

	}

	//If there's no file
	else {
		cout << "Fichier non compatible avec cet affichage.";
	}
}