algo Ex5

var
	tableau_de reel Tab [5];
	reel ref;
	entier count:=0 , i;

principal

debut
	saisir("",@ref);
	pour i:=0 à 4
		saisir("",@Tab [i]);
		si(Tab [i]==ref)alors
			count:=count+1;
		finsi
	finpour
	afficher("nombre d'occurence de la reference :"+count);

fin
