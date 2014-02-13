#include "testCOPiece.h"

int main() {
	// Creates the color of for the O piece
	CVector3 color = new CVector(1.0, 1.0, 0.0)

	// Creates the matrix where the O piece will be
	COPiece o1 = new COPiece(3, 0, 0, &color);
	COPiece o2 = new COPiece(3, 0, 0, &color);
	COPiece o3 = new COPiece(3, 0, 0, &color);

	cout << "Constructors initialized" << endl;

	// Tests of methods (whose CPieceAbstract)
	o1.Turn();
	o2.Turn();
	o3.Turn();
}