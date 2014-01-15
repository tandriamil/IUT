<<<<<<< HEAD
//Include its Exo6.h
#include "Exo6.h"

=======

//Include its Exo6.h
#include "Exo6.h"


>>>>>>> 8a94e2aaed740dd9178532bf5c2d4d4db64f40e6
/**
 * The main method, asking you to enter a chain of characters
 * and then printing it on the terminal
 */
int main() {
<<<<<<< HEAD
	string s;
	cout << "entrez votre chaîne de caractères";
	cin >> s;
	cout << strlen(s);
=======

	char chain[120];
	//char stockch[120];
	char stopchar = '\n';

  	std::cout << "Please, enter your chain : ";
  	std::cin.getline (chain,120, stopchar);


  	
  	std::cout << "vous avez entré : " << "\n" << chain << "\n";
  	std::cout << strlen (chain);

  	return 0;


>>>>>>> 8a94e2aaed740dd9178532bf5c2d4d4db64f40e6
}