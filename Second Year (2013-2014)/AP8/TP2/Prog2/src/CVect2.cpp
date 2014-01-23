#include "CVect2.h"

CVect2 :: CVect2 (int n) {
	m_nbe = n;
	m_pAdr = new double[n];
	cout << "Constructeur usuel - adr objet : " << this << " - adr vecteur : " << m_pAdr << endl;
}

/************************/

CVect2 :: CVect2 (const CVect2& v) {
	m_nbe = v.m_nbe;
	m_pAdr = new double[v.m_nbe];

	for (int i = 0; i < m_nbe; i++) {
		m_pAdr[i] = v.m_pAdr[i];
	}

	cout << "Constructeur de recopie - adr objet : " << this << " - adr vecteur : " << m_pAdr << endl;
}

/************************/

CVect2 :: ~CVect2 () {
	cout << "Destructeur objet - adr objet : " << this << " - adr vecteur: " << m_pAdr << endl;
	delete[] m_pAdr;
}

