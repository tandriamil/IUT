#ifndef __CL2Piece_H__
#define __CL2Piece_H__

#include "CPieceAbstract.h"

class CL2Piece : public CPieceAbstract {

	public:
		CL2Piece(unsigned int dim, int iX, int iY, const CVector3& color);
		~CL2Piece();
		void Turn();

};

#endif /*__CL2Piece_H__*/
