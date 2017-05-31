algo exoarendreTD3
#Fonctionne bien, seuls soucis si certaines sont negatives, la moyenne, le minimum et le maximum peuvent etre negatifs.


var
	#Declaration des variables
	entier count, max, min, somme;
	reel moyenne;
	const entier taille := 5;
	chaine nom, prenom;

	#Declaration des tableaux
	tableau_de entier Tabnote [taille];
	tableau_de chaine Tabmatiere[taille];

principal
debut

	#Initialisation
	count := 0;
	somme := 0;

	#SAISIE
	#Saisie nom et prenom
	saisir("Entrez le nom de l'etudiant:", @nom);
	saisir("Entrez le prenom de l'etudiant:", @prenom);


	#Saisie des matieres et notes
	repeter
		saisir("Entrez une matiere:", @Tabmatiere[count]);
		saisir("Entrez une note:", @Tabnote[count]);

		#Les premieres valeurs de min et de max
		si (count == 0) alors
			max := Tabnote[count];
			min := Tabnote[count];
		finsi

		#Saisie du maximum et du minimum
		si (Tabnote[count] >= max) alors
			max := Tabnote[count];
		finsi

		si (Tabnote[count] <= min) alors
			min := Tabnote[count];
		finsi

		#Somme des notes
		somme := Tabnote[count] + somme;

		#Incrementation
		count := count+1;
	jusqua (count == 5)
	finrepeter


	#AFFICHAGE
	afficher("------------------------------------------------------------------------------------------------------------------------");
	alaligne();
	afficher("Nom et prenom:");
	alaligne();

	#Affichage nom et prenom
	afficher(nom + " " + prenom);
	alaligne();
	afficherln("----------------------------------------------------------------------------------------------------------------------");

	#Afficher matieres et notes
	afficher("Matieres et notes:");
	alaligne();
	pour count:=0 a taille-1
		afficher(Tabmatiere[count]);
		afficher(" : ");
		afficher(Tabnote[count]);
		alaligne();
	finpour

	#Afficher moyenne, maximum et minimum
	afficher("-----------------------------------------------------------------------------------------------------------------");
	alaligne();
	afficherln("Le maximum est: " + max + " .");
	afficherln("Le minimum est: " + min + " .");
	moyenne := somme/5;
	afficherln("La moyenne est: " + moyenne + " .");
fin
