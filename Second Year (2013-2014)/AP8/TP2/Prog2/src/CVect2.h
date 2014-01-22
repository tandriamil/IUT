#ifndef CVECT2_H_
#define CVECT2_H_

#include "AllIncludes.h"

class CVect2 {

	private :
		int		m_nbe;
		double*	m_pAdr;

	public:
		CVect2 (int n);
		// Constructeur de recopie (voir poly)
		CVect2 (const CVect2&);
		~CVect2();
};

#endif /*CVECT2_H_*/
