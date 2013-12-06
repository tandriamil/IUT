algo exo2TD4

var
	const entier taille := 10;
	tableau_de entier Tab [10];
	entier nbelements;

principal
var
	entier a;
	
debut
	afficher(@Tab);
fin

#############################################################
procedure afficheTab (par_ref tableau_de entier Tab)
debut
	pour nbelements=0 à taille-1
		saisir("Entrez un reel:", @a);
		Tab [nbelements] := a;
	finpour
	
	pour nbelements=0 à taille-1
		afficher(Tab [nbelements]);
	finpour
fin