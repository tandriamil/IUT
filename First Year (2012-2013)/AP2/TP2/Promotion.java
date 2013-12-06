public class Promotion {

//Attributs
    private String nom;
    private Etudiant [] listeEtudiants;


//Constructeur
    public Promotion (String nom, Etudiant liste[]) {
	this.nom = nom;
	this.listeEtudiants = new Etudiant [liste.length];

	for (int i = 0; i < liste.length; i++) {
	    this.listeEtudiants[i] = liste[i];
	}
    }

    
//Accesseurs

    //enChaine
    public String enChaine() {
	String ret;
	
	ret = " ";

	for (int i = 0; i < this.listeEtudiants.length; i++) {

	    ret = ret + this.listeEtudiants[i].enChaine() + "\n" ;
	}

	return ret;
    }


    //getNom
    public String getNom () {
	return this.nom;
    }


    //moyenne
    public double moyenne () {
	double ret;
	
	ret = 0;
	for (int i = 0; i < listeEtudiants.length; i++) {

	    ret = this.listeEtudiants[i].moyenne() + ret;
	}

	ret = ret / this.listeEtudiants.length;
	return ret;
    }


    //moyenneMax
    public double moyenneMax() {
	double ret;
	
	ret = 0;
	for (int i = 0; i < this.listeEtudiants.length; i++) {
	    
	    if (this.listeEtudiants[i].moyenne() > ret) {
		ret = this.listeEtudiants[i].moyenne();
	    }
	}
	return ret;
    }

    
    //moyenneMin
    public double moyenneMin() {
	double ret;
	
	ret = 20;
	for (int i = 0; i < this.listeEtudiants.length; i++) {
	    
	    if (this.listeEtudiants[i].moyenne() < ret) {
		ret = this.listeEtudiants[i].moyenne();
	    }
	}
	return ret;
    }

    
    //getMajor   /!\ A un bug /!\
    public Etudiant getMajor() {
	Etudiant ret;

	ret = this.listeEtudiants[0];
	for (int i = 0; i < this.listeEtudiants.length; i++) {
	    
	    if (this.listeEtudiants[i+1].moyenne() >= this.listeEtudiants[i].moyenne()) {
		    ret = this.listeEtudiants[i+1];
	    }

	}
	return ret;
    }

    
    
}