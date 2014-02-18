//Test class of CIPiece

#include "testCIPiece.h"
#include "CProjetTetrisPiece.h"
#include "CTPiece.h"
#include "CGuiGlut.h"

/**
	\brief Main method to test the CIPiece class
 */

int main ( int argc, char *argv[] ) {

//Initialisation
	//Creates the color vector
	const CVector3 color(0.0f, 1.0f, 0.0f);

	//Creates some objects CIPiece
	CIPiece* c1 = new CIPiece(3, 500, 450, color);
	CIPiece* c2 = new CIPiece(3, 400, 350, color);

	cout << "\n The initialisation succeeded." << endl;


//Test of methods

	//Test of GetColIndex()
	cout << "\n Test of GetColIndex() : " << endl;
	cout << "The colIndex of c1 : " << c1 -> GetColIndex() << endl;
	cout << "The colIndex of c2 : " << c2 -> GetColIndex() << endl;

	//Test of GetRowIndex()
	cout << "\n Test of GetRowIndex() : " << endl;
	cout << "The rowIndex of c1 : " << c1 -> GetRowIndex() << endl;
	cout << "The rowIndex of c2 : " << c2 -> GetRowIndex() << endl;

	//Test of GetColor()
	cout << "\n Test of GetColor() : " << endl;
	cout << "The color of c1 : " << c1 -> GetColor() << endl;
	cout << "The color of c2 : " << c2 -> GetColor() << endl;




	//Test of SetColIndex(x)
	cout << "\n Test of SetColIndex(x) : " << endl;
	c1 -> SetColIndex(123);
	cout << "The colIndex of c1 after modification : " << c1 -> GetColIndex() << endl;
	c2 -> SetColIndex(321);
	cout << "The colIndex of c2 after modification : " << c2 -> GetColIndex() << endl;

	//Test of SetIncDecColIndex(x)
	cout << "\n Test of SetIncDecColIndex(x) : " << endl;
	c1 -> SetIncDecColIndex(1);
	cout << "The rowIndex of c1 after incrementation : " << c1 -> GetColIndex() << endl;
	c2 -> SetIncDecColIndex(-1);
	cout << "The rowIndex of c2 after decrementation : " << c2 -> GetColIndex() << endl;




	//Test of setRowIndex(y)
	cout << "\n Test of SetRowIndex(y) : " << endl;
	c1 -> SetRowIndex(456);
	cout << "The rowIndex of c1 after modification : " << c1 -> GetRowIndex() << endl;
	c2 -> SetRowIndex(654);
	cout << "The rowIndex of c2 after modification : " << c2 -> GetRowIndex() << endl;


	//Test of SetIncDecRowIndex(y)
	cout << "\n Test of SetIncDecRowIndex(y) : " << endl;
	c1 -> SetIncDecRowIndex(1);
	cout << "The rowIndex of c1 after incrementation : " << c1 -> GetRowIndex() << endl;
	c2 -> SetIncDecRowIndex(-1);
	cout << "The rowIndex of c2 after decrementation : " << c2 -> GetRowIndex() << endl;




	//Test of Turn(), TurnLeft(), TurnRight() and operator overriding

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


CProjetTetrisPiece* monProjet = new CProjetTetrisPiece();
	CGuiGlut::InitializeGraphics ( argc, argv, monProjet );
	CGuiGlut::RunGraphics();
	delete monProjet;

}