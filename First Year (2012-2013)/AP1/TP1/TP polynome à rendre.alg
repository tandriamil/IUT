algo resolutionpolynome

var
	reel a, b, c, delta, x1, x2, y1, y2;
	
principal
debut
	
	#Entree des valeurs
	saisir("Entrez une valeur de a", @a);
	saisir("Entrez une valeur de b", @b);
	saisir("Entrez une valeur de c", @c);
	
	#Cas où b=0 et a=0 ce qui est impossible
	si (b == 0) alors
		
		tantque (a==0)
			afficher("Entrez une valeur positive de a s'il vous plait");
			saisir("Entrez une valeur POSITIVE de a", @a);
		fintantque
			
	finsi
	
	
	#Cas où a=0 et b=/=0, ce qui donne une fonction de degres 1
	si (b<>0) alors
		
		si (a==0) alors
			afficher("Le résultat est donc " + c/b);
		finsi
		
	finsi
	
	
	
	#Cas ou on a un polynome de degres 2
	si (b<>0) alors
		si (a<>0) alors
			
			
			#Calcul de delta
			delta := (b * b) - (4 * a * c)
			
			
			#Cas de D < 0
			
			
			
			#Cas de D = 0
			si (delta == 0) alors
				afficher("Le résultat est " + -b/(2*a);
			finsi
			
			
			#Cas de D > 0
			
		finsi
	finsi
	
fin