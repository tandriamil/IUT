#include "CGUI.h"

/**
 * The constructor
 * @param pTheArmada The pointer to the armada of submarines created, don't forget that it's a string tab
 */
CGUI::CGUI(CArmada* pTheArmada) {
	this->m_pTheArmada = pTheArmada;
}


/**
 * Initializes the grid to "-"
 */
void CGUI::initGrille() {
	//The letters at the left, begins to A (= 65 in ASCII)
	int letter = 65;

	//Then, creates the first line
	this->m_grille[0] = " ";

	//Then add the colon numbers to the first line
	for (int i = 0; i < this->NB_COL_LIG; i++) {
		this->m_grille[0] = this->m_grille[0] + "  " + (char)(i+48);
	}

	//Then add a line jump
	this->m_grille[0] = this->m_grille[0] + "\n"

	//Then add all the lines
	for (int i = 0; i < this->NB_COL_LIG; i++) {
		//Add the letter
		this->m_grille[i+1] = this->m_grille[i+1] + (char)(i+letter);

		//Then add all the "-"
		for (int j = 0; i < this->NB_COL_LIG; j++) {
			this->m_grille[0] = this->m_grille[0] + "  " + "-";
		}

		//And at the end, add the end line char
		this->m_grille[0] = this->m_grille[0] + "\n";
	}
}