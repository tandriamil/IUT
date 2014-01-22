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
	cout << "Abscisses initilisées à " << m_Abs << " et Ordonnées à " << m_Ord << "." << enl;
}


/**
 * The second constructor without parameters
 */
CPoint :: CPoint () {
	//Just prints a message
	cout << "Construction de l'objet CPoint sans paramètres d'adresse : " << this << endl;
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