#ifndef __CZ1Piece_H__
#define __CZ1Piece_H__

#include "CPieceAbstract.h"

class CZ1Piece : public CPieceAbstract {

	public:
		CZ1Piece(unsigned int dim, int iX, int iY, const CVector3& color);
		~CZ1Piece();
		void Turn();

};

#endif /*__CZ1Piece_H__*/
