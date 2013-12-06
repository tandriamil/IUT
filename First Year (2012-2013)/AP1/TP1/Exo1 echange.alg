algo exo1

var
	entier var1, var2, aux;
	
principal

debut
	saisir("var1=", @var1);
	saisir("var2=", @var2);
	aux := var1;
	var1 := var2;
	var2 := aux;
	afficherln("var1 est égal à " + var1);
	afficher("var2 est égal à " + var2);
fin	
