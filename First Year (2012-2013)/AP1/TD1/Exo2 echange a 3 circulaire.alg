algo exo1

var
	entier var1, var2, var3, aux;
	
principal

debut
	saisir("var1=", @var1);
	saisir("var2=", @var2);
	saisir("var3=", @var3);
	
	aux := var2;
	var2 := var1;
	var1 := var3;
	var3 := aux; 
	
	
	afficherln("var1 est égal à " + var1);
	afficherln("var2 est égal à " + var2);
	afficher("var3 est égal à " + var3);
fin	
