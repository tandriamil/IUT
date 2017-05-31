algo Ex1

var
	tableau_de caractere Tab [4];
	entier count ;

principal

debut
	pour count:=0 à 3
		saisir("Entrez une lettre:",@Tab [count]);
	finpour

	pour count:=0 à 3
		afficher(Tab [3-count]);
	finpour

fin
