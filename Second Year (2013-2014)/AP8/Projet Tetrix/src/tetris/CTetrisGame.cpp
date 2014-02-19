//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================

#include "CTetrisGame.h"

/****************************************/
CTetrisGame::CTetrisGame(unsigned int gamePosX, unsigned int gamePosY, unsigned int boardWidth, unsigned int boardHeight, float dimCase) {	

	m_board = CTGameTable ( boardWidth, boardHeight );	// appel de CTGameTable ( int width, int height )
	m_xPos = gamePosX; 
	m_yPos = gamePosY;
	m_caseDim = dimCase; 
}

/****************************************/

CTetrisGame::~CTetrisGame(){

	
}

/****************************************/

CTGameTable& CTetrisGame::GetBoard() {

	return m_board;
}

/****************************************/

unsigned int CTetrisGame::GetXPos() {

	return m_xPos;
}

/****************************************/

unsigned int CTetrisGame::GetYPos() {
	
	return m_yPos;
}

/****************************************/

float& CTetrisGame::GetCaseDim() 
{
	return m_caseDim;
}


void CTetrisGame::AddPiece() 
{

}

ActionResult MovePiece(PieceAction action) {

	/*switch (action)
	{
		case PA_RotateRight:
		{
			this -> m_state = S_Right;
			cout << "état de la pièce après rotation = S_Right";
			break;
		}

		case PA_RotateLeft:
		{
			this -> m_state = S_Left;
			cout << "état de la pièce après rotation = S_Left";
			break;
		}

		case PA_MoveRight:
		{
			this -> m_state = S_Top;
			cout << "état de la pièce après rotation = S_Top";
			break;
		} 

		case PA_MoveLeft:
		{
			this -> m_state = S_Bottom;
			cout << "état de la pièce après rotation = S_Bottom";
		}

		case PA_MoveBottom:
		{
			this -> m_state = S_Bottom;
			cout << "état de la pièce après rotation = S_Bottom";
		}

		case PA_MoveLeft:
		{
			this -> m_state = S_Bottom;
			cout << "état de la pièce après rotation = S_Bottom";
		}
	}*/
}


void InsertPiece() {
	/*for (int i=0; i<tab.m_GameTable.size(); i++) {
		for (int j=0; j<tab.m_GameTable.size(); j++ ) {

		}
	}*/
}

/****************************************/

/**
	\brief Search the first full line
	\return The index of this line, -1 if there's no one
**/
int CTetrisGame::GetFullRow() {
	//The var to know if he already found one or not and the index i
	bool found = false;
	int i = 0;

	//Gets the vector of game table
	vector<TGameRow> vect = this->m_board.GetGameTable();

	//Travels the board
	while ((!(found)) && (i < vect.size())) {
		//Var to store a bool to know if the line is full
		bool lineFull = true;

		//Gets rows one by one
		vector<Case> aRow = vect[i];

		//Then gets cases one by one
		for (int j = 0; j < aRow.size(); j++) {

			//If a case is empty, so the line isn't full
			if (!(aRow[j].m_used)) {
				lineFull = false;
			}
		}

		//If the row is full
		if (lineFull) {
			found = true;
		}

		//If it isn't
		else {
			//Increments i
			i++;
		}
	}

	//If we found a line, return its index
	if (found) {
		return i;
	}

	//If not, just return -1
	else {
		return -1;
	}
}


/****************************************/

/**
	\brief Delete a full row
	\return The index of this row
*/
void DeleteRow(unsigned int rowIndex) {

}


/****************************************/

/**
	\brief Check if the game is over
	\return true if over, false if not
*/
bool IsGameOver() {

}


/****************************************/

/**
	\brief Get the number of colons
	\return A signed int of the width of the table
*/
int NbBoardCols() {

}


/****************************************/

/**
	\brief Get the number of rows
	\return A signed int of the width of the table
*/
int NbBoardRows() {

}