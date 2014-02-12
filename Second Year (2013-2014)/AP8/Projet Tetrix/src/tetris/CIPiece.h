#ifndef __CIPIECE_H__
#define __CIPIECE_H__

#include "CPieceAbstract.h"

class CIPiece : public CPieceAbstract {

	public:
		CIPiece(unsigned int dim, int iX, int iY);
		~CIPiece();
		void Turn();

};

#endif