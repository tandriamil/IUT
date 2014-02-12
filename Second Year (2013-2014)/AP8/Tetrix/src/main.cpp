//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================


#include "CGuiGlut.h"
#include "CProjetTetris.h"

////////////////////////////////////////////////////////////////////////
/// la fonction main est spéciale 
/// puisque la premiere lancée à l'execution automatiquement
///
/// return code de fin d'application
////////////////////////////////////////////////////////////////////////
int main ( int argc, char *argv[] ) {

	CProjetTetris* monProjet = new CProjetTetris();

	// initialize graphics
	// cette méthode permet d'intialiser le fenetrage associé à votre application: CProjetTetris
   	CGuiGlut::InitializeGraphics ( argc, argv, monProjet );

	// run the main event processing loop
	// on lance une boucle infinie de rendu/mise à jour de la fenêtre/mise à jour de votre jeu 
	// qui se finit uniquement quand l'utilisateur le demande !!! esc ou X
	CGuiGlut::RunGraphics();  

	delete monProjet;
}
