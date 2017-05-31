package pda.control;

import java.util.*;
import java.io.*;
import pda.datas.*;

/**
*Classe permettant de jouer en mode terminal
*/
public class JeuTerminal {
//Attributs
	private static JeuDeDame game = new JeuDeDame();

//Methodes
	/**
	*Fenetre pour la taille du damier
	*/
	private static void fenetreTailleDamier() {
		Scanner scan = new Scanner(System.in);
		int nombreCases = 0;

		System.out.println("\n" + "Veuillez choisir une taille pour le game.getDamier():");
		System.out.println("  1 - Grand (12 * 12 cases)");
		System.out.println("  2 - Moyen (10 * 10 cases)");
		System.out.println("  3 - Petit (8 * 8 cases)");

		try {
			nombreCases = scan.nextInt();

			while ((nombreCases != 1) && (nombreCases != 2) && (nombreCases != 3)) {
				System.out.println("\n" + "Taille non correct! Veuillez entrer une taille correcte:");
				scan.nextLine();
				fenetreTailleDamier();
			}
		}
		catch (InputMismatchException ime) {
			System.out.println("\n" + "Taille non correct! Veuillez entrer une taille correcte:");
			scan.nextLine();
			fenetreTailleDamier();
		}

		if (nombreCases == 1) {
			game.configurerTaille(12);
		}
		if (nombreCases == 2) {
			game.configurerTaille(10);
		}
		if (nombreCases == 3) {
			game.configurerTaille(8);
		}

		scan.nextLine();
	}

	/**
	*Fenetre pour parametrer la couleur du joueur
	*/
	private static void fenetreCouleurJoueur() {
		Scanner scan = new Scanner(System.in);
		int couleurPieces = 0;

		System.out.println("\n" + "Veuillez saisir la couleur desiree de vos pieces:");
		System.out.println("  1 - Blanches");
		System.out.println("  2 - Noires");

		try {
			couleurPieces = scan.nextInt();

			while ((couleurPieces != 1) && (couleurPieces != 2)) {
				System.out.println("\n" + "Veuillez saisir une couleur valide:");
				scan.nextLine();
				fenetreCouleurJoueur();
			}
		}
		catch (InputMismatchException ime) {
			System.out.println("\n" + "Couleur non correct! Veuillez entrer une couleur correcte:");
			scan.nextLine();
			fenetreCouleurJoueur();
		}

		game.configurerCouleurJetonsHumain(couleurPieces);
		scan.nextLine();
	}

	/**
	*Methode pour pouvoir configurer les options
	*/
	private static void fenetreOptions() {
		fenetreTailleDamier();
		fenetreCouleurJoueur();

		System.out.println("\n" + "Nous allons vous retourner a la fenetre d'acceuil.");
		fenetreAcceuil();
	}


	/**
	*Methode pour l'acceuil
	*/
	private static void fenetreAcceuil() {
		Scanner scan = new Scanner(System.in);
		int choix = 0;

		System.out.println("## Bienvenue sur la page d'Acceuil ##");
		System.out.println("");
		System.out.println("Veuillez choisir le chiffre correspondant a votre choix:");
		System.out.println("  1 - Nouvelle Partie");
		System.out.println("  2 - Charger Partie");
		System.out.println("  3 - Options");
		System.out.println("  4 - Quitter");

		try {
			choix = scan.nextInt();

			while ((choix != 1) && (choix != 2) && (choix != 3) && (choix != 4)) {
				scan.nextLine();
				System.out.println("\n" + "Choix non valide. Veuillez reessayer:");
				choix = scan.nextInt();
			}
		}
		catch (InputMismatchException ime) {
			System.out.println("\n" + "Choix non valide. Veuillez reessayer:");
			scan.nextLine();
			fenetreAcceuil();
		}

		if (choix == 1) {
			fenetreNouvellePartie();
		}
		if(choix == 2) {
			fenetreChargerPartie();
		}
		if (choix == 3) {
			fenetreOptions();
		}
		if (choix == 4) {
			fenetreQuitter();
		}
	}

	/**
	*Methode pour la fenetre de sortie
	*/
	private static void fenetreQuitter() {
		Scanner scan = new Scanner(System.in);
		int choix = 0;

		System.out.println("\n" + "Voulez vous vraiment quitter?");
		System.out.println("  1 - Oui");
		System.out.println("  2 - Non");

		try {
			choix = scan.nextInt();

			while ((choix != 1) && (choix != 2)) {
				System.out.println("\n" + "Choix non valide. Veuillez reessayer:");
				scan.nextLine();
				fenetreQuitter();
			}
		}
		catch (InputMismatchException ime) {
			System.out.println("\n" + "Choix non valide. Veuillez reessayer:");
			scan.nextLine();
			fenetreQuitter();
		}

		if (choix == 1) {
			System.out.println("\n" + "Merci d'avoir joue a notre jeux." + "\n" + "Au revoir!");
			System.exit(0);
		}
		if (choix == 2) {
			fenetreAcceuil();
		}
	}

	/**
	*Fenetre pour charger la Partie
	*/
	private static void fenetreChargerPartie() {
		JeuDeDame temp;

		try {
			temp = game.chargerPartie();
			game = temp;
			System.out.println("Chargement effectuee");
		}
		catch (FileNotFoundException e) {
			System.out.println("Fichier pour le chargement non trouve!");
			System.out.println("\n" + "Nous allons vous ramener a l'acceuil.");
			fenetreAcceuil();
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("Classe pour le chargement non trouve!");
			System.out.println("\n" + "Nous allons vous ramener a l'acceuil.");
			fenetreAcceuil();
		}
		catch (IOException ioe) {
			System.out.println("Probleme d'entree sortie!");
			System.out.println("\n" + "Nous allons vous ramener a l'acceuil.");
			fenetreAcceuil();
		}
	}

	/**
	*Fenetre pour une nouvelle partie
	*/
	private static void fenetreNouvellePartie() {
		System.out.println("\n"+ "## Nouvelle Partie ##");

		//Creation de la partie
		game.creerNouvellePartie();

		//Tant que la partie est en cours
		while (!game.getPartieCourante().isFini()) {
			game.getDamier().toString();
			fenetreChoix();
		}

		//Affichage fenetre de fin
		fenetreFinDePartie();
	}

	/**
	*Fenetre de la fenetre pour bouger une piece
	*/
	private static void fenetreBougerPiece() {
		fenetreChoixPiece();
		fenetreChoixDeplacement();

		if (!(game.getPartieCourante().isFini())) {
			fenetreIA();
		}

		if (game.getPartieCourante().isFini()) {
			fenetreFinDePartie();
		}
	}

	/**
	*Fenetre pour le tour de l'IA
	*/
	private static void fenetreIA() {
		System.out.println("\n" + "Tour de l'IA:");
		System.out.println("Chargement ...");

		if (game.getPartieCourante().tourIA()) {
			System.out.println("L'IA a joue le coup suivant:");
			System.out.println(game.getPartieCourante().getCoupCourant().toString());
		}
	}

	/**
	*Fenetre pour le choix de la piece a bougee
	*/
	private static void fenetreChoixPiece() {
		Scanner scan = new Scanner(System.in);
		int x = 0;
		int y = 0;

		//Selection de la piece a jouer
		System.out.println("Veuillez donner les coordonnees de la piece a bouger:");
		try {
			x = scan.nextInt();
			x = x - 1;

			while ((x < 0) || (x >= game.getTaille())) {
				System.out.println("Coordonnee horizontale non valide, veuillez reessayer:");
				scan.nextLine();
				x = scan.nextInt();
				x = x - 1;
			}

			scan.nextLine();

			y = scan.nextInt();
			y = y - 1;

			while ((y < 0) || (y >= game.getTaille())) {
				System.out.println("Coordonnee verticale non valide, veuillez reessayer:");
				scan.nextLine();
				y = scan.nextInt();
				y = y - 1;
			}
		}
		catch (InputMismatchException ime) {
			System.out.println("Coordonnees non valides, veuillez reessayer:");
			fenetreChoixPiece();
		}

		if (game.getDamier().setCurrent(game.getDamier().getPiece(x, y))) {
			System.out.println("Case selectionnee: " + game.getDamier().getCurrent().toString());
			game.getDamier().afficheCasesPossibles(game.getDamier().getCurrent());
		}
		else {
			System.out.println("Coordonnees non valides, veuillez reessayer:");
			fenetreChoixPiece();
		}
	}

	/**
	*Fenetre choix du deplacement
	*/
	private static void fenetreChoixDeplacement() {
		Scanner scan2 = new Scanner(System.in);
		int i = 0;
		int j = 0;

		//Selection de la case ou la deplacee
		System.out.println("\n" + "Veuillez donner les coordonnees de la case ou la placee:");
		try {
			i = scan2.nextInt();
			i = i - 1;

			while ((i < 0) || (i >= game.getTaille())) {
				System.out.println("Coordonnee non valide, veuillez reessayer:");
				scan2.nextLine();
				i = scan2.nextInt();
				i = i - 1;
			}
		}
		catch (InputMismatchException ime) {
			System.out.println("Coordonnee non valide, veuillez reessayer:");
			fenetreChoixDeplacement();
		}

		scan2.nextLine();

		try {
			j = scan2.nextInt();
			j = j - 1;

			while ((j < 0) || (j >= game.getTaille())) {
				System.out.println("Coordonnee non valide, veuillez reessayer:");
				scan2.nextLine();
				j = scan2.nextInt();
				j = j - 1;
			}
		}
		catch (InputMismatchException ime) {
			System.out.println("Coordonnee non valide, veuillez reessayer:");
			fenetreChoixDeplacement();
		}

		if (game.getPartieCourante().jouerUnTour(game.getDamier().getCurrent(), game.getDamier().getPiece(i, j))) {
			System.out.println(game.getDamier().getCurrent().toString() + " deplacee en " + "[" + (i + 1) + "," + (j + 1) + "].");
		}
		else {
			System.out.println("Deplacement impossible! Entrez une nouvelle coordonnee parmis celles proposees:");
			game.getDamier().afficheCasesPossibles(game.getDamier().getCurrent());
			fenetreChoixDeplacement();
		}
	}

	/**
	*Fenetre pour la sauvegarde
	*/
	private static void fenetreSauvegarder() {
		try {
			game.sauvegarderPartie();
			fenetreChoix();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("ERREUR: Probleme lors de la sauvegarde!");
			fenetreChoix();
		}
		catch (IOException ioe) {
			System.out.println("ERREUR: Probleme lors de la sauvegarde!");
			fenetreChoix();
		}
	}

	/**
	*Fenetre pour la fin de partie
	*/
	private static void fenetreFinDePartie() {
		//Si le gagnant est l'humain
		if (game.getPartieCourante().getScoreOrdi() == 0) {
			System.out.println("Felicitation vous avez gagne!");
			System.out.println("Et il vous restait " + game.getPartieCourante().getScoreHumain() + " pieces sur le plateau! Bien joue!");
		}

		//Si le gagnant est l'ordi
		if (game.getPartieCourante().getScoreHumain() == 0) {
			System.out.println("L'ordinateur vous a malheureusement battu! Il faut croire que l'IA vous a surpasse!");
			System.out.println("Et il ne lui restait que " + game.getPartieCourante().getScoreOrdi() + " pieces sur le plateau!" + "\n" + "Vous ferez mieux la prochaine fois!");
		}

		//Affichage de la fenetre de sortie
		fenetreSortie();
	}

	/**
	*Fenetre choix de l'action dans la partie
	*/
	private static void fenetreChoix() {
		Scanner scan = new Scanner(System.in);
		int choix = 0;

		System.out.println("Plateau actuel:" + "\n" + game.getDamier().toString());
		System.out.println("Que voulez vous faire?");
		System.out.println("  1 - Bouger une piece");
		System.out.println("  2 - Sauvegarder");
		System.out.println("  3 - Retourner a l'acceuil");

		try {
			choix = scan.nextInt();

			while ((choix != 1) && (choix != 2) && (choix != 3)) {
				scan.nextLine();
				System.out.println("\n" + "Choix non valide. Veuillez reessayer:");
				choix = scan.nextInt();
			}
		}
		catch (InputMismatchException ime) {
			System.out.println("\n" + "Choix non valide. Veuillez reessayer:");
			scan.nextLine();
			fenetreChoix();
		}

		if (choix == 1) {
			fenetreBougerPiece();
		}
		if(choix == 2) {
			fenetreSauvegarder();
		}
		if (choix == 3) {
			Scanner scan2 = new Scanner(System.in);
			int choix2 = 0;

			System.out.println("\n" + "Voulez vous vraiment quitter?");
			System.out.println("  1 - Oui");
			System.out.println("  2 - Non");

			try {
				choix2 = scan2.nextInt();

				while ((choix2 != 1) && (choix2 != 2)) {
					System.out.println("\n" + "Choix non valide. Veuillez reessayer:");
					scan2.nextLine();
					choix2 = scan2.nextInt();
				}
			}
			catch (InputMismatchException ime) {
				System.out.println("\n" + "Choix non valide. Veuillez reessayer:");
				scan2.nextLine();
				fenetreChoix();
			}

			if (choix2 == 1) {
				fenetreAcceuil();
			}
			if (choix2 == 2) {
				fenetreChoix();
			}
		}
	}

	/**
	*Fenetre apres la fin de la partie
	*/
	private static void fenetreSortie() {
		System.out.println("Que souhaitez vous faire?");
		System.out.println("  1 - Retourner a l'acceuil");
		System.out.println("  2 - Commencer une nouvelle partie");
		System.out.println("  3 - Quitter");

		Scanner scan = new Scanner(System.in);
		int choix = 0;

		try {
			choix = scan.nextInt();

			while ((choix != 1) && (choix != 2) && (choix != 3)) {
				System.out.println("\n" + "Choix non valide. Veuillez reessayer:");
				scan.nextLine();
				fenetreSortie();
			}
		}
		catch (InputMismatchException ime) {
			System.out.println("\n" + "Choix non valide. Veuillez reessayer:");
			scan.nextLine();
			fenetreSortie();
		}

		if (choix == 1) {
			scan.nextLine();
			fenetreAcceuil();
		}
		if (choix == 2) {
			scan.nextLine();
			fenetreNouvellePartie();
		}
		if (choix == 3) {
			scan.nextLine();
			fenetreQuitter();
		}
	}



	/**
	*Lanceur du jeux en mode terminal
	*/
	public static void main(String[] args) {
		System.out.println("Bienvenue sur le mode terminal du jeux de dame du binome");
		System.out.println("ANDRIAMILANTO Tompoariniaina - C1" + "\n" + "COUVERT Theo - C1" + "\n");
		System.out.println("#Lancement du jeu#");

		//Entree du nom
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez saisir un nom de joueur:");
		String nomJoueur = "";

		try {
			nomJoueur = scan.nextLine();

			while (nomJoueur == "") {
				System.out.println("Nom vide! Veuillez saisir un nom de joueur valide:");
				nomJoueur = scan.nextLine();
			}
		}
		catch (InputMismatchException ime) {
			System.out.println("Nom non compatible! Veuillez saisir un nom de joueur valide:");
		}

		game.setNom(nomJoueur);

		//Affichage de l'acceuil
		fenetreAcceuil();
	}
}
