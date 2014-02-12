//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================


//-----------------------------------------------------------------
// On inclu les fichiers .h qui contiennent les déclarations des fonctions
// Les implémentations de nos fonctions ont besoin de leurs déclarations 
// ainsi que des déclarations des fonctions OPENGL
//-----------------------------------------------------------------
#include "CRenderer.h"

#include <cmath>
#include <iostream>					// utiliser par la fonction "cout"
using namespace std;
	
/////////////////////////////////////////////////////////////
/// Initialise le renderer 
///
/// \return code d'erreur
////////////////////////////////////////////////////////////
bool CRenderer::Init()
{
	// init glew
	//GLenum error = glewInit();

	// Problem: glewInit failed, something is seriously wrong.
	//if( GLEW_OK != error ) 
	//{
	//	std::cout << "GLEW ERROR !" << std::endl;
	//	std::cout << glewGetErrorString( error ) << std::endl;
	//	return false;
	//}

	// assurons nous que la caméra et la srtucture de config de la fenêtre a été bien intialisée
	if( (!m_camera->m_UserEvents) || (!m_windowSetup))
		return false;

	// intialisation de notre matrice de transformation de l'espace caméra à l'espace de projection
	CMatrix44 projection = CMatrix44::CreatePerspective(45.0f, static_cast<float>(m_windowSetup->m_width) / static_cast<float>(m_windowSetup->m_height), 0.2f, 5000.0f);
	LoadProjectionMatrix(projection);	

	// On donne une colueur à notre fond d'espace (background)
	glClearColor(m_rendererSetup.m_clearColor[0], m_rendererSetup.m_clearColor[1], 
				 m_rendererSetup.m_clearColor[2], m_rendererSetup.m_clearColor[3]);

	// OpenGL pour traiter les objets dans la scene a besoin de 2/3 routines, savoir dans quel ordre il affiche les éléments
	// affiche t'on les faces caché (normale dans le sens de la caméra) 
	// http://www.linuxgraphic.org/section3d/openGL/didacticiels/didac2/didac4.html
	glEnable(GL_DEPTH_TEST);
	glDepthFunc(GL_LEQUAL);

	// spécifie la couleur de remplissage des faces (soit opengl calcule un dégradé entre les différents sommet de la face, soit vous remplissez
	// la face par la couleur d'un des sommets(GL_FLAT): http://rvirtual.free.fr/programmation/OpenGl/Debut_3D.htm)
	glShadeModel(GL_SMOOTH);

	// dimension de la fenetre de sortie
	glViewport(0,0,m_windowSetup->m_width, m_windowSetup->m_height);

	return true;
}


/////////////////////////////////////////////////////////////
/// lance les méthodes communes à chaque frame
///
////////////////////////////////////////////////////////////
void CRenderer::StartRender()
{
	// remet à zeros les buffer précédents
	glClear(GL_COLOR_BUFFER_BIT |						// Efface le frame buffer (l'image précédente)
			GL_DEPTH_BUFFER_BIT);						// Efface le Z-buffer (le calcul de profondeur l'image précédente)

	// mise a jour des coordonnées de la caméra et on mets à jour la transformation de la caméra
	LoadViewMatrix(m_camera->Compute());
	
	// afficher le sol
	if( m_rendererSetup.m_drawGround )
		DrawGround(500.0f);
}

/////////////////////////////////////////////////////////////
/// charge la matrice de projection
///
/// \param matrice de projection
////////////////////////////////////////////////////////////
void CRenderer::LoadProjectionMatrix(CMatrix44& projection)
{
	glMatrixMode(GL_PROJECTION);						// on spécifie qu'on se positionne dans l'espase de projection
	glLoadIdentity();									// on lui donne comme transformation la matrice identité
	
	// on envoit la matrice de projection à la carte graphique
	glLoadMatrixf(&(projection.b[0]));

	// Ancien code
	//-------------------------
	// on envoit la matrice de projection à la carte graphique
	//CMatrix44 projection = CMatrix44::CreatePerspective(45.0f, static_cast<float>(m_windowSetup->m_width) / static_cast<float>(m_windowSetup->m_height), 0.2f, 100.0f);
	//glLoadMatrixf(&(projection.b[0]));

	// Autre méthode: il existe une librairie directement intégré à OPENGL (glu) qui forunit directement une fonction 
	//gluPerspective(45.0f, 800.0f/640.0f, 0.2f, 100.0f);	// Angle de la caméra, clipping entre 1 et 100 (pas à partir de 0,
															// sinon on perd toute la précision du z-buffer)
}

/////////////////////////////////////////////////////////////
/// charge la matrice de vue
///
/// \param matrice de vue
////////////////////////////////////////////////////////////
void CRenderer::LoadViewMatrix(const CMatrix44& view)
{
	glMatrixMode(GL_MODELVIEW);							// on se place dans le repere de la camera
	glLoadIdentity();									// on lui donne comme transformation la matrice identité

	// matrice de vue 	
	glLoadMatrixf(&(view.b[0]));

	// Ancien code
	//-------------------------
	// matrice de vue 		
	//CMatrix44 view = CMatrix44::CreatelookAt(CVector3(m_camera.m_posX, m_camera.m_posY, m_camera.m_posZ),		// position de la camera
	//							 CVector3(m_camera.m_viewX, m_camera.m_viewY, m_camera.m_viewZ),	// endroit de la scene vers ou la caméra pointe (regarde)
	//							 CVector3(m_camera.m_upX, m_camera.m_upY, m_camera.m_upZ));		// orientation verticale
	//glLoadMatrixf(&(view.b[0])));

	// Autre méthode: il existe une librairie directement intégré à OPENGL (glu) qui forunit directement une fonction 
	//gluLookAt(m_camera.m_posX, m_camera.m_posY, m_camera.m_posZ,		// position de la camera
	//			m_camera.m_viewX, m_camera.m_viewY, m_camera.m_viewZ,	// endroit de la scene vers ou la caméra pointe (regarde)
	//			m_camera.m_upX, m_camera.m_upY, m_camera.m_upZ);		// orientation verticale

}









/////////////////////////////////////////////////////////////
/// lancement d'une phase d'affichage 2D ( A appeler éventuellement dans OnRender()
/////////////////////////////////////////////////////////////
void CRenderer::Start2DRender()
{
	glDisable(GL_DEPTH_TEST);
	glEnable(GL_BLEND) ;
	glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA) ;
	glMatrixMode(GL_PROJECTION);
	glPushMatrix();
	glLoadIdentity();
	gluOrtho2D(0.0, m_windowSetup->m_width, 0.0, m_windowSetup->m_height);
	glMatrixMode(GL_MODELVIEW);
	glPushMatrix();
	glLoadIdentity();
}

/////////////////////////////////////////////////////////////
/// fin d'affichage 2D ( A appeler éventuellement dans OnRender()
/////////////////////////////////////////////////////////////
void CRenderer::End2DRender()
{
	glMatrixMode(GL_PROJECTION);
	glPopMatrix();
	glMatrixMode(GL_MODELVIEW);
	glPopMatrix();

	glEnable(GL_DEPTH_TEST);

	//glFlush();
}


/////////////////////////////////////////////////////////////
/// Affichage d'un texte
///
/// \param string : le texte
/// \param int : position en x
/// \param int : position en y
///
/////////////////////////////////////////////////////////////
void CRenderer::DrawText(const std::string& text, int x, int y, TextSize s, CVector3 color)
{
	glColor3f(color.x,color.y,color.z);
	switch(s)
	{
		case TS_10: DrawText(text,x,y,GLUT_BITMAP_HELVETICA_10); break;
		case TS_12: DrawText(text,x,y,GLUT_BITMAP_HELVETICA_12); break;
		case TS_18: DrawText(text,x,y,GLUT_BITMAP_HELVETICA_18); break;
	}
}



/////////////////////////////////////////////////////////////
/// Affichage d'un texte
///
/// \param string : le texte
/// \param int : position en x
/// \param int : position en y
/// \param void : police GLUT
///
/////////////////////////////////////////////////////////////
void CRenderer::DrawText(const std::string& text, int x, int y, void *police)
{
	glRasterPos2f(x, y);
	for(std::string::const_iterator it = text.begin(); it < text.end(); it++) 
		glutBitmapCharacter(police, *it);
}







/////////////////////////////////////////////////////////////
/// dessine un sol
///
/// \param _size : Taille d'un carreau
///
////////////////////////////////////////////////////////////
void CRenderer::DrawGround(float _size)
{
	float step = _size/40; 
	
	glDisable(GL_LIGHTING);
	glColor3d(0.3,0.3,0.3);
	unsigned int count = 0;
	for (float i = 0 ; i <= 2.0*_size ; i=i+step, count++)
	{
		if (!(count%5)) glLineWidth(3.0f);
		else glLineWidth(1.0f);
		glBegin(GL_LINES);
			glVertex3d(-_size+i,0.001,-_size);
			glVertex3d(-_size+i,0.001,_size);
			glVertex3d(-_size,0.001,-_size+i);
			glVertex3d(_size,0.001,-_size+i);
		glEnd();
	}

	// draw some plane
	glColor3d(0.4,0.4,0.4);
	glBegin(GL_QUADS);
		glVertex3d(-_size,-0.01,-_size);glVertex3d(-_size,-0.01,_size);
		glVertex3d(_size,-0.01,_size);glVertex3d(_size,-0.01,-_size);
	glEnd();
}
 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Partie Animation
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void CGraphicCylinder::Draw(float radius, float x, float y, float z)
{
	glPushMatrix() ;
	glLineWidth(radius);
	glColor3f(1.0F, 1.0F, 0.0F) ;
	glBegin(GL_LINES);
		glVertex3f(0.0f,0.0f,0.0f);
		glVertex3f(x, y, z) ;
	glEnd();
	    
	glPopMatrix() ;
}

void CGraphicSphere::Draw(float radius, CVector3 color)
{
	GLUquadric * quadric=gluNewQuadric() ;
	gluQuadricOrientation(quadric, GLU_OUTSIDE) ;
	glColor3f(color.x, color.y, color.z) ;
	gluSphere(quadric, radius, 10, 10) ;
	gluDeleteQuadric(quadric) ;
}


/////////////////////////////////////////////////////////////
/// mets à jour les attributs de la caméra en fonction des évenements souris
///
////////////////////////////////////////////////////////////
CMatrix44& CCameraLookAt::Compute()
{
	// si boutton du milieu on fait varier la distance entre la caméra et le point vers lequelle elle pointe
	// le zoom quoi
	if(m_UserEvents->mousebuttons[1]) // bouton droite
	{

	}

	// si boutton de droite on fait tourner la caméra autour du point vers lequelle elle pointe
	if(m_UserEvents->mousebuttons[2]) // boutton molette
	{
	}	

	m_viewMatrix = CMatrix44::CreateLookAt(	CVector3(m_posX, m_posY, m_posZ),	// position de la camera
											CVector3(m_viewX, m_viewY, m_viewZ),	// endroit de la scene vers ou la caméra pointe (regarde)
											CVector3(m_upX, m_upY, m_upZ));		// orientation verticale
	
	// 
	if(m_UserEvents->mousebuttons[0]) // boutton gauche
	{
	}	

	m_viewMatrix.Translate(m_translate);

	return m_viewMatrix;
}	

