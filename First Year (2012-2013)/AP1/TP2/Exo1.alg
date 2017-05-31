algo exo1TD2

var
	entier N, C, tmp;

principal
debut
	C:=0;
	saisir("Entrez un nombre entier:", @N);
		repeter
			saisir("Entrez un entier:", @tmp);
			si (tmp==N) alors
				C:=C + 1;
			finsi
		jusqua (tmp==N)
		finrepeter
	afficher("Il y a " + C );
	afficher(" fois l'entier " + N );
	afficher(" .");
fin
