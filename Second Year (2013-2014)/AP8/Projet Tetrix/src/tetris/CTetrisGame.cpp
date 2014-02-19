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
