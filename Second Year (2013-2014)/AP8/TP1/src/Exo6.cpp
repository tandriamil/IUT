//Include its Exo5.h
#include "Exo5.h"

/**
 * The main method, asking you to enter a chain of characters
 * and then printing it on the terminal
 */
int main() {
	char chain[120];
	//char stockch[120];
	char stopchar = '\n';

  	std::cout << "Please, enter your chain : ";
  	std::cin.getline (chain,120, stopchar);


  	
  	std::cout << "vous avez entré : " << "\n" << chain << "\n";
  	std::cout << strlen (chain);

  	return 0;
}