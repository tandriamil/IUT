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
		void setAbs (int x);
		void setOrd (int y);
		int getAbs ();
		int getOrd ();
		void presentation ();
		~CPoint ();
};

#endif /*CPOINT_H_*/
