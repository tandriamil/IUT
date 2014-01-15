<<<<<<< HEAD
//Include its Exo6.h
#include "Exo6.h"

/**
 * The main method, here it'll just display "Ca marche!"
 */
int main() {
	cout << "Coucou! Tu veux ... \n";
=======
//Include its Exo5.h
#include "Exo5.h"

/**
 * The main method, asking you to enter a chain of characters
 * and then printing it on the terminal
 */
int main() {
<<<<<<< HEAD
	char chain[120];
	//char stockch[120];
	char stopchar = '\n';

  	std::cout << "Please, enter your chain : ";
  	std::cin.getline (chain,120, stopchar);


  	
  	std::cout << "vous avez entré : " << "\n" << chain << "\n";
  	std::cout << strlen (chain);

  	return 0;
=======
	string s;
	cout << "entrez votre chaîne de caractères";
	cin >> s;
	cout << strlen(s);
>>>>>>> 3036b70027bdc320ff950bd83c2a5cbb05cf171e
>>>>>>> 659d170cabe23b8511448459de80be813db94a18
}