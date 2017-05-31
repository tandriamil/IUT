#ifndef CManFch_H_
#define CManFch_H_

#include <string>
#include <iostream>
#include <sstream>
#include <fstream>
#include <string.h>
#include <iomanip>

using namespace std;

class CManFch {

	private:
		string m_NomFich;  //Nom plus l'extension
		string m_EmplcmtFich;  //Chemin d'accès absolu (sans le nom)
		int m_TypeFich;  //1 si .txt, 2 si .bin, 0 sinon

	public:
		CManFch();
		CManFch(string str);
		void setNomFichier(string str);
		void afficherAttributs();
		void afficherFichier();
};

#endif
