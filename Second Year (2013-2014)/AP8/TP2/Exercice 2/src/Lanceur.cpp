#include "Lanceur.h"

int main() {

	CPoint cVal1(4, 5);
	CPoint cRef1(1, 2);
	CPoint *cPoint = new CPoint(8, 9);

	functionByValue(cVal1);
	functionByReference(cRef1);
	functionByPointer(cPoint);

	delete cPoint;

}



/**
* Function using the object sent by value
*/
void functionByValue (CPoint cVal) {
	cVal.presentation ();
}


/**
* Function using the object sent by reference
*/
void functionByReference (CPoint &cRef) {
	cRef.presentation ();
}



/**
* Function using the object sent by a pointer
*/
void functionByPointer (CPoint *cPoint) {
	cPoint -> presentation();
}



/**
* Function using the object sent by table 
*/
