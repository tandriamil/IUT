 algo perimetre

var
	reel pc, gc, perimetre;
	
principal
debut
	saisir("Entrez la valeur du petit côté:", @pc);
	saisir("Entrez la valeur du grand côté:", @gc);
	perimetre := 2*(pc+gc);
	afficher("Le périmètre est donc égal à " + perimetre);
fin