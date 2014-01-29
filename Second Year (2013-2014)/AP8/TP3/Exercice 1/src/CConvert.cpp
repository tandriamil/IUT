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


/**
 * The constructor with only a string
 * @param str The string to initialize the attribute
 */
CConvert::CConvert(string str) {
	//Initializes the two attributes
	this->m_Str = str;
	this->m_Dbl = 0;

	//Then prints a message
	cout << "Construction et initialisation des variables à 0 et à " << str << " de l'objet CPoint d'adresse : " << this << endl;
}


/**
 * The last constructor with only a double
 * @param dbl The double to initialize the attribute
 */
CConvert::CConvert(double dbl) {
 	//Initializes the two attributes
	this->m_Str = "";
	this->m_Dbl = dbl;

	//Then prints a message
	cout << "Construction et initialisation des variables à une valeur et à \"\" de l'objet CPoint d'adresse : " << this << endl;
}


/**
 * The destructor
 */
CConvert::~CConvert() {
	cout << "Destruction de l'objet CConvert d'adresse : " << this << "\n" << endl;
}


/**
 * Accessor of the string
 * @return The string of this object
 */
CConvert::getString() {

}


/**
 * Accessor of the double
 * @return The double of this object
 */
CConvert::getDouble() {
	
}