//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================


#ifndef _Math_Vector4_H
#define _Math_Vector4_H
#include <limits>
#include <iostream>
#include "CVector3.h"


class CVector4
{
public :

    //----------------------------------------------------------
    // Constructeur par défaut
    //----------------------------------------------------------
    CVector4(float X = 0, float Y = 0, float Z = 0, float W = 0);
	CVector4(const CVector3& vec, float W = 0);

    //----------------------------------------------------------
    // Réinitialise le vecteur
    //----------------------------------------------------------
    void Set(float X, float Y, float Z, float W);

    //----------------------------------------------------------
    // Renvoie la norme du vecteur
    //----------------------------------------------------------
    float Length() const;

    //----------------------------------------------------------
    // Renvoie la norme au carré du vecteur
    //----------------------------------------------------------
    float LengthSq() const;

    //----------------------------------------------------------
    // Normalise le vecteur
    //----------------------------------------------------------
    void Normalize();

    //----------------------------------------------------------
    // Opérateurs unaires + et -
    //----------------------------------------------------------
    CVector4 operator +() const;
    CVector4 operator -() const;

    //----------------------------------------------------------
    // Opérateurs binaires + et -
    //----------------------------------------------------------
    CVector4 operator +(const CVector4& v) const;
    CVector4 operator -(const CVector4& v) const;

    //----------------------------------------------------------
    // Opérateurs += et -=
    //----------------------------------------------------------
    const CVector4& operator +=(const CVector4& v);
    const CVector4& operator -=(const CVector4& v);

    //----------------------------------------------------------
    // Opérateurs *= et /=
    //----------------------------------------------------------
    const CVector4& operator *=(float t);
    const CVector4& operator /=(float t);

    //----------------------------------------------------------
    // Opérateurs de comparaison
    //----------------------------------------------------------
    bool operator ==(const CVector4& v) const;
    bool operator !=(const CVector4& v) const;


    //----------------------------------------------------------
    // Données membres
    //----------------------------------------------------------
    float x; ///< Composante X
    float y; ///< Composante Y
    float z; ///< Composante Z
	float w; ///< Composante W
};


//==========================================================
// Fonctions globales relatives aux vecteurs
//==========================================================
 CVector4   operator * (const CVector4& v, float t);
 CVector4   operator / (const CVector4& v, float t);
 CVector4   operator * (float t, const CVector4& v);
 std::istream& operator >>(std::istream& Stream, CVector4& Vector);
 std::ostream& operator <<(std::ostream& Stream, const CVector4& Vector);


 /////////////////////////////////////////////////////////////
/// Constructeur par défaut
///
/// \param X : Composante X du vecteur
/// \param Y : Composante Y du vecteur
/// \param Z : Composante Z du vecteur
///
////////////////////////////////////////////////////////////
inline CVector4::CVector4(float X, float Y, float Z, float W) : x(X),y(Y),z(Z), w(W)
{
}
inline CVector4::CVector4(const CVector3& vec, float W) : x(vec.x),y(vec.y),z(vec.z), w(W)
{
}


/////////////////////////////////////////////////////////////
/// Réinitialise le vecteur
///
/// \param X : Composante X du vecteur
/// \param Y : Composante Y du vecteur
/// \param Z : Composante Z du vecteur
///
////////////////////////////////////////////////////////////
inline void CVector4::Set(float X, float Y, float Z, float W)
{
    x = X;
    y = Y;
    z = Z;
	w = W;
}


/////////////////////////////////////////////////////////////
/// Renvoie la norme du vecteur
///
/// \return Valeur de la norme du vecteur sqrt(x² + y² + z²)
///
////////////////////////////////////////////////////////////
inline float CVector4::Length() const
{
    return std::sqrt(LengthSq());
}


/////////////////////////////////////////////////////////////
/// Renvoie la norme au carré du vecteur
///
/// \return Carré de la norme du vecteur (x² + y² + z²)
///
////////////////////////////////////////////////////////////
inline float CVector4::LengthSq() const
{
    return x * x + y * y + z * z + w*w;
}


/////////////////////////////////////////////////////////////
/// Normalise le vecteur
///
////////////////////////////////////////////////////////////
inline void CVector4::Normalize()
{
    float Norm = Length();

    if (std::abs(Norm) > std::numeric_limits<float>::epsilon())
    {
        x /= Norm;
        y /= Norm;
        z /= Norm;
		w /= Norm;
    }
}


/////////////////////////////////////////////////////////////
/// Opérateur unaire +
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////
inline CVector4 CVector4::operator +() const
{
    return (*this);
}


/////////////////////////////////////////////////////////////
/// Opérateur unaire -
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////

inline CVector4 CVector4::operator -() const
{
    return CVector4(-x, -y, -z, -w);
}


/////////////////////////////////////////////////////////////
/// Opérateur binaire +
///
/// \param v : Vecteur à additionner
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////

inline CVector4 CVector4::operator +(const CVector4& v) const
{
    return CVector4(x + v.x, y + v.y, z + v.z, w + v.w);
}


/////////////////////////////////////////////////////////////
/// Opérateur binaire -
///
/// \param v : Vecteur à soustraire
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////

inline CVector4 CVector4::operator -(const CVector4& v) const
{
    return CVector4(x - v.x, y - v.y, z - v.z, w - v.w);
}

/////////////////////////////////////////////////////////////
/// Opérateur +=
///
/// \param v : Vecteur à additioner
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////
inline const CVector4& CVector4::operator +=(const CVector4& v)
{
    x += v.x;
    y += v.y;
    z += v.z;
	w += v.w;

    return *this;
}


/////////////////////////////////////////////////////////////
/// Opérateur -=
///
/// \param v : Vecteur à soustraire
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////
inline const CVector4& CVector4::operator -=(const CVector4& v)
{
    x -= v.x;
    y -= v.y;
    z -= v.z;
	w -= v.w;

    return *this;
}


/////////////////////////////////////////////////////////////
/// Opérateur *= avec un scalaire
///
/// \param t : Scalaire
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////
inline const CVector4& CVector4::operator *=(float t)
{
    x *= t;
    y *= t;
    z *= t;
    w *= t;

    return *this;
}


/////////////////////////////////////////////////////////////
/// Opérateur /= avec un scalaire
///
/// \param t : Scalaire
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////
inline const CVector4& CVector4::operator /=(float t)
{
    x /= t;
    y /= t;
    z /= t;
    w /= t;

    return *this;
}


/////////////////////////////////////////////////////////////
/// Opérateur de comparaison ==
///
/// \param v : Vecteur à comparer
///
/// \return True si les deux vecteurs sont identiques
///
////////////////////////////////////////////////////////////
inline bool CVector4::operator ==(const CVector4& v) const
{
     return ((std::abs(x - v.x) <= std::numeric_limits<float>::epsilon()) &&
            (std::abs(y - v.y) <= std::numeric_limits<float>::epsilon()) &&
            (std::abs(z - v.z) <= std::numeric_limits<float>::epsilon()) &&
            (std::abs(w - v.w) <= std::numeric_limits<float>::epsilon()));
}


/////////////////////////////////////////////////////////////
/// Opérateur de comparaison !=
///
/// \param v : Vecteur à comparer
///
/// \return True si les deux vecteurs sont différents
///
////////////////////////////////////////////////////////////
inline bool CVector4::operator !=(const CVector4& v) const
{
    return !(*this == v);
}



/////////////////////////////////////////////////////////////
/// Opérateurs de multiplication avec un scalaire
///
/// \param v : Vecteur
/// \param t : Scalaire
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////
inline CVector4 operator *(const CVector4& v, float t)
{
    return CVector4(v.x * t, v.y * t, v.z * t, v.w * t);
}


/////////////////////////////////////////////////////////////
/// Opérateurs de division par un scalaire
///
/// \param v : Vecteur
/// \param t : Scalaire
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////
inline CVector4 operator /(const CVector4& v, float t)
{
    return CVector4(v.x / t, v.y / t, v.z / t, v.w / t);
}


/////////////////////////////////////////////////////////////
/// Opérateurs de multiplication avec un scalaire
///
/// \param t : Scalaire
/// \param v : Vecteur
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////
inline CVector4 operator *(float t, const CVector4& v)
{
    return v * t;
}

/////////////////////////////////////////////////////////////
/// Surcharge de l'opérateur >> entre un flux et un vecteur
///
/// \param Stream : Flux d'entrée
/// \param Vector : Vecteur
///
/// \return Référence sur le flux d'entrée
///
////////////////////////////////////////////////////////////

inline std::istream& operator >>(std::istream& Stream, CVector4& Vector)
{
    return Stream >> Vector.x >> Vector.y >> Vector.z >> Vector.w;
}


/////////////////////////////////////////////////////////////
/// Surcharge de l'opérateur << entre un flux et un vecteur
///
/// \param Stream : Flux de sortie
/// \param Vector : Vecteur
///
/// \return Référence sur le flux de sortie
///
////////////////////////////////////////////////////////////

inline std::ostream& operator <<(std::ostream& Stream, const CVector4& Vector)
{
    return Stream << Vector.x << " " << Vector.y << " " << Vector.z << " " << Vector.w;
}


#endif
