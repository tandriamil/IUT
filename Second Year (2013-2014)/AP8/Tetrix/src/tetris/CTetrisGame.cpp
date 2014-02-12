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

/****************************************/
