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
	m_pPiece = NULL;
	m_randomizer = new CRandomizer ();

	AddPiece();
}

/****************************************/

CTetrisGame::~CTetrisGame() {}

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
			m_pPiece =  new CIPiece (3, 3, 17, color);
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
			break;
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
	cout << m_randomizer -> First() << endl;
}


/**
	\brief Move a piece after an action of the user
	\param action The action that the user did
	\return An ActionResult object that show the result of the action
 */
ActionResult CTetrisGame::MovePiece(PieceAction action) {

	ActionResult ret = (ActionResult) NULL;

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

	}

	return ret;

}


void CTetrisGame::InsertPiece() {
	unsigned int i,j;

	for ( i=0; i< this->m_board.GetGameTable().size(); i++ ) {
		for ( j=0; j< this->m_board.GetGameTable()[i].size(); j++ ) {
			if ( m_pPiece->GetTable()[i][j] == 1) {
				 this->m_board.GetGameTable()[i][j].m_used = true;
			}
		}

	}
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
	\brief Delete a full row then moving all the rows upper than it
	\param The index of this row
*/
void CTetrisGame::DeleteRow(unsigned int rowIndex) {
	//Gets the vector of game table
	vector<TGameRow> vect = this->m_board.GetGameTable();

	//Gets the high of this board
	unsigned int boardHeight = this->NbBoardRows();

	//Value to increment
	unsigned int i = 0;

	//Move all the upper rows
	while ((i + rowIndex) < (boardHeight - 1)) {
		vect[rowIndex + i] = vect[rowIndex + i + 1];
	}

	//Then, clean the last row (= the highest)
	//Create a blank row
	Case c = Case();
	int nbCols = this->NbBoardCols();
	TGameRow aRow (nbCols, c);

	//Then put it in the highest row
	vect[boardHeight - 1] = aRow;
}


/****************************************/

/**
	\brief Check if the game is over
	\return true if over, false if not
*/
bool CTetrisGame::IsGameOver() { //Peut être à revoir
	bool ret = false;

	//Gets the row index of the piece
	int rowIndex = this->m_pPiece->GetRowIndex();

	//Gets the height of the board
	int nbBoardRows = this->NbBoardRows();

	//Then look if it's upper than the size of the board
	if (rowIndex >= nbBoardRows) {
		ret = true;
	}

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


/****************************************/

/**
	\brief Get the current piece
	\return A pointer to the current piece
*/
CPieceAbstract* CTetrisGame::GetPiece() {
	return this->m_pPiece;
}


/****************************************/

/**
	\brief Get the current score
	\return A pointer to the current piece
*/
unsigned int CTetrisGame::GetScore() {
	return this->m_score;
}