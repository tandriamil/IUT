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
		//Clean the grid
		for (unsigned int i = 0; i < this->m_dim; i++) {
			for (unsigned int j = 0; j < this->m_dim; j++) {
				this->m_table[i][j] = 0;
			}
		}

		//Colors the correct shape
		this->m_table[1][0] = 1;
		this->m_table[1][1] = 1;
		this->m_table[1][2] = 1;

	}

	//If it's horizontal
	else {
		//Clean the grid
		for (unsigned int i = 0; i < this->m_dim; i++) {
			for (unsigned int j = 0; j < this->m_dim; j++) {
				this->m_table[i][j] = 0;
			}
		}

		//Colors the correct shape
		this->m_table[0][1] = 1;
		this->m_table[1][1] = 1;
		this->m_table[2][1] = 1;
	}


	// disposition des axes de la matrice sur la grille avec la pièce
		//		j2	.	1	.
		//		j1	.	1	.
		//		j0	.	1	.
		//		   x0   x1 	x2


}
