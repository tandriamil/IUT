algo Ex4

var
	tableau_de reel Tab [5];
	reel Max , Min;
	entier count:=0 , PosMax:=1 , PosMin:=1;

principal

debut

	saisir("",@Tab [count]);
	Max:=Tab [count];
	Min:=Tab [count];
	count:=count+1;
	repeter
		saisir("",@Tab [count]);
		si(Tab [count]>Max)alors
			Max:=Tab[count];
			PosMax:=count+1;
		finsi
		si(Tab [count]<Min)alors
			Min:=Tab [count];
			PosMin:=count+1;
		finsi
		count:=count+1;
	jusqua(count==4)
	finrepeter
	afficher("maximum "+Max);
	alaligne();
	afficher("minimum"+Min);
	alaligne();
	afficher("position du maximum"+PosMax);
	alaligne();
	afficher("position du minimum"+PosMin);

fin
