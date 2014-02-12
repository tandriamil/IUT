//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================


//=====================================================================
// classe APPLICATION, s'occupe d'encapsuler l'ensemble des fonction communes à une application
//=====================================================================
#ifndef __APPLICATION_H__	// routine qui sert à pas inclure 2 fois le même fichier
#define __APPLICATION_H__	//



//-----------------------------------------------------------------
// Notre programme va avoir besoin 
// des fonctions spécifiques à l'utilisateur (iterface graphique utilisateur GUI) et
// des fonctions nécéssaires au rendu d'un objet dans la scene
//
// On inclu les fichiers .h qui contiennent les déclarations des fonctions
//-----------------------------------------------------------------
#include "Common.h"				// données liées à la souris
#include "CRenderer.h"			// objet CRenderer


////////////////////////////////////////////////////////////////////////
/// classe CApplication: elle encapsule l'ensemble de l'application à savoir l'utilisation du GUI et du renderer
/// L'objectif étant qu'elle sert de classe commune à ttes applications qui se serviront des fonctions suivantes
////////////////////////////////////////////////////////////////////////
class CApplication {

public:
	//----------------------------------------------------------
	// constructeur de l'objet
	//----------------------------------------------------------
	CApplication() 
		:m_windowSetUp(new WindowSetup(800, 640)), m_UserEvents(0), m_camera(0)  {}

	//----------------------------------------------------------
	// destructeur de l'objet
	//----------------------------------------------------------
	virtual ~CApplication(){}

	//----------------------------------------------------------
	// initilisation de l'appli
	//----------------------------------------------------------
	void Init()		;

	//----------------------------------------------------------
	// boucle de rendu
	//----------------------------------------------------------
	void Render()		;

	//----------------------------------------------------------
	// fin de l'appli, destruction et nettoyage des objets utilisé*
	// au cour de l'appli
	//----------------------------------------------------------
	void Release()	;


	//----------------------------------------------------------
	// appel à la structure des évènements utilisateur
	//----------------------------------------------------------
	UserEvents*	GetUserEvents();

	//----------------------------------------------------------
	// appel à la structure de config de la fenêtre
	//----------------------------------------------------------
	WindowSetup*	GetWindowInfo();

protected:

	//==================================================================
	// Méthodes dédiées à l'héritage
	//==================================================================
	//----------------------------------------------------------
	// l'appel à la fonction d'initialisation de notre sous objet "appli spécifique"
	//----------------------------------------------------------
	virtual bool OnInit() = 0;

	//----------------------------------------------------------
	// l'appel à la fonction de  rendu de notre sous objet "appli spécifique"
	//----------------------------------------------------------
	virtual void OnRender() = 0;

	//----------------------------------------------------------
	// l'appel à la fonction de destruction de notre sous objet "appli spécifique"
	//----------------------------------------------------------
	virtual void OnRelease() = 0;


	//----------------------------------------------------------
	// Données membres
	//----------------------------------------------------------
	WindowSetup*	m_windowSetUp;	///< infos liées à la fenêtre (pointeur car paratagé par deux objets)
	CRenderer		m_renderer	;	///< Déclaration du renderer 
	UserEvents*		m_UserEvents;	///< infos liées à la souris/caméra (pointeur car paratagé par deux objets)
	CCamera*			m_camera	;	// la camera
};

inline WindowSetup*		CApplication::GetWindowInfo()		{ return m_windowSetUp;}
inline UserEvents*		CApplication::GetUserEvents()		{ return m_UserEvents;}



#endif // __APPLICATION_H__ fin de la routine
