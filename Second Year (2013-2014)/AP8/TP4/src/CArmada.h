#ifndef CArmada_H_
#define CArmada_H_

#include <iostream>
#include <sstream>
#include <string>
#include <fstream>
#include <stdexcept>
#include <cstdlib>
#include <cstring>

using namespace std;

class CArmada {
//Attributes
	private:
		//The table for all the submarines
		string* m_pTabSousMarins;

		//The total number of submarines
		int m_nbTotSSM;


//Methods
	public:
		//Constructors, destructors
		CArmada(int nbsub);
		~CArmada();

		//Accessors
		string* getTabSM();
		int getNbSub();

		//Other methods
		void remplirStruct();


	private:
		void analyser(string saisie);
};

#endif