//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================

#include "CProjetTetrisPiece.h"

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Projet Tetris
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

CProjetTetrisPiece::CProjetTetrisPiece() {

	m_game = CTetrisGame(POSX_BOARD, POSY_BOARD, WIDTH_BOARD, HEIGHT_BOARD, DIM_CASE);
	m_step = 0;

	// création d'une nouvelle pièce T, avec 0 et 0 pour coordonnées dans la grille
	m_pPieceT = new CTPiece(3, 0, 0, (CVector3(17.0f/255.0f,218.0f/255.0f,84.0f/255.0f)));
	m_pPieceT -> Turn(); // initialisation de la pièce 

	// création d'une nouvelle pièce I, avec 3 et 0 pour coordonnées dans la grille
	m_pPieceI = new CIPiece(3, 3, 0, (CVector3(17.0f/255.0f,218.0f/255.0f,84.0f/255.0f)));
	m_pPieceI -> Turn(); // initialisation de la pièce 

	// création d'une nouvelle pièce O, avec 6 et 3 pour coordonnées dans la grille
	m_pPieceO = new COPiece(3, 6, 0, (CVector3(17.0f/255.0f,218.0f/255.0f,84.0f/255.0f)));
	m_pPieceO -> Turn(); // initialisation de la pièce 

	// création d'une nouvelle pièce L1, avec 0 et 4 pour coordonnées dans la grille
	m_pPieceL1 = new CL1Piece(3, 0, 4, (CVector3(17.0f/255.0f,218.0f/255.0f,84.0f/255.0f)));
	m_pPieceL1 -> Turn(); // initialisation de la pièce 

	// création d'une nouvelle pièce L1, avec 0 et 4 pour coordonnées dans la grille
	m_pPieceL2 = new CL2Piece(3, 3, 4, (CVector3(17.0f/255.0f,218.0f/255.0f,84.0f/255.0f)));
	m_pPieceL2 -> Turn(); // initialisation de la pièce 

	// création d'une nouvelle pièce Z1, avec 0 et 4 pour coordonnées dans la grille
	m_pPieceZ1 = new CZ1Piece(3, 6, 4, (CVector3(17.0f/255.0f,218.0f/255.0f,84.0f/255.0f)));
	m_pPieceZ1 -> Turn(); // initialisation de la pièce

	// attributs rajoutés pour montrer un exemple de pièce qui descend
	m_posYPiece = HEIGHT_BOARD;
	m_posXPiece = WIDTH_BOARD/2;
}

/****************************************/

CProjetTetrisPiece::~CProjetTetrisPiece() {

	cout << "Destruction objet CProjetTetrisPiece" << endl;

	delete m_pPieceT;
	delete m_pPieceI;
	delete m_pPieceO;
	delete m_pPieceL1;
	delete m_pPieceL2;
	delete m_pPieceZ1;
	
	cout << "Destruction des pièces effectuée" << endl;
}

//----------------------------------------------------------
// initilisation de notre appli (rien car dessiner un cube à l'écran ne nécéssite aucune initialisation)
// !! Méthode appelée dans la méthode Init de la classe CApplication
//----------------------------------------------------------
bool CProjetTetrisPiece::OnInit() {

	return true;
}

//----------------------------------------------------------
// notre scène à dessiner
// !! Méthode appelée dans la méthode Run de la classe CApplication
//----------------------------------------------------------
void CProjetTetrisPiece::OnRender() {

	//-------------------------------------------------------
	// gestion du temps
	//-------------------------------------------------------
	if ( m_step> 50 ) 
	{
		m_step = 0; 
		m_posYPiece--; // à chaque pas de temps, on fait évoluer la coordonnée en y de la pièce 
	}

	//-------------------------------------------------------
	// commande utilisateur
	//-------------------------------------------------------
	if(m_UserEvents->m_keyBoardEvents[Key_a]) {
		cout << "la touche 'a' a bien été utilisée" << endl;
		m_pPieceI -> TurnLeft ();
		m_pPieceI -> Turn();
		DrawTetris();
	}


	if(m_UserEvents->m_keyBoardEvents[Key_z]) {
		cout << "la touche 'z' a bien été utilisée" << endl;
		m_pPieceI -> TurnRight ();
		m_pPieceI -> Turn();
		DrawTetris();
	}

	if(m_UserEvents->m_keyBoardEvents[Key_DOWN])
		cout << "la touche flèche bas a bien été utilisée" << endl;

	if(m_UserEvents->m_keyBoardEvents[Key_RIGHT])
		cout << "la touche flèche droite a bien été utilisée" << endl;

	if(m_UserEvents->m_keyBoardEvents[Key_LEFT])
		cout << "la touche flèche gauche a bien été utilisée" << endl;

	if(m_UserEvents->m_keyBoardEvents[Key_SPACE])
		cout << "la touche espace a bien été utilisée" << endl;
	
	//-------------------------------------------------------
	// affichage
	//-------------------------------------------------------
	// on passe en rendu 2d
	m_renderer.Start2DRender();

	// affichage du score
	DrawInfo();

	// affichage du tetris
	DrawTetris();

	// ICI AFFICHAGE DE MON CARRE DE TEST
	DrawFillRect ( m_game.GetXPos() + m_posXPiece*m_game.GetCaseDim(), m_game.GetYPos()+ m_posYPiece*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f) );

	// fin du rendu 2d
	m_renderer.End2DRender();

	// maj du compteur de passage dans cette fonction
	m_step ++;
}

//----------------------------------------------------------
// destruction de notre appli (rien car dessiner un cube à l'écran ne nécessite aucune destruction)
// !! Méthode appelée dans la méthode Release de la classe CApplication
//----------------------------------------------------------
void CProjetTetrisPiece::OnRelease() {

	// Rien a liberer
}	

//----------------------------------------------------------
//
//----------------------------------------------------------
void CProjetTetrisPiece::DrawInfo() 
{
	std::string title = Helpers::ToString("Mon Tetris");
	std::string scoreStr = "Score : " + Helpers::ToString(200000);
	
	m_renderer.DrawText(title, 300, 500, CRenderer::TS_18, CVector3(1.0f, 1.0f, 1.0f));
	m_renderer.DrawText(scoreStr, 500, 160, CRenderer::TS_12, CVector3(0.0f, 1.0f, 0.0f));	
}

/****************************************/

void CProjetTetrisPiece::DrawTetris() {

	vector<TGameRow> gameTable = m_game.GetBoard().GetGameTable();
	float	tetrisWidth = gameTable[0].size()* m_game.GetCaseDim();
	float	tetrisHeight = gameTable.size() * m_game.GetCaseDim();

	// couleur de fond du tetris
	//DrawFillRect ( m_game.GetXPos(), m_game.GetYPos(), tetrisWidth, tetrisHeight, CVector3(153.0f/255.0f,153.0f/255.0f,153.0f/255.0f) );
	DrawFillRect ( m_game.GetXPos(), m_game.GetYPos(), tetrisWidth, tetrisHeight, CVector3(17.0f/255.0f,218.0f/255.0f,84.0f/255.0f) );
	
	// affichage du "cadre" tetris
	DrawRect ( m_game.GetXPos()-0.1f, m_game.GetYPos()-0.1f, (tetrisWidth+0.2f), (tetrisHeight+0.2f), CVector3(213.0f/255.0f,213.0f/255.0f,213.0f/255.0f) );

	
	
	// affichage du tableau tetris


	// affichage des pièces de test
	// le i et le j*m_game.GetCaseDim() permettent de se décaler dans la grille et
	// ainsi de colorier une nouvelle case
	for (int i=0; i<3; i++) {
		for (int j=0; j<3; j++) {

			//affichage de la pièce T
			// si il n'y a pas de 1 dans la case de la matrice de la pièce T, on ne colorie pas
			if (m_pPieceT -> GetTable()[i][j] == 1) {
				//DrawFillRect ( m_game.GetXPos() + m_pPieceT -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + m_pPieceT -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
				DrawFillRect ( m_game.GetXPos()+ i*m_game.GetCaseDim() + m_pPieceT -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + j*m_game.GetCaseDim() + m_pPieceT -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
			}

			//affichage de la pièce I
			// si il n'y a pas de 1 dans la case de la matrice de la pièce I, on ne colorie pas
			if (m_pPieceI -> GetTable()[i][j] == 1) {
				//DrawFillRect ( m_game.GetXPos() + m_pPieceT -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + m_pPieceT -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
				DrawFillRect ( m_game.GetXPos()+ i*m_game.GetCaseDim() + m_pPieceI -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + j*m_game.GetCaseDim() + m_pPieceI -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
			}

			//affichage de la pièce O
			// si il n'y a pas de 1 dans la case de la matrice de la pièce O, on ne colorie pas
			if (m_pPieceO -> GetTable()[i][j] == 1) {
				//DrawFillRect ( m_game.GetXPos() + m_pPieceT -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + m_pPieceT -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
				DrawFillRect ( m_game.GetXPos()+ i*m_game.GetCaseDim() + m_pPieceO -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + j*m_game.GetCaseDim() + m_pPieceO -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
			}

			//affichage de la pièce L1
			// si il n'y a pas de 1 dans la case de la matrice de la pièce L1, on ne colorie pas
			if (m_pPieceL1 -> GetTable()[i][j] == 1) {
				//DrawFillRect ( m_game.GetXPos() + m_pPieceT -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + m_pPieceT -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
				DrawFillRect ( m_game.GetXPos()+ i*m_game.GetCaseDim() + m_pPieceL1 -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + j*m_game.GetCaseDim() + m_pPieceL1 -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
			}

			//affichage de la pièce L2
			// si il n'y a pas de 1 dans la case de la matrice de la pièce L2, on ne colorie pas
			if (m_pPieceL2 -> GetTable()[i][j] == 1) {
				//DrawFillRect ( m_game.GetXPos() + m_pPieceT -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + m_pPieceT -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
				DrawFillRect ( m_game.GetXPos()+ i*m_game.GetCaseDim() + m_pPieceL2 -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + j*m_game.GetCaseDim() + m_pPieceL2 -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
			}

			//affichage de la pièce Z1
			// si il n'y a pas de 1 dans la case de la matrice de la pièce L2, on ne colorie pas
			if (m_pPieceZ1 -> GetTable()[i][j] == 1) {
				//DrawFillRect ( m_game.GetXPos() + m_pPieceT -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + m_pPieceT -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
				DrawFillRect ( m_game.GetXPos()+ i*m_game.GetCaseDim() + m_pPieceZ1 -> GetColIndex()*m_game.GetCaseDim(), m_game.GetYPos() + j*m_game.GetCaseDim() + m_pPieceZ1 -> GetRowIndex()*m_game.GetCaseDim(), m_game.GetCaseDim(), m_game.GetCaseDim(), CVector3(255.0f/255.0f,153.0f/255.0f,153.0f/255.0f));
			}

		}
	}

	

}

//----------------------------------------------------------
// quelques outils pour afficher des carré et des rectangles
//----------------------------------------------------------
void CProjetTetrisPiece::DrawFillRect(int x, int y, float w, float h, const CVector3 &color) {

	glColor3f(color.x,color.y,color.z);
	glBegin(GL_QUADS);
	glVertex2i(x, y);
	glVertex2i(x,  y+h);
	glVertex2i(x+w,  y+h);
	glVertex2i(x+w, y);
    glEnd();
}

/****************************************/

void CProjetTetrisPiece::DrawRect(int x, int y, float w, float h, const CVector3 &color, float lineWidth)  {

	glColor3f(color.x,color.y,color.z);
	glLineWidth(lineWidth);
	glBegin(GL_LINES);
	glVertex2f(x, y);
	glVertex2f(x,  y+h);
	glVertex2f(x,  y+h);
	glVertex2f(x+w,  y+h);
	glVertex2f(x+w,  y+h);
	glVertex2f(x+w, y);
	glVertex2f(x+w, y);
	glVertex2f(x, y);
	glEnd();
}

/****************************************/

void CProjetTetrisPiece::DrawFillSquare(int x, int y, float dim, const CVector3 &color)  {

	glColor3f(color.x,color.y,color.z);
	glBegin(GL_QUADS);
	glVertex2f(x, y);
	glVertex2f(x,  y+dim);
	glVertex2f(x+dim,  y+dim);
	glVertex2f(x+dim, y);
	glEnd();
}
