#include "CIPiece.h"

/**
	\brief Constructor of CIPiece
*/
CIPiece::CIPiece(unsigned int dim, int iX, int iY, const CVector3& color) : CPieceAbstract(dim, iX, iY, color) {
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
void CIPiece::Turn() {
	//Colors the grids in function of the actual new state

	//If it's vertical
	if ((this->m_state == S_Top) || (this->m_state == S_Bottom)) {
		this->m_table[1][0];
		this->m_table[1][1];
		this->m_table[1][2];
	}

	//If it's horizontal
	else {
		this->m_table[0][1];
		this->m_table[1][1];
		this->m_table[2][1];
	}
}