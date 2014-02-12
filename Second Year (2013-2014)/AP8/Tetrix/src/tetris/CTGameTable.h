//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================

#ifndef CTGAME_TABLE
#define CTGAME_TABLE

#include "Common.h"

struct Case {

	Case() { m_used = false; }
	bool			m_used	;
	CVector3		m_color	;
};

typedef vector<Case> TGameRow;

class CTGameTable {

	private :
		vector<TGameRow> m_GameTable;

	public :

		CTGameTable ( int width, int height );					// grille de jeu, nombre de cases en hauteur (height) et en largeur (width)
		CTGameTable () {};							// constructeur par défaut obligatoire pour la déclaration CTGameTable m_board dans CTetrisGame

		friend ostream& operator<< ( ostream& out, const CTGameTable& obj ); 	// affichage de la grille au terminal
		
		// Accesseur
		vector<TGameRow>& GetGameTable();
};

#endif
