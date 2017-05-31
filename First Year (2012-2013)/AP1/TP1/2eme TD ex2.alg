algo secondeentemps

var
	reel h,m;
	entier r1, r2, sec;

principal
debut
	saisir("Entrez un temps en secondes:", @sec);
	r1 := modulo(sec, 3600);
	h := (sec-r1)/3600;
	r2 := modulo(r1, 60);
	m := (r2-r1)/60;
	afficher(h + "heures, ");
	afficher(m + "minutes et ");
	afficher(r2 + "secondes.");
fin
