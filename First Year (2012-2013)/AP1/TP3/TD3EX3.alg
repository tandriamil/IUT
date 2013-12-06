algo Ex3

var
	tableau_de entier Tab [4];
	entier count:=0;
	
principal

debut
	saisir("",@Tab [0]);
	repeter
		saisir("",@Tab [1+count]);
		count:=count+1;
	jusqua(count==2)
	finrepeter

	count:=0;
	repeter
		alaligne();
		afficher(Tab[1+count]);
		count:=count+1;
	jusqua(count==2)
	finrepeter
	alaligne();
	afficher(Tab[0]);

fin
		