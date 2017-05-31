#include "TestCPoint.h"

/**
 * The main method
 */
int main() {


	// test of constructors and presentation method

	CPoint c1(4, 8); // constructor with parameters
	cout << "présentation de c1 : " << endl;
	c1.presentation();

	CPoint c2; // constructor without parameter
	cout << "présentation de c2 : " << endl;
	c2.presentation();

	CPoint c3(c1); // constructor with reference initialisation
	cout << "présentation de c3 : " << endl;
	c3.presentation();


	// test of modificators

	c1.setAbs(5);
	c1.setOrd(6);
	cout << "présentation de c1 après modifications par les set() : " << endl;
	c1.presentation();

	c2.setAbs(1);
	c2.setOrd(2);
	cout << "présentation de c2 après modifications par les set() : " << endl;
	c2.presentation();

	c3.setAbs(12);
	c3.setOrd(13);
	cout << "présentation de c3 après modifications par les set() : " << endl;
	c3.presentation();


	// test of accessors

	cout << "test des accesseurs d'abscisses" << endl;
	cout << "abscisse de c1 : " << c1.getAbs() << endl;
	cout << "abscisse de c2 : " << c2.getAbs() << endl;
	cout << "abscisse de c3 : " << c3.getAbs() << "\n" << endl;

	cout << "test des accesseurs d'ordonnées" << endl;
	cout << "ordonnée de c1 : " << c1.getOrd() << endl;
	cout << "ordonnée de c2 : " << c2.getOrd() << endl;
	cout << "ordonnée de c3 : " << c3.getOrd() << "\n" <<endl;


	//test of destructor on pointer type object

	CPoint* pc1 = new CPoint (0,0);
	pc1 -> presentation();

	CPoint* pc2 = new CPoint (0,1);
	pc2 -> presentation();

	CPoint* pc3 = new CPoint (0,2);
	pc3 -> presentation();

	cout << "destruction de pc1 : " << endl;
	delete pc1;

	cout << "destruction de pc2 : " << endl;
	delete pc2;

	cout << "destruction de pc3 : " << endl;
	delete pc3;

	cout << "destruction des objets c1, c2 et c3 crées statiquement : " << endl;

	return 0;
}
