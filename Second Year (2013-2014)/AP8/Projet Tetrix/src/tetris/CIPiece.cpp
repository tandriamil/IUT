#include "CIPiece.h"

/**
	\brief Constructor of CIPiece, no parameters because it'll creates them
*/
CIPiece::CIPiece(unsigned int dim, int iX, int iY) {
	//Creates the color of those pieces
	CVector3 col = new CVector3(17.0f/255.0f,218.0f/255.0f,84.0f/255.0f);
	
	//Call the super constructor
	super(dim, iX, iY, &col);

	//Prints a log message
	cout << "CIPiece created in case " << this << endl;
}


/**
	\brief Desctructor of CIPiece
*/
CIPiece::~CIPiece() {
	cout << "CIPiece in case " << this << " deleted";
}


/**
	\brief Turns the piece
*/
void Turn() {
	
}