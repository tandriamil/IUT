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