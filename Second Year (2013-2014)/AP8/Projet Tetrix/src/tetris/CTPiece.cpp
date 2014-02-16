#include "CTPiece.h"

/**
	\brief Constructor of CTPiece
*/
CTPiece::CTPiece(unsigned int dim, int iX, int iY, const CVector3& color) : CPieceAbstract(dim, iX, iY, color) {
	//Prints a log message
	cout << "CTPiece created in case " << this << endl;
}


/**
	\brief Desctructor of CTPiece
*/
CTPiece::~CTPiece() {
	cout << "CTPiece in case " << this << " deleted";
}


/**
	\brief Turns the piece
*/
void CTPiece::Turn() {
	//Colors the grids in function of the actual new state
	
	switch (m_state)
	{
		//If it's top
		case S_Top:
		{
			m_table[1][0]=1;
			m_table[1][1]=1;
			m_table[1][2]=1;
			m_table[2][1]=1;
			break;
		}
		//If it's bottom
		case S_Bottom:
		{
			m_table[1][1]=1;
			m_table[2][0]=1;
			m_table[2][1]=1;
			m_table[2][2]=1;
			break;
		}
		//If it's left
		case S_Left:
		{
			m_table[0][1]=1;
			m_table[1][0]=1;
			m_table[1][1]=1;
			m_table[2][1]=1;
			break;
		} 
		//If it's right
		case S_Right:
		{
			m_table[0][1]=1;
			m_table[1][1]=1;
			m_table[1][2]=1;
			m_table[2][1]=1;
			break;
		}
	}
}