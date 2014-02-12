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
	TPieceRow rows = TPieceRow ( dim, 0 );
	m_table = TPieceTable ( dim, rows );
	m_state = S_Top;
	m_colIndex = iX;
	m_rowIndex = iY;
	m_color = color;
}

CPieceAbstract::~CPieceAbstract()
{
}