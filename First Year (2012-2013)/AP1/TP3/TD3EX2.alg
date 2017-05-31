algo Ex2

var
	tableau_de reel Tab[10];
	entier count:=0 , fixe;

principal

debut

	repeter
		saisir("",@Tab[count]);
		count:=count+1;
	jusqua((count==9) ou (Tab[count-1]==-1))
	finrepeter

	fixe:=count;
	repeter
		afficher(Tab[fixe-count]);
		alaligne();
		count:=count-1;
	jusqua(count==0)
	finrepeter

fin
