//Test class of CIPiece

#include "testCIPiece.h"

/**
	\brief Main method to test the CIPiece class
 */
int main {
//Initialisation
	//Creates the color vector
	CVector3 color = CVector3(0.0f, 1.0f, 0.0f);

	//Creates some objects CIPiece
	CIPiece c1 = new CIPiece(3, 500, 500, &color);
	CIPiece c2 = new CIPiece(3, 400, 400, &color);
	CIPiece c3 = new CIPiece(3, 300, 300, &color);

	//

	cout << "The initialisation succeed." << endl;


//Test of methods
	//Test of GetColIndex()
	cout << "Test of GetColIndex():" << endl;
	cout << "The colIndex of c1 " << c1.GetColIndex() << endl;
	cout << "The colIndex of c2 " << c2.GetColIndex() << endl;
	cout << "The colIndex of c3 " << c3.GetColIndex() << endl;

}