#include "CArmada.h"

/**
* constructor with the number of submarines in parameter
* and initialising the table at this number
* @param nbsub the number of submarine
*/
CArmada :: CArmada (int nbsub) {
	this -> m_pTabSousMarins = new string [nbsub];
}



/**
* destructor of CArmada
*/
CArmada : ~CArmada () {
	cout << "destruction de l'objet CArmada d'adresse : " << this << "et libération de l'espace mémoire du tableau " << "\n" << endl;
	delete [] m_pTabSousMarins;
}


/**
 * Analyses a string to know if it's correct
 * @param saisie The string ot analyse
 */
CArmada :: analyser(string saisie) {
	//If the string does'nt have exactrly 2 chars
	if (!(saisie.size() == 2)) {
		throw logic_error("Taille du string entré incorrect.");
	}

	//If it has exactly 2 chars
	else {
		
	}
}