algo exoarendreTD2
#Aucun problemes, tout les tests ont ete faits, les valeurs nulles de A et B egalement.

var
	reel A, B, PGCD;
	
principal
debut
	#Saisie des valeurs
	saisir("Entrez une valeur de A:", @A);
	saisir("Entrez une valeur de B:", @B);
	PGCD := 0;
	
	
	#Verification de A ou B egal a 0
	si ((A == 0) ou (B == 0)) alors
		afficher("Il n'y a pas de solution.");
	finsi
	
	

	#Calcul
	tantque (A <> B)
	
		tantque (A>B)
			A := A - B;
		fintantque
	
		tantque (A<B)
			B := B-A;
		fintantque
	
	fintantque
	
	
	
	#Cas de A = B
	si (A == B) alors
		PGCD := A;
	finsi
	
		
	#Afficher le resultat et final
	si (A<>0) alors
		si (B<>0) alors
			afficher("Le PGCD est donc " + PGCD);
			afficher(".");
		finsi
	finsi
fin