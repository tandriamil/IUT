#include "CManFch.h"

int main () {

	CManFch f1 ("/home/galvorn/Téléchargements/coin.txt");
	f1.afficherAttributs();
	f1.afficherFichier();

	CManFch f2 ("/home/galvorn/Téléchargements/coin.ach");
	f2.afficherAttributs();
	f2.afficherFichier();

	/*CManFch f3 ("/home/nap/Téléchargements/coin.bin");
	f3.afficherAttributs();
	f3.afficherFichier();*/

}
