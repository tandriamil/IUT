#include "Lanceur.h"

/**
 * The main method
 */
int main() {
	CPoint c1(4, 8);
	c1.presentation(); 
	CPoint c2;
	c2.presentation();
	CPoint c3(c1);
	c3.presentation();

	c1.setAbs(5);
	c1.setOrd(6);
	c1.presentation();

	c2.setAbs(1);
	c2.setOrd(2);
	c2.presentation();

	c3.setAbs(12);
	c3.setOrd(13);
	c3.presentation();

	return 0;
}