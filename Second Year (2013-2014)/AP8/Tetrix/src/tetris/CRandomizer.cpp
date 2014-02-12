//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================

#include "CRandomizer.h"
#include <algorithm>

CRandomizer::CRandomizer(void)
	:m_max(7), m_sizeList(6)
{
	unsigned int i;
	for(i = 0 ; i < m_max; i++) 
		m_set.push_back(i);
}

/****************************************/

CRandomizer::CRandomizer(unsigned int sizeList, unsigned int maxRand)
	:m_max(maxRand), m_sizeList(sizeList)
{
	unsigned int i;
	for(i = 0 ; i < m_max; i++) 
		m_set.push_back(i);
}

/****************************************/

void CRandomizer::Fill() {

	unsigned int i;
	for(i = m_next.size(); i < m_sizeList; i++) {
		std::random_shuffle(m_set.begin(),m_set.end());
		m_next.push_back(m_set.at(0));
	}
}

/****************************************/

int CRandomizer::Next() {

	// on rempli la liste par la fin
	Fill();

	// on recup le premier
	int tmp = m_next.front();

	// puis on l'élimine
	m_next.erase(m_next.begin());
	
	// on renvoit le premier de la liste
	return tmp;
}

/****************************************/

/* renvoit la première valeur */
int CRandomizer::First() {

	// on rempli la liste par la fin
	Fill();

	return m_next[0];
}
