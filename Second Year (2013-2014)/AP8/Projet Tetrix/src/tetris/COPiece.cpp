#include "COPiece.h"

//-------------------------------------------------------------------------------------------------------------------
//
// classe COPiece
//
//-------------------------------------------------------------------------------------------------------------------

// Constructor of the COPiece class
COPiece::COPiece(unsigned int dim, int iX, int iY) {
	// Creates the color of the O piece
	CVector3 col = new CVector3(1.0, 1.0, 0.0)

	// We call the attributes of the super-class
	super(dim, iX, iY, &col);

	cout << "COPiece created in case " << this << endl;
}

/********************************************************************************************************/

/**
* The destructor
*/
COPiece::~COPiece() {

	cout << "COPiece in case " << this << " deleted " << endl;
}

/********************************************************************************************************/

/**
* The method turn which allows to rotate the piece in terms of its state
*/
void COPiece::Turn() {
	// 1st case : where the O piece is turned once
	if ((this -> m_state == S_Top) || (this -> m_state == S_Bottom)) {
		
	}
	
}

/********************************************************************************************************/