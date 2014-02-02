//Include its Exo7.h
#include "Exo7.h"

/**
 * The main method
 */
int main() {
	//For the getline() method
	const int maxSize = 121;
	const char delimiter = '\n';

	//The tab to store the occurence value of each letters
	int tab[26];

	//Initialize each cells to 0
	for (int x = 0; x < 26; x++) {
		tab[x] = 0;
	}

	//The pointers to travel the buffer
	char *p1;

	//To store the text enterred
	char text[maxSize];

	//Gets the message enterred
	cout << "Veuillez entrer le message: " << delimiter;
	cin.getline(text, maxSize, delimiter);

	//Link the pointer to its tab
	p1 = &text[0];

	//The ascii code of a letter
	int majuscule = 65;  // = A
	int minuscule = 97;  // = a

	//Travels it
	for (int i = 0; i < maxSize; i++) {

		//Look the char in this cell
		for (int j = 0; j <= 26; j++) {

			//If it's the letter
			if ((*p1 == (char)(majuscule + j)) || (*p1 == (char)(minuscule + j))) {
				cout << "La lettre est le " << *p1 << delimiter;
				cout << "La lettre majuscule est le " << (char)(majuscule + j) << delimiter;
				tab[j]++;
			}
		}

		//Increments the value of the pointer on the text enterred
		p1++;
	}

	//Then show the values in the tab
	cout << "Les valeurs du tableau:" << delimiter;
	for (int y = 0; y < 26; y++) {
		cout << " est apparu " << tab[y] << " fois." << delimiter;
	}
}