#include "CPoint.h"

/**
 * The first constructor with parameters
 * @param x The x value
 * @param y The y value
 */
CPoint :: CPoint (int x, int y) {
	//Initializes the two attributes
	this -> m_Abs = x;
	this -> m_Ord = y;

	//Then prints a message
	cout << "Construction et initialisation par paramètres de l'objet CPoint d'adresse : " << this << endl;
	
}


/**
 * The second constructor without parameters
 */
CPoint :: CPoint () {
	this -> m_Abs = 0;
	this -> m_Ord = 0;
	//Just prints a message
	cout << "Construction de l'objet CPoint sans paramètres et initialisation des paramètres à 0 à l'adresse : " << this << "." << endl;
}


/**
 * The copy constructor
 * @param toCopy The object to copy, const to set it to not editable
 */
CPoint :: CPoint (const CPoint& toCopy) {
		this -> m_Abs = toCopy.m_Abs;
		this -> m_Ord = toCopy.m_Ord; 
	cout << "Copy constructor operation is a success, sir, " << "and adress is " << this << "." << endl;
}

/**
* accessor of m_Abs
* @return the integer m_Abs
*/
int CPoint :: getAbs () {
	return this -> m_Abs;
}

/**
* accessor of m_Ord
* @return the integer m_Ord
*/
 int CPoint :: getOrd () {
	return this -> m_Ord;
}

/**
* modificator of m_Abs
* @param an integer x to replace the original value
*/
void CPoint :: setAbs (int x) {
	this -> m_Abs = x;
}

/**
* modificator of m_Ord
* @param an integer y to replace the original value
*/
void CPoint :: setOrd (int y) {
	this -> m_Ord = y;
}

/**
* presentation method
*/
void CPoint :: presentation () {
	cout << "abscisse = " << this -> m_Abs << " " << "ordonnée = " << this -> m_Ord << "\n" << endl;
}

/**
* destructor
*/
CPoint :: ~CPoint () {
	cout << "destruction de l'objet CPoint d'adresse : " << this << "\n" << endl;
}