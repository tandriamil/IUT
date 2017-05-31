class TestEtudiant {
    //Attributs

    //Méthodes
    public static void main(String [] toto) {
	//Test Constructeur
	Etudiant pierre = new Etudiant ("Pierre", 5);
	pierre.initialisation ();
	String testnom = pierre.getNom();
	int testtailletableau = pierre.getNbNotes();

	//Test getNom
	if (testnom.equals("Pierre")) {
	    System.out.println ("Test constructeur réussi! Le Nom et getNom fonctionnent.");
	}
	else {
	    System.out.println ("Test constructeur échoué! Le Nom et getNom échouent.");
	}

	//Test getNbNotes
	if (testtailletableau == 5) {
	    System.out.println ("Test constructeur réussi! La taille du tableau et getNbNotes fonctionnent.");
	}
	else {
	    System.out.println ("Test constructeur échoué! La taille du tableau et getNbNotes échouent.");
	}

	//Test setNom
	pierre.setNom("roger");
	System.out.println ("Le nouveau nom de l'étudiant est " + pierre.getNom() + ".");
	if (pierre.getNom().equals("roger")) {
	    System.out.println ("Test de setNom réussit!");
	}
	else {
	    System.out.println ("Test de setNom échoué!");
	}

	//Test getUneNote
	System.out.println ("La 3è note est de " + pierre.getUneNote(2) + " .");
	if (pierre.getUneNote(2) <= 20 && pierre.getUneNote(2) >= 0) {
	    System.out.println ("Test getUneNote réussie!");
	}
	else {
	    System.out.println ("Test getUneNote échoué!");
	}

	//Test Moyenne
	System.out.println ("La moyenne est de " + pierre.moyenne() + " .");
	if (pierre.moyenne() <= 20 && pierre.moyenne() >= 0) {
	    System.out.println ("Test de la moyenne réussie!");
	}
	else {
	    System.out.println ("Test de la moyenne échouée!");
	}

	//Test EnChaine
	System.out.println (pierre.enChaine());
    }
}
