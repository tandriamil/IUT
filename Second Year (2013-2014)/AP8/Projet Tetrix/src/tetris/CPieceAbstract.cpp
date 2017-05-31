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
	cout << "\n Piece " << this << " correctement detruite.\n " << endl;
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
			cout << "état de la pièce après rotation = S_Right";
			break;
		}

		case S_Bottom:
		{
			this -> m_state = S_Left;
			cout << "état de la pièce après rotation = S_Left";
			break;
		}

		case S_Left:
		{
			this -> m_state = S_Top;
			cout << "état de la pièce après rotation = S_Top";
			break;
		}

		case S_Right:
		{
			this -> m_state = S_Bottom;
			cout << "état de la pièce après rotation = S_Bottom";
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
			cout << "état de la pièce après rotation = S_Left";
			break;
		}

		case S_Bottom:
		{
			this -> m_state = S_Right;
			cout << "état de la pièce après rotation = S_Right";
			break;
		}

		case S_Left:
		{
			this -> m_state = S_Bottom;
			cout << "état de la pièce après rotation = S_Bottom";
			break;
		}

		case S_Right:
		{
			this -> m_state = S_Top;
			cout << "état de la pièce après rotation = S_Top";
		}
	}

}

/*************************************/
/* method overriding the output stream */
ostream& operator<< ( ostream& flux, const CPieceAbstract& p ) {
	int count = 0;
	for (int i=0; i< 3; i++) {
		for (int j=0; j < 3; j++) {
			count ++;
			if (count%3 == 0) {
				flux << p.m_table[i][j] << endl;
			}
			else {
				flux  << p.m_table[i][j] << "-";
			}
		}
	}
	return flux;

}
