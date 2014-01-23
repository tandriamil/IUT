#ifndef CPOINT_H_
#define CPOINT_H_

#include <iostream>
using namespace std;

class CPoint {

	private : 
		int m_Abs;
		int m_Ord;

	public: 
		CPoint (int x, int y);
		CPoint ();
		CPoint (const CPoint& toCopy);
};

#endif /*CPOINT_H_*/