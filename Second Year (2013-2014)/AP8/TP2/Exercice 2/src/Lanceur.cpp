#include "Lanceur.h"

/**
 * The main method
 */
int main() {

	// test of constructors and presentation method
	CPoint c1(4, 8);
	c1.presentation(); 
	CPoint c2;
	c2.presentation();
	CPoint c3(c1);
	c3.presentation();


	// test of modificators 
	c1.setAbs(5);
	c1.setOrd(6);
	c1.presentation();

	c2.setAbs(1);
	c2.setOrd(2);
	c2.presentation();

	c3.setAbs(12);
	c3.setOrd(13);
	c3.presentation();

	// test of accessors
	cout << "abscisse de c1 : " << c1.getAbs() << endl;
	cout << "abscisse de c2 : " << c2.getAbs() << endl;
	cout << "abscisse de c3 : " << c3.getAbs() << endl;

	cout << "ordonnée de c1 : " << c1.getOrd() << endl;
	cout << "ordonnée de c2 : " << c2.getOrd() << endl;
	cout << "ordonnée de c3 : " << c3.getOrd() << endl;

	return 0;
}