
//Include its Exo6.h
#include "Exo6.h"


/**
 * The main method, asking you to enter a chain of characters
 * and then printing it on the terminal
 */
int main() {

	char chain[120]; // définit un tableau de caractère de longueur 120 maximum
	char stopchar = '\n'; // définit le caractère de fin (ici entrée) pour valider la fin de chaîne

  	std::cout << "Please, enter your chain : "; // demande à l'utilisateur de taper une chaîne de caractère
  	std::cin.getline(chain, 120, stopchar); // lecture de la chaîne entrée par l'utilisateur
  	
  	std::cout << "Vous avez entré : " << chain << "\n"; // affichage de la chaîne entrée
  	std::cout << "La chaîne fait : " << strlen (chain) << " caractères" << "\n"; // affichage de la longueur de la chaîne

  	return 0; // code indiquant que tout s'est bien passé

}