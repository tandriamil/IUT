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

TPieceTable& CPieceAbstract::GetTable() {
	return this->m_table;
}

/****************************************/

void CPieceAbstract::SetTable(const TPieceTable& table) {
	this->m_table = table;
}

/****************************************/

int CPieceAbstract::GetColIndex() {
	return this->m_colIndex;
}

/****************************************/

int CPieceAbstract::GetRowIndex() {
	return this->m_rowIndex;
}

/****************************************/

void CPieceAbstract::SetIncDecRowIndex(int val) {
	this->m_rowIndex = this->m_rowIndex + val;
}

/****************************************/

void CPieceAbstract::SetIncDecColIndex(int val) {
	this->m_colIndex = this->m_colIndex + val;
}

/****************************************/

void CPieceAbstract::SetColIndex(int newColIndex) {
	this->m_colIndex = newColIndex;
}

/****************************************/

void CPieceAbstract::SetRowIndex(int newRowIndex) {
	this->m_rowIndex = newRowIndex;
}

/****************************************/

const CVector3& CPieceAbstract::GetColor() {
	return this->m_color;
}

/****************************************/

/*friend ostream& CPieceAbstract::operator<< (ostream& flux, const CPieceAbstract& p) {
	
}
*/