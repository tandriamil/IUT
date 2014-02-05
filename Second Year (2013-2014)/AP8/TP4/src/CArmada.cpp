#include "CArmada.h"

/**
* constructor with the number of submarines in parameter
* and initialising the table at this number
* @param nbsub the number of submarine
*/
CArmada :: CArmada (int nbsub) {
	this -> m_pTabSousMarins = new string [nbsub];
}

/*
* accessor of the pointer of the table of submarines
* @return the pointer m_pTabSousMarins
*/
string* CArmada :: getTabSM() {
	return this -> m_pTabSousMarins;
}

/*
* accessor of the number of submarines
* @return the number of submarine m_nbTotSSM
*/
int CArmada :: getNbSub () {
	return this -> m_nbTotSSM;
}

/**
* method filling the table with the coordinates entered by the user
*/
void CArmada :: remplirStruct () {
	char chain[2];
}
	

/**
* destructor of CArmada
*/
CArmada :: ~CArmada () {
	cout << "destruction de l'objet CArmada d'adresse : " << this << "et libération de l'espace mémoire du tableau " << "\n" << endl;
	delete [] m_pTabSousMarins;
}


/**
 * Analyses a string to know if it's correct
 * @param saisie The string ot analyse
 * @throw logic_error If the chars enterred isn't correct
 */
CArmada :: analyser(string saisie) {
	//If the string does'nt have exactrly 2 chars
	if (!(saisie.size() == 2)) {
		throw logic_error("Taille du string entré incorrect.");
	}

	//If it has exactly 2 chars
	else {
		//Gets the two letters
		char firstLetter = saisie.at(0);
		char secondLetter = saisie.at(1);

		//Displays the chars casted
		cout << "Le cast du premier caractère: " << (int)firstLetter << " , et le deuxième: " << (int)secondLetter << endl;

		//Verify if the first is between A and J
		if (!(((int)firstLetter >= 65) && ((int)firstLetter <= 74))) {
			throw logic_error("Premier caractère incompatible.");
		}

		//If the first char is ok
		else {
			//Verify if the second letter is between 0 and 9
			if (!(((int) secondLetter >= 48) && ((int)secondLetter <= 57))) {
				throw logic_error("Deuxième caractère incompatible.");
			}
		}
	}
}