//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================


#ifndef __CRANDOMIZER_H__
#define __CRANDOMIZER_H__

#include <vector>

class CRandomizer {

/* Public method */
public:

	/* Recuperer la prochaine piece */
	int Next();

	/* Constructeurs / Desctructeurs */
	CRandomizer();

	/* Constructeurs / Desctructeurs */
	CRandomizer(unsigned int sizeList, unsigned int maxRand);

	/* renvoit la première valeur */
	int First();

/* Private attribut */
private:
	std::vector<int> m_set;
	std::vector<int> m_next;

	/* Private method */
	/* Remplir la liste */
	void Fill();

    	unsigned int	m_max		;
	unsigned int	m_sizeList	;

};

#endif
