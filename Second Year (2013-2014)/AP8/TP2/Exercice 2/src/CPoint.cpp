#include "CPoint.h"

/**
 * The first constructor with parameters
 * @param x The x value
 * @param y The y value
 */
CPoint :: CPoint (int x, int y) {
	//Initializes the two attributes
	m_Abs = x;
	m_Ord = y;

	//Then prints a message
	cout << "Construction de l'objet CPoint d'adresse : " << this << endl;
	cout << "Abscisses initilisées à " << m_Abs << " et Ordonnées à " << m_Ord << "." << endl;
}


/**
 * The second constructor without parameters
 */
CPoint :: CPoint () {
	m_Abs = 0;
	m_Ord = 0;
	//Just prints a message
	cout << "Construction de l'objet CPoint sans paramètres et initialisation des paramètres à 0 : " << this << endl;
}


/**
 * The copy constructor
 * @param toCopy The object to copy, const for not editing it
 */
CPoint :: CPoint (const CPoint& toCopy) {
		m_Abs = toCopy.m_Abs;
		m_Ord = toCopy.m_Ord; 
	cout << "Copy constructor operation is a success, sir !!" << this << endl;
}

/**
* accessor of m_Abs
* @return the integer m_Abs
*/
int CPoint :: getAbs () {
	return  m_Abs;
}

/**
* accessor of m_Ord
* @return the integer m_Ord
*/
 int CPoint :: getOrd () {
	return m_Ord;
}

/**
* modificator of m_Abs
* @param an integer x to replace the original value
*/
void CPoint :: setAbs (int x) {
	m_Abs = x;
}

/**
* modificator of m_Ord
* @param an integer y to replace the original value
*/
void CPoint :: setOrd (int y) {
	m_Ord = y;
}

/**
* presentation method
*/
void CPoint :: presentation () {
	cout << "abscisse = " << m_Abs << " " << "ordonnée = " << m_Ord << endl;
}