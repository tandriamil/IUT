//========================================================================
// Projet DUT C++ / Jeu Tetris
//
//------------------------------------------------------------------------
// Copyright (c) 2010-2011 Equipe SAMSARA (T. LE NAOUR, N. COURTY, S. GIBET)
// VALORIA - UBS 
//========================================================================


//-----------------------------------------------------------------
// On inclut les fichiers .h qui contiennent les déclarations des méthodes
// Les implémentations de nos méthodes ont besoin de leurs déclarations 
// ainsi que des déclarations des fonctions OPENGL
//-----------------------------------------------------------------
#include "CApplication.h"

/////////////////////////////////////////////////////////////
/// Initialise le GUI (Graphic user interface), le renderer et l'application enfant
///
/// \return code d'erreur
////////////////////////////////////////////////////////////
void CApplication::Init() {

	// infos liées à la souris/caméra (pointeur car paratagé par deux objets)
	m_UserEvents = new UserEvents				;

	// construction de la caméra
	m_camera = new CCameraLookAt();

	// Déclaration du renderer (le renderer va automatiquement appeler son contructeur)
	m_renderer.Create(m_windowSetUp, m_UserEvents, m_camera)	;

	// appel à la méthode de début enfant
	OnInit();

}


/////////////////////////////////////////////////////////////
/// lance la boucle d'affichage, gère les évenements système et le rendu de la scène
///
////////////////////////////////////////////////////////////
void CApplication::Render() {

	// appel à la méthode de rendu enfant
	OnRender();
}

/////////////////////////////////////////////////////////////
/// Fini l'application: détruit les objets plus utilisés
///
////////////////////////////////////////////////////////////
void CApplication::Release() {

	// appel à la méthode de fin enfant
	OnRelease();

	//// on supprime la mémoire allouée aux objets gui et mouse events
	//delete m_camera		;
	delete m_windowSetUp;
	delete m_UserEvents;
}
