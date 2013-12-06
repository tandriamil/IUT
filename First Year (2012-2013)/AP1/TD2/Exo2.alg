 algo exo2TD2

var
	entier min, max, N;
	
principal
debut
	saisir("Entrez un entier:", @N);
	min:=N;
	max:=N;
	tantque (N>0)
		saisir("Entrez un entier:", @N);
		si (N<min) alors
			min:=N;			
		finsi
		si (N>max) alors
			max:=N;
		finsi
	fintantque
	si (min<0) alors
		afficher("La valeur min est " + min);
		afficher(" et la valeur max est " + max);
		afficher(".");
	sinon
		afficher("Il n'y a pas de valeurs dans la liste.");
	finsi
fin