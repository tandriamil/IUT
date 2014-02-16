//Test class of CIPiece

#include "testCIPiece.h"

/**
	\brief Main method to test the CIPiece class
 */

int main() {

//Initialisation
	//Creates the color vector
	const CVector3 color(0.0f, 1.0f, 0.0f);

	//Creates some objects CIPiece
	CIPiece* c1 = new CIPiece(3, 500, 500, color);
	CIPiece* c2 = new CIPiece(3, 400, 400, color);
	CIPiece* c3 = new CIPiece(3, 300, 300, color);

	

	

	

	cout << "\n The initialisation succeeded." << endl;


//Test of methods

	//Test of GetColIndex()
	cout << "\n Test of GetColIndex():" << endl;
	cout << "The colIndex of c1 : " << c1 -> GetColIndex() << endl;
	cout << "The colIndex of c2 : " << c2 -> GetColIndex() << endl;
	cout << "The colIndex of c3 : " << c3 -> GetColIndex() << endl;


	//Test of GetColor()
	cout << "\n Test of GetColor():" << endl;
	cout << "The color of c1 : " << c1 -> GetColor() << endl;
	cout << "The color of c2 : " << c2 -> GetColor() << endl;
	cout << "The color of c3 : " << c3 -> GetColor() << endl;

	//Test of Turn(), TurnLeft() and TurnRight() 


		//Initialize the shapes of c1
		cout << "\n affichage de c1 avant initialisation : " << endl;
		cout << *c1 << endl;

		c1 -> Turn();

		cout << "\n affichage de c1 après initialisation : " << endl;
		cout << *c1 << endl;


		// turns c1 left and checks the modifications in the matrix
		cout << "\n test de rotation à gauche de c1, affichage avant rotation : " << endl;
		cout << *c1 << endl;

		c1 -> TurnLeft();
		c1 -> Turn();

		cout << "\n affichage après rotation : " << endl;
		cout << *c1 << endl;


		//Initialize the shapes of c2
		cout << "\n affichage de c2 avant initialisation : " << endl;
		cout << *c2 << endl;

		c2 -> Turn();

		cout << "\n affichage de c2 après initialisation : " << endl;
		cout << *c2 << endl;


		// turns c2 right and checks the modifications in the matrix
		cout << "\n test de rotation à droite de c2, affichage avant rotation : " << endl;
		cout << *c2 << endl;

		c2 -> TurnRight();
		c2 -> Turn();

		cout << "\n affichage après rotation : " << endl;
		cout << *c2 << endl;


//Destruction of c1, c2 and c3
	delete c1;
	delete c2;
	delete c3;

}