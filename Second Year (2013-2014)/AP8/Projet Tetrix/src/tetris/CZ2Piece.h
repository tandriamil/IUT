#ifndef __CZ2Piece_H__
#define __CZ2Piece_H__

#include "CPieceAbstract.h"

class CZ2Piece : public CPieceAbstract {

	public:
		CZ2Piece(unsigned int dim, int iX, int iY, const CVector3& color);
		~CZ2Piece();
		void Turn();

};

#endif /*__CZ2Piece_H__*/