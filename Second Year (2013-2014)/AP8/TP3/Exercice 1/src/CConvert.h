#ifndef CConvert_H_
#define CConvert_H_

#include <string>
#include <iostream>
#include <sstream>

using namespace std;

class CConvert {

	private: 
		string m_Str;
		double m_Dbl;

	public:
		CConvert();
		CConvert(string str);
		CConvert(double dbl);
		double getDouble();
		string getString();
		~CConvert();
		void presentation();
};

#endif