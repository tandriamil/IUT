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
// ainsi que des fonctions open gl
//-----------------------------------------------------------------
#include "CGuiGlut.h"
#include <iostream>					// utiliser par la fonction "cout"



CApplication*	CGuiGlut::m_application = 0;
std::string		CGuiGlut::appVersionName = "Tetris 0.0.1";
int				CGuiGlut::windowID = 0;
bool			CGuiGlut::gMouseAdjustingCameraAngle = false;
bool			CGuiGlut::gMouseAdjustingCameraRadius = false;
int				CGuiGlut::gMouseAdjustingCameraLastX = 0;
int				CGuiGlut::gMouseAdjustingCameraLastY = 0;


void CGuiGlut::InitializeGraphics (int argc, char **argv, CApplication* application)
{
	//
	m_application = application;

    // initialize GLUT state based on command line arguments
    glutInit (&argc, argv);

    // display modes: RGB+Z and double buffered
    GLint mode = GLUT_RGB | GLUT_DEPTH | GLUT_DOUBLE;
    glutInitDisplayMode (mode);

    // create and initialize our window with GLUT tools
    // (center window on screen with size equal to "ws" times screen size)
    const int sw = m_application->GetWindowInfo()->m_width; //glutGet (GLUT_SCREEN_WIDTH);
    const int sh = m_application->GetWindowInfo()->m_height; //glutGet (GLUT_SCREEN_HEIGHT);
    const float ws = 0.8f; // window_size / screen_size
    const int ww = (int) (sw * ws);
    const int wh = (int) (sh * ws);
    glutInitWindowPosition ((int) (sw * (1-ws)/2), (int) (sh * (1-ws)/2));
    glutInitWindowSize (ww, wh);
    windowID = glutCreateWindow (appVersionName.c_str());
    ReshapeFunc (ww, wh);
    InitGL ();

    // register our display function, make it the idle handler too
    glutDisplayFunc (&DisplayFunc);
    glutIdleFunc (&DisplayFunc);

    // register handler for window reshaping
    glutReshapeFunc (&ReshapeFunc);

    // register handler for keyboard events
    glutKeyboardFunc (&KeyboardFunc);
    glutSpecialFunc (&SpecialFunc);

    //// register handler for mouse button events
    //glutMouseFunc (&mouseButtonFunc);

    //// register handler to track mouse motion when any button down
    //glutMotionFunc (mouseMotionFunc);

    //// register handler to track mouse motion when no buttons down
    //glutPassiveMotionFunc (mousePassiveMotionFunc);

    //// register handler for when mouse enters or exists the window
    //glutEntryFunc (mouseEnterExitWindowFunc);

	m_application->Init();
}

void CGuiGlut::InitGL(void)
{
    // background = dark gray
    glClearColor (0.3f, 0.3f, 0.3f, 0);

	// OpenGL pour traiter les objets dans la scene a besoin de 2/3 routines, savoir dans quel ordre il affiche les éléments
	// affiche t'on les faces caché (normale dans le sens de la caméra)
	// http://www.linuxgraphic.org/section3d/openGL/didacticiels/didac2/didac4.html
	glEnable(GL_DEPTH_TEST);
	glDepthFunc(GL_LEQUAL);

	// spécifie la couleur de remplissage des faces (soit opengl calcule un dégradé entre les différents sommet de la face, soit vous remplissez
	// la face par la couleur d'un des sommets(GL_FLAT): http://rvirtual.free.fr/programmation/OpenGl/Debut_3D.htm)
	glShadeModel(GL_SMOOTH);

    // enable depth buffer clears
    glClearDepth (1.0f);

    //// select smooth shading
    //glShadeModel (GL_SMOOTH);

    //// enable  and select depth test
    //glDepthFunc (GL_LESS);
    //glEnable (GL_DEPTH_TEST);

    //// turn on backface culling
    //glEnable (GL_CULL_FACE);
    //glCullFace (GL_BACK);

    // enable blending and set typical "blend into frame buffer" mode
    glEnable (GL_BLEND);
    glBlendFunc (GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    // reset projection matrix
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
}


void CGuiGlut::ReshapeFunc(int width, int height)
{
    // set viewport to full window
    glViewport(0, 0, width, height);

    // set perspective transformation
    glMatrixMode (GL_PROJECTION);
    glLoadIdentity ();
    const GLfloat w = width;
    const GLfloat h = height;
    const GLfloat aspectRatio = (height == 0) ? 1 : w/h;
    const GLfloat fieldOfViewY = 45;
    const GLfloat hither = 1;  // put this on CCamera so PlugIns can frob it
    const GLfloat yon = 400;   // put this on CCamera so PlugIns can frob it
    gluPerspective (fieldOfViewY, aspectRatio, hither, yon);

    // leave in modelview mode
    glMatrixMode(GL_MODELVIEW);
}

void CGuiGlut::DisplayFunc(void)
{
    // clear color and depth buffers
    glClear (GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	m_application->Render();

    // double buffering, swap back and front buffers
    glFlush ();
    glutSwapBuffers();

	// stop si 'esc'
	if(m_application->GetUserEvents()->m_keyBoardEvents[Key_ESCAPE])
	{
		glutDestroyWindow(CGuiGlut::windowID);
		m_application->Release();
		delete m_application;
		m_application = 0;
		exit(0);
	}

	m_application->GetUserEvents()-> ClearKeyBardEvents();
}


void CGuiGlut::KeyboardFunc(unsigned char key, int /*x*/, int /*y*/)
{
    std::ostringstream message;

    // ascii codes
    const int space = 32;
    const int esc = 27; // escape key

	switch (key)
	{
		case space:				m_application->GetUserEvents()->m_keyBoardEvents[Key_SPACE] = true; break;
		case esc:				m_application->GetUserEvents()->m_keyBoardEvents[Key_ESCAPE] = true; break;

		case 'a':				m_application->GetUserEvents()->m_keyBoardEvents[Key_a] = true; break;
		case 'b':				m_application->GetUserEvents()->m_keyBoardEvents[Key_b] = true; break;
		case 'c':				m_application->GetUserEvents()->m_keyBoardEvents[Key_c] = true; break;
		case 'd':				m_application->GetUserEvents()->m_keyBoardEvents[Key_d] = true; break;
		case 'e':				m_application->GetUserEvents()->m_keyBoardEvents[Key_e] = true; break;
		case 'f':				m_application->GetUserEvents()->m_keyBoardEvents[Key_f] = true; break;
		case 'g':				m_application->GetUserEvents()->m_keyBoardEvents[Key_g] = true; break;
		case 'h':				m_application->GetUserEvents()->m_keyBoardEvents[Key_h] = true; break;
		case 'i':				m_application->GetUserEvents()->m_keyBoardEvents[Key_i] = true; break;
		case 'j':				m_application->GetUserEvents()->m_keyBoardEvents[Key_j] = true; break;
		case 'k':				m_application->GetUserEvents()->m_keyBoardEvents[Key_k] = true; break;
		case 'l':				m_application->GetUserEvents()->m_keyBoardEvents[Key_l] = true; break;
		case 'm':				m_application->GetUserEvents()->m_keyBoardEvents[Key_m] = true; break;
		case 'n':				m_application->GetUserEvents()->m_keyBoardEvents[Key_n] = true; break;
		case 'o':				m_application->GetUserEvents()->m_keyBoardEvents[Key_o] = true; break;
		case 'p':				m_application->GetUserEvents()->m_keyBoardEvents[Key_p] = true; break;
		case 'q':				m_application->GetUserEvents()->m_keyBoardEvents[Key_q] = true; break;
		case 'r':				m_application->GetUserEvents()->m_keyBoardEvents[Key_r] = true; break;
		case 's':				m_application->GetUserEvents()->m_keyBoardEvents[Key_s] = true; break;
		case 't':				m_application->GetUserEvents()->m_keyBoardEvents[Key_t] = true; break;
		case 'u':				m_application->GetUserEvents()->m_keyBoardEvents[Key_u] = true; break;
		case 'v':				m_application->GetUserEvents()->m_keyBoardEvents[Key_v] = true; break;
		case 'w':				m_application->GetUserEvents()->m_keyBoardEvents[Key_w] = true; break;
		case 'x':				m_application->GetUserEvents()->m_keyBoardEvents[Key_x] = true; break;
		case 'y':				m_application->GetUserEvents()->m_keyBoardEvents[Key_y] = true; break;
		case 'z':				m_application->GetUserEvents()->m_keyBoardEvents[Key_z] = true; break;

		default: break;
	}
}

void CGuiGlut::SpecialFunc(int key, int /*x*/, int /*y*/)
{
    std::ostringstream message;

	switch (key)
	{
		case GLUT_KEY_F1:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F1] = true; break;
		case GLUT_KEY_F2:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F2] = true; break;
		case GLUT_KEY_F3:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F3] = true; break;
		case GLUT_KEY_F4:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F4] = true; break;
		case GLUT_KEY_F5:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F5] = true; break;
		case GLUT_KEY_F6:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F6] = true; break;
		case GLUT_KEY_F7:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F7] = true; break;
		case GLUT_KEY_F8:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F8] = true; break;
		case GLUT_KEY_F9:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F9] = true; break;
		case GLUT_KEY_F10:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F10] = true; break;
		case GLUT_KEY_F11:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F11] = true; break;
		case GLUT_KEY_F12:		m_application->GetUserEvents()->m_keyBoardEvents[Key_F12] = true; break;

		//case GLFW_KEY_RCTRL:	m_application->GetUserEvents()->m_keyBoardEvents[Key_RCTRL] = true; break;
		//case GLFW_KEY_LCTRL:	m_application->GetUserEvents()->m_keyBoardEvents[Key_LCTRL] = true; break;
		//case GLFW_KEY_RSHIFT:	m_application->GetUserEvents()->m_keyBoardEvents[Key_RSHIFT] = true; break;
		//case GLFW_KEY_LSHIFT:	m_application->GetUserEvents()->m_keyBoardEvents[Key_LSHIFT] = true; break;
		//case GLFW_KEY_RALT:		m_application->GetUserEvents()->m_keyBoardEvents[Key_RALT] = true; break;
		//case GLFW_KEY_LALT:		m_application->GetUserEvents()->m_keyBoardEvents[Key_LALT] = true; break;

		//// ... todo
		//case GLFW_KEY_KP_0:		m_application->GetUserEvents()->m_keyBoardEvents[Key_KP0] = true; break;
		//case GLFW_KEY_KP_1:		m_application->GetUserEvents()->m_keyBoardEvents[Key_KP1] = true; break;
		//case GLFW_KEY_KP_2:		m_application->GetUserEvents()->m_keyBoardEvents[Key_KP2] = true; break;
		//case GLFW_KEY_KP_3:		m_application->GetUserEvents()->m_keyBoardEvents[Key_KP3] = true; break;
		//case GLFW_KEY_KP_4:		m_application->GetUserEvents()->m_keyBoardEvents[Key_KP4] = true; break;
		//case GLFW_KEY_KP_5:		m_application->GetUserEvents()->m_keyBoardEvents[Key_KP5] = true; break;
		//case GLFW_KEY_KP_6:		m_application->GetUserEvents()->m_keyBoardEvents[Key_KP6] = true; break;
		//case GLFW_KEY_KP_7:		m_application->GetUserEvents()->m_keyBoardEvents[Key_KP7] = true; break;
		//case GLFW_KEY_KP_8:		m_application->GetUserEvents()->m_keyBoardEvents[Key_KP8] = true; break;
		//case GLFW_KEY_KP_9:		m_application->GetUserEvents()->m_keyBoardEvents[Key_KP9] = true; break;

		case GLUT_KEY_RIGHT:	m_application->GetUserEvents()->m_keyBoardEvents[Key_RIGHT]	= true; break;
		case GLUT_KEY_LEFT:		m_application->GetUserEvents()->m_keyBoardEvents[Key_LEFT]	= true; break;
		case GLUT_KEY_DOWN:		m_application->GetUserEvents()->m_keyBoardEvents[Key_DOWN]	= true; break;
		case GLUT_KEY_UP:		m_application->GetUserEvents()->m_keyBoardEvents[Key_UP]		= true; break;

		default: break;
	}
}


void CGuiGlut::RunGraphics (void)
{
    glutMainLoop ();
}
