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
		COPiece(unsigned int dim, int iX, int iY, const CVector3& color);
		void Turn();
};

 #endif