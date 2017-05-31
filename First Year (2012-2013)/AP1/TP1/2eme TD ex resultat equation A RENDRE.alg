algo racineequation

#Programme fonctionnant, tests faits pour D = 0, D > 0 et D <0 ainsi que pour a = b = 0 et a = 0 et b <> 0

var
	reel D, x1, x2, a, b, c;

principal
debut
	#Ici on entre toutes les valeurs de a, b et c
	saisir("Entrez la valeur de a:", @a);
	saisir("Entrez la valeur de b:", @b);
	saisir("Entrez la valeur de c:", @c);

	#Le cas ou b=0 et a=0
	si (b==0) alors

		tantque (a==0)
			afficher("Entrez une valeur positive de a s'il vous plait.");
			saisir("Entrez la valeur de a:", @a);
		fintantque

	finsi


	#Le cas ou a=0 et b=/=0
	si (a==0) alors

		si (b<>0) alors
			x1 := -c/b;
			afficher("Le resultat est donc " + x1);
		finsi

	finsi


	#Cas des polynomes de degres 2
	si (a<>0) alors

			#Calcul du discriminant
			D := ( b * b ) - ( 4 * a * c );


			#Le cas de D < 0
			si (D < 0) alors

				afficherln("ERROR 404");
				afficherln("Complexes non trouves!");

			finsi


			#Le cas de D = 0
			si (D == 0) alors

				x1 := -b/(2*a);
				afficher("Le resultat est donc " + x1);

			finsi


			#Le cas de D > 0
			si (D > 0) alors

				x1 := (-b+(racine(D)))/2*a;
				x2 := (-b-(racine(D)))/2*a;
				afficher("Les deux resultats sont donc " + x1);
				afficher(" et " + x2);

			finsi

	finsi
fin
