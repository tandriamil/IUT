//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================

#ifndef __COPIECE_H__	
#define __COPIECE_H__

#include "CPieceAbstract.h"

//-------------------------------------------------------------------------------------------------------------------
/**
	\brief classe CPieceAbstract abstraite
*/
//-------------------------------------------------------------------------------------------------------------------

class COPiece : public CPieceAbstract {

	public:
		~COPiece();
		COPiece(unsigned int dim, int iX, int iY);
		Turn();
}