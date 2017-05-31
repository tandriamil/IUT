class Etudiant {
    //Attributs
    String nom;
    double notes[];

    //Méthodes
    //Constructeur
    Etudiant (String a, int n) {
	this.nom = a;
	this.notes = new double [n]; //0 dans chaques cases pour l'instant!
    }

    //Méthodes get et set
    String getNom() {
	return this.nom;
    }

    int getNbNotes() {
	int retour;
	retour = this.notes.length; //Accède à la longueur du tableau
	return retour;
    }

    double getUneNote (int i) {
	double a;
	a = 0;

	if (i >= 0 && i < this.notes.length) {
	a = this.notes[i];
	}

	else {
	    System.out.println ("L'indice est en dehors des bornes du tableau.");
	}

	return a;
    }

    void setNom (String n) {
	this.nom = n;
    }


    //Initialisation
    void initialisation () {
	//Variables locales - Initialisation
	int i;
	double rand;

	//Méthode - Initialisation
	for (i = 0; i < this.notes.length; i++) {
	    rand = Math.random ();
	    this.notes[i] = rand * 20;
	}
    }

    //Moyenne
    double moyenne () {
	//Variables locales - Moyenne
	double totalnote;
	double moyenneretournee;
	int i;
	moyenneretournee = 0;

	//Méthode - Moyenne
	//Addition des notes

	//Vérification tableau vide
	if (this.notes.length != 0)  {
	    totalnote = 0;
	    for (i = 0; i < this.notes.length; i++) {
		totalnote = totalnote + notes[i];
	    }
	    //Division par le total
	    moyenneretournee = totalnote / this.notes.length;
	}

	else {
	    System.out.println ("Tableau vide!");
	}

       //Retour
       return moyenneretournee;
    }


    //Affichage nom + notes
    String enChaine() {
	//Variables locales - enChaine
	int i;
	String ret;

	ret = " ";
	//Méthodes - enChaine
	ret = ret + "Le nom de l'étudiant est " + this.nom + "." + "\n";
	ret = ret + "Les notes de l'étudiant: " + "\n" ;

	for (i = 0; i < this.notes.length; i++) {

	    if (i < this.notes.length - 1) {

		ret = ret + this.notes[i] + " ; " + "\n" ;
	    }
	    else {
		ret = ret + this.notes[i] + " ." + "\n" ;
	    }
	}
	return ret;
    }
}
