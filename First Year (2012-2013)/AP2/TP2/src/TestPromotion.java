public class TestPromotion {
//Attributs

//Méthodes
    public static void main(String[] args) {

      //Test Constructeur
	//Création d'étudiants
	Etudiant pierre = new Etudiant ("Pierre", 5);
	pierre.initialisation ();
	Etudiant sacha = new Etudiant ("Sacha", 5);
	sacha.initialisation ();

	//Construction du tableau d'étudiant
	Etudiant[] tabEtud = new Etudiant[2];
	tabEtud[0] = pierre;
	tabEtud[1] = sacha;

	//Construction d'une promotion
	Promotion p1 = new Promotion ("Info1", tabEtud);

	//Affichage de la promotion
	System.out.println (p1.enChaine());

	
      //Test accesseurs
	//Test getNom
	System.out.println ("Le nom de la promotion est " + p1.getNom() + ".");
	
	//Test moyenne
	System.out.println ("La moyenne de la promotion est de " + p1.moyenne() + ".");

	//Test moyenneMax
	System.out.println ("La meilleure moyenne est de " + p1.moyenneMax() + ".");

	//Test moyenneMin
	System.out.println ("La moyenne la plus basse est de " + p1.moyenneMin() + ".");

	//Test getMajor
	System.out.println ("Le major de la promo est " + p1.getMajor() + ".");

    }
}