#include "CManFch.h"

int main () {

	CManFch f1 ("/home/nap/Téléchargements/coin.txt");
	f1.afficherAttributs();
	f1.afficherFichier();

	CManFch f2 ("/home/nap/Téléchargements/coin.ach");
	f2.afficherAttributs();

}