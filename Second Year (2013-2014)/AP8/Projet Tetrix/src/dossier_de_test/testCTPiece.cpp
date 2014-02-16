//Test class of CTPiece

#include "testCTPiece.h"

/**
	\brief Main method to test the CTPiece class
 */

int main () {

//Initialisation
	//Creates the color vector
	const CVector3 color (0.0f, 1.0f, 0.0f);

	//Creates some objects CTPiece
	CTPiece* c1 = new CTPiece(3, 500, 500, color);
	CTPiece* c2 = new CTPiece(3, 400, 400, color);
	CTPiece* c3 = new CTPiece(3, 300, 300, color);

	//Initialize the shapes
	c1 -> Turn();
	c2 -> Turn();
	c3 -> Turn();

	cout << "The initialisation succeed." << endl;


//Test of methods
	//Test of GetColIndex()
	cout << "Test of GetColIndex():" << endl;
	cout << "The colIndex of c1 " << c1 -> GetColIndex() << endl;
	cout << "The colIndex of c2 " << c2 -> GetColIndex() << endl;
	cout << "The colIndex of c3 " << c3 -> GetColIndex() << endl;


	//Test of GetColor()
	cout << "Test of GetColor():" << endl;
	cout << "The color of c1 " << c1 -> GetColor() << endl;
	cout << "The color of c2 " << c2 -> GetColor() << endl;
	cout << "The color of c3 " << c3 -> GetColor() << endl;

	//Destruction of c1, c2 and c3
	delete c1;
	delete c2;
	delete c3;

}