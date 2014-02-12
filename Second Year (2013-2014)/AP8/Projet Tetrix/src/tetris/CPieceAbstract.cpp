//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================

#include "CPieceAbstract.h"

//-------------------------------------------------------------------------------------------------------------------
//
// classe CPieceAbstract
//
//-------------------------------------------------------------------------------------------------------------------

CPieceAbstract::CPieceAbstract ( unsigned int dim, int iX, int iY, const CVector3& color ) {
	m_dim = dim;
	TPieceRow rows = TPieceRow (dim, 0);
	m_table = TPieceTable (dim, rows);
	m_state = S_Top;
	m_colIndex = iX;
	m_rowIndex = iY;
	m_color = color;
}

/****************************************/

CPieceAbstract::~CPieceAbstract() {
	cout << "Piece correctement detruite." << endl;
}

/****************************************/
/* accesseur m_table */

TPieceTable& CPieceAbstract::GetTable() {
	return this->m_table;
}

/****************************************/
/* modificateur m_table */

void CPieceAbstract::SetTable(const TPieceTable& table) {
	this->m_table = table;
}

/****************************************/
/* accesseur m_colIndex */

int CPieceAbstract::GetColIndex() {
	return this->m_colIndex;
}

/****************************************/
/* accesseur m_rowIndex */

int CPieceAbstract::GetRowIndex() {
	return this->m_rowIndex;
}

/****************************************/
/* modificateur m_rowIndex */

void CPieceAbstract::SetIncDecRowIndex(int val) {
	this->m_rowIndex = this->m_rowIndex + val;
}

/****************************************/
/* modificateur ajouteur m_colIndex */

void CPieceAbstract::SetIncDecColIndex(int val) {
	this->m_colIndex = this->m_colIndex + val;
}

/****************************************/
/* modificateur m_colIndex */

void CPieceAbstract::SetColIndex(int newColIndex) {
	this->m_colIndex = newColIndex;
}

/****************************************/
/* modificateur m_rowIndex */

void CPieceAbstract::SetRowIndex(int newRowIndex) {
	this->m_rowIndex = newRowIndex;
}

/****************************************/
/* accesseur m_color */

const CVector3& CPieceAbstract::GetColor() {
	return this->m_color;
}

/****************************************/
/* turn right method */

void CPieceAbstract::TurnRight() {

	switch (m_state)
	{
		case S_Top:
		{
			this -> m_state = S_Right;
			break;
		}

		case S_Bottom:
		{
			this -> m_state = S_Left;
			break;
		}

		case S_Left:
		{
			this -> m_state = S_Top;
			break;
		} 

		case S_Right:
		{
			this -> m_state = S_Bottom;
		}
	}
	
}

/**************************************/
/* turn left method */

void CPieceAbstract::TurnLeft() {

	switch (m_state)
	{
		case S_Top:
		{
			this -> m_state = S_Left;
			break;
		}

		case S_Bottom:
		{
			this -> m_state = S_Right;
			break;
		}

		case S_Left:
		{
			this -> m_state = S_Bottom;
			break;
		} 

		case S_Right:
		{
			this -> m_state = S_Top;
		}
	}
}		


/****************************************/

/*friend ostream& CPieceAbstract::operator<< (ostream& flux, const CPieceAbstract& p) {
	
}
*/