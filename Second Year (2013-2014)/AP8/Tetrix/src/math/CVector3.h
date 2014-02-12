//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================


#ifndef _Math_Vector3_H
#define _Math_Vector3_H
#include <limits>
#include <iostream>
#include <cmath>


class CVector3
{
public :

    //----------------------------------------------------------
    // Constructeur par défaut
    //----------------------------------------------------------
    CVector3(float X = 0, float Y = 0, float Z = 0);

    //----------------------------------------------------------
    // Réinitialise le vecteur
    //----------------------------------------------------------
    void Set(float X, float Y, float Z);

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
    CVector3 operator +() const;
    CVector3 operator -() const;

    //----------------------------------------------------------
    // Opérateurs binaires + et -
    //----------------------------------------------------------
    CVector3 operator +(const CVector3& v) const;
    CVector3 operator -(const CVector3& v) const;

    //----------------------------------------------------------
    // Opérateurs += et -=
    //----------------------------------------------------------
    const CVector3& operator +=(const CVector3& v);
    const CVector3& operator -=(const CVector3& v);

    //----------------------------------------------------------
    // Opérateurs *= et /=
    //----------------------------------------------------------
    const CVector3& operator *=(float t);
    const CVector3& operator /=(float t);

    //----------------------------------------------------------
    // Opérateurs de comparaison
    //----------------------------------------------------------
    bool operator ==(const CVector3& v) const;
    bool operator !=(const CVector3& v) const;

    //----------------------------------------------------------
    // Opérateur de cast en float*
    //----------------------------------------------------------
    operator float*();

    //----------------------------------------------------------
    // Données membres
    //----------------------------------------------------------
    float x; ///< Composante X
    float y; ///< Composante Y
    float z; ///< Composante Z
};


//==========================================================
// Fonctions globales relatives aux vecteurs
//==========================================================
 CVector3   operator * (const CVector3& v, float t);
 CVector3   operator / (const CVector3& v, float t);
 CVector3   operator * (float t, const CVector3& v);
 float     Dot  (const CVector3& v1, const CVector3& v2);
 CVector3   Cross(const CVector3& v1, const CVector3& v2);
 std::istream& operator >>(std::istream& Stream, CVector3& Vector);
 std::ostream& operator <<(std::ostream& Stream, const CVector3& Vector);


 /////////////////////////////////////////////////////////////
/// Constructeur par défaut
///
/// \param X : Composante X du vecteur
/// \param Y : Composante Y du vecteur
/// \param Z : Composante Z du vecteur
///
////////////////////////////////////////////////////////////
inline CVector3::CVector3(float X, float Y, float Z) : x(X),y(Y),z(Z)
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
inline void CVector3::Set(float X, float Y, float Z)
{
    x = X;
    y = Y;
    z = Z;
}


/////////////////////////////////////////////////////////////
/// Renvoie la norme du vecteur
///
/// \return Valeur de la norme du vecteur sqrt(x² + y² + z²)
///
////////////////////////////////////////////////////////////
inline float CVector3::Length() const
{
    return std::sqrt(LengthSq());
}


/////////////////////////////////////////////////////////////
/// Renvoie la norme au carré du vecteur
///
/// \return Carré de la norme du vecteur (x² + y² + z²)
///
////////////////////////////////////////////////////////////
inline float CVector3::LengthSq() const
{
    return x * x + y * y + z * z;
}


/////////////////////////////////////////////////////////////
/// Normalise le vecteur
///
////////////////////////////////////////////////////////////
inline void CVector3::Normalize()
{
    float Norm = Length();

    if (std::abs(Norm) > std::numeric_limits<float>::epsilon())
    {
        x /= Norm;
        y /= Norm;
        z /= Norm;
    }
}


/////////////////////////////////////////////////////////////
/// Opérateur unaire +
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////
inline CVector3 CVector3::operator +() const
{
    return (*this);
}


/////////////////////////////////////////////////////////////
/// Opérateur unaire -
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////

inline CVector3 CVector3::operator -() const
{
    return CVector3(-x, -y, -z);
}


/////////////////////////////////////////////////////////////
/// Opérateur binaire +
///
/// \param v : Vecteur à additionner
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////

inline CVector3 CVector3::operator +(const CVector3& v) const
{
    return CVector3(x + v.x, y + v.y, z + v.z);
}


/////////////////////////////////////////////////////////////
/// Opérateur binaire -
///
/// \param v : Vecteur à soustraire
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////

inline CVector3 CVector3::operator -(const CVector3& v) const
{
    return CVector3(x - v.x, y - v.y, z - v.z);
}

/////////////////////////////////////////////////////////////
/// Opérateur +=
///
/// \param v : Vecteur à additioner
///
/// \return Résultat de l'opération
///
////////////////////////////////////////////////////////////
inline const CVector3& CVector3::operator +=(const CVector3& v)
{
    x += v.x;
    y += v.y;
    z += v.z;

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
inline const CVector3& CVector3::operator -=(const CVector3& v)
{
    x -= v.x;
    y -= v.y;
    z -= v.z;

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
inline const CVector3& CVector3::operator *=(float t)
{
    x *= t;
    y *= t;
    z *= t;

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
inline const CVector3& CVector3::operator /=(float t)
{
    x /= t;
    y /= t;
    z /= t;

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
inline bool CVector3::operator ==(const CVector3& v) const
{
    return ((std::abs(x - v.x) <= std::numeric_limits<float>::epsilon()) &&
            (std::abs(y - v.y) <= std::numeric_limits<float>::epsilon()) &&
            (std::abs(z - v.z) <= std::numeric_limits<float>::epsilon()));
}


/////////////////////////////////////////////////////////////
/// Opérateur de comparaison !=
///
/// \param v : Vecteur à comparer
///
/// \return True si les deux vecteurs sont différents
///
////////////////////////////////////////////////////////////
inline bool CVector3::operator !=(const CVector3& v) const
{
    return !(*this == v);
}


/////////////////////////////////////////////////////////////
/// Opérateur de cast en float*
///
/// \return Pointeur sur les composantes du vecteur
///
////////////////////////////////////////////////////////////
inline CVector3::operator float*()
{
    return &x;
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
inline CVector3 operator *(const CVector3& v, float t)
{
    return CVector3(v.x * t, v.y * t, v.z * t);
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
inline CVector3 operator /(const CVector3& v, float t)
{
    return CVector3(v.x / t, v.y / t, v.z / t);
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
inline CVector3 operator *(float t, const CVector3& v)
{
    return v * t;
}


/////////////////////////////////////////////////////////////
/// Effectue le produit scalaire entre deux vecteurs
///
/// \param v1 : Vecteur 1
/// \param v2 : Vecteur 2
///
/// \return Résultat du produit scalaire
///
////////////////////////////////////////////////////////////
inline float Dot(const CVector3& v1, const CVector3& v2)
{
    return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
}


/////////////////////////////////////////////////////////////
/// Effectue le produit vectoriel entre deux vecteurs
///
/// \param v1 : Vecteur 1
/// \param v2 : Vecteur 2
///
/// \return Résultat du produit vectoriel
///
////////////////////////////////////////////////////////////
inline CVector3 Cross(const CVector3& v1, const CVector3& v2)
{
    return CVector3(v1.y * v2.z - v1.z * v2.y, v1.z * v2.x - v1.x * v2.z, v1.x * v2.y - v1.y * v2.x);
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

inline std::istream& operator >>(std::istream& Stream, CVector3& Vector)
{
    return Stream >> Vector.x >> Vector.y >> Vector.z;
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

inline std::ostream& operator <<(std::ostream& Stream, const CVector3& Vector)
{
    return Stream << Vector.x << " " << Vector.y << " " << Vector.z;
}


#endif
