#include "CVect1.h"

CVect1 :: CVect1 (int n) {
	m_nbe = n;
	m_pAdr = new double[n];
	cout << "Constructeur usuel - adr objet : " << this << " - adr vecteur : " << m_pAdr << endl;
}

/************************/

CVect1 :: ~CVect1 () {
	cout << "Destructeur objet - adr objet : " << this << " - adr vecteur: " << m_pAdr << endl;
	delete[] m_pAdr;
}
