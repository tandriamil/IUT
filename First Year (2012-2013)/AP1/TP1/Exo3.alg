algo exo1

var
	entier var1, var2, var3, som;
	reel resultat;
	
principal

debut
	saisir("var1=", @var1);
	saisir("var2=", @var2);
	saisir("var3=", @var3);
	
	som := (var1 + var2 + var3);
	resultat := ( som / 3 );
		
	
	afficherln("La somme est égale à " + som);
	afficherln("La moyenne est de " + resultat);
fin	
