#ifndef __TEST_CIPIECE_H__
#define __TEST_CIPIECE_H__

class testCIPiece {

	public:
		CIPiece(unsigned int dim, int iX, int iY, const CVector3& color);
		~CIPiece();
		void Turn();

};

#endif