#ifndef CGUI_H_
#define CGUI_H_

#include <iostream>
#include <sstream>

//Define of constants
#define NB_COL_LIG = 11

using namespace std;

class CGUI {
//Attributes
	private:
		//The grid to display the board
		string m_grille[NB_COL_LIG];

		//Pointer to save the submarines positions
		CArmada* m_pTheArmada;


//Methods
	public:
		//Constructors, destructors
		CGUI(CArmada∗ pTheArmada);

		//Other methods
		void printGrille(ostream& os);


	private:
		void initGrille();


	friend ostream& operator<<(ostream& os, CGUI& theG);
};

#endif /* CGUI_H_ */
