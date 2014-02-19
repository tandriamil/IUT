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
	m_pPiece = null;
	m_randomizer = CRandomizer (void);
}

/****************************************/

CTetrisGame::~CTetrisGame() {

	
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


void CTetrisGame::AddPiece() {


	const CVector3 color(0.0f, 1.0f, 0.0f);


	switch (m_randomizer -> First()) 
	{
		case 1:
		{
			m_pPiece = new CIPiece (3, 3, 17, color);
			break;
		}

		case 2:
		{
			m_pPiece = new CTPiece (3, 3, 17, color);
			break;
		}

		case 3:
		{
			m_pPiece = new COPiece (3, 3, 17, color);
			break;
		} 

		case 4:
		{
			m_pPiece = new CL1Piece (3, 3, 17, color);
		}

		case 5:
		{
			m_pPiece = new CL2Piece (3, 3, 17, color);
			break;
		}

		case 6:
		{
			m_pPiece = new CZ1Piece (3, 3, 17, color);
			break;
		} 

		case 7:
		{
			m_pPiece = new CZ2Piece (3, 3, 17, color);
		}
	}
}

ActionResult CTetrisGame::MovePiece(PieceAction action) {
	ActionResult* ar = new ActionResult();
	ActionResult& ret = *ar;

	switch (action)
	{
		case PA_RotateRight :
		{
			m_pPiece -> TurnRight ();
			m_pPiece -> Turn();
			break;
		}

		case PA_RotateLeft :
		{
			m_pPiece -> TurnLeft ();
			m_pPiece -> Turn();
			break;
		}

		case PA_MoveRight :
		{
			m_pPiece -> SetIncDecColIndex(1);
			break;
		} 

		case PA_MoveLeft :
		{
			m_pPiece -> SetIncDecColIndex(-1);
			break;
		}

		case PA_MoveBottom :
		{
			m_pPiece -> SetIncDecRowIndex(-1);
			break;
		}

		case PA_MoveBottom2 :
		{
			m_pPiece -> SetIncDecRowIndex(-3);
		}
<<<<<<< HEAD
	}
=======
	}*/

	return ret;
>>>>>>> da54f54741bd4194484b316a3bc8616857e9e98d
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
	unsigned int i = 0;

	//Gets the vector of game table
	vector<TGameRow> vect = this->m_board.GetGameTable();

	//Travels the board
	while ((!(found)) && (i < vect.size())) {
		//Var to store a bool to know if the line is full
		bool lineFull = true;

		//Gets rows one by one
		vector<Case> aRow = vect[i];

		//Then gets cases one by one
		for (unsigned int j = 0; j < aRow.size(); j++) {

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

	//If we didn't found a full row
	if (!(found)) {
		i = -1;
	}

	return i;
}


/****************************************/

/**
	\brief Delete a full row
	\param The index of this row
*/
void CTetrisGame::DeleteRow(unsigned int rowIndex) {
	//Gets the vector of game table
	vector<TGameRow> vect = this->m_board.GetGameTable();

	//Gets the high of this board
	unsigned int boardHeight = this.NbBoardRows();

	//Gets the highest value, 
	int maxJValue = boardHeight - 2;
	maxJValue = maxJValue - rowIndex;

	//And in the end, move all the line at the top of this one
	for (unsigned int j = 0; j <= maxJValue; j++) {
		//Move all the rows, except the last one
		vect[rowIndex + j] = vect[rowIndex + j + 1];
	}
}


/****************************************/

/**
	\brief Check if the game is over
	\return true if over, false if not
*/
bool CTetrisGame::IsGameOver() {
	bool ret = false;

	return ret;
}


/****************************************/

/**
	\brief Get the number of colons
	\return A signed int of the width of the table
*/
int CTetrisGame::NbBoardCols() {
	int ret = 0;

	//Gets the vector of game table
	vector<TGameRow> vect = this->m_board.GetGameTable();

	//Then gets a single row (here it's the first one)
	vector<Case> singleRow = vect[0];

	//And gets its number of cases (so it's width)
	ret = singleRow.size();

	return ret;
}


/****************************************/

/**
	\brief Get the number of rows
	\return A signed int of the high of the table
*/
int CTetrisGame::NbBoardRows() {
	int ret = 0;

	//Gets the vector of game table
	vector<TGameRow> vect = this->m_board.GetGameTable();

	//Then gets its size (so the high of the board)
	ret = vect.size();

	//Then returns the result
	return ret;
}