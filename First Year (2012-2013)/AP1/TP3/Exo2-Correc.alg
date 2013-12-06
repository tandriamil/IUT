algo Exo2TD3

var
	tableau_de reel Tab [10];
	entier i, valeur, nbvaleurs :=0;
	
principal
debut
	i := 0;
	nbvaleurs := 0;
	
	repeter
		saisir("Entrez un entier:", @valeur);
			si (valeur <> (-1)) alors
				Tab [i] := valeur;
				nbvaleurs := nbvaleurs + 1;
			finsi
			i := i+1;
	jusqua (((i == 9) ou (valeur == (-1)))
	finrepeter

	alaligne();
	pour i := (nbvaleurs - 1) à 0
		afficher(Tab [i]);

fin