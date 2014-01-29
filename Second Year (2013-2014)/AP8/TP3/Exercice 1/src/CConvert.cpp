#include "CConvert.h"

/**
 * The first constructor with no parameters
 */
CConvert::CConvert() {
	//Initializes the two attributes
	this->m_Str = "";
	this->m_Dbl = 0;

	//Then prints a message
	cout << "Construction et initialisation des variables à 0 et \"\" de l'objet CPoint d'adresse : " << this << endl;
}