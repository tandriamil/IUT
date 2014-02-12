//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================


//=====================================================================
// classe GUI, s'occupe du fenetrage et de l'interface avec l'utilisateur
//=====================================================================
//-----------------------------------------------------------------
// Ici fichier des déclarations des fonctions. Une fonction ne peut être déclarée qu'une seule fois
// d'ou l'ajout d'une routine qui dit que si votre fichier à déjà été inclu avant pas la peine de le re-inclure
//-----------------------------------------------------------------
#ifndef __GUI_H__	// routine qui sert à pas inclure 2 fois le même fichier
#define __GUI_H__	//


//-----------------------------------------------------------------
// On inclu les fichiers .h qui contiennent les déclarations des fonctions
// On a besoin ici des objets SDL (SDLKey, SDL_Event) déclarés dans SDL.h
// ainsi que des déclarations des fonctions OPENGL
//-----------------------------------------------------------------

#include <vector>					// utilisé par "std::vector<SDLKey> m_keyEvents;"
#include "Common.h"					// structure UserEvents utilisée pour récupérer les données liées à la souris


#include "GL/glut.h"
#include "CApplication.h"

//class MyApplication: public CApplication
//{
//	void OnInit(){std::cout<<"OnInit"<< std::endl;};
//	void OnRender(){std::cout<<"OnRender"<< std::endl;};
//	void OnRelease(){std::cout<<"OnRelease"<< std::endl;};
//};

////////////////////////////////////////////////////////////////////////
// Class qui définit un GUI à partir de la bibliotheque GLFW, à savoir la création de la fenetre,  gestion de la caméra, clavier , joystik ...
////////////////////////////////////////////////////////////////////////
class CGuiGlut
{
public:	// les fonctions suivantes peuvent être appelées par d'autres classes / programmes

	//----------------------------------------------------------
	// constructeur
	//----------------------------------------------------------
	CGuiGlut(){}

	//----------------------------------------------------------
	// Destructeur
	//----------------------------------------------------------
	virtual ~CGuiGlut(){}

	//----------------------------------------------------------
	// intialisation du GUI
	//----------------------------------------------------------
	static void InitializeGraphics(int argc, char **argv, CApplication* application);

	//----------------------------------------------------------
	// instruction a lancer pour le rendu de la scene
	//----------------------------------------------------------
	static void RunGraphics (void);
	
protected:	// les fonctions suivantes peuvent être appelées seulement pas cettte même classe et les classes filles de cette classe
	
	static void InitGL(void);
	static void ReshapeFunc(int width, int height);
	static void DisplayFunc(void);
	static void KeyboardFunc(unsigned char key, int /*x*/, int /*y*/);
	static void SpecialFunc(int key, int /*x*/, int /*y*/);
	
	// application
	static CApplication*	m_application;

	// The number of our GLUT window
	static	int			windowID;
	static	std::string	appVersionName;
	static	bool		gMouseAdjustingCameraAngle ;
	static	bool		gMouseAdjustingCameraRadius ;
	static	int			gMouseAdjustingCameraLastX;
	static	int			gMouseAdjustingCameraLastY;

};



#endif // __GUI_H__ fin de la routine