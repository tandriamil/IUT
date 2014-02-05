#include "TestCArmada.h"

/**
* the main method
*/
int main() {
	CArmada c1 (8); // test constructeur
	cout << "adresse du pointeur retourné par l'accesseur : " << c1.getTabSM() << endl; // test accesseur pointeur
	cout << "nombre de sous-marins présents renvoyés par l'accesseur = " << c1.getNbSub () << endl; // test accesseur nb sous-marins
	c1.remplirStruct();

	cout << "\n exécution de la classe de test terminée ! \n" << endl;
}