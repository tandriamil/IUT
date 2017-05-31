algo ExoarendreTD4
#L'algorithme fonctionne correctement. Les tests ont bien été faits.

var
	tableau_de entier Tabnotes[10];
	entier i, T;

#Debut du programme principal
principal

debut

	#On remplis d'abord le tableau
	alaligne();
	remplirtab(@Tabnotes);

	#On l'affiche ensuite
	alaligne();
	affichertab(@Tabnotes);

	#Et enfin on y fait les manips et on l'affiche
	alaligne();
	manip(@T);

fin

###############################################
#Affichage du tableau
procedure affichertab (par_ref tableau_de entier Tabnotes)

var
	entier i;

debut

	pour i:=0 à 9
		afficherln("La case numéro " + (i+1) + " a la valeur " + Tabnotes[i] + " .");
	finpour

fin

###############################################
#Remplissage du tableau
procedure remplirtab (par_ref tableau_de entier Tabnotes)

var
	entier i, N;

debut

	pour i:=0 à 9
		saisir("Entrez une note:", @N);
		Tabnotes[i] := N;
	finpour

fin

################################################
#Manipulation des valeurs du tableau

procedure manip (par_ref entier T)

var
	reel moyenne;
	entier count := 0;

debut
	T := 0;

	pour i:=0 à 9
		T := T + Tabnotes[i];
	finpour

	moyenne := T/10;

	pour i:=0 à 9
		si (Tabnotes[i] < moyenne) alors
			count := count+1;
		finsi
	finpour

	alaligne();
	afficherln("La somme des valeurs contenues dans le tableau est: " + T + " .");

	alaligne();
	afficherln("La moyenne est de " + moyenne + " .");

	alaligne();
	afficherln("Il y a " + count + " notes sous la moyenne.");
fin
