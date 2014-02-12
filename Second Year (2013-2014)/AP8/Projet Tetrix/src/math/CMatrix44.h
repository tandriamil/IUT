//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================


#ifndef ___MATRIX44_H__
#define ___MATRIX44_H__

// fichier a merger avec la lib math une fois la fusion des lib faite
#include "CVector3.h"
#include "CVector4.h"
#include <cstring>

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Col-major !!!!! ATTENTION: l'inverse de la notation mathématique
// J'ai choisi en col-major car c'est le type de matrice  que prend en entrée OPENGL par défaut ...
//
//	| 1 2 3 |
//	| 4 5 6	|	=> 1 4 2 5 3 6
//
//	b[0] = m[0][0]		b[4] = m[1][0]		b[8]  = m[2][0]		b[12] = m[3][0]	
//	b[1] = m[0][1]		b[5] = m[1][1]		b[9]  = m[2][1]		b[13] = m[3][1]	
//	b[2] = m[0][2]		b[6] = m[1][2]		b[10] = m[2][2]		b[14] = m[3][2]	
//	b[3] = m[0][3]		b[7] = m[1][3]		b[11] = m[2][3]		b[15] = m[3][3]	
//
//
//	notation mathématique
//	a00 a01	a02	a03	
//	a10 a11	a12	a13	
//	a20 a21	a22	a23	
//	a30 a31	a32	a33	
//
//
//	notation col-major
//	a00 a10	a20	a30	
//	a01 a11	a21	a31	
//	a02 a12	a22	a32	
//	a03 a13	a23	a33	
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////
static float matrix44_ident[16] =
{
 1.0f, 0.0f, 0.0f, 0.0f,
 0.0f, 1.0f, 0.0f, 0.0f,
 0.0f, 0.0f, 1.0f, 0.0f,
 0.0f, 0.0f, 0.0f, 1.0f
};


/*! \brief [SmrCoreMath] define float 4*4 Matrix */
class CMatrix44
{
public:
	/*!	\brief union matrix = 4 colomn * 4 lines or a 16 value buffer */
	union
	{
		float m[4][4];
		float b[16];
	};

	//====================================================
	// CONSTRUCTORS
	//====================================================
	/*!
		\brief default constructor, init matrix to identity
	*/
	CMatrix44()
	{
		memcpy(&(m[0][0]), matrix44_ident, sizeof(matrix44_ident));
	}

	/*!
		\brief constructor, init matrix with a buffer of values
		\param buffer of values
	*/
	CMatrix44(float* buff);

	/*!
		\brief constructor, init matrix with 3 axes
		\param axis 1
		\param axis 2
		\param axis 3
	*/
	CMatrix44(const CVector3& x, const CVector3& y, const CVector3& z);


	//====================================================
	// METHODS
	//====================================================
	/*!
		\brief set translation
		\param translation
	*/
	void SetTranslation(const CVector3& vec);
	void SetTranslation(const CVector4& vec);

	/*!
		\brief Add translation
		\param translation
	*/
	void Translate(const CVector3& vec);
	void Translate(const CVector4& vec);

	/*!
		\brief get translation
		\return translation
	*/
	CVector3 GetTranslation() const;

	/*!
		\brief get scale
		\return scale
	*/
	CVector3 GetScale();

	/*!
		\brief get axis x,y,z
		\return axis
	*/
	CVector3 GetXAxis()
	{
		return CVector3(m[0][0], m[0][1], m[0][2]);
	}
	CVector3 GetYAxis()
	{
		return CVector3(m[1][0], m[1][1], m[1][2]);
	}
	CVector3 GetZAxis()
	{
		return CVector3(m[2][0], m[2][1], m[2][2]);
	}

	/*!
		\brief operator to get a value into matrix
		\return translation
	*/
	const	float& operator()	(unsigned int row, unsigned int col)	const;
			float& operator()	(unsigned int row, unsigned int col);

	/*!
		\brief get determinant of matrix
		\return float of determinant
	*/
	float det();

	/*!
		\brief invert the matrix
	*/
	void invert();

	/*!
		\brief invert the matrix
	*/
	void transpose();

	/*!
		\brief operator to multiply current matrix with other matrix
		\return result matrinx
	*/
	CMatrix44 operator*( const CMatrix44 &m ) const ;

	/*!
		\brief operator to multiply current matrix with other matrix
		\return result matrinx
	*/
	CVector4 operator*( const CVector4 &v ) const ;

	/*!
		\brief operator to multiply current matrix with other matrix
		\return result matrinx
	*/
	CVector3 operator*( const CVector3 &v ) const ;


	/*!
		\brief specifies a viewing frustum into the world coordinate system (http://www.opengl.org/sdk/docs/man/xhtml/gluPerspective.xml)
		\param Specifies the field of view angle, in degrees, in the y direction.
		\param Specifies the aspect ratio that determines
                    the field of view in the x direction.
                    The aspect ratio is the ratio of x (width) to y (height)
		\param Specifies the distance from the viewer to the near clipping plane
                    (always positive)
		\param Specifies the distance from the viewer to the far clipping plane
                    (always positive)
	*/
	void Perspective( float fovy, float aspect, float zNear, float zFar);
	static CMatrix44 CreatePerspective( float fovy, float aspect, float zNear, float zFar);

	/*!
		\brief creates a viewing matrix derived from an eye point (http://www.opengl.org/sdk/docs/man/xhtml/gluLookAt.xml)
		\param Specifies the position of the eye point.
		\param Specifies the position of the reference point
		\param Specifies the direction of the up vector
	*/
	void LookAt( const CVector3& eye, const CVector3& center, const CVector3& up );
	static CMatrix44 CreateLookAt( const CVector3& eye, const CVector3& center, const CVector3& up );

	/*!
		\brief creates a Orthographic (http://www.opengl.org/sdk/docs/man/xhtml/glOrtho.xml)
		\param Specify the coordinates for the left and right vertical clipping planes
		\param Specify the coordinates for the bottom and top horizontal clipping planes.
		\param Specify the distances to the nearer and farther depth clipping planes.
                    These values are negative if the plane is to be behind the viewer
	*/
	void Orthographic( float left, float right, float bottom, float top, float nearVal, float farVal );
	static CMatrix44 CreateOrthographic( float left, float right, float bottom, float top, float nearVal, float farVal );


	bool operator == (const CMatrix44& t) const
	{
		unsigned int i;
		for(i=0;i<16;i++)
			if(t.b[i] != b[i])
				return false;
		return true;
	}

	bool operator != (const CMatrix44& t) const
	{
		return !(*this == t);
	}

	static CMatrix44	Identity	;	///< identity transformation
};






inline
std::ostream& operator<< (std::ostream& stream, const CMatrix44& mat)
{
	//std::string mat = 
	//b[0] + " " + b[4] + " " + b[8] + " " + b[12] + " \n" + 
	//b[1] + " " + b[5] + " " + b[9] + " " + b[13] + " \n" + 
	//b[2] + " " + b[6] + " " + b[10] + " " + b[14] + " \n" + 
	//b[3] + " " + b[7] + " " + b[11] + " " + b[15] + " \n\n" ;
	//LOG( mat );
	// FIXME CA DEVRAIT ETRE L inverse
	//stream << mat.b[0] << " " << mat.b[1] << " " << mat.b[2] << " " << mat.b[3] << std::endl;
	//stream << mat.b[4] << " " << mat.b[5] << " " << mat.b[6] << " " << mat.b[7] << std::endl;
	//stream << mat.b[8] << " " << mat.b[9] << " " << mat.b[10] << " " << mat.b[11] << std::endl;
	//stream << mat.b[12] << " " << mat.b[13] << " " << mat.b[14] << " " << mat.b[15] << std::endl << std::endl;;
	//stream << mat.b[0] << " " << mat.b[4] << " " << mat.b[8] << " " << mat.b[12] << std::endl;
	//stream << mat.b[1] << " " << mat.b[5] << " " << mat.b[9] << " " << mat.b[13] << std::endl;
	//stream << mat.b[2] << " " << mat.b[6] << " " << mat.b[10] << " " << mat.b[14] << std::endl;
	//stream << mat.b[3] << " " << mat.b[7] << " " << mat.b[11] << " " << mat.b[15] << std::endl << std::endl;

	stream << mat.m[0][0] << " " << mat.m[1][0] << " " << mat.m[2][0] << " " << mat.m[3][0] << std::endl;
	stream << mat.m[0][1] << " " << mat.m[1][1] << " " << mat.m[2][1] << " " << mat.m[3][1] << std::endl;
	stream << mat.m[0][2] << " " << mat.m[1][2] << " " << mat.m[2][2] << " " << mat.m[3][2] << std::endl;
	stream << mat.m[0][3] << " " << mat.m[1][3] << " " << mat.m[2][3] << " " << mat.m[3][3] << std::endl << std::endl;

	return stream;
}


inline 
void CMatrix44::SetTranslation(const CVector3& vec)
{
	b[12] = (float)vec.x;
	b[13] = (float)vec.y;
	b[14] = (float)vec.z;
}
inline
void CMatrix44::SetTranslation(const CVector4& vec)
{
	b[12] = (float)vec.x;
	b[13] = (float)vec.y;
	b[14] = (float)vec.z;
}

inline 
void CMatrix44::Translate(const CVector3& vec)
{
	b[12] += (float)vec.x;
	b[13] += (float)vec.y;
	b[14] += (float)vec.z;
}
inline
void CMatrix44::Translate(const CVector4& vec)
{
	b[12] += (float)vec.x;
	b[13] += (float)vec.y;
	b[14] += (float)vec.z;
}

inline 
CVector3 CMatrix44::GetTranslation() const
{
	return CVector3(b[12],b[13],b[14]);
}



inline 
const float& CMatrix44::operator()	(unsigned int row, unsigned int col)	const
{
	return	m[col][row];
}

inline 
float& CMatrix44::operator()	(unsigned int row, unsigned int col)
{
	return	m[col][row];
}

#endif // __MATRIX44_H__
