algo exo1

var
	reel var1, var2, var3, h1;
	entier sec, r1, r2, r3, h, m ,s;

principal

debut
	saisir ( "Entrez un temps en secondes ", @sec ) ;
	r1 := modulo( sec, 3600 );
	h1 := sec / 3600;
	h := arrondi(h1);
	r2 := modulo(r1 , 60);
	r3 := modulo(r2 , 60);



	afficherln(r1);
	afficherln(h);

fin
