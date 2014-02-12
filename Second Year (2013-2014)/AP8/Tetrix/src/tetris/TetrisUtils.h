#ifndef __TETRIS_UTILS_H__	// routine qui sert à pas inclure 2 fois le même fichier
#define __TETRIS_UTILS_H__	//


#define WIDTH_BOARD  10		///< largeur de la grille du jeu
#define HEIGHT_BOARD  20	///< hauteur de la grille du jeu
#define POSX_BOARD  300		///< position en X de la grille du jeu dans la fenêtre GLUT
#define POSY_BOARD  100		///< position en Y de la grille du jeu dans la fenêtre GLUT
#define DIM_CASE  17.0 		///< taille d'une case de la grille du jeu (carrée)

/**
	\brief Actions possibles par l'utilisateur
*/
enum PieceAction
{
	PA_RotateRight, // rotation horlogique
	PA_RotateLeft,	// rotation anti-horlogique
	PA_MoveRight,	// déplacement à droite
	PA_MoveLeft,	// déplacement à gauche
	PA_MoveBottom,	// déplacement vers le bas
	PA_MoveBottom2 	// déplacement rapide vers le bas
};

/**
	\brief Etat du jeu après une action (update, modification de position ou orientation piece)
*/
enum ActionResult
{
	AR_Ok,
	AR_Collision,
	AR_GameOver
};



#endif // __TETRIS_UTILS_H__ fin de la routine
