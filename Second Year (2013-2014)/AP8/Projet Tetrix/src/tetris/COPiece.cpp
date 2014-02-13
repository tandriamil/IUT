#include "COPiece.h"

//-------------------------------------------------------------------------------------------------------------------
//
// classe COPiece
//
//-------------------------------------------------------------------------------------------------------------------

// Constructor of the COPiece class
COPiece::COPiece(unsigned int dim, int iX, int iY, const CVector3& color) : CPieceAbstract(dim, iX, iY, color) {

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
	// Activates the cases to draw the O piece. As the O piece doesn't move, we don't have to initialize the other cases to 0, which are by default
		this->m_table[1][1] = 1;
		this->m_table[1][2] = 1;
		this->m_table[2][1] = 1;
		this->m_table[2][2] = 1;
}

/********************************************************************************************************/