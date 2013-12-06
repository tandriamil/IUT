algo TP5arendre
#Programme fonctionnant. Jeux de tests effectués.

var
	const entier N:=6;
	tableau_de caractere Tableau[N];
	entier i, countmin, countmaj;
	caractere entreemin, entreemaj, sortie;
			
#Programme principal
principal

debut
	
	countmin := 0;
	countmaj := 0;
	
	#Remplissage du tableau
	pour i:=0 à 5
		saisir("Entrez une lettre:", @Tableau[i]);
	finpour
	
	#Affichage du tableau initial
	alaligne();
	afficherln(" ");
	afficherln("Les caractères initiaux:");
	affichertab(@Tableau);
	
	#Lettres a remplaces
	saisir("Quelle lettre en minuscule voulez-vous remplacer?", @entreemin);
	saisir("Quelle lettre en majuscule voulez-vous remplacer?", @entreemaj);
	saisir("Par quelle caractere voulez vous le remplacer?", @sortie);

	#Remplacement des valeurs
	remplace(@Tableau, @countmin, @countmaj);
		
		
	#Affichages des résultats
	alaligne();
	afficherln(" ");
	afficherln("Les caractères modifiés:");
	affichertab(@Tableau);
	
	#Affichage des valeurs
	alaligne();
	afficher(" ");
	alaligne();
	
	si (countmin > 1) alors
		afficher(countmin + " " + entreemin + " minuscules ont été remplacés par " + sortie + " .");
	finsi
	
	si (countmin == 1) alors
		afficher("Un seul " + entreemin + " minuscule a été remplacé par " + sortie + " .");
	finsi
	
	si (countmin == 0) alors
		afficher("Aucun remplacement de " + entreemin + " par " + sortie + " ne sera fait.");
	finsi
	alaligne();
	
	
	si (countmaj > 1) alors
		afficher(countmaj + " " + entreemaj +" majuscules ont été remplacés par " + sortie + " .");
	finsi
	
	si (countmaj == 1) alors
		afficher("Un seul " + entreemaj + " majuscule a été remplacé par " + sortie + " .");
	finsi
	
	si (countmaj == 0) alors
		afficher("Aucun remplacement de " + entreemaj + " par " + sortie + " ne sera fait.");
	finsi
	
	afficherln(" ");
		
fin


##########################################################

procedure remplace (par_ref tableau_de caractere Tableau, par_ref entier countmin, par_ref entier countmaj)

debut
	
	pour i:=0 à 5
	
		si (Tableau[i] == entreemaj) alors
			Tableau[i] := sortie;
			countmaj := countmaj + 1;
		finsi
		
		si (Tableau[i] == entreemin) alors
			Tableau[i] := sortie;
			countmin := countmin+1;
		finsi
		
	finpour
	
fin


###############################################
#Affichage du tableau
procedure affichertab (par_ref tableau_de caractere Tableau)

var
	entier i;
	
debut
	
	pour i:=0 à 5
		afficher(Tableau[i] + " ");
	finpour

fin