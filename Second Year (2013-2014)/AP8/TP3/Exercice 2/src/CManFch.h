#ifndef CManFch_H_
#define CManFch_H_

#include <string>
#include <iostream>

using namespace std;

class CManFch {

	private:
		string m_NomFich;  //Nom plus l'extension
		string m_EmplcmtFich;  //Chemin d'accès absolu (sans le nom)
		int m_TypeFich;  //1 si .txt, 2 si binaire, 0 sinon

	public:
		CManFch();
		CManFch(string str);
		void setNomFichier(string str);
		void afficherAttributs();
		void afficherFichier();
};

#endif