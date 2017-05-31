 algo perimetre

var
	reel pc, gc, perimetre;

principal
debut
	saisir("Entrez la valeur du petit cote:", @pc);
	saisir("Entrez la valeur du grand cote:", @gc);
	perimetre := 2*(pc+gc);
	afficher("Le perimetre est donc egal a " + perimetre);
fin
