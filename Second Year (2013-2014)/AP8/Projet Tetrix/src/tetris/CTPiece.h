#ifndef __CTPIECE_H__
#define __CTPIECE_H__

#include "CPieceAbstract.h"

class CTPiece : public CPieceAbstract {

	public:
		CTPiece(unsigned int dim, int iX, int iY, const CVector3& color);
		~CTPiece();
		void Turn();

};

#endif /*__CTPIECE_H__*/