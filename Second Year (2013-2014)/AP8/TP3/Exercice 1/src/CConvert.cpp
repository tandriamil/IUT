#include "CConvert.h"

/**
 * The first constructor with no parameters
 */
CConvert::CConvert() {
	//Initializes the two attributes
	this->m_Str = "";
	this->m_Dbl = 0;

	//Then prints a message
	cout << "Construction et initialisation des variables à 0 et \"\" de l'objet CConvert d'adresse : " << this << endl;
}


/**
 * The constructor with only a string
 * @param str The string to initialize the attribute
 */
CConvert::CConvert(string str) {
	//Initializes the two attributes
	this-> m_Str = str;

	//Creates the double
	istringstream tmp (str);
	double converted;
	tmp >> converted;
	this -> m_Dbl = converted;


	//Then prints a message
<<<<<<< HEAD
	cout << "Construction et initialisation des variables à " << str << " et à " << converted <<  "de l'objet CConvert d'adresse : " << this << endl;
=======
	cout << "Construction et initialisation des variables à " << this->m_Dbl << " et à " << str << " de l'objet CPoint d'adresse : " << this << endl;
>>>>>>> f0b12885ff959259ac042aa9fb89f40fea17afbc
}


/**
 * The last constructor with only a double
 * @param dbl The double to initialize the attribute
 */
CConvert::CConvert(double dbl) {
 	//Initializes the two attributes
	this->m_Dbl = dbl;

	//Creates the string
	ostringstream tmp;
	tmp << dbl;
	this->m_Str = tmp.str();

	//Then prints a message
<<<<<<< HEAD
	cout << "Construction et initialisation des variables à une valeur et à \"\" de l'objet CConvert d'adresse : " << this << endl;
=======
	cout << "Construction et initialisation des variables à " << dbl << " et à " << this->m_Str << " de l'objet CPoint d'adresse : " << this << endl;
>>>>>>> f0b12885ff959259ac042aa9fb89f40fea17afbc
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
string CConvert::getString() {
	return this -> m_Str;
}


/**
 * Accessor of the double
 * @return The double of this object
 */
double CConvert::getDouble() {
	return this -> m_Dbl;
}

/**
* Presentation method to print attributes
*/
void CConvert::presentation() {
	cout << "String attribute = " << this -> m_Str << "Double attribute = " << this -> m_Dbl << endl;
}

/**
* the affiche methode
*/
void CConvert::affiche() {
	double f = this -> m_Dbl;
	std::cout << std::setprecision(5) << "La valeur est : " << f << '\n';

}