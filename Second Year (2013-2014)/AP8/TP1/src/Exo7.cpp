//Include its Exo7.h
#include "Exo7.h"

/**
 * The main method, here it'll just display "Ca marche!"
 */
int main() {
	//The max size
	const int maxSize = 121;

	//The delimiter
	char delimiter = '\n';

	//The pointer which points the buffer
	char *pCh;

	//The tab where we'll count the number of occurence of a letter
	int tab[26];

	//The pointers to point on tab and pCh
	char *p1;
	int *p2;

	//Displays the message
	cout << "Entrez une chaîne de caractère:";

	cin.getline(*pCh, maxSize, '\n');
}