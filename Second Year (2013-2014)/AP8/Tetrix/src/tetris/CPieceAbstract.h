//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================



#ifndef __CPIECE_ABSTRACT_H__	// routine qui sert à éviter l'inclusion multiple
#define __CPIECE_ABSTRACT_H__	//

#include "Common.h"

typedef vector<int> TPieceRow;	// 1 = case coloriée, 0 = case vide
typedef vector<TPieceRow> TPieceTable;

//-------------------------------------------------------------------------------------------------------------------
/**
	\brief classe CPieceAbstract abstraite
*/
//-------------------------------------------------------------------------------------------------------------------
class CPieceAbstract {

public:

	virtual ~CPieceAbstract();

	/**
		\brief rotation de la piece vers la droite
	*/
	void TurnRight();

	/**
		\brief rotation de la piece vers la gauche
	*/
	void TurnLeft();

	/**
		\brief rotation de la piece en fonction de l'état courant (à redéfinir dans les classes filles)
	*/
	virtual void Turn() = 0;

	/**
		\brief renvoit la matrice d'état courante
		\return la matrice de la piece
	*/
	TPieceTable& GetTable();

	/**
		\brief modifie la matrice d'état de la piece
		\param la matrice de la piece
	*/
	void SetTable(const TPieceTable& table);

	/**
		\brief index en abcisse de la piece dans le tetrix
		\return entier de l'index en abcisse de la piece dans le tetrix
	*/
	int GetColIndex();

	/**
		\brief index en ordonnée de la piece dans le tetrix
		\return entier de l'index en ordonnée de la piece dans le tetrix
	*/
	int GetRowIndex();

	/**
		\brief incrémentation ou décrémentation de l'index de ligne (ordonnée)
		\param la valeur de l'incrémentation (>0) ou décrémentation (<0)
	*/
	void SetIncDecRowIndex ( int val );

	/**
		\brief incrémentation ou décrémentation de l'index de colonne (abscisse)
		\param la valeur de l'incrémentation (>0) ou décrémentation (<0)
	*/
	void SetIncDecColIndex ( int val );

	/**
		\brief permet de modifier l'index en abcisse de la piece dans le tetrix
		\return entier de l'index en abcisse de la piece dans le tetrix
	*/
	void SetColIndex ( int newColIndex );

	/**
		\brief permet de modifier l'index en ordonnée de la piece dans le tetrix
		\return entier de l'index en abcisse de la piece dans le tetrix
	*/
	void SetRowIndex ( int newRowIndex );

	/**
		\brief renvoit la couleur de la piece
		\return vecteur 3 sur la couleur rgb de la piece
	*/
	const CVector3& GetColor();

	/**
		affiche le contenu de la matrice TPieceTable à l'écran
	*/
	friend ostream& operator<< ( ostream& flux, const CPieceAbstract& p );

protected:
	/**
		\brief constructeur de piece
		\param dim: obligé pour initialiser le tableau (la matrice)
		\param entier de l'index en abcisse de la piece dans le tetrix
		\param entier de l'index en ordonnée de la piece dans le tetrix
		\param vecteur 3 sur la couleur rgb de la piece
		\remarque initialisation d'un état par défaut, du tableau
	*/
	CPieceAbstract ( unsigned int dim, int iX, int iY, const CVector3& color );

	// Eventuellement à cause de l'héritage => appel par la sous-classe du constructeur vide
	CPieceAbstract() {;}

	//----------------------------------------------------------
	// Enumération de l'état/posture de la piece
	//----------------------------------------------------------

	// dans le sens horlogique
	enum State {

		S_Top,
		S_Right,
		S_Bottom,
		S_Left
	};

	//----------------------------------------------------------
	// Données membres
	//----------------------------------------------------------
	unsigned int		m_dim	;		///< dimension de la piece
	TPieceTable		m_table;		///< matrice d'état de la piece
	State			m_state	;		///< posture de la pièce
	int			m_colIndex;		///< index en abcisse de la pièce dans le tetrix
	int			m_rowIndex;		///< index en ordonnée de la pièce dans le tetrix
	CVector3		m_color	;		///< la couleur de la piece

};

#endif
