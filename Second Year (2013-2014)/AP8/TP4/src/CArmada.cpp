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
	char coordinates[2];
	char stopchar = '\n';
	for (int i=0; i < m_nbTotSSM; i++) {
		cout << "enter the coordinates of the submarine : " << endl;
	  	cin.getline(coordinates, 2, stopchar);
	  	cout << "coordonnées " << coordinates << " à la case " << i+1 << endl;
    }
}
	

/**
* destructor of CArmada
*/
CArmada :: ~CArmada () {
	cout << "destruction de l'objet CArmada d'adresse : " << this << "et libération de l'espace mémoire du tableau " << "\n" << endl;
	delete [] m_pTabSousMarins;
}