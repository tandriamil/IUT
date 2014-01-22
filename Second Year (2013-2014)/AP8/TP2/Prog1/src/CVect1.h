#ifndef CVECT1_H_
#define CVECT1_H_

#include "AllIncludes.h"

class CVect1 {

	private :
		int		m_nbe;
		double*	m_pAdr;

	public:
		CVect1 ( int n );
		// Destructeur
		~CVect1();
};

#endif /*CVECT1_H_*/
