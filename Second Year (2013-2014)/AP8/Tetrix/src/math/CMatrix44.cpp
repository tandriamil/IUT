//========================================================================
// Projet C/C++
//
//------------------------------------------------------------------------
// Copyright (c) 2013-2014 Equipe SEASIDE (T. LE NAOUR, J.F KAMP)
// IRISA - UBS  / IUT Informatique Vannes
//========================================================================


#include "CMatrix44.h"
#include <cmath>

CMatrix44 CMatrix44::Identity = CMatrix44();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///
///	
///
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
CMatrix44::CMatrix44(const CVector3& x, const CVector3& y, const CVector3& z)
{
	memcpy(&(m[0][0]), matrix44_ident, sizeof(matrix44_ident));
	m[0][0] = static_cast<float>(x.x);	m[0][1] = static_cast<float>(x.y);	m[0][2]= static_cast<float>(x.z);		m[0][3] = 0.0f;
	m[1][0] = static_cast<float>(y.x);	m[1][1] = static_cast<float>(y.y);	m[1][2]= static_cast<float>(y.z);		m[1][3] = 0.0f;
	m[2][0] = static_cast<float>(z.x);	m[2][1] = static_cast<float>(z.y);	m[2][2] = static_cast<float>(z.z);	m[2][3] = 0.0f;
	m[3][0] = 0.0f;		m[3][1] = 0.0f;		m[3][2] = 0.0f;		m[3][3] = 1.0f;
}



CMatrix44::CMatrix44(float* buff)
{
	memcpy(&(m[0][0]), matrix44_ident, sizeof(matrix44_ident));
	b[0] = buff[0];	b[4] = buff[4];	b[8] = buff[8];		b[12] = buff[12];
	b[1] = buff[1];	b[5] = buff[5];	b[9] = buff[9];		b[13] = buff[13];
	b[2] = buff[2];	b[6] = buff[6];	b[10] = buff[10];	b[14] = buff[14];
	b[3] = buff[3];	b[7] = buff[7];	b[11] = buff[11];	b[15] = buff[15];
}



CMatrix44 CMatrix44::operator*( const CMatrix44 &m ) const 
{
	CMatrix44 mf = CMatrix44( );
	
	mf.b[0] = b[0] * m.b[0] + b[4] * m.b[1] + b[8] * m.b[2] + b[12] * m.b[3];
	mf.b[1] = b[1] * m.b[0] + b[5] * m.b[1] + b[9] * m.b[2] + b[13] * m.b[3];
	mf.b[2] = b[2] * m.b[0] + b[6] * m.b[1] + b[10] * m.b[2] + b[14] * m.b[3];
	mf.b[3] = b[3] * m.b[0] + b[7] * m.b[1] + b[11] * m.b[2] + b[15] * m.b[3];

	mf.b[4] = b[0] * m.b[4] + b[4] * m.b[5] + b[8] * m.b[6] + b[12] * m.b[7];
	mf.b[5] = b[1] * m.b[4] + b[5] * m.b[5] + b[9] * m.b[6] + b[13] * m.b[7];
	mf.b[6] = b[2] * m.b[4] + b[6] * m.b[5] + b[10] * m.b[6] + b[14] * m.b[7];
	mf.b[7] = b[3] * m.b[4] + b[7] * m.b[5] + b[11] * m.b[6] + b[15] * m.b[7];

	mf.b[8] = b[0] * m.b[8] + b[4] * m.b[9] + b[8] * m.b[10] + b[12] * m.b[11];
	mf.b[9] = b[1] * m.b[8] + b[5] * m.b[9] + b[9] * m.b[10] + b[13] * m.b[11];
	mf.b[10] = b[2] * m.b[8] + b[6] * m.b[9] + b[10] * m.b[10] + b[14] * m.b[11];
	mf.b[11] = b[3] * m.b[8] + b[7] * m.b[9] + b[11] * m.b[10] + b[15] * m.b[11];

	mf.b[12] = b[0] * m.b[12] + b[4] * m.b[13] + b[8] * m.b[14] + b[12] * m.b[15];
	mf.b[13] = b[1] * m.b[12] + b[5] * m.b[13] + b[9] * m.b[14] + b[13] * m.b[15];
	mf.b[14] = b[2] * m.b[12] + b[6] * m.b[13] + b[10] * m.b[14] + b[14] * m.b[15];
	mf.b[15] = b[3] * m.b[12] + b[7] * m.b[13] + b[11] * m.b[14] + b[15] * m.b[15];

	return mf;
}


CVector4 CMatrix44::operator*( const CVector4 &v ) const 
{
	return CVector4(
	m[0][0] * v.x + m[1][0] * v.y + m[2][0] * v.z + m[3][0] * v.w,
	m[0][1] * v.x + m[1][1] * v.y + m[2][1] * v.z + m[3][1] * v.w,
	m[0][2] * v.x + m[1][2] * v.y + m[2][2] * v.z + m[3][2] * v.w,
	m[0][3] * v.x + m[1][3] * v.y + m[2][3] * v.z + m[3][3] * v.w);
}

CVector3 CMatrix44::operator*( const CVector3 &v ) const 
{
	return CVector3(
	m[0][0] * v.x + m[1][0] * v.y + m[2][0] * v.z + m[3][0] * 1.0f,
	m[0][1] * v.x + m[1][1] * v.y + m[2][1] * v.z + m[3][1] * 1.0f,
	m[0][2] * v.x + m[1][2] * v.y + m[2][2] * v.z + m[3][2] * 1.0f);
}


//------------------------------------------------------------------------------
//#ifndef N_MATRIXDEFS_H
//#define N_MATRIXDEFS_H
////------------------------------------------------------------------------------
//#define M11 m[0][0]
//#define M12 m[1][0]
//#define M13 m[2][0]
//#define M14 m[3][0]
//#define M21 m[0][1]
//#define M22 m[1][1]
//#define M23 m[2][1]
//#define M24 m[3][1]
//#define M31 m[0][2]
//#define M32 m[1][2]
//#define M33 m[2][2]
//#define M34 m[3][2]
//#define M41 m[0][3]
//#define M42 m[1][3]
//#define M43 m[2][3]
//#define M44 m[3][3]
//
////------------------------------------------------------------------------------
//#endif
//
////------------------------------------------------------------------------------
//
//float CMatrix44::det()
//{
//return
//	(M11 * M22 - M12 * M21) * (M33 * M44 - M34 * M43)
//	-(M11 * M23 - M13 * M21) * (M32 * M44 - M34 * M42)
//	+(M11 * M24 - M14 * M21) * (M32 * M43 - M33 * M42)
//	+(M12 * M23 - M13 * M22) * (M31 * M44 - M34 * M41)
//	-(M12 * M24 - M14 * M22) * (M31 * M43 - M33 * M41)
//	+(M13 * M24 - M14 * M23) * (M31 * M42 - M32 * M41);
//}
//
////------------------------------------------------------------------------------
//
//void CMatrix44::invert()
//{
//	float s = det();
//	if (s == 0.0) return;
//	s = 1/s;
//	
//	M11 = s*(M22*(M33*M44 - M34*M43) + M23*(M34*M42 - M32*M44) + M24*(M32*M43 - M33*M42));
//	M12 = s*(M32*(M13*M44 - M14*M43) + M33*(M14*M42 - M12*M44) + M34*(M12*M43 - M13*M42));
//	M13 = s*(M42*(M13*M24 - M14*M23) + M43*(M14*M22 - M12*M24) + M44*(M12*M23 - M13*M22));
//	M14 = s*(M12*(M24*M33 - M23*M34) + M13*(M22*M34 - M24*M32) + M14*(M23*M32 - M22*M33));
//	M21 = s*(M23*(M31*M44 - M34*M41) + M24*(M33*M41 - M31*M43) + M21*(M34*M43 - M33*M44));
//	M22 = s*(M33*(M11*M44 - M14*M41) + M34*(M13*M41 - M11*M43) + M31*(M14*M43 - M13*M44));
//	M23 = s*(M43*(M11*M24 - M14*M21) + M44*(M13*M21 - M11*M23) + M41*(M14*M23 - M13*M24));
//	M24 = s*(M13*(M24*M31 - M21*M34) + M14*(M21*M33 - M23*M31) + M11*(M23*M34 - M24*M33));
//	M31 = s*(M24*(M31*M42 - M32*M41) + M21*(M32*M44 - M34*M42) + M22*(M34*M41 - M31*M44));
//	M32 = s*(M34*(M11*M42 - M12*M41) + M31*(M12*M44 - M14*M42) + M32*(M14*M41 - M11*M44));
//	M33 = s*(M44*(M11*M22 - M12*M21) + M41*(M12*M24 - M14*M22) + M42*(M14*M21 - M11*M24));
//	M34 = s*(M14*(M22*M31 - M21*M32) + M11*(M24*M32 - M22*M34) + M12*(M21*M34 - M24*M31));
//	M41 = s*(M21*(M33*M42 - M32*M43) + M22*(M31*M43 - M33*M41) + M23*(M32*M41 - M31*M42));
//	M42 = s*(M31*(M13*M42 - M12*M43) + M32*(M11*M43 - M13*M41) + M33*(M12*M41 - M11*M42));
//	M43 = s*(M41*(M13*M22 - M12*M23) + M42*(M11*M23 - M13*M21) + M43*(M12*M21 - M11*M22));
//	M44 = s*(M11*(M22*M33 - M23*M32) + M12*(M23*M31 - M21*M33) + M13*(M21*M32 - M22*M31));
//}

#ifndef N_MATRIXDEFS_H
#define N_MATRIXDEFS_H
//------------------------------------------------------------------------------
#define M00 m[0][0]
#define M01 m[1][0]
#define M02 m[2][0]
#define M03 m[3][0]
#define M10 m[0][1]
#define M11 m[1][1]
#define M12 m[2][1]
#define M13 m[3][1]
#define M20 m[0][2]
#define M21 m[1][2]
#define M22 m[2][2]
#define M23 m[3][2]
#define M30 m[0][3]
#define M31 m[1][3]
#define M32 m[2][3]
#define M33 m[3][3]

//------------------------------------------------------------------------------
#endif

//------------------------------------------------------------------------------

float CMatrix44::det()
{
 float d =	(M00 * M11 - M01 * M10) * (M22 * M33 - M23 * M32) -
			(M00 * M12 - M02 * M10) * (M21 * M33 - M23 * M31) +
			(M00 * M13 - M03 * M10) * (M21 * M32 - M22 * M31) +
			(M01 * M12 - M02 * M11) * (M20 * M33 - M23 * M30) -
			(M01 * M13 - M03 * M11) * (M20 * M32 - M22 * M30) +
			(M02 * M13 - M03 * M12) * (M20 * M31 - M21 * M30);

 return d;
}

//------------------------------------------------------------------------------

void CMatrix44::transpose()
{
	 #define swap(x,y) { float t=x; x=y; y=t; }
     swap(M01, M10);
     swap(M02, M20);
     swap(M03, M30);
     swap(M12, M21);
     swap(M13, M31);
     swap(M23, M32);
}

//------------------------------------------------------------------------------
void CMatrix44::invert()
{
	float d = det();
	if (d == 0.0) return;
	d = 1/d;
	

	CMatrix44 temp = *this;

	M00 = d *(temp(1,1) * (temp(2,2) * temp(3,3) - temp(2,3) * temp(3,2)) +
			  temp(1,2) * (temp(2,3) * temp(3,1) - temp(2,1) * temp(3,3)) +
			  temp(1,3) * (temp(2,1) * temp(3,2) - temp(2,2) * temp(3,1)));

	M01 = d *(temp(2,1) * (temp(0,2) * temp(3,3) - temp(0,3) * temp(3,2)) +
	          temp(2,2) * (temp(0,3) * temp(3,1) - temp(0,1) * temp(3,3)) +
		      temp(2,3) * (temp(0,1) * temp(3,2) - temp(0,2) * temp(3,1)));

	M02 = d *(temp(3,1) * (temp(0,2) * temp(1,3) - temp(0,3) * temp(1,2)) +
              temp(3,2) * (temp(0,3) * temp(1,1) - temp(0,1) * temp(1,3)) +
              temp(3,3) * (temp(0,1) * temp(1,2) - temp(0,2) * temp(1,1)));
                 
	M03 = d *(temp(0,1) * (temp(1,3) * temp(2,2) - temp(1,2) * temp(2,3)) +
			  temp(0,2) * (temp(1,1) * temp(2,3) - temp(1,3) * temp(2,1)) +
			  temp(0,3) * (temp(1,2) * temp(2,1) - temp(1,1) * temp(2,2)));

	M10 = d *(temp(1,2) * (temp(2,0) * temp(3,3) - temp(2,3) * temp(3,0)) +
			  temp(1,3) * (temp(2,2) * temp(3,0) - temp(2,0) * temp(3,2)) +
			  temp(1,0) * (temp(2,3) * temp(3,2) - temp(2,2) * temp(3,3)));
                
	M11 = d * (temp(2,2) * (temp(0,0) * temp(3,3) - temp(0,3) * temp(3,0)) +
               temp(2,3) * (temp(0,2) * temp(3,0) - temp(0,0) * temp(3,2)) +
               temp(2,0) * (temp(0,3) * temp(3,2) - temp(0,2) * temp(3,3)));
                
	M12 = d * (temp(3,2) * (temp(0,0) * temp(1,3) - temp(0,3) * temp(1,0)) +
               temp(3,3) * (temp(0,2) * temp(1,0) - temp(0,0) * temp(1,2)) +
               temp(3,0) * (temp(0,3) * temp(1,2) - temp(0,2) * temp(1,3)));
                
	M13 = d * (temp(0,2) * (temp(1,3) * temp(2,0) - temp(1,0) * temp(2,3)) +
               temp(0,3) * (temp(1,0) * temp(2,2) - temp(1,2) * temp(2,0)) +
               temp(0,0) * (temp(1,2) * temp(2,3) - temp(1,3) * temp(2,2)));
               
	M20= d * (temp(1,3) * (temp(2,0) * temp(3,1) - temp(2,1) * temp(3,0)) +
              temp(1,0) * (temp(2,1) * temp(3,3) - temp(2,3) * temp(3,1)) +
              temp(1,1) * (temp(2,3) * temp(3,0) - temp(2,0) * temp(3,3)));
               
	M21 = d * (temp(2,3) * (temp(0,0) * temp(3,1) - temp(0,1) * temp(3,0)) +
               temp(2,0) * (temp(0,1) * temp(3,3) - temp(0,3) * temp(3,1)) +
               temp(2,1) * (temp(0,3) * temp(3,0) - temp(0,0) * temp(3,3)));
                
	M22 = d * (temp(3,3) * (temp(0,0) * temp(1,1) - temp(0,1) * temp(1,0)) +
               temp(3,0) * (temp(0,1) * temp(1,3) - temp(0,3) * temp(1,1)) +
               temp(3,1) * (temp(0,3) * temp(1,0) - temp(0,0) * temp(1,3)));
               
	M23 = d * (temp(0,3) * (temp(1,1) * temp(2,0) - temp(1,0) * temp(2,1)) +
               temp(0,0) * (temp(1,3) * temp(2,1) - temp(1,1) * temp(2,3)) +
               temp(0,1) * (temp(1,0) * temp(2,3) - temp(1,3) * temp(2,0)));
               
	M30 = d * (temp(1,0) * (temp(2,2) * temp(3,1) - temp(2,1) * temp(3,2)) +
               temp(1,1) * (temp(2,0) * temp(3,2) - temp(2,2) * temp(3,0)) +
               temp(1,2) * (temp(2,1) * temp(3,0) - temp(2,0) * temp(3,1)));
                
	M31 = d * (temp(2,0) * (temp(0,2) * temp(3,1) - temp(0,1) * temp(3,2)) +
               temp(2,1) * (temp(0,0) * temp(3,2) - temp(0,2) * temp(3,0)) +
               temp(2,2) * (temp(0,1) * temp(3,0) - temp(0,0) * temp(3,1)));
                
	M32 = d * (temp(3,0) * (temp(0,2) * temp(1,1) - temp(0,1) * temp(1,2)) +
               temp(3,1) * (temp(0,0) * temp(1,2) - temp(0,2) * temp(1,0)) +
               temp(3,2) * (temp(0,1) * temp(1,0) - temp(0,0) * temp(1,1)));
               
	M33 = d * (temp(0,0) * (temp(1,1) * temp(2,2) - temp(1,2) * temp(2,1)) +
               temp(0,1) * (temp(1,2) * temp(2,0) - temp(1,0) * temp(2,2)) +
               temp(0,2) * (temp(1,0) * temp(2,1) - temp(1,1) * temp(2,0)));

}



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void CMatrix44::Perspective( float fovy, float aspect, float zNear, float zFar )
{
	//float f( 1.0f / std::tan( (fovy / 2)* 3.1415f / 180.f )  );
	//float coeff(zNear - zFar);
		
	//m[0][0] = f/aspect;		m[0][1] = 0.0f;		m[0][2] = 0.0f;					m[0][3] = 0.0f;
	//m[1][0] = 0.0f;			m[1][1] = f	  ;		m[1][2] = 0.0f;					m[1][3] = 0.0f;
	//m[2][0] = 0.0f;			m[2][1] = 0.0f;		m[2][2] = (zNear+zFar)/coeff;	m[2][3] = perspective * (zNear*zFar)/coeff;
	//m[3][0] = 0.0f;			m[3][1] = 0.0f;		m[3][2] = -1.0f;				m[3][3] = 0.0f;

	float range = std::tan( (fovy / 2)* 3.1415f / 180.f ) * zNear;	
	float left = -range * aspect;
	float right = range * aspect;
	float bottom = -range;
	float top = range;

	m[0][0] = (float(2) * zNear) / (right - left);
	m[1][1] = (float(2) * zNear) / (top - bottom);
	m[2][2] = - (zFar + zNear) / (zFar - zNear);
	m[2][3] = - float(1);
	m[3][2] = - (float(2) * zFar * zNear) / (zFar - zNear);
}
CMatrix44 CMatrix44::CreatePerspective( float fovy, float aspect, float zNear, float zFar )
{
	CMatrix44 mat;
	mat.Perspective(fovy, aspect, zNear, zFar);
	return mat;
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void CMatrix44::LookAt( const CVector3& eye, const CVector3& center, const CVector3& up )
{
	CVector3 F(center-eye);
	CVector3 f(F/F.Length());
	CVector3 UP(up/up.Length());
	
	CVector3 s( Cross(f,UP) );
	CVector3 u( Cross(s,f) );

	s.Normalize();
	u.Normalize();

	m[0][0] = static_cast<float>(s.x);		m[1][0] = static_cast<float>(s.y);	m[2][0] = static_cast<float>(s.z);	m[3][0] = 0.0f;
	m[0][1] = static_cast<float>(u.x);		m[1][1] = static_cast<float>(u.y)	;	m[2][1] = static_cast<float>(u.z);	m[3][1] = 0.0f;
	m[0][2] = static_cast<float>(-f.x);		m[1][2] = static_cast<float>(-f.y);	m[2][2] = static_cast<float>(-f.z);	m[3][2] = 0.0f;
	m[0][3] = 0.0f;			m[1][3] = 0.0f;		m[2][3] = 0.0f;		m[3][3] = 1.0f;

	CMatrix44 tr;
	CVector3 tmp = -eye;
	tr.SetTranslation(tmp);
	*this = *this * tr;
}

CMatrix44 CMatrix44::CreateLookAt( const CVector3& eye, const CVector3& center, const CVector3& up )
{
	CMatrix44 mat;
	mat.LookAt(eye,center,up);
	return mat;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void CMatrix44::Orthographic( float left, float right, float bottom, float top, float nearVal, float farVal )
{
	float cx	(right-left)				;
	float cy	(top-bottom)				;
	float cz	(farVal-nearVal)			;

	float tx	( -(right+left)/cx )		;
	float ty	( -(top+bottom)/cy )		;
	float tz	( -(nearVal+farVal)/cz )	;
	
	m[0][0] = 2.0f/cx;		m[1][0] = 0.0f;		m[2][0] = 0.0f;		m[3][0] = tx;
	m[0][1] = 0.0f;			m[1][1] = 2.0f/cy;	m[2][1] = 0.0f;		m[3][1] = ty;
	m[0][2] = 0.0f;			m[1][2] = 0.0f;		m[2][2] = -2.0f/cz;	m[3][2] = tz;
	m[0][3] = 0.0f;			m[1][3] = 0.0f;		m[2][3] = 0.0f;		m[3][3] = 1.0f;
}

CMatrix44 CMatrix44::CreateOrthographic( float left, float right, float bottom, float top, float nearVal, float farVal )
{
	CMatrix44 mat;
	mat.Orthographic( left, right, bottom, top, nearVal, farVal );
	return mat;
}

 
CVector3 CMatrix44::GetScale()
{
	float d		(det());
	float sign	(d / std::abs(d)); 
	return CVector3(	-sign * (m[0][0] / std::abs(m[0][0])) * std::sqrt( m[0][0]*m[0][0] + m[1][0]*m[1][0] + m[2][0]*m[2][0] ),
						-sign * (m[1][1] / std::abs(m[1][1])) * std::sqrt( m[0][1]*m[0][1] + m[1][1]*m[1][1] + m[2][1]*m[2][1] ),
						-sign * (m[2][2] / std::abs(m[2][2])) * std::sqrt( m[0][2]*m[0][2] + m[1][2]*m[1][2] + m[2][2]*m[2][2] ) );
}
