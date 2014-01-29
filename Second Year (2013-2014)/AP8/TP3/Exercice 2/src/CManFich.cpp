#include "CManFch.h"

/**
 * The first constructor with no parameters
 */
CManFch::CManFch() {
	//Initializes the attributes
	this->m_NomFich = "";
	this->m_EmplcmtFich = "";
	this->m_TypeFich = 0;
}


/** 
 * The second constructor with a string
 * @param str The name of the file with it location
 */
CManFch::CManFch(string str) {

}


/**
 * Method to set the name of the file
 * @param str The new name of the file
 */
void CManFch::setNomFichier(string str) {
	//Firstly, create a copy of the name
	string tmp = this->m_NomFich;

	//Change the name of the file
	this->m_NomFich = str;

	//Displays the changes
	cout << "Changement du nom de " << tmp << " en " << this->m_NomFich << ".";
}


/**
 * Displays the attributes
 */
void CManFch::afficherAttributs() {
	cout << "Nom du fichier: " << this->m_NomFich << endl << "Emplacement du fichier: " << this->m_EmplcmtFich << endl << "Type du fichier: " << this->m_TypeFich << endl;
}


/**
 * Displays the file
 */
void CManFch::afficherFichier() {
	//If it's a .txt file
	if (this->m_TypeFich == 1) {
		//Creates the full location and name of the file
		string fullFile;
		fullFile = this->m_EmplcmtFich + this->m_NomFich;
		const char* nameFile = (char*)fullFile.c_str();

		//Opens the file
		ifstream ifs(nameFile, ifstream::in);

		//If everything's ok
		if (ifs) {
			//Var to store the line
			string line;

			//Reads the file line by line
			getline(ifs, line);

			//Then displays the line
			cout << line;
		}

		//If we can't open the file
		else {
			cout << "Ouverture du fichier impossible!";
		}
	}

	//If it's a .bin file
	else if (this->m_TypeFich == 2) {
		//Creates the full location and name of the file
		string fullFile;
		fullFile = this->m_EmplcmtFich + this->m_NomFich;
		const char* nameFile = (char*)fullFile.c_str();

		//Opens the file
		ifstream ifs(nameFile, ifstream::in);

		//If everything's ok
		if (ifs) {
			//Configures the output (display on screen)
			cout.setf(ios::hex, ios::basefield);
			cout.setf(ios::showbase);

			//Var to store the line and one to store the number of line
			string line;
			int i = 0;

			//Reads the file line by line
			while (getline(ifs, line)) {
				//Displays the line
				cout << i << ": " << line << endl;
				i++;
			}
		}

		//If we can't open the file
		else {
			cout << "Ouverture du fichier impossible!";
		}
	}

	//If there's no file
	else {
		cout << "Fichier non compatible avec cet affichage.";
	}
}