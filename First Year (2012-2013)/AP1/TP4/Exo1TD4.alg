algo exo1TD4

var
	const entier taille := 10;

#La fonction
fonction verif (reel note) : booleen
debut
	si ((note >=0) et (note <=20)) alors
		retourne vrai;
	finsi

	si (note == (-1)) alors
		retourne vrai;
	finsi

	retourne faux;
fin


#L'algo principal
principal
var
	tableau_de reel Tab [taille];
	entier i, nbelements := 0;
	reel moyenne := 0;

debut
	#Initialisation du tableau
	pour i:=0 à taille-1
		Tab [i] := 0;
	finpour

	#Saisie du tableau
	i := 0;
	repeter
		repeter
			saisir("Entrez note de rang " + i, @note);
		jusqua (verif Tab[i] == vrai);
		finrepeter
	i := i+1;
	jusqua ((i==taille) ou (Tab [i] == (-1)))
	finrepeter

	#Affichage du tableau
	pour i=0 à nbelements-1
		afficher(Tab [i] + ".'");
		moyenne := moyenne + Tab [i];
		afficher("Moyenne =" + moyenne);
	finpour
fin
