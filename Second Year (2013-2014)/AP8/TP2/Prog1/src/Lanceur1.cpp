#include "Lanceur1.h"

int main() {
	CVect1 a(5); //Appelle implicitement le constructeur avec un paramètre int
	fct(a);
	return 0;
}

/************************/

void fct (CVect1 b) {
	cout << "Appel de la fonction" << endl;
}
