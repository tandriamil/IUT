//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================


//=====================================================================
// fichier common, contient des objets communs à plusieurs classes
//=====================================================================
//-----------------------------------------------------------------
// Ici fichier des déclarations des fonctions. Une fonction ne peut être déclarée qu'une seule fois
// d'ou l'ajout d'une routine qui dit que si votre fichier à déjà été inclu avant pas la peine de le re-inclure
//-----------------------------------------------------------------
#ifndef __COMMON_H__	// routine qui sert à pas inclure 2 fois le même fichier
#define __COMMON_H__	//


// on va mettre tous les fichier .h des lib communes à tous nos fichiers dans ce fichier hitoire de pas
// avoir à les déclarer à chaque fois
#include <string>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <cstring>
#include "CVector3.h"
#include "CVector4.h"
#include "CMatrix44.h"

using namespace std;

////////////////////////////////////////////////////////////////////////
// la structure WindowSetup est utilisée par l'objet interface utilisateur pour récupérer les données et
// exploitée par le renderer (on calcul la matrice de projection en fonction de la taille de la fenêtre)
////////////////////////////////////////////////////////////////////////
struct WindowSetup {

	WindowSetup()
		:m_width(800), m_height(640) {}
	WindowSetup(int width, int height)
		:m_width(width), m_height(height) {}

	void SetSize(int width, int height){m_width = width; m_height = height;}

	int m_width, m_height;
};

////////////////////////////////////////////////////////////////////////
// la structure RendererSetup est utilisée par l'objet renderer
// on pourra par exemple donner le choix à l'utilisateur de certain paramètres de la matrice de projection
// couleur de fond, dessiner ou pas un sol ...
////////////////////////////////////////////////////////////////////////
struct RendererSetup {

	RendererSetup()
		:m_drawGround(true)
	{
		// couleur de fond d'écran par défaut
		m_clearColor[0] = 125.f/256.f	;
		m_clearColor[1] = 125.f/256.f	;
		m_clearColor[2] = 125.f/256.f	;
		m_clearColor[3] = 0.0f			;
	}

	// couleur de fond d'écran
	void SetClearColor(float red, float green, float blue, float alpha)
	{
		m_clearColor[0] = red	;
		m_clearColor[1] = green	;
		m_clearColor[2] = blue	;
		m_clearColor[3] = alpha	;
	}

	bool	m_drawGround	;
	float	m_clearColor[4]	;
};


////////////////////////////////////////////////////////////////////////
// helper to delete pointer contain into vector
//////////////////////////////////////////////////////////////////////////
struct STLDelete {

   template <class T> void operator ()(T*& p) const
   {
	  delete p;
	  p = 0;
   }
};


////////////////////////////////////////////////////////////////////////
/// Structure qui regroupe des petites fonctions utiles
///
//////////////////////////////////////////////////////////////////////////
struct Helpers {

	//----------------------------------------------------------
	// retrouve le nombre de sous chaine de caractère contenu dans la chaine de caractère 'str'
	//----------------------------------------------------------
	static unsigned int FindSubStrCount(const std::string& str, const std::string& subStr)
	{
		unsigned int counter(0),i;
		std::string tempSubString;
		for (i = 0 ; i < str.size() ; i++)
		{
			tempSubString = str.substr( i,subStr.size() );
			if( subStr == tempSubString )
				++counter;
		}
		return counter;
	}

	/*!
		\brief split a string by an other string
		\param the string we want split
		\param the splitter substring
		\return a string vector splited
	*/
	static std::vector<std::string> Split(const std::string & src, const char delim)
	{
		std::vector<std::string> v;
		std::string::const_iterator p = src.begin ();
		std::string::const_iterator q =
		find (p, src.end (), delim);

		while (q != src.end ())
		{
			v.push_back (std::string (p, q));
			p = q;
			q = find (++p, src.end (), delim);
		}
		if (p != src.end ())
			v.push_back (std::string (p, src.end ()));

		return v;
	}

	//----------------------------------------------------------
	// fonction d'aide qui convertit tout en string
	//----------------------------------------------------------
	template<class T>
	static std::string ToString(const T& value)
	{
		std::stringstream ss;
		ss << value;

		return ss.str();
	}
};

////////////////////////////////////////////////////////////////////////
// liste des touches du clavier (les mêmes que pour SDL)
//////////////////////////////////////////////////////////////////////////
typedef enum {

	/* The keyboard syms have been cleverly chosen to map to ASCII */
	Key_UNKNOWN		= 0,
	Key_FIRST		= 0,
	Key_BACKSPACE		= 8,
	Key_TAB		= 9,
	Key_CLEAR		= 12,
	Key_RETURN		= 13,
	Key_PAUSE		= 19,
	Key_ESCAPE		= 27,
	Key_SPACE		= 32,
	Key_EXCLAIM		= 33,
	Key_QUOTEDBL		= 34,
	Key_HASH		= 35,
	Key_DOLLAR		= 36,
	Key_AMPERSAND		= 38,
	Key_QUOTE		= 39,
	Key_LEFTPAREN		= 40,
	Key_RIGHTPAREN		= 41,
	Key_ASTERISK		= 42,
	Key_PLUS		= 43,
	Key_COMMA		= 44,
	Key_MINUS		= 45,
	Key_PERIOD		= 46,
	Key_SLASH		= 47,
	Key_0			= 48,
	Key_1			= 49,
	Key_2			= 50,
	Key_3			= 51,
	Key_4			= 52,
	Key_5			= 53,
	Key_6			= 54,
	Key_7			= 55,
	Key_8			= 56,
	Key_9			= 57,
	Key_COLON		= 58,
	Key_SEMICOLON		= 59,
	Key_LESS		= 60,
	Key_EQUALS		= 61,
	Key_GREATER		= 62,
	Key_QUESTION		= 63,
	Key_AT			= 64,
	/*
	   Skip uppercase letters
	 */
	Key_LEFTBRACKET	= 91,
	Key_BACKSLASH		= 92,
	Key_RIGHTBRACKET	= 93,
	Key_CARET		= 94,
	Key_UNDERSCORE		= 95,
	Key_BACKQUOTE		= 96,
	Key_a			= 97,
	Key_b			= 98,
	Key_c			= 99,
	Key_d			= 100,
	Key_e			= 101,
	Key_f			= 102,
	Key_g			= 103,
	Key_h			= 104,
	Key_i			= 105,
	Key_j			= 106,
	Key_k			= 107,
	Key_l			= 108,
	Key_m			= 109,
	Key_n			= 110,
	Key_o			= 111,
	Key_p			= 112,
	Key_q			= 113,
	Key_r			= 114,
	Key_s			= 115,
	Key_t			= 116,
	Key_u			= 117,
	Key_v			= 118,
	Key_w			= 119,
	Key_x			= 120,
	Key_y			= 121,
	Key_z			= 122,
	Key_DELETE		= 127,
	/* End of ASCII mapped keysyms */

	/* International keyboard syms */
	Key_WORLD_0		= 160,		/* 0xA0 */
	Key_WORLD_1		= 161,
	Key_WORLD_2		= 162,
	Key_WORLD_3		= 163,
	Key_WORLD_4		= 164,
	Key_WORLD_5		= 165,
	Key_WORLD_6		= 166,
	Key_WORLD_7		= 167,
	Key_WORLD_8		= 168,
	Key_WORLD_9		= 169,
	Key_WORLD_10		= 170,
	Key_WORLD_11		= 171,
	Key_WORLD_12		= 172,
	Key_WORLD_13		= 173,
	Key_WORLD_14		= 174,
	Key_WORLD_15		= 175,
	Key_WORLD_16		= 176,
	Key_WORLD_17		= 177,
	Key_WORLD_18		= 178,
	Key_WORLD_19		= 179,
	Key_WORLD_20		= 180,
	Key_WORLD_21		= 181,
	Key_WORLD_22		= 182,
	Key_WORLD_23		= 183,
	Key_WORLD_24		= 184,
	Key_WORLD_25		= 185,
	Key_WORLD_26		= 186,
	Key_WORLD_27		= 187,
	Key_WORLD_28		= 188,
	Key_WORLD_29		= 189,
	Key_WORLD_30		= 190,
	Key_WORLD_31		= 191,
	Key_WORLD_32		= 192,
	Key_WORLD_33		= 193,
	Key_WORLD_34		= 194,
	Key_WORLD_35		= 195,
	Key_WORLD_36		= 196,
	Key_WORLD_37		= 197,
	Key_WORLD_38		= 198,
	Key_WORLD_39		= 199,
	Key_WORLD_40		= 200,
	Key_WORLD_41		= 201,
	Key_WORLD_42		= 202,
	Key_WORLD_43		= 203,
	Key_WORLD_44		= 204,
	Key_WORLD_45		= 205,
	Key_WORLD_46		= 206,
	Key_WORLD_47		= 207,
	Key_WORLD_48		= 208,
	Key_WORLD_49		= 209,
	Key_WORLD_50		= 210,
	Key_WORLD_51		= 211,
	Key_WORLD_52		= 212,
	Key_WORLD_53		= 213,
	Key_WORLD_54		= 214,
	Key_WORLD_55		= 215,
	Key_WORLD_56		= 216,
	Key_WORLD_57		= 217,
	Key_WORLD_58		= 218,
	Key_WORLD_59		= 219,
	Key_WORLD_60		= 220,
	Key_WORLD_61		= 221,
	Key_WORLD_62		= 222,
	Key_WORLD_63		= 223,
	Key_WORLD_64		= 224,
	Key_WORLD_65		= 225,
	Key_WORLD_66		= 226,
	Key_WORLD_67		= 227,
	Key_WORLD_68		= 228,
	Key_WORLD_69		= 229,
	Key_WORLD_70		= 230,
	Key_WORLD_71		= 231,
	Key_WORLD_72		= 232,
	Key_WORLD_73		= 233,
	Key_WORLD_74		= 234,
	Key_WORLD_75		= 235,
	Key_WORLD_76		= 236,
	Key_WORLD_77		= 237,
	Key_WORLD_78		= 238,
	Key_WORLD_79		= 239,
	Key_WORLD_80		= 240,
	Key_WORLD_81		= 241,
	Key_WORLD_82		= 242,
	Key_WORLD_83		= 243,
	Key_WORLD_84		= 244,
	Key_WORLD_85		= 245,
	Key_WORLD_86		= 246,
	Key_WORLD_87		= 247,
	Key_WORLD_88		= 248,
	Key_WORLD_89		= 249,
	Key_WORLD_90		= 250,
	Key_WORLD_91		= 251,
	Key_WORLD_92		= 252,
	Key_WORLD_93		= 253,
	Key_WORLD_94		= 254,
	Key_WORLD_95		= 255,		/* 0xFF */

	/* Numeric keypad */
	Key_KP0		= 256,
	Key_KP1		= 257,
	Key_KP2		= 258,
	Key_KP3		= 259,
	Key_KP4		= 260,
	Key_KP5		= 261,
	Key_KP6		= 262,
	Key_KP7		= 263,
	Key_KP8		= 264,
	Key_KP9		= 265,
	Key_KP_PERIOD		= 266,
	Key_KP_DIVIDE		= 267,
	Key_KP_MULTIPLY	= 268,
	Key_KP_MINUS		= 269,
	Key_KP_PLUS		= 270,
	Key_KP_ENTER		= 271,
	Key_KP_EQUALS		= 272,

	/* Arrows + Home/End pad */
	Key_UP			= 273,
	Key_DOWN		= 274,
	Key_RIGHT		= 275,
	Key_LEFT		= 276,
	Key_INSERT		= 277,
	Key_HOME		= 278,
	Key_END		= 279,
	Key_PAGEUP		= 280,
	Key_PAGEDOWN		= 281,

	/* Function keys */
	Key_F1			= 282,
	Key_F2			= 283,
	Key_F3			= 284,
	Key_F4			= 285,
	Key_F5			= 286,
	Key_F6			= 287,
	Key_F7			= 288,
	Key_F8			= 289,
	Key_F9			= 290,
	Key_F10		= 291,
	Key_F11		= 292,
	Key_F12		= 293,
	Key_F13		= 294,
	Key_F14		= 295,
	Key_F15		= 296,

	/* Key state modifier keys */
	Key_NUMLOCK		= 300,
	Key_CAPSLOCK		= 301,
	Key_SCROLLOCK		= 302,
	Key_RSHIFT		= 303,
	Key_LSHIFT		= 304,
	Key_RCTRL		= 305,
	Key_LCTRL		= 306,
	Key_RALT		= 307,
	Key_LALT		= 308,
	Key_RMETA		= 309,
	Key_LMETA		= 310,
	Key_LSUPER		= 311,		/* Left "Windows" key */
	Key_RSUPER		= 312,		/* Right "Windows" key */
	Key_MODE		= 313,		/* "Alt Gr" key */
	Key_COMPOSE		= 314,		/* Multi-key compose key */

	/* Miscellaneous function keys */
	Key_HELP		= 315,
	Key_PRINT		= 316,
	Key_SYSREQ		= 317,
	Key_BREAK		= 318,
	Key_MENU		= 319,
	Key_POWER		= 320,		/* Power Macintosh power key */
	Key_EURO		= 321,		/* Some european keyboards */
	Key_UNDO		= 322,		/* Atari keyboard has Undo */

	/* Add any other keys here */

	Key_LAST
} Key;

////////////////////////////////////////////////////////////////////////
// on regroupe les évenements liés à la souris dans une structure
// la structure UserEvents est utilisée par l'objet interface utilisateur pour récupérer les données et
// exploitée par la caméra du renderer (la caméra bouge en fonction de la souris)
////////////////////////////////////////////////////////////////////////
struct UserEvents {

	int mousex,mousey		;
	int mousexrel,mouseyrel	;
	int mousebuttons[6]		;

	UserEvents()
	{
		mousex = mousey = 0;
		mousexrel = mouseyrel = 0;
		mousebuttons[0] = mousebuttons[1] = mousebuttons[2] = mousebuttons[3] = mousebuttons[4] = mousebuttons[5] = 0;

		m_keyBoardEvents.resize(Key_LAST);
	}

	void ClearKeyBardEvents()
	{
		unsigned int i;
		for(i=0;i<m_keyBoardEvents.size(); i++)
			m_keyBoardEvents[i] = false;
	}

	bool IsPressed(Key key)
	{
		return m_keyBoardEvents[static_cast<unsigned int>(key)];
	}

	std::vector<bool>	m_keyBoardEvents;
};

#endif // __COMMON_H__ fin de la routine
