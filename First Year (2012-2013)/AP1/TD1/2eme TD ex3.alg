algo quotientfamilial

var
	entier adulte, enfant, revenu;
	reel QF;

principal
debut
	saisir("Nombre d'adultes:", @adulte);
	saisir("Nombre d'enfants:", @enfant);
	saisir("Revenu total:", @revenu);
	QF := revenu/(adulte+(enfant/2));
	afficher("Le quotient familial est " + QF);
fin