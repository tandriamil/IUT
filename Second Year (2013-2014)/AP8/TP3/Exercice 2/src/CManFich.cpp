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
	
	size_t found=str.find_last_of("/\\"); // cherche le dernier "/"

  	this->m_NomFich = str.substr(found+1); // prend tout ce qu'il y a après le dernier "/"
	this->m_EmplcmtFich = str.substr(0,found); // prend tout ce qu'il y a avant le dernier "/"
	
	found = this -> m_NomFich.find_last_of("."); // cherche le "."
	string fileExtension = this -> m_NomFich.substr(found+1); // prend tout ce qu'il y après le "."
	
	char tabChar[6]="txt"; // création d'un tableau statique contenant "txt"
	char tabChar1[6]="bin"; // création d'un tableau statique contenant "bin"
	char tabChar2[6]; // création d'un tableau statique contenant l'extension trouvée du fichier

	for (int i=0; i < 6; i++) {
		tabChar2[i] = fileExtension[i]; // recopie de fileExtention dans tabChar2
	}


	int test1 = strcmp(tabChar,tabChar2); // test entre "txt" et l'extension du fichier en paramètre
	int test2 = strcmp(tabChar1,tabChar2); // test entre "bin" et l'extension du fichier en paramètre
	if (test1 == 0 ) {
		this -> m_TypeFich = 1; // si c'est un fichier .txt
		//cout << "\n" << "nom du fichier : " << this -> m_NomFich << "\n" << "emplacement du fichier : " << this -> m_EmplcmtFich << "\n" << "extension du fichier : "<< this -> m_TypeFich << "\n" << endl;
	}
	else if (test2 == 0) {
		this -> m_TypeFich = 2; // si c'est un fichier .bin
		//cout << "\n" << "nom du fichier : " << this -> m_NomFich << "\n" << "emplacement du fichier : " << this -> m_EmplcmtFich << "\n" << "extension du fichier : "<< this -> m_TypeFich << "\n" << endl;
	}
	else {
		this -> m_TypeFich = 0; // si c'est un .ach
		//cout << "nom du fichier : " << this -> m_NomFich << "\n" << "emplacement du fichier : " << this -> m_EmplcmtFich << "\n" << "extension du fichier : "<< this -> m_TypeFich << endl;
		cout << "\n" << "/!\\  Erreur concernant le fichier " << this -> m_NomFich << ", extension incorrecte ! (uniquement extensions .bin et .txt autorisées)" << "\n" << endl;
	}


	

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
		fullFile = this->m_EmplcmtFich + "/" + this->m_NomFich;
		const char* nameFile = (char*)fullFile.c_str();

		//Opens the file
		ifstream ifs(nameFile, ifstream::in);

		//If everything's ok
		if (ifs) {
			//Var to store the line
			string line;
			int i = 1;
			cout << endl;

			//Reads the file line by line
			while (getline(ifs, line)) {
				//Displays the line number
				cout.fill('0');
				cout.width(5);
				cout << std::right << i;
				cout << ": " << line << endl;
				i++;
			}
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
		fullFile = this->m_EmplcmtFich + "/" + this->m_NomFich;
		const char* nameFile = (char*)fullFile.c_str();

		//Opens the file
		ifstream ifs(nameFile, ifstream::in);

		//If everything's ok
		if (ifs) {
			//Var to store the line and one to store the number of line
			string line;
			int i = 0;
			int x = 1;
			cout << "llllllakqsjdiofhdsfjhsdiof" << endl;

			//Reads the file line by line
			while (getline(ifs, line)) {
				//Configures the output (display on screen)
				cout.fill('0');
				cout.width(5);
				cout << std::right << i;

				i = 16*x + i;
				x++;

				cout << ": " << std::hex << std::setfill('0') << std::nouppercase << std::setw(6) << line << endl;
			}
		}

		//If we can't open the file
		else {
			cout << "Ouverture du fichier impossible!";
		}
	}

	//If there's no file
	else {
		cout << "Fichier non compatible avec cet affichage." << endl;
	}
}