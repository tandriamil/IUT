#include "CZ1Piece.h"

/**
	\brief Constructor of CZ1Piece
*/
CZ1Piece::CZ1Piece(unsigned int dim, int iX, int iY, const CVector3& color) : CPieceAbstract(dim, iX, iY, color) {
	//Prints a log message
	cout << "CZ1Piece created in case " << this << endl;
}


/**
	\brief Desctructor of CZ1Piece
*/
CZ1Piece::~CZ1Piece() {
	cout << "CZ1Piece in case " << this << " deleted";
}


/**
	\brief Turns the piece
*/
void CZ1Piece::Turn() {
	//Colors the grids in function of the actual new state

	switch (m_state)
	{
		//If it's top
		case S_Top:
		{
			for (unsigned int i = 0; i < this->m_dim; i++) {
				for (unsigned int j = 0; j < this->m_dim; j++) {
					this->m_table[i][j] = 0;
				}
			}
			// /!\ attention aux cases et aux axes de la matrice
			// qui n'ont pas la même disposition qu'avec tableau à 2 dimensions classique
			m_table[0][0]=1;
			m_table[0][1]=1;
			m_table[1][1]=1;
			m_table[1][2]=1;
			break;
		}
		//If it's bottom
		case S_Bottom:
		{
			for (unsigned int i = 0; i < this->m_dim; i++) {
				for (unsigned int j = 0; j < this->m_dim; j++) {
					this->m_table[i][j] = 0;
				}
			}
			// /!\ attention aux cases et aux axes de la matrice
			// qui n'ont pas la même disposition qu'avec tableau à 2 dimensions classique
			m_table[1][0]=1;
			m_table[1][1]=1;
			m_table[2][1]=1;
			m_table[2][2]=1;
			break;
		}
		//If it's left
		case S_Left:
		{
			for (unsigned int i = 0; i < this->m_dim; i++) {
				for (unsigned int j = 0; j < this->m_dim; j++) {
					this->m_table[i][j] = 0;
				}
			}
			// /!\ attention aux cases et aux axes de la matrice
			// qui n'ont pas la même disposition qu'avec tableau à 2 dimensions classique
			m_table[0][1]=1;
			m_table[1][0]=1;
			m_table[1][1]=1;
			m_table[2][0]=1;
			break;
		}
		//If it's right
		case S_Right:
		{
			for (unsigned int i = 0; i < this->m_dim; i++) {
				for (unsigned int j = 0; j < this->m_dim; j++) {
					this->m_table[i][j] = 0;
				}
			}
			// /!\ attention aux cases et aux axes de la matrice
			// qui n'ont pas la même disposition qu'avec tableau à 2 dimensions classique
			m_table[0][2]=1;
			m_table[1][1]=1;
			m_table[1][2]=1;
			m_table[2][1]=1;
			break;
		}

		// disposition des axes de la matrice sur la grille
		//		j2	.	1	.
		//		j1	.	1	.
		//		j0	1	1	.
		//		   x0   x1 	x2

	}
}
