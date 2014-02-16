//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================



#ifndef __PROJET_TETRIS_H__	// routine qui sert à pas inclure 2 fois le même fichier
#define __PROJET_TETRIS_H__	//

//-----------------------------------------------------------------
// Notre programme va avoir besoin 
// des fonctions spécifiques à l'utilisateur (iterface graphique utilisateur GUI) et
// des fonctions nécéssaires au rendu (dessin) d'un objet dans la scene
//
// On inclu les fichiers .h qui contiennent les déclarations des fonctions
//-----------------------------------------------------------------
#include "CApplication.h"		// ensemble des fonctions contenant notre environnement de développement
#include "CTetrisGame.h"			// le jeu tétris (pas d'affichage dedans  !!!!!)

////////////////////////////////////////////////////////////////////////
/// classe Demo: elle est notre classe cliente, elle possède l'ensemble des propriétés de la classe CApplication
/// et donc utilise le GUI et le renderer. 
//
// Projet Tetris
//
////////////////////////////////////////////////////////////////////////
class CProjetTetris: public CApplication {

public:
	/** 
		\brief constructeur par défaut de CProjetTetris
	*/
	CProjetTetris();

	/**
		\brief destructeur de CProjetTetris
	*/
	~CProjetTetris();

	/**
		\brief initilisation de notre appli (rien car dessiner un cube à l'écran ne nécéssite aucune initialisation)
		 !! Méthode appelée dans la méthode Init de la classe CApplication
	*/
	bool OnInit();

	/**
		\brief notre scène à dessiner
		 !! Méthode appelée dans la méthode Run de la classe CApplication
	*/
	void OnRender();

	/**
		\brief destructuion de notre appli (rien car dessiner un cube à l'écran ne nécéssite aucune destruction)
		 !! Méthode appelée dans la méthode Release de la classe CApplication
	*/
	void OnRelease();


private:
	
	//----------------------------------------------------------
	// Données membres
	//----------------------------------------------------------
	unsigned int		m_step;			///< compteur de passage dans la méthode onRender() permet de gérer implicitement le temps
	CTetrisGame		m_game;			///< le jeu !!
	
	// Attributs temporaires
	// Il s'agit d'un test i.e. un carré qui descend pour vous montrer comment évolue le jeu au cours du temps
	int				m_posYPiece;			
	int				m_posXPiece;

	/** 
		\brief affichage de la grille de jeu
	*/
	void DrawTetris();

	/** 
		\brief affichage des informations du jeu
	*/
	void DrawInfo();




	//----------------------------------------------------------
	// quelques outils pour afficher des carré et des rectangles
	//----------------------------------------------------------
	/** 
		\brief affiche un carré plein
		\param 1&2 coordonnées
		\param 3: dimension (coté) du carré
		\param 4: couleur
	*/
	void DrawFillSquare(int x, int y, float dim, const CVector3 &color) ;
	
	/** 
		\brief affiche un rectangle plein
		\param 1&2 coordonnées
		\param 3&4: largeur et hauteur
		\param 4: couleur
	*/
	void DrawFillRect(int x, int y, float w, float h, const CVector3 &color) ;

	/** 
		\brief affiche le contour d'un rectangle 
		\param 1&2 coordonnées
		\param 3&4: largeur et hauteur
		\param 4: couleur
		\param 5: taille de la ligne
	*/
	void DrawRect(int x, int y, float w, float h, const CVector3 &color, float lineWidth = 1.5f) ;
};


#endif // __ProjetTetris_H__ fin de la routine
