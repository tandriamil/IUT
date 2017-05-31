algo exo4TD2

var
	entier n, tmp1, tmp2, C;

principal
debut
	C := 0;
	n := 1;

	tantque (n <> 0)

		saisir("Entrez une valeur:", @n);
		tmp1 := n;
		saisir("Enrez une valeur:", @n);
		tmp2 := n;

		si (tmp1 == tmp2) alors
			C := C+1;
		finsi

		si (tmp1 == ((-1) * tmp2)) alors
			C := C+1;
		finsi

	fintantque

	afficher("Il y a " + C);
	afficher(" entiers successifs symetriques par rapport a 0.");

fin
