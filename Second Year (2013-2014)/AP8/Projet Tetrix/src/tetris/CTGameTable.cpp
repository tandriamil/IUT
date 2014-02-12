#include "CTGameTable.h"

CTGameTable::CTGameTable ( int width, int height ) {

	Case uneCase = Case ( );

	TGameRow uneLgn ( width, uneCase );
	
	m_GameTable = vector<TGameRow>( height, uneLgn );
}

/****************************************/

ostream& operator<< ( ostream& out, const CTGameTable& tab ) {

	unsigned int i,j;

	for ( i=0; i<tab.m_GameTable.size(); i++ ) {

		for ( j=0; j<tab.m_GameTable[i].size(); j++ ) {

			out << tab.m_GameTable[i][j].m_used <<  " ";
		}

		out << endl;
	}

	return out;
}

/****************************************/

vector<TGameRow>& CTGameTable::GetGameTable() {

	return m_GameTable;

}

