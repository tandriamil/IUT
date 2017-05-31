#ifndef __CL1PIECE_H__
#define __CL1PIECE_H__

#include "CPieceAbstract.h"

class CL1Piece : public CPieceAbstract {

	public:
		CL1Piece(unsigned int dim, int iX, int iY, const CVector3& color);
		~CL1Piece();
		void Turn();

};

#endif /*__CL1PIECE_H__*/
