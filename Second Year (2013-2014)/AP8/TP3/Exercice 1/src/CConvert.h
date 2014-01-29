#ifndef CConvert_H_
#define CConvert_H_

#include <string>
#include <istringstream>
#include <ostringstream>

using namespace std;

class CConvert {

	private : 
		string m_Str;
		double m_Dbl;

	public:
		CConvert();
		CConvert(string str);
		CConvert(double dbl);
		~CConvert();
};

#endif