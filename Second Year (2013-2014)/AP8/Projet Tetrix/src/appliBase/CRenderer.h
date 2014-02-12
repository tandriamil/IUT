//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================

//=====================================================================
// classe CRenderer, s'occupe de gérer l'affichage de la scene
//=====================================================================
//-----------------------------------------------------------------
// Ici fichier des déclarations des fonctions. Une fonction ne peut être déclarée qu'une seule fois par le fichier principal (main.cpp)
// d'ou l'ajout d'une routine qui dit que si votre fichier à déjà été inclu avant pas la peine de le re-inclure
//-----------------------------------------------------------------
#ifndef __RENDERER_H__	// routine qui sert à pas inclure 2 fois le même fichier
#define __RENDERER_H__	//


//-----------------------------------------------------------------
// On inclu les fichiers .h qui contiennent les déclarations des fonctions dont a besion
// On a besoin ici de la structure UserEvents contenant les déplacement de la souris à chaque frame
//-----------------------------------------------------------------
#include "Common.h"		// données liées à la souris
#include "GL/glut.h"


////////////////////////////////////////////////////////////////////////
/// classe caméra: s'occupe de mettre à jour la position de la caméra dans la fonction gluLookAt
////////////////////////////////////////////////////////////////////////
class CCamera
{
public:
	//----------------------------------------------------------
	// constructeur de l'objet
	//----------------------------------------------------------
	CCamera()
		:m_UserEvents(0), m_XOffset(0.0f), m_YOffset(0.0f), m_ZOffset(100.0f), m_rotateX(0.0f), m_rotateY(45.0f){}

	//----------------------------------------------------------
	// Destructeur de l'objet
	//----------------------------------------------------------
	~CCamera()
	{
		m_UserEvents = 0;
	}

	//----------------------------------------------------------
	// compute met à jour les coordonnées de poistion de la caméra
	//----------------------------------------------------------
	virtual CMatrix44& Compute() = 0;


	//----------------------------------------------------------
	// Données membres
	//----------------------------------------------------------
	UserEvents*		m_UserEvents				;		///< pointeur sur l'objet partagé mouse events mis à jour par le GUI
	CMatrix44		m_viewMatrix				;		///< matrice de transformation de la vue
	float			m_XOffset, m_YOffset, m_ZOffset,	///< x,y rotate
					m_rotateX, m_rotateY;				///< x,y,z offset
	CVector4			m_translate;
};


class CCameraLookAt: public CCamera
{
public:
	//----------------------------------------------------------
	// constructeur de l'objet
	//----------------------------------------------------------
	CCameraLookAt()
		:m_posX(50.0f), m_posY(50.0f), m_posZ(50.0f),
		 m_viewX(0.0f), m_viewY(0.0f), m_viewZ(0.0f),
		 m_upX(0.0f), m_upY(1.0f), m_upZ(0.0f){}

	//----------------------------------------------------------
	// Destructeur de l'objet
	//----------------------------------------------------------
	~CCameraLookAt() {}

	//----------------------------------------------------------
	// compute met à jour les coordonnées de poistion de la caméra
	//----------------------------------------------------------
	CMatrix44& Compute();


	//----------------------------------------------------------
	// Données membres
	//----------------------------------------------------------
	float m_posX,	m_posY,	 m_posZ	;	///< look at variables (pos)
	float m_viewX,	m_viewY, m_viewZ;	///< look at variables (view)
	float m_upX,	m_upY,	 m_upZ	;	///< look at variables (up)
};



////////////////////////////////////////////////////////////////////////
// opengl helper
////////////////////////////////////////////////////////////////////////
/** \brief Noeud graphique représentant un cylindre.
	Le cylindre est décrit par les rayons de lsa base et de son sommet, ainsi que par sa hauteur.
	\warning : La hauteur se situe sur l'axe des Z.
*/
struct CGraphicCylinder
{
	/** Gestion de l'affichage openGL
	  \param radiues : le rayon du cylindre
	  \param x,y, z : extremite du rayon
	*/
	static void Draw(float radius, float x, float y, float z);
} ;


/** \brief Noeud de géométrie représentant une sphère.
*/
struct CGraphicSphere
{
	/** \brief Gestion de l'affichage OpenGL
		 \param radius : le rayon de la sphère
	*/
	static void Draw(float radius, CVector3 color = CVector3(1.0f, 0.0f, 0.0f));
};


////////////////////////////////////////////////////////////////////////
///  tutorial sympa pour commencer : http://www-evasion.imag.fr/Membres/Antoine.Bouthors/teaching/opengl/
///
/// le renderer est notre classe qui va
///		- intialiser notre matrice de transformation de l'espace caméra à l'espace de projection
///		- initialiser notre matrice de transformation de l'espace monde à l'espace caméra
///		- intialiser notre scene dans l'espace monde
///		- dessiner des objets 3D, des gémométries
////////////////////////////////////////////////////////////////////////
enum PrimitiveType
{
	PT_Face = 1,
	PT_Edge = 10,
	PT_Vertex = 100
};

class CRenderer
{
public:		// les fonctions suivantes peuvent être appelées par d'autres classes / programmes
	//----------------------------------------------------------
	// constructeur par défaut de l'objet (appeler automatiquement à la déclaration (si l'objet n'est pas un pointeur))
	// rien à mettre dedans pour le moment, notre programme n'a pas besoin d'objets temporaires
	//----------------------------------------------------------
	CRenderer();

	//----------------------------------------------------------
	// constructeur de l'objet (appelée uniquement par la classe CApplication !!!!!!)
	//----------------------------------------------------------
	CRenderer(WindowSetup* windowSetup, UserEvents* UserEvents, CCamera* camera);

	//----------------------------------------------------------
	// Autre façon de créer le renderer (appelée uniquement par la classe CApplication !!!!!!)
	//----------------------------------------------------------
	void Create(WindowSetup* windowSetup, UserEvents* UserEvents, CCamera* camera);

	//----------------------------------------------------------
	// Destructeur de l'objet appeler automatiquement à la fin de la fonction main (si l'objet n'est pas un pointeur))
	// rien à mettre dedans pour le moment, notre programme n'a pas besoin d'objets temporaires
	//----------------------------------------------------------
	~CRenderer();

	//----------------------------------------------------------
	// fonction d'initialisation, initialie OPENGL	(appelée uniquement par la classe CApplication !!!!!!)
	//----------------------------------------------------------
	bool Init();



	//----------------------------------------------------------
	// fonction d'affichage appelé à chaque bouche de rendu (appelée uniquement par la classe CApplication !!!!!!)
	//----------------------------------------------------------
	void StartRender();

	//----------------------------------------------------------
	// fonction qui permet de configurer les options propres au renderer
	//----------------------------------------------------------
	RendererSetup*	SetUpRenderer();

	//----------------------------------------------------------
	// fonction d'initialisation de la transformation de projection
	//----------------------------------------------------------
	void LoadProjectionMatrix(CMatrix44& projection);

	//----------------------------------------------------------
	// fonction dde mise à jour de la transformation de vue
	//----------------------------------------------------------
	void LoadViewMatrix(const CMatrix44& view);




	//----------------------------------------------------------
	// lancement d'une phase d'affichage 2D (A appeler éventuellement dans OnRender()
	//----------------------------------------------------------
	void Start2DRender();

	//----------------------------------------------------------
	// fin d'affichage 2D (A appeler éventuellement dans OnRender()
	//----------------------------------------------------------
	void End2DRender();

	//----------------------------------------------------------
	// Affichage d'un texte
	//
	// \param string : le texte
	// \param int : position en x
	// \param int : position en y
	// \param TextSize : taille du texte
	// \param CVector3 : couleur du texte RGB, r,g,v \in [0,1]
	//
	//----------------------------------------------------------
	enum TextSize{TS_10, TS_12, TS_18};
	void DrawText(const std::string& text, int x, int y, TextSize s = TS_12, CVector3 color = CVector3(1.0f, 0.0f, 0.0f));



protected:	// les fonctions suivantes peuvent être appelées seulement pas cettte même classe et les classes filles de cette classe

	//----------------------------------------------------------
	// Données membres
	//----------------------------------------------------------
	WindowSetup*	m_windowSetup	;	// config et evenement liés à la fenêtre
	CCamera*			m_camera		;	// la camera
	RendererSetup	m_rendererSetup	;	// config et evenement du renderer


	//----------------------------------------------------------
	// fonction qui affiche un plan dans l'espace 3d
	//----------------------------------------------------------
	void DrawGround(float _size);


	//----------------------------------------------------------
	// Affichage d'un texte
	//----------------------------------------------------------
	void DrawText(const std::string& text, int x, int y, void *police);
};


// les fonctions inline permette une optimisation du code. Brievement, le corps des fonctions suivantes
// remplace les valeurs appelés dans le code par ces mêmes fonctions
inline	CRenderer::CRenderer() :m_camera() {}
inline	CRenderer::~CRenderer(){m_windowSetup = 0;}
inline	CRenderer::CRenderer(WindowSetup* windowSetup, UserEvents* UserEvents,  CCamera* camera)
	:m_windowSetup(windowSetup), m_camera(camera)
{
	m_camera->m_UserEvents = UserEvents;
}

inline void CRenderer::Create(WindowSetup* windowSetup, UserEvents* UserEvents, CCamera* camera)
{
	m_windowSetup = windowSetup;
	m_camera = camera;
	m_camera->m_UserEvents = UserEvents;
}
inline RendererSetup*	CRenderer::SetUpRenderer()	{ return &m_rendererSetup;}


#endif // __RENDERER_H__ fin de la routine
